module Historial
    ( Conteo
    , registrarConsulta
    , consultasDe
    ) where

import Control.Monad.State
import qualified Data.Map as Map

type Conteo = Map.Map String Int

-- Registra una consulta
registrarConsulta :: String -> State Conteo ()
registrarConsulta nombre =
    modify (Map.insertWith (+) nombre 1)

-- Consulta cuantas veces aparece un nombre
consultasDe :: String -> Conteo -> Int
consultasDe nombre conteo =
    Map.findWithDefault 0 nombre conteo
