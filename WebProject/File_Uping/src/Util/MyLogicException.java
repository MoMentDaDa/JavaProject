package Util;

public class MyLogicException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 * @param message �쳣��Ϣ
	 * @param cause   �쳣ԭ��
	 */
	public MyLogicException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * 
	 * @param message �쳣��Ϣ
	 */
	public MyLogicException(String message) {
		super(message);
	}

}
