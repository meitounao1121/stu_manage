/*
Navicat MySQL Data Transfer

Source Server         : 123
Source Server Version : 50087
Source Host           : localhost:3306
Source Database       : stu_manage

Target Server Type    : MYSQL
Target Server Version : 50087
File Encoding         : 65001

Date: 2019-10-30 15:44:59
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `class_info`
-- ----------------------------
DROP TABLE IF EXISTS `class_info`;
CREATE TABLE `class_info` (
  `id` int(11) NOT NULL default '0',
  `class_name` varchar(20) default NULL,
  `column1` varchar(20) default NULL,
  `column2` varchar(22) default NULL,
  `column3` varchar(22) default NULL,
  `column4` varchar(22) default NULL,
  `column5` varchar(22) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_info
-- ----------------------------
INSERT INTO `class_info` VALUES ('1', '2018级6班', null, null, null, null, null);
INSERT INTO `class_info` VALUES ('2', '2016级3班', null, null, null, null, null);
INSERT INTO `class_info` VALUES ('3', '2017级1班', null, null, null, null, null);
INSERT INTO `class_info` VALUES ('4', '2018级2班', null, null, null, null, null);
INSERT INTO `class_info` VALUES ('5', '2018级1班', null, null, null, null, null);
INSERT INTO `class_info` VALUES ('6', '2018级3班', null, null, null, null, null);
INSERT INTO `class_info` VALUES ('7', '2018级4班', null, null, null, null, null);
INSERT INTO `class_info` VALUES ('8', '2018级5班', null, null, null, null, null);
INSERT INTO `class_info` VALUES ('9', '2018级7班', null, null, null, null, null);
INSERT INTO `class_info` VALUES ('10', '2017级2班', null, null, null, null, null);
INSERT INTO `class_info` VALUES ('11', '2017级3班', null, null, null, null, null);
INSERT INTO `class_info` VALUES ('12', '2017级4班', null, null, null, null, null);
INSERT INTO `class_info` VALUES ('13', '2017级5班', null, null, null, null, null);
INSERT INTO `class_info` VALUES ('14', '2016级1班', null, null, null, null, null);
INSERT INTO `class_info` VALUES ('15', '2016级2班', null, null, null, null, null);
INSERT INTO `class_info` VALUES ('16', '2016级4班', null, null, null, null, null);

-- ----------------------------
-- Table structure for `class_stu`
-- ----------------------------
DROP TABLE IF EXISTS `class_stu`;
CREATE TABLE `class_stu` (
  `id` int(11) NOT NULL auto_increment,
  `class_id` int(11) default NULL,
  `stu_id` int(11) default NULL,
  `column1` varchar(22) default NULL,
  `column2` varchar(22) default NULL,
  `column3` varchar(22) default NULL,
  `column4` varchar(22) default NULL,
  `column5` varchar(22) default NULL,
  PRIMARY KEY  (`id`),
  KEY `key1` (`class_id`),
  KEY `stu_id` (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_stu
-- ----------------------------
INSERT INTO `class_stu` VALUES ('1', '1', '1', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('2', '2', '2', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('3', '3', '3', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('4', '3', '4', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('5', '4', '5', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('6', '5', '6', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('7', '6', '7', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('8', '7', '8', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('9', '8', '9', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('10', '9', '10', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('11', '10', '11', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('12', '11', '12', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('13', '12', '13', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('14', '13', '14', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('15', '14', '15', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('16', '16', '16', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('17', '13', '17', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('18', '13', '18', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('19', '16', '19', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('20', '5', '20', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('21', '6', '21', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('22', '7', '22', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('23', '2', '35', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('24', '2', '36', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('25', '2', '37', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('26', '1', '38', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('27', '1', '39', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('28', '1', '40', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('29', '1', '41', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('30', '1', '42', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('31', '1', '43', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('32', '11', '44', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('33', '12', '45', null, null, null, null, null);
INSERT INTO `class_stu` VALUES ('34', '12', '46', null, null, null, null, null);

-- ----------------------------
-- Table structure for `class_tea`
-- ----------------------------
DROP TABLE IF EXISTS `class_tea`;
CREATE TABLE `class_tea` (
  `id` int(11) NOT NULL auto_increment,
  `class_id` int(11) default NULL,
  `tea_id` int(11) default '0' COMMENT '此老师为班主任',
  `column1` varchar(22) default NULL,
  `column2` varchar(22) default NULL,
  `column3` varchar(22) default NULL,
  `column4` varchar(22) default NULL,
  `column5` varchar(22) default NULL,
  PRIMARY KEY  (`id`),
  KEY `class_id` (`class_id`),
  KEY `tea_id` (`tea_id`)
) ENGINE=InnoDB AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of class_tea
-- ----------------------------
INSERT INTO `class_tea` VALUES ('1', '1', '1', null, null, null, null, null);
INSERT INTO `class_tea` VALUES ('2', '3', '2', null, null, null, null, null);
INSERT INTO `class_tea` VALUES ('3', '2', '4', null, null, null, null, null);
INSERT INTO `class_tea` VALUES ('4', '4', '3', null, null, null, null, null);
INSERT INTO `class_tea` VALUES ('5', '5', '3', null, null, null, null, null);
INSERT INTO `class_tea` VALUES ('6', '6', '1', null, null, null, null, null);
INSERT INTO `class_tea` VALUES ('7', '10', '10', null, null, null, null, null);
INSERT INTO `class_tea` VALUES ('8', '7', '2', null, null, null, null, null);
INSERT INTO `class_tea` VALUES ('9', '8', '4', null, null, null, null, null);
INSERT INTO `class_tea` VALUES ('10', '9', '10', null, null, null, null, null);
INSERT INTO `class_tea` VALUES ('11', '15', '19', null, null, null, null, null);
INSERT INTO `class_tea` VALUES ('12', '14', '17', null, null, null, null, null);
INSERT INTO `class_tea` VALUES ('13', '11', '22', null, null, null, null, null);
INSERT INTO `class_tea` VALUES ('14', '12', '23', null, null, null, null, null);

-- ----------------------------
-- Table structure for `course_info`
-- ----------------------------
DROP TABLE IF EXISTS `course_info`;
CREATE TABLE `course_info` (
  `id` int(11) NOT NULL auto_increment,
  `course_name` varchar(20) default NULL,
  `flag` int(11) default '0',
  `column2` varchar(22) default NULL,
  `column3` varchar(22) default NULL,
  `column4` varchar(22) default NULL,
  `column5` varchar(22) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_info
-- ----------------------------
INSERT INTO `course_info` VALUES ('1', '马克思主义哲学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('2', '中国哲学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('3', '外国哲学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('4', '逻辑学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('5', '伦理学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('6', '美学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('7', '宗教学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('8', '科学技术哲学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('9', '政治经济学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('10', '经济思想史', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('11', '经济史', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('12', '西方经济学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('13', '世界经济', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('14', '人口、资源与环境经济学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('15', '国民经济学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('16', '国际贸易学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('17', '经济法学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('18', '军事法学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('19', '国际政治', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('20', '外交学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('21', '社会学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('22', '公安管理学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('23', '特殊教育学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('24', '基础心理学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('25', '应用心理学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('26', '学前教育学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('27', '教育学原理', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('28', '文艺学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('29', '汉语言文字学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('30', '中国现当代文学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('31', '中国古典文献学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('32', '新闻学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('33', '传播学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('34', '考古学史和考古学理论', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('35', '科技考古', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('36', '历史地理学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('37', '史学理论及中国史学史', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('38', '世界史学理论与史学史', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('39', '概率论与数理统计', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('40', '应用数学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('41', '运筹学与控制论', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('42', '粒子物理与原子核物理', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('43', '原子与分子物理', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('44', '无机化学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('45', '有机化学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('46', '高分子化学与物理', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('47', '天体物理', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('48', '地理学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('49', '气象学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('50', '海洋科学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('51', '地球物理学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('52', '地质学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('53', '生物学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('54', '系统科学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('55', '科学技术史', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('56', '生态学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('57', '统计学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('58', '一般力学与力学基础', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('59', '机械制造及其自动化', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('60', '仪器科学与技术', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('61', '材料科学与工程', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('62', '冶金工程', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('63', '动力工程及工程热物理', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('64', '电气工程', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('65', '电子科学与技术', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('66', '信息与通信工程', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('67', '控制科学与工程', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('68', '计算机科学与技术', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('69', '建筑历史与理论', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('70', '土木工程', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('71', '水利工程', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('72', '测绘科学与技术', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('73', '化学工程与技术', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('74', '地质资源与地质工程', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('75', '石油与天然气工程', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('76', '船舶与海洋工程', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('77', '兵器科学与技术', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('78', '软件工程', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('79', '作物学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('80', '园艺学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('81', '农业资源利用', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('82', '植物保护', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('83', '兽医学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('84', '林学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('85', '草学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('86', '基础医学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('87', '口腔医学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('88', '公共卫生与预防医学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('89', '中药学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('90', '护理学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('91', '军事思想及军事历史', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('92', '战略学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('93', '军队指挥学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('94', '军队政治工作学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('95', '管理科学与工程', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('96', '工商管理', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('97', '农林经济管理', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('98', '图书馆、情报与档案管理', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('99', '艺术学理论', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('100', '音乐与舞蹈学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('101', '戏剧与影视学', '0', null, null, null, null);
INSERT INTO `course_info` VALUES ('102', '美术学', '0', null, null, null, null);

-- ----------------------------
-- Table structure for `course_stu`
-- ----------------------------
DROP TABLE IF EXISTS `course_stu`;
CREATE TABLE `course_stu` (
  `id` int(11) NOT NULL auto_increment,
  `course_id` int(11) default NULL,
  `stu_id` int(11) default NULL,
  `column1` varchar(22) default NULL,
  `column2` varchar(22) default NULL,
  `column3` varchar(22) default NULL,
  `column4` varchar(22) default NULL,
  `column5` varchar(22) default NULL,
  PRIMARY KEY  (`id`),
  KEY `course_id` (`course_id`),
  KEY `stu_id` (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_stu
-- ----------------------------
INSERT INTO `course_stu` VALUES ('1', '1', '5', null, null, null, null, null);
INSERT INTO `course_stu` VALUES ('2', '2', '5', null, null, null, null, null);
INSERT INTO `course_stu` VALUES ('3', '3', '5', null, null, null, null, null);
INSERT INTO `course_stu` VALUES ('4', '4', '16', null, null, null, null, null);
INSERT INTO `course_stu` VALUES ('5', '1', '17', null, null, null, null, null);

-- ----------------------------
-- Table structure for `course_tea`
-- ----------------------------
DROP TABLE IF EXISTS `course_tea`;
CREATE TABLE `course_tea` (
  `id` int(11) NOT NULL auto_increment,
  `course_id` int(11) default NULL,
  `tea_id` int(11) default NULL COMMENT '此老师为科任老师',
  `course_class` varchar(22) default NULL,
  `deadline` datetime default NULL,
  `course_time` varchar(22) default NULL,
  `course_place` varchar(22) default NULL,
  `column5` varchar(22) default NULL,
  PRIMARY KEY  (`id`),
  KEY `course_tea_ibfk_1` (`course_id`),
  KEY `tea_id` (`tea_id`)
) ENGINE=InnoDB AUTO_INCREMENT=43 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of course_tea
-- ----------------------------
INSERT INTO `course_tea` VALUES ('1', '1', '2', '马哲1班', '2019-09-07 00:00:00', '10:30-12:00', '1教201', null);
INSERT INTO `course_tea` VALUES ('2', '1', '3', '马哲2班', '2019-09-08 00:00:00', '10:30-12:00', '1教202', null);
INSERT INTO `course_tea` VALUES ('3', '1', '4', '马哲3班', '2019-09-08 00:00:00', '10:30-12:00', '1教203', null);
INSERT INTO `course_tea` VALUES ('4', '2', '1', '中国哲学1班', '2019-09-08 00:00:00', '08:30-10:00', '2教405', null);
INSERT INTO `course_tea` VALUES ('5', '2', '2', '中国哲学2班', '2019-09-08 00:00:00', '08:30-10:00', '3教333', null);
INSERT INTO `course_tea` VALUES ('6', '2', '12', '中国哲学3班', '2019-09-08 00:00:00', '08:30-10:00', '3教601', null);
INSERT INTO `course_tea` VALUES ('7', '3', '13', '外国哲学1班', '2019-09-21 00:00:00', '13:30-15:00', '3教502', null);
INSERT INTO `course_tea` VALUES ('8', '3', '2', '外国哲学2班', '2019-09-18 00:00:00', '13:30-15:00', '1教201', null);
INSERT INTO `course_tea` VALUES ('9', '32', '5', '新闻学1班', '2019-09-12 00:00:00', '19:00-20:40', '实验楼207', null);
INSERT INTO `course_tea` VALUES ('10', '4', '12', '逻辑学1班', '2019-09-12 00:00:00', '19:00-20:40', '实验楼203', null);
INSERT INTO `course_tea` VALUES ('11', '5', '14', '伦理学1班', '2019-09-12 00:00:00', '19:00-20:40', '八教102', null);
INSERT INTO `course_tea` VALUES ('12', '6', '15', '美学1班', '2019-09-21 00:00:00', '19:00-20:40', '九教202', null);
INSERT INTO `course_tea` VALUES ('13', '7', '16', '宗教学1班', '2019-09-21 00:00:00', '19:00-20:40', '实验楼204', null);
INSERT INTO `course_tea` VALUES ('14', '7', '14', '宗教学2班', '2019-09-12 00:00:00', '08:00 - 09:40', '五教北402', null);
INSERT INTO `course_tea` VALUES ('15', '8', '15', '科学技术哲学2班', '2019-09-12 00:00:00', '14:10 - 04:00', '五教北402', null);
INSERT INTO `course_tea` VALUES ('16', '8', '15', '科学技术哲学1班', '2019-09-12 00:00:00', '14:10 - 04:00', '五教北402', null);
INSERT INTO `course_tea` VALUES ('17', '9', '16', '政治经济学1班', '2019-09-14 00:00:00', '10:10 - 11:50', '三教306', null);
INSERT INTO `course_tea` VALUES ('18', '10', '11', '经济思想史1班', '2019-09-14 00:00:00', '08:00 - 09:40', '中文楼505', null);
INSERT INTO `course_tea` VALUES ('19', '25', '17', '应用心理学1班', '2019-09-14 00:00:00', '08:00 - 11:50', '五教北101', null);
INSERT INTO `course_tea` VALUES ('20', '12', '1', '西方经济学1班', '2019-09-14 00:00:00', '19:00 - 20:40', '五教西203', null);
INSERT INTO `course_tea` VALUES ('21', '11', '1', '经济史1班', '2019-09-15 00:00:00', '08:00 - 09:40', '一教306', null);
INSERT INTO `course_tea` VALUES ('22', '13', '2', '世界经济1班', '2019-09-20 00:00:00', '14:20 - 16:00', '中文楼505', null);
INSERT INTO `course_tea` VALUES ('23', '14', '3', '人口资源与环境经济学1班', '2019-09-21 00:00:00', '14:20 - 16:00', '中文楼101', null);
INSERT INTO `course_tea` VALUES ('24', '17', '4', '经济法学1班', '2019-09-21 00:00:00', '14:20 - 16:00', '中文楼201', null);
INSERT INTO `course_tea` VALUES ('25', '18', '5', '军事法学1班', '2019-09-17 00:00:00', '08:00 - 09:40', '中文楼505', null);
INSERT INTO `course_tea` VALUES ('26', '15', '5', '国民经济学1班', '2019-09-14 00:00:00', '10:20 - 11:50', '中文楼301', null);
INSERT INTO `course_tea` VALUES ('27', '16', '10', '国际贸易学1班', '2019-09-13 00:00:00', '10:20 - 11:50', '中文楼304', null);
INSERT INTO `course_tea` VALUES ('28', '19', '12', '国际政治1班', '2019-09-21 00:00:00', '16:20 - 18:00', '中文楼202', null);
INSERT INTO `course_tea` VALUES ('29', '20', '12', '外交学1班', '2019-09-14 00:00:00', '14:20 - 16:00', '八教203', null);
INSERT INTO `course_tea` VALUES ('30', '22', '14', '公安管理学1班', '2019-09-14 00:00:00', '08:00 - 09:40', '八教404', null);
INSERT INTO `course_tea` VALUES ('31', '23', '15', '特殊教育学1班', '2019-09-14 00:00:00', '08:00 - 09:40', '五教北701', null);
INSERT INTO `course_tea` VALUES ('32', '24', '18', '基础心理学1班', '2019-09-18 00:00:00', '10:20 - 11:50', '五教602', null);
INSERT INTO `course_tea` VALUES ('33', '28', '18', '文艺学1班', '2019-09-14 00:00:00', '14:20 - 18:00', '五教南304', null);
INSERT INTO `course_tea` VALUES ('34', '31', '19', '中国古典文献学', '2019-09-14 00:00:00', '08:00 - 09:40', '五教北206', null);
INSERT INTO `course_tea` VALUES ('35', '35', '13', '科技考古1班', '2019-09-14 00:00:00', '08:00 - 09:40', '五教南606', null);
INSERT INTO `course_tea` VALUES ('36', '36', '14', '历史地理学1班', '2019-09-14 00:00:00', '08:00 - 09:40', '五教南505', null);
INSERT INTO `course_tea` VALUES ('37', '40', '19', '应用数学1班', '2019-09-14 00:00:00', '10:20 - 11:50', '五教北701', null);
INSERT INTO `course_tea` VALUES ('38', '88', '19', '公共卫生与预防医学', '2019-09-14 00:00:00', '19:00 - 08:40', '五教北103', null);
INSERT INTO `course_tea` VALUES ('39', '83', '17', '兽医学1班', '2019-09-14 00:00:00', '10:20 - 11:50', '五教南102', null);
INSERT INTO `course_tea` VALUES ('40', '84', '15', '林学1班', '2019-09-14 00:00:00', '19:00 - 20:40', '八教306', null);
INSERT INTO `course_tea` VALUES ('41', '96', '22', '工商管理1班', '2019-09-12 00:00:00', '00:00 - 00:00', '701', null);
INSERT INTO `course_tea` VALUES ('42', '90', '23', '护理学1班', '2019-09-14 00:00:00', '08:00 - 09:40', '五教101', null);

-- ----------------------------
-- Table structure for `ct_s`
-- ----------------------------
DROP TABLE IF EXISTS `ct_s`;
CREATE TABLE `ct_s` (
  `id` int(11) NOT NULL auto_increment,
  `ct_id` int(11) default NULL,
  `stu_id` int(11) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=159 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of ct_s
-- ----------------------------
INSERT INTO `ct_s` VALUES ('115', '1', '5');
INSERT INTO `ct_s` VALUES ('116', '4', '5');
INSERT INTO `ct_s` VALUES ('117', '7', '5');
INSERT INTO `ct_s` VALUES ('118', '4', '16');
INSERT INTO `ct_s` VALUES ('119', '1', '17');
INSERT INTO `ct_s` VALUES ('120', '1', '18');
INSERT INTO `ct_s` VALUES ('121', '24', '16');
INSERT INTO `ct_s` VALUES ('122', '1', '15');
INSERT INTO `ct_s` VALUES ('123', '6', '15');
INSERT INTO `ct_s` VALUES ('124', '25', '15');
INSERT INTO `ct_s` VALUES ('125', '24', '15');
INSERT INTO `ct_s` VALUES ('126', '18', '15');
INSERT INTO `ct_s` VALUES ('127', '20', '15');
INSERT INTO `ct_s` VALUES ('128', '21', '15');
INSERT INTO `ct_s` VALUES ('129', '22', '15');
INSERT INTO `ct_s` VALUES ('130', '23', '15');
INSERT INTO `ct_s` VALUES ('131', '33', '16');
INSERT INTO `ct_s` VALUES ('132', '34', '16');
INSERT INTO `ct_s` VALUES ('133', '40', '15');
INSERT INTO `ct_s` VALUES ('134', '31', '6');
INSERT INTO `ct_s` VALUES ('135', '3', '6');
INSERT INTO `ct_s` VALUES ('136', '5', '6');
INSERT INTO `ct_s` VALUES ('137', '7', '6');
INSERT INTO `ct_s` VALUES ('138', '36', '6');
INSERT INTO `ct_s` VALUES ('139', '35', '6');
INSERT INTO `ct_s` VALUES ('140', '37', '6');
INSERT INTO `ct_s` VALUES ('141', '1', '8');
INSERT INTO `ct_s` VALUES ('142', '4', '8');
INSERT INTO `ct_s` VALUES ('143', '18', '8');
INSERT INTO `ct_s` VALUES ('144', '21', '8');
INSERT INTO `ct_s` VALUES ('145', '23', '8');
INSERT INTO `ct_s` VALUES ('146', '27', '8');
INSERT INTO `ct_s` VALUES ('147', '35', '8');
INSERT INTO `ct_s` VALUES ('148', '37', '8');
INSERT INTO `ct_s` VALUES ('149', '28', '8');
INSERT INTO `ct_s` VALUES ('150', '29', '8');
INSERT INTO `ct_s` VALUES ('151', '1', '13');
INSERT INTO `ct_s` VALUES ('152', '7', '13');
INSERT INTO `ct_s` VALUES ('153', '4', '13');
INSERT INTO `ct_s` VALUES ('154', '1', '16');
INSERT INTO `ct_s` VALUES ('155', '41', '44');
INSERT INTO `ct_s` VALUES ('156', '1', '44');
INSERT INTO `ct_s` VALUES ('157', '42', '46');
INSERT INTO `ct_s` VALUES ('158', '41', '16');

-- ----------------------------
-- Table structure for `major_course`
-- ----------------------------
DROP TABLE IF EXISTS `major_course`;
CREATE TABLE `major_course` (
  `id` int(11) NOT NULL auto_increment,
  `course_id` int(11) default NULL,
  `major_id` int(11) default NULL,
  `column1` varchar(22) default NULL,
  `column2` varchar(22) default NULL,
  `column3` varchar(22) default NULL,
  `column4` varchar(22) default NULL,
  `column5` varchar(22) default NULL,
  PRIMARY KEY  (`id`),
  KEY `course_id` (`course_id`),
  KEY `mojor_id` (`major_id`)
) ENGINE=InnoDB AUTO_INCREMENT=141 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major_course
-- ----------------------------
INSERT INTO `major_course` VALUES ('39', '1', '1', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('40', '2', '1', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('41', '3', '1', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('42', '4', '1', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('43', '5', '1', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('44', '6', '1', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('45', '7', '1', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('46', '8', '1', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('47', '9', '2', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('48', '10', '2', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('49', '11', '2', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('50', '12', '2', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('51', '13', '2', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('52', '14', '2', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('53', '15', '2', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('54', '16', '2', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('55', '17', '3', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('56', '18', '3', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('57', '19', '3', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('58', '20', '3', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('59', '21', '3', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('60', '22', '3', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('61', '23', '4', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('62', '24', '4', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('63', '25', '4', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('64', '26', '4', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('65', '27', '4', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('66', '28', '5', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('67', '29', '5', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('68', '30', '5', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('69', '31', '5', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('70', '32', '5', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('71', '33', '5', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('72', '34', '6', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('73', '35', '6', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('74', '36', '6', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('75', '37', '6', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('76', '38', '6', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('77', '39', '7', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('78', '40', '7', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('79', '41', '7', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('80', '42', '7', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('81', '43', '7', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('82', '44', '7', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('83', '45', '7', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('84', '46', '7', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('85', '47', '7', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('86', '48', '7', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('87', '49', '7', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('88', '50', '7', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('89', '51', '7', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('90', '52', '7', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('91', '53', '7', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('92', '54', '7', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('93', '55', '7', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('94', '56', '7', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('95', '57', '7', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('96', '58', '8', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('97', '59', '8', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('98', '60', '8', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('99', '61', '8', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('100', '62', '8', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('101', '63', '8', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('102', '64', '8', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('103', '65', '8', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('104', '66', '8', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('105', '67', '8', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('106', '68', '8', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('107', '69', '8', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('108', '70', '8', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('109', '71', '8', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('110', '72', '8', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('111', '73', '8', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('112', '74', '8', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('113', '75', '8', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('114', '76', '8', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('115', '77', '8', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('116', '78', '8', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('117', '79', '9', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('118', '80', '9', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('119', '81', '9', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('120', '82', '9', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('121', '83', '9', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('122', '84', '9', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('123', '85', '9', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('124', '86', '10', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('125', '87', '10', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('126', '88', '10', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('127', '89', '10', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('128', '90', '10', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('129', '91', '11', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('130', '92', '11', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('131', '93', '11', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('132', '94', '11', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('133', '95', '12', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('134', '96', '12', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('135', '97', '12', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('136', '98', '12', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('137', '99', '13', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('138', '100', '13', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('139', '101', '13', null, null, null, null, null);
INSERT INTO `major_course` VALUES ('140', '102', '13', null, null, null, null, null);

-- ----------------------------
-- Table structure for `major_info`
-- ----------------------------
DROP TABLE IF EXISTS `major_info`;
CREATE TABLE `major_info` (
  `id` int(11) NOT NULL auto_increment,
  `major_name` varchar(20) default NULL,
  `column1` varchar(22) default NULL,
  `column2` varchar(22) default NULL,
  `column3` varchar(22) default NULL,
  `column4` varchar(22) default NULL,
  `column5` varchar(22) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of major_info
-- ----------------------------
INSERT INTO `major_info` VALUES ('1', '哲学', null, null, null, null, null);
INSERT INTO `major_info` VALUES ('2', '经济学', null, null, null, null, null);
INSERT INTO `major_info` VALUES ('3', '法学', null, null, null, null, null);
INSERT INTO `major_info` VALUES ('4', '教育学', null, null, null, null, null);
INSERT INTO `major_info` VALUES ('5', '文学', null, null, null, null, null);
INSERT INTO `major_info` VALUES ('6', '历史学', null, null, null, null, null);
INSERT INTO `major_info` VALUES ('7', '理学', null, null, null, null, null);
INSERT INTO `major_info` VALUES ('8', '工学', null, null, null, null, null);
INSERT INTO `major_info` VALUES ('9', '农学', null, null, null, null, null);
INSERT INTO `major_info` VALUES ('10', '医学', null, null, null, null, null);
INSERT INTO `major_info` VALUES ('11', '军事学', null, null, null, null, null);
INSERT INTO `major_info` VALUES ('12', '管理学', null, null, null, null, null);
INSERT INTO `major_info` VALUES ('13', '艺术学', null, null, null, null, null);

-- ----------------------------
-- Table structure for `permission`
-- ----------------------------
DROP TABLE IF EXISTS `permission`;
CREATE TABLE `permission` (
  `id` int(11) NOT NULL auto_increment,
  `pid` int(11) default NULL,
  `permission_name` varchar(20) default NULL,
  `permission_url` varchar(100) default NULL,
  `create_time` datetime default NULL,
  `modify_time` datetime default NULL,
  `column1` varchar(22) default NULL,
  `column2` varchar(22) default NULL,
  `column3` varchar(22) default NULL,
  `column4` varchar(22) default NULL,
  `column5` varchar(22) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1002 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of permission
-- ----------------------------
INSERT INTO `permission` VALUES ('1', '0', '学生管理', '/admin/stu', null, null, null, null, null, null, null);
INSERT INTO `permission` VALUES ('2', '0', '老师管理', '/admin/tea', null, null, null, null, null, null, null);
INSERT INTO `permission` VALUES ('3', '0', '课程管理', null, null, null, null, null, null, null, null);
INSERT INTO `permission` VALUES ('4', '0', '班级管理', '/admin/class', null, null, null, null, null, null, null);
INSERT INTO `permission` VALUES ('5', '0', '课程管理', null, null, null, null, null, null, null, null);
INSERT INTO `permission` VALUES ('6', '0', '成绩管理', null, null, null, null, null, null, null, null);
INSERT INTO `permission` VALUES ('7', '0', '账号管理', null, null, null, null, null, null, null, null);
INSERT INTO `permission` VALUES ('8', '0', '授课管理', 'teacher/course', null, null, null, null, null, null, null);
INSERT INTO `permission` VALUES ('9', '0', '班级管理', 'teacher/class', null, null, null, null, null, null, null);
INSERT INTO `permission` VALUES ('11', '1', '添加学生', 'admin/addStudent.html', null, null, null, null, null, null, null);
INSERT INTO `permission` VALUES ('12', '1', '学生信息', 'admin/AllStudentsInfo.html', null, null, null, null, null, null, null);
INSERT INTO `permission` VALUES ('21', '2', '添加老师', 'admin/addTeacher.html', null, null, null, null, null, null, null);
INSERT INTO `permission` VALUES ('22', '2', '老师信息', 'admin/AllTeachersInfo.html', null, null, null, null, null, null, null);
INSERT INTO `permission` VALUES ('31', '3', '选修课程分配', 'admin/addCourseTeacher.html', null, null, null, null, null, null, null);
INSERT INTO `permission` VALUES ('41', '4', '分配修改班级', 'admin/addClassTeacher.html', null, null, null, null, null, null, null);
INSERT INTO `permission` VALUES ('51', '5', '选课', 'student/course.html', null, null, null, null, null, null, null);
INSERT INTO `permission` VALUES ('52', '5', '查看课表', 'student/checkcourse.html', null, null, null, null, null, null, null);
INSERT INTO `permission` VALUES ('61', '6', '查看成绩', 'student/queryScore.html', null, null, null, null, null, null, null);
INSERT INTO `permission` VALUES ('71', '7', '查看信息', 'student/message.html', null, null, null, null, null, null, null);
INSERT INTO `permission` VALUES ('81', '8', '查看课程', 'teacher/checkcourse.html', null, null, null, null, null, null, null);
INSERT INTO `permission` VALUES ('91', '9', '我的班级', 'teacher/TeacherClass.html', null, null, null, null, null, null, null);
INSERT INTO `permission` VALUES ('92', '9', '课程班级', 'teacher/CourseClass.html', null, null, null, null, null, null, null);
INSERT INTO `permission` VALUES ('100', '0', '账号管理', '', null, null, null, null, null, null, null);
INSERT INTO `permission` VALUES ('1001', '100', '我的信息', 'teacher/message.html', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `role`
-- ----------------------------
DROP TABLE IF EXISTS `role`;
CREATE TABLE `role` (
  `id` int(11) NOT NULL auto_increment,
  `role_name` varchar(20) default NULL,
  `create_time` datetime default NULL,
  `modify_time` datetime default NULL,
  `column1` varchar(22) default NULL,
  `column2` varchar(22) default NULL,
  `column3` varchar(22) default NULL,
  `column4` varchar(22) default NULL,
  `column5` varchar(22) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role
-- ----------------------------
INSERT INTO `role` VALUES ('1', '超级管理员', null, null, null, null, null, null, null);
INSERT INTO `role` VALUES ('2', '学生', null, null, null, null, null, null, null);
INSERT INTO `role` VALUES ('3', '老师', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `role_permission`
-- ----------------------------
DROP TABLE IF EXISTS `role_permission`;
CREATE TABLE `role_permission` (
  `id` int(11) NOT NULL auto_increment,
  `role_id` int(11) default NULL,
  `permission_id` int(11) default NULL,
  `create_time` datetime default NULL,
  `modify_time` datetime default NULL,
  `column1` varchar(22) default NULL,
  `column2` varchar(22) default NULL,
  `column3` varchar(22) default NULL,
  `column4` varchar(22) default NULL,
  `column5` varchar(22) default NULL,
  PRIMARY KEY  (`id`),
  KEY `role_id` (`role_id`),
  KEY `permission_id` (`permission_id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of role_permission
-- ----------------------------
INSERT INTO `role_permission` VALUES ('1', '1', '12', null, null, null, null, null, null, null);
INSERT INTO `role_permission` VALUES ('2', '1', '22', null, null, null, null, null, null, null);
INSERT INTO `role_permission` VALUES ('3', '1', '41', null, null, null, null, null, null, null);
INSERT INTO `role_permission` VALUES ('4', '1', '31', null, null, null, null, null, null, null);
INSERT INTO `role_permission` VALUES ('5', '1', '21', null, null, null, null, null, null, null);
INSERT INTO `role_permission` VALUES ('6', '1', '4', null, null, null, null, null, null, null);
INSERT INTO `role_permission` VALUES ('7', '1', '3', null, null, null, null, null, null, null);
INSERT INTO `role_permission` VALUES ('8', '1', '1', null, null, null, null, null, null, null);
INSERT INTO `role_permission` VALUES ('9', '1', '2', null, null, null, null, null, null, null);
INSERT INTO `role_permission` VALUES ('10', '1', '11', null, null, null, null, null, null, null);
INSERT INTO `role_permission` VALUES ('11', '2', '61', null, null, null, null, null, null, null);
INSERT INTO `role_permission` VALUES ('12', '2', '71', null, null, null, null, null, null, null);
INSERT INTO `role_permission` VALUES ('13', '2', '5', null, null, null, null, null, null, null);
INSERT INTO `role_permission` VALUES ('14', '2', '6', null, null, null, null, null, null, null);
INSERT INTO `role_permission` VALUES ('15', '2', '7', null, null, null, null, null, null, null);
INSERT INTO `role_permission` VALUES ('16', '2', '51', null, null, null, null, null, null, null);
INSERT INTO `role_permission` VALUES ('17', '2', '52', null, null, null, null, null, null, null);
INSERT INTO `role_permission` VALUES ('18', '3', '1001', null, null, null, null, null, null, null);
INSERT INTO `role_permission` VALUES ('19', '3', '91', null, null, null, null, null, null, null);
INSERT INTO `role_permission` VALUES ('20', '3', '81', null, null, null, null, null, null, null);
INSERT INTO `role_permission` VALUES ('21', '3', '8', null, null, null, null, null, null, null);
INSERT INTO `role_permission` VALUES ('22', '3', '9', null, null, null, null, null, null, null);
INSERT INTO `role_permission` VALUES ('23', '3', '100', null, null, null, null, null, null, null);
INSERT INTO `role_permission` VALUES ('24', '3', '92', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `score`
-- ----------------------------
DROP TABLE IF EXISTS `score`;
CREATE TABLE `score` (
  `id` int(11) NOT NULL auto_increment,
  `course_tea_id` int(11) default NULL,
  `stu_id` int(11) default NULL,
  `score` int(11) default NULL,
  `column1` varchar(22) default NULL,
  `column2` varchar(22) default NULL,
  `column3` varchar(22) default NULL,
  `column4` varchar(22) default NULL,
  `column5` varchar(22) default NULL,
  PRIMARY KEY  (`id`),
  KEY `course_id` (`course_tea_id`),
  KEY `stu_id` (`stu_id`)
) ENGINE=InnoDB AUTO_INCREMENT=48 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of score
-- ----------------------------
INSERT INTO `score` VALUES ('4', '1', '5', '60', null, null, null, null, null);
INSERT INTO `score` VALUES ('5', '4', '5', '60', null, null, null, null, null);
INSERT INTO `score` VALUES ('6', '7', '5', '60', null, null, null, null, null);
INSERT INTO `score` VALUES ('7', '4', '16', '99', null, null, null, null, null);
INSERT INTO `score` VALUES ('8', '1', '17', '80', null, null, null, null, null);
INSERT INTO `score` VALUES ('9', '1', '18', '90', null, null, null, null, null);
INSERT INTO `score` VALUES ('10', '24', '16', null, null, null, null, null, null);
INSERT INTO `score` VALUES ('11', '1', '15', '85', null, null, null, null, null);
INSERT INTO `score` VALUES ('12', '6', '15', '89', null, null, null, null, null);
INSERT INTO `score` VALUES ('13', '25', '15', '89', null, null, null, null, null);
INSERT INTO `score` VALUES ('14', '24', '15', '89', null, null, null, null, null);
INSERT INTO `score` VALUES ('15', '18', '15', '89', null, null, null, null, null);
INSERT INTO `score` VALUES ('16', '20', '15', '89', null, null, null, null, null);
INSERT INTO `score` VALUES ('17', '21', '15', '89', null, null, null, null, null);
INSERT INTO `score` VALUES ('18', '22', '15', '89', null, null, null, null, null);
INSERT INTO `score` VALUES ('19', '23', '15', '89', null, null, null, null, null);
INSERT INTO `score` VALUES ('20', '33', '16', null, null, null, null, null, null);
INSERT INTO `score` VALUES ('21', '34', '16', null, null, null, null, null, null);
INSERT INTO `score` VALUES ('22', '40', '15', '89', null, null, null, null, null);
INSERT INTO `score` VALUES ('23', '31', '6', null, null, null, null, null, null);
INSERT INTO `score` VALUES ('24', '3', '6', null, null, null, null, null, null);
INSERT INTO `score` VALUES ('25', '5', '6', null, null, null, null, null, null);
INSERT INTO `score` VALUES ('26', '7', '6', null, null, null, null, null, null);
INSERT INTO `score` VALUES ('27', '36', '6', null, null, null, null, null, null);
INSERT INTO `score` VALUES ('28', '35', '6', null, null, null, null, null, null);
INSERT INTO `score` VALUES ('29', '37', '6', null, null, null, null, null, null);
INSERT INTO `score` VALUES ('30', '1', '8', null, null, null, null, null, null);
INSERT INTO `score` VALUES ('31', '4', '8', null, null, null, null, null, null);
INSERT INTO `score` VALUES ('32', '18', '8', null, null, null, null, null, null);
INSERT INTO `score` VALUES ('33', '21', '8', null, null, null, null, null, null);
INSERT INTO `score` VALUES ('34', '23', '8', null, null, null, null, null, null);
INSERT INTO `score` VALUES ('35', '27', '8', null, null, null, null, null, null);
INSERT INTO `score` VALUES ('36', '35', '8', null, null, null, null, null, null);
INSERT INTO `score` VALUES ('37', '37', '8', null, null, null, null, null, null);
INSERT INTO `score` VALUES ('38', '28', '8', null, null, null, null, null, null);
INSERT INTO `score` VALUES ('39', '29', '8', null, null, null, null, null, null);
INSERT INTO `score` VALUES ('40', '1', '13', '93', null, null, null, null, null);
INSERT INTO `score` VALUES ('41', '7', '13', '93', null, null, null, null, null);
INSERT INTO `score` VALUES ('42', '4', '13', '93', null, null, null, null, null);
INSERT INTO `score` VALUES ('43', '1', '16', null, null, null, null, null, null);
INSERT INTO `score` VALUES ('44', '41', '44', '1000', null, null, null, null, null);
INSERT INTO `score` VALUES ('45', '1', '44', null, null, null, null, null, null);
INSERT INTO `score` VALUES ('46', '42', '46', '80', null, null, null, null, null);
INSERT INTO `score` VALUES ('47', '41', '16', null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `stu_info`
-- ----------------------------
DROP TABLE IF EXISTS `stu_info`;
CREATE TABLE `stu_info` (
  `id` int(11) NOT NULL auto_increment,
  `stu_name` varchar(20) default NULL,
  `stu_age` varchar(20) default NULL,
  `stu_sex` varchar(5) default NULL,
  `stu_phone` char(11) default NULL,
  `stu_mail` varchar(40) default NULL,
  `stu_address` varchar(50) default NULL,
  `column1` varchar(22) default NULL,
  `column2` varchar(22) default NULL,
  `column3` varchar(22) default NULL,
  `column4` varchar(22) default NULL,
  `column5` varchar(22) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of stu_info
-- ----------------------------
INSERT INTO `stu_info` VALUES ('1', '王昭君', '20', '女', '11342143214', '123871855@qq.com', '四川省绵阳市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('2', '小李', '25', '男', '15834323212', '456121855@qq.com', '四川省内江市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('3', '张正月', '22', '男', '11342143212', '123121855@qq.com', '四川省绵阳市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('4', '张居正', '21', '男', '13734323212', '456121855@qq.com', '四川省德阳市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('5', '张崔', '21', '男', '15834323212', '654121855@qq.com', '四川省内江市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('6', '李莉莉', '20', '女', '15934323212', '346121855@qq.com', '四川省成都市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('7', '李华', '20', '女', '15923193212', '345121855@qq.com', '四川省资阳市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('8', '赵华', '20', '男', '13723192332', '645121855@qq.com', '四川省资阳市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('9', '赵强', '21', '男', '13754678332', '632121855@qq.com', '四川省自贡市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('10', '赵婷婷', '21', '女', '13754675332', '63561855@qq.com', '四川省成都市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('11', '黄婷', '21', '女', '13754575323', '32561822@qq.com', '四川省遂宁市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('12', '左左', '21', '女', '15754575315', '32525822@qq.com', '四川省遂宁市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('13', '桌子', '21', '男', '13754368315', '725258552@qq.com', '四川省盐亭市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('14', '苏玉珍', '21', '女', '13754368379', '895258552@qq.com', '四川省自贡市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('15', '王宝强', '25', '男', '13754368517', '893578552@qq.com', '四川省达州市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('16', '狗蛋儿', '233', '男', '15756349563', '1007953251@qq.com', '四川省成都市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('17', '张三', '22', '男', '13785471452', null, '四川省达州市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('18', '邓强', '22', '男', '15878459514', null, '四川省广元市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('19', '王亮', '21', '男', '14384267519', null, null, null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('20', '唐仁河', '25', '男', '15878459514', '985478485@qq.com', '四川省广元市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('21', '徐嘉伟', '22', '男', '15878239123', '', '四川省成都市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('22', 'qw', null, '女', null, null, null, null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('32', 'zhangsan', '18', '男', '123456', '123@qq.com', '四川成都市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('33', 'lisi', '18', '男', '978978465', '163@163.com', '四川巴中市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('34', '王五', '18', '男', '4367', '123@sina.com', '四川内江市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('35', 'zhangsan', '18', '男', '123456', '123@qq.com', '四川成都市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('36', 'lisi', '18', '男', '978978465', '163@163.com', '四川巴中市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('37', '王五', '18', '男', '4367', '123@sina.com', '四川内江市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('38', 'zhangsan', '18', '男', '123456', '123@qq.com', '四川成都市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('39', 'lisi', '18', '男', '978978465', '163@163.com', '四川巴中市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('40', '王五', '18', '男', '4367', '123@sina.com', '四川内江市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('41', 'AAA', '18', '男', '18967267748', '123@qq.com', '四川成都市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('42', 'BBB', '18', '男', '978978465', '163@163.com', '四川巴中市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('43', 'CCC', '18', '男', '4367', '123@sina.com', '四川内江市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('44', 'DDD', '18', '男', '18967267748', '123@qq.com', '四川成都市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('45', '钟杰1', '18', '男', '18967267748', '123@qq.com', '四川成都市', null, null, null, null, null);
INSERT INTO `stu_info` VALUES ('46', '李雨峰1', '22', '男', '13333333333', '11@qq.com', '四川成都市', null, null, null, null, null);

-- ----------------------------
-- Table structure for `tea_info`
-- ----------------------------
DROP TABLE IF EXISTS `tea_info`;
CREATE TABLE `tea_info` (
  `id` int(11) NOT NULL auto_increment,
  `tea_name` varchar(20) default NULL,
  `tea_age` varchar(20) default NULL,
  `tea_sex` varchar(20) default NULL,
  `tea_phone` char(11) default NULL,
  `tea_email` varchar(40) default NULL,
  `tea_address` varchar(50) default NULL,
  `column1` varchar(22) default NULL,
  `column2` varchar(22) default NULL,
  `column3` varchar(22) default NULL,
  `column4` varchar(22) default NULL,
  `column5` varchar(22) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=24 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tea_info
-- ----------------------------
INSERT INTO `tea_info` VALUES ('1', '何老大', '42', '男', '15823451234', '126@qq.com', '四川省巴中市', null, null, null, null, null);
INSERT INTO `tea_info` VALUES ('2', '春春', '44', '男', '15812347890', '163@163.com', '四川省巴中市', null, null, null, null, null);
INSERT INTO `tea_info` VALUES ('3', '军军', '43', '男', '17723451234', '123@163.com', '四川省自贡市', null, null, null, null, null);
INSERT INTO `tea_info` VALUES ('4', '笑容', '40', '女', '17812431256', 'xq@qq.com', '四川省内江市', null, null, null, null, null);
INSERT INTO `tea_info` VALUES ('5', '飞大哥', '42', '男', '17826783478', '163@163.com', '四川省成都市', null, null, null, null, null);
INSERT INTO `tea_info` VALUES ('6', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tea_info` VALUES ('7', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tea_info` VALUES ('8', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tea_info` VALUES ('9', null, null, null, null, null, null, null, null, null, null, null);
INSERT INTO `tea_info` VALUES ('10', '钟z', '40', '女', '15878239234', '123@321.com', '四川省巴中市', null, null, null, null, null);
INSERT INTO `tea_info` VALUES ('11', '钟zq', '38', '女', '15809784512', '163@sina.com', '四川省攀枝花市', null, null, null, null, null);
INSERT INTO `tea_info` VALUES ('12', '武老', '43', '男', '13778452547', '254877847@qq.com', '四川省绵阳市', null, null, null, null, null);
INSERT INTO `tea_info` VALUES ('13', '武老师', '45', '男', '13700124070', '1719768112@qq.com', '四川省南充市', null, null, null, null, null);
INSERT INTO `tea_info` VALUES ('14', '静静W', '35', '女', '18709783412', '157@163.com', '四川省达州市', null, null, null, null, null);
INSERT INTO `tea_info` VALUES ('15', '敏Z', '28', '女', '17780858020', '126@', '四川省内江市', null, null, null, null, null);
INSERT INTO `tea_info` VALUES ('16', 'L刘', '36', '男', '15690236734', '756@qq.com', '四川省成都市', null, null, null, null, null);
INSERT INTO `tea_info` VALUES ('17', '黄天天', '35', '女', '15989781487', '', '', null, null, null, null, null);
INSERT INTO `tea_info` VALUES ('18', '飞燕', '25', '女', '18756241256', '187@qq.com', '四川省绵阳市', null, null, null, null, null);
INSERT INTO `tea_info` VALUES ('19', 'Lily', '30', '女', '18834508050', '188@qq.com', '四川省自贡市', null, null, null, null, null);
INSERT INTO `tea_info` VALUES ('20', 'Doctor', null, '男', null, null, null, null, null, null, null, null);
INSERT INTO `tea_info` VALUES ('21', 'Scalttle', '25', '女', '18756241256', '187@qq.com', '四川省绵阳市', null, null, null, null, null);
INSERT INTO `tea_info` VALUES ('22', 'Sum', '25', '女', '18834508050', '188@qq.com', '四川省自贡市', null, null, null, null, null);
INSERT INTO `tea_info` VALUES ('23', '雍惠', '25', '女', '18756241256', '187@qq.com', '四川省绵阳市', null, null, null, null, null);

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `user_name` varchar(20) default NULL,
  `password` varchar(20) default '111111',
  `create_time` datetime default NULL,
  `modify_time` datetime default NULL,
  `column1` varchar(22) default NULL,
  `column2` varchar(22) default NULL,
  `column3` varchar(22) default NULL,
  `column4` varchar(22) default NULL,
  `column5` varchar(22) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', '何老大', '321', '2019-09-03 09:45:00', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('2', '春春', '321', '2019-09-03 09:45:00', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('3', '军军', '12345322', '2019-09-03 13:58:00', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('4', '王', '123qwe', '2019-09-03 16:32:58', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('5', '笑容', '123456', '2019-09-04 10:08:00', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('6', '飞大哥', '123456', '2019-09-04 11:52:00', null, null, null, null, null, null);
INSERT INTO `user` VALUES ('7', '狗蛋', '123', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('8', '静静W', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('9', '狗蛋儿', '111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('10', '敏Z', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('11', '钟z', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('12', '钟zq', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('13', '武老', '123', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('14', '武老师', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('15', '敏W', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('16', 'L刘', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('17', '小李', 'qwe', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('18', '张正月', '321', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('19', '张居正', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('20', '张崔', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('21', '李莉莉', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('22', '李华', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('23', '赵华', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('24', '赵强', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('25', '赵婷婷', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('26', '黄婷', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('27', '左左', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('28', '桌子', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('29', '苏玉珍', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('30', '王宝强', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('31', '张三', '123', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('32', '邓强', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('33', '王亮', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('34', '唐仁河', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('35', '黄天天', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('36', 'lyf', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('37', '徐嘉伟', '123', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('38', 'test1', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('39', 'test2', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('40', 'test3', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('41', 'test4', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('42', 'test5', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('43', 'test6', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('44', 'qw', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('45', 'zhangsan', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('46', 'lisi', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('47', '王五', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('48', 'zhangsan', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('49', 'lisi', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('50', '王五', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('51', '飞燕', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('52', 'Lily', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('53', 'Doctor', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('54', 'AC卡卡', 'ac123456', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('55', 'AAA', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('56', 'BBB', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('57', 'CCC', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('58', 'DDD', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('59', 'Scalttle', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('60', 'Sum', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('61', '钟杰1', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('62', '李雨峰1', '111111', null, null, null, null, null, null, null);
INSERT INTO `user` VALUES ('63', '雍惠', '111111', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `user_role`
-- ----------------------------
DROP TABLE IF EXISTS `user_role`;
CREATE TABLE `user_role` (
  `id` int(11) NOT NULL auto_increment,
  `user_id` int(11) default NULL,
  `role_id` int(11) default NULL,
  `create_time` datetime default NULL,
  `modify_time` datetime default NULL,
  `column1` varchar(22) default NULL,
  `column2` varchar(22) default NULL,
  `column3` varchar(22) default NULL,
  `column4` varchar(22) default NULL,
  `column5` varchar(22) default NULL,
  PRIMARY KEY  (`id`),
  KEY `user_id` (`user_id`),
  KEY `role_id` (`role_id`)
) ENGINE=InnoDB AUTO_INCREMENT=59 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_role
-- ----------------------------
INSERT INTO `user_role` VALUES ('1', '7', '1', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('2', '4', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('3', '9', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('4', '1', '3', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('5', '17', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('6', '18', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('7', '19', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('8', '20', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('9', '21', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('10', '22', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('11', '23', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('12', '24', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('13', '25', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('14', '26', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('15', '27', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('16', '28', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('17', '29', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('18', '30', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('19', '31', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('20', '32', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('21', '33', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('22', '34', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('24', '2', '3', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('25', '3', '3', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('26', '5', '3', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('27', '6', '3', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('28', '8', '3', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('29', '10', '3', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('30', '11', '3', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('31', '12', '3', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('32', '13', '3', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('33', '14', '3', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('34', '16', '3', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('36', '35', '3', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('37', '36', '1', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('38', '37', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('39', '44', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('40', '45', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('41', '46', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('42', '47', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('43', '48', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('44', '49', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('45', '50', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('46', '51', '3', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('47', '52', '3', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('48', '53', '3', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('49', '54', '1', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('50', '55', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('51', '56', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('52', '57', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('53', '58', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('54', '59', '3', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('55', '60', '3', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('56', '61', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('57', '62', '2', null, null, null, null, null, null, null);
INSERT INTO `user_role` VALUES ('58', '63', '3', null, null, null, null, null, null, null);

-- ----------------------------
-- Table structure for `user_stu`
-- ----------------------------
DROP TABLE IF EXISTS `user_stu`;
CREATE TABLE `user_stu` (
  `id` int(11) NOT NULL auto_increment,
  `uid` int(11) default NULL,
  `sid` int(11) default NULL,
  `column1` varchar(22) default NULL,
  `column2` varchar(22) default NULL,
  `column3` varchar(22) default NULL,
  `column4` varchar(22) default NULL,
  `column5` varchar(22) default NULL,
  PRIMARY KEY  (`id`),
  KEY `uid` (`uid`),
  KEY `sid` (`sid`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_stu
-- ----------------------------
INSERT INTO `user_stu` VALUES ('1', '4', '1', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('2', '17', '2', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('3', '18', '3', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('4', '19', '4', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('5', '20', '5', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('6', '21', '6', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('7', '22', '7', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('8', '23', '8', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('9', '24', '9', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('10', '25', '10', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('11', '26', '11', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('12', '27', '12', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('13', '28', '13', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('14', '29', '14', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('15', '30', '15', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('16', '9', '16', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('17', '31', '17', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('18', '32', '18', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('19', '33', '19', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('20', '34', '20', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('21', '37', '21', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('22', '44', '22', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('23', '45', '35', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('24', '46', '36', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('25', '47', '37', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('26', '48', '38', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('27', '49', '39', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('28', '50', '40', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('29', '55', '41', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('30', '56', '42', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('31', '57', '43', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('32', '58', '44', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('33', '61', '45', null, null, null, null, null);
INSERT INTO `user_stu` VALUES ('34', '62', '46', null, null, null, null, null);

-- ----------------------------
-- Table structure for `user_tea`
-- ----------------------------
DROP TABLE IF EXISTS `user_tea`;
CREATE TABLE `user_tea` (
  `id` int(11) NOT NULL auto_increment,
  `uid` int(11) default NULL,
  `tid` int(11) default NULL,
  `column1` varchar(22) default NULL,
  `column2` varchar(22) default NULL,
  `column3` varchar(22) default NULL,
  `column4` varchar(22) default NULL,
  `column5` varchar(22) default NULL,
  PRIMARY KEY  (`id`),
  KEY `uid` (`uid`),
  KEY `tid` (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=20 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user_tea
-- ----------------------------
INSERT INTO `user_tea` VALUES ('1', '1', '1', null, null, null, null, null);
INSERT INTO `user_tea` VALUES ('2', '2', '2', null, null, null, null, null);
INSERT INTO `user_tea` VALUES ('3', '3', '3', null, null, null, null, null);
INSERT INTO `user_tea` VALUES ('4', '5', '4', null, null, null, null, null);
INSERT INTO `user_tea` VALUES ('5', '6', '5', null, null, null, null, null);
INSERT INTO `user_tea` VALUES ('6', '10', '15', null, null, null, null, null);
INSERT INTO `user_tea` VALUES ('7', '11', '10', null, null, null, null, null);
INSERT INTO `user_tea` VALUES ('8', '12', '11', null, null, null, null, null);
INSERT INTO `user_tea` VALUES ('9', '13', '12', null, null, null, null, null);
INSERT INTO `user_tea` VALUES ('10', '14', '13', null, null, null, null, null);
INSERT INTO `user_tea` VALUES ('11', '8', '14', null, null, null, null, null);
INSERT INTO `user_tea` VALUES ('12', '16', '16', null, null, null, null, null);
INSERT INTO `user_tea` VALUES ('13', '35', '17', null, null, null, null, null);
INSERT INTO `user_tea` VALUES ('14', '51', '18', null, null, null, null, null);
INSERT INTO `user_tea` VALUES ('15', '52', '19', null, null, null, null, null);
INSERT INTO `user_tea` VALUES ('16', '53', '20', null, null, null, null, null);
INSERT INTO `user_tea` VALUES ('17', '59', '21', null, null, null, null, null);
INSERT INTO `user_tea` VALUES ('18', '60', '22', null, null, null, null, null);
INSERT INTO `user_tea` VALUES ('19', '63', '23', null, null, null, null, null);
