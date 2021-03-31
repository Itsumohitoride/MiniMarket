package ui;

import java.util.Scanner;

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

		System.out.println("*********************************************");
		System.out.println("*                  MENU                     *");
		System.out.println("*********************************************");
		System.out.println("* Que desea hacer?:                         *");
		System.out.println("* (1) Contratar un empleado                 *");
		System.out.println("* (2) Despedir un empleado                  *");
		System.out.println("* (0) Salir                                 *");
		System.out.println("*********************************************");

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

			try {

				optionToDocument = Integer.parseInt(option);

				if(optionToDocument != 1 && optionToDocument != 2 && optionToDocument != 3 && optionToDocument != 4) {
					System.out.println("Opción no valida, digitelo nuevamente");
				}
				else {
					System.out.println("Ingrese el número del documento");
					
					numberDocument = lector.nextLine();
					
					lastInteger = Integer.parseInt(numberDocument.substring(numberDocument.length()));
				}
				
				//market.createPeople(optionToDocument, numberDocument);
				
			}catch(NumberFormatException e) {
				System.out.println("El valor digitado no es numérico, por favor corregirlo");
			}
		}while(optionToDocument != 1 && optionToDocument != 2 && optionToDocument != 3 && optionToDocument != 4 && lastInteger == 0);
	}

	public void consultPerson() {

	}
}