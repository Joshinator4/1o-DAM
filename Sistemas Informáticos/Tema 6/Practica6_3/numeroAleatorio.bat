@echo off
set/p numeroIntroducido=Introduzca un numero
set/a numeroAleatroio=(%RANDOM%%%(100-1+1))+1
echo %numeroAleatroio%
set i=false
	if %numeroAleatroio% equ %numeroIntroducido% (echo Has hacertado!
	set i=true 
	exit
	)
	if %numeroAleatroio% lss %numeroIntroducido% (echo el numero es menor)
	if %numeroAleatroio% gtr %numeroIntroducido% (echo el numero es mayor)