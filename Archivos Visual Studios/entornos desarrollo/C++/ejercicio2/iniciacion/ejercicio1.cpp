/*
* Nombre: Suma de dos numeros
*Autor: Joshua Sangareau
*Fecha: 08/03/2024
*Descripción: Suma de dos numeros
*/

#include <iostream>

using namespace std;

int main(){
    double numero1, numero2, total;

    cout << "Introduce el primer numero" << endl;
    cin >> numero1;
    cout << "Introduce el segundo numero" << endl;
    cin >> numero2;
    cout << "Se va a proceder a sumar los 2 nunmeros introducidos" << endl;

    total = numero1 + numero2;

    cout << "Resultado: " << endl;
    cout << total << endl;

    return 0;
}