package mundo;

import java.util.ArrayList;
import java.util.Date;

public interface IEmpresa {
		
	public void agregarEmpleado() throws Exception;
	
	public void darEmpleado() throws Exception;
	
	public void verEmpleado() throws Exception;
	
	public boolean validacionUsuario(String usuarioP, String contraseniaP);
	
	public Empleado crearEmpleadoNuevo(int identificacion, String tipoDocumento, String nombre, 
			String apellidos, String sexo, Date fechaNacimiento, String estadoCivil,
			String correo, int edad, int telefono, int celularP, String direccion, String ciudad,
			String departamento, String nacionalidad);
	
	public void agregarReferenciaEmpleado(Empleado empleadoP, String nombresP, String apellidosP, int telefonoP, 
			int documentoP, String sexoP, String direccionP, String ciudadP, String departamentoP, String tipoP, 
			String empresaP, String conceptoP);
	
	public void agregarExperienciaEmpleado(Empleado empleadoP, String cargoP, String empresaP, String tipoContratoP, Date fechaInicioP, Date fechaFinP);
	
	public void eliminarReferenciaEmpleado(Empleado empleadoP, int index);
	
	public void eliminarExperienciaEmpleado(Empleado empleadoP, int index);
	
	public ArrayList darListaReferecniasEmpleado(Empleado empleadoP);
	
	public ArrayList darListaExperienciaEmpleado(Empleado empleadoP);
	
	public Empleado getEmpleadoNuevo();
	
}
