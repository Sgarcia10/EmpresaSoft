package mundo;

import java.util.Date;

public class Hijo extends Persona {
		
	public Hijo(String nombre, String apellidos, int telefono,
			int identificacion, String sexo, String direccion, String ciudad, String departamento,
			String tipoDocumentoP, Date fechaNacimientoP) {
		
		super(identificacion, tipoDocumentoP, nombre, apellidos, sexo, fechaNacimientoP, 
				"", "", -1, telefono, -1, direccion, ciudad, departamento, "");		
	}

	
}
