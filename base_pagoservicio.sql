-- phpMyAdmin SQL Dump
-- version 4.7.9
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 03-12-2019 a las 23:44:49
-- Versión del servidor: 10.1.31-MariaDB
-- Versión de PHP: 7.2.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `base_pagoservicio`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cliente`
--

CREATE TABLE `cliente` (
  `codigo_C` int(10) NOT NULL,
  `codigo_TC` int(10) NOT NULL,
  `nroDocumento_C` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `nombre_C` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `apellido_C` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `direccion_C` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `telefono_C` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `estado_C` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `comprobante`
--

CREATE TABLE `comprobante` (
  `codigo_COMP` int(10) NOT NULL,
  `codigo_CONT` int(10) NOT NULL,
  `codigo_TCO` int(10) NOT NULL,
  `monto_COMP` double NOT NULL,
  `estado_COMP` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `contrato`
--

CREATE TABLE `contrato` (
  `codigo_CONT` int(10) NOT NULL,
  `codigo_C` int(10) NOT NULL,
  `codigo_S` int(10) NOT NULL,
  `fechaInicio_CONT` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `fechaFin_CONT` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `tipoContrato_CONT` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `estado_CONT` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `cuentabancario`
--

CREATE TABLE `cuentabancario` (
  `codigo_B` int(11) NOT NULL,
  `codigo_PR` int(11) NOT NULL,
  `codigo_P` int(11) NOT NULL,
  `numeroCuenta_B` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `tipocuenta_B` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `fechaVencimiento_B` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `clave_B` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `estado_B` tinyint(1) NOT NULL,
  `saldo_B` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallemespagado`
--

CREATE TABLE `detallemespagado` (
  `codigo_DMP` int(11) NOT NULL,
  `codigo_M` int(11) NOT NULL,
  `codigo_P` int(11) NOT NULL,
  `monto_DMP` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `entidadbancaria`
--

CREATE TABLE `entidadbancaria` (
  `codigo_E` int(11) NOT NULL,
  `nombre_E` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `direccion_E` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `ruc_E` varchar(30) COLLATE utf8_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `mes`
--

CREATE TABLE `mes` (
  `codigo_M` int(11) NOT NULL,
  `codigo_CONT` int(11) NOT NULL,
  `intervaloT_M` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `fechaInicio_M` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `fechaFin_M` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `vigencia_M` tinyint(1) NOT NULL,
  `observacion_M` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `costo_M` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `pago`
--

CREATE TABLE `pago` (
  `codigo_P` int(11) NOT NULL,
  `codigo_TP` int(11) NOT NULL,
  `codigo_COMP` int(11) NOT NULL,
  `fecha_COMP` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `total_COMP` double NOT NULL,
  `estado_COMP` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `codigo_PR` int(11) NOT NULL,
  `razonSocial_PR` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `nombre_PR` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `ruc_PR` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `direccion_PR` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `telefono_PR` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `estado_PR` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `servicio`
--

CREATE TABLE `servicio` (
  `codigo_S` int(11) NOT NULL,
  `codigo_TS` int(11) NOT NULL,
  `nombre_PR` int(11) NOT NULL,
  `nombre_S` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `descripcion_S` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `precio_S` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipocliente`
--

CREATE TABLE `tipocliente` (
  `codigo_TC` int(11) NOT NULL,
  `descripcion_TC` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `estado_TC` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipocomprobante`
--

CREATE TABLE `tipocomprobante` (
  `codigo_TCO` int(11) NOT NULL,
  `descripcion_TCO` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `estado_TCO` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipopago`
--

CREATE TABLE `tipopago` (
  `codigo_TP` int(11) NOT NULL,
  `descripcion_TP` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `estado_TP` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tiposervicio`
--

CREATE TABLE `tiposervicio` (
  `codigo_TS` int(11) NOT NULL,
  `descripcion_TS` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `estado_TS` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tipousuario`
--

CREATE TABLE `tipousuario` (
  `codigo_TU` int(11) NOT NULL,
  `descripcion_TU` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `estado_TU` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuario`
--

CREATE TABLE `usuario` (
  `codigo_U` int(11) NOT NULL,
  `codigo_TU` int(11) NOT NULL,
  `codigo_C` int(11) NOT NULL,
  `codigo_P` int(11) NOT NULL,
  `nombre_U` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `password_U` varchar(30) COLLATE utf8_unicode_ci NOT NULL,
  `vigencia_U` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`codigo_C`),
  ADD KEY `fk_tipoCliente` (`codigo_TC`);

--
-- Indices de la tabla `comprobante`
--
ALTER TABLE `comprobante`
  ADD PRIMARY KEY (`codigo_COMP`),
  ADD KEY `fk_codigo_CONT` (`codigo_CONT`),
  ADD KEY `fk_codigo_TCO` (`codigo_TCO`);

--
-- Indices de la tabla `contrato`
--
ALTER TABLE `contrato`
  ADD PRIMARY KEY (`codigo_CONT`),
  ADD KEY `fk_codigo_C` (`codigo_C`),
  ADD KEY `fk_codigo_S` (`codigo_S`);

--
-- Indices de la tabla `cuentabancario`
--
ALTER TABLE `cuentabancario`
  ADD PRIMARY KEY (`codigo_B`),
  ADD KEY `fk_codigo_PR` (`codigo_PR`),
  ADD KEY `fk_codigo_P` (`codigo_P`);

--
-- Indices de la tabla `detallemespagado`
--
ALTER TABLE `detallemespagado`
  ADD PRIMARY KEY (`codigo_DMP`),
  ADD KEY `fk_codigo_M` (`codigo_M`),
  ADD KEY `fk_codigo_P` (`codigo_P`);

--
-- Indices de la tabla `entidadbancaria`
--
ALTER TABLE `entidadbancaria`
  ADD PRIMARY KEY (`codigo_E`);

--
-- Indices de la tabla `mes`
--
ALTER TABLE `mes`
  ADD PRIMARY KEY (`codigo_M`),
  ADD KEY `fk_codigo_CONT` (`codigo_CONT`);

--
-- Indices de la tabla `pago`
--
ALTER TABLE `pago`
  ADD PRIMARY KEY (`codigo_P`),
  ADD KEY `fk_codigo_TP` (`codigo_TP`),
  ADD KEY `fk_codigo_COMP` (`codigo_COMP`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`codigo_PR`);

--
-- Indices de la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD PRIMARY KEY (`codigo_S`),
  ADD KEY `fk_codigo_TS` (`codigo_TS`);

--
-- Indices de la tabla `tipocliente`
--
ALTER TABLE `tipocliente`
  ADD PRIMARY KEY (`codigo_TC`);

--
-- Indices de la tabla `tipocomprobante`
--
ALTER TABLE `tipocomprobante`
  ADD PRIMARY KEY (`codigo_TCO`);

--
-- Indices de la tabla `tipopago`
--
ALTER TABLE `tipopago`
  ADD PRIMARY KEY (`codigo_TP`);

--
-- Indices de la tabla `tiposervicio`
--
ALTER TABLE `tiposervicio`
  ADD PRIMARY KEY (`codigo_TS`);

--
-- Indices de la tabla `tipousuario`
--
ALTER TABLE `tipousuario`
  ADD PRIMARY KEY (`codigo_TU`);

--
-- Indices de la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD PRIMARY KEY (`codigo_U`),
  ADD KEY `fk_codigo_TU` (`codigo_TU`),
  ADD KEY `fk_codigo_C` (`codigo_C`),
  ADD KEY `fk_codigo_P` (`codigo_P`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `cliente`
--
ALTER TABLE `cliente`
  MODIFY `codigo_C` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `comprobante`
--
ALTER TABLE `comprobante`
  MODIFY `codigo_COMP` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `contrato`
--
ALTER TABLE `contrato`
  MODIFY `codigo_CONT` int(10) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `cuentabancario`
--
ALTER TABLE `cuentabancario`
  MODIFY `codigo_B` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `detallemespagado`
--
ALTER TABLE `detallemespagado`
  MODIFY `codigo_DMP` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `entidadbancaria`
--
ALTER TABLE `entidadbancaria`
  MODIFY `codigo_E` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `mes`
--
ALTER TABLE `mes`
  MODIFY `codigo_M` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `pago`
--
ALTER TABLE `pago`
  MODIFY `codigo_P` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `codigo_PR` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `servicio`
--
ALTER TABLE `servicio`
  MODIFY `codigo_S` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipocliente`
--
ALTER TABLE `tipocliente`
  MODIFY `codigo_TC` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipocomprobante`
--
ALTER TABLE `tipocomprobante`
  MODIFY `codigo_TCO` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipopago`
--
ALTER TABLE `tipopago`
  MODIFY `codigo_TP` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tiposervicio`
--
ALTER TABLE `tiposervicio`
  MODIFY `codigo_TS` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `tipousuario`
--
ALTER TABLE `tipousuario`
  MODIFY `codigo_TU` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT de la tabla `usuario`
--
ALTER TABLE `usuario`
  MODIFY `codigo_U` int(11) NOT NULL AUTO_INCREMENT;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `cliente`
--
ALTER TABLE `cliente`
  ADD CONSTRAINT `cliente_ibfk_1` FOREIGN KEY (`codigo_TC`) REFERENCES `tipocliente` (`codigo_TC`);

--
-- Filtros para la tabla `comprobante`
--
ALTER TABLE `comprobante`
  ADD CONSTRAINT `comprobante_ibfk_1` FOREIGN KEY (`codigo_TCO`) REFERENCES `tipocomprobante` (`codigo_TCO`),
  ADD CONSTRAINT `comprobante_ibfk_2` FOREIGN KEY (`codigo_CONT`) REFERENCES `contrato` (`codigo_CONT`);

--
-- Filtros para la tabla `contrato`
--
ALTER TABLE `contrato`
  ADD CONSTRAINT `contrato_ibfk_1` FOREIGN KEY (`codigo_S`) REFERENCES `servicio` (`codigo_S`),
  ADD CONSTRAINT `contrato_ibfk_2` FOREIGN KEY (`codigo_C`) REFERENCES `cliente` (`codigo_C`);

--
-- Filtros para la tabla `cuentabancario`
--
ALTER TABLE `cuentabancario`
  ADD CONSTRAINT `cuentabancario_ibfk_1` FOREIGN KEY (`codigo_P`) REFERENCES `pago` (`codigo_P`),
  ADD CONSTRAINT `cuentabancario_ibfk_2` FOREIGN KEY (`codigo_PR`) REFERENCES `proveedor` (`codigo_PR`);

--
-- Filtros para la tabla `detallemespagado`
--
ALTER TABLE `detallemespagado`
  ADD CONSTRAINT `detallemespagado_ibfk_1` FOREIGN KEY (`codigo_P`) REFERENCES `pago` (`codigo_P`),
  ADD CONSTRAINT `detallemespagado_ibfk_2` FOREIGN KEY (`codigo_M`) REFERENCES `mes` (`codigo_M`);

--
-- Filtros para la tabla `mes`
--
ALTER TABLE `mes`
  ADD CONSTRAINT `mes_ibfk_1` FOREIGN KEY (`codigo_CONT`) REFERENCES `contrato` (`codigo_CONT`);

--
-- Filtros para la tabla `pago`
--
ALTER TABLE `pago`
  ADD CONSTRAINT `pago_ibfk_1` FOREIGN KEY (`codigo_COMP`) REFERENCES `comprobante` (`codigo_COMP`),
  ADD CONSTRAINT `pago_ibfk_2` FOREIGN KEY (`codigo_TP`) REFERENCES `tipopago` (`codigo_TP`);

--
-- Filtros para la tabla `servicio`
--
ALTER TABLE `servicio`
  ADD CONSTRAINT `servicio_ibfk_1` FOREIGN KEY (`codigo_TS`) REFERENCES `tiposervicio` (`codigo_TS`);

--
-- Filtros para la tabla `usuario`
--
ALTER TABLE `usuario`
  ADD CONSTRAINT `usuario_ibfk_1` FOREIGN KEY (`codigo_TU`) REFERENCES `tipousuario` (`codigo_TU`),
  ADD CONSTRAINT `usuario_ibfk_2` FOREIGN KEY (`codigo_C`) REFERENCES `cliente` (`codigo_C`),
  ADD CONSTRAINT `usuario_ibfk_3` FOREIGN KEY (`codigo_P`) REFERENCES `proveedor` (`codigo_PR`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
