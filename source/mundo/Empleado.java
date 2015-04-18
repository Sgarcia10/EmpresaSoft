package mundo;

import java.util.ArrayList;
import java.util.Date;

public class Empleado extends Persona{

//TODO extends Persona
	
	private ArrayList<Hijo> hijos;
	
	private ArrayList <ReferenciaPersonal> referencias;
	
	private ArrayList <Experiencia> experiencia;
	
	private Contrato contrato;
	
	private String salud;
	
	private String pensiones;
	
	private String arl;
	
	private String solidaridad;
	
	private Date fechaAfiliacionSS;
		
	
	public Empleado(int identificacion, String tipoDocumento, String nombre, 
			String apellidos, String sexo, Date fechaNacimiento, String estadoCivil,
			String correo, int edad, int telefono, int celularP, String direccion, String ciudad,
			String departamento, String nacionalidad) 
	{
		super(identificacion, tipoDocumento, nombre, apellidos, sexo, fechaNacimiento,
				estadoCivil, correo, edad, telefono, celularP, direccion, ciudad, 
				departamento, nacionalidad);		
	}
	
	
	public void agregarReferencia(String nombre, String apellidos, int telefono,
			int identificacion, String sexo, String direccion, String ciudad, String departamento,
			String tipoP, String empresaP, String conceptoP) {
		
		ReferenciaPersonal nueva = new ReferenciaPersonal(nombre, apellidos, telefono,
				identificacion, sexo, direccion, ciudad, departamento,
				tipoP, empresaP, conceptoP);
		referencias.add(nueva);
	}
	
	public void eliminarReferencia(int index){
		referencias.remove(index);
	}
	
	public void agregarExperiencia(String cargoP, String empresaP, String tipoContratoP, Date fechaInicioP, Date fechaFinP){
		Experiencia nueva = new Experiencia(cargoP, empresaP, tipoContratoP, fechaInicioP, fechaFinP);
		experiencia.add(nueva);
	}
	
	public void eliminarExperiencia(int index){
		experiencia.remove(index);
	}
	
	protected void setContrato(String cargoP, int sueldoBasicoP, boolean auxilioTransporteP, int periodoLiquidacionP,
			Date fechaInicioP, String tipoContratoP, Date fechaFinP, String tipoSalarioP, int horasSemana)
	{
		contrato = new Contrato(cargoP, sueldoBasicoP, auxilioTransporteP, periodoLiquidacionP,
				fechaInicioP, tipoContratoP, fechaFinP, tipoSalarioP, horasSemana);
	}
	
	public Contrato getContrato()
	{
		return contrato;
	}

	public ArrayList getHijos() {
		return hijos;
	}


	protected void setHijos(ArrayList hijos) {
		this.hijos = hijos;
	}

	public String getSalud() {
		return salud;
	}


	protected void setSalud(String salud) {
		this.salud = salud;
	}


	public String getPensiones() {
		return pensiones;
	}


	protected void setPensiones(String pensiones) {
		this.pensiones = pensiones;
	}


	public String getArl() {
		return arl;
	}


	protected void setArl(String arl) {
		this.arl = arl;
	}


	public String getSolidaridad() {
		return solidaridad;
	}


	protected void setSolidaridad(String solidaridad) {
		this.solidaridad = solidaridad;
	}


	public Date getFechaAfiliacionSS() {
		return fechaAfiliacionSS;
	}


	protected void setFechaAfiliacionSS(Date fechaAfiliacionSS) {
		this.fechaAfiliacionSS = fechaAfiliacionSS;
	}


	public ArrayList getReferencias() {
		return referencias;
	}


	protected void setReferencias(ArrayList referenciasP) {
		this.referencias = referenciasP;
	}

	public ArrayList getExperiencia() {
		return experiencia;
	}

	protected void setExperiencia(ArrayList experiencia) {
		this.experiencia = experiencia;
	}
	

}
