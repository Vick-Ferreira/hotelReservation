package model.exceptions;

//extenção personalizada é DomainExeption /  que é uma extenção da classe Exception ou RuntimeException
//runtimeException = copilador não te obriga a tratar
//Exception = obriga a tratar igual parseException

public class DomainException extends Exception {
	private static final long serialVersionUID = 1L; // declaração de clase serial

	// contrutor
	public DomainException(String msg) {
		super(msg);
	}

}
