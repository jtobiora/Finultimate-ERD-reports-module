package reporting.wrapper;

import reporting.wrapper.ErrorMessage;

/**
 * Created by israel on 3/15/17.
 */
public class CodeGenerator {
    public static ErrorMessage generateError(String message) {
        return new ErrorMessage(message);
    }

    public static ErrorMessage generateError(String message, Integer error_code) {
        return new ErrorMessage(message, error_code);
    }

    public static void main(String[] args){
        Byte a = 127;
        Byte b = 127;
        Byte c = (byte)(a+b);

        System.out.println(c);
    }
}
