package mundo.nomina;

import java.io.Serializable;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Cesantias implements Serializable {
	
	private final static long serialVersionUID = 200L;
	
	private double valor;
	
	private double valorFijo;

	private Date inicioContrato;
	
	private int numeroDiasAcumulados;
	
	private boolean cesantiasPagadas;
	
	private double[] ultimosTresSalarios;
	
	public Cesantias(double valorP, Date inicioContratoP){
		
		valor = valorP;
		inicioContrato = inicioContratoP;
		numeroDiasAcumulados = 0;
		cesantiasPagadas = false;
		ultimosTresSalarios = new double[3];
	}
	
	public void calcularAcumulado(double devengadoUltimaLiquidacion) throws Exception{
		
		actualizarUltimosTresSalarios(devengadoUltimaLiquidacion);
		
		int dias = 0;
		double parcial = 0;
		
		Date actual = new Date(); //Para saber año actual
		int anio = actual.getYear();
		int mes = actual.getMonth();
		int dia = actual.getDate();
		
		//Reiniciar cesantias
		if ( (mes == 6 && dia >= 1) || (mes == 11 && dia > 21)){  //se reinicia el estado de prima pagada con el nuevo semestre
			cesantiasPagadas = false;
		}
		
		//Determinar dias para calculo de cesantias
		Date referencia1 = new Date(anio + 1900, 0, 1); //crear fecha de referencia primer semestre
		
		if (inicioContrato.after(referencia1)){  //inicio contrato luego de enero
			
			dias = calcularDiasDesdeInicioDeContrato();  //se cuentan los dias desde inicio de contrato hasta hoy
		}
		
		else {  // si el empleado es antiguo
			dias = calcularDiasDesdeInicioDeAnio(); //Contar dias desde 1 de Enero
		}
		
		//Calculo de las cesantias basado en sueldos variables
		parcial = (devengadoUltimaLiquidacion * dias)/360;
		
		if (numeroDiasAcumulados == 0){
			numeroDiasAcumulados = dias;
			valor = parcial;
		}
		
		else{
			//se suma el aporte por la ultima nomina y se recalcula la porción del acumulado anterior para ajustarlo al promedio
			valor = ((valor * numeroDiasAcumulados)/dias) + parcial;  
			numeroDiasAcumulados = dias;  //se ajusta el numero de dias para tener proporcion entre dias acumulados y faltantes para la proxima nomina 
		}
		
		valorFijo = (devengadoUltimaLiquidacion * dias)/360;
		
		//Si se quiere dejar automático
//		if ( (mes == 11 && dia >= 30)){
//			super.liquidarCesantias();
//		}
		
	}
	
	public int calcularDiasDesdeInicioDeAnio(){
		
		Date date2 = new Date();  //fecha actual
		int anio = date2.getYear();
		
		Date date1 = new Date(anio + 1900, 0, 1);  //fecha inicio semestre
		
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
	
	public double liquidarCesantias(){
		
		double res = 0;
		
		if (ultimosTresSalarios[0] == ultimosTresSalarios[1]  && 
				ultimosTresSalarios[0] == ultimosTresSalarios[2]){
			
			res = valorFijo;
		}
		else{
			res = valor;
		}
		
		valor = 0;
		valorFijo = 0;
		numeroDiasAcumulados = 0;
		cesantiasPagadas = true;
		return res;
	}
	
	public double getValor() {
		return valor;
	}
	
	private void actualizarUltimosTresSalarios(double ultimo){
		ultimosTresSalarios[2] = ultimosTresSalarios[1];
		ultimosTresSalarios[1] = ultimosTresSalarios[0];
		ultimosTresSalarios[0] = ultimo;
	}
}
