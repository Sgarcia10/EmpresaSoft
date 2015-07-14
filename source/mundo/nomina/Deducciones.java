package mundo.nomina;

import java.io.Serializable;
import java.util.ArrayList;

public class Deducciones implements Serializable {
	
	private final static long serialVersionUID = 200L;
		
	private int salarioBasico;
	
	private boolean auxilioTransporte;
	
	private double totalDevengado;
	
	private double totalDeducido;
		
	private double salud;
	
	private double pension;

	private double pensionVoluntaria;

	private double solidaridad;

	private double afc;

	private double retencion;

	private double otras;
	
	private ArrayList<Prestamo> prestamos;
	
		
	public Deducciones(Nomina nominaP)
	{
		salarioBasico = nominaP.getSalarioBasico();
		
		auxilioTransporte = nominaP.isAuxiloTransporte();
		
		totalDevengado = nominaP.getDevengado().getTotal();
		
		prestamos = nominaP.getPrestamos();
	}
	
	private void liquidar()
	{
		totalDeducido = 0;
	}
	
	public int EPS()
	{
		return 0;
	}	
	
	public double getValorSalud() {
		return salud;
	}



	public double getValorPension() {
		return pension;
	}



	public double getValorPensionVoluntaria() {
		return pensionVoluntaria;
	}



	public double getValorSolidaridad(String periodo) {
		return solidaridad;
	}



	public double getValorAFC() {
		return afc;
	}



	public double getValorRetencion(String periodo) {
		return retencion;
	}



	public double getDeduccionesOtrasTotalJuzgados() {
		return otras;
	}

	public double getValorPrestamos() {
		double valor = 0;
		for(int i=0; i<prestamos.size(); i++)
		{
			Prestamo p = prestamos.get(i);
			if(!p.isAmortizado())
			{
				valor = p.getValorCuota();
			}
		}
		
		return valor;
	}

	public double getValorFondosEmpleados() {
		return 0;
	}
	
	
	protected int getSalarioBasico() {
		return salarioBasico;
	}

	protected boolean isAuxilioTransporte() {
		return auxilioTransporte;
	}

	protected double getTotalDevengado() {
		return totalDevengado;
	}

	protected double getTotalDeducido() {
		return totalDeducido;
	}

	protected double getSalud() {
		return salud;
	}

	protected double getPension() {
		return pension;
	}

	protected double getPensionVoluntaria() {
		return pensionVoluntaria;
	}

	protected double getSolidaridad() {
		return solidaridad;
	}

	protected double getAfc() {
		return afc;
	}

	protected double getRetencion() {
		return retencion;
	}

	protected double getOtras() {
		return otras;
	}
	
}
