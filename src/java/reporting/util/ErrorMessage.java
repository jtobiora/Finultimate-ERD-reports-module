package reporting.util;

import java.io.Serializable;

public class ErrorMessage implements Serializable {

	private String error;
	private Integer errorCode;

	public ErrorMessage(String error) {
		this.error = error;
	}

	public ErrorMessage(String error, Integer errorCode) {
		this(error);
		this.errorCode = errorCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Integer getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(Integer errorCode) {
		this.errorCode = errorCode;
	}

}
