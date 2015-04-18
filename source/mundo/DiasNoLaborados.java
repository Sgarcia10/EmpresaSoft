package mundo;

import java.util.Date;

public class DiasNoLaborados extends Registro
{
	private boolean excusa;
	
	private Date fechaInicio;
	
	private int duracion;
	
	public DiasNoLaborados(Usuario user, String concepto, boolean excusa, Date fechaInicio, int duracion)
	{
		super(concepto, user);
		
		this.excusa = excusa;
		
		this.fechaInicio = this.fechaInicio;
		
		this.duracion = duracion;
	}

	public boolean isExcusa() {
		return excusa;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public int getDuracion() {
		return duracion;
	}

	protected void setExcusa(boolean excusa) {
		this.excusa = excusa;
	}

	protected void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	protected void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	
}
