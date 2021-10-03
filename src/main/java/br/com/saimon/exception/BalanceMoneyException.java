package br.com.saimon.exception;

public class BalanceMoneyException extends BankException {

	private static final long serialVersionUID = 1L;

	public BalanceMoneyException(String message) {
		super(message);
	}
}
