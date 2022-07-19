package exceptions;

public class SeHaPasadoException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3449779212512184137L;

	public SeHaPasadoException() {
		
	}

	public SeHaPasadoException(String message) {
		super(message);
		
	}

	public SeHaPasadoException(Throwable cause) {
		super(cause);
	
	}

	public SeHaPasadoException(String message, Throwable cause) {
		super(message, cause);
	
	}

	public SeHaPasadoException(String message, Throwable cause, boolean enableSuppression, 
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		
	}

	
}
