package mundo;

import java.util.Date;

public class Prestamo
{
	private Date fechaExpedicion;
	
	private int cantidad;
	
	private int saldo;
	
	private int numeroCuotas;
	
	private double interes;
	
	public Prestamo(int cantidadP, int numeroCuotasP, double interesP)
	{
		fechaExpedicion = new Date();
		cantidad = cantidadP;
		numeroCuotas=numeroCuotasP;
		interes=interesP;
	}
	
	
	

}
