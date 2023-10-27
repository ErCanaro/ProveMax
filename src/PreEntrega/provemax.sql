-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-10-2023 a las 00:39:27
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `provemax`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `compra`
--

CREATE TABLE `compra` (
  `idCompra` int(11) NOT NULL,
  `idProveedor` int(11) NOT NULL,
  `fecha` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `compra`
--

INSERT INTO `compra` (`idCompra`, `idProveedor`, `fecha`) VALUES
(1, 1, '2023-10-01'),
(2, 1, '2023-10-01'),
(3, 3, '2023-10-01'),
(4, 4, '2023-10-04'),
(5, 5, '2023-10-05'),
(6, 6, '2023-10-06'),
(7, 7, '2023-10-07'),
(8, 8, '2023-10-08'),
(10, 24, '2023-10-17'),
(11, 7, '2023-10-17'),
(12, 7, '2023-10-17'),
(13, 1, '2023-10-17'),
(14, 20, '2023-10-17'),
(15, 6, '2023-10-17'),
(16, 6, '2023-10-17'),
(17, 7, '2023-10-17'),
(18, 4, '2023-10-18'),
(19, 2, '2023-10-19');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `detallecompra`
--

CREATE TABLE `detallecompra` (
  `idDetalle` int(11) NOT NULL,
  `cantidad` int(11) NOT NULL,
  `precioCosto` double NOT NULL,
  `idCompra` int(11) NOT NULL,
  `idProducto` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `detallecompra`
--

INSERT INTO `detallecompra` (`idDetalle`, `cantidad`, `precioCosto`, `idCompra`, `idProducto`) VALUES
(1, 10, 90, 1, 1),
(2, 15, 110, 1, 2),
(3, 20, 70, 2, 3),
(4, 5, 95, 3, 1),
(5, 12, 115, 3, 2),
(6, 8, 75, 3, 3),
(7, 10, 100, 4, 4),
(8, 15, 110, 4, 5),
(9, 20, 70, 5, 6),
(10, 5, 95, 6, 7),
(11, 12, 115, 6, 8),
(12, 8, 75, 7, 4),
(13, 18, 105, 7, 5),
(14, 25, 65, 8, 6),
(15, 3, 85, 8, 7),
(16, 7, 100, 8, 8),
(17, 8, 110, 1, 10),
(19, 15, 75, 1, 14),
(21, 66, 66.66, 17, 2),
(22, 66, 66.66, 17, 8),
(23, 66, 66.66, 17, 6),
(24, 66, 66.66, 17, 4),
(25, 15, 100.23, 18, 1),
(26, 25, 200.15, 18, 6),
(27, 150, 73.25, 18, 7),
(28, 152, 100, 18, 6),
(29, 15, 723.35, 19, 2),
(30, 20, 723.35, 19, 5),
(31, 18, 785.36, 19, 8);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `producto`
--

CREATE TABLE `producto` (
  `idProducto` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `descripcion` varchar(50) NOT NULL,
  `precioActual` double NOT NULL,
  `stock` int(11) NOT NULL,
  `estado` tinyint(1) NOT NULL,
  `stockMinimo` int(11) NOT NULL DEFAULT 10
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `producto`
--

INSERT INTO `producto` (`idProducto`, `nombre`, `descripcion`, `precioActual`, `stock`, `estado`, `stockMinimo`) VALUES
(1, 'Producto B', 'Lucecitas B', 100, 9, 1, 10),
(2, 'Producto Y', 'Batidora Y', 120, 13, 1, 10),
(3, 'Producto Z', 'Multiprocesadora Z', 80, 70, 1, 10),
(4, 'Producto W', 'Microondas W', 110, 20, 1, 10),
(5, 'Producto X', 'Televisor X', 100, 50, 1, 10),
(6, 'Producto C', 'Heladera Y', 120, 30, 1, 10),
(7, 'Producto D', 'Cafetera Z', 80, 17, 1, 10),
(8, 'Producto A', 'Tostadora A', 90, 60, 1, 10),
(9, 'Juguera', 'Hace jugo', 12536.84, 18, 1, 10),
(10, 'Cosita', 'Nuevita', 1234.35, 152, 1, 20),
(11, 'Nuevo Producto', 'Otra cosa nueva', 105.36, 32, 1, 10),
(12, 'Chingazo', 'Mortal', 1215.13, 123, 1, 12),
(13, 'Produc', 'Tito', 0.15, 150, 1, 15),
(14, 'Otropro', 'Ductito', 12365.36356546549, 150, 1, 15),
(15, 'Probando', 'Esto', 123.35, 150, 1, 15),
(16, 'Cargado desde Dialog', 'Dialog', 123.45, 25, 1, 18),
(17, 'otro desde dialog', 'Diualo', 1335.35, 150, 1, 10),
(18, 'Creado desde Dialog3', 'Dialog 3', 1234, 122, 1, 15),
(19, '4 Dialog', '4Dialog', 123, 123, 1, 12),
(20, '5Dialog', '5Dialog', 145, 14, 1, 12),
(21, '6Dialog', '6Dialog', 134, 12, 1, 1),
(22, '7Dialog', '7Dialog', 1234, 123, 1, 45),
(23, '8Dialog', 'Dialog', 1234, 1324, 1, 321),
(24, 'Dialog Prod Nuevo', 'Dialog', 123, 132, 1, 13),
(25, '40DIalog', 'Algo', 1234, 12, 1, 1),
(26, '50Dialog', 'asdas21', 12, 13213, 1, 12);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `proveedor`
--

CREATE TABLE `proveedor` (
  `idProveedor` int(11) NOT NULL,
  `razonSocial` varchar(50) NOT NULL,
  `domicilio` varchar(50) NOT NULL,
  `telefono` varchar(15) NOT NULL,
  `estado` tinyint(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `proveedor`
--

INSERT INTO `proveedor` (`idProveedor`, `razonSocial`, `domicilio`, `telefono`, `estado`) VALUES
(1, 'Proveedor A', 'Calle 123, Ciudad A', '555-1234', 1),
(2, 'Proveedor B', 'Avenida 456, Ciudad B', '555-5678', 1),
(3, 'Proveedor C', 'Carrera 789, Ciudad C', '555-9012999', 1),
(4, 'Proveedor D', 'Carrera 012, Ciudad D', '555-3456', 1),
(5, 'Proveedor E', 'Avenida 789, Ciudad E', '555-6789', 1),
(6, 'Proveedor F', 'Calle 234, Ciudad F', '555-1234', 1),
(7, 'Proveedor G', 'Avenida 567, Ciudad G', '555-4567', 1),
(8, 'Proveedor H', 'Carrera 890, Ciudad H', '555-7890', 1),
(9, 'La Estrella', 'Via Láctea', '03 03 456', 1),
(10, 'SSSSS', 'AA33', '134879', 1),
(11, 'Cosa con Muchas DD', 'AA33', '134879', 1),
(12, 'Testeando Mucho', 'Desde Guardar', 'Ma ver mostreme', 1),
(13, 'Sanchez', 'De la CUadra', '123789456546', 1),
(14, 'La empresa Prveedora', 'Suca Sita', '444 555 666 777', 1),
(15, 'nuevo proceedor', 'bien pro', '7778889999987', 1),
(16, 'El libro', 'Gordo', 'de petete', 1),
(17, 'Dotor', 'Su cas', '444555566', 1),
(18, 'Kushiro', 'Suca Sita', '111 22 334', 1),
(19, 'Cargando ', 'Nuevo', '333 333 333', 1),
(20, 'Miriam', 'Deja de Gritar', '111 222 333 ', 1),
(21, 'Proveedor Nuve Cito', 'Laca sita desu novia', '333 555 444', 1),
(23, 'Algo', 'pa', 'poner', 1),
(24, 'aaaaaaaaaassssssssssddddddddddffffffffffggggggggg1', 'Prueba', 'puesto', 1),
(25, 'Procv', 'Nuevo', '12345678', 1),
(26, '1ProvDialog', 'Suca Sita', '21321-46', 1),
(27, '2Dialog', '2Dialog', '132-35654', 1),
(28, 'Miriam', 'La wapita 250', '1234-4576', 1),
(30, 'Nuevo Proveedor DIalog', 'Dialoguito', '321654987', 1),
(31, 'Rox', 'Mentora Pro', '32165798', 1),
(32, '50Dialog', 'Algo', '1234657/98', 1),
(33, '60Dialog', 'Algo', '2134567', 1),
(34, '70Dialog', 'alguito', '13', 1);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `compra`
--
ALTER TABLE `compra`
  ADD PRIMARY KEY (`idCompra`),
  ADD KEY `idProveedor` (`idProveedor`);

--
-- Indices de la tabla `detallecompra`
--
ALTER TABLE `detallecompra`
  ADD PRIMARY KEY (`idDetalle`),
  ADD KEY `idProducto` (`idProducto`),
  ADD KEY `idCompra` (`idCompra`);

--
-- Indices de la tabla `producto`
--
ALTER TABLE `producto`
  ADD PRIMARY KEY (`idProducto`);

--
-- Indices de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  ADD PRIMARY KEY (`idProveedor`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `compra`
--
ALTER TABLE `compra`
  MODIFY `idCompra` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;

--
-- AUTO_INCREMENT de la tabla `detallecompra`
--
ALTER TABLE `detallecompra`
  MODIFY `idDetalle` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=32;

--
-- AUTO_INCREMENT de la tabla `producto`
--
ALTER TABLE `producto`
  MODIFY `idProducto` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=27;

--
-- AUTO_INCREMENT de la tabla `proveedor`
--
ALTER TABLE `proveedor`
  MODIFY `idProveedor` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=36;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `compra`
--
ALTER TABLE `compra`
  ADD CONSTRAINT `compra_ibfk_1` FOREIGN KEY (`idProveedor`) REFERENCES `proveedor` (`idProveedor`);

--
-- Filtros para la tabla `detallecompra`
--
ALTER TABLE `detallecompra`
  ADD CONSTRAINT `detallecompra_ibfk_1` FOREIGN KEY (`idProducto`) REFERENCES `producto` (`idProducto`),
  ADD CONSTRAINT `detallecompra_ibfk_2` FOREIGN KEY (`idCompra`) REFERENCES `compra` (`idCompra`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
