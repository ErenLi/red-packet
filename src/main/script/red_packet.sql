/*
Navicat MySQL Data Transfer

Source Server         : root
Source Server Version : 50515
Source Host           : localhost:3306
Source Database       : red_packet

Target Server Type    : MYSQL
Target Server Version : 50515
File Encoding         : 65001

Date: 2018-09-16 18:53:20
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for t_red_packet
-- ----------------------------
DROP TABLE IF EXISTS `t_red_packet`;
CREATE TABLE `t_red_packet` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `user_id` int(12) NOT NULL,
  `amount` decimal(16,2) NOT NULL,
  `send_date` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `total` int(12) NOT NULL,
  `unit_amount` decimal(12,2) NOT NULL,
  `stock` int(12) NOT NULL,
  `version` int(12) NOT NULL DEFAULT '0',
  `note` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for t_user_red_packet
-- ----------------------------
DROP TABLE IF EXISTS `t_user_red_packet`;
CREATE TABLE `t_user_red_packet` (
  `id` int(12) NOT NULL AUTO_INCREMENT,
  `red_packet_id` int(12) NOT NULL,
  `user_id` int(12) NOT NULL,
  `amount` decimal(16,2) NOT NULL,
  `grab_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `note` varchar(256) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8mb4;


INSERT INTO `red_packet`.`t_red_packet` (`id`, `user_id`, `amount`, `send_date`, `total`, `unit_amount`, `stock`, `version`, `note`) VALUES ('1', '1', '200000.00', '2018-09-16 18:33:02', '20000', '10.00', '20000', '0', '20万元金额，2万个小红包，每个10元');
INSERT INTO `red_packet`.`t_red_packet` (`id`, `user_id`, `amount`, `send_date`, `total`, `unit_amount`, `stock`, `version`, `note`) VALUES ('2', '1', '200000.00', '2018-09-16 18:36:05', '20000', '10.00', '20000', '0', '20万元金额，2万个小红包，每个10元');
INSERT INTO `red_packet`.`t_red_packet` (`id`, `user_id`, `amount`, `send_date`, `total`, `unit_amount`, `stock`, `version`, `note`) VALUES ('3', '1', '200000.00', '2018-09-16 18:38:49', '20000', '10.00', '20000', '16974', '20万元金额，2万个小红包，每个10元');
INSERT INTO `red_packet`.`t_red_packet` (`id`, `user_id`, `amount`, `send_date`, `total`, `unit_amount`, `stock`, `version`, `note`) VALUES ('4', '1', '200000.00', '2018-09-16 18:52:10', '20000', '10.00', '20000', '20000', '20万元金额，2万个小红包，每个10元');
