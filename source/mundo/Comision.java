package mundo;

import java.util.Date;

public class Comision extends Registro
{
	private int valor;
	
	private Date fecha;
	
	public Comision(Usuario user, String concepto, int valor, Date fecha)
	{
		super(concepto, user);
		
		this.valor = valor;
		
		this.fecha = fecha;
	}

	public int getValor() {
		return valor;
	}


	public Date getFecha() {
		return fecha;
	}


	protected void setValor(int valor) {
		this.valor = valor;
	}

	protected void setFecha(Date fecha) {
		this.fecha = fecha;
	}
}
