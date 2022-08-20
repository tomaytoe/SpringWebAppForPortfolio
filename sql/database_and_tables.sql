CREATE DATABASE IF NOT EXISTS `spring_web_app_portfolio`;
USE `spring_web_app_portfolio`;	

DROP TABLE IF EXISTS `customer`;
DROP TABLE IF EXISTS `skill`;
DROP TABLE IF EXISTS `project`;
DROP TABLE IF EXISTS `image`;
DROP TABLE IF EXISTS `topic`;

CREATE TABLE `customer`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `email` varchar(45) NOT NULL,
    `first_name` varchar(45),
    `last_name` varchar(45),
    `password` varchar(45) NOT NULL,
    PRIMARY KEY (`id`)
)ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `skill`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `skill` varchar(45) NOT NULL,
    `customer_id` int(11) NOT NULL,
    PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `project`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `name` varchar(45) UNIQUE NOT NULL,
    `subject` varchar(45),
    `customer_id` int(11) NOT NULL,
     PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `image`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `image` blob NOT NULL,
    `project_id` int(11) NOT NULL,
     PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;

CREATE TABLE `topic`(
	`id` int(11) NOT NULL AUTO_INCREMENT,
    `topic` text,
    `customer_id` int(11) NOT NULL,
     PRIMARY KEY(`id`)
)ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4;