package mundo;

import java.util.Date;

public class Experiencia {

	private String empresa;
	private String cargo;
	private String tipoContrato;
	private Date fechaInicio;
	private Date fechaFin;
	
	public Experiencia(String cargoP, String empresaP, String tipoContratoP, Date fechaInicioP, Date fechaFinP){
		empresa = empresaP;
		cargo = cargoP;
		tipoContrato = tipoContratoP;
		fechaInicio = fechaInicioP;
		fechaFin = fechaFinP;
	}

	public String getEmpresa() {
		return empresa;
	}

	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getTipoContrato() {
		return tipoContrato;
	}

	public void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
	
	
}
