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
		total=valorComisiones()+valorHorasExtra()+valorAuxilioTransporte();
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
	
	public double valorComisiones()
	{
		double valor=0;
		for(int i=0; i<comisiones.size(); i++)
		{
			valor+=comisiones.get(i).getValor();
		}
		return valor;
	}
	
	public double valorHorasExtra()
	{
		double valor=0;
		for(int i=0; i<horasExtra.size(); i++)
		{
			valor+=valorHora*horasExtra.get(i).getFactor();
		}
		return valor;
	}
	
	public double valorAuxilioTransporte()
	{
		if(auxilioTransporte)
		{
			return Constantes.AUXILIO_TRANSPORTE;
		}
		else
			return 0;
	}
	
	public double getOrdinarioTotalRecargoNocturno() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	public double getDominicalTotalRecargoNocturno() {
		// TODO Auto-generated method stub
		return 0;
	}
	

	public double getDominicalTotalRecargoDiurno() {
		// TODO Auto-generated method stub
		return 0;
	}

	public double getOrdinarioTotalExtraDiurno() {
		double valor=0;
		for(int i=0; i<horasExtra.size(); i++)
		{
			HoraExtra horaExtra = horasExtra.get(i);
			if(!horaExtra.isFestivo() && !horaExtra.isNocturno())
			valor+=valorHora*horasExtra.get(i).getFactor();
		}
		return valor;
	}

	public double getOrdinarioTotalExtraNocturno() {
		double valor=0;
		for(int i=0; i<horasExtra.size(); i++)
		{
			HoraExtra horaExtra = horasExtra.get(i);
			if(!horaExtra.isFestivo() && horaExtra.isNocturno())
			valor+=valorHora*horasExtra.get(i).getFactor();
		}
		return valor;
	}

	

	public double getDominicalTotalExtraDiurno() {
		double valor=0;
		for(int i=0; i<horasExtra.size(); i++)
		{
			HoraExtra horaExtra = horasExtra.get(i);
			if(horaExtra.isFestivo() && !horaExtra.isNocturno())
			valor+=valorHora*horasExtra.get(i).getFactor();
		}
		return valor;
	}



	public double getDominicalTotalExtraNocturno() {
		double valor=0;
		for(int i=0; i<horasExtra.size(); i++)
		{
			HoraExtra horaExtra = horasExtra.get(i);
			if(horaExtra.isFestivo() && horaExtra.isNocturno())
			valor+=valorHora*horasExtra.get(i).getFactor();
		}
		return valor;
	}

	
	public ArrayList<HoraExtra> getListaOrdinariaExtraDiurno() {
		// TODO Auto-generated method stub
		ArrayList<HoraExtra> lista = new ArrayList<HoraExtra>(); 
		for(int i=0; i<horasExtra.size(); i++)
		{
			HoraExtra horaExtra = horasExtra.get(i);
			if(!horaExtra.isFestivo() && !horaExtra.isNocturno())
				lista.add(horaExtra);
		}
		return lista;
	}


	public ArrayList <HoraExtra> getListaOrdinariaExtraNocturno() {
		ArrayList<HoraExtra> lista = new ArrayList<HoraExtra>(); 
		for(int i=0; i<horasExtra.size(); i++)
		{
			HoraExtra horaExtra = horasExtra.get(i);
			if(!horaExtra.isFestivo() && horaExtra.isNocturno())
				lista.add(horaExtra);
		}
		return lista;
		
	}

	public ArrayList <HoraExtra> getListaDominicalExtraDiurno() {
		ArrayList<HoraExtra> lista = new ArrayList<HoraExtra>(); 
		for(int i=0; i<horasExtra.size(); i++)
		{
			HoraExtra horaExtra = horasExtra.get(i);
			if(horaExtra.isFestivo() && !horaExtra.isNocturno())
				lista.add(horaExtra);
		}
		return lista;
	}

	public ArrayList <HoraExtra> getListaDominicalExtraNocturno() {
		ArrayList<HoraExtra> lista = new ArrayList<HoraExtra>(); 
		for(int i=0; i<horasExtra.size(); i++)
		{
			HoraExtra horaExtra = horasExtra.get(i);
			if(horaExtra.isFestivo() && horaExtra.isNocturno())
				lista.add(horaExtra);
		}
		return lista;
	}
	
}
