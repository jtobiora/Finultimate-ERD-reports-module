package reporting.util;

public class CodeGenerator {
	public static ErrorMessage generateError(String message) {
        return new ErrorMessage(message);
    }

    public static ErrorMessage generateError(String message, Integer errorCode) {
        return new ErrorMessage(message, errorCode);
    }
}
