
package ejercicios;

import java.util.Scanner;

public class ejercicio3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
				Scanner entrada = new Scanner(System.in);
				int n=1, n1=0, n2=0, n3=0, n4=0, n5=0, n6=0, n7=0, n8=0, n9=0, n10=0;
				int nm1, nm2, nm3, nm4, nm5, nm6, nm7, nm8, nm9, nm10;
				int ns1=0, ns2=0, ns3=0, ns4=0, ns5=0, ns6=0, ns7=0, ns8=0, ns9=0, ns10=0;
				while (n!=0){
					System.out.println("Inserte un número comprendido entre 1 al 100 y cuando quiera parar ponga 0");
					n = entrada.nextInt();
					if (n==1 && n<=10) {
						n1++;
						ns1=ns1+n;
						nm1=ns1/n1;
					} else {
						if (n==11 && n<=20) {
							n2++;
							ns2=ns2+n;
							nm2=ns2/n2;
						} else {
							if (n==21 && n<=30) {
								n3++;
								ns3=ns3+n;
								nm2=ns2/n2;
							} else {
								if (n==31 && n<=40) {
									n4++;
									ns4=ns4+n;
									nm4=ns4/n4;
								} else {
									if (n==41 && n<=50) {
										n5++;
										ns5=ns5+n;
										nm5=ns5/n5;
									} else {
										if (n==51 && n<=60) {
											n6++;
											ns6=ns6+n;
											nm6=ns6/n6;
										} else {
											if (n==61 && n<=70) {
												n7++;
												ns7=ns7+n;
												nm7=ns7/n7;
											} else {
												if (n==71 && n<=70) {
													n7++;
													ns7=ns7+n;
												} else {
													if (n==71 && n<=80) {
														n8++;
														ns8=ns8+n;
													} else {
														if (n==81 && n<=90) {
															n9++;
															ns9=ns9+n;
														} else {
															if (n==91 && n<=100) {
																n10++;
																ns10=ns10+n;
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
				System.out.println("La cantidad de números introducidos en la primera decena es: "+n1);
				System.out.println("La cantidad de números introducidos en la primera decena es: "+n2);
				System.out.println("La cantidad de números introducidos en la primera decena es: "+n3);
				System.out.println("La cantidad de números introducidos en la primera decena es: "+n4);
				System.out.println("La cantidad de números introducidos en la primera decena es: "+n5);
				System.out.println("La cantidad de números introducidos en la primera decena es: "+n6);
				System.out.println("La cantidad de números introducidos en la primera decena es: "+n7);
				System.out.println("La cantidad de números introducidos en la primera decena es: "+n8);
				System.out.println("La cantidad de números introducidos en la primera decena es: "+n9);
				System.out.println("La cantidad de números introducidos en la primera decena es: "+n10);

			}
}