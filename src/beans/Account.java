/**
 * 
 */
package beans;

/**
 * @author iaw21752927
 *
 */
public class Account {
	public String iban;
	public Cliente cliente;
	public String propietario;
	public double balance;

	public Account(String iban, String propietario, double balance) {
		super();
		this.iban = iban;
		this.propietario = propietario;
		this.balance = balance;
	}
	
	public Account(String iban, Cliente cliente, double balance) {
		super();
		this.iban = iban;
		this.cliente = cliente;
		this.balance = balance;
	}



	public Cliente getCliente() {
		return cliente;
	}

	public String getIban() {
		return iban;
	}

	public String getPropietario() {
		return propietario;
	}

	public void setIban(String iban) {
		this.iban = iban;
	}

	public void setPropietario(String propietario) {
		this.propietario = propietario;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	@Override
	public String toString() {
		return "Account [iban=" + iban + ", propietario=" + propietario + ", balance=" + balance + "]";
	}

	

}
