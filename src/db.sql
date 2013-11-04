DROP DATABASE epimarket;
CREATE DATABASE `epimarket` ;
use epimarket;

CREATE TABLE `USER` (
`firstName` VARCHAR( 50 ) NOT NULL ,
`lastName` VARCHAR( 50 ) NOT NULL ,
`email` VARCHAR( 50 ) NOT NULL ,
`Id` INT AUTO_INCREMENT ,
PRIMARY KEY ( `Id` )
);

CREATE TABLE `DVD` (
`title` VARCHAR( 50 ) NOT NULL ,
`descritpion` VARCHAR( 50 ) NOT NULL ,
`prix` int NOT NULL ,
`reduction` int NOT NULL ,
`Id` INT AUTO_INCREMENT ,
PRIMARY KEY ( `Id` )
);

CREATE TABLE `K7` (
`title` VARCHAR( 50 ) NOT NULL ,
`descritpion` VARCHAR( 50 ) NOT NULL ,
`prix` int NOT NULL ,
`reduction` int NOT NULL ,
`Id` INT AUTO_INCREMENT ,
PRIMARY KEY ( `Id` )
);

CREATE TABLE `GAME` (
`title` VARCHAR( 50 ) NOT NULL ,
`descritpion` VARCHAR( 50 ) NOT NULL ,
`prix` int NOT NULL ,
`reduction` int NOT NULL ,
`Id` INT AUTO_INCREMENT ,
PRIMARY KEY ( `Id` )
);