module Estadisticas
  ( Estudiante
  , promedio
  , masAlto
  , ordenarPorNota
  , aprobados
  ) where

import Data.List (sortBy)
import Data.Ord (comparing)

type Estudiante = (String, Double)

-- Calcular el promedio
promedio :: [Estudiante] -> Double
promedio [] = 0
promedio xs =
  sum (map snd xs) / fromIntegral (length xs)

-- Buscar al estudiante con mayor nota
masAlto :: [Estudiante] -> Estudiante
masAlto [x] = x
masAlto (x:xs)
  | snd x >= snd mejorResto = x
  | otherwise = mejorResto
  where
    mejorResto = masAlto xs
masAlto [] = error "Lista vacia"

-- Ordenar estudiantes por nota
ordenarPorNota :: [Estudiante] -> [Estudiante]
ordenarPorNota =
  sortBy (comparing (negate . snd))

-- Obtener estudiantes aprobados
aprobados :: [Estudiante] -> [Estudiante]
aprobados xs =
  [e | e <- xs, snd e >= 51]
