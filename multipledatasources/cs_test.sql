/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50720
Source Host           : localhost:3306
Source Database       : test

Target Server Type    : MYSQL
Target Server Version : 50720
File Encoding         : 65001

Date: 2019-02-22 14:34:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cs_test
-- ----------------------------
DROP TABLE IF EXISTS `cs_test`;
CREATE TABLE `cs_test` (
  `id` varchar(128) NOT NULL,
  `userid` varchar(5) DEFAULT NULL,
  `score` int(11) DEFAULT NULL,
  `classid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;
