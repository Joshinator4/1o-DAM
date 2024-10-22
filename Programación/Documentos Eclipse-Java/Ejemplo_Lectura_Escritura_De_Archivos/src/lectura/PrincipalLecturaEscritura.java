package lectura;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrincipalLecturaEscritura {

	public static void main(String[] args) {
	
		/*
		 * ESTO ES PARA ARCHIVOS SEPARADOS POR ESPACIOS.
		 * SOLO COGERIA 1 NOMBRE. NO SIRVE PARA NOMBRES COMPUESTOS
		File archivo = new File("Empleado.txt");
		String nombre, fecha;
		LocalDate fechaIntroduccion;
		double salario;
		List<Empleado> listaEmpleados = new ArrayList<>();
		
		try {
			Scanner lector = new Scanner(archivo);
			while(lector.hasNextLine()) {
				
				nombre = lector.next();
				fecha = lector.next();
				salario = lector.nextDouble();
				fechaIntroduccion = LocalDate.parse(fecha);
				Empleado empleado1 = new Empleado(nombre, fechaIntroduccion, salario);
				listaEmpleados.add(empleado1);
				
			}
			lector.close();
		//LO NORMAL ES TRATAR TODAS LAS EXCEPCIONES O LAS MAS USUALES
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(Empleado i: listaEmpleados) {
			System.out.println(i.toString());
		}
	  */
		File archivo = new File("Empleado.txt");
		String linea, nombre, fecha;
		LocalDate fechaIntroduccion;
		double salario;
		List<Empleado> listaEmpleados = new ArrayList<>();;
		
		try {
			Scanner lector = new Scanner(archivo);
			while(lector.hasNextLine()) {
				
				linea = lector.nextLine();
				String [] arrayStrings = linea.split(";");
				fechaIntroduccion = LocalDate.parse(arrayStrings[1]);
				salario = Double.parseDouble(arrayStrings[2]);
				Empleado empleado1 = new Empleado(arrayStrings[0], fechaIntroduccion, salario);
				//tambien se puede hacer Empleado empleado1 = new Empleado(arrayStrings[0], LocalDate.parse(arrayStrings[1]), Double.valueOf(ArrayStrings[2]));
				listaEmpleados.add(empleado1);
			}
			lector.close();
			//LO NORMAL ES TRATAR TODAS LAS EXCEPCIONES O LAS MAS USUALES
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
		for(Empleado i: listaEmpleados) {
			System.out.println(i.toString());
		}
		
		
		try {
			
			FileWriter archivoEscritura = new FileWriter("EmpleadoEscritura.txt", true);//si ponemos true se situa al final del archivo. Si no se pone se creara el archivo EmpleadoEscritura.txt y si existe lo pisa.
			for(Empleado i: listaEmpleados) {
				archivoEscritura.write(i.getSalario() + ";" + i.getNombre() + ";" + i.getFechaNacimiento().toString() + "\n");
			}
			
			archivoEscritura.close();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
