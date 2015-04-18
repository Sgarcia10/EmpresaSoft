package mundo;

import java.util.Date;

public class HoraExtra extends Registro
{
	private Date fechaLaborada;
	
	private boolean festivo;
	
	private int horaInicio;
	
	private int numeroHoras;
	
	private int factor;
	
	public HoraExtra(Usuario user, String concepto, Date fechaLaborada, boolean festivo, int horaInicio, int numeroHoras)
	{
		super(concepto, user);
		
		this.fechaLaborada = fechaLaborada;
		
		this.horaInicio = horaInicio;
		
		this.numeroHoras = numeroHoras;
		
		factor = 0;
		
		calcularFactor();
	}
	
	private void calcularFactor()
	{
		
	}

	public Date getFechaLaborada() {
		return fechaLaborada;
	}

	public int getHoraInicio() {
		return horaInicio;
	}

	public int getNumeroHoras() {
		return numeroHoras;
	}

	public int getFactor() {
		return factor;
	}
	
	public double getValorUnitario() {
		return 0;
	}
	
	public double getSubTotal() {
		return getValorUnitario()*numeroHoras;
	}
	
	protected void setFechaLaborada(Date fechaLaborada) {
		this.fechaLaborada = fechaLaborada;
		
		calcularFactor();
	}

	protected void setHoraInicio(int horaInicio) {
		this.horaInicio = horaInicio;
		calcularFactor();
	}

	protected void setNumeroHoras(int numeroHoras) {
		this.numeroHoras = numeroHoras;
		calcularFactor();
	}
	
	
}
