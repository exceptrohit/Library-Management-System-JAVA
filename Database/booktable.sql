-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jul 10, 2021 at 09:28 PM
-- Server version: 10.4.6-MariaDB
-- PHP Version: 7.3.8

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `dbms_project`
--

-- --------------------------------------------------------

--
-- Table structure for table `booktable`
--

CREATE TABLE `booktable` (
  `book_id` int(10) NOT NULL,
  `book_name` varchar(50) NOT NULL,
  `author` varchar(50) NOT NULL,
  `status` tinyint(1) NOT NULL DEFAULT 1,
  `stid` int(10) DEFAULT NULL,
  `duedate` date DEFAULT NULL,
  `fine` float DEFAULT NULL,
  `issuedate` date DEFAULT NULL,
  `request` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `booktable`
--

INSERT INTO `booktable` (`book_id`, `book_name`, `author`, `status`, `stid`, `duedate`, `fine`, `issuedate`, `request`) VALUES
(1, 'firstbook', 'first author', 0, 1, '2021-05-10', 620, '2021-01-10', 0),
(2, 'second book', 'author', 0, 1, '2021-08-09', 0, '2021-07-09', 1),
(4, 'testbook', 'author', 1, NULL, NULL, 0, NULL, 0),
(5, 'test', 'author1', 0, 4, '2021-08-10', 0, '2021-07-10', 0),
(6, 'hello', 'author2', 0, 11, '2021-08-09', 0, '2021-07-09', 0),
(7, 'testjava', 'a1', 1, NULL, NULL, NULL, NULL, 0),
(8, 'testjava1', 'a1', 0, 4, '2020-08-29', 3160, '2020-07-29', 0),
(10, 'java2', 'a2', 0, 4, '2021-08-10', 0, '2021-07-10', 0),
(13, 'harry potter', 'jkr', 0, 1, '2021-03-10', 1230, '2021-01-10', 0),
(14, 'harry potter 2', 'jkr', 0, 1, '2021-08-10', 0, '2021-07-10', 1),
(15, 'twilight', 'meyer', 0, 1, '2021-08-10', 0, '2021-07-10', 0),
(16, 'test2021', 'author2021', 1, NULL, NULL, NULL, NULL, 0),
(17, 'again2021', 'author21', 0, 4, '2021-08-10', 0, '2021-07-10', 0),
(18, 'hola', 'fgkhfgh', 1, NULL, NULL, NULL, NULL, 0),
(19, 'tata', 'ratan', 1, NULL, NULL, NULL, NULL, 0);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `booktable`
--
ALTER TABLE `booktable`
  ADD PRIMARY KEY (`book_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `booktable`
--
ALTER TABLE `booktable`
  MODIFY `book_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
