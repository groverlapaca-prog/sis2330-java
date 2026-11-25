module Main where

import Modelo (Estudiante, promedio, aprobados)
import Persistencia (guardarEstudiantes, cargarEstudiantes)
import Control.Monad (replicateM, forM_)

archivoDatos :: FilePath
archivoDatos = "estudiantes.csv"

leerEstudiante :: IO Estudiante
leerEstudiante = do
  putStrLn "Nombre del estudiante:"
  nombre <- getLine

  putStrLn "Nota del estudiante:"
  notaTexto <- getLine

  case reads notaTexto :: [(Double, String)] of
    [(nota, "")]
      | nota >= 0 && nota <= 100 ->
          return (nombre, nota)
    _ -> do
      putStrLn "Nota invalida. Intente nuevamente."
      leerEstudiante

main :: IO ()
main = do
  resultados <- cargarEstudiantes archivoDatos

  forM_ resultados $ \r ->
    case r of
      Left err -> putStrLn ("Aviso: " ++ err)
      Right _ -> return ()

  let existentes = [e | Right e <- resultados]

  putStrLn ("Estudiantes cargados: " ++ show (length existentes))

  putStrLn "Cuantos estudiantes nuevos vas a agregar?"
  cantidadTexto <- getLine

  case reads cantidadTexto :: [(Int, String)] of
    [(cantidad, "")] | cantidad >= 0 -> do
      nuevos <- replicateM cantidad leerEstudiante

      let todos = existentes ++ nuevos

      guardarEstudiantes archivoDatos todos

      putStrLn ("Total guardados: " ++ show (length todos))
      putStrLn ("Promedio: " ++ show (promedio todos))
      putStrLn ("Aprobados: " ++ show (length (aprobados todos)))

    _ -> putStrLn "Cantidad invalida."
