package beans;

public class Transaccion {
	
	private long id;
	private String date;
	private double amount;
	private String origin;
	private String destination;
	
	
	public Transaccion(long id, String date, double amount, String origin, String destination) {
		super();
		this.id = id;
		this.date = date;
		this.amount = amount;
		this.origin = origin;
		this.destination = destination;
	}


	public long getId() {
		return id;
	}


	public String getDate() {
		return date;
	}


	public double getAmount() {
		return amount;
	}


	public String getOrigin() {
		return origin;
	}


	public String getDestination() {
		return destination;
	}


	public void setId(long id) {
		this.id = id;
	}


	public void setDate(String date) {
		this.date = date;
	}


	public void setAmount(double amount) {
		this.amount = amount;
	}


	public void setOrigin(String origin) {
		this.origin = origin;
	}


	public void setDestination(String destination) {
		this.destination = destination;
	}
	
	
	
}
