package interfaz;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;

import mundo.Empleado;
import mundo.Empresa;
import mundo.IEmpresa;

public class Control {
	
	private IEmpresa empresa;
	
	public Control() throws Exception
	{
		empresa = new Empresa( );
		
		empresa.cargarEstado(Empresa.RUTA_ARCHIVO_PERSISTENCIA);
	}

	public void agregarEmpleado(){
		
		empresa.agregarEmpleado();
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
	
	public void agregarConyugueEmpleadoNuevo(String nombresParejaP, String apellidosParejaP, double cedulaParejaP,
			double telefonoParejaP, Date fechaNacimientoParejaP, String sexoParejaP,
			String direccionParejaP, String ciudadParejaP){
		
		Empleado e = empresa.getEmpleadoNuevo();
		empresa.agregarConyugueEmpleado(e, nombresParejaP, apellidosParejaP, cedulaParejaP, telefonoParejaP, fechaNacimientoParejaP, sexoParejaP, direccionParejaP, ciudadParejaP);
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
	
	public void agregarHijoEmpleadoNuevo(String nombreP,String apellidosP,int telefonoP,int identificacionP, String sexoP,
			String direccionP, String ciudadP, String departamentoP, String tipoDocumentoP, Date fechaNacimientoP)
	{
		
		Empleado e = empresa.getEmpleadoNuevo();
		empresa.agregarHijos(e, nombreP, apellidosP, telefonoP, identificacionP, sexoP, direccionP, ciudadP, departamentoP, tipoDocumentoP, fechaNacimientoP);

	}
	
	public void eliminarReferenciaEmpleadoNuevo(int index){
		Empleado e = empresa.getEmpleadoNuevo();
		empresa.eliminarReferenciaEmpleado(e, index);
	}
	
	public void eliminarExperienciaEmpleadoNuevo(int index){
		Empleado e = empresa.getEmpleadoNuevo();
		empresa.eliminarExperienciaEmpleado(e, index);
	}
	
	public void eliminarHijoEmpleadoNuevo(int index){
		Empleado e = empresa.getEmpleadoNuevo();
		empresa.eliminarHijoEmpleado(e, index);
	}
	
	public void editarReferenciaEmpleadoNuevo(int posicion, String tipoP,
			String nombresP, String apellidosP, int documentoP,
			int telefonoP,String sexoP, String direccionP,
			String ciudadP,String empresaP,String conceptoP){
		
		Empleado e = empresa.getEmpleadoNuevo();
		empresa.editarReferenciaEmpleado(e,posicion, tipoP,
				nombresP, apellidosP,documentoP,telefonoP,sexoP,
				direccionP,	ciudadP,empresaP,conceptoP);		
	}
	
	public void editarExperienciaEmpleadoNuevo( int index, String empresaP, 
			String cargoP, String tipoP, Date fechaInicioP, Date fechaFinP){
		
		Empleado e = empresa.getEmpleadoNuevo();
		empresa.editarExperienciaEmpleado(e, index, empresaP, cargoP, tipoP, fechaInicioP, fechaFinP);
		
	}
	
	public void editarHijoEmpleadoNuevo(int index, String nombreP, String apellidosP, String tipoP,
			int identificacionP, String sexoP, Date fechaP, String direccionP){
		
		Empleado e = empresa.getEmpleadoNuevo();
		empresa.editarHijoEmpleado(e, index, nombreP, apellidosP, tipoP, identificacionP, sexoP, fechaP, direccionP);
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
	
	public ArrayList getEmpleados(){
		return empresa.getEmpleados();
	}
	
	public ArrayList darListaReferecniasEmpleadoNuevo(){
		return empresa.getEmpleadoNuevo().getReferencias();
	}
	
	public ArrayList darListaExperienciaEmpleadoNuevo(){
		return empresa.getEmpleadoNuevo().getExperiencia();
	}
	
	public ArrayList darListaHijosEmpleadoNuevo(){
		return empresa.getEmpleadoNuevo().getHijos();
	}
	
	public ArrayList darListaEmpleados(){
		return empresa.getEmpleados();
	}
	
	public Empresa getEmpresa(){
		return (Empresa) empresa;
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

	public ArrayList getListaDominicalExtraNocturno() {
		// TODO Auto-generated method stub
		ArrayList rta = new ArrayList( );
		return rta;
	}

	public ArrayList getListaDominicalDiasDominicalesYFestivos() {
		// TODO Auto-generated method stub
		ArrayList rta = new ArrayList( );
		return rta;
	}

	public ArrayList getListaDeduccionesPrestamos() {
		// TODO Auto-generated method stub
		ArrayList rta = new ArrayList( );
		return rta;
	}
	
	public void agregarInfoLaboralEmpleadoNuevo(String cargoP,
			int salarioFijoP, int horasP, String tipoP, String duracionP,
			Date fechaInicioP, Date fechaFinP, int tipoLiquidacionP, String saludP,
			String pensionesP, String arlP, boolean solidaridadP, String cajaCompensacionP,
			Date fechaAfiliacionP, boolean auxilioP) {
		
		Empleado e = empresa.getEmpleadoNuevo();
		empresa.agregarInfoLaboralEmpleado( e, cargoP, salarioFijoP,  
				horasP,  tipoP,  duracionP, fechaInicioP,  fechaFinP,  
				tipoLiquidacionP,  saludP, pensionesP,  arlP,  solidaridadP,  
				cajaCompensacionP, fechaAfiliacionP, auxilioP); 
		
	}
	
	public void agregarInfoPersonalEmpleadoNuevo(String nombreP,String apellidosP,
			String tipoP, int documentoP, String sexoP, String estadoCivilP, 
			Date fechaP, String direccionP, String ciudadP, int telefonoP,int celularP,
			ImageIcon fotoP)
	{
		Empleado e = empresa.getEmpleadoNuevo();
		empresa.agregarInfoPersonalEmpleado( e,  nombreP, apellidosP,
				 tipoP,  documentoP,  sexoP,  estadoCivilP, 
				 fechaP,  direccionP,  ciudadP,  telefonoP, celularP,fotoP);
	}
	
}
