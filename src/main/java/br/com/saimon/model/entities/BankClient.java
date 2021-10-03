package br.com.saimon.model.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bankclient")
public class BankClient {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String name;
	private String account;
	private String password;
	private double balance;
	private double check_limit;

	public BankClient() {

	}

	public BankClient(String name, String account, String password, double balance, double check_limit) {
		super();
		this.name = name;
		this.account = account;
		this.password = password;
		this.balance = balance;
		this.check_limit = check_limit;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public double getCheck_limit() {
		return check_limit;
	}

	public void setCheck_limit(double check_limit) {
		this.check_limit = check_limit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(account, balance, check_limit, id, name, password);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BankClient other = (BankClient) obj;
		return Objects.equals(account, other.account)
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Double.doubleToLongBits(check_limit) == Double.doubleToLongBits(other.check_limit) && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password);
	}

}
