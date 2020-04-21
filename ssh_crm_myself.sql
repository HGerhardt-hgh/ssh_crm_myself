/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 80019
Source Host           : localhost:3306
Source Database       : ssh_crm_myself

Target Server Type    : MYSQL
Target Server Version : 80019
File Encoding         : 65001

Date: 2020-04-21 15:34:30
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_customer
-- ----------------------------
DROP TABLE IF EXISTS `t_customer`;
CREATE TABLE `t_customer` (
  `custid` int NOT NULL AUTO_INCREMENT,
  `custName` varchar(255) COLLATE utf8mb4_0900_bin DEFAULT NULL,
  `custSource` varchar(255) COLLATE utf8mb4_0900_bin DEFAULT NULL,
  `custLinkman` varchar(255) COLLATE utf8mb4_0900_bin DEFAULT NULL,
  `custPhone` int DEFAULT NULL,
  `custMobile` int DEFAULT NULL,
  `custAddress` varchar(255) COLLATE utf8mb4_0900_bin DEFAULT NULL,
  `custZip` varchar(255) COLLATE utf8mb4_0900_bin DEFAULT NULL,
  `custFax` varchar(255) COLLATE utf8mb4_0900_bin DEFAULT NULL,
  `custWebsite` varchar(255) COLLATE utf8mb4_0900_bin DEFAULT NULL,
  `custLevel` varchar(255) COLLATE utf8mb4_0900_bin DEFAULT NULL,
  PRIMARY KEY (`custid`),
  KEY `FKo6oqtbbjmu6890to85xbpymcd` (`custLevel`),
  CONSTRAINT `FKo6oqtbbjmu6890to85xbpymcd` FOREIGN KEY (`custLevel`) REFERENCES `t_dict` (`did`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin;

-- ----------------------------
-- Records of t_customer
-- ----------------------------
INSERT INTO `t_customer` VALUES ('1', '客户1', '1', '1', '1', '1', '1', '1', '1', '1', '4028848171538ad3017153901c970001');
INSERT INTO `t_customer` VALUES ('2', '客户2', '2', '2', '2', '2', '2', '2', '2', '2', '4028848171538ad3017153901c970001');
INSERT INTO `t_customer` VALUES ('3', '客户3', '3', '3', '3', '3', '3', '3', '3', '3', '4028848171538ad3017153901c970001');

-- ----------------------------
-- Table structure for t_dict
-- ----------------------------
DROP TABLE IF EXISTS `t_dict`;
CREATE TABLE `t_dict` (
  `did` varchar(255) COLLATE utf8mb4_0900_bin NOT NULL,
  `dname` varchar(255) COLLATE utf8mb4_0900_bin DEFAULT NULL,
  PRIMARY KEY (`did`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin;

-- ----------------------------
-- Records of t_dict
-- ----------------------------
INSERT INTO `t_dict` VALUES ('4028848171538ad3017153901c970001', 'vip');
INSERT INTO `t_dict` VALUES ('4028848171538ad301715390391d0002', '普通');
INSERT INTO `t_dict` VALUES ('4028848171538ad3017153904eb70003', 'super');
INSERT INTO `t_dict` VALUES ('4028848171538ad30171539071570004', '大师');

-- ----------------------------
-- Table structure for t_linkman
-- ----------------------------
DROP TABLE IF EXISTS `t_linkman`;
CREATE TABLE `t_linkman` (
  `lkmId` int NOT NULL AUTO_INCREMENT,
  `lkmName` varchar(255) COLLATE utf8mb4_0900_bin DEFAULT NULL,
  `lkmGender` varchar(255) COLLATE utf8mb4_0900_bin DEFAULT NULL,
  `lkmPhone` int DEFAULT NULL,
  `lkmMobile` int DEFAULT NULL,
  `custid` int DEFAULT NULL,
  PRIMARY KEY (`lkmId`),
  KEY `FKpviaf2n560mr992y8njkaaxh8` (`custid`),
  CONSTRAINT `FKpviaf2n560mr992y8njkaaxh8` FOREIGN KEY (`custid`) REFERENCES `t_customer` (`custid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin;

-- ----------------------------
-- Records of t_linkman
-- ----------------------------
INSERT INTO `t_linkman` VALUES ('1', '联系人1', '男', '1', '1', '1');

-- ----------------------------
-- Table structure for t_user
-- ----------------------------
DROP TABLE IF EXISTS `t_user`;
CREATE TABLE `t_user` (
  `uid` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) COLLATE utf8mb4_0900_bin DEFAULT NULL,
  `password` varchar(255) COLLATE utf8mb4_0900_bin DEFAULT NULL,
  `address` varchar(255) COLLATE utf8mb4_0900_bin DEFAULT NULL,
  PRIMARY KEY (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'zyp', '123', 'wojai');

-- ----------------------------
-- Table structure for t_visit
-- ----------------------------
DROP TABLE IF EXISTS `t_visit`;
CREATE TABLE `t_visit` (
  `visitId` int NOT NULL AUTO_INCREMENT,
  `visitAddress` varchar(255) COLLATE utf8mb4_0900_bin DEFAULT NULL,
  `visitContent` varchar(255) COLLATE utf8mb4_0900_bin DEFAULT NULL,
  `custid` int DEFAULT NULL,
  `uid` int DEFAULT NULL,
  PRIMARY KEY (`visitId`),
  KEY `FKdrgjn59bak2isi4xqngsk0f4c` (`custid`),
  KEY `FKmpuabksndief7wumddthsiho1` (`uid`),
  CONSTRAINT `FKdrgjn59bak2isi4xqngsk0f4c` FOREIGN KEY (`custid`) REFERENCES `t_customer` (`custid`),
  CONSTRAINT `FKmpuabksndief7wumddthsiho1` FOREIGN KEY (`uid`) REFERENCES `t_user` (`uid`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_bin;

-- ----------------------------
-- Records of t_visit
-- ----------------------------
INSERT INTO `t_visit` VALUES ('1', '13123', '3333', '1', '1');
