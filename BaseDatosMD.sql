-- phpMyAdmin SQL Dump
-- version 4.9.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Generation Time: Dec 27, 2019 at 05:55 PM
-- Server version: 10.3.18-MariaDB
-- PHP Version: 7.3.11

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `DELTADB`
--

-- --------------------------------------------------------

--
-- Table structure for table `PAGOS`
--

CREATE TABLE `PAGOS` (
  `id_pago` int(11) NOT NULL,
  `fecha_pago` date DEFAULT NULL,
  `monto_pago` double DEFAULT NULL,
  `id_reporte` int(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `REPORTES`
--

CREATE TABLE `REPORTES` (
  `id_reporte` int(11) NOT NULL,
  `fecha_inicio_reporte` date DEFAULT NULL,
  `fecha_fin_reporte` date DEFAULT NULL,
  `id_tarea` int(11) DEFAULT NULL,
  `id_sitio` int(11) DEFAULT NULL,
  `item` int(11) DEFAULT NULL,
  `id_sede` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `SEDES`
--

CREATE TABLE `SEDES` (
  `id_sede` int(11) NOT NULL,
  `nombre_supervisor` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `SITIOS`
--

CREATE TABLE `SITIOS` (
  `id_sitio` int(11) NOT NULL,
  `nombre_sitio` varchar(45) DEFAULT NULL,
  `latitud` varchar(45) DEFAULT NULL,
  `altitud` varchar(45) DEFAULT NULL,
  `id_sede` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `TAREAS`
--

CREATE TABLE `TAREAS` (
  `id_tarea` int(11) NOT NULL,
  `ticket` varchar(15) DEFAULT NULL,
  `fecha_inicio_tarea` date DEFAULT NULL,
  `fecha_fin_tarea` date DEFAULT NULL,
  `item` int(11) DEFAULT NULL,
  `id_sede` int(11) DEFAULT NULL,
  `rda` varchar(10) DEFAULT NULL,
  `id_sitio` int(11) DEFAULT NULL,
  `id_usuario` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `TRABAJOS`
--

CREATE TABLE `TRABAJOS` (
  `item` int(11) NOT NULL,
  `nombre_trabajo` varchar(45) DEFAULT NULL,
  `descripcion_trabajo` varchar(125) DEFAULT NULL,
  `pago_autorizado` varchar(45) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `USUARIOS`
--

CREATE TABLE `USUARIOS` (
  `id_usuario` int(11) NOT NULL,
  `usuario` varchar(45) NOT NULL,
  `password` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `USUARIOS`
--

INSERT INTO `USUARIOS` (`id_usuario`, `usuario`, `password`) VALUES
(1, 'steven', '140716'),
(2, 'sergio', '5e225e8d2484161ccf0bf50ec198c847');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `PAGOS`
--
ALTER TABLE `PAGOS`
  ADD PRIMARY KEY (`id_pago`),
  ADD UNIQUE KEY `id_pagos_UNIQUE` (`id_pago`),
  ADD KEY `fk_pagos_reporte_idx` (`id_reporte`);

--
-- Indexes for table `REPORTES`
--
ALTER TABLE `REPORTES`
  ADD PRIMARY KEY (`id_reporte`),
  ADD UNIQUE KEY `id_reporte_UNIQUE` (`id_reporte`),
  ADD KEY `fk_reporte_tarea_idx` (`id_tarea`),
  ADD KEY `fk_reporte_sitio_idx` (`id_sitio`),
  ADD KEY `fk_reporte_preciario_idx` (`item`),
  ADD KEY `fk_reporte_sede_idx` (`id_sede`);

--
-- Indexes for table `SEDES`
--
ALTER TABLE `SEDES`
  ADD PRIMARY KEY (`id_sede`),
  ADD UNIQUE KEY `id_sede_UNIQUE` (`id_sede`);

--
-- Indexes for table `SITIOS`
--
ALTER TABLE `SITIOS`
  ADD PRIMARY KEY (`id_sitio`),
  ADD UNIQUE KEY `id_sitio_UNIQUE` (`id_sitio`),
  ADD KEY `fk_sitios_sede_idx` (`id_sede`);

--
-- Indexes for table `TAREAS`
--
ALTER TABLE `TAREAS`
  ADD PRIMARY KEY (`id_tarea`),
  ADD UNIQUE KEY `id_tarea_UNIQUE` (`id_tarea`),
  ADD KEY `fk_tareas_preciario_idx` (`item`),
  ADD KEY `fk_tareas_sede_idx` (`id_sede`),
  ADD KEY `fk_tareas_sitio_idx` (`id_sitio`),
  ADD KEY `fk_tareas_usuario_idx` (`id_usuario`);

--
-- Indexes for table `TRABAJOS`
--
ALTER TABLE `TRABAJOS`
  ADD PRIMARY KEY (`item`),
  ADD UNIQUE KEY `item_UNIQUE` (`item`);

--
-- Indexes for table `USUARIOS`
--
ALTER TABLE `USUARIOS`
  ADD PRIMARY KEY (`id_usuario`),
  ADD UNIQUE KEY `idusuario_UNIQUE` (`id_usuario`),
  ADD UNIQUE KEY `usuario_UNIQUE` (`usuario`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `PAGOS`
--
ALTER TABLE `PAGOS`
  MODIFY `id_pago` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `REPORTES`
--
ALTER TABLE `REPORTES`
  MODIFY `id_reporte` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `SEDES`
--
ALTER TABLE `SEDES`
  MODIFY `id_sede` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `TAREAS`
--
ALTER TABLE `TAREAS`
  MODIFY `id_tarea` int(11) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `PAGOS`
--
ALTER TABLE `PAGOS`
  ADD CONSTRAINT `fk_pagos_reporte` FOREIGN KEY (`id_reporte`) REFERENCES `REPORTES` (`id_reporte`);

--
-- Constraints for table `REPORTES`
--
ALTER TABLE `REPORTES`
  ADD CONSTRAINT `fk_reporte_preciario` FOREIGN KEY (`item`) REFERENCES `TRABAJOS` (`item`),
  ADD CONSTRAINT `fk_reporte_sede` FOREIGN KEY (`id_sede`) REFERENCES `SEDES` (`id_sede`),
  ADD CONSTRAINT `fk_reporte_sitio` FOREIGN KEY (`id_sitio`) REFERENCES `SITIOS` (`id_sitio`),
  ADD CONSTRAINT `fk_reporte_tarea` FOREIGN KEY (`id_tarea`) REFERENCES `TAREAS` (`id_tarea`);

--
-- Constraints for table `SITIOS`
--
ALTER TABLE `SITIOS`
  ADD CONSTRAINT `fk_sitios_sede` FOREIGN KEY (`id_sede`) REFERENCES `SEDES` (`id_sede`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- Constraints for table `TAREAS`
--
ALTER TABLE `TAREAS`
  ADD CONSTRAINT `fk_tareas_preciario` FOREIGN KEY (`item`) REFERENCES `TRABAJOS` (`item`),
  ADD CONSTRAINT `fk_tareas_sede` FOREIGN KEY (`id_sede`) REFERENCES `SEDES` (`id_sede`),
  ADD CONSTRAINT `fk_tareas_sitio` FOREIGN KEY (`id_sitio`) REFERENCES `SITIOS` (`id_sitio`),
  ADD CONSTRAINT `fk_tareas_usuario` FOREIGN KEY (`id_usuario`) REFERENCES `USUARIOS` (`id_usuario`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
