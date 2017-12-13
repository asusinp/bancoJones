package beans;

import java.util.LinkedList;
import java.util.List;

public class Cliente {
	
	private String nombre;
	private String dni;
	private String apellidos;
	private String password;
	private String fechaNacimiento;
	private String sexo;
	private String direccion;
	private String telefono;
	private boolean isValid;
	private List<Account> accounts;
	
	public Cliente() {
		accounts = new LinkedList<>();
	}
	
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getFechaNacimiento() {
		return fechaNacimiento;
	}
	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public List<Account> getAccounts() {
		return accounts;
	}
	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}	
	public boolean isValid() {
		return isValid;
	}
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getDni() {
		return dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", dni=" + dni + ", apellidos=" + apellidos + ", contraseña=" + password
				+ ", fechaNacimiento=" + fechaNacimiento + ", sexo=" + sexo + ", direccion=" + direccion + ", telefono="
				+ telefono + ", isValid=" + isValid + "]";
	}
	
	
	
}
