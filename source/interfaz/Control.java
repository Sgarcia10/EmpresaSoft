package interfaz;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;

import Excepciones.NoExisteEmpleadoException;
import Excepciones.NominaNoEncontradaException;
import mundo.Empresa;
import mundo.IEmpresa;
import mundo.empleado.Empleado;
import mundo.nomina.DiasNoLaborados;
import mundo.nomina.Nomina;

public class Control {
	
	private IEmpresa empresa;
	
	public Control() throws Exception
	{
		empresa = new Empresa( );
		
		empresa.cargarEstadoEmpleados(Empresa.RUTA_ARCHIVO_PERSISTENCIA);
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
		
		empresa.agregarConyugueEmpleado(empresa.getEmpleadoNuevo(), nombresParejaP, apellidosParejaP, cedulaParejaP, telefonoParejaP, fechaNacimientoParejaP, sexoParejaP, direccionParejaP, ciudadParejaP);
	}
	
	public void agregarReferenciaEmpleadoNuevo(String nombresP, String apellidosP, double telefonoP, 
			double documentoP, String sexoP, String direccionP, String ciudadP, String departamentoP, String tipoP, 
			String empresaP, String conceptoP){
		
		Empleado e = empresa.getEmpleadoNuevo();
		empresa.agregarReferenciaEmpleado(e, nombresP, apellidosP, telefonoP, documentoP, sexoP, direccionP, ciudadP, departamentoP, tipoP, empresaP, conceptoP);
	}
	
	public void agregarExperienciaEmpleadoNuevo(String cargoP, String empresaP, String tipoContratoP, Date fechaInicioP, Date fechaFinP){

		Empleado e = empresa.getEmpleadoNuevo();
		empresa.agregarExperienciaEmpleado(e, cargoP, empresaP, tipoContratoP, fechaInicioP, fechaFinP);
	}
	
	public void agregarHijoEmpleadoNuevo(String nombreP,String apellidosP,double telefonoP,double identificacionP, String sexoP,
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
			String nombresP, String apellidosP, double documentoP,
			double telefonoP,String sexoP, String direccionP,
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
			double identificacionP, String sexoP, Date fechaP, String direccionP){
		
		Empleado e = empresa.getEmpleadoNuevo();
		empresa.editarHijoEmpleado(e, index, nombreP, apellidosP, tipoP, identificacionP, sexoP, fechaP, direccionP);
	}
	
	
	public ArrayList darListaReferecnias(){
		return empresa.getEmpleadoNuevo().getReferencias();
	}
	
	public ArrayList darListaExperiencia(){
		return empresa.getEmpleadoNuevo().getExperiencia();
	}
	
	public ArrayList getEmpleados(){
		return empresa.getEmpleados();
	}
	
	public Empleado seleccionarEmpleadoIdentificacion(String id)
	{
		String [] idlist = id.split(".");
		String idp = "";
		for(int i=0; i<idlist.length; i++)
		{
			idp+=idlist[i];
			System.out.println(idlist[i]);
		}
		double identificacion = Double.parseDouble(id);
		Empleado e = empresa.buscarEmpleadoIdentificacion(identificacion);
		empresa.seleccionarEmpleado(e);
		return e;
	}
	
	
	public ArrayList darListaReferecniasEmpleadoNuevo(){
		return empresa.getEmpleadoNuevo().getReferencias();
	}
	
	public ArrayList darListaReferecniasEmpleado(){
		return empresa.getEmpleadoSeleccionado().getReferencias();
	}
	
	public ArrayList darListaExperienciaEmpleadoNuevo(){
		return empresa.getEmpleadoNuevo().getExperiencia();
	}
	
	public ArrayList darListaExperienciaEmpleado(){
		return empresa.getEmpleadoSeleccionado().getExperiencia();
	}
	
	public ArrayList darListaHijosEmpleadoNuevo(){
		return empresa.getEmpleadoNuevo().getHijos();
	}
	
	public ArrayList darListaHijosEmpleado(){
		
		return empresa.getEmpleadoSeleccionado().getHijos();
	}
	
	public ArrayList darListaEmpleados(){
		return empresa.getEmpleados();
	}
	
	public Empresa getEmpresa(){
		return (Empresa) empresa;
	}
	
	public Empleado getEmpleadoSeleccionado()
	{
		return empresa.getEmpleadoSeleccionado();
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

	
	public Nomina getNominaEmpleadoSeleccionado(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException
	{
		if(empresa.getEmpleadoSeleccionado()==null)
		{
			throw new NoExisteEmpleadoException("Debe seleccionar un empleado");
		}
		Nomina n =empresa.getEmpleadoSeleccionado().buscarNominaPeriodo(periodo);
		if(n==null)
		{
			throw new NominaNoEncontradaException("La n�mina no fue encontrada");
		}
		return n;
	}
	
	public double getNovedadesSueldoBasico(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException {
		
		Nomina n = getNominaEmpleadoSeleccionado(periodo);
		double rta = n.getSalarioBasico();
		return rta;
	}

	public int getNovedadesTiempoPeriodo(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException {
		Nomina n = getNominaEmpleadoSeleccionado(periodo);
		int rta = n.getPeriodoLiquidacion();
		return rta;
	}
	
	
	public void agregarDiaNoLaborado(String fechaInicio, String duracion, String concepto, String incapacidad){
		
	}
	
	public void editarDiaNoLaborado(int index, String fechaInicio, String duracion, String concepto, String incapacidad){
		
	}
	
	public void eliminarDiaNoLaborado(int index){
		
	}
	
	public void agregarOrdinarioExtraDiurno(String fechaRealizado, String cantidad, String concepto, String valorUnitario, String subTotal){
		
	}
	
	public void editarOrdinarioExtraDiurno(int index, String fechaRealizado, String cantidad, String concepto, String valorUnitario, String subTotal){
		
	}
	
	public void eliminarOrdinarioExtraDiurno(int index){
		
	}
	
	public void agregarOrdinarioExtraNocturno(String fechaRealizado, String cantidad, String concepto, String valorUnitario, String subTotal){
		
	}
	
	public void editarOrdinarioExtraNocturno(int index, String fechaRealizado, String cantidad, String concepto, String valorUnitario, String subTotal){
		
	}
	
	public void eliminarOrdinarioExtraNocturno(int index){
		
	}
	
	public void agregarDominicalExtraDiurno(String fechaRealizado, String cantidad, String concepto, String valorUnitario, String subTotal){
		
	}
	
	public void editarDominicalExtraDiurno(int index, String fechaRealizado, String cantidad, String concepto, String valorUnitario, String subTotal){
		
	}
	
	public void eliminarDominicalExtraDiurno(int index){
		
	}
	
	public void agregarDominicalExtraNocturno(String fechaRealizado, String cantidad, String concepto, String valorUnitario, String subTotal){
		
	}
	
	public void editarDominicalExtraNocturno(int index, String fechaRealizado, String cantidad, String concepto, String valorUnitario, String subTotal){
		
	}
	
	public void eliminarDominicalExtraNocturno(int index){
		
	}
	
	public void agregarDominicalDiasDominicalesYFestivos(String fechaRealizado, String cantidad, String concepto, String valorUnitario, String subTotal){
		
	}
	
	public void editarDominicalDiasDominicalesYFestivos(int index, String fechaRealizado, String cantidad, String concepto, String valorUnitario, String subTotal){
		
	}
	
	public void eliminarDominicalDiasDominicalesYFestivos(int index){
		
	}
	
	public void agregarDeduccionesOtrosTotalPrestamos(String fechaPrestamo, String concepto, String total, String cuotaPeriodo, String saldo){
		
	}
	
	public void editarDeduccionesOtrosTotalPrestamos(int index, String fechaPrestamo, String concepto, String total, String cuotaPeriodo, String saldo){
		
	}
	
	public void eliminarDeduccionesOtrosTotalPrestamos(int index){
		
	}

	public double getNovedadesSueldoPeriodo(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException {
		Nomina n = getNominaEmpleadoSeleccionado(periodo);
		return n.getSueldoPeriodo();
	}


	public double getDevengadoOrdinarioTotalRecargoNocturno(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException {
		Nomina n = getNominaEmpleadoSeleccionado(periodo);
		return n.getDevengado().getOrdinarioTotalRecargoNocturno();
	}


	public double getDevengadoDominicalTotalDominicalesFestivos(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException {
		Nomina n = getNominaEmpleadoSeleccionado(periodo);
		return n.getDevengado().getDominicalTotalRecargoDiurno();
	}
	
	public double getDevengadoDominicalTotalRecargoNocturno(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException {
		Nomina n = getNominaEmpleadoSeleccionado(periodo);
		return n.getDevengado().getDominicalTotalRecargoNocturno();
	}

	public double getDevengadoOrdinarioTotalExtraDiurno(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException {
		Nomina n = getNominaEmpleadoSeleccionado(periodo);
		return n.getDevengado().getOrdinarioTotalExtraDiurno();
	}

	public double getDevengadoOrdinarioTotalExtraNocturno(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException {
		Nomina n = getNominaEmpleadoSeleccionado(periodo);
		return n.getDevengado().getOrdinarioTotalExtraNocturno();
	}

	public double getDevengadoDominicalTotalExtraDiurno(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException {
		Nomina n = getNominaEmpleadoSeleccionado(periodo);
		return n.getDevengado().getDominicalTotalExtraDiurno();
	}

	public double getDevengadoDominicalTotalExtraNocturno(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException {
		Nomina n = getNominaEmpleadoSeleccionado(periodo);
		return n.getDevengado().getDominicalTotalExtraNocturno();
	}
	
	public double getDevengadoOtrosTotalAuxilioTransporte(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException {

		Nomina n = getNominaEmpleadoSeleccionado(periodo);
		return n.getDevengado().valorAuxilioTransporte();
	}


	public double getDevengadoOtrosTotalComisiones(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException {
		Nomina n = getNominaEmpleadoSeleccionado(periodo);
		return n.getDevengado().valorComisiones();
	}



	public double getDeduccionesSeguridadSocialTotalSalud(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException{
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDeduccionesSeguridadSocialTotalPension(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException {
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDeduccionesSeguridadSocialTotalPensionVoluntaria(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException {
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDeduccionesSeguridadSocialTotalSolidaridad(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException{
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDeduccionesSeguridadSocialTotalAFC(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException{
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDeduccionesOtrasTotalRetencion(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException{
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDeduccionesOtrasTotalJuzgados(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException{
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDeduccionesOtrasTotalPrestamos(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException{
		// TODO Auto-generated method stub
		return 0;
	}



	public double getDeduccionesOtrosTotalFondosEmpleados(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException{
		// TODO Auto-generated method stub
		return 0;
	}

	public ArrayList<DiasNoLaborados> getListaDiasNoLaborados(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException {

		Nomina n = getNominaEmpleadoSeleccionado(periodo);
		return n.getDiasNoLaborados();
	}

	public ArrayList getListaOrdinariaExtraDiurno(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException {
		Nomina n = getNominaEmpleadoSeleccionado(periodo);
		return n.getDevengado().getListaOrdinariaExtraDiurno();

	}

	public ArrayList getListaOrdinariaExtraNocturno(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException {
		Nomina n = getNominaEmpleadoSeleccionado(periodo);
		return n.getDevengado().getListaOrdinariaExtraNocturno();
	}


	public ArrayList getListaDominicalExtraDiurno(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException {
		Nomina n = getNominaEmpleadoSeleccionado(periodo);
		return n.getDevengado().getListaDominicalExtraDiurno();
	}

	public ArrayList getListaDominicalExtraNocturno(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException {
		Nomina n = getNominaEmpleadoSeleccionado(periodo);
		return n.getDevengado().getListaDominicalExtraNocturno();
	}

	public ArrayList getListaDominicalDiasDominicalesYFestivos(String periodo) throws NoExisteEmpleadoException, NominaNoEncontradaException {
		// TODO Auto-generated method stub
		ArrayList rta = new ArrayList( );
		return rta;
	}

	public ArrayList getListaDeduccionesPrestamos(String periodo) {
		// TODO Auto-generated method stub
		ArrayList rta = new ArrayList( );
		return rta;
	}
	
	public void agregarInfoLaboralEmpleadoNuevo(String cargoP,
			double salarioFijoP, int horasP, String tipoP, String duracionP,
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
			String tipoP, double documentoP, String sexoP, String estadoCivilP, 
			Date fechaP, String direccionP, String ciudadP, String departamentoP, String correoP, 
			String nacionalidadP, double telefonoP,double celularP,	ImageIcon fotoP)
	{
		Empleado e = empresa.getEmpleadoNuevo();
		empresa.agregarInfoPersonalEmpleado( e,  nombreP, apellidosP,
				 tipoP,  documentoP,  sexoP,  estadoCivilP, 
				 fechaP,  direccionP,  ciudadP, departamentoP, correoP, nacionalidadP, telefonoP, celularP,fotoP);
		
	}
	
	public void calcularPrima(double pTotal){
		Empleado e = getEmpleadoSeleccionado();
		e.calcularPrima(pTotal);
	}
	
	public void calcularCesantias(double pTotal){
		Empleado e = getEmpleadoSeleccionado();
		e.calcularCesantias(pTotal);
	}
	
	public String darUsuario(){
		String res = "usuario";
		return res;
	}

	public double getDevengadoPrestacionesTotalPrima(String periodo) {
		Empleado e = getEmpleadoSeleccionado();
		double res = e.darTotalPrima(periodo);
		return res;
	}

	public double getDevengadoPrestacionesTotalCesantias(String periodo) {
		Empleado e = getEmpleadoSeleccionado();
		double res = e.darTotalCesantias(periodo);
		return res;
	}

	public double getDevengadoPrestacionesTotalVacaciones(String periodo) {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public void liquidarPrima(String pPeriodo){
		Empleado e = getEmpleadoSeleccionado();
		e.liquidarPrima(pPeriodo);
	}
	
	public void liquidarCesantias(String pPeriodo){
		Empleado e = getEmpleadoSeleccionado();
		e.liquidarCesantias(pPeriodo);
	}

	
}
