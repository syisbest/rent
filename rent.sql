/*
Navicat MySQL Data Transfer

Source Server         : shenyan
Source Server Version : 80018
Source Host           : localhost:3306
Source Database       : rent

Target Server Type    : MYSQL
Target Server Version : 80018
File Encoding         : 65001

Date: 2020-02-04 15:46:33
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for admin
-- ----------------------------
DROP TABLE IF EXISTS `admin`;
CREATE TABLE `admin` (
  `id` char(10) NOT NULL,
  `password` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for contract
-- ----------------------------
DROP TABLE IF EXISTS `contract`;
CREATE TABLE `contract` (
  `Cno` char(10) NOT NULL,
  `Lid` char(10) NOT NULL,
  `Hid` char(10) NOT NULL,
  `Rent` int(11) NOT NULL,
  `Date` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '年/月/日',
  `Time` int(11) NOT NULL COMMENT '以月为单位',
  `Status` enum('-2','-1','0','1') NOT NULL DEFAULT '0' COMMENT '0为未处理，1为同意，-1为不同意，-2为到期',
  PRIMARY KEY (`Cno`),
  KEY `lid_` (`Lid`),
  KEY `Hid_` (`Hid`),
  CONSTRAINT `hid_` FOREIGN KEY (`Hid`) REFERENCES `house` (`Hid`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `lid_` FOREIGN KEY (`Lid`) REFERENCES `lodge` (`Lid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for house
-- ----------------------------
DROP TABLE IF EXISTS `house`;
CREATE TABLE `house` (
  `LLid` char(10) NOT NULL,
  `Hid` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Address` varchar(200) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Size` int(10) NOT NULL,
  `Type` char(10) NOT NULL,
  PRIMARY KEY (`Hid`),
  KEY `id` (`LLid`),
  CONSTRAINT `id` FOREIGN KEY (`LLid`) REFERENCES `landlord` (`LLid`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for landlord
-- ----------------------------
DROP TABLE IF EXISTS `landlord`;
CREATE TABLE `landlord` (
  `LLid` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `LLname` char(10) NOT NULL,
  `LLsex` enum('女','男') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '“男”或“女”',
  `LLpassword` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '6-10位',
  `LLage` int(2) NOT NULL COMMENT '0-99',
  `LLtel` char(11) NOT NULL,
  `LLidno` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`LLid`),
  UNIQUE KEY `LLidno` (`LLidno`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Table structure for lodge
-- ----------------------------
DROP TABLE IF EXISTS `lodge`;
CREATE TABLE `lodge` (
  `Lid` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Lname` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Lsex` enum('女','男') CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Lage` int(2) NOT NULL COMMENT '0-99',
  `Ltel` char(11) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `Lpassword` char(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '6-10位字符',
  `Lidno` char(18) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  PRIMARY KEY (`Lid`) USING BTREE,
  UNIQUE KEY `Lidno` (`Lidno`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci ROW_FORMAT=DYNAMIC;
