module Notas
    ( Estudiante
    , promedio
    , masAlto
    , ordenarPorNota
    , aprobados
    , parsearLinea
    ) where

import Data.List (sortBy)
import Data.Ord (comparing)

-- Nombre y nota del estudiante
type Estudiante = (String, Double)

-- Calcula el promedio
promedio :: [Estudiante] -> Double
promedio [] = 0
promedio xs =
    sum (map snd xs) / fromIntegral (length xs)

-- Busca la nota mas alta
masAlto :: [Estudiante] -> Maybe Estudiante
masAlto [] = Nothing
masAlto xs =
    Just (foldl1 (\a b ->
        if snd a >= snd b then a else b) xs)

-- Ordena por nota de mayor a menor
ordenarPorNota :: [Estudiante] -> [Estudiante]
ordenarPorNota =
    sortBy (comparing (negate . snd))

-- Obtiene los estudiantes aprobados
aprobados :: [Estudiante] -> [Estudiante]
aprobados xs =
    [e | e <- xs, snd e >= 51]

-- Convierte una linea en un estudiante
parsearLinea :: String -> Either String Estudiante
parsearLinea linea =
    case break (== ',') linea of
        (nombre, ',' : notaTexto)
            | null nombre ->
                Left ("nombre vacio: " ++ linea)
            | otherwise ->
                case reads notaTexto :: [(Double, String)] of
                    [(nota, "")] ->
                        Right (nombre, nota)
                    _ ->
                        Left ("nota invalida: " ++ linea)

        _ ->
            Left ("linea sin formato nombre,nota: " ++ linea)
