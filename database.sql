CREATE DATABASE  IF NOT EXISTS `bbs` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `bbs`;
-- MySQL dump 10.13  Distrib 5.6.19, for osx10.7 (i386)
--
-- Host: localhost    Database: bbs
-- ------------------------------------------------------
-- Server version	5.6.23

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
-- Table structure for table `authority`
--

DROP TABLE IF EXISTS `authority`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `authority` (
  `user_id` int(11) NOT NULL,
  `authority` varchar(45) NOT NULL,
  `forum_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`user_id`,`authority`),
  KEY `fk_a_f_idx` (`forum_id`),
  CONSTRAINT `fk_a_f` FOREIGN KEY (`forum_id`) REFERENCES `forum` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_a_u` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `authority`
--

LOCK TABLES `authority` WRITE;
/*!40000 ALTER TABLE `authority` DISABLE KEYS */;
INSERT INTO `authority` VALUES (1,'ROLE_ADMIN',NULL);
/*!40000 ALTER TABLE `authority` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `forum`
--

DROP TABLE IF EXISTS `forum`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `forum` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(45) NOT NULL,
  `description` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `forum`
--

LOCK TABLES `forum` WRITE;
/*!40000 ALTER TABLE `forum` DISABLE KEYS */;
INSERT INTO `forum` VALUES (1,'forum1','hello forum1');
/*!40000 ALTER TABLE `forum` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `reply`
--

DROP TABLE IF EXISTS `reply`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `reply` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `topic_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `title` varchar(45) DEFAULT NULL,
  `content` mediumtext NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_comment_threadid_idx` (`topic_id`),
  KEY `fk_comment_userid_idx` (`user_id`),
  CONSTRAINT `fk_comment_threadid` FOREIGN KEY (`topic_id`) REFERENCES `topic` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `fk_comment_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `reply`
--

LOCK TABLES `reply` WRITE;
/*!40000 ALTER TABLE `reply` DISABLE KEYS */;
INSERT INTO `reply` VALUES (1,1,1,'不错哦','嗯嗯嗯','2016-03-21 14:49:15'),(2,1,1,'是啊','。。。','2016-03-21 14:49:44'),(3,1,1,'asdf','test','2016-03-22 06:40:47'),(8,1,NULL,'t1','t2','2016-03-22 10:02:41'),(9,1,NULL,'t1','t2','2016-03-22 10:06:39'),(10,1,NULL,'t1','t2','2016-03-22 10:07:47'),(11,1,NULL,'t1','t2','2016-03-22 10:09:23'),(12,1,1,'t1','t2','2016-03-22 10:37:21'),(13,1,1,'t1','t2','2016-03-22 10:37:37'),(14,1,1,'ttt','ccc','2016-03-22 11:36:38'),(15,1,1,'asd','dd','2016-03-22 12:15:34'),(16,1,1,'asd','','2016-03-22 13:01:12'),(17,1,1,'asd','','2016-03-22 13:01:16'),(18,1,1,'ddd','','2016-03-22 13:01:36'),(19,1,1,'ddd','','2016-03-22 13:04:39'),(20,1,1,'','Using Bean Validation Validating input received from the user to maintain data integrity is an important part of application logic. Validation of data can take place at different layers in even the simplest of applications, as shown in Developing a Simple Facelets Application. The guessnumber example application validates the user input (in the h:inputText tag) for numerical data at the presentation layer and for a valid range of numbers at the business layer.  JavaBeans Validation (Bean Validation) is a new validation model available as part of Java EE 6 platform. The Bean Validation model is supported by constraints in the form of annotations placed on a field, method, or class of a JavaBeans component, such as a managed bean.  Constraints can be built in or user defined. User-defined constraints are called custom constraints. Several built-in constraints are available in the javax.validation.constraints package. Table 9-2 lists all the built-in constraints.  Table 9-2 Built-In Bean Validation Constraints','2016-03-22 13:35:44');
/*!40000 ALTER TABLE `reply` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `setting`
--

DROP TABLE IF EXISTS `setting`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `setting` (
  `bbs_name` varchar(45) NOT NULL,
  `bbs_desc` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `setting`
--

LOCK TABLES `setting` WRITE;
/*!40000 ALTER TABLE `setting` DISABLE KEYS */;
/*!40000 ALTER TABLE `setting` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `topic`
--

DROP TABLE IF EXISTS `topic`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `topic` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `forum_id` int(11) NOT NULL,
  `user_id` int(11) DEFAULT NULL,
  `title` varchar(45) NOT NULL,
  `content` mediumtext NOT NULL,
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `last_modified` timestamp NULL DEFAULT NULL,
  `clicks` int(11) DEFAULT '0',
  `pin` tinyint(4) DEFAULT '0',
  PRIMARY KEY (`id`),
  KEY `fk_thread_forumid_idx` (`forum_id`),
  KEY `fk_thread_userid_idx` (`user_id`),
  CONSTRAINT `fk_thread_forumid` FOREIGN KEY (`forum_id`) REFERENCES `forum` (`id`) ON UPDATE CASCADE,
  CONSTRAINT `fk_thread_userid` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`) ON DELETE SET NULL ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `topic`
--

LOCK TABLES `topic` WRITE;
/*!40000 ALTER TABLE `topic` DISABLE KEYS */;
INSERT INTO `topic` VALUES (1,1,1,'Hello!','World!!','2016-03-21 08:30:39','2016-03-21 09:07:50',0,0),(2,1,1,'asdf','asdf','2016-03-22 12:40:18',NULL,NULL,NULL);
/*!40000 ALTER TABLE `topic` ENABLE KEYS */;
UNLOCK TABLES;
/*!50003 SET @saved_cs_client      = @@character_set_client */ ;
/*!50003 SET @saved_cs_results     = @@character_set_results */ ;
/*!50003 SET @saved_col_connection = @@collation_connection */ ;
/*!50003 SET character_set_client  = utf8 */ ;
/*!50003 SET character_set_results = utf8 */ ;
/*!50003 SET collation_connection  = utf8_general_ci */ ;
/*!50003 SET @saved_sql_mode       = @@sql_mode */ ;
/*!50003 SET sql_mode              = 'STRICT_TRANS_TABLES,NO_ENGINE_SUBSTITUTION' */ ;
DELIMITER ;;
/*!50003 CREATE*/ /*!50017 DEFINER=`root`@`localhost`*/ /*!50003 trigger tirgger_update_thread
before
UPDATE ON `topic` FOR EACH ROW 
BEGIN
	if NEW.content != OLD.content or NEW.title != OLD.title then
        set NEW.last_modified = NOW();
	END IF;
	
END */;;
DELIMITER ;
/*!50003 SET sql_mode              = @saved_sql_mode */ ;
/*!50003 SET character_set_client  = @saved_cs_client */ ;
/*!50003 SET character_set_results = @saved_cs_results */ ;
/*!50003 SET collation_connection  = @saved_col_connection */ ;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `password` char(32) NOT NULL,
  `email` varchar(255) DEFAULT NULL,
  `avatar` varchar(255) DEFAULT NULL,
  `member_title` varchar(16) DEFAULT NULL,
  `signature` varchar(255) DEFAULT NULL,
  `enabled` bit(1) DEFAULT b'1',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'nw','202CB962AC59075B964B07152D234B70','nw4869@gmail.com',NULL,NULL,'sasdasdasasdasdasasdasdasasdasdasasdasdasasdasdasasdasdasasdasdasasdasdasasdasdasasdasda','','2015-12-31 16:00:00'),(2,'test','202CB962AC59075B964B07152D234B70','test@test.com','/avatar/test.jpg',NULL,'my signature','','2016-03-19 11:57:50'),(11,'usn2','202CB962AC59075B964B07152D234B70','','','','','\0','2016-03-19 12:21:44'),(12,'啊啊','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-19 12:26:21'),(15,'50c2a8c3-1d70-41','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-19 12:30:30'),(17,'085773d5-90e4-44','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-19 12:30:46'),(20,'e18a68e3-c6cd-4a','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-19 12:31:37'),(22,'837ba119-323c-47','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-19 12:33:58'),(24,'f82d12b2-f89f-48','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-19 12:46:33'),(26,'905ac95c-e5cc-49','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-19 13:16:58'),(27,'bd849dfd-3a80-49','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-19 13:17:41'),(28,'7296230c-6524-4d','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-19 13:21:15'),(29,'c2f513bf-3baf-45','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-19 13:21:39'),(31,'5e39fbb8-c892-43','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-19 13:22:45'),(33,'bdca8ba1-2c3c-4c','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-19 13:30:16'),(34,'36fd4683-e55f-40','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-19 13:54:15'),(36,'d30bc546-4dc2-4a','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-19 13:54:50'),(38,'9c76ee50-b2d9-4f','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-19 13:57:49'),(40,'7429497d-de6f-45','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-19 14:01:38'),(42,'a4c140bd-25c6-4f','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-19 14:01:46'),(44,'fc7b44ba-5ab2-4b','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-19 14:03:44'),(46,'35fcf623-adb8-4b','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-19 14:07:02'),(47,'ae6b5449-8d8d-4e','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-20 03:11:20'),(48,'8d1577e0-cd62-4e','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-20 03:12:04'),(49,'d9c5b9ba-12a1-48','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-20 03:12:12'),(50,'56f63a81-832f-40','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-20 03:12:24'),(51,'804b9bcf-fde4-45','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-20 03:12:32'),(52,'dcdc1edf-f7b9-42','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-20 03:12:41'),(56,'nw1','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-20 12:24:41'),(62,'lianghao','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-20 12:39:44'),(63,'nw123','202CB962AC59075B964B07152D234B70',NULL,NULL,NULL,NULL,'','2016-03-21 05:31:36');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-03-22 22:06:30
