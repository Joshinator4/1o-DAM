/*
* Nombre: Paso por Valor
*Autor: Joshua Sangareau
*Fecha: 08/03/2024
*Descripción: Escribe un programa en C++ que defina una función llamada suma que tome dos números enteros como parámetros y devuelva la suma de estos dos números.
*En el programa principal, solicita al usuario dos números enteros, llama a la función suma con estos números como argumentos y muestra el resultado de la suma.
*/

#include <iostream>

using namespace std;

int suma(int numero1, int numero2){
    return numero1+numero2;
}

int main(){

int numero1, numero2;

cout << "Introduzca el primer numero a sumar" << endl;

cin >> numero1;

cout << "Introduzca el segundo numero a sumar" << endl;

cin >> numero2;

cout << "El resultado de la suma es: " << suma(numero1, numero2) << endl;

return 0;

}