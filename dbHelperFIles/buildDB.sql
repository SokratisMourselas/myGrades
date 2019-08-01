-- --------------------------------------------------------
-- Host:                         127.0.0.1
-- Server version:               10.3.10-MariaDB - mariadb.org binary distribution
-- Server OS:                    Win64
-- HeidiSQL Version:             9.4.0.5125
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!50503 SET NAMES utf8mb4 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Dumping database structure for mygradesdb
CREATE DATABASE IF NOT EXISTS `mygradesdb` /*!40100 DEFAULT CHARACTER SET ascii */;
USE `mygradesdb`;

-- Dumping structure for table mygradesdb.authorities
CREATE TABLE IF NOT EXISTS `authorities` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `authority` varchar(50) NOT NULL,
  UNIQUE KEY `id` (`id`),
  KEY `FK_authorities_users` (`username`),
  CONSTRAINT `FK_authorities_users` FOREIGN KEY (`username`) REFERENCES `users` (`username`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=ascii;

-- Dumping data for table mygradesdb.authorities: ~5 rows (approximately)
DELETE FROM `authorities`;
/*!40000 ALTER TABLE `authorities` DISABLE KEYS */;
INSERT INTO `authorities` (`id`, `username`, `authority`) VALUES
	(3, 'teacher', 'ROLE_GENERAL'),
	(4, 'teacher', 'ROLE_TEACHER'),
	(5, 'student', 'ROLE_GENERAL'),
	(6, 'student', 'ROLE_STUDENT'),
	(7, 'sokratism', 'ROLE_GENERAL');
/*!40000 ALTER TABLE `authorities` ENABLE KEYS */;

-- Dumping structure for table mygradesdb.lesson
CREATE TABLE IF NOT EXISTS `lesson` (
  `uniqueId` int(5) NOT NULL,
  `courseName` varchar(50) NOT NULL,
  `grade` tinyint(1) DEFAULT NULL,
  `teacherId` int(11) DEFAULT NULL,
  PRIMARY KEY (`uniqueId`),
  KEY `FK_lesson_users` (`teacherId`),
  CONSTRAINT `FK_lesson_users` FOREIGN KEY (`teacherId`) REFERENCES `users` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=ascii;

-- Dumping data for table mygradesdb.lesson: ~0 rows (approximately)
DELETE FROM `lesson`;
/*!40000 ALTER TABLE `lesson` DISABLE KEYS */;
INSERT INTO `lesson` (`uniqueId`, `courseName`, `grade`, `teacherId`) VALUES
	(19001, 'Mathematics', 1, 2),
	(19002, 'Physics', 1, 2);
/*!40000 ALTER TABLE `lesson` ENABLE KEYS */;

-- Dumping structure for table mygradesdb.students
CREATE TABLE IF NOT EXISTS `students` (
  `id` int(5) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(60) NOT NULL,
  `lastName` varchar(60) NOT NULL,
  `dateOfBirth` date DEFAULT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FK_students_users` (`userId`),
  CONSTRAINT `FK_students_users` FOREIGN KEY (`userId`) REFERENCES `users` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=ascii;

-- Dumping data for table mygradesdb.students: ~0 rows (approximately)
DELETE FROM `students`;
/*!40000 ALTER TABLE `students` DISABLE KEYS */;
INSERT INTO `students` (`id`, `firstName`, `lastName`, `dateOfBirth`, `userId`) VALUES
	(1, 'Sokratis', 'Mourselas', '1995-06-06', 4);
/*!40000 ALTER TABLE `students` ENABLE KEYS */;

-- Dumping structure for table mygradesdb.users
CREATE TABLE IF NOT EXISTS `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `firstName` varchar(50) DEFAULT NULL,
  `lastName` varchar(50) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `password` char(80) NOT NULL,
  `enabled` int(1) DEFAULT NULL,
  PRIMARY KEY (`username`),
  UNIQUE KEY `id` (`id`),
  UNIQUE KEY `email` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=ascii;

-- Dumping data for table mygradesdb.users: ~3 rows (approximately)
DELETE FROM `users`;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` (`id`, `username`, `firstName`, `lastName`, `email`, `password`, `enabled`) VALUES
	(4, 'sokratism', 'Sokratis', 'Mourselas', 'socmour@hotmail.com', '$2a$10$GVK6/s3by2cZvJn9Jgta0.9Xet2GEhVPcM1nvJ1jUL.Ra5bllK4tW', 1),
	(3, 'student', 'Dimitris', 'Stamopoulos', 'dim.stam@hotmail.com', '$2a$10$lQJJWHVFrelXMYZqL3NONuTQ0QtEWCEuaHRPGxrqHzYoPRD3HuIXO', 1),
	(2, 'teacher', 'Georgios', 'Arampatzis', 'garampatzis@pem.tuc.gr', '$2a$10$5qcp1o5aanzFZciA8eloqe5XQHF5U4Tc2ZBoomYzRWfr4ftQN4fs.', 1);
/*!40000 ALTER TABLE `users` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
