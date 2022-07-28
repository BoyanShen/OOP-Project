-- phpMyAdmin SQL Dump
-- version 5.3.0-dev+20220727.b0c4426a43
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Jul 28, 2022 at 05:09 AM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.5

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `oop`
--

-- --------------------------------------------------------

--
-- Table structure for table `lecturers`
--

CREATE TABLE `lecturers` (
  `id` varchar(16) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `lecturers`
--

INSERT INTO `lecturers` (`id`, `password`) VALUES
('John', '0505');


-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `canView` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `status`
--

INSERT INTO `status` (`canView`) VALUES
(1);

-- --------------------------------------------------------

--
-- Table structure for table `students`
--

CREATE TABLE `students` (
  `id` varchar(16) DEFAULT NULL,
  `password` varchar(16) DEFAULT NULL,
  `voteCount` int(5) DEFAULT 0,
  `hasVoted` tinyint(1) NOT NULL DEFAULT 0,
  `isCandidate` tinyint(1) NOT NULL DEFAULT 0
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `students`
--

INSERT INTO `students` (`id`, `password`, `voteCount`, `hasVoted`, `isCandidate`) VALUES
('Andrew', '1234', 0, 0, 1),
('Adrian', '1234', 0, 0, 1),
('Amy', '1234', 1, 0, 1),
('Anne', '1234', 0, 1, 1),
('Boyan', '1234', 0, 1, 1),
('Bryan', '1234', 0, 0, 1),
('Beth', '1234', 0, 0, 0),
('Becca', '1234', 0, 0, 0),
('Caleb', '1234', 0, 0, 0),
('Carl', '1234', 2, 1, 0),
('Charlotte', '1234', 0, 0, 0),
('Chloe', '1234', 0, 0, 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
