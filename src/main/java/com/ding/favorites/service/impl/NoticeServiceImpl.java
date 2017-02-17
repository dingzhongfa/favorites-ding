package com.ding.favorites.service.impl;


import com.ding.favorites.dao.CommentMapper;
import com.ding.favorites.dao.NoticeMapper;
import com.ding.favorites.dao.PraiseMapper;
import com.ding.favorites.dao.UserMapper;
import com.ding.favorites.domain.Notice;
import com.ding.favorites.domain.enums.NoticeType;
import com.ding.favorites.domain.view.CollectSummary;
import com.ding.favorites.service.NoticeService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class NoticeServiceImpl implements NoticeService {

	public Logger logger = LoggerFactory.getLogger(NoticeServiceImpl.class);
	
	@Autowired
	private NoticeMapper noticeMapper;
	@Autowired
	private CommentMapper commentMapper;
	@Autowired
	private PraiseMapper praiseMapper;
	@Autowired
	private UserMapper userMapper;
	
	/**
	 * 保存消息通知
	 * @param collectId
	 * @param type
	 * @param userId
	 * @param operId
	 */
	@Override
	public void saveNotice(String collectId, NoticeType type, String userId, String operId){
		Notice notice = new Notice();
		notice.setCollectId(collectId);
		notice.setReaded((byte)1);
		notice.setType(type);
		if(StringUtils.isNotBlank(operId)){
			notice.setOperId(operId);
		}
		notice.setUserId(userId);
		notice.setCreateTime(new Date());
		noticeMapper.insert(notice);
	}

	/**
	 * 展示消息通知
	 * @param type
	 * @param userId
	 * @param pageInfo
	 */
	@Override
	public List<CollectSummary> getNoticeCollects(NoticeType type, String userId, PageInfo pageInfo){

		Notice notice = new Notice();
		notice.setType(type);
		notice.setUserId(userId);
		PageHelper.startPage(pageInfo.getPageNum(),pageInfo.getPageSize());
		List<CollectSummary> summaries = new ArrayList<>();
		return summaries;
		// TODO Auto-generated method stub
//		Page<CollectView> views = noticeMapper.findViewByUserIdAndType(userId, type, pageable);
//		return convertCollect(views, type);
	}

	/*private List<CollectSummary> convertCollect(Page<CollectView> views, String type) {
		List<CollectSummary> summarys=new ArrayList<CollectSummary>();
		for (CollectView view : views) {
			CollectSummary summary=new CollectSummary(view);
			if("at".equals(type)){
				summary.setCollectTime(DateUtils.getTimeFormatText(view.getLastModifyTime())+" at了你");
			}else if("comment".equals(type)){
				CommentView comment = commentRepository.findReplyUser(Long.valueOf(view.getOperId()));
				if(comment == null){
					continue;
				}
				summary.setUserId(comment.getUserId());
				summary.setUserName(comment.getUserName());
				summary.setProfilePicture(comment.getProfilePicture());
				if(comment.getReplyUserId() != null && comment.getReplyUserId() != 0L){
					User replyUser = userRepository.findOne(comment.getReplyUserId());
				    summary.setRemark("回复@"+replyUser.getUserName()+": "+comment.getContent());
				}else{
					summary.setRemark(comment.getContent());
				}
				summary.setCollectTime(DateUtils.getTimeFormatText(comment.getCreateTime()));
			}else if("praise".equals(type)){
				CommentView comment = praiseRepository.findPraiseUser(Long.valueOf(view.getOperId()));
				if(comment == null){
					continue;
				}
				summary.setUserId(comment.getUserId());
				summary.setUserName(comment.getUserName());
				summary.setProfilePicture(comment.getProfilePicture());
				summary.setCollectTime(DateUtils.getTimeFormatText(comment.getCreateTime())+" 赞了你的收藏");
			}		
			summarys.add(summary);
		}*/
		/*return summarys;
	}*/
}
