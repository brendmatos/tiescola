-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 14/04/2026 às 00:15
-- Versão do servidor: 10.4.32-MariaDB
-- Versão do PHP: 8.0.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `chamado_tecnico`
--
CREATE DATABASE IF NOT EXISTS `chamado_tecnico` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `chamado_tecnico`;

-- --------------------------------------------------------

--
-- Estrutura para tabela `ti_escola`
--

CREATE TABLE `ti_escola` (
  `id` bigint(20) NOT NULL,
  `solicitante` varchar(100) DEFAULT NULL,
  `sala` varchar(50) NOT NULL,
  `equipamento_tag` varchar(50) DEFAULT NULL,
  `problema_relatado` text DEFAULT NULL,
  `diagnostico_tecnico` text NOT NULL,
  `prioridade` varchar(20) NOT NULL DEFAULT 'MÉDIA',
  `status` varchar(20) NOT NULL DEFAULT 'PENDENTE',
  `data_abertura` timestamp NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `ti_escola`
--
ALTER TABLE `ti_escola`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
