/*
SQLyog Professional v12.09 (64 bit)
MySQL - 5.7.27-log : Database - wzx
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`wzx` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_czech_ci */;

USE `wzx`;

/*Table structure for table `room` */

DROP TABLE IF EXISTS `room`;

CREATE TABLE `room` (
  `room_class` varchar(255) COLLATE utf8mb4_czech_ci DEFAULT NULL,
  `sum` int(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_czech_ci;

/*Data for the table `room` */

insert  into `room`(`room_class`,`sum`) values ('first',5),('second',5),('third',5);

/*Table structure for table `room_user` */

DROP TABLE IF EXISTS `room_user`;

CREATE TABLE `room_user` (
  `user_name` varchar(20) COLLATE utf8mb4_czech_ci NOT NULL,
  `room_number` int(20) NOT NULL AUTO_INCREMENT,
  `room_class` varchar(20) COLLATE utf8mb4_czech_ci DEFAULT NULL,
  PRIMARY KEY (`user_name`),
  KEY `room_spot` (`room_number`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_czech_ci;

/*Data for the table `room_user` */

/*Table structure for table `surplus_room` */

DROP TABLE IF EXISTS `surplus_room`;

CREATE TABLE `surplus_room` (
  `room_type` varchar(50) COLLATE utf8mb4_czech_ci DEFAULT NULL,
  `surplus_number` int(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_czech_ci;

/*Data for the table `surplus_room` */

insert  into `surplus_room`(`room_type`,`surplus_number`) values ('first',5),('second',5),('third',5);

/*Table structure for table `t_clazz` */

DROP TABLE IF EXISTS `t_clazz`;

CREATE TABLE `t_clazz` (
  `cid` int(11) NOT NULL,
  `cname` varchar(255) COLLATE utf8mb4_czech_ci DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_czech_ci;

/*Data for the table `t_clazz` */

insert  into `t_clazz`(`cid`,`cname`) values (1000,'高三一班'),(1001,'高三二班'),(1002,'高三三班');

/*Table structure for table `user_money` */

DROP TABLE IF EXISTS `user_money`;

CREATE TABLE `user_money` (
  `user_name` varchar(50) COLLATE utf8mb4_czech_ci NOT NULL,
  `user_money` int(50) DEFAULT NULL,
  PRIMARY KEY (`user_name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_czech_ci;

/*Data for the table `user_money` */

/*Table structure for table `vip_user` */

DROP TABLE IF EXISTS `vip_user`;

CREATE TABLE `vip_user` (
  `name` varchar(50) COLLATE utf8mb4_czech_ci NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_czech_ci;

/*Data for the table `vip_user` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
