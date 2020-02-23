-- MySQL dump 10.13  Distrib 5.7.27, for Win64 (x86_64)
--
-- Host: localhost    Database: zshop
-- ------------------------------------------------------
-- Server version	5.7.27

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `t_cart`
--

DROP TABLE IF EXISTS `t_cart`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_cart` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '购物车主键id',
  `customer_id` int(11) unsigned DEFAULT NULL COMMENT '客户的id',
  `product_id` int(11) unsigned DEFAULT NULL COMMENT '商品的id',
  `product_num` int(100) unsigned DEFAULT NULL COMMENT '商品数量',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '商品加入购物车的时间',
  `total_price` double DEFAULT NULL COMMENT '某一购物车商品总价',
  `status` tinyint(1) DEFAULT NULL COMMENT '表示购物车中的某个商品是否有效,默认有效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=57 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_cart`
--

LOCK TABLES `t_cart` WRITE;
/*!40000 ALTER TABLE `t_cart` DISABLE KEYS */;
INSERT INTO `t_cart` VALUES (1,14,29,1,'2019-04-06 07:15:11',0.1,0),(2,14,52,1,'2019-04-06 07:20:25',0.1,0),(3,14,31,1,'2019-04-06 07:21:11',0.1,0),(4,14,50,1,'2019-04-06 07:22:02',0.1,0),(5,14,31,1,'2019-04-06 07:23:34',0.1,0),(6,14,31,1,'2019-04-06 07:27:14',0.1,0),(7,14,55,1,'2019-04-06 07:56:27',0.1,1),(8,17,18,1,'2019-04-06 08:20:53',0.1,0),(9,14,18,1,'2019-04-07 04:20:26',0.1,1),(10,14,31,1,'2019-04-07 06:33:23',0.1,0),(11,14,50,1,'2019-04-07 06:34:09',0.1,0),(12,14,18,1,'2019-04-07 09:07:52',0.1,0),(13,14,31,1,'2019-04-07 09:19:41',0.1,0),(14,18,20,1,'2019-12-05 07:11:10',0.1,2),(15,18,20,1,'2019-12-05 07:11:23',0.1,0),(16,42,2,1,'2019-12-11 03:55:29',2222,0),(17,42,21,2,'2019-12-11 03:55:53',10998,0),(18,42,32,1,'2019-12-11 03:57:37',1999,0),(19,42,28,10,'2019-12-11 03:58:52',86990,0),(20,42,19,2,'2019-12-11 04:04:30',9598,0),(21,42,28,1,'2019-12-11 11:00:40',8699,0),(22,42,29,1,'2019-12-11 11:16:11',8699,0),(23,42,27,1,'2019-12-11 11:16:19',8699,0),(24,42,30,1,'2019-12-11 11:16:24',8699,0),(25,42,20,6,'2019-12-11 11:23:19',28794,0),(26,42,6,1,'2019-12-11 12:05:58',2999,0),(27,42,12,1,'2019-12-11 12:06:03',4599,0),(28,42,17,1,'2019-12-11 12:06:10',4799,0),(29,42,3,17,'2019-12-11 12:06:48',37774,0),(30,42,2,1,'2019-12-11 12:27:07',2222,0),(31,42,2,3,'2019-12-12 00:49:21',6666,0),(32,42,20,1,'2019-12-12 02:08:06',4799,0),(33,42,8,4,'2019-12-12 03:31:19',11996,0),(34,42,15,1,'2019-12-12 07:17:04',4799,0),(35,42,32,1,'2019-12-12 07:18:10',1999,0),(36,42,19,1,'2019-12-13 06:41:35',4799,0),(37,42,20,1,'2019-12-13 06:42:16',4799,0),(38,42,20,1,'2019-12-13 07:21:01',4799,1),(39,2,32,1,'2019-12-16 07:14:36',1999,0),(40,2,27,1,'2019-12-16 07:17:29',8699,0),(41,2,3,1,'2019-12-16 07:22:26',2222,0),(42,2,7,1,'2019-12-16 12:14:26',2999,0),(43,2,3,1,'2019-12-18 07:55:05',2222,0),(44,2,7,4,'2019-12-18 07:55:14',11996,0),(45,2,12,1,'2019-12-18 07:55:27',4599,0),(46,2,8,1,'2019-12-18 07:55:39',2999,0),(47,2,6,2,'2020-02-02 11:00:55',5998,0),(48,2,6,2,'2020-02-02 11:00:58',5998,0),(49,3,32,1,'2020-02-06 12:06:28',1999,0),(50,3,32,1,'2020-02-06 12:08:18',1999,0),(51,3,7,1,'2020-02-06 12:08:56',2999,0),(52,3,3,1,'2020-02-08 08:20:10',2222,1),(53,18,30,1,'2020-02-08 11:53:26',8699,0),(54,18,30,1,'2020-02-08 11:54:17',8699,2),(55,18,19,1,'2020-02-08 12:39:10',4799,0),(56,18,19,1,'2020-02-08 12:39:14',4799,0);
/*!40000 ALTER TABLE `t_cart` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_customer`
--

DROP TABLE IF EXISTS `t_customer`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_customer` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(20) NOT NULL,
  `password` varchar(50) NOT NULL,
  `phone` varchar(20) DEFAULT NULL,
  `address` varchar(30) DEFAULT NULL,
  `is_valid` int(11) DEFAULT NULL,
  `regist_date` datetime DEFAULT NULL,
  `images` varchar(200) DEFAULT '/static/images/user.png',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=19 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_customer`
--

LOCK TABLES `t_customer` WRITE;
/*!40000 ALTER TABLE `t_customer` DISABLE KEYS */;
INSERT INTO `t_customer` VALUES (1,'DENG','123','13487304600','广东省',1,NULL,'/static/images/user.png'),(2,'Deg','123123','19812140190','斗门区',1,'2019-12-10 19:39:10','/static/images/boy.png'),(3,'DENG-','123123','19812140191','广东省',1,'2020-02-06 20:05:51','/static/images/user.png'),(18,'DENG','123123','19812140194','南方IT学院',1,'2020-02-08 19:42:28','/static/images/boy.png');
/*!40000 ALTER TABLE `t_customer` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_customer_role`
--

DROP TABLE IF EXISTS `t_customer_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_customer_role` (
  `customer_id` int(11) DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_customer_role`
--

LOCK TABLES `t_customer_role` WRITE;
/*!40000 ALTER TABLE `t_customer_role` DISABLE KEYS */;
/*!40000 ALTER TABLE `t_customer_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order`
--

DROP TABLE IF EXISTS `t_order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '订单的id',
  `order_number` varchar(300) DEFAULT NULL COMMENT '订单编号',
  `customer_id` int(11) DEFAULT NULL COMMENT '用户的id',
  `price` double DEFAULT NULL COMMENT '该笔订单的商品总价',
  `create_date` timestamp NULL DEFAULT NULL COMMENT '订单生成的时间',
  `product_number` int(11) DEFAULT NULL COMMENT '该笔订单中包含的所有商品数量',
  `status` tinyint(4) DEFAULT NULL COMMENT '订单的状态，默认0未支付未发货，1则表示支付未发货，2表示已发货未收货，3 表示已完成交易，4表示订单取消，5表示删除订单',
  `address` varchar(200) DEFAULT NULL COMMENT '订单的收获地址',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `customer_id` (`customer_id`) USING BTREE,
  CONSTRAINT `t_order_ibfk_1` FOREIGN KEY (`customer_id`) REFERENCES `t_customer` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order`
--

LOCK TABLES `t_order` WRITE;
/*!40000 ALTER TABLE `t_order` DISABLE KEYS */;
INSERT INTO `t_order` VALUES (7,'202002021582778288',2,5998,'2020-02-02 11:01:15',2,5,'广东省珠海市斗门区斗门区白蕉镇南方IT学院'),(8,'202002020383133735',2,5998,'2020-02-02 11:14:20',2,5,'广东省珠海市斗门区斗门区白蕉镇南方IT学院'),(9,'202002020242043442',2,2999,'2020-02-02 11:30:34',1,0,'广东省珠海市斗门区斗门区白蕉镇南方IT学院'),(10,'202002060059787086',3,1999,'2020-02-06 12:07:45',1,0,'湖南省岳阳市平江县12'),(11,'202002060224943938',3,1999,'2020-02-06 12:08:20',1,0,'湖南省岳阳市平江县12'),(12,'202002060960463571',3,2999,'2020-02-06 12:08:58',1,0,'湖南省岳阳市平江县12'),(13,'202002080003365767',18,8699,'2020-02-08 12:13:56',1,1,'广东省珠海市斗门区南方IT学院'),(14,'202002080464487480',18,4799,'2020-02-08 12:39:16',1,5,'广东省珠海市斗门区南方IT学院'),(15,'202002080123807447',18,4799,'2020-02-08 14:25:49',1,0,'广东省珠海市斗门区南方IT学院');
/*!40000 ALTER TABLE `t_order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_order_item`
--

DROP TABLE IF EXISTS `t_order_item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_order_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '类目表id',
  `product_id` int(11) DEFAULT NULL COMMENT '商品id',
  `num` int(11) DEFAULT NULL COMMENT '类目商品数量',
  `price` double DEFAULT NULL COMMENT '类目商品小计',
  `order_id` int(11) DEFAULT NULL COMMENT '订单id',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `product_id` (`product_id`) USING BTREE,
  KEY `order_id` (`order_id`) USING BTREE,
  CONSTRAINT `t_order_item_ibfk_1` FOREIGN KEY (`product_id`) REFERENCES `t_product` (`id`),
  CONSTRAINT `t_order_item_ibfk_2` FOREIGN KEY (`order_id`) REFERENCES `t_order` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=16 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_order_item`
--

LOCK TABLES `t_order_item` WRITE;
/*!40000 ALTER TABLE `t_order_item` DISABLE KEYS */;
INSERT INTO `t_order_item` VALUES (7,6,2,5998,7),(8,6,2,5998,8),(9,8,1,2999,9),(10,32,1,1999,10),(11,32,1,1999,11),(12,7,1,2999,12),(13,30,1,8699,13),(14,19,1,4799,14),(15,19,1,4799,15);
/*!40000 ALTER TABLE `t_order_item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product`
--

DROP TABLE IF EXISTS `t_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `price` double DEFAULT NULL,
  `info` varchar(200) DEFAULT NULL,
  `image` varchar(200) DEFAULT NULL,
  `product_type_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  KEY `product_type_id` (`product_type_id`) USING BTREE,
  CONSTRAINT `t_product_ibfk_1` FOREIGN KEY (`product_type_id`) REFERENCES `t_product_type` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product`
--

LOCK TABLES `t_product` WRITE;
/*!40000 ALTER TABLE `t_product` DISABLE KEYS */;
INSERT INTO `t_product` VALUES (1,'iPhone 7',2222,'iPhone 7 金色 64GB','/static/images/iPhone/iphone7-golden.png',1),(2,'iPhone 7',2222,'iPhone 7 玫瑰金色 64GB','/static/images/iPhone/iphone7-rosegold.png',1),(3,'iPhone 7',2222,'iPhone 7 银色 64GB','/static/images/iPhone/iphone7-silver.png',1),(4,'iPhone 7',2222,'iPhone 7 黑色 64GB','/static/images/iPhone/iphone7-black.png',1),(5,'iPhone 7 Plus',2999,'iPhone 7 Plus 金色 64GB','/static/images/iPhone/iphone7-golden.png',1),(6,'iPhone 7 Plus',2999,'iPhone 7 Plus 玫瑰金色 64GB','/static/images/iPhone/iphone7-rosegold.png',1),(7,'iPhone 7 Plus',2999,'iPhone 7 Plus 银色 64GB','/static/images/iPhone/iphone7-silver.png',1),(8,'iPhone 7 Plus',2999,'iPhone 7 Plus 黑色 64GB','/static/images/iPhone/iphone7-black.png',1),(9,'iPhone 8',3999,'iPhone 8 深空灰色 64G','/static/images/iPhone/iphone8-spacegrey.png',2),(10,'iPhone 8',3999,'iPhone 8 金色 64G','/static/images/iPhone/iphone8-golden.png',2),(11,'iPhone 8',3999,'iPhone 8 银色 64G','/static/images/iPhone/iphone8-silver.png',2),(12,'iPhone 8 Plus',4599,'iPhone 8 Plus 深空灰色 64G','/static/images/iPhone/iphone8-spacegrey.png',2),(13,'iPhone 8 Plus',4599,'iPhone 8 Plus 金色 64G','/static/images/iPhone/iphone8-golden.png',2),(14,'iPhone 8 Plus',4599,'iPhone 8 Plus 银色 64G','/static/images/iPhone/iphone8-silver.png',2),(15,'iPhone XR',4799,'iPhone XR 珊瑚色 64G','/static/images/iPhone/iphone-xr-coralline.png',3),(16,'iPhone XR',4799,'iPhone XR 黑色 64G','/static/images/iPhone/iphone-xr-black.png',3),(17,'iPhone XR',4799,'iPhone XR 蓝色 64G','/static/images/iPhone/iphone-xr-blue.png',3),(18,'iPhone XR',4799,'iPhone XR 红色 64G','/static/images/iPhone/iphone-xr-red.png',3),(19,'iPhone XR',4799,'iPhone XR 白色 64G','/static/images/iPhone/iphone-xr-white.png',3),(20,'iPhone XR',4799,'iPhone XR 黄色 64G','/static/images/iPhone/iphone-xr-yellow.png',3),(21,'iPhone 11',5499,'iPhone 11 黑色 64G','/static/images/iPhone/iphone11-black.png',4),(22,'iPhone 11',5499,'iPhone 11 绿色 64G','/static/images/iPhone/iphone11-green.png',4),(23,'iPhone 11',5499,'iPhone 11 紫色 64G','/static/images/iPhone/iphone11-purple.png',4),(24,'iPhone 11',5499,'iPhone 11 红色 64G','/static/images/iPhone/iphone11-red.png',4),(25,'iPhone 11',5499,'iPhone 11 白色 64G','/static/images/iPhone/iphone11-white.png',4),(26,'iPhone 11',5499,'iPhone 11 黄色 64G','/static/images/iPhone/iphone11-yellow.png',4),(27,'iPhone 11 Pro',8699,'iPhone 11 Pro 暗夜绿色 64G','/static/images/iPhone/iphone11-pro-darkgreen.png',5),(28,'iPhone 11 Pro',8699,'iPhone 11 Pro 金色 64G','/static/images/iPhone/iphone11-pro-golden.png',5),(29,'iPhone 11 Pro',8699,'iPhone 11 Pro 银色 64G','/static/images/iPhone/iphone11-pro-silver.png',5),(30,'iPhone 11 Pro',8699,'iPhone 11 Pro 深空灰色 64G','/static/images/iPhone/iphone11-pro-spacegrey.png',5),(31,'AirPods',1588,'AirPods','/static/images/AirPods/airPods.jpg',6),(32,'AirPods Pro',1999,'AirPods Pro','/static/images/AirPods/airPods-pro.jpg',6),(33,'iPhone 7',29999,'内存64G 黑色 4.7寸屏幕','/static/images/1581168408(1).jpg',1);
/*!40000 ALTER TABLE `t_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_product_type`
--

DROP TABLE IF EXISTS `t_product_type`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_product_type` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(200) NOT NULL,
  `status` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `name` (`name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_product_type`
--

LOCK TABLES `t_product_type` WRITE;
/*!40000 ALTER TABLE `t_product_type` DISABLE KEYS */;
INSERT INTO `t_product_type` VALUES (1,'iPhone 7',1),(2,'iPhone 8',1),(3,'iPhone xr',1),(4,'iPhone 11',1),(5,'iPhone 11 Pro',1),(6,'AirPods',1),(9,'iPhone 6s',0);
/*!40000 ALTER TABLE `t_product_type` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_role`
--

DROP TABLE IF EXISTS `t_role`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_role` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `role_name` varchar(50) NOT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `role_name` (`role_name`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_role`
--

LOCK TABLES `t_role` WRITE;
/*!40000 ALTER TABLE `t_role` DISABLE KEYS */;
INSERT INTO `t_role` VALUES (2,'会员用户'),(1,'普通用户'),(3,'超级管理员');
/*!40000 ALTER TABLE `t_role` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_shipping`
--

DROP TABLE IF EXISTS `t_shipping`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_shipping` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '收货地址的主键id',
  `customer_id` int(11) unsigned DEFAULT NULL COMMENT '客户id,地址绑定客户',
  `receiver_name` varchar(200) DEFAULT NULL COMMENT '收货人的姓名',
  `receiver_mobile` varchar(100) DEFAULT NULL COMMENT '收货人的手机号码',
  `receiver_city` varchar(50) DEFAULT NULL COMMENT '城市名称',
  `receiver_province` varchar(50) DEFAULT NULL COMMENT '省份名称',
  `receiver_district` varchar(100) DEFAULT NULL COMMENT '区, 区域, 县, 地域, 一带, 禺',
  `create_time` timestamp NULL DEFAULT NULL COMMENT '创建时间',
  `update_time` timestamp NULL DEFAULT NULL COMMENT '更新时间',
  `status` tinyint(4) DEFAULT NULL COMMENT '收货地址标志：默认为0，1 表示默认的收获地址，备注：这里是预留字段',
  `address_detail` varchar(100) DEFAULT NULL COMMENT '收货地址的详情地址',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_shipping`
--

LOCK TABLES `t_shipping` WRITE;
/*!40000 ALTER TABLE `t_shipping` DISABLE KEYS */;
INSERT INTO `t_shipping` VALUES (23,42,'deng','19812140194','珠海市','广东省','斗门区','2019-12-13 01:36:56','2019-12-13 01:36:56',1,'斗门区白蕉镇南方IT学院'),(24,42,'deng','19812140194','珠海市','广东省','斗门区','2019-12-13 01:38:39','2019-12-13 01:38:39',1,'斗门区白蕉镇南方IT学院'),(25,42,'deng','19812140194','珠海市','广东省','斗门区','2019-12-13 01:39:16','2019-12-13 01:39:16',1,'斗门区白蕉镇南方IT学院'),(26,42,'deng','19812140194','珠海市','广东省','斗门区','2019-12-13 01:56:20','2019-12-13 03:57:17',0,'斗门区白蕉镇南方IT学院'),(27,42,'deng','19812140194','珠海市','广东省','斗门区','2019-12-13 02:13:44','2019-12-13 03:57:13',0,'斗门区白蕉镇南方IT学院'),(28,42,'den','19812140194','珠海市','广东省','斗门区','2019-12-13 02:55:27','2019-12-13 03:57:09',0,'白蕉镇南方IT学院'),(29,2,'deng','19812140194','珠海市','广东省','斗门区','2019-12-16 07:17:50','2019-12-16 07:17:50',1,'斗门区白蕉镇南方IT学院'),(30,3,'邓梁','19812140194','岳阳市','湖南省','平江县','2020-02-06 12:07:39','2020-02-06 12:07:39',1,'12'),(31,18,'李四','19812140194','珠海市','广东省','斗门区','2020-02-08 12:09:45','2020-02-08 12:11:42',1,'南方IT学院');
/*!40000 ALTER TABLE `t_shipping` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `t_sysuser`
--

DROP TABLE IF EXISTS `t_sysuser`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `t_sysuser` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `login_name` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `phone` varchar(50) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `is_valid` int(11) DEFAULT NULL,
  `create_date` datetime DEFAULT NULL,
  `role_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE KEY `login_name` (`login_name`) USING BTREE,
  KEY `role_id` (`role_id`) USING BTREE,
  CONSTRAINT `t_sysuser_ibfk_1` FOREIGN KEY (`role_id`) REFERENCES `t_role` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8 ROW_FORMAT=DYNAMIC;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `t_sysuser`
--

LOCK TABLES `t_sysuser` WRITE;
/*!40000 ALTER TABLE `t_sysuser` DISABLE KEYS */;
INSERT INTO `t_sysuser` VALUES (1,'admin','123123','19812140194','1913753881@qq.com',1,NULL,3);
/*!40000 ALTER TABLE `t_sysuser` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-23 14:11:35
