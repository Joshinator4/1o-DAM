/*
* Nombre: Paso por Referencia
*Autor: Joshua Sangareau
*Fecha: 08/03/2024
*Descripción: Crea un programa en C++ que tenga un procedimiento llamado duplicar.
*Este procedimiento debe tomar un número entero como parámetro y duplicar su valor. En el programa principal,
*define una variable entera, muestra su valor original, llama al procedimiento duplicar con esta variable como argumento y muestra el nuevo valor de la variable después de duplicarla.
*/

#include <iostream>

using namespace std;

void duplicar(int &numero){
    numero*=2;
}

int main(){

int numero;

cout << "Introduzca el numero a duplicar" << endl;

cin >> numero;

duplicar(numero);

cout << "El resultado de duplicar el numero es es: " << numero << endl;

return 0;

}