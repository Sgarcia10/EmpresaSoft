package mundo.nomina;

import java.io.Serializable;
import java.util.Date;

import mundo.Registro;
import mundo.Usuario;

public class Prestamo extends Registro implements Serializable {
	
	private final static long serialVersionUID = 200L;
	
	private Date fechaExpedicion;
	
	private double cantidad;
	
	private double saldo;
	
	private int numeroCuotas;
	
	private double valorCuota;
	
	private double interes;
	
	private boolean amortizado;
	
	public Prestamo(Usuario user, String concepto, double cantidadP, int numeroCuotasP, double interesP)
	{
		super(concepto, user);
		fechaExpedicion = new Date();
		cantidad = cantidadP;
		numeroCuotas=numeroCuotasP;
		interes=interesP;
		amortizado = false;
		valorCuota = Math.round(cantidad/numeroCuotasP);
	}

	public Date getFechaExpedicion() {
		return fechaExpedicion;
	}

	public void setFechaExpedicion(Date fechaExpedicion) {
		this.fechaExpedicion = fechaExpedicion;
	}

	public double getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public double getSaldo() {
		return saldo;
	}

	public void setSaldo(int saldo) {
		this.saldo = saldo;
	}

	public int getNumeroCuotas() {
		return numeroCuotas;
	}

	public void setNumeroCuotas(int numeroCuotas) {
		this.numeroCuotas = numeroCuotas;
	}

	public double getInteres() {
		return interes;
	}

	public void setInteres(double interes) {
		this.interes = interes;
	}

	public Double getValorCuota() {
		return valorCuota;
	}

	public boolean isAmortizado() {
		return amortizado;
	}	
	

}
