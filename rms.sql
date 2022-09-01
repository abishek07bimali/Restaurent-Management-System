-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Aug 11, 2022 at 04:22 PM
-- Server version: 10.4.24-MariaDB
-- PHP Version: 8.1.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `rms`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `adminId` int(10) NOT NULL,
  `Fullname` varchar(40) NOT NULL,
  `Gender` varchar(10) NOT NULL,
  `Email` varchar(40) NOT NULL,
  `Username` varchar(15) NOT NULL,
  `Password` varchar(20) NOT NULL,
  `Picture` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`adminId`, `Fullname`, `Gender`, `Email`, `Username`, `Password`, `Picture`) VALUES
(1, 'Abishek Bimali', 'Male', 'Abishek@gmail.com', 'abishekbimali', 'asdfzxc1', 'C:\\Users\\Asus\\OneDrive\\Desktop\\download.png'),
(2, 'Abishek', 'Male', '9815077699', 'abishek', 'asdfgh1', ''),
(3, 'abishek', 'Male', 'abi@gmail.com', 'abishek', 'asdfzxcv1', 'C:\\Users\\Asus\\OneDrive\\Documents\\Screenshot 2022-05-31 081806.jpg'),
(4, 'asdf', 'Male', 'abi0a@gmail.com', 'azsx', 'azsxdc1', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `attendance`
--

CREATE TABLE `attendance` (
  `att_id` int(10) NOT NULL,
  `name` varchar(40) NOT NULL,
  `date` varchar(30) NOT NULL,
  `status` varchar(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `attendance`
--

INSERT INTO `attendance` (`att_id`, `name`, `date`, `status`) VALUES
(1, 'Abishek', '2022-06-28-18-18-17', NULL),
(2, 'Abishek', '2022-07-02-13-45-38', NULL),
(3, 'Abishek', '2022-07-02-21-11-41', NULL),
(4, 'Abishek', '2022-07-02-21-12-07', NULL),
(5, 'Abishek', '2022-07-02-21-13-01', NULL),
(6, 'Abishek', '2022-07-02-21-30-58', NULL),
(7, 'Abishek Bimali', '2022-07-03-14-21-06', NULL),
(8, 'Abishek Bimali', '2022-07-03-14-25-00', NULL),
(9, 'Abishek Bimali', '2022-07-03-14-26-50', NULL),
(10, 'Abishek Bimali', '2022-07-03-15-28-49', NULL),
(11, 'Abishek Bimali', '2022-07-03-15-41-02', NULL),
(12, 'Abishek Bimali', '2022-07-03-20-41-38', NULL),
(13, 'Abishek Bimali', '2022-07-04-20-45-10', NULL),
(14, 'Abishek Bimali', '2022-07-06-13-48-13', NULL),
(15, 'Abishek Bimali', '2022-07-24-21-11-56', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `id` int(10) NOT NULL,
  `name` varchar(20) NOT NULL,
  `citizen_no` varchar(20) NOT NULL,
  `gender` varchar(20) NOT NULL,
  `address` varchar(20) NOT NULL,
  `phone` varchar(20) NOT NULL,
  `mail` varchar(20) NOT NULL,
  `username` varchar(20) NOT NULL,
  `password` varchar(20) NOT NULL,
  `position` varchar(20) NOT NULL,
  `salary` varchar(20) NOT NULL,
  `married` varchar(20) NOT NULL,
  `picture` varchar(200) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`id`, `name`, `citizen_no`, `gender`, `address`, `phone`, `mail`, `username`, `password`, `position`, `salary`, `married`, `picture`) VALUES
(7, 'Abishek Bimali', '11-22-33', 'Male', 'Birtamode', '1111122222', 'abi@gmail.com', 'aaa', 'bb', 'cc', '123', 'Married', 'C:\\Users\\Asus\\OneDrive\\Desktop\\download.png');

-- --------------------------------------------------------

--
-- Table structure for table `ordertable`
--

CREATE TABLE `ordertable` (
  `OrderId` int(10) NOT NULL,
  `TabelID` varchar(10) DEFAULT NULL,
  `Name` varchar(40) DEFAULT NULL,
  `Quantity` varchar(20) DEFAULT NULL,
  `Total` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `ordertable`
--

INSERT INTO `ordertable` (`OrderId`, `TabelID`, `Name`, `Quantity`, `Total`) VALUES
(6, '1', ' MoMo', '1', '149.99'),
(8, '1', 'Tea', '1', '29.99'),
(9, '1', 'Chow Mein ', '1', '149.99'),
(10, '1', 'Sekuwa', '1', '399.99'),
(11, '12', 'Chicken Soup', '1', '299.99'),
(12, '12', 'Burgers ', '1', '150.00'),
(13, '12', 'Meatloaf', '1', '399.99'),
(14, '1', 'Fried MoMo', '1', '199.99'),
(15, '1', 'Hot Dog', '4', '999.96'),
(16, '1', 'Coffee', '2', '399.98'),
(17, '1', 'Fried MoMo', '7', '1399.93'),
(18, '1', 'Chicken Soup', '4', '1199.96'),
(19, '12', 'Burgers ', '1', '150.00'),
(20, '12', 'Meatloaf', '3', '1199.97'),
(21, '1', 'Fried MoMo', '1', '199.99');

-- --------------------------------------------------------

--
-- Table structure for table `product`
--

CREATE TABLE `product` (
  `product_id` int(10) NOT NULL,
  `product_name` varchar(10) NOT NULL,
  `product_code` varchar(20) NOT NULL,
  `product_available` varchar(15) NOT NULL,
  `product_price` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `product`
--

INSERT INTO `product` (`product_id`, `product_name`, `product_code`, `product_available`, `product_price`) VALUES
(2, 'food1', '1112222', 'Not available', '1111'),
(3, 'fod1', 'hello', 'Not available', '123');

-- --------------------------------------------------------

--
-- Table structure for table `totalsales`
--

CREATE TABLE `totalsales` (
  `id` int(11) NOT NULL,
  `date` varchar(20) NOT NULL,
  `totalsales` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

--
-- Dumping data for table `totalsales`
--

INSERT INTO `totalsales` (`id`, `date`, `totalsales`) VALUES
(1, '2022-06-30', '10'),
(3, '2022-06-30', '0'),
(4, '2022-06-30', '22.00'),
(5, '2022-06-30', '44.00'),
(6, '2022-06-28', '22.00'),
(7, '2022-06-30', '44.00'),
(8, '2022-06-30', '66.00'),
(9, '2022-06-22', '22.00'),
(11, '2022-06-30', '00'),
(12, '2022-07-02', '3.29'),
(13, '2022-07-02', '6.58'),
(14, '2022-07-02', '16.45'),
(15, '2022-07-03', '3790.26'),
(16, '2022-07-03', '1441.93'),
(17, '2022-07-03', '00'),
(18, '2022-07-06', '1596.46');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`adminId`);

--
-- Indexes for table `attendance`
--
ALTER TABLE `attendance`
  ADD PRIMARY KEY (`att_id`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `ordertable`
--
ALTER TABLE `ordertable`
  ADD PRIMARY KEY (`OrderId`);

--
-- Indexes for table `product`
--
ALTER TABLE `product`
  ADD PRIMARY KEY (`product_id`);

--
-- Indexes for table `totalsales`
--
ALTER TABLE `totalsales`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `admin`
--
ALTER TABLE `admin`
  MODIFY `adminId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT for table `attendance`
--
ALTER TABLE `attendance`
  MODIFY `att_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=16;

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `ordertable`
--
ALTER TABLE `ordertable`
  MODIFY `OrderId` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=22;

--
-- AUTO_INCREMENT for table `product`
--
ALTER TABLE `product`
  MODIFY `product_id` int(10) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `totalsales`
--
ALTER TABLE `totalsales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
