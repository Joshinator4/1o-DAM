/*
 * Realizar un método auditoriaEmpresa, que devolverá un valor boolean.
Recibe los siguientes parámetros:
 SalarioJefe
 SalarioEncargado
 SalarioOficinistas
 numeroOficinistas
 proyectosTerminados (boolean)
 presupuestoEmpresa

El método hará las siguientes comprobaciones:
 Si los proyectos no se han terminado devolverá un valor false.y además mostrará un
mensaje por pantalla:" No ha pasado la auditoría ya que no ha terminado los
proyectos acordados".
 En caso contrario: calculará el gasto acumulado en sueldos globales : (sueldo jefe +
sueldo encargado + sueldo de todos los oficinistas).
Si sobrepasa los 20.000 euros devolverá un valor false y además mostrará el mensaje
por pantalla: " No ha pasado la auditoría ya que el gasto en personal es de ... y
excede el límite mensual de 20.000 euros".
 Si el gasto acumulado es inferior o igual a 20.000 euros comprobaremos el presupuesto
asignado por la empresa. Si es superior a 100.000 euros devolverá false y además
mostrará el mensaje por pantalla: "No ha pasado la auditoría ya que el presupuesto
asignado de .... excede el límite establecido de 100.000 euros".
 En caso contrario devolverá true y además mostrará un mensaje por pantalla:
"Enhorabuena!! Ha pasado la auditoría, nos vemos el año que viene".

 */
package ejercicio6;

import java.util.Scanner;

public class Ejercicio6 {

	public static void main(String[] args) {
		//----------------------------------------------
	    //          Declaración de variables 
	    //----------------------------------------------
		
	    // Constantes
	    // Variables de entrada
		double salarioJefe, salarioEncargado, salarioOficinistas, presupuestoEmpresa;
		int numeroOficinistas;
		char proyectos;
		boolean proyectosTerminados = false;
	    // Variables de salida
	    // Variables auxiliares
	    // Clase Scanner para petición de datos
		
	    Scanner teclado = new Scanner(System.in);
	    
	    //----------------------------------------------
	    //                Entrada de datos 
	    //----------------------------------------------
	    
	    System.out.println("Introduzca el salio del jefe");
	    salarioJefe = teclado.nextDouble();
	    
	    System.out.println("Introduzca el salio del encargado");
	    salarioEncargado = teclado.nextDouble();
	    
	    System.out.println("Introduzca el salio de cada oficinista");
	    salarioOficinistas = teclado.nextDouble();
	    
	    System.out.println("Introduzca el numero de oficinistas");
	    numeroOficinistas = teclado.nextInt();
	    
	    System.out.println("Introduzca el presupuesto de la empresa de este año");
	    presupuestoEmpresa = teclado.nextDouble();
	    
	    System.out.println("Introduzca S/N según si han terminado los proyectos (S) o no (N)");
	    proyectos = teclado.next().charAt(0);
	    
	    if(proyectos == 's' || proyectos == 'S') {
	    	proyectosTerminados = true;
	    } else if (proyectos == 'n' || proyectos == 'N') {
	    	proyectosTerminados = false;
	    }
	    
	    auditoriaEmpresa (salarioJefe, salarioEncargado, salarioOficinistas, numeroOficinistas, proyectosTerminados, presupuestoEmpresa);
	    //----------------------------------------------
	    //                 Procesamiento 
	    //----------------------------------------------
	    
	    
	    
	    
	}
	
	public static boolean auditoriaEmpresa(double x, double y, double z, int q, boolean r, double s) {
		boolean auditoria = false;
		double salariosTotales = x + y + (z*q);
		if(r == false) {
			auditoria = false;
			System.out.println("No ha pasado la auditoría ya que no ha terminado los proyectos acordados");
		} else {
			if (salariosTotales > 20000) {
				auditoria = false;
				System.out.println("No ha pasado la auditoría ya que el gasto en personal es de " + salariosTotales + "€ y excede el límite mensual de 20.000 euros");
			}else {
				if(s > 100000) {
					auditoria = false;
					System.out.println("No ha pasado la auditoría ya que el presupuesto asignado de " + s + "€ excede el límite establecido de 100.000 euros");
				} else {
					auditoria = true;
					System.out.println("Enhorabuena!! Ha pasado la auditoría, nos vemos el año que viene");
				}
			}
			
		}
		return auditoria;
	} 
}
