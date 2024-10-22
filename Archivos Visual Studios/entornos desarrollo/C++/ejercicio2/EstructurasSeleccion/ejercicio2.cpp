/*
* Nombre: Calcular el mayor de tres números (emplea if-else):
*Autor: Joshua Sangareau
*Fecha: 08/03/2024
*Descripción: Calcular el mayor de tres números (emplea if-else):
*/

#include <iostream>

using namespace std;

int main(){
    int numero1, numero2, numero3;

    cout << "Introduzca el primer numero" << endl;
    cin >> numero1;

    cout << "Introduzca el segundo numero" << endl;
    cin >> numero2;

    cout << "Introduzca el tercer numero" << endl;
    cin >> numero3;

    if(numero1 > numero2){
        if(numero1 > numero3){
            cout << "El primer numero es el mayor" << endl;
        }else{
            cout << "El tercer numero es el mayor" << endl;
        }

    }else{
        if(numero2 > numero3){
            cout << "El segundo numero es el mayor" << endl;
        }else{
           cout << "El tercer numero es el mayor" << endl; 
        }
    }

    return 0;

}