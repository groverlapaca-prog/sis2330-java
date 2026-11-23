module Main where

import Test.Hspec
import Lib

main :: IO ()
main = hspec $ do

    describe "Pruebas de suma" $ do
        it "Suma dos numeros" $ do
            suma 5 7 `shouldBe` 12

    describe "Pruebas de doble" $ do
        it "Duplica un numero" $ do
            doble 8 `shouldBe` 16

    describe "Pruebas de promedio" $ do
        it "Calcula el promedio" $ do
            promedio [10,20,30] `shouldBe` 20.0
