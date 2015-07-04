package mundo.empleado;

import java.io.Serializable;
import java.util.Date;

public abstract class Persona implements Serializable{
	

	
	public final static String HOMBRE = "Hombre";
	public final static String MUJER = "Mujer";
	
	public final static String CEDULA = "Cédula de Ciudadanía";
	public final static String TARJETA = "Tarjeta de Identidad";
	
	
	private String nombres;
	
	private String apellidos;
	
	private double telefono;
	
	private String tipoDocumento;
	
	private double identificacion;
	
	private String sexo;
	
	private String direccion;
	
	private String ciudad;
	
	private double celular;
	
	private Date fechaNacimiento;
	
	private String estadoCivil;
	
	private String correo;

	private int edad;
	
	private String departamento;
	
	private String nacionalidad;
	

	public Persona(double identificacion, String tipoDocumento, String nombre, 
			String apellidos, String sexo, Date fechaNacimiento, String estadoCivil,
			String correo, int edad, double telefono, double celularP, String direccion, String ciudad,
			String departamento, String nacionalidad) 
	{
		this.identificacion = identificacion;
		this.tipoDocumento = tipoDocumento;
		this.nombres = nombre;
		this.apellidos = apellidos;
		this.sexo = sexo;
		this.fechaNacimiento = fechaNacimiento;
		this.estadoCivil = estadoCivil;
		this.correo = correo;
		this.edad = edad;
		this.telefono = telefono;
		this.celular = celularP;
		this.direccion = direccion;
		this.ciudad = ciudad;
		this.departamento = departamento;
		this.nacionalidad = nacionalidad;
	}


	public String getNombres() {
		return nombres;
	}


	public String getApellidos() {
		return apellidos;
	}


	public double getTelefono() {
		return telefono;
	}


	public String getTipoDocumento() {
		return tipoDocumento;
	}


	public double getIdentificacion() {
		return identificacion;
	}


	public String getSexo() {
		return sexo;
	}


	public String getDireccion() {
		return direccion;
	}


	public String getCiudad() {
		return ciudad;
	}


	public double getCelular() {
		return celular;
	}


	public Date getFechaNacimiento() {
		return fechaNacimiento;
	}


	public String getEstadoCivil() {
		return estadoCivil;
	}


	public String getCorreo() {
		return correo;
	}


	public int getEdad() {
		return edad;
	}


	public String getDepartamento() {
		return departamento;
	}


	public String getNacionalidad() {
		return nacionalidad;
	}


	public void setNombres(String nombres) {
		this.nombres = nombres;
	}


	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}


	public void setTelefono(double telefono) {
		this.telefono = telefono;
	}


	public void setTipoDocumento(String tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}


	public void setIdentificacion(double identificacion) {
		this.identificacion = identificacion;
	}


	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}


	public void setCelular(double celular) {
		this.celular = celular;
	}


	public void setFechaNacimiento(Date fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}


	public void setEstadoCivil(String estadoCivil) {
		this.estadoCivil = estadoCivil;
	}


	public void setCorreo(String correo) {
		this.correo = correo;
	}


	public void setEdad(int edad) {
		this.edad = edad;
	}


	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}


	public void setNacionalidad(String nacionalidad) {
		this.nacionalidad = nacionalidad;
	}


	@Override
	public String toString() {
		return nombres +" "+ apellidos;
	}
	
	
}
