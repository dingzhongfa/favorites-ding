package com.ding.favorites.service.impl;


import com.ding.favorites.service.LookRecordService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by louie on 2017/1/12.
 */
@Service
@Transactional
public class LookRecordServiceImpl implements LookRecordService {
    public Logger logger = LoggerFactory.getLogger(LookRecordServiceImpl.class);

    @Autowired
    private LookRecordRepository lookRecordRepository;

    @Autowired
    private PraiseRepository praiseRepository;

    @Autowired
    private CommentRepository commentRepository;

    @Autowired
    private CollectService collectService;




    @Override
    public void saveLookRecord(Long userId,Long collectId) {
        Integer count = lookRecordRepository.countByUserIdAndCollectId(userId,collectId);
        if (count > 0){
            lookRecordRepository.updatelastModifyTime(userId,collectId, DateUtils.getCurrentTime());
        }else {
            LookRecord lookRecord = new LookRecord();
            lookRecord.setUserId(userId);
            lookRecord.setCollectId(collectId);
            lookRecord.setCreateTime(DateUtils.getCurrentTime());
            lookRecord.setLastModifyTime(DateUtils.getCurrentTime());
            lookRecordRepository.save(lookRecord);
        }

    }

    @Override
    public List<CollectSummary> getLookRecords(Long userId, Pageable pageable) {
        Page<CollectView> views = null;

        views = lookRecordRepository.findViewByUserId(userId, pageable);

        return convertCollect(views,userId);
    }

    /**
     * @author neo
     * @date 2016年8月11日
     * @param collects
     * @return
     */
    private List<CollectSummary> convertCollect(Page<CollectView> views,Long userId) {
        List<CollectSummary> summarys=new ArrayList<CollectSummary>();
        for (CollectView view : views) {
            CollectSummary summary=new CollectSummary(view);
            summary.setPraiseCount(praiseRepository.countByCollectId(view.getId()));
            summary.setCommentCount(commentRepository.countByCollectId(view.getId()));
            Praise praise=praiseRepository.findByUserIdAndCollectId(userId, view.getId());
            if(praise!=null){
                summary.setPraise(true);
            }else{
                summary.setPraise(false);
            }
            summary.setCollectTime(DateUtils.getTimeFormatText(view.getCreateTime()));
            summarys.add(summary);
        }
        return summarys;
    }


}
