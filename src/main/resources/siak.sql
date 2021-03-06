-- phpMyAdmin SQL Dump
-- version 3.4.5
-- http://www.phpmyadmin.net
--
-- Host: localhost
-- Generation Time: Jun 03, 2014 at 11:46 PM
-- Server version: 5.5.16
-- PHP Version: 5.3.8

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Database: `siak`
--

-- --------------------------------------------------------

--
-- Table structure for table `m_ambil`
--

CREATE TABLE IF NOT EXISTS `m_ambil` (
  `a_id_ambil` int(11) NOT NULL AUTO_INCREMENT,
  `a_npm` varchar(10) NOT NULL,
  `a_kelas` varchar(20) NOT NULL,
  `a_lahan_praktek` text NOT NULL,
  `a_kode_dosen` varchar(8) NOT NULL,
  `a_kode_mk` varchar(8) NOT NULL,
  PRIMARY KEY (`a_id_ambil`),
  KEY `a_kode_dosen` (`a_kode_dosen`),
  KEY `a_kode_mk` (`a_kode_mk`),
  KEY `a_npm` (`a_npm`)
) ENGINE=InnoDB  DEFAULT CHARSET=latin1 AUTO_INCREMENT=9 ;

--
-- Dumping data for table `m_ambil`
--

INSERT INTO `m_ambil` (`a_id_ambil`, `a_npm`, `a_kelas`, `a_lahan_praktek`, `a_kode_dosen`, `a_kode_mk`) VALUES
(5, '12.001.021', 'B Siang', '-', '10222333', 'PK505'),
(6, '12.001.129', 'B Siang', '-', '10222333', 'PK505'),
(7, '12.001.127', 'B Siang', '-', '10222333', 'PK505'),
(8, '12.001.020', 'B Siang', '-', '10222333', 'PK505');

-- --------------------------------------------------------

--
-- Table structure for table `m_dosen`
--

CREATE TABLE IF NOT EXISTS `m_dosen` (
  `d_kode_dosen` varchar(8) NOT NULL,
  `d_nama_dosen` varchar(60) NOT NULL,
  `d_nidn` varchar(16) NOT NULL,
  `d_riwayat_pendidikan` varchar(20) NOT NULL,
  `d_alamat` text NOT NULL,
  `d_kontak` varchar(13) NOT NULL,
  `d_status` tinyint(1) NOT NULL,
  PRIMARY KEY (`d_kode_dosen`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_dosen`
--

INSERT INTO `m_dosen` (`d_kode_dosen`, `d_nama_dosen`, `d_nidn`, `d_riwayat_pendidikan`, `d_alamat`, `d_kontak`, `d_status`) VALUES
('10222333', 'Wahyudin ST MKOM', '132', 'S2', 'Bandung', '085720010024', 1),
('10222334', 'Taupik Hasanudin ST', '137', 'S1', 'Bandung', '087833344423', 1);

-- --------------------------------------------------------

--
-- Table structure for table `m_komponen_nilai`
--

CREATE TABLE IF NOT EXISTS `m_komponen_nilai` (
  `kn_id_komponen_nilai` int(11) NOT NULL,
  `kn_nilai_kehadiran` tinyint(4) NOT NULL,
  `kn_nilai_tugas` decimal(10,0) NOT NULL,
  `kn_nilai_uts` decimal(10,0) NOT NULL,
  `kn_nilai_uas` decimal(10,0) NOT NULL,
  PRIMARY KEY (`kn_id_komponen_nilai`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_komponen_nilai`
--

INSERT INTO `m_komponen_nilai` (`kn_id_komponen_nilai`, `kn_nilai_kehadiran`, `kn_nilai_tugas`, `kn_nilai_uts`, `kn_nilai_uas`) VALUES
(5, 0, 0, 0, 0),
(6, 0, 0, 0, 0),
(7, 0, 0, 0, 0),
(8, 0, 0, 0, 0);

-- --------------------------------------------------------

--
-- Table structure for table `m_mahasiswa`
--

CREATE TABLE IF NOT EXISTS `m_mahasiswa` (
  `mhs_npm` varchar(10) NOT NULL,
  `mhs_nama_lengkap` varchar(60) NOT NULL,
  `mhs_tempat_lahir` varchar(50) NOT NULL,
  `mhs_tanggal_lahir` date NOT NULL,
  `mhs_jns_kelamin` char(1) NOT NULL,
  `mhs_asal_sekolah` varchar(60) NOT NULL,
  `mhs_alamat` text NOT NULL,
  `mhs_nama_orang_tua` varchar(60) NOT NULL COMMENT 'wali',
  `mhs_pekerjaan_orang_tua` varchar(60) NOT NULL COMMENT 'wali',
  `mhs_judul_penelitian` varchar(50) NOT NULL,
  `mhs_status` tinyint(1) NOT NULL,
  PRIMARY KEY (`mhs_npm`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_mahasiswa`
--

INSERT INTO `m_mahasiswa` (`mhs_npm`, `mhs_nama_lengkap`, `mhs_tempat_lahir`, `mhs_tanggal_lahir`, `mhs_jns_kelamin`, `mhs_asal_sekolah`, `mhs_alamat`, `mhs_nama_orang_tua`, `mhs_pekerjaan_orang_tua`, `mhs_judul_penelitian`, `mhs_status`) VALUES
('09.001.014', 'Cecep Ceppy M.G', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('09.001.043', 'Ganis Kawenang', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.001', 'Abdan Syakur', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.002', 'Adi Ryan ANS', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.003', 'Agung Sonjaya', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.004', 'Ahmad Rustendi', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.005', 'Ahsani Lestari', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.006', 'Alfa Feto Efendi', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.008', 'Amirul Ikhsan', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.009', 'Anang Aldiansyah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.010', 'Andri Charadika', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.011', 'Andrian Firmansyah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.012', 'Anggrek Janur', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.013', 'Anzar Sumyana', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.014', 'Aram Musliman', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.015', 'Arie Subekti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.017', 'Aris Kadarisman', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.018', 'Asep Patah Hidayat', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.019', 'Bagus Yudha Hartono Putranto', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.020', 'Cahya Tresna Septiani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.021', 'Candra Sugiri', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.022', 'Christofel Hehahia', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.023', 'Cindhy Mariza', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.024', 'Dadan Ramdani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.025', 'Deden Juliansyah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.028', 'Diana Cristy Agustin', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.030', 'Dita Puspita', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.031', 'Dwi Vita D.', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.032', 'Eka Jayanti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.033', 'Elisabeth Bunga', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.034', 'Eva Putrianti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.035', 'Eri Haryati', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.036', 'Erina Cahyany', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.037', 'Erni Megawaty', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.038', 'Fachmy Ibrahim', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.039', 'Faishal Hadi Citra', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.040', 'Febby Firmansyah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.041', 'Fenny Siti Ramayanti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.042', 'Ferina BR. Ginting', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.043', 'Ferissa Apyenti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.044', 'Feti Sri Dewanti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.046', 'Fitanur Fitriana', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.047', 'Fitria Cici Apriani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.048', 'Fitry Sri Apriyanty', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.049', 'Frambadi Wiji W.', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.050', 'Fransiskus X. Saudale', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.051', 'Gerri Reggi K.', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.052', 'Gilar Dwi Cahya', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.053', 'Gina Nurfadilah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.054', 'Hana Farida Ulfah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.055', 'Hendrianto', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.056', 'Herawati', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.058', 'Janu Arismunandar', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.059', 'Kania Diana', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.060', 'Kanya Riandini', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.061', 'Kekey Zakaria', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.062', 'Leli Yulipah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.063', 'Liza Oktarina', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.064', 'Lucky Muhamad R.', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.065', 'Maria Fransiska', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.066', 'Maria Margareta', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.067', 'Maria Oktaviana', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.068', 'Maria Yosefina Sarina Bima', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.069', 'Mayang Sari', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.070', 'Mega Handriani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.071', 'Meivadiza Putri', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.072', 'Melkialdus Missa', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.073', 'Muhammad Fatir Naufal', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.074', 'Muhammad Reinanda P.', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.075', 'Neneng Nuraini', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.076', 'Nia Siti N. S.', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.077', 'Nita', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.078', 'Noor Maessani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.079', 'Novita Fauziyanti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.080', 'Nurmalawati Kusumah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.082', 'Perawati Setiawan', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.083', 'Philipus Lakun Usi Letor', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.084', 'Qurrota Ayunil Falah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.085', 'R. Iqbal Taufik N.', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.086', 'Rahadian Kurnia', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.087', 'Rida Hardani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.088', 'Rinensa Susi Syarifah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.089', 'Rinrin Candriyani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.090', 'Riska Ayudya P.', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.091', 'Risma Yuli Pramesti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.092', 'Riyan Suhendar', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.093', 'Rizal Fauzi', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.094', 'Rizal Nulhakim', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.096', 'Rizky Kurniawan', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.097', 'Roni Rediyansah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.098', 'Rumi Herlina Illu Boling', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.099', 'Rusliadi Kustiawan', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.100', 'Sandi Septiani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.101', 'Sandy Eka Sidik', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.102', 'Sanita Kosmila', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.103', 'Saverius Babo Benge', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.104', 'Sifa Mandiri', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.105', 'Simon Petrus Mangusura', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.106', 'Sin Sin Sintani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.108', 'Siti Verawati', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.109', 'Sophia Euphrasia Bena', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.110', 'Sunita Dewi Maryam', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.111', 'Supandiah Masnun Dewi SR', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.112', 'Susan Yuliana', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.113', 'Susi Dwi Febrianti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.114', 'Syaikhul Wahab', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.115', 'Syifa Shilviana', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.116', 'Thio Suhada', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.117', 'Tri Wibowo', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.118', 'Wildan F. Pratama', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.119', 'Wini Silviyana', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.120', 'Wulan Sari Sidik P.', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.121', 'Yanuar Muchamad', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.122', 'Yohan Julian Mega Nanda', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.123', 'Yuda Sandi Aji', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.124', 'Yudi Adistira L.', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.126', 'Yuliana Daeng Duli', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.127', 'Yulius Kristian', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.128', 'Yulvinna Birahmatika', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.129', 'Yuni Wahyuningtias', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.130', 'Yurita Murti Nugraha', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('10.001.131', 'Yusuf Yustaman', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.002', 'Ade Irawan', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.003', 'Adella Adriani Widiarti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.004', 'Agisa Subangkit', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.005', 'Agung Gumilar', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.006', 'Akbar Fani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.007', 'Ali Ansor Nurohman', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.010', 'Anggit Permatasari', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.011', 'Anggun Putri Larasati', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.012', 'Anis Nuriyanti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.013', 'Annurilah Lismayanti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.014', 'Astri Setiana', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.015', 'Budi Kurniawan', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.016', 'Budi Utami', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.017', 'Defri Junjunan', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.018', 'Delviana', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.019', 'Deni Sandi Hermawan', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.022', 'Dian Fitriyani Mustofa', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.023', 'Dian Permatasari Effendi', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.024', 'Dina Juniarti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.026', 'Eka Wahyu K.', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.027', 'Elisa Fitri', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.028', 'Elizabeth Nona Windy', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.029', 'Elsa Ruhwiyati Agnia', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.030', 'Ema Maemunah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.031', 'Emilda Susan', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.032', 'Eri Erdiana', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.033', 'Faizal Akbar', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.034', 'Faizal Ragil P.', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.035', 'Fajar Evriana', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.036', 'Fajar Koharudin', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.037', 'Farida Puji Maulida', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.038', 'Fatmawati', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.039', 'Fauzan', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.040', 'Fauzan Akbar Ramdhana', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.041', 'Febriyanti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.042', 'Firda Maulida H.', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.044', 'Fita Siti Nurjanah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.046', 'Geri Sugara', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.047', 'Ginna Febriananda', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.048', 'Hamdan Hendra Mukti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.049', 'Hani Nuryani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.050', 'Hanidah sucirayinda', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.052', 'Hendra Suparman', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.053', 'Hendri Suparman', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.054', 'Horasma Sianturi', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.057', 'Iis Astuti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.058', 'Imam Asyidiq', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.059', 'Intan Nur Anisa', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.060', 'Isra Prasetia', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.061', 'Jati Nugraha', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.062', 'Jayanti Lestari', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.063', 'Jeini Nurmalasari', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.064', 'Jejen Mohamad Jaenudin', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.065', 'Joni Prasetio', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.066', 'Juliawaldi L. H.', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.067', 'Karolus Bertholomeus Wawo', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.069', 'Meilani Dewi Nuraeni', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.070', 'Maria Konsolata Aek', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.071', 'Maria Yelinda', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.072', 'Maria Yenne Bunga T', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.073', 'Marini Setiawati', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.074', 'Mega Fachri Maulidin', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.075', 'Mentari Fuji Insani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.076', 'Mochamad Isya Arafat', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.078', 'Muhamad Kahfiansyah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.079', 'Muhammad Hafidh Firdaus', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.080', 'Muhammad Qurreys', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.081', 'Nanang Sukarna', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.082', 'Nasrul Husna Al Givari', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.083', 'Nela Kusmiati', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.084', 'Nisrina Khairunnisa Fauziah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.085', 'Novi Anggraeni', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.086', 'Novianti Ratnasari', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.087', 'Novia Fahik', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.088', 'Okka Saputra Pratama', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.089', 'Oktaviana Stefanie Mema', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.091', 'Rangga Loka', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.093', 'Riskiana Rachmandani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.094', 'Rismala Dewi', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.095', 'Risnawati', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.096', 'Rizal Nurdiansyah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.098', 'Rizki Kholiludin Romdhoni', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.099', 'Romana Deno Gadiga''a', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.101', 'Ryan Wilka Ramdani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.103', 'Sanjaya', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.104', 'Santi Fitriyani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.105', 'Santi Soendari', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.106', 'Septian Nugraha', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.107', 'Septian Putra Yudha Sakti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.110', 'Siska Nurlela', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.111', 'Siti Muzdalifah Rohmah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.112', 'Sylvia Eka Putri', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.113', 'Tantan Permady', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.114', 'Trisma Wulan Lestari', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.115', 'Vini Sinatrya Nirashido', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.116', 'Vinny Nur Indah Lestari', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.117', 'Wanda Setiawan', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.118', 'Wanura Nabilla Belbandeya', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.119', 'Wike Karlina', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.120', 'Wita Sopahhiah Agustina', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.122', 'Yosef Triana', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.123', 'Yunita Kristianty', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.124', 'Yunita Femilian Riadianty', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.125', 'Wike Dwikawati', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.126', 'Lufthansa Siti Miranti A', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.127', 'Iksan Sopian Santosa', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('11.001.128', 'Herni Pebrianti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.001', 'Adifa Destira', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.002', 'Agung Febrianto', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.003', 'Agung Restu Ardiansyah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.004', 'Ahmad Abdul Majid', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.005', 'Ajeng Oktaviani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.006', 'Amalia Dwita', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.007', 'Ana Silviana Wulan Sari', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.008', 'Anggi Dhiba Lestari', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.009', 'Anggita Nandiyan P', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.010', 'Anggun Cintami', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.011', 'Anisa Noveliana', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.012', 'Asep Rosma', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.013', 'Asep Umin', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.014', 'Ayu Rizki Lestari', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.015', 'Azan Insan S', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.016', 'Azie Maulana Sidiq', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.017', 'Boki Nurhasanah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.018', 'Cecep Samsudin', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.019', 'Cucu Tri Mulyati', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.020', 'Daby Maulana', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.021', 'Dadan Hendriawan', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.022', 'Dandy Faqih Munazar', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.023', 'Dani Purnama', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.024', 'Debby Cynthia Setianingsih', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.025', 'Dede Lili Rohili', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.026', 'Deden Nurdiana', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.027', 'Defi Septiawan N.', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.028', 'Defi Septiawan Nugraha', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.029', 'Dewi Permatasari', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.030', 'Dian Andriani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.031', 'Dika Hardie Dikriawan', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.032', 'Dimas Wibowo', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.033', 'Dinda Ridmawan Jumantoro', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.034', 'Dwi Rizki Anggia', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.035', 'Ela Nurlaila Megandini', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.036', 'Elisa Verawati', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.037', 'Elva Anggraeni', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.038', 'Eri Mochamad Rizal', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.039', 'Erin Maharani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.040', 'Euis Kartiska', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.041', 'Fauziah Fadillah A.', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.042', 'Fitra Nurasyah Amelinda', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.043', 'Fitra Nurfitriani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.044', 'Fitri Erliyani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.045', 'Fitri Widaningsih', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.046', 'Fitriyanti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.047', 'Fitriyantika', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.048', 'Frank Jumers Wairatta', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.049', 'Ghita Megalia', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.050', 'Gilang Dandri', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.051', 'Gina Sulistina', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.052', 'Gita Noviyanti Kharisma', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.053', 'Granida', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.054', 'Guntara', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.055', 'Hermawanto', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.056', 'Heru Tryo Mulyana', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.057', 'Idham', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.058', 'Ilman Munadyansalman', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.059', 'Indri Sugi Aprilia', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.060', 'Inten Sundarina', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.061', 'Irfan Rohaendi', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.062', 'Irin Nurswandi', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.063', 'Isti Siti Marhamah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.064', 'Ivan Sayid Nurahman', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.065', 'Jejen Jaenal Aripin', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.066', 'Julianti Eka Sapitri', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.067', 'Kania Patriani Puspita', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.068', 'Khomarudin', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.069', 'Khotijah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.070', 'Kurnia Ari Sobari', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.071', 'Latansa Hanifan Q', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.072', 'Lika Mirnawati', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.074', 'Maria Hiasinta Meo', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.075', 'Maria Regina', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.076', 'Marina Soraya', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.077', 'Marta Arifin N.', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.078', 'Maslina Pandiangan', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.079', 'Mega Noer H.', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.080', 'Mega Silvia', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.081', 'Meki Fahik', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.082', 'Meli', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.083', 'Melisa Primatasari', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.084', 'Mikjaya Yusuf', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.085', 'Mina Mukarohmah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.086', 'Mita Karlita', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.087', 'Mochamad Arief Rinaldi', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.088', 'Mohamad Azhar', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.089', 'Muhamad Taufik Apriansyah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.090', 'Nanan Septyani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.091', 'Nely Hulia', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.092', 'Nerisa Arviana', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.093', 'Nia Kurniawati', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.094', 'Nida Diwidian', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.095', 'Novi Santika', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.096', 'Noviliani Magdalena', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.097', 'Nurhasanah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.098', 'Nurlina Wulansari', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.099', 'Nurul Fauziah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.100', 'Nurul Rahma Habibah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.101', 'Opik Firmansyah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.102', 'Paramitha', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.103', 'Periyana', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.104', 'Puri Tri Rahayu', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.105', 'Purnama Meita D', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.106', 'Putri Lestari', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.107', 'R. Anggi Anggraeni', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.108', 'Rara Dewi Utami', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.109', 'Ratna Pradita Putri', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.110', 'Revani Febriana', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.111', 'Reynaldi Aji Pradana', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.112', 'Reza Syairun', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.113', 'Rima Kusuma', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.114', 'Rini Karlina', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.115', 'Rini Khoirunnisa', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.116', 'Ripa Agustina', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.117', 'Risna Rahmayanti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.118', 'Rizki Nugraha', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.119', 'Rizky Ramdani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.120', 'Rodeka Wati', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.121', 'Ropikoh Nopianti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.122', 'Roshela Nopanti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.123', 'Roza Dewi Sukma', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.125', 'Rully Ruswandi Awaludin', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.126', 'Ryan Pratama Putra', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.127', 'Santi Nurmala', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.128', 'Santi Septiani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.129', 'Septriyana Aji Nugraha', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.130', 'Sigit Baihaqi', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.131', 'Silvi Nuraeni', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.132', 'Sri Lestari', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.133', 'Sujatmiko Trisusilo', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.134', 'Susi Susanti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.135', 'Taufik Setiawan', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.136', 'Tesya Rifani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.137', 'Tira Nurmita', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.138', 'Tri Agus Lestari', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.139', 'Tri Patriani', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.140', 'Tria Faturochman', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.141', 'Trisna Cahya Ginanjar', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.142', 'Vivi Tria Anasthasi Febrina', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.143', 'Wicaksana Adiputra', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.144', 'Widayanti', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.146', 'Yanti Widia', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.147', 'Yoga Arifin', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.148', 'Yogi Mulyadi', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.149', 'Yudi Saefudin', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.150', 'Yuliana Danuk', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1),
('12.001.151', 'Yunita Nurhasanah', 'Bandung', '2022-02-22', 'L', 'SMA NEGERI 1 BANDUNG', 'Jl.cijerah', 'X', 'Wiraswasta', '-', 1);

-- --------------------------------------------------------

--
-- Table structure for table `m_mata_kuliah`
--

CREATE TABLE IF NOT EXISTS `m_mata_kuliah` (
  `mk_kode_mk` varchar(8) NOT NULL,
  `mk_nama_mk` varchar(60) NOT NULL,
  `mk_sks` tinyint(4) NOT NULL,
  `mk_semester` tinyint(2) NOT NULL,
  `mk_status` tinyint(1) NOT NULL,
  PRIMARY KEY (`mk_kode_mk`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `m_mata_kuliah`
--

INSERT INTO `m_mata_kuliah` (`mk_kode_mk`, `mk_nama_mk`, `mk_sks`, `mk_semester`, `mk_status`) VALUES
('PK101', 'Pendidikan Agama', 2, 1, 1),
('PK102', 'Pendidikan Pancasila', 2, 1, 1),
('PK104', 'Bahasa Indonesia', 2, 5, 1),
('PK105', 'Bahasa Inggris I', 2, 1, 1),
('PK106', 'Bahasa Inggris II', 2, 2, 1),
('PK107', 'Bahasa Inggris III', 2, 3, 1),
('PK201', 'Biomedik I (Biologi & Genetika Manusia)', 2, 1, 1),
('PK202', 'Biomedik II (Anatomi)', 2, 1, 1),
('PK203', 'Biomedik III (Fisiologi)', 2, 1, 1),
('PK204', 'Biomedik IV (Patologi)', 2, 2, 1),
('PK205', 'Biomedik V (Farmakologi)', 2, 4, 1),
('PK206', 'IPLK I (Terminologi Medis I)', 2, 1, 1),
('PK207', 'IPLK II (Terminologi Medis II)', 2, 2, 1),
('PK208', 'IPLK III (Terminologi Laboratorium)', 2, 2, 1),
('PK209', 'Biostatistik', 2, 2, 1),
('PK210', 'Administrasi Kesehatan Masyarakat', 2, 2, 1),
('PK211', 'Pengantar Manajemen Kesehatan', 2, 3, 1),
('PK212', 'Dasar-Dasar Akuntasi Kesehatan', 2, 4, 1),
('PK213', 'Ilmu Kesehatan Masyarakat', 2, 1, 1),
('PK301', 'PSRM I (Dasar-Dasar Peng. & Sejarah RM)', 2, 1, 1),
('PK302', 'PSRM II (Manajemen Berkas &  Isi RM)', 2, 2, 1),
('PK303', 'PSRM III (Sistem RM Yankes)', 2, 3, 1),
('PK304', 'PSRM IV (Sistem Informasi URM)', 2, 4, 1),
('PK305', 'PSRM V (Manajemen URM)', 2, 5, 1),
('PK306', 'PSRM VII (POMR)', 2, 4, 1),
('PK307', 'Epidemiologi Kesehatan', 2, 3, 1),
('PK308', 'KPT I (General Coding)', 3, 2, 1),
('PK309', 'KPT II (Morbidity Coding I)', 3, 3, 1),
('PK310', 'KPT III (Morbidity Coding II)', 3, 4, 1),
('PK311', 'KPT IV (Mortality Coding)', 3, 5, 1),
('PK312', 'Kependudukan & Lingkungan Hidup', 2, 3, 1),
('PK313', 'PSIK I (Program Aplikasi Komputer I)', 3, 2, 1),
('PK314', 'PSIK II (Program Aplikasi Komputer II)', 3, 3, 1),
('PK315', 'PSIK III (Statistik Yankes)', 2, 3, 1),
('PK316', 'PSIK IV (Pemrograman I)', 3, 4, 1),
('PK317', 'PSIK V (Pemrograman II)', 3, 5, 1),
('PK318', 'PSIK VI (EPI Info)', 3, 5, 1),
('PK319', 'PSIK VII (MIS)', 2, 6, 1),
('PK320', 'PSIK VIII (SIK Nasional)', 2, 6, 1),
('PK322', 'Quality Assurance/Akreditasi RM)', 2, 6, 1),
('PK401', 'Psikologi Terapan', 2, 4, 1),
('PK402', 'Etik & Etika Profesi', 2, 6, 1),
('PK403', 'Pendidikan Kesehatan Masyarakat', 2, 5, 1),
('PK404', 'Public Relation/Customer Service', 2, 6, 1),
('PK405', 'Matematika', 2, 1, 1),
('PK406', 'PSRM VI (Ergonomi & PURM)', 2, 4, 1),
('PK407', 'PSRM VIII (Hukum Kesehatan)', 2, 3, 1),
('PK408', 'Metodologi Riset Kesehatan', 2, 5, 1),
('PK409', 'Ilmu Komunikasi', 2, 2, 1),
('PK410', 'Kewirausahaan', 2, 6, 1),
('PK501', 'Praktek Laboratorium Klinik', 2, 2, 1),
('PK502', 'Praktek Kerja Lapangan I', 2, 2, 1),
('PK503', 'Praktek Kerja Lapangan II', 2, 4, 1),
('PK504', 'Praktek Kerja Lapangan III', 2, 5, 1),
('PK505', 'Karya Tulis Ilmiah', 4, 6, 1);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `m_ambil`
--
ALTER TABLE `m_ambil`
  ADD CONSTRAINT `m_ambil_ibfk_5` FOREIGN KEY (`a_kode_dosen`) REFERENCES `m_dosen` (`d_kode_dosen`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `m_ambil_ibfk_6` FOREIGN KEY (`a_kode_mk`) REFERENCES `m_mata_kuliah` (`mk_kode_mk`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `m_ambil_ibfk_8` FOREIGN KEY (`a_npm`) REFERENCES `m_mahasiswa` (`mhs_npm`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Constraints for table `m_komponen_nilai`
--
ALTER TABLE `m_komponen_nilai`
  ADD CONSTRAINT `m_komponen_nilai_ibfk_1` FOREIGN KEY (`kn_id_komponen_nilai`) REFERENCES `m_ambil` (`a_id_ambil`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
