-- phpMyAdmin SQL Dump
-- version 4.8.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Waktu pembuatan: 03 Bulan Mei 2019 pada 14.47
-- Versi server: 10.1.33-MariaDB
-- Versi PHP: 7.1.18

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `db_kuis`
--

-- --------------------------------------------------------

--
-- Struktur dari tabel `tb_biodata`
--

CREATE TABLE `tb_biodata` (
  `id` int(11) NOT NULL,
  `nama` varchar(1000) NOT NULL,
  `usia` int(4) NOT NULL,
  `domisili` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Struktur dari tabel `webs`
--

CREATE TABLE `webs` (
  `id` int(11) NOT NULL,
  `kode` varchar(50) NOT NULL,
  `nama` varchar(50) NOT NULL,
  `url` varchar(50) NOT NULL,
  `pemilik` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data untuk tabel `webs`
--

INSERT INTO `webs` (`id`, `kode`, `nama`, `url`, `pemilik`) VALUES
(0, 'W1', 'Bukalapak', 'bukalapak.com', 'Achmad Zaky');

--
-- Indexes for dumped tables
--

--
-- Indeks untuk tabel `tb_biodata`
--
ALTER TABLE `tb_biodata`
  ADD PRIMARY KEY (`id`);

--
-- Indeks untuk tabel `webs`
--
ALTER TABLE `webs`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
