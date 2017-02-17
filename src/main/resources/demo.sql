/*
Navicat MySQL Data Transfer

Source Server         : local
Source Server Version : 50537
Source Host           : localhost:3306
Source Database       : favorites

Target Server Type    : MYSQL
Target Server Version : 50537
File Encoding         : 65001

Date: 2017-02-16 15:02:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for collection
-- ----------------------------
DROP TABLE IF EXISTS `collection`;
CREATE TABLE `collection` (
  `id` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '收藏id',
  `userId` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '用户id',
  `favoritesId` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '收藏夹id',
  `url` varchar(60) COLLATE utf8_bin NOT NULL COMMENT 'url地址',
  `title` varchar(60) COLLATE utf8_bin DEFAULT NULL COMMENT '主题',
  `description` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '描述',
  `logoUrl` varchar(60) COLLATE utf8_bin DEFAULT NULL COMMENT '收藏logo的url',
  `charset` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '编码类型',
  `type` enum('') COLLATE utf8_bin DEFAULT NULL COMMENT '权限',
  `remark` varchar(60) COLLATE utf8_bin DEFAULT NULL COMMENT '备注',
  `isDelet` enum('') COLLATE utf8_bin DEFAULT NULL COMMENT '是否删除',
  `createTime` datetime DEFAULT NULL COMMENT '收藏日期',
  `lastModifyTime` datetime DEFAULT NULL COMMENT '最后修改时间',
  `category` varchar(10) COLLATE utf8_bin DEFAULT NULL COMMENT '收藏夹名',
  `newFavorites` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '??',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='收藏表';

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '评论id',
  `collectId` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '收藏id',
  `content` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '内容',
  `userId` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '被评论用户',
  `replyUserId` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '评论用户',
  `commentTime` datetime DEFAULT NULL COMMENT '评论时间',
  `userName` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '被评论用户名字',
  `replyUserName` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '评论用户名字',
  `profilePicture` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '??',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='评论表';

-- ----------------------------
-- Table structure for favorites
-- ----------------------------
DROP TABLE IF EXISTS `favorites`;
CREATE TABLE `favorites` (
  `id` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '收藏夹id',
  `userId` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '用户id',
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '收藏夹名',
  `count` bigint(20) DEFAULT NULL COMMENT '数量',
  `createTime` datetime DEFAULT NULL COMMENT '创建日期',
  `lastModifyTime` datetime DEFAULT NULL COMMENT '最后修改时间',
  `publicCount` bigint(20) DEFAULT NULL COMMENT '公开数量',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='收藏夹表';

-- ----------------------------
-- Table structure for follow
-- ----------------------------
DROP TABLE IF EXISTS `follow`;
CREATE TABLE `follow` (
  `id` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '评论id',
  `userId` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '用户id',
  `followId` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '粉丝id',
  `status` enum('') COLLATE utf8_bin DEFAULT NULL COMMENT '状态',
  `createTime` datetime DEFAULT NULL COMMENT '创建日期',
  `lastModifyTime` datetime DEFAULT NULL COMMENT '最后修改日期',
  `name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '粉丝名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='粉丝关联表';

-- ----------------------------
-- Table structure for notice
-- ----------------------------
DROP TABLE IF EXISTS `notice`;
CREATE TABLE `notice` (
  `id` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '消息id',
  `userId` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '用户id',
  `collectId` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '收藏夹id',
  `type` enum('') COLLATE utf8_bin DEFAULT NULL COMMENT '类型',
  `operId` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '消息源用户',
  `readed` tinyint(4) DEFAULT NULL COMMENT '是否已读，0-已读，1-未读',
  `createTime` datetime DEFAULT NULL COMMENT '消息时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='消息表';

-- ----------------------------
-- Table structure for praise
-- ----------------------------
DROP TABLE IF EXISTS `praise`;
CREATE TABLE `praise` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `collectId` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '收藏id',
  `userId` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '用户id',
  `createTime` datetime DEFAULT NULL COMMENT '点赞时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='点赞表';

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` varchar(20) COLLATE utf8_bin NOT NULL DEFAULT '' COMMENT '用户id',
  `userName` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '用户名',
  `password` varchar(20) COLLATE utf8_bin NOT NULL COMMENT '密码',
  `email` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '邮箱',
  `profilePicture` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '头像url',
  `introduction` varchar(30) COLLATE utf8_bin DEFAULT NULL COMMENT '用户介绍',
  `createTime` datetime DEFAULT NULL COMMENT '注册日期',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_bin COMMENT='用户表';
