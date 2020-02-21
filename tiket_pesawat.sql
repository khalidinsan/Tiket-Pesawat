-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jan 02, 2020 at 09:06 AM
-- Server version: 10.3.16-MariaDB
-- PHP Version: 7.3.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `tiket_pesawat`
--

-- --------------------------------------------------------

--
-- Table structure for table `maskapai`
--

CREATE TABLE `maskapai` (
  `id_maskapai` int(11) NOT NULL,
  `nama_maskapai` varchar(200) NOT NULL,
  `logo` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `maskapai`
--

INSERT INTO `maskapai` (`id_maskapai`, `nama_maskapai`, `logo`) VALUES
(1, 'Garuda Indonesia', 'garudaindonesia.png'),
(2, 'Citilink', 'citilink.png'),
(3, 'Air Asia', 'airasia.png'),
(4, 'Batik Air', 'batikair.png');

-- --------------------------------------------------------

--
-- Table structure for table `rute`
--

CREATE TABLE `rute` (
  `id_rute` int(11) NOT NULL,
  `id_maskapai` int(11) NOT NULL,
  `asal` varchar(200) NOT NULL,
  `tujuan` varchar(200) NOT NULL,
  `kelas` varchar(100) NOT NULL,
  `harga` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `rute`
--

INSERT INTO `rute` (`id_rute`, `id_maskapai`, `asal`, `tujuan`, `kelas`, `harga`) VALUES
(1, 1, 'Jakarta', 'Surabaya', 'Ekonomi', 700000),
(2, 1, 'Jakarta', 'Denpasar', 'Ekonomi', 1500000),
(3, 1, 'Surabaya', 'Jakarta', 'Ekonomi', 700000),
(4, 1, 'Surabaya', 'Denpasar', 'Ekonomi', 1000000),
(5, 1, 'Denpasar', 'Jakarta', 'Ekonomi', 1500000),
(6, 1, 'Denpasar', 'Surabaya', 'Ekonomi', 1000000),
(7, 1, 'Jakarta', 'Surabaya', 'Bisnis', 1200000),
(8, 1, 'Jakarta', 'Denpasar', 'Bisnis', 2000000),
(9, 1, 'Surabaya', 'Jakarta', 'Bisnis', 1200000),
(10, 1, 'Surabaya', 'Denpasar', 'Bisnis', 1500000),
(11, 1, 'Denpasar', 'Jakarta', 'Bisnis', 2000000),
(12, 1, 'Denpasar', 'Surabaya', 'Bisnis', 1500000),
(13, 1, 'Jakarta', 'Surabaya', 'VIP', 1950000),
(14, 1, 'Jakarta', 'Denpasar', 'VIP', 2750000),
(15, 1, 'Surabaya', 'Jakarta', 'VIP', 1950000),
(16, 1, 'Surabaya', 'Denpasar', 'VIP', 2250000),
(17, 1, 'Denpasar', 'Jakarta', 'VIP', 2750000),
(18, 1, 'Denpasar', 'Surabaya', 'VIP', 2250000),
(19, 2, 'Jakarta', 'Surabaya', 'Ekonomi', 500000),
(20, 2, 'Jakarta', 'Denpasar', 'Ekonomi', 1300000),
(21, 2, 'Surabaya', 'Jakarta', 'Ekonomi', 500000),
(22, 2, 'Surabaya', 'Denpasar', 'Ekonomi', 800000),
(23, 2, 'Denpasar', 'Jakarta', 'Ekonomi', 1300000),
(24, 2, 'Denpasar', 'Surabaya', 'Ekonomi', 800000),
(25, 2, 'Jakarta', 'Surabaya', 'Bisnis', 1000000),
(26, 2, 'Jakarta', 'Denpasar', 'Bisnis', 1800000),
(27, 2, 'Surabaya', 'Jakarta', 'Bisnis', 1000000),
(28, 2, 'Surabaya', 'Denpasar', 'Bisnis', 1300000),
(29, 2, 'Denpasar', 'Jakarta', 'Bisnis', 1800000),
(30, 2, 'Denpasar', 'Surabaya', 'Bisnis', 1300000),
(31, 3, 'Jakarta', 'Surabaya', 'Ekonomi', 600000),
(32, 3, 'Jakarta', 'Denpasar', 'Ekonomi', 1400000),
(33, 3, 'Surabaya', 'Jakarta', 'Ekonomi', 600000),
(34, 3, 'Surabaya', 'Denpasar', 'Ekonomi', 900000),
(35, 3, 'Denpasar', 'Jakarta', 'Ekonomi', 1400000),
(36, 3, 'Denpasar', 'Surabaya', 'Ekonomi', 900000),
(37, 3, 'Jakarta', 'Surabaya', 'Bisnis', 1100000),
(38, 3, 'Jakarta', 'Denpasar', 'Bisnis', 1900000),
(39, 3, 'Surabaya', 'Jakarta', 'Bisnis', 1100000),
(40, 3, 'Surabaya', 'Denpasar', 'Bisnis', 1400000),
(41, 3, 'Denpasar', 'Jakarta', 'Bisnis', 1900000),
(42, 3, 'Denpasar', 'Surabaya', 'Bisnis', 1400000),
(43, 3, 'Jakarta', 'Surabaya', 'VIP', 1850000),
(44, 3, 'Jakarta', 'Denpasar', 'VIP', 2650000),
(45, 3, 'Surabaya', 'Jakarta', 'VIP', 1850000),
(46, 3, 'Surabaya', 'Denpasar', 'VIP', 2150000),
(47, 3, 'Denpasar', 'Jakarta', 'VIP', 2650000),
(48, 3, 'Denpasar', 'Surabaya', 'VIP', 2150000),
(49, 4, 'Jakarta', 'Surabaya', 'Ekonomi', 500000),
(50, 4, 'Jakarta', 'Denpasar', 'Ekonomi', 1300000),
(51, 4, 'Surabaya', 'Jakarta', 'Ekonomi', 500000),
(52, 4, 'Surabaya', 'Denpasar', 'Ekonomi', 800000),
(53, 4, 'Denpasar', 'Jakarta', 'Ekonomi', 1300000),
(54, 4, 'Denpasar', 'Surabaya', 'Ekonomi', 800000),
(55, 4, 'Jakarta', 'Surabaya', 'Bisnis', 1000000),
(56, 4, 'Jakarta', 'Denpasar', 'Bisnis', 1800000),
(57, 4, 'Surabaya', 'Jakarta', 'Bisnis', 1000000),
(58, 4, 'Surabaya', 'Denpasar', 'Bisnis', 1300000),
(59, 4, 'Denpasar', 'Jakarta', 'Bisnis', 1800000),
(60, 4, 'Denpasar', 'Surabaya', 'Bisnis', 1300000),
(61, 4, 'Jakarta', 'Surabaya', 'VIP', 1750000),
(62, 4, 'Jakarta', 'Denpasar', 'VIP', 2550000),
(63, 4, 'Surabaya', 'Jakarta', 'VIP', 1750000),
(64, 4, 'Surabaya', 'Denpasar', 'VIP', 2050000),
(65, 4, 'Denpasar', 'Jakarta', 'VIP', 2550000),
(66, 4, 'Denpasar', 'Surabaya', 'VIP', 2050000);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `maskapai`
--
ALTER TABLE `maskapai`
  ADD PRIMARY KEY (`id_maskapai`);

--
-- Indexes for table `rute`
--
ALTER TABLE `rute`
  ADD PRIMARY KEY (`id_rute`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `maskapai`
--
ALTER TABLE `maskapai`
  MODIFY `id_maskapai` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `rute`
--
ALTER TABLE `rute`
  MODIFY `id_rute` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=67;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
