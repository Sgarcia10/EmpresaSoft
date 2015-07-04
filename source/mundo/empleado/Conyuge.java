package mundo.empleado;

import java.io.Serializable;
import java.util.Date;

public class Conyuge extends Persona implements Serializable
{
	public Conyuge ( String nombresParejaP, String apellidosParejaP, double cedulaParejaP,
			double telefonoParejaP, Date fechaNacimientoParejaP, String sexoParejaP,
			String direccionParejaP, String ciudadParejaP)
	{
		super(cedulaParejaP, Persona.CEDULA, nombresParejaP, apellidosParejaP, sexoParejaP, 
				fechaNacimientoParejaP, "", "", -1, telefonoParejaP, -1, direccionParejaP, ciudadParejaP, "", "");
	}
}
