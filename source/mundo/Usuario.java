package mundo;

public class Usuario 
{
	private String user;
	
	private String pass;
	
	private String categoria;
	
	public Usuario(String user, String pass, String categoria)
	{
		this.user = user;
		
		this.pass = pass;
		
		this.categoria = categoria;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getUser() {
		return user;
	}

	public String getPass() {
		return pass;
	}

	protected void setUser(String user) {
		this.user = user;
	}

	protected void setPass(String pass) {
		this.pass = pass;
	}
	
}
