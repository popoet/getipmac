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

 Date: 10/08/2022 11:04:58
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for boot_ip
-- ----------------------------
DROP TABLE IF EXISTS `boot_ip`;
CREATE TABLE `boot_ip`  (
  `bi_id` int NOT NULL AUTO_INCREMENT,
  `bi_name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `bi_department` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bi_ip` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `bi_mac` varchar(255) CHARACTER SET utf16 COLLATE utf16_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`bi_id`) USING BTREE,
  UNIQUE INDEX `bi_name`(`bi_name`) USING BTREE,
  UNIQUE INDEX `bi_mac`(`bi_mac`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 65 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = Dynamic;

-- ----------------------------
-- Records of boot_ip
-- ----------------------------
INSERT INTO `boot_ip` VALUES (58, '', 'admin', '', '');
INSERT INTO `boot_ip` VALUES (59, '张学科', '联创项目实施部', '192.168.1.196', '04-33-C2-A9-E2-5F');

SET FOREIGN_KEY_CHECKS = 1;
