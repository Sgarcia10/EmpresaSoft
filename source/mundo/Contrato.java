package mundo;

import java.io.Serializable;
import java.util.Date;

public class Contrato implements Serializable
{
	private String cargo;
	
	private double sueldoBasico;
	
	private boolean auxilioTransporte;
		
	private int periodoLiquidacion;
	
	private  Date fechaInicio;
	
	private  String tipoContrato;
	
	private  Date fechaFin;
	
	private String duracionContrato;
	
	private int horasSemana;
	
	public final static double AUXILIO = 75000;
	
	public Contrato(String cargoP, double sueldoBasicoP, boolean auxilioTransporteP, int periodoLiquidacionP,
			Date fechaInicioP, String tipoContratoP, Date fechaFinP, String tipoSalarioP, int horasSemanaP)
	{
		cargo = cargoP;
		
		sueldoBasico = sueldoBasicoP;
		
		auxilioTransporte = auxilioTransporteP;
		
		periodoLiquidacion = periodoLiquidacionP;
		
		fechaInicio = fechaInicioP;
		
		fechaFin = fechaFinP;
		
		tipoContrato = tipoContratoP;
		
		duracionContrato = tipoSalarioP;
		
		horasSemana = horasSemanaP;
	}

	protected void setCargo(String cargo) {
		this.cargo = cargo;
	}

	protected void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}

	protected void setAuxilioTransporte(boolean auxilioTransporte) {
		this.auxilioTransporte = auxilioTransporte;
	}

	protected void setPeriodoLiquidacion(int periodoLiquidacion) {
		this.periodoLiquidacion = periodoLiquidacion;
	}

	protected void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	protected void setTipoContrato(String tipoContrato) {
		this.tipoContrato = tipoContrato;
	}

	protected void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}

	protected void setTipoSalario(String tipoSalario) {
		this.duracionContrato = tipoSalario;
	}

	protected void setHorasSemana(int horasSemana) {
		this.horasSemana = horasSemana;
	}

	public String getCargo() {
		return cargo;
	}

	public double getSueldoBasico() {
		return sueldoBasico;
	}
	
	public double getSueldoTotal() {
		double res = getSueldoBasico();
		if (auxilioTransporte){
			res = res + this.AUXILIO;
		}
		return res;
	}

	public boolean isAuxilioTransporte() {
		return auxilioTransporte;
	}

	public int getPeriodoLiquidacion() {
		return periodoLiquidacion;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public String getTipoContrato() {
		return tipoContrato;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public String getTipoSalario() {
		return duracionContrato;
	}

	public int getHorasSemana() {
		return horasSemana;
	}

}
