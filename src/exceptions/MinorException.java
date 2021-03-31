package exceptions;

public class MinorException extends Exception{
	
	private static final long serialVersionUID = 1L;

	public MinorException() {
		super("The person is minor, for that he can't go in");
	}
}