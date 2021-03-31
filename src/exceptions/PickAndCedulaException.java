package exceptions;

public class PickAndCedulaException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public PickAndCedulaException() {
		super("The person can't go in, in this day");
	}
}
