/*
SQLyog Enterprise - MySQL GUI v6.14
MySQL - 5.5.27 : Database - crmdb2
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

create database if not exists `crmdb2`;

USE `crmdb2`;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

/*Table structure for table `crm_class` */

DROP TABLE IF EXISTS `crm_class`;

CREATE TABLE `crm_class` (
  `classId` varchar(50) NOT NULL,
  `courseTypeId` varchar(255) DEFAULT NULL,
  `name` varchar(50) DEFAULT NULL,
  `beginTime` datetime DEFAULT NULL,
  `endTime` datetime DEFAULT NULL,
  `status` varchar(20) DEFAULT NULL,
  `totalCount` int(11) DEFAULT NULL,
  `upgradeCount` int(11) DEFAULT NULL,
  `changeCount` int(11) DEFAULT NULL,
  `runoffCount` int(11) DEFAULT NULL,
  `remark` varchar(500) DEFAULT NULL,
  `uploadFile` varchar(200) DEFAULT NULL,
  `uploadTime` datetime DEFAULT NULL,
  `uploadPath` varchar(200) DEFAULT NULL,
  `uploadFilename` varchar(100) DEFAULT NULL,
  PRIMARY KEY (`classId`),
  KEY `FKC6862FD7280DDF21` (`courseTypeId`),
  CONSTRAINT `FKC6862FD7280DDF21` FOREIGN KEY (`courseTypeId`) REFERENCES `crm_course_type` (`courseTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_class` */

insert  into `crm_class`(`classId`,`courseTypeId`,`name`,`beginTime`,`endTime`,`status`,`totalCount`,`upgradeCount`,`changeCount`,`runoffCount`,`remark`,`uploadFile`,`uploadTime`,`uploadPath`,`uploadFilename`) values ('2c9091c14c78e58b014c78e8cc62000a','2c9091c14c78e58b014c78e829b70008','1期','2015-03-10 00:00:00','2015-04-30 00:00:00',NULL,80,2,0,2,'',NULL,'2015-04-02 16:33:09','/WEB-INF/upload/0d7a042741544da988b2d2462c683e57','(第173期)2015年01月22日 JavaEE就业班.xls'),('2c9091c14c78e58b014c78e9106e000b','2c9091c14c78e58b014c78e829b70008','2期','2015-04-28 00:00:00','2015-05-27 00:00:00',NULL,67,0,0,0,'',NULL,NULL,NULL,NULL),('2c9091c14c78e58b014c78e9601a000c','2c9091c14c78e58b014c78e867b80009','1期ee','2015-03-29 00:00:00','2015-07-13 00:00:00',NULL,120,0,0,0,'',NULL,NULL,NULL,NULL);

/*Table structure for table `crm_course_type` */

DROP TABLE IF EXISTS `crm_course_type`;

CREATE TABLE `crm_course_type` (
  `courseTypeId` varchar(255) NOT NULL,
  `courseCost` double DEFAULT NULL,
  `total` int(11) DEFAULT NULL,
  `courseName` varchar(500) DEFAULT NULL,
  `remark` varchar(5000) DEFAULT NULL,
  PRIMARY KEY (`courseTypeId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_course_type` */

insert  into `crm_course_type`(`courseTypeId`,`courseCost`,`total`,`courseName`,`remark`) values ('2c9091c14c78e58b014c78e829b70008',2000,1000,'java基础',''),('2c9091c14c78e58b014c78e867b80009',18000,4000,'java就业','');

/*Table structure for table `crm_department` */

DROP TABLE IF EXISTS `crm_department`;

CREATE TABLE `crm_department` (
  `depId` varchar(255) NOT NULL,
  `depName` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`depId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_department` */

insert  into `crm_department`(`depId`,`depName`) values ('2c9091c14c78e58b014c78e67de10001','java学院'),('2c9091c14c78e58b014c78e68ded0002','咨询部');

/*Table structure for table `crm_follow` */

DROP TABLE IF EXISTS `crm_follow`;

CREATE TABLE `crm_follow` (
  `followId` varchar(255) NOT NULL,
  `followTime` datetime DEFAULT NULL,
  `content` varchar(1000) DEFAULT NULL,
  `staffId` varchar(255) DEFAULT NULL,
  `referId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`followId`),
  KEY `FKF8D81325A7A5688` (`referId`),
  KEY `FKF8D8132402401A8` (`staffId`),
  CONSTRAINT `FKF8D8132402401A8` FOREIGN KEY (`staffId`) REFERENCES `crm_staff` (`staffId`),
  CONSTRAINT `FKF8D81325A7A5688` FOREIGN KEY (`referId`) REFERENCES `crm_refer` (`referId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_follow` */

insert  into `crm_follow`(`followId`,`followTime`,`content`,`staffId`,`referId`) values ('402881e84d47ffc9014d480cf3e00000','2015-05-12 20:15:17','有问题，钱','2c9091c14c78e58b014c78e5c32a0000','2c9091c14c79506c014c7981cf370000'),('402881e84d47ffc9014d480d19e70001','2015-05-12 20:15:27','钱解决','2c9091c14c78e58b014c78e5c32a0000','2c9091c14c79506c014c7981cf370000');

/*Table structure for table `crm_graduate` */

DROP TABLE IF EXISTS `crm_graduate`;

CREATE TABLE `crm_graduate` (
  `granduateId` varchar(255) NOT NULL,
  `studentId` varchar(255) DEFAULT NULL,
  `companyName` varchar(50) DEFAULT NULL,
  `salary` varchar(50) DEFAULT NULL,
  `post` varchar(50) DEFAULT NULL,
  `entryTime` datetime DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  `classId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`granduateId`),
  UNIQUE KEY `studentId` (`studentId`),
  KEY `FK5592468CF7E9881` (`classId`),
  KEY `FK5592468C2CF4BD39` (`studentId`),
  CONSTRAINT `FK5592468C2CF4BD39` FOREIGN KEY (`studentId`) REFERENCES `crm_student` (`studentId`),
  CONSTRAINT `FK5592468CF7E9881` FOREIGN KEY (`classId`) REFERENCES `crm_class` (`classId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_graduate` */

insert  into `crm_graduate`(`granduateId`,`studentId`,`companyName`,`salary`,`post`,`entryTime`,`remark`,`classId`) values ('402881e84d47ffc9014d48a22ebf0005','2c9091c14c78e58b014c78e9c324000d','展讯','99999','java高级工程师','2015-05-14 00:00:00','手动方式',NULL);

/*Table structure for table `crm_outflow` */

DROP TABLE IF EXISTS `crm_outflow`;

CREATE TABLE `crm_outflow` (
  `runOffId` varchar(255) NOT NULL,
  `studentId` varchar(255) DEFAULT NULL,
  `staffId` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `isRefund` varchar(255) DEFAULT NULL,
  `refundAmount` varchar(255) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`runOffId`),
  KEY `FKC8E5C41B402401A8` (`staffId`),
  KEY `FKC8E5C41B2CF4BD39` (`studentId`),
  CONSTRAINT `FKC8E5C41B2CF4BD39` FOREIGN KEY (`studentId`) REFERENCES `crm_student` (`studentId`),
  CONSTRAINT `FKC8E5C41B402401A8` FOREIGN KEY (`staffId`) REFERENCES `crm_staff` (`staffId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_outflow` */

insert  into `crm_outflow`(`runOffId`,`studentId`,`staffId`,`createDate`,`isRefund`,`refundAmount`,`remark`) values ('2c9091c14c78f63c014c78f680c30000','2c9091c14c78e58b014c78ec4e110012','2c9091c14c78e58b014c78e5c32a0000','2015-04-02 15:09:23','1','1000',''),('402881e84d47ffc9014d4882f05b0003','402881e84d47ffc9014d481b53860002','2c9091c14c78e58b014c78e5c32a0000','2015-05-12 22:24:10','1','','');

/*Table structure for table `crm_post` */

DROP TABLE IF EXISTS `crm_post`;

CREATE TABLE `crm_post` (
  `postId` varchar(255) NOT NULL,
  `postName` varchar(100) DEFAULT NULL,
  `depId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`postId`),
  KEY `FK7A0A4A6165481EDB` (`depId`),
  CONSTRAINT `FK7A0A4A6165481EDB` FOREIGN KEY (`depId`) REFERENCES `crm_department` (`depId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_post` */

insert  into `crm_post`(`postId`,`postName`,`depId`) values ('2c9091c14c78e58b014c78e6b34a0003','总监','2c9091c14c78e58b014c78e67de10001'),('2c9091c14c78e58b014c78e6d4510004','讲师','2c9091c14c78e58b014c78e67de10001'),('2c9091c14c78e58b014c78e6f2340005','主管','2c9091c14c78e58b014c78e68ded0002');

/*Table structure for table `crm_refer` */

DROP TABLE IF EXISTS `crm_refer`;

CREATE TABLE `crm_refer` (
  `referId` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `staffId` varchar(255) DEFAULT NULL,
  `intentionLevel` varchar(50) DEFAULT NULL,
  `classId` varchar(50) DEFAULT NULL,
  `courseTypeId` varchar(255) DEFAULT NULL,
  `source` varchar(100) DEFAULT NULL,
  `status` varchar(10) DEFAULT NULL,
  `remark` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`referId`),
  KEY `FKC75672DF402401A8` (`staffId`),
  KEY `FKC75672DFF7E9881` (`classId`),
  KEY `FKC75672DF280DDF21` (`courseTypeId`),
  CONSTRAINT `FKC75672DF280DDF21` FOREIGN KEY (`courseTypeId`) REFERENCES `crm_course_type` (`courseTypeId`),
  CONSTRAINT `FKC75672DF402401A8` FOREIGN KEY (`staffId`) REFERENCES `crm_staff` (`staffId`),
  CONSTRAINT `FKC75672DFF7E9881` FOREIGN KEY (`classId`) REFERENCES `crm_class` (`classId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_refer` */

insert  into `crm_refer`(`referId`,`name`,`telephone`,`qq`,`createDate`,`staffId`,`intentionLevel`,`classId`,`courseTypeId`,`source`,`status`,`remark`) values ('2c9091c14c79506c014c7981cf370000','张三','13812341234','2342424','2015-04-02 17:41:32','2c9091c14c78e58b014c78e5c32a0000','A.马上报名','2c9091c14c78e58b014c78e8cc62000a','2c9091c14c78e58b014c78e829b70008','1.QQ','2',''),('402881ec4e735c57014e73777f210000','张三2','13812341234','123456','2015-07-09 23:38:08','2c9091c14c78e58b014c78e5c32a0000','B.想报名，考虑中','2c9091c14c78e58b014c78e9601a000c','2c9091c14c78e58b014c78e867b80009','2.电话咨询','1','水电费的爽肤水');

/*Table structure for table `crm_staff` */

DROP TABLE IF EXISTS `crm_staff`;

CREATE TABLE `crm_staff` (
  `staffId` varchar(255) NOT NULL,
  `loginName` varchar(100) DEFAULT NULL,
  `loginPwd` varchar(100) DEFAULT NULL,
  `staffName` varchar(100) DEFAULT NULL,
  `gender` varchar(20) DEFAULT NULL,
  `onDutyDate` datetime DEFAULT NULL,
  `postId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`staffId`),
  KEY `FKC76B493F7D07A7EC` (`postId`),
  CONSTRAINT `FKC76B493F7D07A7EC` FOREIGN KEY (`postId`) REFERENCES `crm_post` (`postId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_staff` */

insert  into `crm_staff`(`staffId`,`loginName`,`loginPwd`,`staffName`,`gender`,`onDutyDate`,`postId`) values ('2c9091c14c78e58b014c78e5c32a0000','jack','81dc9bdb52d04dc20036dbd8313ed055','管理员',NULL,NULL,NULL),('2c9091c14c78e58b014c78e759b40006','rose','81dc9bdb52d04dc20036dbd8313ed055','肉丝','女','2013-04-16 00:00:00','2c9091c14c78e58b014c78e6f2340005'),('2c9091c14c78e58b014c78e7ecd90007','tom','81dc9bdb52d04dc20036dbd8313ed055','汤姆','男','2014-04-24 00:00:00','2c9091c14c78e58b014c78e6d4510004');

/*Table structure for table `crm_station` */

DROP TABLE IF EXISTS `crm_station`;

CREATE TABLE `crm_station` (
  `stationId` varchar(255) NOT NULL,
  `studentId` varchar(255) DEFAULT NULL,
  `flag` varchar(255) DEFAULT NULL,
  `staffId` varchar(255) DEFAULT NULL,
  `createDate` datetime DEFAULT NULL,
  `beforeClassId` varchar(50) DEFAULT NULL,
  `afterClassId` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`stationId`),
  KEY `FK99C46BD3BF7A8325` (`afterClassId`),
  KEY `FK99C46BD3A804BC22` (`beforeClassId`),
  KEY `FK99C46BD3402401A8` (`staffId`),
  KEY `FK99C46BD32CF4BD39` (`studentId`),
  CONSTRAINT `FK99C46BD32CF4BD39` FOREIGN KEY (`studentId`) REFERENCES `crm_student` (`studentId`),
  CONSTRAINT `FK99C46BD3402401A8` FOREIGN KEY (`staffId`) REFERENCES `crm_staff` (`staffId`),
  CONSTRAINT `FK99C46BD3A804BC22` FOREIGN KEY (`beforeClassId`) REFERENCES `crm_class` (`classId`),
  CONSTRAINT `FK99C46BD3BF7A8325` FOREIGN KEY (`afterClassId`) REFERENCES `crm_class` (`classId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_station` */

insert  into `crm_station`(`stationId`,`studentId`,`flag`,`staffId`,`createDate`,`beforeClassId`,`afterClassId`) values ('2c9091c14c78e58b014c78ea53cd000f','2c9091c14c78e58b014c78e9c324000d','3','2c9091c14c78e58b014c78e5c32a0000','2015-04-02 14:56:05','2c9091c14c78e58b014c78e8cc62000a','2c9091c14c78e58b014c78e9601a000c'),('2c9091c14c78e58b014c78ea89ea0010','2c9091c14c78e58b014c78ea12f0000e','3','2c9091c14c78e58b014c78e5c32a0000','2015-04-02 14:56:18','2c9091c14c78e58b014c78e8cc62000a','2c9091c14c78e58b014c78e9601a000c');

/*Table structure for table `crm_student` */

DROP TABLE IF EXISTS `crm_student`;

CREATE TABLE `crm_student` (
  `studentId` varchar(255) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `gender` varchar(255) DEFAULT NULL,
  `mustTuition` int(11) DEFAULT NULL,
  `actualTuition` int(11) DEFAULT NULL,
  `telephone` varchar(255) DEFAULT NULL,
  `identity` varchar(255) DEFAULT NULL,
  `classId` varchar(50) DEFAULT NULL,
  `qq` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `school` varchar(255) DEFAULT NULL,
  `education` varchar(255) DEFAULT NULL,
  `professional` varchar(255) DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `identityAddress` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  `remark` varchar(255) DEFAULT NULL,
  `homeTelephone` varchar(255) DEFAULT NULL,
  `homeUser` varchar(255) DEFAULT NULL,
  `referId` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`studentId`),
  UNIQUE KEY `referId` (`referId`),
  KEY `FK9AD6ECDA5A7A5688` (`referId`),
  KEY `FK9AD6ECDAF7E9881` (`classId`),
  CONSTRAINT `FK9AD6ECDA5A7A5688` FOREIGN KEY (`referId`) REFERENCES `crm_refer` (`referId`),
  CONSTRAINT `FK9AD6ECDAF7E9881` FOREIGN KEY (`classId`) REFERENCES `crm_class` (`classId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `crm_student` */

insert  into `crm_student`(`studentId`,`name`,`gender`,`mustTuition`,`actualTuition`,`telephone`,`identity`,`classId`,`qq`,`email`,`school`,`education`,`professional`,`status`,`identityAddress`,`address`,`remark`,`homeTelephone`,`homeUser`,`referId`) values ('2c9091c14c78e58b014c78e9c324000d','张三','男',18000,18000,'13812341234','123456201212211234','2c9091c14c78e58b014c78e9601a000c','2342424','','','','','4','','','','','',NULL),('2c9091c14c78e58b014c78ea12f0000e','李四','男',18000,18000,'','123456200205097890','2c9091c14c78e58b014c78e9601a000c','','','','','','3','','','','','',NULL),('2c9091c14c78e58b014c78ec4e110012','王五','男',18000,18000,'','','2c9091c14c78e58b014c78e8cc62000a','','','','','','5','','','','','',NULL),('402881e84d47ffc9014d481b53860002','张三','男',132,1233,'13812341234','123456201212211234','2c9091c14c78e58b014c78e8cc62000a','2342424','','北京大学','3.本科','计算机','5','','','','','','2c9091c14c79506c014c7981cf370000');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
