package mundo;

import java.util.ArrayList;
import java.util.Date;

import javax.swing.ImageIcon;

public interface IEmpresa {
	
	public static final String RUTA_ARCHIVO_PERSISTENCIA = "./data/Persistencia/";
		
	public void agregarEmpleado();
	
	public void agregarInfoLaboralEmpleado(Empleado empleadoP, String cargoP,
			double salarioFijoP, int horasP, String tipoP, String duracionP,
			Date fechaInicioP, Date fechaFinP, int tipoLiquidacionP, String saludP,
			String pensionesP, String arlP, boolean solidaridadP, String cajaCompensacionP,
			Date fechaAfiliacionP, boolean auxilioP);
	
	public void agregarInfoPersonalEmpleado(Empleado empleadoP, String nombreP,String apellidosP,
			String tipoP, double documentoP, String sexoP, String estadoCivilP, 
			Date fechaP, String direccionP, String ciudadP, double telefonoP,double celularP,
			ImageIcon fotoP);
	
	public void darEmpleado() throws Exception;
	
	public void verEmpleado() throws Exception;
	
	public boolean validacionUsuario(String usuarioP, String contraseniaP);
	
	public Empleado crearEmpleadoNuevo(int identificacion, String tipoDocumento, String nombre, 
			String apellidos, String sexo, Date fechaNacimiento, String estadoCivil,
			String correo, int edad, int telefono, int celularP, String direccion, String ciudad,
			String departamento, String nacionalidad);
	
	public void agregarReferenciaEmpleado(Empleado empleadoP, String nombresP, String apellidosP, double telefonoP, 
			double documentoP, String sexoP, String direccionP, String ciudadP, String departamentoP, String tipoP, 
			String empresaP, String conceptoP);
	
	public void agregarExperienciaEmpleado(Empleado empleadoP, String cargoP, String empresaP, String tipoContratoP, Date fechaInicioP, Date fechaFinP);
	
	public void agregarHijos(Empleado empleadoP, String nombreP,String apellidosP,double telefonoP,double identificacionP, String sexoP, String direccionP, String ciudadP, String departamentoP, String tipoDocumentoP, Date fechaNacimientoP);
	
	public void agregarConyugueEmpleado(Empleado empleadoP, String nombresParejaP, String apellidosParejaP, double cedulaParejaP,
			double telefonoParejaP, Date fechaNacimientoParejaP, String sexoParejaP,
			String direccionParejaP, String ciudadParejaP);
	
	public void eliminarReferenciaEmpleado(Empleado empleadoP, int index);
	
	public void eliminarExperienciaEmpleado(Empleado empleadoP, int index);
	
	public void eliminarHijoEmpleado(Empleado empleadoP, int index);
	
	public void editarReferenciaEmpleado(Empleado empleadoP, int posicion,
			String tipoP, String nombresP, String apellidosP, double documentoP,
			double telefonoP, String sexoP, String direccionP, String ciudadP,
			String empresaP, String conceptoP);
	
	public void editarExperienciaEmpleado(Empleado empleadoP, int index, String empresaP, 
			String cargoP, String tipoP, Date fechaInicioP, Date fechaFinP);
	
	public void editarHijoEmpleado(Empleado empleadoP, int index, String nombreP, String apellidosP, String tipoP,
			double identificacionP, String sexoP, Date fechaP, String direccionP);
	
	public ArrayList darListaReferecniasEmpleado(Empleado empleadoP);
	
	public ArrayList darListaExperienciaEmpleado(Empleado empleadoP);
	
	public Empleado getEmpleadoNuevo();
	
	public Empleado getEmpleadoSeleccionado();
	
	public ArrayList getEmpleados();
	
    public void cargarEstado( String pRutaNombre ) throws PersistenciaException;
	
	public void guardarEstado( String pRutaNombre) throws PersistenciaException;
	
}
