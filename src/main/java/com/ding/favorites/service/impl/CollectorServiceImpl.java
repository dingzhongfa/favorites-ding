package com.ding.favorites.service.impl;


import com.ding.favorites.dao.CollectionMapper;
import com.ding.favorites.service.CollectorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @Description: 获取收藏家
 * @Auth: yuyang
 * @Date: 2017/1/19 14:14
 * @Version: 1.0
 **/
@Service
@Transactional
public class CollectorServiceImpl implements CollectorService {

    public Logger logger = LoggerFactory.getLogger(CollectorServiceImpl.class);

    @Autowired
    private CollectionMapper collectionMapper;


    /**
     * 获取收藏家
     * @return
     */
    @Override
    public IndexCollectorView getCollectors() {
        IndexCollectorView indexCollectorView = new IndexCollectorView();
        Long mostCollectUser = collectorRepository.getMostCollectUser();
        indexCollectorView.setMostCollectUser(mostCollectUser);
        Long mostFollowedUser = collectorRepository.getMostFollowedUser(mostCollectUser);
        indexCollectorView.setMostFollowedUser(mostFollowedUser);
        String notUserIds = mostCollectUser+","+mostFollowedUser;
        Long mostPraisedUser = collectorRepository.getMostPraisedUser(notUserIds);
        indexCollectorView.setMostPraisedUser(mostPraisedUser);
        notUserIds += ","+mostPraisedUser;
        Long mostCommentedUser = collectorRepository.getMostCommentedUser(notUserIds);
        indexCollectorView.setMostCommentedUser(mostCommentedUser);
        notUserIds += ","+ mostCommentedUser;
        Long mostPopularUser = collectorRepository.getMostPopularUser(notUserIds);
        indexCollectorView.setMostPopularUser(mostPopularUser);
        notUserIds += ","+ mostPopularUser;
        Long mostActiveUser = collectorRepository.getMostActiveUser(notUserIds);
        indexCollectorView.setMostActiveUser(mostActiveUser);
        return indexCollectorView;
    }
}
