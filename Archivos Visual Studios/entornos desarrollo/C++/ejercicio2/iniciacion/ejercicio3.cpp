/*
* Nombre: Calcular la media de 3 numeros
*Autor: Joshua Sangareau
*Fecha: 08/03/2024
*Descripción: Calcular la media de 3 numeros
*/

#include <iostream>

using namespace std;

int main(){

    double numero1, numero2, numero3, media;

    cout << "Introduce el primer numero:" << endl;
    cin >> numero1;
    cout << "Introduce el segundo numero:" << endl;
    cin >> numero2;
    cout << "Introduce el tercer numero:" << endl;
    cin >> numero3;

    media = (numero1+numero2+numero3)/3;

    cout << "La media de los 3 numeros es:" << endl;
    cout << media;
    
    return 0;
}