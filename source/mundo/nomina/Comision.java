package mundo.nomina;

import java.io.Serializable;
import java.util.Date;

import mundo.Registro;
import mundo.Usuario;

public class Comision extends Registro implements Serializable {
	
	private final static long serialVersionUID = 200L;
	
	private double valor;
	
	private Date fecha;
	
	public Comision(Usuario user, String concepto, double valor, Date fecha)
	{
		super(concepto, user);
		
		this.valor = valor;
		
		this.fecha = fecha;
	}

	public double getValor() {
		return valor;
	}


	public Date getFecha() {
		return fecha;
	}


	protected void setValor(double valor) {
		this.valor = valor;
	}

	protected void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
