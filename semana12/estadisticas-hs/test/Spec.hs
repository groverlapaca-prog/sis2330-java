module Main (main) where

import Test.Hspec
import Estadisticas

main :: IO ()
main = hspec $ do

    describe "Funcion promedio" $ do
        it "calcula el promedio de estudiantes" $ do
            promedio [("Ana", 90), ("Luis", 45), ("Marta", 70)]
                `shouldBe` 68.33333333333333

        it "devuelve cero si la lista esta vacia" $ do
            promedio [] `shouldBe` 0

    describe "Funcion masAlto" $ do
        it "encuentra al estudiante con mayor nota" $ do
            masAlto [("Ana", 90), ("Luis", 45), ("Marta", 70)]
                `shouldBe` ("Ana", 90)

    describe "Funcion ordenarPorNota" $ do
        it "ordena de mayor a menor" $ do
            ordenarPorNota [("Luis", 45), ("Ana", 90), ("Marta", 70)]
                `shouldBe` [("Ana", 90), ("Marta", 70), ("Luis", 45)]

    describe "Funcion aprobados" $ do
        it "muestra solamente notas mayores o iguales a 51" $ do
            aprobados [("Ana", 90), ("Luis", 45), ("Marta", 70)]
                `shouldBe` [("Ana", 90), ("Marta", 70)]

        it "devuelve lista vacia si nadie aprobo" $ do
            aprobados [("Luis", 30), ("Pedro", 40)]
                `shouldBe` []
