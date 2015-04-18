package mundo;

public class Usuario 
{
	private String user;
	
	private String pass;
	
	public Usuario(String user, String pass)
	{
		this.user = user;
		
		this.pass = pass;
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
