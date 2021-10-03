package br.com.saimon.exception;

public class FailFindBankClientException extends BankException{

	private static final long serialVersionUID = 1L;

	public FailFindBankClientException(String message) {
		super(message);
	}

}
