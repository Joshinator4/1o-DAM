/*
* Nombre: Función y Procedimiento combinados
*Autor: Joshua Sangareau
*Fecha: 08/03/2024
*Descripción: Desarrolla un programa en C++ que incluya tanto una función como un procedimiento. El procedimiento debe llamarse incrementar y tomar un número entero por referencia,
*incrementando su valor en 1. La función debe llamarse calcularCuadrado y tomar un número entero como argumento, devolviendo el cuadrado de ese número.
*En el programa principal, define una variable entera, muestra su valor original, llama al procedimiento incrementar con esta variable como argumento, muestra el nuevo valor de la variable,
*luego llama a la función calcularCuadrado con la misma variable y muestra el resultado devuelto por la función.
*/

#include <iostream>

using namespace std;

void incrementar(int &numero){
    numero+=1;
}

int calcularCuadrado(int numero){

    return numero * numero;
}

int main(){

int numero = 2;

cout << "Este es el valor inicial del numero: " << numero << endl;

incrementar(numero);

cout << "Este es el valor del numero tras llamar al procedimiento incrementar: " << numero << endl;

cout << "Este es el resultado de elevar al cuadrado el numero: " << calcularCuadrado(numero) << endl;

return 0;

}