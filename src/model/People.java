package model;

public class People {
	
	//Attribute
	
	private Document document;
	private String numberDocument;
	
	People(Document document, String numberDocument){
		
		this.document = document;
		this.numberDocument = numberDocument;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}

	public String getNumberDocument() {
		return numberDocument;
	}

	public void setNumberDocument(String numberDocument) {
		this.numberDocument = numberDocument;
	}
}
