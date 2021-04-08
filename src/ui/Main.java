package ui;

import java.util.Scanner;

import exceptions.MinorException;
import exceptions.PickAndCedulaException;
import model.Document;
import model.MiniMarket;

public class Main {

	private MiniMarket market;

	public Scanner lector;

	public Main() {

		lector = new Scanner(System.in);
		createMiniMarket();
	}

	public static void main(String[] args) {

		Main objMain = new Main();
		int option = 1;

		while(option != 0){
			option = objMain.menu();
		}
	}

	public void createMiniMarket() {

		market = new MiniMarket();
	}

	public int menu() {

		String option = "";
		int optionToSwitch = 3;

		System.out.println("*******************************************************");
		System.out.println("*    Bienvenido al registro de Mi Barrio Te Quiere    *");
		System.out.println("*******************************************************\n");

		System.out.println("**************************************************************");
		System.out.println("*                            MENU                            *");
		System.out.println("**************************************************************");
		System.out.println("* Que desea hacer?:                                          *");
		System.out.println("* (1) Registrar el ingreso de una persona                    *");
		System.out.println("* (2) Mostrar el número de personas que han intentado entrar *");
		System.out.println("* (0) Salir                                                  *");
		System.out.println("**************************************************************");

		do {
			option = lector.nextLine();
			try {

				optionToSwitch = Integer.parseInt(option);

				switch(optionToSwitch) {
				case 0:
					System.out.println("***********************************************************************");
					System.out.println("*                Gracias por utilizar nuestro software                *");
					System.out.println("***********************************************************************");
					break;
				case 1:
					registerPerson();
					break;
				case 2:
					consultPerson();
					break;
				default:
					System.out.println("**********************************************************************");
					System.out.println("*                  Opcion invalida, digite de nuevo                  *");
					System.out.println("**********************************************************************");
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("El valor digitado no es numérico, por favor corregirlo");
			}

		}while(optionToSwitch != 1 && optionToSwitch != 2 && optionToSwitch != 0);

		return optionToSwitch;
	}

	public void registerPerson() {

		String option = "";
		String numberDocument = "";
		String message = "";
		int optionToDocument = 0;
		int lastInteger = 0;
		
		System.out.println("***********************************************************************");
		System.out.println("*                       REGISTRO DE UNA PERSONA                       *");
		System.out.println("***********************************************************************");

		System.out.println("********************************");
		System.out.println("* Que tipo de documento tiene? *");
		System.out.println("********************************");
		System.out.println("* (1) Tarjeta de Identidad     *");
		System.out.println("* (2) Cédula de Ciudadanía     *");
		System.out.println("* (3) Pasaporte                *");
		System.out.println("* (4) Cédula de Extranjería    *");
		System.out.println("********************************");

		do {

			option = lector.nextLine();

			do {
				try {

					optionToDocument = Integer.parseInt(option);

					if(optionToDocument != 1 && optionToDocument != 2 && optionToDocument != 3 && optionToDocument != 4) {
						System.out.println("Opción no valida, digitelo nuevamente");
					}
					else {
						
						System.out.println("Ingrese el número del documento");

						numberDocument = lector.nextLine();

						lastInteger = Integer.parseInt(numberDocument.substring(numberDocument.length()-2));
						
						switch(optionToDocument) {
						case 1:
							message = market.addPeople(Document.TI, numberDocument);
							break;
						case 2:
							message = market.addPeople(Document.CC, numberDocument);
							break;
						case 3:
							message = market.addPeople(Document.PP, numberDocument);
							break;
						case 4:
							message = market.addPeople(Document.CE, numberDocument);
							break;
						}
					}

				}catch(NumberFormatException e) {
					System.out.println("El valor digitado no tiene el penúltimo valor numérico, por favor corregirlo");
				}catch(MinorException mE) {
					
					System.out.println("***********************************************************************************");
					System.out.println("*  La persona que esté intentando ingresar NO puede entrar por ser menor de edad  *");
					System.out.println("***********************************************************************************");
				}catch(PickAndCedulaException pcE) {
					System.out.println("**********************************************************************************************");
					System.out.println("*  La persona que está intentando ingresar NO puede entrar porque no le corresponde el día   *");
					System.out.println("**********************************************************************************************");
				}

			}while(lastInteger == 0);
			
		}while(optionToDocument != 1 && optionToDocument != 2 && optionToDocument != 3 && optionToDocument != 4);
		
		
		System.out.println(message);
	}

	public void consultPerson() {
		
		System.out.println("***********************************************************************");
		System.out.println("*       NUMERO DE PERSONAS QUE HAN INTENTADO INGRESAR AL LOCAL        *");
		System.out.println("***********************************************************************");
		
		System.out.println("Número de personas: "+market.getContPoeple());
	}
}