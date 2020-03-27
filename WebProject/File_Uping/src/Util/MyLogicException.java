package Util;

public class MyLogicException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message 异常信息
	 * @param cause   异常原因
	 */
	public MyLogicException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 
	 * @param message 异常信息
	 */
	public MyLogicException(String message) {
		super(message);
	}

}
