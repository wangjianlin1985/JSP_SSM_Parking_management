/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50620
Source Host           : localhost:3306
Source Database       : ssm_depot_system

Target Server Type    : MYSQL
Target Server Version : 50620
File Encoding         : 65001

Date: 2020-02-05 14:09:39
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `card`
-- ----------------------------
DROP TABLE IF EXISTS `card`;
CREATE TABLE `card` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '停车场卡信息表',
  `cardnum` varchar(50) DEFAULT NULL COMMENT '卡号',
  `type` int(11) DEFAULT NULL COMMENT '卡类型',
  `money` double(11,2) DEFAULT '0.00' COMMENT '余额',
  `time` datetime DEFAULT NULL COMMENT '发卡时间',
  `islose` int(11) DEFAULT '0' COMMENT '是否挂失',
  `illegalcount` int(11) DEFAULT '0' COMMENT '违规次数',
  `carnum` varchar(50) DEFAULT NULL COMMENT '假如没有办卡那么就用车牌来标识',
  `deductedtime` datetime DEFAULT NULL COMMENT '扣费时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=18 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of card
-- ----------------------------
INSERT INTO `card` VALUES ('8', '1314938242720171217', '1', '456.00', '2017-12-17 11:03:40', '0', '0', null, null);
INSERT INTO `card` VALUES ('9', '1581345771220190221', '1', '242.00', '2017-12-25 19:37:53', '0', '0', null, null);
INSERT INTO `card` VALUES ('13', '1234567891020190220', '3', '8880.00', '2019-01-14 22:02:46', '0', '0', null, '2019-01-01 21:20:05');
INSERT INTO `card` VALUES ('17', '1302250240420190911', '2', '18080.00', '2019-09-11 15:35:49', '0', '0', null, '2019-09-11 15:35:49');

-- ----------------------------
-- Table structure for `cardtype`
-- ----------------------------
DROP TABLE IF EXISTS `cardtype`;
CREATE TABLE `cardtype` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '卡类型表',
  `type` varchar(50) DEFAULT NULL COMMENT '卡类型',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of cardtype
-- ----------------------------
INSERT INTO `cardtype` VALUES ('1', '普通卡');
INSERT INTO `cardtype` VALUES ('2', '月卡');
INSERT INTO `cardtype` VALUES ('3', '年卡');

-- ----------------------------
-- Table structure for `coupon`
-- ----------------------------
DROP TABLE IF EXISTS `coupon`;
CREATE TABLE `coupon` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `couponNum` varchar(255) DEFAULT NULL COMMENT '优惠券号码',
  `money` int(11) DEFAULT NULL COMMENT '优惠金额',
  `cardnum` varchar(255) DEFAULT NULL COMMENT '卡号',
  `time` datetime DEFAULT NULL COMMENT '过期时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of coupon
-- ----------------------------
INSERT INTO `coupon` VALUES ('4', '8684914d6c5345078acaea7d261a3ba5', '100', '1234567891020190220', '2019-02-01 21:11:11');
INSERT INTO `coupon` VALUES ('6', '637e3324ac544c3481d5e23049956976', '100', '1314938242720171217', '2019-02-20 13:18:19');

-- ----------------------------
-- Table structure for `depotinfo`
-- ----------------------------
DROP TABLE IF EXISTS `depotinfo`;
CREATE TABLE `depotinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '停车场信息表',
  `hourmoney` varchar(50) DEFAULT NULL COMMENT '停车场名',
  `monthcard` varchar(50) DEFAULT NULL COMMENT '停车场电话',
  `yearcard` varchar(255) DEFAULT NULL COMMENT '停车场地址',
  `illegal` varchar(255) DEFAULT NULL COMMENT '总车位',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of depotinfo
-- ----------------------------
INSERT INTO `depotinfo` VALUES ('1', '10', '1920', '21120', '50');

-- ----------------------------
-- Table structure for `email`
-- ----------------------------
DROP TABLE IF EXISTS `email`;
CREATE TABLE `email` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `sendid` int(11) DEFAULT NULL COMMENT '发送方',
  `toid` int(11) DEFAULT NULL COMMENT '接收方',
  `title` varchar(255) DEFAULT NULL COMMENT '标题',
  `content` varchar(255) DEFAULT NULL COMMENT '内容',
  `time` datetime DEFAULT NULL COMMENT '发送时间',
  `managerisread` int(11) DEFAULT '0',
  `userisread` int(11) DEFAULT '0' COMMENT '是否被读',
  `userdeleted` int(11) DEFAULT '0',
  `managedelete` int(11) DEFAULT '0',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of email
-- ----------------------------
INSERT INTO `email` VALUES ('1', '16', '0', '213231', '213213132', '2019-01-28 11:50:52', '2', '1', '0', '0');
INSERT INTO `email` VALUES ('3', '1', '16', '回复：213231', '555555555', '2019-01-28 20:54:32', '0', '1', '1', '1');
INSERT INTO `email` VALUES ('4', '16', '0', '12312', '3121233', '2019-02-21 20:44:38', '1', '0', '0', '1');
INSERT INTO `email` VALUES ('5', '16', '0', '444', 'stupid', '2019-02-21 20:46:17', '2', '0', '0', '0');
INSERT INTO `email` VALUES ('6', '1', '16', '回复：444', 'ok', '2019-02-21 20:47:12', '0', '1', '0', '0');
INSERT INTO `email` VALUES ('7', '16', '0', '5555', '222', '2019-02-21 20:48:18', '2', '0', '0', '0');
INSERT INTO `email` VALUES ('8', '2', '16', '回复：5555', 'ok', '2019-02-21 20:48:41', '0', '1', '0', '0');
INSERT INTO `email` VALUES ('9', '16', '0', 'test1', 'test1', '2019-02-21 21:33:13', '2', '0', '0', '0');
INSERT INTO `email` VALUES ('10', '16', '0', 'test2', 'test2', '2019-02-21 21:33:22', '0', '0', '0', '0');
INSERT INTO `email` VALUES ('11', '1', '16', '回复：test1', '123761238762381', '2019-02-21 21:38:27', '0', '0', '0', '0');
INSERT INTO `email` VALUES ('12', '10', '0', '12', '12', '2019-09-11 15:22:16', '0', '0', '1', '0');
INSERT INTO `email` VALUES ('13', '10', '0', '关于价格问题', '这个多次是否有优惠呢？', '2019-09-11 15:22:52', '0', '0', '0', '0');

-- ----------------------------
-- Table structure for `illegalinfo`
-- ----------------------------
DROP TABLE IF EXISTS `illegalinfo`;
CREATE TABLE `illegalinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cardnum` varchar(255) DEFAULT NULL COMMENT '停车卡号',
  `illegalInfo` varchar(255) DEFAULT NULL COMMENT '违规信息',
  `parkin` datetime DEFAULT NULL,
  `time` datetime DEFAULT NULL COMMENT '违规时间',
  `uid` int(11) DEFAULT '0' COMMENT '添加的管理员',
  `carnum` varchar(255) DEFAULT NULL COMMENT '车牌号，临时停车的话用车牌号记录',
  `deleted` char(10) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of illegalinfo
-- ----------------------------
INSERT INTO `illegalinfo` VALUES ('3', '1581345771220190221', 'asdjkasdhadskjhasdkjkjhasdkjasdhkjdshasdjkhasdhadsjkhasdkj', '2019-01-01 11:45:04', '2019-01-01 17:45:44', '1', 'sadsajkhdaskj', 'N');
INSERT INTO `illegalinfo` VALUES ('6', '1314938242720171217', '123321321312', '2019-02-01 20:28:26', '2019-02-01 20:38:16', '1', '1231312', 'N');
INSERT INTO `illegalinfo` VALUES ('7', '1314938242720171217', '12331132', '2019-02-01 20:57:35', '2019-02-01 21:04:33', '1', '213312', 'N');
INSERT INTO `illegalinfo` VALUES ('8', '1581345771220190221', '213123123123', '2019-02-06 20:53:54', '2019-02-06 20:54:08', '1', '123123321', 'N');
INSERT INTO `illegalinfo` VALUES ('9', '1581345771220190221', '123123', '2019-02-06 20:54:45', '2019-02-06 20:54:49', '1', '123123312', 'N');
INSERT INTO `illegalinfo` VALUES ('10', '1581345771220190221', '123213', '2019-02-06 20:55:52', '2019-02-06 20:55:55', '1', '123123213', 'N');
INSERT INTO `illegalinfo` VALUES ('11', '1581345771220190221', '123123', '2019-02-06 20:57:37', '2019-02-06 20:57:42', '1', '123213321', 'N');
INSERT INTO `illegalinfo` VALUES ('12', '1581345771220190221', '213321213', '2019-02-06 21:00:12', '2019-02-06 21:00:16', '1', '12312', 'N');
INSERT INTO `illegalinfo` VALUES ('13', '1581345771220190221', '123213132132', '2019-02-06 21:01:20', '2019-02-06 21:01:25', '1', '12321321321', 'N');
INSERT INTO `illegalinfo` VALUES ('14', '1581345771220190221', '123213', '2019-02-06 21:02:07', '2019-02-06 21:02:11', '1', '123132321231', 'N');
INSERT INTO `illegalinfo` VALUES ('15', '1581345771220190221', '1221', '2019-02-06 21:03:25', '2019-02-06 21:03:29', '1', '123123', 'N');
INSERT INTO `illegalinfo` VALUES ('16', '1581345771220190221', '12312132', '2019-02-06 21:13:19', '2019-02-06 21:13:23', '1', '123123312213', 'N');
INSERT INTO `illegalinfo` VALUES ('17', '1581345771220190221', '12321321321', '2019-02-06 21:15:48', '2019-02-06 21:15:52', '1', '123123312123', 'N');
INSERT INTO `illegalinfo` VALUES ('18', '1581345771220190221', '213321321', '2019-02-06 21:18:03', '2019-02-06 21:18:07', '1', '213321321', 'N');
INSERT INTO `illegalinfo` VALUES ('19', '1581345771220190221', '312132312', '2019-02-06 21:24:47', '2019-02-06 21:25:03', '1', '123321231213', 'N');
INSERT INTO `illegalinfo` VALUES ('20', '7458214563220190206', '132123', '2019-02-11 21:07:45', '2019-02-11 21:07:51', '1', '213312132312', 'N');

-- ----------------------------
-- Table structure for `income`
-- ----------------------------
DROP TABLE IF EXISTS `income`;
CREATE TABLE `income` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `money` double(20,2) DEFAULT '0.00' COMMENT '收入',
  `method` int(11) DEFAULT '0' COMMENT '收入方式（0现金，1支付宝，2微信，9从卡中扣费）',
  `type` int(11) DEFAULT '0' COMMENT '收入类型（0临时停车，1普通卡，2月卡，3年卡）',
  `carnum` varchar(255) DEFAULT NULL,
  `cardnum` varchar(255) DEFAULT NULL,
  `isillegal` int(11) DEFAULT '0' COMMENT '是否有违规',
  `source` int(11) DEFAULT '1' COMMENT '收入来源，0充值卡，1出库收费',
  `time` datetime DEFAULT NULL COMMENT '收入时间',
  `duration` bigint(20) DEFAULT NULL COMMENT '停车时长',
  `trueincome` int(5) DEFAULT '0' COMMENT '是否真正收入（0：否，1：是）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of income
-- ----------------------------
INSERT INTO `income` VALUES ('32', '456.00', '1', '1', null, '1314938242720171217', '0', '0', '2019-12-06 20:51:54', '0', '0');
INSERT INTO `income` VALUES ('33', '300.00', '1', '1', null, '1581345771220190221', '0', '0', '2019-02-06 20:53:26', '0', '0');
INSERT INTO `income` VALUES ('34', '58.00', '9', '1', '12312', '1581345771220190221', '1', '1', '2019-02-06 21:00:19', '1', '1');
INSERT INTO `income` VALUES ('35', '58.00', '9', '1', '12321321321', '1581345771220190221', '1', '1', '2019-02-06 21:01:42', '1', '1');
INSERT INTO `income` VALUES ('36', '58.00', '9', '1', '123132321231', '1581345771220190221', '1', '1', '2019-02-06 21:02:45', '1', '1');
INSERT INTO `income` VALUES ('37', '58.00', '9', '1', '123123', '1581345771220190221', '1', '1', '2019-02-06 21:03:41', '1', '1');
INSERT INTO `income` VALUES ('38', '58.00', '9', '1', '123123312213', '1581345771220190221', '1', '1', '2019-02-06 21:13:46', '1', '1');
INSERT INTO `income` VALUES ('39', '58.00', '9', '1', '123123312123', '1581345771220190221', '1', '1', '2019-02-06 21:16:08', '1', '1');
INSERT INTO `income` VALUES ('40', '58.00', '9', '1', '213321321', '1581345771220190221', '1', '1', '2019-02-06 21:18:16', '1', '1');
INSERT INTO `income` VALUES ('41', '58.00', '9', '1', '213312132312', '7458214563220190206', '1', '1', '2019-02-11 21:08:56', '2', '0');
INSERT INTO `income` VALUES ('42', '10.00', '0', '0', '213123123', '', '0', '1', '2019-02-20 10:31:06', '9', '0');
INSERT INTO `income` VALUES ('43', '10.00', '9', '0', '12', '', '0', '1', '2019-09-11 15:24:41', '1', '0');
INSERT INTO `income` VALUES ('44', '1920.00', '1', '2', null, '1302250240420190911', '0', '0', '2019-09-11 15:35:49', '0', '0');

-- ----------------------------
-- Table structure for `parkinfo`
-- ----------------------------
DROP TABLE IF EXISTS `parkinfo`;
CREATE TABLE `parkinfo` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `parknum` int(11) DEFAULT NULL COMMENT '停车位号，对应parkspace的parkid',
  `cardnum` varchar(50) DEFAULT NULL COMMENT '卡号',
  `carnum` varchar(50) DEFAULT NULL COMMENT '车牌号',
  `parkin` datetime DEFAULT NULL COMMENT '停入时间',
  `parktemp` int(11) DEFAULT '0' COMMENT '0正常停车，1临时停车',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parkinfo
-- ----------------------------
INSERT INTO `parkinfo` VALUES ('21', '1', '', '苏A12345', '2019-09-11 15:25:09', '1');
INSERT INTO `parkinfo` VALUES ('22', '2', '', '苏A12312', '2019-09-11 15:27:10', '1');

-- ----------------------------
-- Table structure for `parkinfoall`
-- ----------------------------
DROP TABLE IF EXISTS `parkinfoall`;
CREATE TABLE `parkinfoall` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cardnum` varchar(255) DEFAULT NULL,
  `parknum` int(11) DEFAULT NULL,
  `carnum` varchar(255) DEFAULT NULL,
  `parkin` datetime DEFAULT NULL,
  `parkout` datetime DEFAULT NULL,
  `parktemp` int(11) DEFAULT '0' COMMENT '0正常停车，1临时停车',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parkinfoall
-- ----------------------------
INSERT INTO `parkinfoall` VALUES ('1', '21312', '321', '123', '2019-01-03 15:14:12', '2019-01-01 15:14:15', '0');
INSERT INTO `parkinfoall` VALUES ('3', '1581345771220190221', '1', 'sadsajkhdaskj', '2019-01-01 11:45:04', '2019-01-07 21:42:59', '0');
INSERT INTO `parkinfoall` VALUES ('4', '1314938242720171217', '1', 'qwe5646', '2019-01-14 19:43:19', '2019-01-21 17:48:12', '0');
INSERT INTO `parkinfoall` VALUES ('5', '1314938242720171217', '1', '1212123132', '2019-02-01 19:34:01', '2019-02-01 19:45:52', '0');
INSERT INTO `parkinfoall` VALUES ('6', '1314938242720171217', '1', 'sadasdas', '2019-02-01 20:02:47', '2019-02-01 20:27:41', '0');
INSERT INTO `parkinfoall` VALUES ('7', '1314938242720171217', '1', '1231312', '2019-02-01 20:28:26', '2019-02-01 20:49:11', '0');
INSERT INTO `parkinfoall` VALUES ('8', '1314938242720171217', '1', '213312', '2019-02-01 20:57:35', '2019-02-01 21:10:38', '0');
INSERT INTO `parkinfoall` VALUES ('9', '1234567891020190220', '1', '123123', '2019-02-04 21:16:04', '2019-02-04 21:20:21', '0');
INSERT INTO `parkinfoall` VALUES ('10', '1581345771220190221', '1', '123123321', '2019-02-06 20:53:54', '2019-02-06 20:54:14', '0');
INSERT INTO `parkinfoall` VALUES ('11', '1581345771220190221', '1', '123123312', '2019-02-06 20:54:45', '2019-02-06 20:54:52', '0');
INSERT INTO `parkinfoall` VALUES ('12', '1581345771220190221', '1', '123123213', '2019-02-06 20:55:52', '2019-02-06 20:55:59', '0');
INSERT INTO `parkinfoall` VALUES ('13', '1581345771220190221', '1', '123213321', '2019-02-06 20:57:37', '2019-02-06 20:58:59', '0');
INSERT INTO `parkinfoall` VALUES ('14', '1581345771220190221', '1', '12312', '2019-02-06 21:00:12', '2019-02-06 21:00:19', '0');
INSERT INTO `parkinfoall` VALUES ('15', '1581345771220190221', '1', '12321321321', '2019-02-06 21:01:20', '2019-02-06 21:01:42', '0');
INSERT INTO `parkinfoall` VALUES ('16', '1581345771220190221', '1', '123132321231', '2019-02-06 21:02:07', '2019-02-06 21:02:45', '0');
INSERT INTO `parkinfoall` VALUES ('17', '1581345771220190221', '1', '123123', '2019-02-06 21:03:25', '2019-02-06 21:03:41', '0');
INSERT INTO `parkinfoall` VALUES ('18', '1581345771220190221', '1', '123123312213', '2019-02-06 21:13:19', '2019-02-06 21:13:46', '0');
INSERT INTO `parkinfoall` VALUES ('19', '1581345771220190221', '1', '123123312123', '2019-02-06 21:15:48', '2019-02-06 21:16:08', '0');
INSERT INTO `parkinfoall` VALUES ('20', '1581345771220190221', '1', '213321321', '2019-02-06 21:18:03', '2019-02-06 21:18:16', '0');
INSERT INTO `parkinfoall` VALUES ('21', '1581345771220190221', '1', '123321231213', '2019-02-06 21:24:47', '2019-02-06 21:25:07', '0');
INSERT INTO `parkinfoall` VALUES ('22', '7458214563220190206', '1', '213312132312', '2019-02-11 21:07:45', '2019-02-11 21:08:56', '0');
INSERT INTO `parkinfoall` VALUES ('23', '', '1', '213123123', '2019-02-20 10:22:21', '2019-02-20 10:31:06', '0');
INSERT INTO `parkinfoall` VALUES ('24', '', '1', '12', '2019-09-11 15:24:26', '2019-09-11 15:24:41', '0');

-- ----------------------------
-- Table structure for `parkspace`
-- ----------------------------
DROP TABLE IF EXISTS `parkspace`;
CREATE TABLE `parkspace` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '停车位表',
  `parkid` int(11) DEFAULT NULL COMMENT '车位号',
  `status` int(11) DEFAULT '0' COMMENT '是否停车',
  `tag` int(11) DEFAULT '1' COMMENT '停车类型，1：正常，2：临时，3紧急',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=101 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of parkspace
-- ----------------------------
INSERT INTO `parkspace` VALUES ('1', '1', '1', '1');
INSERT INTO `parkspace` VALUES ('2', '2', '1', '1');
INSERT INTO `parkspace` VALUES ('3', '3', '0', '1');
INSERT INTO `parkspace` VALUES ('4', '4', '0', '1');
INSERT INTO `parkspace` VALUES ('5', '5', '0', '1');
INSERT INTO `parkspace` VALUES ('6', '6', '0', '1');
INSERT INTO `parkspace` VALUES ('7', '7', '0', '1');
INSERT INTO `parkspace` VALUES ('8', '8', '0', '1');
INSERT INTO `parkspace` VALUES ('9', '9', '0', '1');
INSERT INTO `parkspace` VALUES ('10', '10', '0', '1');
INSERT INTO `parkspace` VALUES ('11', '11', '0', '1');
INSERT INTO `parkspace` VALUES ('12', '12', '0', '1');
INSERT INTO `parkspace` VALUES ('13', '13', '0', '1');
INSERT INTO `parkspace` VALUES ('14', '14', '0', '1');
INSERT INTO `parkspace` VALUES ('15', '15', '0', '1');
INSERT INTO `parkspace` VALUES ('16', '16', '0', '1');
INSERT INTO `parkspace` VALUES ('17', '17', '0', '1');
INSERT INTO `parkspace` VALUES ('18', '18', '0', '1');
INSERT INTO `parkspace` VALUES ('19', '19', '0', '1');
INSERT INTO `parkspace` VALUES ('20', '20', '0', '1');
INSERT INTO `parkspace` VALUES ('21', '21', '0', '1');
INSERT INTO `parkspace` VALUES ('22', '22', '0', '1');
INSERT INTO `parkspace` VALUES ('23', '23', '0', '1');
INSERT INTO `parkspace` VALUES ('24', '24', '0', '1');
INSERT INTO `parkspace` VALUES ('25', '25', '0', '1');
INSERT INTO `parkspace` VALUES ('26', '26', '0', '1');
INSERT INTO `parkspace` VALUES ('27', '27', '0', '1');
INSERT INTO `parkspace` VALUES ('28', '28', '0', '1');
INSERT INTO `parkspace` VALUES ('29', '29', '0', '1');
INSERT INTO `parkspace` VALUES ('30', '30', '0', '1');
INSERT INTO `parkspace` VALUES ('31', '31', '0', '1');
INSERT INTO `parkspace` VALUES ('32', '32', '0', '1');
INSERT INTO `parkspace` VALUES ('33', '33', '0', '1');
INSERT INTO `parkspace` VALUES ('34', '34', '0', '1');
INSERT INTO `parkspace` VALUES ('35', '35', '0', '1');
INSERT INTO `parkspace` VALUES ('36', '36', '0', '1');
INSERT INTO `parkspace` VALUES ('37', '37', '0', '1');
INSERT INTO `parkspace` VALUES ('38', '38', '0', '1');
INSERT INTO `parkspace` VALUES ('39', '39', '0', '1');
INSERT INTO `parkspace` VALUES ('40', '40', '0', '1');
INSERT INTO `parkspace` VALUES ('41', '41', '0', '1');
INSERT INTO `parkspace` VALUES ('42', '42', '0', '1');
INSERT INTO `parkspace` VALUES ('43', '43', '0', '1');
INSERT INTO `parkspace` VALUES ('44', '44', '0', '1');
INSERT INTO `parkspace` VALUES ('45', '45', '0', '1');
INSERT INTO `parkspace` VALUES ('46', '46', '0', '1');
INSERT INTO `parkspace` VALUES ('47', '47', '0', '1');
INSERT INTO `parkspace` VALUES ('48', '48', '0', '1');
INSERT INTO `parkspace` VALUES ('49', '49', '0', '1');
INSERT INTO `parkspace` VALUES ('50', '50', '0', '1');
INSERT INTO `parkspace` VALUES ('51', '51', '0', '1');
INSERT INTO `parkspace` VALUES ('52', '52', '0', '1');
INSERT INTO `parkspace` VALUES ('53', '53', '0', '1');
INSERT INTO `parkspace` VALUES ('54', '54', '0', '1');
INSERT INTO `parkspace` VALUES ('55', '55', '0', '1');
INSERT INTO `parkspace` VALUES ('56', '56', '0', '1');
INSERT INTO `parkspace` VALUES ('57', '57', '0', '1');
INSERT INTO `parkspace` VALUES ('58', '58', '0', '1');
INSERT INTO `parkspace` VALUES ('59', '59', '0', '1');
INSERT INTO `parkspace` VALUES ('60', '60', '0', '1');
INSERT INTO `parkspace` VALUES ('61', '61', '0', '1');
INSERT INTO `parkspace` VALUES ('62', '62', '0', '1');
INSERT INTO `parkspace` VALUES ('63', '63', '0', '1');
INSERT INTO `parkspace` VALUES ('64', '64', '0', '1');
INSERT INTO `parkspace` VALUES ('65', '65', '0', '1');
INSERT INTO `parkspace` VALUES ('66', '66', '0', '1');
INSERT INTO `parkspace` VALUES ('67', '67', '0', '1');
INSERT INTO `parkspace` VALUES ('68', '68', '0', '1');
INSERT INTO `parkspace` VALUES ('69', '69', '0', '1');
INSERT INTO `parkspace` VALUES ('70', '70', '0', '2');
INSERT INTO `parkspace` VALUES ('71', '71', '0', '2');
INSERT INTO `parkspace` VALUES ('72', '72', '0', '2');
INSERT INTO `parkspace` VALUES ('73', '73', '0', '2');
INSERT INTO `parkspace` VALUES ('74', '74', '0', '2');
INSERT INTO `parkspace` VALUES ('75', '75', '0', '2');
INSERT INTO `parkspace` VALUES ('76', '76', '0', '2');
INSERT INTO `parkspace` VALUES ('77', '77', '0', '2');
INSERT INTO `parkspace` VALUES ('78', '78', '0', '2');
INSERT INTO `parkspace` VALUES ('79', '79', '0', '2');
INSERT INTO `parkspace` VALUES ('80', '80', '0', '2');
INSERT INTO `parkspace` VALUES ('81', '81', '0', '2');
INSERT INTO `parkspace` VALUES ('82', '82', '0', '2');
INSERT INTO `parkspace` VALUES ('83', '83', '0', '2');
INSERT INTO `parkspace` VALUES ('84', '84', '0', '2');
INSERT INTO `parkspace` VALUES ('85', '85', '0', '2');
INSERT INTO `parkspace` VALUES ('86', '86', '0', '2');
INSERT INTO `parkspace` VALUES ('87', '87', '0', '2');
INSERT INTO `parkspace` VALUES ('88', '88', '0', '2');
INSERT INTO `parkspace` VALUES ('89', '89', '0', '2');
INSERT INTO `parkspace` VALUES ('90', '90', '0', '2');
INSERT INTO `parkspace` VALUES ('91', '91', '0', '3');
INSERT INTO `parkspace` VALUES ('92', '92', '0', '3');
INSERT INTO `parkspace` VALUES ('93', '93', '0', '3');
INSERT INTO `parkspace` VALUES ('94', '94', '0', '3');
INSERT INTO `parkspace` VALUES ('95', '95', '0', '3');
INSERT INTO `parkspace` VALUES ('96', '96', '0', '3');
INSERT INTO `parkspace` VALUES ('97', '97', '0', '3');
INSERT INTO `parkspace` VALUES ('98', '98', '0', '3');
INSERT INTO `parkspace` VALUES ('99', '99', '0', '3');
INSERT INTO `parkspace` VALUES ('100', '100', '0', '3');

-- ----------------------------
-- Table structure for `user`
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '人员信息表',
  `username` varchar(50) DEFAULT NULL COMMENT '用户名',
  `name` varchar(50) DEFAULT NULL COMMENT '姓名',
  `password` varchar(50) DEFAULT NULL COMMENT '密码',
  `sex` varchar(10) DEFAULT '男' COMMENT '性别',
  `tel` varchar(50) DEFAULT '' COMMENT '联系电话',
  `role` int(11) DEFAULT '3' COMMENT '权限/职位（1超级管理员，2管理员，3用户）',
  `cardid` int(11) DEFAULT '0' COMMENT '停车场卡（停车用户才有的）',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=25 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('1', 'admin', '张三', 'admin', '女', '13149382427', '1', '0');
INSERT INTO `user` VALUES ('2', 'yuanma', '李四', '123456', '男', '13149382427', '2', '0');
INSERT INTO `user` VALUES ('10', 'matou', 'www', '123456', '女', '13149382427', '3', '8');
INSERT INTO `user` VALUES ('15', 'wangwu', 'wangwu', 'abcisme123', '男', null, '1', '0');
INSERT INTO `user` VALUES ('16', '15813457712', 'EX', '15813457712', '男', '15813457712', '3', '9');
INSERT INTO `user` VALUES ('20', '12345678910', 'ee', '12345678910', '男', '12345678910', '3', '13');
INSERT INTO `user` VALUES ('24', '13022502404', 'yanmamatou', '13022502404', '男', '13022502404', '3', '17');
