

public class CreditException extends Exception{
	
	// Parameterless Constructor
		public CreditException() {
		}

		// Constructor that accepts a message
		public CreditException(String message) {
			super(message);
		}

		// Constructor that accepts a message
		public CreditException(String message, Exception e) {
			super(message, e);

}
}
