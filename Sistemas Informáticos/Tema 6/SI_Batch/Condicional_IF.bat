@echo off
title Uso de if
::Pedimos al usuario un numero
set/p NUMERO=Escribe tu numero
set/p Nombre=Escribe tu nombre
IF %NUMERO% EQU 11 (echo Tienes el numero maestro 11) else (echo tu numero no es el numero maestro 11)
IF %NUMERO% EQU 22 (echo Tienes el numero maestro 22)
IF %NUMERO% EQU 33 echo Tienes el numero maestro 33
echo Tu numero es %NUMERO%
pause