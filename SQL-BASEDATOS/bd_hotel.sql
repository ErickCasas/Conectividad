-- phpMyAdmin SQL Dump
-- version 4.8.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 18-10-2019 a las 01:54:08
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 7.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bd_hotel`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `codigo_c` int(11) NOT NULL,
  `dni` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `nombre` varchar(199) COLLATE utf8_unicode_ci NOT NULL,
  `apellido` varchar(199) COLLATE utf8_unicode_ci NOT NULL,
  `edad` int(11) NOT NULL,
  `tipo` varchar(199) COLLATE utf8_unicode_ci NOT NULL,
  `estado` varchar(199) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprobante`
--

CREATE TABLE `comprobante` (
  `codigo_comp` int(11) NOT NULL,
  `descripcion` varchar(199) COLLATE utf8_unicode_ci NOT NULL,
  `estado` varchar(199) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `controlasistencia`
--

CREATE TABLE `controlasistencia` (
  `codigo_a` int(11) NOT NULL,
  `codigo_p` int(11) NOT NULL,
  `asistencia` varchar(199) COLLATE utf8_unicode_ci NOT NULL,
  `estado` varchar(199) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detalleestancia`
--

CREATE TABLE `detalleestancia` (
  `codigo_de` int(11) NOT NULL,
  `codigo_c` int(11) NOT NULL,
  `codigo_h` int(11) NOT NULL,
  `codigo_u` int(11) NOT NULL,
  `codigo_r` int(11) NOT NULL,
  `codigo_p` int(11) NOT NULL,
  `fechaIngreso` datetime NOT NULL,
  `fechaSalida` datetime NOT NULL,
  `numeroComprobante` int(11) NOT NULL,
  `estado` varchar(199) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `habitacion`
--

CREATE TABLE `habitacion` (
  `codigo_h` int(11) NOT NULL,
  `descripcion` varchar(199) COLLATE utf8_unicode_ci NOT NULL,
  `clase` varchar(199) COLLATE utf8_unicode_ci NOT NULL,
  `costo` decimal(10,0) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `horario`
--

CREATE TABLE `horario` (
  `codigo_ho` int(11) NOT NULL,
  `horaIngreso` datetime NOT NULL,
  `horaSalida` datetime NOT NULL,
  `dia` varchar(199) COLLATE utf8_unicode_ci NOT NULL,
  `estado` varchar(199) COLLATE utf8_unicode_ci NOT NULL,
  `codigo_p` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `personal`
--

CREATE TABLE `personal` (
  `codigo_p` int(11) NOT NULL,
  `dni` varchar(9) COLLATE utf8_unicode_ci NOT NULL,
  `nombre` varchar(199) COLLATE utf8_unicode_ci NOT NULL,
  `apellido` varchar(199) COLLATE utf8_unicode_ci NOT NULL,
  `edad` int(11) NOT NULL,
  `tipo` varchar(199) COLLATE utf8_unicode_ci NOT NULL,
  `estado` varchar(199) COLLATE utf8_unicode_ci NOT NULL,
  `cargo` varchar(199) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `promociones`
--

CREATE TABLE `promociones` (
  `codigo_pro` int(11) NOT NULL,
  `codigo_h` int(11) NOT NULL,
  `descripcion` varchar(199) COLLATE utf8_unicode_ci NOT NULL,
  `costo` decimal(10,0) NOT NULL,
  `codigo_s` int(11) NOT NULL,
  `fecha` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `recepcion`
--

CREATE TABLE `recepcion` (
  `codigo_r` int(11) NOT NULL,
  `detalle` varchar(199) COLLATE utf8_unicode_ci NOT NULL,
  `horaApertura` datetime NOT NULL,
  `horaCierre` datetime NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `serie`
--

CREATE TABLE `serie` (
  `codigo_s` int(11) NOT NULL,
  `codigo_comp` int(11) NOT NULL,
  `descripcion` varchar(199) COLLATE utf8_unicode_ci NOT NULL,
  `estado` varchar(199) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `codigo_s` int(11) NOT NULL,
  `descripcion` varchar(199) COLLATE utf8_unicode_ci NOT NULL,
  `estado` varchar(199) COLLATE utf8_unicode_ci NOT NULL,
  `tipo` varchar(199) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `codigo_u` int(11) NOT NULL,
  `estado` varchar(199) COLLATE utf8_unicode_ci NOT NULL,
  `correo` varchar(199) COLLATE utf8_unicode_ci NOT NULL,
  `contraseña` varchar(199) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`codigo_c`);

--
-- Indices de la tabla `comprobante`
--
ALTER TABLE `comprobante`
  ADD PRIMARY KEY (`codigo_comp`);

--
-- Indices de la tabla `controlasistencia`
--
ALTER TABLE `controlasistencia`
  ADD PRIMARY KEY (`codigo_a`),
  ADD KEY `fk_codigo_p` (`codigo_p`);

--
-- Indices de la tabla `detalleestancia`
--
ALTER TABLE `detalleestancia`
  ADD PRIMARY KEY (`codigo_de`),
  ADD KEY `fk_codigo_h` (`codigo_h`),
  ADD KEY `fk_codigo_c` (`codigo_c`),
  ADD KEY `fk_codigo_u` (`codigo_u`),
  ADD KEY `fk_codigo_r` (`codigo_r`),
  ADD KEY `fk_codigo_p` (`codigo_p`);

--
-- Indices de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD PRIMARY KEY (`codigo_h`);

--
-- Indices de la tabla `horario`
--
ALTER TABLE `horario`
  ADD PRIMARY KEY (`codigo_ho`),
  ADD KEY `fk_codigo_p` (`codigo_p`);

--
-- Indices de la tabla `personal`
--
ALTER TABLE `personal`
  ADD PRIMARY KEY (`codigo_p`);

--
-- Indices de la tabla `promociones`
--
ALTER TABLE `promociones`
  ADD PRIMARY KEY (`codigo_pro`),
  ADD KEY `fk_codigo_h` (`codigo_h`),
  ADD KEY `fk_codigo_s` (`codigo_s`);

--
-- Indices de la tabla `recepcion`
--
ALTER TABLE `recepcion`
  ADD PRIMARY KEY (`codigo_r`);

--
-- Indices de la tabla `serie`
--
ALTER TABLE `serie`
  ADD PRIMARY KEY (`codigo_s`),
  ADD KEY `fk_codigo_comp` (`codigo_comp`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`codigo_s`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`codigo_u`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `codigo_c` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `comprobante`
--
ALTER TABLE `comprobante`
  MODIFY `codigo_comp` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `controlasistencia`
--
ALTER TABLE `controlasistencia`
  MODIFY `codigo_a` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detalleestancia`
--
ALTER TABLE `detalleestancia`
  MODIFY `codigo_de` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `habitacion`
--
ALTER TABLE `habitacion`
  MODIFY `codigo_h` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `horario`
--
ALTER TABLE `horario`
  MODIFY `codigo_ho` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `personal`
--
ALTER TABLE `personal`
  MODIFY `codigo_p` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `promociones`
--
ALTER TABLE `promociones`
  MODIFY `codigo_pro` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `recepcion`
--
ALTER TABLE `recepcion`
  MODIFY `codigo_r` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `serie`
--
ALTER TABLE `serie`
  MODIFY `codigo_s` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `servicio`
--
ALTER TABLE `servicio`
  MODIFY `codigo_s` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `codigo_u` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `controlasistencia`
--
ALTER TABLE `controlasistencia`
  ADD CONSTRAINT `controlasistencia_ibfk_1` FOREIGN KEY (`codigo_p`) REFERENCES `personal` (`codigo_p`);

--
-- Filtros para la tabla `detalleestancia`
--
ALTER TABLE `detalleestancia`
  ADD CONSTRAINT `detalleestancia_ibfk_1` FOREIGN KEY (`codigo_c`) REFERENCES `cliente` (`codigo_c`),
  ADD CONSTRAINT `detalleestancia_ibfk_2` FOREIGN KEY (`codigo_u`) REFERENCES `usuario` (`codigo_u`),
  ADD CONSTRAINT `detalleestancia_ibfk_3` FOREIGN KEY (`codigo_r`) REFERENCES `recepcion` (`codigo_r`),
  ADD CONSTRAINT `detalleestancia_ibfk_4` FOREIGN KEY (`codigo_p`) REFERENCES `promociones` (`codigo_pro`);

--
-- Filtros para la tabla `habitacion`
--
ALTER TABLE `habitacion`
  ADD CONSTRAINT `habitacion_ibfk_1` FOREIGN KEY (`codigo_h`) REFERENCES `detalleestancia` (`codigo_h`);

--
-- Filtros para la tabla `horario`
--
ALTER TABLE `horario`
  ADD CONSTRAINT `horario_ibfk_1` FOREIGN KEY (`codigo_p`) REFERENCES `personal` (`codigo_p`);

--
-- Filtros para la tabla `promociones`
--
ALTER TABLE `promociones`
  ADD CONSTRAINT `promociones_ibfk_1` FOREIGN KEY (`codigo_h`) REFERENCES `habitacion` (`codigo_h`),
  ADD CONSTRAINT `promociones_ibfk_2` FOREIGN KEY (`codigo_s`) REFERENCES `servicio` (`codigo_s`);

--
-- Filtros para la tabla `serie`
--
ALTER TABLE `serie`
  ADD CONSTRAINT `serie_ibfk_1` FOREIGN KEY (`codigo_comp`) REFERENCES `comprobante` (`codigo_comp`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
