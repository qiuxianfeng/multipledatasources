/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : test2

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-02-22 14:34:32
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cs_teacher
-- ----------------------------
DROP TABLE IF EXISTS `cs_teacher`;
CREATE TABLE `cs_teacher` (
  `id` varchar(128) NOT NULL,
  `teachername` varchar(32) DEFAULT NULL,
  `classid` varchar(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
