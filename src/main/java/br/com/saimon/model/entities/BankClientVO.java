package br.com.saimon.model.entities;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
@Table(name = "bankclient")
@JsonPropertyOrder({"id", "account"})
public class BankClientVO implements Serializable {

	private static final long serialVersionID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name="first_name", nullable=false, length = 80)
	private String name;

	@Column(name="account", nullable = false, length = 80)
	private String account;
	@Column(name = "password",nullable = false, length = 100)
	private String password;

	private double balance;
	private double check_limit;

	public BankClientVO() {

	}

	public BankClientVO(String name, String account, String password, double balance, double check_limit) {
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
		BankClientVO other = (BankClientVO) obj;
		return Objects.equals(account, other.account)
				&& Double.doubleToLongBits(balance) == Double.doubleToLongBits(other.balance)
				&& Double.doubleToLongBits(check_limit) == Double.doubleToLongBits(other.check_limit) && id == other.id
				&& Objects.equals(name, other.name) && Objects.equals(password, other.password);
	}

}
