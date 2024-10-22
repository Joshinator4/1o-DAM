package ejercicio5;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) {

		Scanner teclado = new Scanner (System.in);
		
		int numeroIntroducido, codigoIntroducido,codigoCambiar, cursosAprobados;
		ArrayList <Alumno> guardarAlumnos = new ArrayList<>();
		Alumno alumno1= new Alumno("Joshua", "Sangareau", "calle desengaño", " 980524653", 5, 10, LocalDate.of(2023, 9, 15));
		guardarAlumnos.add(alumno1);
		String nombreIntroducido, apellidosIntroducido, telefonoIntroducido, direccionIntroducido;
		boolean bandera = true;
		
		do {
			System.out.println("Introduzca el numero de opcion a realizar\n1.-Añadir nuevo alumno por defecto\n2.-Mostrar informacion a partir del codigo del alumno\n"
					+ "3.-Dar de baja a un alumno a partir de nombre y apellidos\n4.-Modifcar direccion y/o teléfono al alumno a partir del código"
					+ "\n5.-Realizar modificaciones por cambiar de ciclo formativo.\n0.-Salir del programa");
			numeroIntroducido = teclado.nextInt();
			switch(numeroIntroducido) {
				case (1):{
					guardarAlumnos.add(new Alumno());
					break;
					
				}case (2):{
					System.out.println("Introduzca el codigo del alumno a mostrar su información");
					codigoIntroducido = teclado.nextInt();
					for(Alumno i: guardarAlumnos){
						if(i.getCodigoAlumno() == codigoIntroducido) {
							System.out.println(i.toString());
						}else {
							System.out.println("El dodigo de alumno no existe");
						}
					}
					break;
				
				}case(3):{
					teclado.nextLine();
					System.out.println("Introduzca el nombre del alumno a dar de baja");
					nombreIntroducido = teclado.nextLine();
					System.out.println("Introduzca los apellidos del alumno a dar de baja");
					apellidosIntroducido = teclado.nextLine();
					try {
						for(Alumno i: guardarAlumnos){
							if(i.getNombre().equalsIgnoreCase(nombreIntroducido)) {
								if(i.getApellidos().equalsIgnoreCase(apellidosIntroducido)) {
									guardarAlumnos.remove(i);
								}else {
									System.out.println("No hay ningun alumno con esos apellidos");
								}
							}else {
								System.out.println("No hay ningun alumno con ese nombre");
							}
						}
					}catch(ConcurrentModificationException excepcion1) {
						System.out.println("Se ha eliminado el ultimo alumno de la lista, la lista ahora esta vacía");
					}
					break;
					
				}case(4):{
					System.out.println("Introduzca el codigo del alumno a modificar su información");
					codigoIntroducido = teclado.nextInt();
					System.out.println("Introuduzca la opcion deseada:\n1.-cambiar telefono.\n2.-cambiar dirección\n3.-cambiar telefono y dirección");
					numeroIntroducido = teclado.nextInt();
					if(numeroIntroducido == 1) {
						System.out.println("Introduzca el numero de telefono");
						teclado.nextLine();
						telefonoIntroducido = teclado.nextLine();
						for(Alumno i : guardarAlumnos) {
							if(i.getCodigoAlumno() == codigoIntroducido) {
								i.setTelefono(telefonoIntroducido);
							}else {
								System.out.println("El dodigo de alumno no existe");
							}
						}
					}else if(numeroIntroducido == 2) {
						teclado.nextLine();
						System.out.println("Introduzca la direccion");
						direccionIntroducido = teclado.nextLine();
						for(Alumno i : guardarAlumnos) {
							if(i.getCodigoAlumno() == codigoIntroducido) {
								i.setDireccion(direccionIntroducido);
							}else {
								System.out.println("El dodigo de alumno no existe");
							}
						}
					}else if(numeroIntroducido == 3) {
						teclado.nextLine();
						System.out.println("Introduzca el numero de telefono");
						telefonoIntroducido = teclado.nextLine();
						System.out.println("Introduzca la direccion");
						direccionIntroducido = teclado.nextLine();
						for(Alumno i : guardarAlumnos) {
							if(i.getCodigoAlumno() == codigoIntroducido) {
								i.setTelefono(direccionIntroducido);
								i.setTelefono(telefonoIntroducido);
							}else {
								System.out.println("El dodigo de alumno no existe");
							}
						}
					}else {
						System.out.println("La opcion introducida es incorrecta");
					}
					break;
					
				}case(5):{
					System.out.println("Introduzca el codigo del alumno que desea cambiar de ciclo");
					numeroIntroducido = teclado.nextInt();
					for(Alumno i : guardarAlumnos) {
						if(i.getCodigoAlumno() == numeroIntroducido) {
							System.out.println("Introduzca el código del ciclo al que quiere cambiarse");
							codigoCambiar = teclado.nextInt();
							System.out.println("Introduzca número de cursos aprobados");
							cursosAprobados = teclado.nextInt();
							i.setCodigoCiclo(codigoCambiar);
							i.setCantidadCursosAprobados(cursosAprobados);
						}else {
							System.out.println("El dodigo de alumno no existe");
						}
					}
					break;
					
				}case(0):{
					System.out.println("Se va a proceder a salir del programa, ¡Hasta pronto!");
					bandera = false;
					break;
					
				}default:{
					System.out.println("Numero incorecto introduzca un numero del 1 al 4");
					break;
				}
				
				}
		
	
		
		}while(bandera==true);
	}

}
