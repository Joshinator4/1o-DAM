/*
* Nombre: Verificar si un número es positivo, negativo o cero (emplea if-else):
*Autor: Joshua Sangareau
*Fecha: 08/03/2024
*Descripción: Suma de dos numeros
*/

#include <iostream>

using namespace std;

int main(){

    int numero;

    cout << "Introduzca un numero" << endl;
    cin >> numero;

    if(numero > 0){
        cout << "El numero introducido es positivo" << endl;
    }else if(numero < 0){
        cout << "El numero introducido es negativo" << endl;    
    }else{
        cout << "El numero introducido cero" << endl;
    }

    return 0;

}