/*
*Nombre: Cálculo del área de un círculo
*Autor: Joshua Sangareau
*Fecha: 08/03/2024
*Descripción: Cálculo del área de un círculo:
*/

#include <iostream>
#include <math.h>

using namespace std;

int main(){
    double radio, area;

    cout << "Introduce el radio del circulo" << endl;
    cin >> radio;
    cout << "Este es el area del circulo: " << endl;
    area = 2*M_PI*radio;
    cout << area << endl;

    return 0;
}