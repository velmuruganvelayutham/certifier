CREATE DATABASE  IF NOT EXISTS `tradeshow` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `tradeshow`;
-- MySQL dump 10.13  Distrib 5.7.9, for linux-glibc2.5 (x86_64)
--
-- Host: 127.0.0.1    Database: tradeshow
-- ------------------------------------------------------
-- Server version	5.7.18

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
-- Table structure for table `c_options`
--

DROP TABLE IF EXISTS `c_options`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `c_options` (
  `c_options_id` int(11) NOT NULL AUTO_INCREMENT,
  `choice` varchar(10000) DEFAULT NULL,
  `explanation` varchar(10000) DEFAULT NULL,
  `isCorrect` bit(1) DEFAULT NULL,
  `c_questions_id` int(11) NOT NULL,
  PRIMARY KEY (`c_options_id`),
  UNIQUE KEY `c_options_id` (`c_options_id`),
  KEY `FK988D1AC2F581F235` (`c_questions_id`),
  CONSTRAINT `FK988D1AC2F581F235` FOREIGN KEY (`c_questions_id`) REFERENCES `c_questions` (`c_questions_id`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `c_options`
--

LOCK TABLES `c_options` WRITE;
/*!40000 ALTER TABLE `c_options` DISABLE KEYS */;
INSERT INTO `c_options` VALUES (1,' A) public void setDone(boolean done) ',NULL,'\0',1),(2,'B) public boolean setDone(boolean done) ',NULL,'\0',1),(3,'C) private boolean setDone(boolean done) ',NULL,'\0',1),(4,'D) public void setDone() ',NULL,'\0',1),(5,'E) public boolean getDone() ',NULL,'\0',1),(6,'F) public boolean isDone() ',NULL,'\0',1),(7,'G) public boolean getDone(boolean done) ',NULL,'\0',1),(8,'H) public void isDone() ',NULL,'\0',1),(9,' A) Compilation fails. ',NULL,'\0',2),(10,'B) An exception is thrown at runtime.',NULL,'\0',2),(11,'C) \"go\" is printed ',NULL,'\0',2),(12,'D) \"gogogo\" is printed',NULL,'\0',2),(13,'E) \"gogo\" is printed ',NULL,'\0',2),(14,' A) Only the Hotel class. ',NULL,'\0',3),(15,'B) Any class.   ',NULL,'\0',3),(16,' C) Any class in com.mycompany package. ',NULL,'\0',3),(17,' D) Any class that extends Hotel. ',NULL,'\0',3),(18,'A) Compilation fails. ',NULL,'\0',4),(19,'B) An exception is thrown at runtime. ',NULL,'\0',4),(20,' C) 0 ',NULL,'\0',4),(21,' D) 1 ',NULL,'\0',4),(22,' E) 2 ',NULL,'\0',4),(23,' F) -1 ',NULL,'\0',4),(24,' A) 10  ',NULL,'\0',5),(25,'B) 11   ',NULL,'\0',5),(26,' C) 12 ',NULL,'\0',5),(27,' D) 13 ',NULL,'\0',5),(28,' E) Line 5 will be never reached. ',NULL,'\0',5),(29,' A) The code demonstrates polymorphism. ',NULL,'\0',6),(30,'B) The class is fully encapsulated.  ',NULL,'\0',6),(31,' C) The variable roomNr breaks encapsulation. ',NULL,'\0',6),(32,' D) Variables beginDttm and endDttm break polymorphism.\n			',NULL,'\0',6),(33,' E) The method book breaks encapsulation ',NULL,'\0',6),(34,' A) The value \"1\" is printed ',NULL,'\0',7),(35,' B) Compilation fails because of an error in line 5   ',NULL,'\0',7),(36,' C) A NullPointerException occurs at runtime ',NULL,'\0',7),(37,' D) A NumberFormatException occurs at runtime  ',NULL,'\0',7),(38,' E) An IllegalStateExcepition occurs at runtime ',NULL,'\0',7),(39,' A) Compilation fails.  ',NULL,'\0',8),(40,'B) An exception is thrown at runtime.  ',NULL,'\0',8),(41,' C) d e h ',NULL,'\0',8),(42,' D) d f i ',NULL,'\0',8),(43,' E) c f i  ',NULL,'\0',8),(44,' F) c e h  ',NULL,'\0',8),(45,' A) Compilation fails. ',NULL,'\0',9),(46,'B) \"1\" is printed.  ',NULL,'\0',9),(47,' C)\"2\" is printed. ',NULL,'\0',9),(48,' D) \"3\" is printed. ',NULL,'\0',9),(49,' E) An exception is thrown at runtime. ',NULL,'\0',9),(50,' A) \"1\" is printed  ',NULL,'\0',10),(51,' B) \"2\" is printed   ',NULL,'\0',10),(52,' C) Compilation fails ',NULL,'\0',10),(53,' D) An exception is thrown at runtime ',NULL,'\0',10),(54,' A) public void setDone(boolean done) ',NULL,'\0',11),(55,'B) public boolean setDone(boolean done) ',NULL,'\0',11),(56,'C) private boolean setDone(boolean done) ',NULL,'\0',11),(57,'D) public void setDone() ',NULL,'\0',11),(58,'E) public boolean getDone() ',NULL,'\0',11),(59,'F) public boolean isDone() ',NULL,'\0',11),(60,'G) public boolean getDone(boolean done) ',NULL,'\0',11),(61,'H) public void isDone() ',NULL,'\0',11),(62,' A) Compilation fails. ',NULL,'\0',12),(63,'B) An exception is thrown at runtime.',NULL,'\0',12),(64,'C) \"go\" is printed ',NULL,'\0',12),(65,'D) \"gogogo\" is printed',NULL,'\0',12),(66,'E) \"gogo\" is printed ',NULL,'\0',12),(67,' A) Only the Hotel class. ',NULL,'\0',13),(68,'B) Any class.   ',NULL,'\0',13),(69,' C) Any class in com.mycompany package. ',NULL,'\0',13),(70,' D) Any class that extends Hotel. ',NULL,'\0',13),(71,'A) Compilation fails. ',NULL,'\0',14),(72,'B) An exception is thrown at runtime. ',NULL,'\0',14),(73,' C) 0 ',NULL,'\0',14),(74,' D) 1 ',NULL,'\0',14),(75,' E) 2 ',NULL,'\0',14),(76,' F) -1 ',NULL,'\0',14),(77,' A) 10  ',NULL,'\0',15),(78,'B) 11   ',NULL,'\0',15),(79,' C) 12 ',NULL,'\0',15),(80,' D) 13 ',NULL,'\0',15),(81,' E) Line 5 will be never reached. ',NULL,'\0',15),(82,' A) The code demonstrates polymorphism. ',NULL,'\0',16),(83,'B) The class is fully encapsulated.  ',NULL,'\0',16),(84,' C) The variable roomNr breaks encapsulation. ',NULL,'\0',16),(85,' D) Variables beginDttm and endDttm break polymorphism.\n			',NULL,'\0',16),(86,' E) The method book breaks encapsulation ',NULL,'\0',16),(87,' A) The value \"1\" is printed ',NULL,'\0',17),(88,' B) Compilation fails because of an error in line 5   ',NULL,'\0',17),(89,' C) A NullPointerException occurs at runtime ',NULL,'\0',17),(90,' D) A NumberFormatException occurs at runtime  ',NULL,'\0',17),(91,' E) An IllegalStateExcepition occurs at runtime ',NULL,'\0',17),(92,' A) Compilation fails.  ',NULL,'\0',18),(93,'B) An exception is thrown at runtime.  ',NULL,'\0',18),(94,' C) d e h ',NULL,'\0',18),(95,' D) d f i ',NULL,'\0',18),(96,' E) c f i  ',NULL,'\0',18),(97,' F) c e h  ',NULL,'\0',18),(98,' A) Compilation fails. ',NULL,'\0',19),(99,'B) \"1\" is printed.  ',NULL,'\0',19),(100,' C)\"2\" is printed. ',NULL,'\0',19),(101,' D) \"3\" is printed. ',NULL,'\0',19),(102,' E) An exception is thrown at runtime. ',NULL,'\0',19),(103,' A) \"1\" is printed  ',NULL,'\0',20),(104,' B) \"2\" is printed   ',NULL,'\0',20),(105,' C) Compilation fails ',NULL,'\0',20),(106,' D) An exception is thrown at runtime ',NULL,'\0',20);
/*!40000 ALTER TABLE `c_options` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `c_questions`
--

DROP TABLE IF EXISTS `c_questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `c_questions` (
  `c_questions_id` int(11) NOT NULL AUTO_INCREMENT,
  `category` varchar(45) DEFAULT NULL,
  `question` varchar(10000) NOT NULL,
  `questionno` varchar(45) DEFAULT NULL,
  `c_tests_id` bigint(20) NOT NULL,
  PRIMARY KEY (`c_questions_id`),
  UNIQUE KEY `c_questions_id` (`c_questions_id`),
  KEY `FKD1775C7176C9E8D` (`c_tests_id`),
  CONSTRAINT `FKD1775C7176C9E8D` FOREIGN KEY (`c_tests_id`) REFERENCES `c_tests` (`tests_id`)
) ENGINE=InnoDB AUTO_INCREMENT=21 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `c_questions`
--

LOCK TABLES `c_questions` WRITE;
/*!40000 ALTER TABLE `c_questions` DISABLE KEYS */;
INSERT INTO `c_questions` VALUES (1,NULL,'\n			A Java bean component has the following field:\n			private boolean\n			done;\n			Which method declarations follow the JavaBean standards for\n			getting/settings this field? (Choose 3)\n		',NULL,1),(2,NULL,'\n			Given the code. What is the result?\n			public class Cruiser\n			implements Runnable {\n\n			public void run() {\n			System.out.print(\"go\");\n			}\n\n			public static void main(String arg[]) {\n			Thread t = new Thread(new\n			Cruiser());\n			t.run();\n			t.run();\n			t.start();\n			}\n			}\n		',NULL,1),(3,NULL,'\n			What can directly access and change the value of the variable\n			roomNr?\n			package com.mycompany;\n\n			public class Hotel {\n			private int roomNr =\n			100;\n			}\n		',NULL,1),(4,NULL,'\n			Give the code. What is the result?\n			class Hotel {\n			public int\n			bookings;\n			public void book() {\n			bookings++;\n			}\n			}\n\n			public class SuperHotel\n			extends Hotel {\n			public void book() {\n			bookings--;\n			}\n\n			public void book(int\n			size) {\n			book();\n			super.book();\n			bookings += size;\n			}\n\n			public static void\n			main(String args[]) {\n			SuperHotel hotel = new SuperHotel();\n			hotel.book(2);\n			System.out.print(hotel.bookings);\n			}\n			}\n		',NULL,1),(5,NULL,'\n			Given the code. What is the result?\n			1. int i = 10;\n			2. while (i++ <= 10) {\n			3. i++;\n			4. }\n			5. System.out.print(i);\n			\n		',NULL,1),(6,NULL,'\n			Given the code. What is true?\npublic class Room {\n    public int roomNr;\n    private Date beginDtm;\n    private Date endDttm;\n    \n    public void book(int roomNr, Date beginDttm, Date endDttm) {\n        this.roomNr = roomNr;\n        this.beginDtm = beginDttm;\n        this.endDttm = endDttm;\n    }\n}\n			\n		',NULL,1),(7,NULL,'\n			Given the code. What is the result?\n1   public class TryMe {\n2       Integer A;\n3       int a;\n4       public TryMe(int a) {\n5           this.a = A + a;\n6           System.out.print(this.a);\n7       }\n8       public static void main(String args[]) {        \n9           Integer A = new Integer(1);\n10          TryMe t = new TryMe(A);\n11      }\n12  }\n			\n		',NULL,1),(8,NULL,'\n			Given the code. What is the result?\npublic class Test { \n    private static void doStuff(String str) {\n        int var = 4;\n        if (var == str.length()) {\n            System.out.print(str.charAt(var--) + \" \");\n        }\n        else {\n            System.out.print(str.charAt(0) + \" \");\n        }\n    }\n    public static void main(String args[]) {\n        doStuff(\"abcd\");\n        doStuff(\"efg\");\n        doStuff(\"hi\");\n    }\n}\n			\n		',NULL,1),(9,NULL,'\n			Given the code. What is the result?\n    public static void main(String args[]) {\n        String str = null;\n        if (str == null) {\n            System.out.print(\"1\");\n        } else (str.length() == 0) {\n            System.out.print(\"2\");\n        } else {\n            System.out.print(\"3\");\n        }\n    }\n			\n		',NULL,1),(10,NULL,'\n			Given the code. What is the result?\npublic class SomeClass {\n    private Integer value = 1;\n    \n    public Integer getValue() {\n        return value;\n    }\n    \n    public void changeVal(Integer value) {\n        value = new Integer(3);\n    }\n\n    public static void main(String args[]) {\n        Integer a = new Integer(2);\n        SomeClass c = new SomeClass();\n        c.changeVal(a);\n        System.out.print(a);\n    }\n}\n			\n		',NULL,1),(11,NULL,'\n			A Java bean component has the following field:\n			private boolean\n			done;\n			Which method declarations follow the JavaBean standards for\n			getting/settings this field? (Choose 3)\n		',NULL,2),(12,NULL,'\n			Given the code. What is the result?\n			public class Cruiser\n			implements Runnable {\n\n			public void run() {\n			System.out.print(\"go\");\n			}\n\n			public static void main(String arg[]) {\n			Thread t = new Thread(new\n			Cruiser());\n			t.run();\n			t.run();\n			t.start();\n			}\n			}\n		',NULL,2),(13,NULL,'\n			What can directly access and change the value of the variable\n			roomNr?\n			package com.mycompany;\n\n			public class Hotel {\n			private int roomNr =\n			100;\n			}\n		',NULL,2),(14,NULL,'\n			Give the code. What is the result?\n			class Hotel {\n			public int\n			bookings;\n			public void book() {\n			bookings++;\n			}\n			}\n\n			public class SuperHotel\n			extends Hotel {\n			public void book() {\n			bookings--;\n			}\n\n			public void book(int\n			size) {\n			book();\n			super.book();\n			bookings += size;\n			}\n\n			public static void\n			main(String args[]) {\n			SuperHotel hotel = new SuperHotel();\n			hotel.book(2);\n			System.out.print(hotel.bookings);\n			}\n			}\n		',NULL,2),(15,NULL,'\n			Given the code. What is the result?\n			1. int i = 10;\n			2. while (i++ <= 10) {\n			3. i++;\n			4. }\n			5. System.out.print(i);\n			\n		',NULL,2),(16,NULL,'\n			Given the code. What is true?\npublic class Room {\n    public int roomNr;\n    private Date beginDtm;\n    private Date endDttm;\n    \n    public void book(int roomNr, Date beginDttm, Date endDttm) {\n        this.roomNr = roomNr;\n        this.beginDtm = beginDttm;\n        this.endDttm = endDttm;\n    }\n}\n			\n		',NULL,2),(17,NULL,'\n			Given the code. What is the result?\n1   public class TryMe {\n2       Integer A;\n3       int a;\n4       public TryMe(int a) {\n5           this.a = A + a;\n6           System.out.print(this.a);\n7       }\n8       public static void main(String args[]) {        \n9           Integer A = new Integer(1);\n10          TryMe t = new TryMe(A);\n11      }\n12  }\n			\n		',NULL,2),(18,NULL,'\n			Given the code. What is the result?\npublic class Test { \n    private static void doStuff(String str) {\n        int var = 4;\n        if (var == str.length()) {\n            System.out.print(str.charAt(var--) + \" \");\n        }\n        else {\n            System.out.print(str.charAt(0) + \" \");\n        }\n    }\n    public static void main(String args[]) {\n        doStuff(\"abcd\");\n        doStuff(\"efg\");\n        doStuff(\"hi\");\n    }\n}\n			\n		',NULL,2),(19,NULL,'\n			Given the code. What is the result?\n    public static void main(String args[]) {\n        String str = null;\n        if (str == null) {\n            System.out.print(\"1\");\n        } else (str.length() == 0) {\n            System.out.print(\"2\");\n        } else {\n            System.out.print(\"3\");\n        }\n    }\n			\n		',NULL,2),(20,NULL,'\n			Given the code. What is the result?\npublic class SomeClass {\n    private Integer value = 1;\n    \n    public Integer getValue() {\n        return value;\n    }\n    \n    public void changeVal(Integer value) {\n        value = new Integer(3);\n    }\n\n    public static void main(String args[]) {\n        Integer a = new Integer(2);\n        SomeClass c = new SomeClass();\n        c.changeVal(a);\n        System.out.print(a);\n    }\n}\n			\n		',NULL,2);
/*!40000 ALTER TABLE `c_questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `c_tests`
--

DROP TABLE IF EXISTS `c_tests`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `c_tests` (
  `tests_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `category` varchar(45) DEFAULT NULL,
  `file` longblob,
  `name` varchar(45) NOT NULL,
  PRIMARY KEY (`tests_id`),
  UNIQUE KEY `tests_id` (`tests_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `c_tests`
--

LOCK TABLES `c_tests` WRITE;
/*!40000 ALTER TABLE `c_tests` DISABLE KEYS */;
INSERT INTO `c_tests` VALUES (1,'',NULL,'Java'),(2,'',NULL,'HTML');
/*!40000 ALTER TABLE `c_tests` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `category_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `vendor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`category_id`),
  KEY `FK302BCFED060E677` (`vendor_id`),
  CONSTRAINT `FK302BCFED060E677` FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (`vendor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `product_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `vendor_id` bigint(20) DEFAULT NULL,
  PRIMARY KEY (`product_id`),
  KEY `FKED8DCCEFD060E677` (`vendor_id`),
  CONSTRAINT `FKED8DCCEFD060E677` FOREIGN KEY (`vendor_id`) REFERENCES `vendor` (`vendor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `settings`
--

DROP TABLE IF EXISTS `settings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `settings` (
  `settings_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `url` varchar(1024) NOT NULL,
  `websiteName` varchar(512) DEFAULT NULL,
  PRIMARY KEY (`settings_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `settings`
--

LOCK TABLES `settings` WRITE;
/*!40000 ALTER TABLE `settings` DISABLE KEYS */;
/*!40000 ALTER TABLE `settings` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_roles`
--

DROP TABLE IF EXISTS `user_roles`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_roles` (
  `user_role_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `ROLE` varchar(45) NOT NULL,
  PRIMARY KEY (`user_role_id`),
  UNIQUE KEY `uni_username_role` (`ROLE`,`username`),
  KEY `fk_username_idx` (`username`),
  CONSTRAINT `fk_username` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_roles`
--

LOCK TABLES `user_roles` WRITE;
/*!40000 ALTER TABLE `user_roles` DISABLE KEYS */;
INSERT INTO `user_roles` VALUES (2,'admin@admin.com','ROLE_ADMIN'),(1,'admin@admin.com','ROLE_USER'),(6,'mailtovelmuruga@gmail.com','ROLE_USER'),(5,'user@user.com','ROLE_USER');
/*!40000 ALTER TABLE `user_roles` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_test`
--

DROP TABLE IF EXISTS `user_test`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_test` (
  `user_test_id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(45) NOT NULL,
  `tests_id` bigint(20) NOT NULL,
  `enabled` tinyint(4) DEFAULT NULL,
  PRIMARY KEY (`user_test_id`),
  UNIQUE KEY `index4` (`username`,`tests_id`),
  KEY `fk_user_test_1_idx` (`tests_id`),
  KEY `fk_user_test_2_idx` (`username`),
  CONSTRAINT `fk_user_test_1` FOREIGN KEY (`tests_id`) REFERENCES `c_tests` (`tests_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `fk_user_test_2` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_test`
--

LOCK TABLES `user_test` WRITE;
/*!40000 ALTER TABLE `user_test` DISABLE KEYS */;
INSERT INTO `user_test` VALUES (1,'mailtovelmuruga@gmail.com',1,NULL);
/*!40000 ALTER TABLE `user_test` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `username` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL,
  `enabled` tinyint(4) NOT NULL DEFAULT '1',
  PRIMARY KEY (`username`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES ('admin@admin.com','admin',1),('mailtovelmuruga@gmail.com','admin',1),('user@user.com','user',1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `vendor`
--

DROP TABLE IF EXISTS `vendor`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `vendor` (
  `vendor_id` bigint(20) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `boothNo` varchar(255) DEFAULT NULL,
  `description` varchar(10000) DEFAULT NULL,
  `email` varchar(10000) DEFAULT NULL,
  `fax` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `showEndDate` datetime DEFAULT NULL,
  `showName` varchar(255) NOT NULL,
  `showStartDate` datetime DEFAULT NULL,
  `vendorName` varchar(255) NOT NULL,
  `website` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vendor_id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `vendor`
--

LOCK TABLES `vendor` WRITE;
/*!40000 ALTER TABLE `vendor` DISABLE KEYS */;
/*!40000 ALTER TABLE `vendor` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `verification_token`
--

DROP TABLE IF EXISTS `verification_token`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `verification_token` (
  `verification_id` int(11) NOT NULL AUTO_INCREMENT,
  `token` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`verification_id`),
  KEY `FKE248B2D5BF229181` (`username`),
  CONSTRAINT `FKE248B2D5BF229181` FOREIGN KEY (`username`) REFERENCES `users` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `verification_token`
--

LOCK TABLES `verification_token` WRITE;
/*!40000 ALTER TABLE `verification_token` DISABLE KEYS */;
INSERT INTO `verification_token` VALUES (1,'763b7dd7-ac99-4349-8b78-63ced9dda622','mailtovelmuruga@gmail.com');
/*!40000 ALTER TABLE `verification_token` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-05-14 11:14:27
