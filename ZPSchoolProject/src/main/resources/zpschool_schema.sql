create database zpschool;

use zpschool;

CREATE TABLE IF NOT EXISTS `Users` (
  `person_Id` int NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `email_Id` varchar(50) NOT NULL,
  `mobile_Number` varchar(20) NOT NULL,
  `date_Of_Birth` varchar(50) NOT NULL,
  `address` varchar(20) NOT NULL,
  `pwd` varchar(200) NOT NULL,
  `created_at` TIMESTAMP NOT NULL,
  `created_by` varchar(50) NOT NULL,
  `updated_at` TIMESTAMP DEFAULT NULL,
  `updated_by` varchar(50) DEFAULT NULL
);