import java.io.Serializable;

/**
 * Custom exception thrown when there are errors during data initialization
 */
public class InputException extends Exception implements Serializable {
    private static final long serialVersionUID = 1L;

    public InputException(String message) {
        super(message);
    }

    public InputException(String message, Throwable cause) {
        super(message, cause);
    }
}