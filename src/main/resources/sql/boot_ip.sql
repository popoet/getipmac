/*
 Navicat Premium Data Transfer

 Source Server         : mysql8
 Source Server Type    : MySQL
 Source Server Version : 80022
 Source Host           : localhost:3306
 Source Schema         : boot_ip

 Target Server Type    : MySQL
 Target Server Version : 80022
 File Encoding         : 65001

 Date: 25/07/2022 18:29:25
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for boot_ip
-- ----------------------------
DROP TABLE IF EXISTS `boot_ip`;
CREATE TABLE `boot_ip`  (
  `bi_id` int NOT NULL AUTO_INCREMENT,
  `bi_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bi_department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bi_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bi_mac` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`bi_id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of boot_ip
-- ----------------------------
INSERT INTO `boot_ip` VALUES (1, '张学科', '联创集成组', '192.168.1.123', '04-33-C2-A9-E2-5F');
INSERT INTO `boot_ip` VALUES (2, '学科', '联创', '11', '22');
INSERT INTO `boot_ip` VALUES (3, 'xk', '联创', '11', '22');
INSERT INTO `boot_ip` VALUES (4, '班尼特', '联创', '333', '222');
INSERT INTO `boot_ip` VALUES (5, '胡桃', '联创', '222', '333');
INSERT INTO `boot_ip` VALUES (6, '李倩', '联创', '192.168.1.123', '04-33-C2-A8-E2-56');
INSERT INTO `boot_ip` VALUES (7, '李慧', '联创', '192.168.1.145', '04-33-C2-A8-25-34');

SET FOREIGN_KEY_CHECKS = 1;
