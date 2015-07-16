package mundo.nomina;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Prima implements Serializable {
	
	private final static long serialVersionUID = 200L;
	
	private double valor;

	private Date inicioContrato;
	
	private int numeroDiasAcumulados;
	
	private boolean primaPagada;
	
	public Prima(double valorP, Date inicioContratoP){
		
		valor = valorP;
		inicioContrato = inicioContratoP;
		numeroDiasAcumulados = 0;
		primaPagada = false;
	}
	
	public void calcularAcumulado(double devengadoUltimaLiquidacion) throws Exception{
		
		int dias = 0;
		double parcial = 0;
		
		Date actual = new Date(); //Para saber año actual
		int anio = actual.getYear();
		int mes = actual.getMonth();
		int dia = actual.getDate();
		
		if ( (mes == 6 && dia >= 1) || (mes == 11 && dia > 21)){  //se reinicia el estado de prima pagada con el nuevo semestre
			primaPagada = false;
		}
		
		Date referencia1 = new Date(anio + 1900, 0, 1); //crear fecha de referencia primer semestre
		Date referencia2 = new Date(anio + 1900, 5, 30); //crear referencia segundo semestre
		
		if (inicioContrato.after(referencia1)){  //inicio contrato luego de enero
			
			dias = calcularDiasDesdeInicioDeContrato();  //se cuentan los dias desde inicio de contrato hasta hoy
		}
		
		else {  // si el empleado es antiguo
			if (mes >= 0 && mes <=5){ //Esta en el primer semestre
				dias = calcularDiasDesdeInicioDeSemestre(0, 1); //Contar dias desde 1 de Enero
			}
			else{
				dias = calcularDiasDesdeInicioDeSemestre(5, 30); //Contar dias desde 30 de Junio
			}
		}
		
		parcial = (devengadoUltimaLiquidacion * dias)/360;
		
		if (numeroDiasAcumulados == 0){
			numeroDiasAcumulados = dias;
			valor = parcial;
		}
		
		else{
			//se suma el aporte por la ultima nomina y se recalcula la porción del acumulado anterior para ajustarlo al promedio
			valor = ((valor * numeroDiasAcumulados)/dias) + parcial;  
			numeroDiasAcumulados = numeroDiasAcumulados + dias;  //se ajusta el numero de dias para tener proporcion entre dias acumulados y faltantes para la proxima nomina 
		}
		
		
		//Si se quiere dejar automático
//		if ( (mes == 5 && dia >= 16) || (mes == 11 && dia >= 1)){
//			super.liquidarPrima();
//		}
		
	}
	
	public int calcularDiasDesdeInicioDeSemestre(int mes, int dia){
		
		Date date2 = new Date();  //fecha actual
		int anio = date2.getYear();
		
		Date date1 = new Date(anio + 1900, mes, dia);  //fecha inicio semestre
		
		long diff = date2.getTime() - date1.getTime();
	    int dias = (int) Math.round(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		return dias;
	}
	
	public int calcularDiasDesdeInicioDeContrato(){
		
		Date date2 = new Date();		
		Date date1 = inicioContrato;
		
		long diff = date2.getTime() - date1.getTime();
	    int dias = (int) Math.round(TimeUnit.DAYS.convert(diff, TimeUnit.MILLISECONDS));
		return dias;
	}
	
	public double liquidarPrima(){
		
		double res = valor;
		valor = 0;
		numeroDiasAcumulados = 0;
		primaPagada = true;
		return res;
	}
	
	public double getValor() {
		return valor;
	}
}
