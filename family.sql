/*
 Navicat Premium Data Transfer

 Source Server         : 本地
 Source Server Type    : MySQL
 Source Server Version : 50741 (5.7.41-log)
 Source Host           : localhost:3306
 Source Schema         : family

 Target Server Type    : MySQL
 Target Server Version : 50741 (5.7.41-log)
 File Encoding         : 65001

 Date: 01/07/2023 16:41:40
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for event_type
-- ----------------------------
DROP TABLE IF EXISTS `event_type`;
CREATE TABLE `event_type`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of event_type
-- ----------------------------
INSERT INTO `event_type` VALUES (1, '结婚');
INSERT INTO `event_type` VALUES (2, '晋升');
INSERT INTO `event_type` VALUES (3, '重病');
INSERT INTO `event_type` VALUES (4, '重要成果');
INSERT INTO `event_type` VALUES (5, '交通事故');
INSERT INTO `event_type` VALUES (6, '升学');

-- ----------------------------
-- Table structure for family
-- ----------------------------
DROP TABLE IF EXISTS `family`;
CREATE TABLE `family`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` int(11) NOT NULL,
  `family_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `create_time` datetime NULL DEFAULT NULL,
  `is_del` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 5 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of family
-- ----------------------------
INSERT INTO `family` VALUES (1, 1, '说明1', '2023-07-01 16:07:31', '0');
INSERT INTO `family` VALUES (2, 1, '123', '2023-07-01 16:12:38', '1');
INSERT INTO `family` VALUES (3, 1, '123', '2023-07-01 16:12:50', '1');
INSERT INTO `family` VALUES (4, 1, '1234', '2023-07-01 16:13:32', '0');

-- ----------------------------
-- Table structure for family_person
-- ----------------------------
DROP TABLE IF EXISTS `family_person`;
CREATE TABLE `family_person`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `family_id` int(11) NOT NULL,
  `name` varchar(20) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `sex` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `birth_date` datetime NULL DEFAULT NULL,
  `death_date` datetime NULL DEFAULT NULL,
  `avatar` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_del` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 7 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of family_person
-- ----------------------------
INSERT INTO `family_person` VALUES (1, 1, '蒋介石', 'M', '2023-06-28 00:00:00', '2023-06-28 00:00:00', 'http://localhost:9999/static/operationtime1688199223848.jpeg', '0');
INSERT INTO `family_person` VALUES (2, 1, '宋美龄', 'F', '2023-06-28 15:00:54', '2023-06-28 15:00:56', 'http://localhost:9999/static/operationtime1688132781560.jpeg', '0');
INSERT INTO `family_person` VALUES (3, 1, '蒋经国', 'M', '2023-06-28 15:00:54', '2023-06-28 15:00:56', 'http://localhost:9999/static/operationtime1688132781560.jpeg', '0');
INSERT INTO `family_person` VALUES (4, 1, '蒋孝武', 'M', '2023-06-28 15:00:54', '2023-06-28 15:00:56', 'http://localhost:9999/static/operationtime1688132781560.jpeg', '0');
INSERT INTO `family_person` VALUES (5, 1, '蒋孝勇', 'M', '2023-06-28 15:00:54', '2023-06-28 15:00:56', 'http://localhost:9999/static/operationtime1688132781560.jpeg', '0');
INSERT INTO `family_person` VALUES (6, 1, '章亚若', '女', '2023-06-29 00:00:00', '2023-06-06 00:00:00', 'http://localhost:9999/static/operationtime1688132781560.jpeg', '0');

-- ----------------------------
-- Table structure for person_event
-- ----------------------------
DROP TABLE IF EXISTS `person_event`;
CREATE TABLE `person_event`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `person_id` int(11) NOT NULL,
  `event_date` datetime NULL DEFAULT NULL,
  `type_id` int(255) NULL DEFAULT NULL,
  `event_desc` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  `is_del` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 4 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of person_event
-- ----------------------------
INSERT INTO `person_event` VALUES (1, 2, '2023-07-03 00:00:00', 1, NULL, '0');
INSERT INTO `person_event` VALUES (2, 2, '2023-07-03 00:00:00', 4, NULL, '1');
INSERT INTO `person_event` VALUES (3, 2, '2023-07-05 00:00:00', 2, '123', '0');

-- ----------------------------
-- Table structure for person_relation
-- ----------------------------
DROP TABLE IF EXISTS `person_relation`;
CREATE TABLE `person_relation`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `person_id1` int(11) NULL DEFAULT NULL,
  `person_id2` int(11) NULL DEFAULT NULL,
  `person_type_id` int(11) NULL DEFAULT NULL,
  `is_del` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 9 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of person_relation
-- ----------------------------
INSERT INTO `person_relation` VALUES (1, 2, 1, 5, '0');
INSERT INTO `person_relation` VALUES (2, 3, 1, 9, '0');
INSERT INTO `person_relation` VALUES (3, 4, 1, 9, '0');
INSERT INTO `person_relation` VALUES (4, 5, 4, 9, '0');
INSERT INTO `person_relation` VALUES (5, 6, 3, 5, '0');

-- ----------------------------
-- Table structure for person_type
-- ----------------------------
DROP TABLE IF EXISTS `person_type`;
CREATE TABLE `person_type`  (
  `id` int(11) NOT NULL,
  `name` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of person_type
-- ----------------------------
INSERT INTO `person_type` VALUES (1, '父亲');
INSERT INTO `person_type` VALUES (2, '养父');
INSERT INTO `person_type` VALUES (3, '养母');
INSERT INTO `person_type` VALUES (4, '母亲');
INSERT INTO `person_type` VALUES (5, '妻子');
INSERT INTO `person_type` VALUES (6, '离异妻子');
INSERT INTO `person_type` VALUES (7, '未婚情人');
INSERT INTO `person_type` VALUES (8, '女儿');
INSERT INTO `person_type` VALUES (9, '儿子');
INSERT INTO `person_type` VALUES (10, '私生儿子');
INSERT INTO `person_type` VALUES (11, '私生女儿');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `password` varchar(100) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  `is_del` varchar(1) CHARACTER SET utf8 COLLATE utf8_general_ci NOT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 1 CHARACTER SET = utf8 COLLATE = utf8_general_ci ROW_FORMAT = DYNAMIC;

-- ----------------------------
-- Records of user
-- ----------------------------

SET FOREIGN_KEY_CHECKS = 1;
