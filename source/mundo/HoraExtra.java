package mundo;

import java.util.Date;

public class HoraExtra extends Registro
{
	private Date fechaLaborada;
	
	private boolean festivo;
	
	private boolean nocturno;
	
	private int horaInicio;
	
	private int numeroHoras;
	
	private double factor;
	
	private double valor;
	
	public HoraExtra(Usuario user, String concepto, Date fechaLaborada, boolean festivo, boolean nocturno, int horaInicio, int numeroHoras)
	{
		super(concepto, user);
		
		this.fechaLaborada = fechaLaborada;
		
		this.horaInicio = horaInicio;
		
		this.numeroHoras = numeroHoras;
		
		this.festivo = festivo;
		
		this.nocturno = nocturno;
		
		factor = 0;
		
		calcularFactor();
	}
	
	private void calcularFactor()
	{
		if(festivo)
		{
			if(nocturno)
			{
				factor = numeroHoras*Constantes.HORA_EXTRA_DOMINICAL_NOCTURNA;
			}
			else
			{
				factor = numeroHoras*Constantes.HORA_EXTRA_DOMINICAL_DIURNA;
			}
		}
		else
		{
			if(nocturno)
			{
				factor = numeroHoras*Constantes.HORA_EXTRA_ORDINARIA_NOCTURNA;
			}
			else
			{
				factor = numeroHoras*Constantes.HORA_EXTRA_ORDINARIA_DIURNA;
			}
		}
	}
	
	public boolean isFestivo()
	{
		return festivo;
	}
	
	public boolean isNocturno()
	{
		return nocturno;
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

	public double getFactor() {
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
