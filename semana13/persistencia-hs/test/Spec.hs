module Main where

import Modelo
import Persistencia

main :: IO ()
main = do
  putStrLn "PRUEBAS DE SEMANA 13"

  print (promedio [("Ana", 80), ("Luis", 60)])

  print (aprobados
    [("Ana", 80), ("Luis", 40)])

  print (parsearLinea "Pedro,75.0")

  print (parsearLinea "Maria,nota")
  
  putStrLn "Pruebas finalizadas."
