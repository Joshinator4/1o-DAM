/*
* Nombre: switch-case
*Autor: Joshua Sangareau
*Fecha: 08/03/2024
*Descripción: Realiza un programa donde usuario ingresa un número del mes y luego
se utiliza la declaración switch para seleccionar el nombre del mes
correspondiente. Cada case representa un número de mes y se imprime
el nombre del mes correspondiente. Si el número ingresado no está en el
rango de 1 a 12, se imprime un mensaje de error utilizando default
*/

#include <iostream>

using namespace std;

int main(){

    int numeroMes;

    cout << "Introduzca un numero de mes" << endl;
    cin >> numeroMes;

    switch (numeroMes){
        case (1):{
            cout << "El mes es enero" << endl;
            break;
        }case (2):{
            cout << "El mes es febrero" << endl;
            break;
        }case (3):{
            cout << "El mes es marzo" << endl;
            break;
        }case (4):{
            cout << "El mes es abril" << endl;
            break;
        }case (5):{
            cout << "El mes es mayo" << endl;
            break;
        }case (6):{
            cout << "El mes es junio" << endl;
            break;
        }case (7):{
            cout << "El mes es julio" << endl;
            break;
        }case (8):{
            cout << "El mes es agosto" << endl;
            break;
        }case (9):{
            cout << "El mes es septiembre" << endl;
            break;
        }case (10):{
            cout << "El mes es octubre" << endl;
            break;
        }case (11):{
            cout << "El mes es noviembre" << endl;
            break;
        }case (12):{
            cout << "El mes es diciembre" << endl;
            break;
        }default:{
            cout << "Error: el numero de mes es incorrecto, debe ser del 1 al 12" << endl;
            break;
        }
    }
    return 0;
}