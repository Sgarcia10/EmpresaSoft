package interfaz;

import java.util.ArrayList;
import java.util.Date;

import mundo.Empleado;
import mundo.Empresa;
import mundo.IEmpresa;

public class Control {
	
	private IEmpresa empresa;
	
	public Control() 
	{
		empresa = new Empresa( );
	}

	public boolean validacionUsuario(String usuarioP, String contraseniaP) 
	{
		return empresa.validacionUsuario(usuarioP, contraseniaP);
	}
	
	public void crearNuevoEmpleado(int identificacion, String tipoDocumento, String nombre, 
			String apellidos, String sexo, Date fechaNacimiento, String estadoCivil,
			String correo, int edad, int telefono, int celularP, String direccion, String ciudad,
			String departamento, String nacionalidad) 
	{
		empresa.crearEmpleadoNuevo(identificacion, tipoDocumento, nombre, apellidos, sexo, 
				fechaNacimiento, estadoCivil, correo, edad, telefono, celularP, direccion, 
				ciudad, departamento, nacionalidad);
	}
	
	public void agregarReferenciaEmpleadoNuevo(String nombresP, String apellidosP, int telefonoP, 
			int documentoP, String sexoP, String direccionP, String ciudadP, String departamentoP, String tipoP, 
			String empresaP, String conceptoP){
		
		Empleado e = empresa.getEmpleadoNuevo();
		empresa.agregarReferenciaEmpleado(e, nombresP, apellidosP, telefonoP, documentoP, sexoP, direccionP, ciudadP, departamentoP, tipoP, empresaP, conceptoP);
	}
	
	public void agregarExperienciaEmpleadoNuevo(String cargoP, String empresaP, String tipoContratoP, Date fechaInicioP, Date fechaFinP){

		Empleado e = empresa.getEmpleadoNuevo();
		empresa.agregarExperienciaEmpleado(e, cargoP, empresaP, tipoContratoP, fechaInicioP, fechaFinP);
	}
	
	public void eliminarReferenciaEmpleadoNuevo(int index){
		Empleado e = empresa.getEmpleadoNuevo();
		empresa.eliminarReferenciaEmpleado(e, index);
	}
	
	public void eliminarExperienciaEmpleadoNuevo(int index){
		Empleado e = empresa.getEmpleadoNuevo();
		empresa.eliminarExperienciaEmpleado(e, index);
	}
	
	public ArrayList darListaReferecnias(){
		return empresa.getEmpleadoNuevo().getReferencias();
	}
	
	public ArrayList darListaExperiencia(){
		return empresa.getEmpleadoNuevo().getExperiencia();
	}
	
	public Empleado getEmpleado(){
		return empresa.getEmpleadoNuevo();
	}
	
//	public String getPeriodoNomina() {
//		// TODO Auto-generated method stub
//		String rta = mundo.getEmpleadoActual( ).getSueldoBasico( ); 
//		return rta;
//	}
//
//	public double getSueldoBasico() {
//		// TODO Auto-generated method stub
//		double rta = mundo.getEmpleadoActual( ).getSueldoBasico( );
//		return rta;
//	}
//
//	public int getTiempo() {
//		// TODO Auto-generated method stub
//		int rta = mundo.getEmpleadoActual().getTiempoLaboradoPeriodo( );
//		return rta;
//	}
//
//	public double getSueldoPeriodo() {
//		// TODO Auto-generated method stub
////		double rta = mundo.getEmpleadoActual( ).getSueldoPeriodo( );
//		return 1;
//	}
//	
	//CESAR
	public double getNovedadesSueldoBasico(String periodo) {
		// TODO Auto-generated method stub
//		double rta = mundo.getEmpleadoActual( ).getSueldoBasico( );
		return 1;
	}

	public int getNovedadesTiempoPeriodo(String periodo) {
		// TODO Auto-generated method stub
//		int rta = mundo.getEmpleadoActual().getTiempoLaboradoPeriodo( );
		return 1;
	}

	public double getNovedadesSueldoPeriodo(String periodo) {
		// TODO Auto-generated method stub
//		double rta = mundo.getEmpleadoActual( ).getSueldoPeriodo( );
		return 1;
	}



	public double getDevengadoOrdinarioTotalRecargoNocturno(String periodo) {
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDevengadoOrdinarioTotalExtraDiurno(String periodo) {
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDevengadoOrdinarioTotalExtraNocturno(String periodo) {
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDevengadoDominicalTotalRecargoNocturno(String periodo) {
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDevengadoDominicalTotalExtraDiurno(String periodo) {
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDevengadoDominicalTotalExtraNocturno(String periodo) {
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDevengadoDominicalTotalDominicalesFestivos(String periodo) {
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDevengadoOtrosTotalAuxilioTransporte(String periodo) {
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDevengadoOtrosTotalComisiones(String periodo) {
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDeduccionesSeguridadSocialTotalSalud(String periodo) {
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDeduccionesSeguridadSocialTotalPension(String periodo) {
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDeduccionesSeguridadSocialTotalPensionVoluntaria(
			String periodo) {
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDeduccionesSeguridadSocialTotalSolidaridad(String periodo) {
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDeduccionesSeguridadSocialTotalAFC(String periodo) {
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDeduccionesOtrasTotalRetencion(String periodo) {
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDeduccionesOtrasTotalJuzgados(String periodo) {
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDeduccionesOtrasTotalPrestamos(String periodo) {
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDeduccionesOtrosTotalFondosEmpleados(String periodo) {
		// TODO Auto-generated method stub
		return 0;
	}



	public ArrayList getListaDiasNoLaborados() {
		// TODO Auto-generated method stub
		ArrayList rta = new ArrayList( );
		return rta;
	}



	public ArrayList getListaOrdinariaExtraDiurno() {
		// TODO Auto-generated method stub
		ArrayList rta = new ArrayList( );
		return rta;
	}



	public ArrayList getListaOrdinariaExtraNocturno() {
		// TODO Auto-generated method stub
		ArrayList rta = new ArrayList( );
		return rta;
	}



	public ArrayList getListaDominicalExtraDiurno() {
		// TODO Auto-generated method stub
		ArrayList rta = new ArrayList( );
		return rta;
	}
	
}
