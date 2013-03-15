/*
SQLyog Enterprise - MySQL GUI v7.12 
MySQL - 5.1.40-community : Database - desedm
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;

CREATE DATABASE /*!32312 IF NOT EXISTS*/`desedm` /*!40100 DEFAULT CHARACTER SET latin1 */;

USE `desedm`;

/*Table structure for table `descontent` */

DROP TABLE IF EXISTS `descontent`;

CREATE TABLE `descontent` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `input_file_name` varchar(200) DEFAULT NULL,
  `input_file_path` varchar(200) DEFAULT NULL,
  `output_file_name` varchar(200) DEFAULT NULL,
  `output_file_path` varchar(200) DEFAULT NULL,
  `hash_input` varchar(50) DEFAULT NULL,
  `hash_output` varchar(50) DEFAULT NULL,
  `trivia` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;

/*Data for the table `descontent` */

insert  into `descontent`(`id`,`input_file_name`,`input_file_path`,`output_file_name`,`output_file_path`,`hash_input`,`hash_output`,`trivia`) values (7,'loremipsum_inp.txt','C:\\Users\\Baran\\Desktop\\Crypto\\JAX-WSRPCPro\\loremipsum_inp.txt','loremipsum_inp_139821104934900222447065033885224517803.enc','C:\\Users\\Baran\\Desktop\\Crypto\\JAX-WSRPCPro\\loremipsum_inp_139821104934900222447065033885224517803.enc','3470074571','3717763143','1234-4567-8910-2345'),(6,'loremipsum_inp.txt','C:\\Users\\Baran\\Desktop\\Crypto\\JAX-WSRPCEx\\loremipsum_inp.txt','loremipsum_inp_233791748694139990319682670690557272739.enc','C:\\Users\\Baran\\Desktop\\Crypto\\JAX-WSRPCEx\\loremipsum_inp_233791748694139990319682670690557272739.enc','3470074571','3717763143','1234-4567-8910-2345'),(8,'loremipsum_inp.txt','C:\\Users\\Baran\\Desktop\\Crypto\\JAX-WSRPCPro\\loremipsum_inp.txt','loremipsum_inp_68324782374304057550113228240832301009.enc','C:\\Users\\Baran\\Desktop\\Crypto\\JAX-WSRPCPro\\loremipsum_inp_68324782374304057550113228240832301009.enc','3470074571','3717763143','1234-4567-8910-2345');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
