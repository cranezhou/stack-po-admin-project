USE `stack_po_admin_db_dev`;

-- MySQL dump 10.13  Distrib 5.7.24, for Linux (x86_64)
--
-- Host: 127.0.0.1    Database: stack_po_admin_db_dev
-- ------------------------------------------------------
-- Server version	5.7.24-0ubuntu0.16.04.1

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `tbl_auth_resource`
--

DROP TABLE IF EXISTS `tbl_auth_resource`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_auth_resource` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `resource_name` varchar(45) DEFAULT NULL,
  `resource_desc` varchar(45) DEFAULT NULL,
  `resource_type` varchar(45) DEFAULT NULL,
  `resource_status` int(11) DEFAULT '1',
  PRIMARY KEY (`id`),
  UNIQUE KEY `resource_name_UNIQUE` (`resource_name`)
) ENGINE=InnoDB AUTO_INCREMENT=1106 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_auth_resource`
--

LOCK TABLES `tbl_auth_resource` WRITE;
/*!40000 ALTER TABLE `tbl_auth_resource` DISABLE KEYS */;
INSERT INTO `tbl_auth_resource` (`id`, `resource_name`, `resource_desc`, `resource_type`, `resource_status`) VALUES 
(1001,'可乐','百事可乐','饮料',1),
(1002,'雪碧','柠檬味汽水','饮料',1),
(1003,'橙汁','果粒橙汁','饮料',1),
(1101,'农夫山泉','农夫山泉 国产矿泉水','矿泉水',1),
(1102,'冰露','冰露 国产矿泉水','矿泉水',1),
(1103,'纯悦','纯悦 国产矿泉水','矿泉水',1),
(1104,'矿泉水十一','矿泉水十一 国产矿泉水','矿泉水',1),
(1105,'矿泉水十二','矿泉水十二 国产矿泉水','矿泉水',1);
/*!40000 ALTER TABLE `tbl_auth_resource` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_auth_role`
--

DROP TABLE IF EXISTS `tbl_auth_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_auth_role` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(45) NOT NULL COMMENT '角色名称',
  `remark` varchar(45) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`),
  UNIQUE KEY `role_name_UNIQUE` (`role_name`)
) ENGINE=InnoDB AUTO_INCREMENT=104 DEFAULT CHARSET=utf8 COMMENT='用户角色主表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_auth_role`
--

LOCK TABLES `tbl_auth_role` WRITE;
/*!40000 ALTER TABLE `tbl_auth_role` DISABLE KEYS */;
INSERT INTO `tbl_auth_role` (`id`, `role_name`, `remark`) VALUES 
(101,'Administrator',NULL),
(102,'Normal User',NULL),
(103,'Super User',NULL);
/*!40000 ALTER TABLE `tbl_auth_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_auth_user_roles`
--

DROP TABLE IF EXISTS `tbl_auth_user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_auth_user_roles` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `user_id` int(10) NOT NULL,
  `role_id` int(10) NOT NULL,
  `remark` varchar(45) DEFAULT NULL COMMENT '备注信息',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COMMENT='用户角色关系表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_auth_user_roles`
--

LOCK TABLES `tbl_auth_user_roles` WRITE;
/*!40000 ALTER TABLE `tbl_auth_user_roles` DISABLE KEYS */;
INSERT INTO `tbl_auth_user_roles` (`id`, `user_id`, `role_id`, `remark`) VALUES 
(1,2001,101,NULL),
(2,2002,102,NULL),
(3,2003,103,NULL);
/*!40000 ALTER TABLE `tbl_auth_user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `tbl_auth_users`
--

DROP TABLE IF EXISTS `tbl_auth_users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `tbl_auth_users` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL COMMENT '用户账号',
  `password` varchar(128) NOT NULL COMMENT '用户密码',
  `fullname` varchar(45) DEFAULT NULL COMMENT '用户全名',
  `user_email` varchar(45) NOT NULL COMMENT '电子邮件',
  `user_phone` varchar(45) NOT NULL COMMENT '手机号码',
  `last_login` datetime NOT NULL COMMENT '最后登录',
  `date_joined` datetime NOT NULL COMMENT '创建时间',
  `user_status` int(11) NOT NULL DEFAULT '1' COMMENT '用户状态 (1:active, 0: inactive)',
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`),
  UNIQUE KEY `user_phone_UNIQUE` (`user_phone`)
) ENGINE=InnoDB AUTO_INCREMENT=2004 DEFAULT CHARSET=utf8 COMMENT='用户主表';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `tbl_auth_users`
--

LOCK TABLES `tbl_auth_users` WRITE;
/*!40000 ALTER TABLE `tbl_auth_users` DISABLE KEYS */;
INSERT INTO `tbl_auth_users` (`id`, `username`, `password`, `fullname`, `user_email`, `user_phone`, `last_login`, `date_joined`, `user_status`) VALUES 
(2001,'admin','$2a$10$GH2UACuX4b7sXXkOIy3/p./Xa6IP.P89nc9wxfwoT5Am2y2qmufR.','admin zhou','crane_zhou@163.com','138xxxxxxx9','2018-10-08 20:01:00','2018-10-08 20:01:00',1),
(2002,'user02','password02','User Name 02','user02@hellosoft.com','138xxxxxx89','2018-10-08 20:02:00','2018-10-08 20:02:00',1),
(2003,'user03','password03','User Name 03','user03@hellosoft.com','138xxxxxx789','2018-10-08 20:03:00','2018-10-08 20:03:00',1);
/*!40000 ALTER TABLE `tbl_auth_users` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-02-16 15:29:55
