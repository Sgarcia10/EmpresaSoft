package mundo;

import java.util.Date;

public class Conyuge extends Persona
{
	public Conyuge ( String nombresParejaP, String apellidosParejaP, int cedulaParejaP, 
			Date fechaNacimientoParejaP)
	{
		super(cedulaParejaP, Persona.CEDULA, nombresParejaP, apellidosParejaP, "", 
				fechaNacimientoParejaP, "", "", -1, -1, -1, "", "", "", "");
	}
}
