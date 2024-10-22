package ejercicio1;

import java.util.HashSet;
import java.util.InputMismatchException;
import java.util.Scanner;

import ejercicio1.SocioMejorado.TipoCliente;

public class PricipalMejorado {

	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		HashSet<SocioMejorado> listaSocios = new HashSet<>();
		HashSet<Curso> listaCursos = new HashSet<>();
		
		int opcionDeseada, numeroIntroducido, adultoAsociado, maxAlumnos, codigoCurso;
		String nombreIntroducido, dniIntroducido, descripcionIntroducido;
		double precio;
		
		
		do {
			System.out.println("Elija un opcion:\n1.-Añadir socio.\n2.-Añadir curso."
					+ "\n3.-Matricular socio en curso\n4.-Mostrar informacion de los socios"
					+ "\n0.-Salir del programa");
			opcionDeseada = teclado.nextInt();
			switch (opcionDeseada) {
			case(1):{
				try {
					listaSocios.add(pedirSocio(teclado, listaSocios));
				}catch(IllegalArgumentException excepcion1) {
					System.out.println(excepcion1.getMessage());
				}catch(InputMismatchException excepcion2) {
					System.out.println(excepcion2.getMessage());
				}
					
				
				break;
				
			}case(2):{
				try {
					listaCursos.add(pedirCurso(teclado, listaCursos));
				}catch(IllegalArgumentException excepcion3) {
					System.out.println(excepcion3.getMessage());
				}
				
				break;
				
			}case(3):{
				try {
					matricularSocio(teclado, listaSocios, listaCursos);
				}catch(IllegalArgumentException excepcion4) {
					System.out.println(excepcion4.getMessage());
				}
				
				break;
				
			}case(4):{
				System.out.println("Mostrando la informacion de los Socios: \n " + informeSocios(listaSocios));
				break;
				
			}case(0):{
				System.out.println("Se va a proceder a cerrar el programa, ¡Hasta Pronto!");
				break;
			}default:{
				System.out.println("Se ha introducido una opcion incorrecta, introduzca un numero de cualquiera de las funciones");
			}
			
			
			}
				
			
		}while(opcionDeseada != 0);
		}
	
		public static boolean comprobarDni (String dni, HashSet<SocioMejorado> lista){
			boolean devolucion=true;
			for(SocioMejorado i: lista) {
				if(i.getDni().equals(dni)) {
					devolucion = false;
				}
			}
			return devolucion;
			
		}
		
		public static boolean comprobarAdulto(int codigoAdulto, HashSet<SocioMejorado> lista) {
			boolean devolucion=false;
			for(SocioMejorado i: lista) {
				if(i.getCodigoCliente() == codigoAdulto) {
					devolucion = true;
				}
			}
			if(codigoAdulto==0) {
				devolucion=true;
			}
			return devolucion;
		}
		
		public static boolean comprobarCurso(String nombre, HashSet<Curso> lista) {
			boolean devolucion = true;
			for(Curso i: lista) {
				if(i.getNombre().equalsIgnoreCase(nombre)) {
					devolucion = false;
				}
			}
			return devolucion;
		}
		
		//este metodo pide los datos del socio incluido el tipo y devuleve un objeto de tipo socio
		public static SocioMejorado pedirSocio(Scanner teclado, HashSet<SocioMejorado> lista) throws IllegalArgumentException{
			SocioMejorado devolucion;
			int numeroIntroducido, adultoAsociado;
			String nombreIntroducido, dniIntroducido;
			System.out.println("Introduzca 1 para normal, 2 para jubilado o 3 para infantil");
			numeroIntroducido = teclado.nextInt();
			teclado.nextLine();
			System.out.println("Introduzca el nombre");
			nombreIntroducido = teclado.nextLine();
			System.out.println("Introduzca el dni");
			dniIntroducido = teclado.nextLine();
			 if(comprobarDni(dniIntroducido, lista)) {
				 if(numeroIntroducido == 1) {
						devolucion = new SocioMejorado(nombreIntroducido, dniIntroducido, TipoCliente.NORMAL);
					}else if(numeroIntroducido == 2) {
						devolucion = new SocioMejorado(nombreIntroducido, dniIntroducido,TipoCliente.JUBILADO);
					}else if(numeroIntroducido == 3) {
						//este apartado crea y añade un socio infantil a la lista de socios si el adulto existe o el codigo es 0 (no esta asociado a ningun adulto)
						System.out.println("Introduzca el adulto al que está asociado, si no esta asociado introduzca 0");
						adultoAsociado = teclado.nextInt();
						if(comprobarAdulto(adultoAsociado, lista)) {
							devolucion = new SocioInfantil(nombreIntroducido, dniIntroducido,TipoCliente.INFANTIL, adultoAsociado);
						}else {
							throw new IllegalArgumentException("Este codigo de socio no existe no se creará al socio infantil");
						}
						
					}else {
						throw new IllegalArgumentException("El numero introducido es incorrecto");
					}
			 }else{
				 throw new IllegalArgumentException("Este dni ya existe no se creará el socio");
			 }
				
			return devolucion;
		}
		
		//este metodo pide los datos del curso y devulve un objeto de tipo curso
		public static Curso pedirCurso(Scanner teclado, HashSet<Curso> lista) throws IllegalArgumentException{
			Curso devolucion;
			String nombreIntroducido, descripcionIntroducido;
			double precio;
			int maxAlumnos, codigoCurso;
			teclado.nextLine();
			System.out.println("Introduzca el nombre del curso");
			nombreIntroducido = teclado.nextLine();
			
			if(comprobarCurso(nombreIntroducido, lista)) {
				
				System.out.println("Introduzca la descripcion del curso");
				descripcionIntroducido = teclado.nextLine();
				System.out.println("Introduzca el precio");
				precio = teclado.nextDouble();
				System.out.println("Introduzca el numero maximo de alumnos");
				maxAlumnos = teclado.nextInt();
			
				devolucion = new Curso(nombreIntroducido, descripcionIntroducido, precio, maxAlumnos);
			
			}else{
				throw new IllegalArgumentException("El nombre del curso ya existe. no se crerá");
			}
			
			return devolucion;
		}
		
		//Este metodo filtrará si existe el socio en la lista de socios y devuelve el objeto SocioMejorado
		public static SocioMejorado sePuedeMatricularSocio(String dni, HashSet<SocioMejorado> listaSocio) throws IllegalArgumentException{
			SocioMejorado devolucion = null;
			for(SocioMejorado i: listaSocio) {
				if(i.getDni().equals(dni)){
					devolucion = i;
				}
			}
			if(devolucion == null) {
				throw new IllegalArgumentException("El dni del socio no existe, no se matriculará el socio en el curso");
			}
			return devolucion;
		}
		
		//Este metodo filtrará si el curso tiene capacidad para algun alumno más
		public static boolean comprobarCantidadAlumnos(int codigoCurso, HashSet<Curso> listaCurso) throws IllegalArgumentException{
			boolean devolucion=true;
			for(Curso i: listaCurso) {
				if(i.getCodigoCurso() == codigoCurso) {
					if(i.getContadorAlumnos() >= i.getMaxAlumnos()) {
						devolucion = false;
					}
				}
			}
			if(devolucion == false) {
				throw new IllegalArgumentException("Se ha superado el numero maximo de alumnos");
			}
			return devolucion;
		}
		
		public static Curso saberSiExisteCurso(int codigoCurso, HashSet<Curso> listaCurso) {
			Curso devolucion = null;
			for(Curso i: listaCurso) {
				if(i.getCodigoCurso() == codigoCurso) {
					devolucion = i;
				}
			}
			return devolucion;
		}
		
		//Este metodo recibe un Socio y filtra si el curso ya se ha creado(debe estar creado) para devolver el Curso. 
		//Tambien filtra si el socio ya está matriculado(no lo permitirá matricularse en caso afirmativo) y si hay espacio en el curso a matricularse llamando a los metodos correspondientes
		public static Curso sePuedeMatricularCurso(String dni, int codigoCurso, HashSet<SocioMejorado> listaSocio, HashSet<Curso> listaCurso) throws IllegalArgumentException{
			Curso devolucion = null;
			SocioMejorado socio= null;
			boolean sePuede = true, existeCurso=false;
			socio = sePuedeMatricularSocio(dni, listaSocio);
			
			if(socio != null) {
				for(Curso j: socio.getArrayCursos()) {
					if(j.getCodigoCurso() == codigoCurso) {
						sePuede = false;
					}
				}
				if(sePuede == true){
					comprobarCantidadAlumnos(codigoCurso, listaCurso);
					devolucion = saberSiExisteCurso(codigoCurso, listaCurso);
					if(devolucion == null) {
						throw new IllegalArgumentException("El codigo del curso no existe, no se matriculará el socio en el curso");
					}
				}else {
					throw new IllegalArgumentException("El socio ya esta matriculado en el curso, no se matriculará el socio en el curso");
				}
				
			}
			return devolucion;
			
		}
		
		//Este metodo Solicita los datos necesarios para poder matricular un socio en un curso. Llamara a los metodos correspondientes que filtrarán
		//todos los requisitos.
		public static void matricularSocio(Scanner teclado, HashSet<SocioMejorado> listaSocio, HashSet<Curso> listaCurso) throws IllegalArgumentException{
			String dni;
			int codigoCurso;
			
			teclado.nextLine();
			System.out.println("Introduzca el dni del socio");
			dni = teclado.nextLine();
			System.out.println("Introduzca el codigo del curso");
			codigoCurso = teclado.nextInt();
			teclado.nextLine();
			
			SocioMejorado socio = sePuedeMatricularSocio(dni, listaSocio);
			Curso curso = sePuedeMatricularCurso(dni, codigoCurso, listaSocio, listaCurso);
			
			if(socio != null) {
				if(curso != null) {
					socio.matricularEnCurso(curso);
					curso.setContadorAlumnos(curso.getContadorAlumnos()+1);
				}
			}
			
		}
		
		//Este metodo muestra los datos de los socios
		public static String informeSocios(HashSet<SocioMejorado> listaSocio) {
			String devolucion= "Este es listado de socios:";
			
			for(SocioMejorado i: listaSocio) {
				devolucion+= "\n" + i.toString();
			}
			return devolucion;
		}
		
	}