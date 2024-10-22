/*onjetivo: crear un programa de java que calcule la estación del año sabiendo el día y mes que ponga el usuario. Los limites de las estaciones están puestos en el programa
 						   autor: Francisco Javier Martín-Lunas Escobar
 						   fecha: 21/10/2022*/
package ejercicios;

import java.util.Scanner;

public class ejercico1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner entrada = new Scanner(System.in);
		int m, d;
		System.out.println("Inserte el día en el que se encuentra: ");
		d = entrada.nextInt();
		System.out.println("Inserte el mes en el que se encuentra de forma numérica, yendo del mes 1 enero al 12 diciembre: ");//se solicitan los meses numéricos sin 0 a la izquierda
		m = entrada.nextInt();
		if (m==12 && d>=21) {//inicio del invierno
			System.out.println("La estación el año es Invierno.");
		} else {
			if (m==1 || m==2 ) {
				System.out.println("La estación el año es Invierno.");
			} else {
				if (m==3 && d<=20) {//final del invierno
					System.out.println("La estación el año es Invierno.");
				} else {
					if (m==3 && d>=21) {//principio de la primavera
						System.out.println("La estación el año es Primavera.");
					} else {
						if (m==4 || m==5) {
							System.out.println("La estación el año es Primavera.");
						} else {
							if (m==6 && d<=21) {//final de la primavera
								System.out.println("La estación el año es Primavera.");
							} else {
								if (m==6 && d>=22) {//inicio del verano
									System.out.println("La estación el año es Verano.");
								} else {
									if (m==7 || m==8) {
										System.out.println("La estación el año es Verano.");
									} else {
										if (m==9 && d<=23) {//final del verano
											System.out.println("La estación el año es Verano.");
										} else {
											if (m==9 && d>=24) {// principio del otoño
												System.out.println("La estación el año es Otoño.");
											} else {
												if (m==10 || m==11) {
													System.out.println("La estación el año es Otoño.");
												} else {
													if (m==12 && d<=20) {//final del otoño
														System.out.println("La estación el año es Otoño.");
													}
												}
											}
										}
									}
								}
							}
						}
					}
				}
			}
		}

	}

}