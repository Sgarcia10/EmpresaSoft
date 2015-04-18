package mundo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Nomina 
{		
	private int salarioBasico;
	
	private boolean auxilioTransporte;
	
	private int horasSemana;
	
	private int periodoLiquidacion;
	
	private Date periodoInicio;
	
	private Date periodoFin;
	
	private ArrayList<DiasNoLaborados> diasNoLaborados;
	
	private Devengado devengado;
	
	private Deducciones deducciones;
	
	private double sueldoPeriodo;
	
	private double valorHora;
	
	private int total;
	
	public Nomina(Empleado empleadoP)
	{
		salarioBasico = empleadoP.getContrato().getSueldoBasico();
		
		auxilioTransporte = empleadoP.getContrato().isAuxilioTransporte();
		
		horasSemana = empleadoP.getContrato().getHorasSemana();
		
		periodoLiquidacion = empleadoP.getContrato().getPeriodoLiquidacion();
		

		diasNoLaborados = new ArrayList<DiasNoLaborados>();
		
		valorHora = salarioBasico / (horasSemana * 4);
	}
	
	private void crearPeriodoActual()
	{
		Date fechaActual = new Date();	
		SimpleDateFormat formatoDelTexto = new SimpleDateFormat("dd-MM-yyyy");
		String [] valoresFechaActual = formatoDelTexto.format(fechaActual).split("-");
		int diaActual = Integer.parseInt(valoresFechaActual[0]);
		int mesActual = Integer.parseInt(valoresFechaActual[1]);
		int anioActual = Integer.parseInt(valoresFechaActual[2]);
		
		if(periodoLiquidacion==15)
		{
			if(diaActual>=1 && diaActual<=15)
			{
				String fecha1 = "01-"+mesActual+"-"+anioActual;
				String fecha2 = "15-"+mesActual+"-"+anioActual;
				try 
				{
					periodoInicio = formatoDelTexto.parse(fecha1);
					periodoFin = formatoDelTexto.parse(fecha2);
				}
				catch (ParseException e) 
				{
					e.printStackTrace();
				}
			}
			else
			{
				String fecha1 = "16-"+mesActual+"-"+anioActual;
				String fecha2 = "30-"+mesActual+"-"+anioActual;
				try 
				{
					periodoInicio = formatoDelTexto.parse(fecha1);
					periodoFin = formatoDelTexto.parse(fecha2);
				}
				catch (ParseException e) 
				{
					e.printStackTrace();
				}
			}
		}
		else if(periodoLiquidacion==30)
		{
			String fecha1 = "01-"+mesActual+"-"+anioActual;
			String fecha2 = "30-"+mesActual+"-"+anioActual;
			try 
			{
				periodoInicio = formatoDelTexto.parse(fecha1);
				periodoFin = formatoDelTexto.parse(fecha2);
			}
			catch (ParseException e) 
			{
				e.printStackTrace();
			}
		}
	}
	
	protected void agregarDiaNoLaborado(Usuario user, String concepto, boolean excusa, Date fechaInicio, int duracion)
	{
		DiasNoLaborados nuevo = new DiasNoLaborados(user, concepto, excusa, fechaInicio, duracion);
		
		diasNoLaborados.add(nuevo);
	}
	
	public void liquidar()
	{
		calcularSueldoPeriodo();
		devengado = new Devengado(this);
		deducciones = new Deducciones(this);
	}
	
	public int numeroDiasNoLaborados()
	{
		return 0;
	}
	
	private void calcularSueldoPeriodo()
	{
		sueldoPeriodo=0;
	}
	
	public double getValorHora()
	{
		return valorHora;
	}

	public ArrayList<DiasNoLaborados> getDiasNoLaborados() {
		return diasNoLaborados;
	}
	
	public int getSalarioBasico() {
		return salarioBasico;
	}

	public boolean isAuxilioTransporte() {
		return auxilioTransporte;
	}

	public int getHorasSemana() {
		return horasSemana;
	}

	public int getPeriodoLiquidacion() {
		return periodoLiquidacion;
	}

	public Date getPeriodoInicio() {
		return periodoInicio;
	}

	public Date getPeriodoFin() {
		return periodoFin;
	}

	public Devengado getDevengado()
	{
		return devengado;
	}

	public int getTotal() {
		return total;
	}
	
	public boolean isAuxiloTransporte()
	{
		return auxilioTransporte;
	}
		
	
}
