package reporting.wrapper;

import java.io.Serializable;

/**
 * Created by israel on 5/2/17.
 */
public class ErrorMessage implements Serializable {
    private String error;
    private Integer error_code;

    public ErrorMessage(String error) {
        this.error = error;
    }

    public ErrorMessage(String error, Integer error_code) {
        this(error);
        this.error_code = error_code;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getError_code() {
        return error_code;
    }

    public void setError_code(Integer error_code) {
        this.error_code = error_code;
    }
}
