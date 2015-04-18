package mundo;

import java.util.ArrayList;
import java.util.Date;

public class Empresa implements IEmpresa {
	
	private ArrayList empleados;
	
	private Empleado empleadoNuevo;
	
	private Empleado empleadoSeleccionado;
	
	public Empresa(){
		empleados = new ArrayList();
	}
	
	public boolean validacionUsuario(String usuarioP, String contraseniaP){
		if (usuarioP.equals("1") && contraseniaP.equals("1"))
		{
			return true;
		}
		return false;
	}

	@Override
	public void agregarEmpleado() throws Exception {
		// TODO Auto-generated method stub
		
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
	
	public void agregarReferenciaEmpleado(Empleado empleadoP, String nombresP, String apellidosP, int telefonoP, 
			int documentoP, String sexoP, String direccionP, String ciudadP, String departamentoP, String tipoP, 
			String empresaP, String conceptoP){
		
		empleadoP.agregarReferencia(nombresP, apellidosP, telefonoP, documentoP, sexoP, direccionP, ciudadP, departamentoP, tipoP, empresaP, conceptoP);
	}
	
	public void agregarExperienciaEmpleado(Empleado empleadoP, String cargoP, String empresaP, String tipoContratoP, Date fechaInicioP, Date fechaFinP){
		empleadoP.agregarExperiencia(cargoP, empresaP, tipoContratoP, fechaInicioP, fechaFinP);
	}
	
	public void eliminarReferenciaEmpleado(Empleado empleadoP, int index){
		empleadoP.eliminarReferencia(index);
	}
	
	public void eliminarExperienciaEmpleado(Empleado empleadoP, int index){
		empleadoP.eliminarExperiencia(index);
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

}
