-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: mysql:3306
-- Tiempo de generación: 23-06-2024 a las 17:53:54
-- Versión del servidor: 8.0.37
-- Versión de PHP: 8.0.27

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `BDCibertec`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `Especialidad`
--

CREATE TABLE `Especialidad` (
  `IdEspecialidad` int NOT NULL,
  `Titulo` varchar(250) NOT NULL,
  `Funcion` varchar(250) NOT NULL,
  `FechGraduacion` date NOT NULL,
  `IdMedico` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Volcado de datos para la tabla `Especialidad`
--

INSERT INTO `Especialidad` (`IdEspecialidad`, `Titulo`, `Funcion`, `FechGraduacion`, `IdMedico`) VALUES
(1, 'Cirugía General', 'Realizar cirugías de diversa índole', '2010-07-01', 1),
(2, 'Pediatría', 'Atender a niños y adolescentes', '2005-05-15', 2),
(3, 'Ginecología', 'Atender a mujeres en temas de salud reproductiva', '2008-09-30', 3),
(4, 'Cardiología', 'Atender a pacientes con problemas cardíacos', '2006-12-20', 4),
(5, 'Dermatología', 'Tratar enfermedades de la piel', '2007-04-10', 5);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `Especialidad`
--
ALTER TABLE `Especialidad`
  ADD PRIMARY KEY (`IdEspecialidad`),
  ADD KEY `IdMedico` (`IdMedico`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `Especialidad`
--
ALTER TABLE `Especialidad`
  MODIFY `IdEspecialidad` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `Especialidad`
--
ALTER TABLE `Especialidad`
  ADD CONSTRAINT `Especialidad_ibfk_1` FOREIGN KEY (`IdMedico`) REFERENCES `Medico` (`IdMedico`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
