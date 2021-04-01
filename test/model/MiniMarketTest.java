package model;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import exceptions.MinorException;
import exceptions.PickAndCedulaException;

public class MiniMarketTest {
	
	private MiniMarket market;
	
	public void setupScenary1() {
		market = new MiniMarket();
	}
	
	public void setupScenary2() {
		market = new MiniMarket();
	}
	
	public void setupScenary3() {
		market = new MiniMarket();
	}

	@Test
	public void testAddPeople() throws MinorException, PickAndCedulaException {
		
		setupScenary1();
		
		Document document = Document.CC;
		String documentNumber = "1006016025";
		
		int day = LocalDate.now().getDayOfMonth();
		
		if(day % 2 != 0) {
			documentNumber = "1006016022";
		}
		
		market.addPeople(document, documentNumber);
		
		ArrayList<People> people = market.getPeople();
		
		assertEquals(1, people.size());
		
		People peopleTest = people.get(0);
		assertEquals(document, peopleTest.getDocument());
		assertEquals(documentNumber, peopleTest.getNumberDocument());
	}
	
	@Test
	public void testAddPeople2() throws MinorException, PickAndCedulaException {
		
		setupScenary2();
		
		Document document = Document.TI;
		String documentNumberImpar = "1193573597";
		String documentNumberPar = "1193573592";
		
		int day = LocalDate.now().getDayOfMonth();
		
		if(day % 2 != 0) {
			assertThrows(MinorException.class, () -> market.addPeople(document, documentNumberPar));
		}
		else {
			assertThrows(MinorException.class, () -> market.addPeople(document, documentNumberImpar));
		}

		ArrayList<People> people = market.getPeople();
		
		assertEquals(0, people.size());
	}
	
	@Test
	public void testAddPeople3() throws MinorException, PickAndCedulaException {
		
		setupScenary3();
		
		Document document = Document.CE;
		String documentNumberImpar = "11931536897";
		String documentNumberPar = "11931536892";
		
		int day = LocalDate.now().getDayOfMonth();
		
		if(day % 2 == 0) {
			assertThrows(PickAndCedulaException.class, () -> market.addPeople(document, documentNumberPar));
		}
		else {
			assertThrows(PickAndCedulaException.class, () -> market.addPeople(document, documentNumberImpar));
		}
		
		ArrayList<People> people = market.getPeople();
		
		assertEquals(0, people.size());
	}
}