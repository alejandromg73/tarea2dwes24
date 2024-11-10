-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1:3307
-- Tiempo de generación: 10-11-2024 a las 16:23:35
-- Versión del servidor: 10.4.32-MariaDB
-- Versión de PHP: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `tarea2servidor`
--
CREATE DATABASE IF NOT EXISTS `tarea2servidor` DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
USE `tarea2servidor`;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `credenciales`
--

CREATE TABLE `credenciales` (
  `id` int(11) NOT NULL,
  `usuario` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `idPersona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `credenciales`
--

INSERT INTO `credenciales` (`id`, `usuario`, `password`, `idPersona`) VALUES
(1, 'admin', 'admin', 0),
(2, 'alejandro', 'alejandro', 2),
(4, 'luis', 'luis', 3),
(5, 'pepe', 'pepe', 4),
(6, 'antonio', 'antonio.', 5),
(7, 'nerea', 'nereanerea.', 6),
(8, 'hugo', 'hugohugo.', 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `ejemplares`
--

CREATE TABLE `ejemplares` (
  `id` int(11) NOT NULL,
  `nombre` varchar(25) NOT NULL,
  `id_planta` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `ejemplares`
--

INSERT INTO `ejemplares` (`id`, `nombre`, `id_planta`) VALUES
(1, 'ROSA_1', 'ROSA'),
(2, 'GIRASOL_2', 'GIRASOL'),
(3, 'HIEDRA_3', 'HIEDRA'),
(4, 'HIEDRA_4', 'HIEDRA'),
(5, 'ROSA_5', 'ROSA'),
(6, 'TULIPAN_6', 'TULIPAN'),
(7, 'LAVANDA_7', 'LAVANDA');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mensajes`
--

CREATE TABLE `mensajes` (
  `id` int(11) NOT NULL,
  `fechahora` datetime NOT NULL,
  `mensaje` varchar(500) NOT NULL,
  `idejemplar` int(11) NOT NULL,
  `idpersona` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `mensajes`
--

INSERT INTO `mensajes` (`id`, `fechahora`, `mensaje`, `idejemplar`, `idpersona`) VALUES
(1, '2024-11-08 10:43:00', 'Añadido el ejemplar 1', 1, 0),
(2, '2024-11-08 18:03:11', 'Trabajos de mantenimiento del ejemplar ', 1, 0),
(3, '2024-11-08 18:07:06', 'Cambio de habitat del ejemplar ', 1, 2),
(4, '2024-11-08 19:00:24', 'Añadido el ejemplar GIRASOL_2', 2, 0),
(5, '2024-11-08 19:02:23', 'Añadido el ejemplar HIEDRA_3', 3, 0),
(6, '2024-11-08 19:02:29', 'Añadido el ejemplar HIEDRA_4', 4, 0),
(7, '2024-11-08 19:02:34', 'Añadido el ejemplar ROSA_5', 5, 0),
(8, '2024-11-08 19:02:45', 'Añadido el ejemplar TULIPAN_6', 6, 0),
(9, '2024-11-09 10:20:05', 'Cambio de tierra y abono', 2, 2),
(10, '2024-11-10 15:29:05', 'Añadido el ejemplar LAVANDA_7', 7, 0);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personas`
--

CREATE TABLE `personas` (
  `id` int(11) NOT NULL,
  `nombre` varchar(40) NOT NULL,
  `email` varchar(40) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `personas`
--

INSERT INTO `personas` (`id`, `nombre`, `email`) VALUES
(0, 'admin', 'admin@admin.com'),
(2, 'Alejandro', 'alejandromg73@educastur.es'),
(3, 'Luis', 'luis@educastur.es'),
(4, 'Pepe', 'pepe@gmail.com'),
(5, 'Antonio', 'antonio@gmail.com'),
(6, 'Nerea', 'nerea@educastur.es'),
(7, 'Hugo', 'hugo@educastur.es');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `plantas`
--

CREATE TABLE `plantas` (
  `codigo` varchar(50) NOT NULL,
  `nombrecomun` varchar(100) NOT NULL,
  `nombrecientifico` varchar(100) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `plantas`
--

INSERT INTO `plantas` (`codigo`, `nombrecomun`, `nombrecientifico`) VALUES
('CALA', 'Cala', 'Zantedeschia aethiopica'),
('GIRASOL', 'Girasol', 'Helianthus annuus'),
('HIEDRA', 'Hiedra', 'Hedera Helix'),
('LAVANDA', 'Lavanda', 'Lavandulas'),
('MARGARITA', 'Margarita', 'Bellis perennis'),
('ROSA', 'Rosa', 'Rosa Rosae'),
('TULIPAN', 'TULIPAN', 'Tulipa sp');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `credenciales`
--
ALTER TABLE `credenciales`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `usuario` (`usuario`),
  ADD KEY `fk_personas` (`idPersona`);

--
-- Indices de la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_plantas` (`id_planta`);

--
-- Indices de la tabla `mensajes`
--
ALTER TABLE `mensajes`
  ADD PRIMARY KEY (`id`),
  ADD KEY `fk_ejemplares` (`idejemplar`),
  ADD KEY `fk_persona` (`idpersona`);

--
-- Indices de la tabla `personas`
--
ALTER TABLE `personas`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `email` (`email`);

--
-- Indices de la tabla `plantas`
--
ALTER TABLE `plantas`
  ADD PRIMARY KEY (`codigo`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `credenciales`
--
ALTER TABLE `credenciales`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT de la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT de la tabla `mensajes`
--
ALTER TABLE `mensajes`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;

--
-- AUTO_INCREMENT de la tabla `personas`
--
ALTER TABLE `personas`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `credenciales`
--
ALTER TABLE `credenciales`
  ADD CONSTRAINT `fk_personas` FOREIGN KEY (`idPersona`) REFERENCES `personas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `ejemplares`
--
ALTER TABLE `ejemplares`
  ADD CONSTRAINT `fk_plantas` FOREIGN KEY (`id_planta`) REFERENCES `plantas` (`codigo`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Filtros para la tabla `mensajes`
--
ALTER TABLE `mensajes`
  ADD CONSTRAINT `fk_ejemplares` FOREIGN KEY (`idejemplar`) REFERENCES `ejemplares` (`id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `fk_persona` FOREIGN KEY (`idpersona`) REFERENCES `personas` (`id`) ON DELETE CASCADE ON UPDATE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
