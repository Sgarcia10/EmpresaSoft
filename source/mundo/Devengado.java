package mundo;

import java.util.ArrayList;
import java.util.Date;

public class Devengado
{
	private boolean auxilioTransporte;
	
	private ArrayList<HoraExtra> horasExtra;
	
	private ArrayList<Comision> comisiones;
	
	private double valorHora;
	
	private double total;

	public Devengado(Nomina nominaP)
	{
		
		auxilioTransporte = nominaP.isAuxilioTransporte();
		
		valorHora = nominaP.getValorHora();
		
		horasExtra = new ArrayList<HoraExtra>();
		
		comisiones = new ArrayList<Comision>();		
		
		total=0;

	}
	
	public void liquidar()
	{
		total=0;
	}
	
	public ArrayList<HoraExtra> getHorasExtra() {
		return horasExtra;
	}

	public ArrayList<Comision> getComisiones() {
		return comisiones;
	}
	
	public double getTotal()
	{
		return total;
	}
	
}
