package mundo;

import java.util.Date;

public class ReferenciaPersonal extends Persona{
	
	
	private String tipo;
	private String empresa;
	private String concepto;
	public final static String PERSONAL = "Personal";
	public final static String LABORAL = "Laboral";
	public final static String FAMILIAR = "Familiar";
	
	public ReferenciaPersonal(String nombre, String apellidos, int telefono,
			int identificacion, String sexo, String direccion, String ciudad, String departamento,
			String tipoP, String empresaP, String conceptoP) 
	{		
		super(identificacion, Persona.CEDULA, nombre, apellidos, sexo, null, "", "", -1, 
				telefono, -1, direccion, ciudad, departamento, "");
		
		tipo = tipoP;
		empresa = empresaP;
		concepto = conceptoP;
	}


	public String getTipo() {
		return tipo;
	}


	public void setTipo(String tipo) {
		this.tipo = tipo;
	}


	public String getEmpresa() {
		return empresa;
	}


	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}


	public String getConcepto() {
		return concepto;
	}


	public void setConcepto(String concepto) {
		this.concepto = concepto;
	}
	
	
}
