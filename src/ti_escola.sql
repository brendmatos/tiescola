-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 28/04/2026 às 02:08
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
-- Banco de dados: `ti_escola`
--
CREATE DATABASE IF NOT EXISTS `ti_escola` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `ti_escola`;

-- --------------------------------------------------------

--
-- Estrutura para tabela `chamado_tecnico`
--

CREATE TABLE `chamado_tecnico` (
  `id` bigint(20) NOT NULL,
  `id_usuario` int(11) DEFAULT NULL,
  `id_equipamento` int(11) DEFAULT NULL,
  `problema_relatado` text DEFAULT NULL,
  `diagnostico_tecnico` text NOT NULL,
  `prioridade` varchar(20) NOT NULL DEFAULT 'MÉDIA',
  `status` varchar(20) NOT NULL DEFAULT 'PENDENTE',
  `data_abertura` varchar(10) NOT NULL DEFAULT current_timestamp()
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `chamado_tecnico`
--

INSERT INTO `chamado_tecnico` (`id`, `id_usuario`, `id_equipamento`, `problema_relatado`, `diagnostico_tecnico`, `prioridade`, `status`, `data_abertura`) VALUES
(6, 2, 1, 'lllllll', 'llllllll', 'MÉDIA', 'ABERTO', '23/04/26'),
(7, 2, 1, 'aaaaa', 'aaaaaaaa', 'ALTA', 'ABERTO', '23/04/26');

-- --------------------------------------------------------

--
-- Estrutura para tabela `equipamentos`
--

CREATE TABLE `equipamentos` (
  `id_equipamento` int(11) NOT NULL,
  `tag_patrimonio` varchar(50) NOT NULL,
  `sala` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `equipamentos`
--

INSERT INTO `equipamentos` (`id_equipamento`, `tag_patrimonio`, `sala`) VALUES
(1, 'csds', 'dsdsds');

-- --------------------------------------------------------

--
-- Estrutura para tabela `usuarios`
--

CREATE TABLE `usuarios` (
  `id_usuario` int(11) NOT NULL,
  `nome` varchar(100) NOT NULL,
  `email` varchar(100) NOT NULL,
  `senha` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `usuarios`
--

INSERT INTO `usuarios` (`id_usuario`, `nome`, `email`, `senha`) VALUES
(2, 'a', 'a', '$2a$10$N80Bw0vFG8SK7oOLt65nUOB48E3ytnpPs6dl97ryh1F1PnuNPYxQW');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `chamado_tecnico`
--
ALTER TABLE `chamado_tecnico`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_usuario_chamado` (`id_usuario`),
  ADD KEY `fk_equipamento_chamado` (`id_equipamento`);

--
-- Índices de tabela `equipamentos`
--
ALTER TABLE `equipamentos`
  ADD PRIMARY KEY (`id_equipamento`),
  ADD UNIQUE KEY `tag_patrimonio` (`tag_patrimonio`);

--
-- Índices de tabela `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `chamado_tecnico`
--
ALTER TABLE `chamado_tecnico`
  MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de tabela `equipamentos`
--
ALTER TABLE `equipamentos`
  MODIFY `id_equipamento` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de tabela `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `id_usuario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Restrições para tabelas despejadas
--

--
-- Restrições para tabelas `chamado_tecnico`
--
ALTER TABLE `chamado_tecnico`
  ADD CONSTRAINT `fk_equipamento_chamado` FOREIGN KEY (`id_equipamento`) REFERENCES `equipamentos` (`id_equipamento`),
  ADD CONSTRAINT `fk_usuario_chamado` FOREIGN KEY (`id_usuario`) REFERENCES `usuarios` (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
