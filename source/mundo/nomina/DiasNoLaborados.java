package mundo.nomina;

import java.io.Serializable;
import java.util.Date;

import mundo.Registro;
import mundo.Usuario;

public class DiasNoLaborados extends Registro implements Serializable {
	
	private final static long serialVersionUID = 200L;
	
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
