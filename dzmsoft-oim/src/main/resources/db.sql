/*
Navicat MySQL Data Transfer

Source Server         : dzmtsm
Source Server Version : 50166
Source Host           : localhost:3306
Source Database       : walle

Target Server Type    : MYSQL
Target Server Version : 50166
File Encoding         : 65001

Date: 2016-01-13 17:14:07
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for `oim_ad_article`
-- ----------------------------
DROP TABLE IF EXISTS `oim_ad_article`;
CREATE TABLE `oim_ad_article` (
  `id` char(32) NOT NULL COMMENT 'ID',
  `column_id` char(6) NOT NULL COMMENT '栏目',
  `short_title` varchar(30) NOT NULL COMMENT '短标题',
  `long_title` varchar(100) DEFAULT NULL COMMENT '长标题',
  `pic_title` varchar(100) DEFAULT NULL COMMENT '图片标题',
  `context` text COMMENT '内容',
  `summary` varchar(100) DEFAULT NULL COMMENT '摘要',
  `status` char(2) NOT NULL COMMENT '状态',
  `creator` char(32) NOT NULL COMMENT '创建者',
  `create_time` datetime NOT NULL COMMENT '创建时间',
  `deploy_time` datetime DEFAULT NULL COMMENT '发布时间',
  `updator` char(32) DEFAULT NULL COMMENT '修改者',
  `update_time` datetime DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告文章';

-- ----------------------------
-- Records of oim_ad_article
-- ----------------------------
INSERT INTO `oim_ad_article` VALUES ('121534b1ce654ce5a3eb9d54a7afd9d2', '010001', '欢迎页面4', '', '2016-01-05\\2指纹登陆.jpg', '&lt;p&gt;http://localhost:8096/hko&lt;/p&gt;', '', '00', '00000000000000000000000000000000', '2016-01-05 17:39:41', null, null, null);
INSERT INTO `oim_ad_article` VALUES ('e80ee0a51d994a948328a998af6105f5', '010001', '欢迎页面1', '', '', '&lt;p&gt;&lt;img src=&quot;http://localhost:8096/hko/ueditor/jsp/upload/image/20160104/1451882202675012701.png&quot; title=&quot;1451882202675012701.png&quot; alt=&quot;QQ图片20151021105448.png&quot;/&gt;&lt;/p&gt;', '', '00', '00000000000000000000000000000000', '2016-01-04 12:36:44', null, null, null);
INSERT INTO `oim_ad_article` VALUES ('edc8d08b2b474a3ba9cc27778a69737c', '010001', '欢迎页面2', '', '', '&lt;p&gt;ueditor&lt;/p&gt;', '', '00', '00000000000000000000000000000000', '2016-01-04 13:51:15', null, null, null);
INSERT INTO `oim_ad_article` VALUES ('fa747651d8c74a4393553f1038a0e067', '010001', '欢迎页面3', '', '2016-01-04\\1登陆.jpg', '', '', '00', '00000000000000000000000000000000', '2016-01-04 14:30:42', null, null, null);

-- ----------------------------
-- Table structure for `oim_ad_position`
-- ----------------------------
DROP TABLE IF EXISTS `oim_ad_position`;
CREATE TABLE `oim_ad_position` (
  `id` char(6) NOT NULL COMMENT 'ID',
  `name` varchar(20) NOT NULL COMMENT '栏目名称',
  `pid` char(6) DEFAULT NULL COMMENT '上级栏目',
  `status` char(2) NOT NULL COMMENT '状态',
  `description` varchar(200) DEFAULT NULL COMMENT '描述',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告位';

-- ----------------------------
-- Records of oim_ad_position
-- ----------------------------
INSERT INTO `oim_ad_position` VALUES ('010000', '手机客户端', '000000', '01', '');
INSERT INTO `oim_ad_position` VALUES ('010001', '欢迎页面', '010000', '01', null);

-- ----------------------------
-- Table structure for `oim_ad_region`
-- ----------------------------
DROP TABLE IF EXISTS `oim_ad_region`;
CREATE TABLE `oim_ad_region` (
  `id` char(32) NOT NULL COMMENT 'ID',
  `admin_region_id` varchar(32) NOT NULL COMMENT '行政区域',
  `ad_article_id` char(32) NOT NULL COMMENT '广告文章',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='广告所属行政区域';

-- ----------------------------
-- Records of oim_ad_region
-- ----------------------------

-- ----------------------------
-- Table structure for `oim_employee`
-- ----------------------------
DROP TABLE IF EXISTS `oim_employee`;
CREATE TABLE `oim_employee` (
  `id` int(12) unsigned zerofill NOT NULL AUTO_INCREMENT COMMENT '认证编号',
  `name` varchar(20) NOT NULL COMMENT '姓名',
  `sex` char(1) NOT NULL COMMENT '性别 0：女 1：男',
  `birthday` date NOT NULL COMMENT '出生日期',
  `description` varchar(500) DEFAULT NULL COMMENT '员工简介',
  `id_card` varchar(18) NOT NULL COMMENT '身份证号',
  `qrcode` varchar(100) DEFAULT NULL COMMENT '二维码',
  `pic` varchar(100) DEFAULT NULL COMMENT '个人照片',
  `ucs_id` char(32) DEFAULT NULL,
  `mobile` char(11) NOT NULL COMMENT '手机号',
  `pic_name` varchar(30) DEFAULT NULL COMMENT '个人图片名称',
  `status` char(2) NOT NULL COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COMMENT='员工';

-- ----------------------------
-- Records of oim_employee
-- ----------------------------
INSERT INTO `oim_employee` VALUES ('000000000002', '邓俊', '1', '2016-01-13', '', '421126198508081118', null, '2016-01-13/df2a0f2bbfae436696a902311dff41d5.jpg', null, '15071090829', '6充话费.jpg', '01');

-- ----------------------------
-- Table structure for `oim_mall_category`
-- ----------------------------
DROP TABLE IF EXISTS `oim_mall_category`;
CREATE TABLE `oim_mall_category` (
  `id` char(6) NOT NULL COMMENT '分类编号',
  `pid` char(32) DEFAULT NULL COMMENT '上级分类',
  `name` varchar(16) NOT NULL COMMENT '分类名称',
  `site_resource_path` varchar(128) DEFAULT NULL COMMENT '网页图标文件路径',
  `phone_resource_path` varchar(128) DEFAULT NULL COMMENT '手机端图标路径',
  `status` char(2) NOT NULL DEFAULT '01' COMMENT '状态',
  `sort` int(2) NOT NULL COMMENT '排序',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='商品分类';

-- ----------------------------
-- Records of oim_mall_category
-- ----------------------------
INSERT INTO `oim_mall_category` VALUES ('000001', '', '保洁商品分类', null, null, '01', '1');
INSERT INTO `oim_mall_category` VALUES ('000002', '000001', '清洁用品', '2016-01-13/60bdbb41e41246aca9f6375e313e6885.jpg', '2016-01-13/47a5dcdedb424af6971131b1fc901869.jpg', '01', '2');

-- ----------------------------
-- Table structure for `oim_member`
-- ----------------------------
DROP TABLE IF EXISTS `oim_member`;
CREATE TABLE `oim_member` (
  `id` char(32) NOT NULL COMMENT 'ID',
  `name` varchar(50) NOT NULL COMMENT '姓名',
  `sex` char(1) NOT NULL COMMENT '性别',
  `mobile` varchar(20) DEFAULT NULL COMMENT '手机号',
  `ucs_id` char(32) DEFAULT NULL COMMENT '用户ID',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员信息';

-- ----------------------------
-- Records of oim_member
-- ----------------------------

-- ----------------------------
-- Table structure for `oim_member_address`
-- ----------------------------
DROP TABLE IF EXISTS `oim_member_address`;
CREATE TABLE `oim_member_address` (
  `id` char(21) NOT NULL COMMENT 'ID',
  `is_default` char(1) NOT NULL DEFAULT '0' COMMENT '默认',
  `city` char(6) NOT NULL COMMENT '市',
  `division` char(6) NOT NULL COMMENT '区',
  `short_address` varchar(20) NOT NULL COMMENT '短地址',
  `long_address` varchar(50) DEFAULT NULL COMMENT '长地址',
  `ucs_id` char(32) DEFAULT NULL COMMENT '会员',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='会员服务地址';

-- ----------------------------
-- Records of oim_member_address
-- ----------------------------
