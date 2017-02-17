package com.ding.favorites.service.impl;


import com.ding.favorites.service.LookAroundService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import javax.persistence.PersistenceUnit;

import java.util.ArrayList;
import java.util.List;

/**
 * 随便看看ServiceImpl
 * Created by chenzhimin on 2017/1/4.
 */
@Service
@Transactional
public class LookAroundServiceImpl implements LookAroundService {

    public Logger logger = LoggerFactory.getLogger(LookAroundServiceImpl.class);

    @Autowired
    private CollectRepository collectRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private PraiseRepository praiseRepository;

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Override
    public List<CollectSummary> scrollFiveCollect() {
          EntityManager em = emf.createEntityManager();
          //定义SQL
          String sql = "SELECT " +
                  "c1.id as id,c1.title as title,c1.url as url,c1.logo_url as logoUrl, " +
                  "c1.user_id as userId,u.profile_picture as profilePicture,u.user_name as userName " +
                  "FROM collect AS c1,user u " +
                  "JOIN (SELECT ROUND(RAND() * (SELECT MAX(id) FROM collect)) AS cid) AS c2 " +
                  "WHERE c1.user_id = u.id AND c1.id >= c2.cid " +
                  "AND c1.is_delete = 'NO' " +
                  "ORDER BY c1.id ASC LIMIT 5";
          //创建原生SQL查询QUERY实例
          Query query =  em.createNativeQuery(sql);
          //执行查询，返回的是对象数组(Object[])列表,
          //每一个对象数组存的是相应的实体属性
          List objecArraytList = query.getResultList();
          em.close();
          return convert(objecArraytList);
    }

    @Override
    public List<UserIsFollow> queryFiveUser(Long userId) {
        EntityManager em = emf.createEntityManager();
        String userIdsql = null;
        String noUserIdsql = null;
        if(userId != null && userId > 0){
            userIdsql = "SELECT " +
                    "a.id AS id, " +
                    "a.user_name AS userName, " +
                    "a.profile_picture AS profilePicture, " +
                    "COUNT(user_id) AS num " +
                    "FROM user a " +
                    "INNER JOIN collect b ON b.user_id = a.id " +
                    "GROUP BY b.user_id " +
                    "ORDER BY num DESC LIMIT 5";
        }else{
            noUserIdsql = "SELECT " +
                    "a.id AS id, " +
                    "a.user_name AS userName, " +
                    "a.profile_picture AS profilePicture, " +
                    "COUNT(user_id) AS num, " +
                    "(SELECT STATUS FROM follow WHERE follow_id = a.id AND user_id = 10) AS isFollow " +
                    "FROM user a " +
                    "INNER JOIN collect b ON b.user_id = a.id " +
                    "GROUP BY b.user_id " +
                    "ORDER BY num DESC LIMIT 5";
        }
        //创建原生SQL查询QUERY实例
        Query query =  em.createNativeQuery(userId != null && userId > 0 ? userIdsql : noUserIdsql);
        //执行查询，返回的是对象数组(Object[])列表,
        //每一个对象数组存的是相应的实体属性
        List objecArraytList = query.getResultList();
        em.close();
        List<UserIsFollow> lists = new ArrayList<UserIsFollow>();
        for (int i = 0; i < objecArraytList.size(); i++) {
            UserIsFollow u = new UserIsFollow();
            Object[] obj = (Object[])objecArraytList.get(i);
            u.setId(Long.parseLong(obj[0].toString()));
            u.setUserName(obj[1] == null ? "" : obj[1].toString());
            u.setProfilePicture(obj[2] == null ? "" : obj[2].toString());
            if(userId != null && userId > 0) {
                u.setIsFollow(obj[3] == null ? "" : obj[3].toString());
            }else{
                u.setIsFollow("");
            }
            lists.add(u);
        }
        return lists;
    }

    @Override
    public List<CollectSummary> queryCollectExplore(Pageable pageable,Long userId,String category) {
        Page<CollectView> views = null;
        if(category != null && !"".equals(category) && !"ALL".equals(category)) {
            views = collectRepository.findExploreViewByCategory(category,pageable);
        }else{
            views = collectRepository.findExploreViewByType(pageable);
        }
        List<CollectSummary> summarys = new ArrayList<CollectSummary>();
        for (CollectView view : views) {
            CollectSummary summary=new CollectSummary(view);
            summary.setPraiseCount(praiseRepository.countByCollectId(view.getId()));
            summary.setCommentCount(commentRepository.countByCollectId(view.getId()));
            Praise praise=praiseRepository.findByUserIdAndCollectId(userId, view.getId());
            if (praise != null) {
                summary.setPraise(true);
            } else {
                summary.setPraise(false);
            }
            summary.setCollectTime(DateUtils.getTimeFormatText(view.getCreateTime()));
            summarys.add(summary);
        }
        return summarys;
    }


    private List<CollectSummary> convert(List objecArraytList) {
        /**
         * c1.id,c1.title,c1.url,c1.logo_url, " +
         "u.id,u.profile_picture,u.user_name
         */
        List<CollectSummary> lists = new ArrayList<CollectSummary>();
        for (int i = 0; i < objecArraytList.size(); i++) {
            CollectSummary entity = new CollectSummary();
            Object[] obj = (Object[]) objecArraytList.get(i);
            entity.setId(Long.parseLong(obj[0].toString()));
            entity.setTitle(obj[1] == null ? "" : obj[1].toString());
            entity.setUrl(obj[2] == null ? "" : obj[2].toString());
            entity.setLogoUrl(obj[3] == null ? "" : obj[3].toString());
            entity.setUserId(Long.parseLong(obj[4] == null ? "" : obj[4].toString()));
            entity.setProfilePicture(obj[5] == null ? "" : obj[5].toString());
            entity.setUserName(obj[6] == null ? "" : obj[6].toString());
            lists.add(entity);
        }
        return lists;
    }
}