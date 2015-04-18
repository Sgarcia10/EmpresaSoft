package mundo;

import java.util.Date;

public abstract class Registro 
{
	private Date fecha;
	
	private String concepto;
	
	private Usuario user;
	
	public Registro(String concepto, Usuario user)
	{
		fecha = new Date();
		
		this.concepto = concepto;
		
		this.user = user;
	}

	public Date getFecha() {
		return fecha;
	}

	public String getConcepto() {
		return concepto;
	}

	public Usuario getUser() {
		return user;
	}

	protected void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	protected void setConcepto(String concepto) {
		this.concepto = concepto;
	}

	protected void setUser(Usuario user) {
		this.user = user;
	}
	
}
