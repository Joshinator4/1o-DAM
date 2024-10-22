@echo off
set globalvar=5
setlocal
set var=13145
set/A var=%var%+5
echo %var%
echo %globalvar%
endlocal