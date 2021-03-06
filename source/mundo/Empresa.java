package mundo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Properties;

import javax.swing.ImageIcon;

import Excepciones.NominaExistenteException;
import mundo.empleado.Empleado;

public class Empresa implements IEmpresa {
	
	private ArrayList <Empleado> empleados;
	private ArrayList <Usuario> usuarios;
	
	private Empleado empleadoNuevo;
	
	private Empleado empleadoSeleccionado;
	
	private Usuario usuarioConectado;
	
	public static final String RUTA_ARCHIVO_PERSISTENCIA = "./data/Persistencia/";
	
	public static final String RUTA_ARCHIVO_FOTOS = "./data/Imagenes/";
	
	public Empresa(){
		empleados = new ArrayList<Empleado>();
		usuarios = new ArrayList<Usuario>();
		empleadoNuevo = null;
		empleadoSeleccionado = null;
		usuarioConectado = null;
	}
	
	public boolean validacionUsuario(String usuarioP, String contraseniaP){
		if (usuarioP.equals("1") && contraseniaP.equals("1"))
		{
			return true;
		}
		return false;
	}

	public void agregarEmpleado(){
		
		empleados.add(empleadoNuevo);
		
	}
	
	public void agregarInfoLaboralEmpleado(Empleado empleadoP, String cargoP,
			double salarioFijoP, int horasP, String tipoP, String duracionP,
			Date fechaInicioP, Date fechaFinP, int tipoLiquidacionP, String saludP,
			String pensionesP, String arlP, boolean solidaridadP, String cajaCompensacionP,
			Date fechaAfiliacionP, boolean auxilioP) {
		
		empleadoP.agregarContrato(cargoP, salarioFijoP, horasP, tipoP, duracionP, fechaInicioP, fechaFinP, tipoLiquidacionP, auxilioP);
		
		empleadoP.setSalud(saludP);
		empleadoP.setPensiones(pensionesP);
		empleadoP.setArl(arlP);
		empleadoP.setSolidaridad(solidaridadP);
		empleadoP.setCajaCompensacion(cajaCompensacionP);
		empleadoP.setFechaAfiliacionSS(fechaAfiliacionP);
		
	}
	
	public void agregarInfoPersonalEmpleado(Empleado empleadoP,
			String nombreP, String apellidosP, String tipoP, double documentoP,
			String sexoP, String estadoCivilP, Date fechaP, String direccionP,
			String ciudadP, String departamentoP, String correoP, String nacionalidadP, 
			double telefonoP, double celularP, ImageIcon fotoP) {

		empleadoP.setNombres(nombreP);
		empleadoP.setApellidos(apellidosP);
		empleadoP.setTipoDocumento(tipoP);
		empleadoP.setIdentificacion(documentoP);
		empleadoP.setSexo(sexoP);
		empleadoP.setEstadoCivil(estadoCivilP);
		empleadoP.setFechaNacimiento(fechaP);
		empleadoP.setDireccion(direccionP);
		empleadoP.setCiudad(ciudadP);
		empleadoP.setTelefono(telefonoP);
		empleadoP.setCelular(celularP);
		empleadoP.setFoto(fotoP);
		empleadoP.setDepartamento(departamentoP);
		empleadoP.setCorreo(correoP);
		empleadoP.setNacionalidad(nacionalidadP);
	}

	@Override
	public void darEmpleado() throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void verEmpleado() throws Exception {
		// TODO Auto-generated method stub
		
	}
	
	public Empleado crearEmpleadoNuevo(int identificacion, String tipoDocumento, String nombre, 
			String apellidos, String sexo, Date fechaNacimiento, String estadoCivil,
			String correo, int edad, int telefono, int celularP, String direccion, String ciudad,
			String departamento, String nacionalidad) 
	{
		empleadoNuevo = new Empleado(identificacion, tipoDocumento, nombre, apellidos, sexo, fechaNacimiento,
				estadoCivil, correo, edad, telefono, celularP, direccion, ciudad, 
				departamento, nacionalidad);
		return empleadoNuevo;
	}
	
	public void agregarReferenciaEmpleado(Empleado empleadoP, String nombresP, String apellidosP, double telefonoP, 
			double documentoP, String sexoP, String direccionP, String ciudadP, String departamentoP, String tipoP, 
			String empresaP, String conceptoP){
		
		empleadoP.agregarReferencia(nombresP, apellidosP, telefonoP, documentoP, sexoP, direccionP, ciudadP, departamentoP, tipoP, empresaP, conceptoP);
	}
	
	public void agregarExperienciaEmpleado(Empleado empleadoP, String cargoP, String empresaP, String tipoContratoP, Date fechaInicioP, Date fechaFinP){
		empleadoP.agregarExperiencia(cargoP, empresaP, tipoContratoP, fechaInicioP, fechaFinP);
	}
	
	public void agregarHijos(Empleado empleadoP, String nombreP,String apellidosP,double telefonoP,double identificacionP, String sexoP, String direccionP, String ciudadP, String departamentoP, String tipoDocumentoP, Date fechaNacimientoP)
	{
		
		empleadoP.agregarHijo(nombreP, apellidosP, telefonoP, identificacionP, sexoP, direccionP, ciudadP, departamentoP, tipoDocumentoP, fechaNacimientoP);
	}
	
	public void agregarConyugueEmpleado(Empleado empleadoP, String nombresParejaP, String apellidosParejaP, double cedulaParejaP,
			double telefonoParejaP, Date fechaNacimientoParejaP, String sexoParejaP,
			String direccionParejaP, String ciudadParejaP){
		
		empleadoP.agregarConyugue(nombresParejaP, apellidosParejaP, cedulaParejaP, telefonoParejaP, fechaNacimientoParejaP, sexoParejaP, direccionParejaP, ciudadParejaP);
	}
	
	public void eliminarReferenciaEmpleado(Empleado empleadoP, int index){
		empleadoP.eliminarReferencia(index);
	}
	
	public void eliminarExperienciaEmpleado(Empleado empleadoP, int index){
		empleadoP.eliminarExperiencia(index);
	}
	
	public void eliminarHijoEmpleado(Empleado empleadoP, int index){
		empleadoP.eliminarHijo(index);
	}
	
	public void editarReferenciaEmpleado(Empleado empleadoP, int posicion, String tipoP,
			String nombresP, String apellidosP, double documentoP, double telefonoP,
			String sexoP, String direccionP, String ciudadP, String empresaP,
			String conceptoP) {

		empleadoP.editarReferencia(posicion, tipoP, nombresP, apellidosP, documentoP, telefonoP,
				sexoP, direccionP, ciudadP, empresaP, conceptoP);
		
	}
	
	public void editarExperienciaEmpleado(Empleado empleadoP, int index, String empresaP, 
			String cargoP, String tipoP, Date fechaInicioP, Date fechaFinP){
		
		empleadoP.editarExperiencia(index, empresaP, cargoP, tipoP, fechaInicioP, fechaFinP);
	}
	
	public void editarHijoEmpleado(Empleado empleadoP, int index, String nombreP, String apellidosP, String tipoP,
			double identificacionP, String sexoP, Date fechaP, String direccionP){
		
		empleadoP.editarHijo(index, nombreP, apellidosP, tipoP, identificacionP, sexoP, fechaP, direccionP);
	}
	
	
	
	public ArrayList darListaReferecniasEmpleado(Empleado empleadoP){
		return empleadoP.getReferencias();
	}
	
	public ArrayList darListaExperienciaEmpleado(Empleado empleadoP){
		return empleadoP.getExperiencia();
	}
	
	public Empleado getEmpleadoNuevo(){
		return empleadoNuevo;
	}


	
	public void cargarEstadoEmpleados( String pRutaNombre ) throws PersistenciaException
	{
		
		String rutaEmpleados = pRutaNombre + "estadoEmpleados.data";
		
		try
		{
			File archivoEmpleados = new File(rutaEmpleados);
			
			if( archivoEmpleados.exists( ) )
			{
				
				ObjectInputStream oisEmpleado = new ObjectInputStream( new FileInputStream( archivoEmpleados ) );
				empleados = ( ArrayList<Empleado> ) oisEmpleado.readObject( );
				oisEmpleado.close( );
			}
			
			else
			{
				empleados = new ArrayList<Empleado>();
			}
			
		}
		catch( FileNotFoundException e )
		{
			throw new PersistenciaException( "No se encontró archivo de persistencia. \nAl cerrar la aplicación se generará por primera vez el archivo de persistencia " );
		}
		catch( IOException e )
		{
			throw new PersistenciaException( "No fue posible leer el archivo de persistencia. " + e.getMessage( ) );
		}
		catch( ClassNotFoundException e )
		{
			throw new PersistenciaException( "Problemas al cargar el archivo de persistencia. " + e.getMessage( ) );
		}

	}

	public void guardarEstadoEmpleados( String pRutaNombre) throws PersistenciaException
	{
		try
		{
			//Se crean las tres rutas
			String rutaEmpleados = pRutaNombre + "estadoEmpleados.data";
			
			//Serializar
			ObjectOutputStream oosEmpleado= new ObjectOutputStream( new FileOutputStream( rutaEmpleados ) );
			oosEmpleado.writeObject( empleados );
			oosEmpleado.close( );
		}
		catch( IOException e )
		{
			throw new PersistenciaException( "Error al salvar: " + e.getMessage( ) );
		}
	}
	
	public void cargarAdmin()
	{
		Properties prop = new Properties();
		InputStream inStream = null;
	 
		try {
	 
			inStream = new FileInputStream("./data/Persistencia/admin.properties");
			prop.load(inStream);
			// set the properties value
			
	 
		} catch (IOException io) {
			io.printStackTrace();
		} finally {
			if (inStream != null) {
				try {
					inStream.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	 
		}
	}
	
	@Override
	public ArrayList getEmpleados() {
		// TODO Auto-generated method stub
		return empleados;
	}

	@Override
	public Empleado getEmpleadoSeleccionado() {
		return empleadoSeleccionado;
	}
	
	public void seleccionarEmpleado(Empleado e)
	{
		if(e!=null)
		{
			empleadoSeleccionado = e;
			agregarNomina();
		}
		
	}
	
	public void agregarNomina()
	{
		Calendar c = Calendar.getInstance();
		int dia = c.get(Calendar.DATE);
		int anio = c.get(Calendar.YEAR);
		String mes = new SimpleDateFormat("MMMM").format(c.getTime());
		String dias = "";
		if(dia<16)
			dias="1-15";
		else
			dias="16-30";
		String periodo = dias+ "/" + mes + "/" + anio;
		
		try {
			empleadoSeleccionado.agregarNomina(periodo);
			System.out.println("creo nomina periodo: "+periodo);
		} catch (NominaExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public Empleado buscarEmpleadoIdentificacion(double identificacionP) {
		Empleado e = null;
		for(int i=0; i<empleados.size(); i++)
		{
			e=empleados.get(i);
			if(e.getIdentificacion()==identificacionP)
				return e;
		}
		return e;
	}
	
	
	
}
