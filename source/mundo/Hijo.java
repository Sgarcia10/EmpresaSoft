package mundo;

import java.io.Serializable;
import java.util.Date;

public class Hijo extends Persona implements Serializable{
		
	public Hijo(String nombre, String apellidos, double telefono,
			double identificacion, String sexo, String direccion, String ciudad, String departamento,
			String tipoDocumentoP, Date fechaNacimientoP) {
		
		super(identificacion, tipoDocumentoP, nombre, apellidos, sexo, fechaNacimientoP, 
				"", "", -1, telefono, -1, direccion, ciudad, departamento, "");		
	}

	
}
