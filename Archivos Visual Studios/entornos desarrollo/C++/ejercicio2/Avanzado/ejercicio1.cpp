/*
* Nombre: Implementa un menú que ejecute una calculadora:
*Autor: Joshua Sangareau
*Fecha: 08/03/2024
*Descripción: Implementa un menú que ejecute una calculadora:
*/

#include <iostream>

using namespace std;

int main(){

    char operador;
    double numero1, numero2, total=0;
    bool bandera = true;

    do
    {
        cout << "Introduzca un operador (+, -, *, /) o 'q' para salir" << endl;
        cin >> operador;

        if (operador == '+' || operador == '-' || operador == '*' || operador == '/'){
        
            cout << "Introduzca el primer numero" << endl;
            cin >> numero1;

            cout << "Introduzca el segundo numero" << endl;
            cin >> numero2;
        }else if(operador == 'q'){

        }

        switch (operador){
            case ('+'):{
                total = numero1 + numero2;
                 cout << "El resultado es: " << total << endl;
                break;   
            }case ('-'):{
                total = numero1 - numero2;
                 cout << "El resultado es: " << total << endl;
                break;   
            }case ('*'):{
                total = numero1 * numero2;
                 cout << "El resultado es: " << total << endl;
                break;   
            }case ('/'):{
                total = numero1 / numero2;
                 cout << "El resultado es: " << total << endl;
                break;   
            }case ('q'):{
                cout << "Se va a proceder a salir de la calculadora, Hasta pronto" << endl;
                bandera = false;
                break;   
            }default:{
                cout << "Se ha introducido un operador incorrecto" << endl;
                break;
            }
        }
    } while (bandera == true);
    
    
    
    return 0;
}