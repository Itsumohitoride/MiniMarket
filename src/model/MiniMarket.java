package model;

import java.time.LocalDate;
import java.util.ArrayList;

import exceptions.MinorException;
import exceptions.PickAndCedulaException;

public class MiniMarket {
	
	//Constants
	
	public final static int ONE = 1;
	
	//Attribute
	
	private int contPoeple;
	
	//Relations
	
	private ArrayList<People> people;
	
	public MiniMarket() {
		
		contPoeple = 0;
		people = new ArrayList<>();
	}
	
	public String addPeople(Document document, String numberDocument) throws MinorException, PickAndCedulaException {
		
		String message = "";
		
		setContPoeple(getContPoeple()+1);
		
		if(document == Document.TI) {
			throw new MinorException();
		}
		else {
			
			int day = LocalDate.now().getDayOfMonth();
			
			int numberOfDocument = Integer.parseInt(numberDocument.substring(numberDocument.length()-2));
			
			if((day % 2 == 0 && numberOfDocument % 2 != 0) || (day % 2 != 0 && numberOfDocument % 2 == 0)) {
				people.add(new People(document,numberDocument));
				
				message = "La persona puede ingresar";
			}
			else {
				throw new PickAndCedulaException();
			}
		}
		
		return message;
	}

	public int getContPoeple() {
		return contPoeple;
	}

	public void setContPoeple(int contPoeple) {
		this.contPoeple = contPoeple;
	}

	public ArrayList<People> getPeople() {
		return people;
	}

	public void setPeople(ArrayList<People> people) {
		this.people = people;
	}
}
