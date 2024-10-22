/*
* Nombre: Calcular el factorial de un número (emplea for):
*Autor: Joshua Sangareau
*Fecha: 08/03/2024
*Descripción:Calcular el factorial de un número (emplea for):
*/

#include <iostream>

using namespace std;

int main(){

    int numeroIntroducido, total = 0;

    cout << "Introduzca un numero para calcular su factorial" << endl;
    cin >> numeroIntroducido;

    if(numeroIntroducido == 0){
        total = 1;
    }

    for(int i = 1; i < numeroIntroducido; i++){
        total = total * (i+1); 
    }

    cout << "El factorial de su numero es: " << total << endl;
}