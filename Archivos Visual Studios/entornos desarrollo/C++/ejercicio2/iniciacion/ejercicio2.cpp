/*
* Nombre: Calcular area de un rectángulo
*Autor: Joshua Sangareau
*Fecha: 08/03/2024
*Descripción: Calcular area de un rectángulo
*/

#include <iostream>

using namespace std;

int main(){

    double altura, base, area;

    cout << "Introduzca la altura del rectangulo" << endl;
    cin >> altura;
    cout << "Introduzca la base del rectangulo" << endl;
    cin >> base;
    cout << "El perimetro del recangulo es: " << endl;

    area = altura*base;
    cout << area << endl;

    return 0;
}