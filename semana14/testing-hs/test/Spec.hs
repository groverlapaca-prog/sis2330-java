module Main where

import Test.HUnit
import Test.QuickCheck
import Notas
import System.Exit (exitFailure, exitSuccess)

-- Test del promedio
testPromedioSimple :: Test
testPromedioSimple = TestCase $
    assertEqual "Promedio de 3 notas" 20.0
        (promedio [("A",10), ("B",20), ("C",30)])

-- Test de lista vacia
testPromedioVacio :: Test
testPromedioVacio = TestCase $
    assertEqual "Promedio de lista vacia" 0.0
        (promedio [])

-- Test de nota mas alta
testMasAlto :: Test
testMasAlto = TestCase $
    assertEqual "El mas alto"
        (Just ("B",90))
        (masAlto [("A",70), ("B",90), ("C",60)])

-- Test de aprobados
testAprobados :: Test
testAprobados = TestCase $
    assertEqual "Solo aprobados"
        [("A",80)]
        (aprobados [("A",80), ("B",40)])

-- Test de linea valida
testParsearLineaValida :: Test
testParsearLineaValida = TestCase $
    assertEqual "Linea valida"
        (Right ("Ana",85.0))
        (parsearLinea "Ana,85.0")

-- Test de linea invalida
testParsearLineaInvalida :: Test
testParsearLineaInvalida = TestCase $
    case parsearLinea "sinformato" of
        Left _ -> return ()
        Right _ -> assertFailure "Debia haber fallado el parseo"

-- Propiedad QuickCheck
propOrdenarPreservaLongitud :: [(String, Double)] -> Bool
propOrdenarPreservaLongitud xs =
    length (ordenarPorNota xs) == length xs

-- Lista de todos los tests
todosLosTests :: Test
todosLosTests = TestList
    [ TestLabel "promedio simple" testPromedioSimple
    , TestLabel "promedio vacio" testPromedioVacio
    , TestLabel "mas alto" testMasAlto
    , TestLabel "aprobados" testAprobados
    , TestLabel "parsear linea valida" testParsearLineaValida
    , TestLabel "parsear linea invalida" testParsearLineaInvalida
    ]

main :: IO ()
main = do
    resultados <- runTestTT todosLosTests

    putStrLn "Propiedad QuickCheck:"
    quickCheck propOrdenarPreservaLongitud

    if errors resultados + failures resultados == 0
        then exitSuccess
        else exitFailure
