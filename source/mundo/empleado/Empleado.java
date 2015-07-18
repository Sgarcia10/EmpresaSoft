package mundo.empleado;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;

import javax.swing.ImageIcon;

import Excepciones.NominaExistenteException;
import mundo.Contrato;
import mundo.nomina.Cesantias;
import mundo.nomina.Nomina;
import mundo.nomina.Prestamo;
import mundo.nomina.Prima;

public class Empleado extends Persona implements Serializable{

	private final static long serialVersionUID = 200L;
	
	private ArrayList<Hijo> hijos;
	
	private ArrayList <Referencia> referencias;
	
	private LinkedList <Nomina> nominas;	
	
	private ArrayList<Prestamo> prestamos;

	private ArrayList <Experiencia> experiencia;
		
	private ImageIcon foto;
	
	private Contrato contrato;
	
	private String salud;
	
	private String pensiones;
	
	private String arl;
	
	private String cajaCompensacion;
	
	private boolean solidaridad;
	
	private Date fechaAfiliacionSS;
	
	private Conyuge conyugue;
		
	private Prima prima;
	
	private Cesantias cesantias;
	
	
	public Empleado(double identificacion, String tipoDocumento, String nombre, 
			String apellidos, String sexo, Date fechaNacimiento, String estadoCivil,
			String correo, int edad, double telefono, double celularP, String direccion, String ciudad,
			String departamento, String nacionalidad) 
	{
		super(identificacion, tipoDocumento, nombre, apellidos, sexo, fechaNacimiento,
				estadoCivil, correo, edad, telefono, celularP, direccion, ciudad, 
				departamento, nacionalidad);
		nominas = new LinkedList<Nomina>();
		
		hijos = new ArrayList();
		referencias = new ArrayList();
		experiencia = new ArrayList();
	
		prestamos = new ArrayList<Prestamo>();
		foto = null;

	}
	
	public void agregarConyugue( String nombresParejaP, String apellidosParejaP, double cedulaParejaP,
			double telefonoParejaP, Date fechaNacimientoParejaP, String sexoParejaP,
			String direccionParejaP, String ciudadParejaP){
		
		conyugue = new Conyuge(nombresParejaP, apellidosParejaP, cedulaParejaP, telefonoParejaP, fechaNacimientoParejaP, sexoParejaP, direccionParejaP, ciudadParejaP);
	}
	
	public void agregarReferencia(String nombre, String apellidos, double telefono,
			double identificacion, String sexo, String direccion, String ciudad, String departamento,
			String tipoP, String empresaP, String conceptoP) {
		
		Referencia nueva = new Referencia(nombre, apellidos, telefono,
				identificacion, sexo, direccion, ciudad, departamento,
				tipoP, empresaP, conceptoP);
		referencias.add(nueva);
	}
	
	public void eliminarReferencia(int index){
		referencias.remove(index);
	}
	
	public void editarReferencia(int posicion, String tipoP, String nombresP,
			String apellidosP, double documentoP, double telefonoP, String sexoP,
			String direccionP, String ciudadP, String empresaP, String conceptoP) {
		
		// TODO Auto-generated method stub
		Referencia ref = referencias.get(posicion);
		
		ref.setTipo(tipoP);
		ref.setNombres(nombresP);
		ref.setApellidos(apellidosP);
		ref.setIdentificacion(documentoP);
		ref.setTelefono(telefonoP);
		ref.setSexo(sexoP);
		ref.setDireccion(direccionP);
		ref.setCiudad(ciudadP);
		ref.setEmpresa(empresaP);
		ref.setConcepto(conceptoP);
	}
	
	public void agregarExperiencia(String cargoP, String empresaP, String tipoContratoP, Date fechaInicioP, Date fechaFinP){
		Experiencia nueva = new Experiencia(cargoP, empresaP, tipoContratoP, fechaInicioP, fechaFinP);
		experiencia.add(nueva);
	}
	
	public void eliminarExperiencia(int index){
		experiencia.remove(index);
	}
	
	public void editarExperiencia(int index, String empresaP, String cargoP, String tipoP, Date fechaInicioP, Date fechaFinP){
		
		Experiencia exp = experiencia.get(index);
		
		exp.setEmpresa(empresaP);
		exp.setCargo(cargoP);
		exp.setTipoContrato(tipoP);
		exp.setFechaInicio(fechaInicioP);
		exp.setFechaFin(fechaFinP);
	}
	
	public void agregarHijo(String nombreP,String apellidosP,double telefonoP,double identificacionP, String sexoP,
			String direccionP, String ciudadP, String departamentoP, String tipoDocumentoP, Date fechaNacimientoP)
	{
		Hijo nuevo = new Hijo(nombreP, apellidosP, telefonoP, identificacionP, sexoP,
				direccionP, ciudadP, departamentoP, tipoDocumentoP, fechaNacimientoP);
		hijos.add(nuevo);
	}
	
	public void eliminarHijo(int index){
		hijos.remove(index);
	}
	
	public void agregarContrato(String cargoP,
			double salarioFijoP, int horasP, String tipoP, String duracionP,
			Date fechaInicioP, Date fechaFinP, int tipoLiquidacionP, boolean auxilioP)
	{
		Contrato contratoNuevo = new Contrato(cargoP, salarioFijoP, auxilioP,
				tipoLiquidacionP, fechaInicioP, tipoP, fechaFinP, duracionP, horasP);
		
		contrato = contratoNuevo;
		prima = new Prima(0, fechaInicioP);
		cesantias = new Cesantias(0, fechaInicioP);
	}
	
	public void editarHijo(int index, String nombreP, String apellidosP, String tipoP,
			double identificacionP, String sexoP, Date fechaP, String direccionP){
		
		Hijo hij = hijos.get(index);
		
		hij.setNombres(nombreP);
		hij.setApellidos(apellidosP);
		hij.setTipoDocumento(tipoP);
		hij.setIdentificacion(identificacionP);
		hij.setSexo(sexoP);
		hij.setFechaNacimiento(fechaP);
		hij.setDireccion(direccionP);
	}
	
	public double calcularSueldoVariable(){
		return contrato.getSueldoBasico();
	}
	
	
	public void setContrato(String cargoP, int sueldoBasicoP, boolean auxilioTransporteP, int periodoLiquidacionP,
			Date fechaInicioP, String tipoContratoP, Date fechaFinP, String tipoSalarioP, int horasSemana)
	{
		contrato = new Contrato(cargoP, sueldoBasicoP, auxilioTransporteP, periodoLiquidacionP,
				fechaInicioP, tipoContratoP, fechaFinP, tipoSalarioP, horasSemana);
	}
	
	public Nomina buscarNominaPeriodo(String periodo)
	{
		for(int i=0; i<nominas.size(); i++)
		{
			if(periodo.equals(nominas.get(i).getPeriodo()))
			{
				return nominas.get(i);
			}
		}
		return null;
	}
	
	public Nomina agregarNomina(String periodo) throws NominaExistenteException
	{
		if(buscarNominaPeriodo(periodo)==null){
			Nomina n = new Nomina(this, periodo);
			nominas.addFirst(n);
			return n;
		}
		else
			throw new NominaExistenteException("Ya esta creada la última nomina");
	}
	
	public Contrato getContrato()
	{
		return contrato;
	}

	public ArrayList getHijos() {
		return hijos;
	}


	public void setHijos(ArrayList hijos) {
		this.hijos = hijos;
	}
	
	public Conyuge getConyugue() {
		return conyugue;
	}


	public void setConyugue(Conyuge conyugueP) {
		conyugue = conyugueP;
	}

	public String getSalud() {
		return salud;
	}


	public void setSalud(String salud) {
		this.salud = salud;
	}


	public String getPensiones() {
		return pensiones;
	}


	public void setPensiones(String pensiones) {
		this.pensiones = pensiones;
	}


	public String getArl() {
		return arl;
	}


	public void setArl(String arl) {
		this.arl = arl;
	}


	public boolean getSolidaridad() {
		return solidaridad;
	}


	public void setSolidaridad(boolean solidaridad) {
		this.solidaridad = solidaridad;
	}


	public Date getFechaAfiliacionSS() {
		return fechaAfiliacionSS;
	}


	public void setFechaAfiliacionSS(Date fechaAfiliacionSS) {
		this.fechaAfiliacionSS = fechaAfiliacionSS;
	}


	public ArrayList getReferencias() {
		return referencias;
	}

	public void setReferencias(ArrayList referenciasP) {
		this.referencias = referenciasP;
	}

	public ArrayList getExperiencia() {
		return experiencia;
	}

	public void setExperiencia(ArrayList experiencia) {
		this.experiencia = experiencia;
	}
	
	public String getCajaCompensacion(){
		return cajaCompensacion;
	}
	
	public void setCajaCompensacion(String cajaCompensacionP){
		this.cajaCompensacion = cajaCompensacionP;
	}
	
	public ImageIcon getFoto() {
		return foto;
	}

	public void setFoto(ImageIcon foto) {
		this.foto = foto;
	}	

	public ArrayList<Prestamo> getPrestamos()
	{
		return prestamos;
	}	

	public LinkedList<Nomina> getNominas() {
		return nominas;
	}

	public void setNominas(LinkedList<Nomina> nominas) {
		this.nominas = nominas;
	}

	public String toString()
	{
		return getApellidos() + " " + getNombres();
	}

	public void calcularPrima(double pTotal) {
		prima.calcularAcumulado(pTotal);
	}
	
	public void calcularCesantias(double pTotal) {
		cesantias.calcularAcumulado(pTotal);
	}
		
	public void liquidarPrima(String pPeriodo){
		Nomina actual = buscarNominaPeriodo(pPeriodo);
		actual.setPrima(prima.getValor());
	}
	
	public void liquidarCesantias(String pPeriodo){
		Nomina actual = buscarNominaPeriodo(pPeriodo);
		actual.setCesantias(cesantias.getValor());
	}
	
	public double darTotalPrima(String periodo){
		Nomina actual = buscarNominaPeriodo(periodo);
		return actual.getPrima();
	}
	
	public double darTotalCesantias(String periodo){
		Nomina actual = buscarNominaPeriodo(periodo);
		return actual.getCesantias();
	}
}
