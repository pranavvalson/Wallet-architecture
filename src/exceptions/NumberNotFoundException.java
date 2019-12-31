package exceptions;

public class NumberNotFoundException extends RuntimeException {
	public NumberNotFoundException(String msg) {
		super(msg);
	}
}
