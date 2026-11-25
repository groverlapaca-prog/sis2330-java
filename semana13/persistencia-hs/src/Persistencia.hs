module Persistencia
  ( guardarEstudiantes
  , cargarEstudiantes
  , parsearLinea
  ) where

import System.Directory (doesFileExist)
import Modelo (Estudiante)

formatearLinea :: Estudiante -> String
formatearLinea (nombre, nota) =
  nombre ++ "," ++ show nota

parsearLinea :: String -> Either String Estudiante
parsearLinea linea =
  case break (== ',') linea of
    (nombre, ',' : notaTexto)
      | null nombre ->
          Left ("nombre vacio: " ++ linea)
      | otherwise ->
          case reads notaTexto :: [(Double, String)] of
            [(nota, "")]
              | nota >= 0 && nota <= 100 ->
                  Right (nombre, nota)
              | otherwise ->
                  Left ("nota fuera de rango: " ++ linea)
            _ -> Left ("nota invalida: " ++ linea)
    _ -> Left ("formato invalido: " ++ linea)

guardarEstudiantes :: FilePath -> [Estudiante] -> IO ()
guardarEstudiantes ruta estudiantes =
  writeFile ruta
    (unlines (map formatearLinea estudiantes))

cargarEstudiantes :: FilePath -> IO [Either String Estudiante]
cargarEstudiantes ruta = do
  existe <- doesFileExist ruta
  if not existe
    then return []
    else do
      contenido <- readFile ruta
      let lineas = filter (not . null) (lines contenido)
      return (map parsearLinea lineas)
