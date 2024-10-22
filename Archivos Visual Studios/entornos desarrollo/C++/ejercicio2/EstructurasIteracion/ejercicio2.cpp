/*
* Nombre: Sumar los primeros 10 números naturales (emplea do-while):
*Autor: Joshua Sangareau
*Fecha: 08/03/2024
*Descripción: Sumar los primeros 10 números naturales (emplea do-while):
*/

#include <iostream>

using namespace std;

int main(){

    int numero = 1, total = 0;

    do{
       total += numero;
       numero++;
    } while (numero <= 10);

    cout << "esto es la suma de los 10 primeros numeros naturales: " << total << endl;     

    return 0;

}