-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Host: db
-- Generation Time: Jun 25, 2020 at 03:48 PM
-- Server version: 8.0.20
-- PHP Version: 7.4.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `stou_zaab`
--

-- --------------------------------------------------------

--
-- Table structure for table `bill`
--

CREATE TABLE `bill` (
  `bill_id` int NOT NULL,
  `bill_odr_id` int DEFAULT NULL,
  `bill_staff_id` varchar(5) DEFAULT NULL,
  `bill_cust_id` varchar(5) DEFAULT NULL,
  `cus_id` varchar(5) DEFAULT NULL,
  `bill_total` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `bill`
--

INSERT INTO `bill` (`bill_id`, `bill_odr_id`, `bill_staff_id`, `bill_cust_id`, `cus_id`, `bill_total`) VALUES
(1, NULL, NULL, NULL, NULL, '0'),
(2, NULL, NULL, NULL, NULL, '0'),
(3, NULL, NULL, NULL, NULL, '0'),
(4, NULL, NULL, NULL, NULL, '0'),
(5, NULL, NULL, NULL, NULL, '0'),
(6, NULL, NULL, NULL, NULL, '0');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `cus_id` int NOT NULL,
  `cus_name` varchar(30) NOT NULL,
  `cus_phone` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`cus_id`, `cus_name`, `cus_phone`) VALUES
(1, 'ขวัญข้าว ทองดี', '0869910382'),
(2, 'ฟ้าประทาน คงมาลัย', '0957670315'),
(3, 'กิ่งแก้ว ตั้งใจ', '0956673431'),
(8, 'ดุจฤดี พอใจ', '0960899375'),
(10, 'พะัพะั', '1231213');

-- --------------------------------------------------------

--
-- Table structure for table `food`
--

CREATE TABLE `food` (
  `food_id` int NOT NULL,
  `food_name` varchar(30) NOT NULL,
  `food_cost` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `food`
--

INSERT INTO `food` (`food_id`, `food_name`, `food_cost`) VALUES
(3, 'ส้มตำปลาร้า', 350),
(4, 'ส้มตำไข่เค็ม', 50),
(5, 'ส้มตำถาด', 70),
(6, 'ลาบหมู / ไก่', 50),
(7, 'น้ำตกหมู', 50),
(8, 'คอหมูย่าง', 60),
(9, 'ต้มแซ่บ', 60),
(10, 'ข้าวเหนียว', 10);

-- --------------------------------------------------------

--
-- Table structure for table `odr`
--

CREATE TABLE `odr` (
  `odr_id` int NOT NULL,
  `odr_food_id` int NOT NULL,
  `odr_amount` int NOT NULL,
  `odr_price` decimal(10,0) NOT NULL,
  `odr_bill_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `odr`
--

INSERT INTO `odr` (`odr_id`, `odr_food_id`, `odr_amount`, `odr_price`, `odr_bill_id`) VALUES
(1, 3, 1, '50', 4),
(2, 5, 3, '70', 4),
(3, 6, 2, '50', 5),
(4, 4, 3, '50', 5),
(5, 9, 1, '60', 6),
(6, 9, 1, '60', 6),
(7, 3, 1, '50', 6),
(8, 3, 1, '350', 6);

-- --------------------------------------------------------

--
-- Table structure for table `staff`
--

CREATE TABLE `staff` (
  `staff_id` int NOT NULL,
  `staff_name` varchar(30) NOT NULL,
  `staff_phone` varchar(12) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `staff`
--

INSERT INTO `staff` (`staff_id`, `staff_name`, `staff_phone`) VALUES
(1, 'ดวงดาว ใจมนต์', '0984538865'),
(2, 'พรทิพย์ บุตะเคียน', '0870049513'),
(3, 'อภิชาติ สุใจ', '0870041893'),
(4, 'ชุมพล หวังงาม', '0864829510');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `bill`
--
ALTER TABLE `bill`
  ADD PRIMARY KEY (`bill_id`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`cus_id`);

--
-- Indexes for table `food`
--
ALTER TABLE `food`
  ADD PRIMARY KEY (`food_id`);

--
-- Indexes for table `odr`
--
ALTER TABLE `odr`
  ADD PRIMARY KEY (`odr_id`);

--
-- Indexes for table `staff`
--
ALTER TABLE `staff`
  ADD PRIMARY KEY (`staff_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `bill`
--
ALTER TABLE `bill`
  MODIFY `bill_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- AUTO_INCREMENT for table `customer`
--
ALTER TABLE `customer`
  MODIFY `cus_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT for table `food`
--
ALTER TABLE `food`
  MODIFY `food_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT for table `odr`
--
ALTER TABLE `odr`
  MODIFY `odr_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT for table `staff`
--
ALTER TABLE `staff`
  MODIFY `staff_id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
