package mundo;

public class Deducciones 
{
	
	private int salarioBasico;
	
	private boolean auxilioTransporte;
	
	private double totalDevengado;
	
	private double totalDeducido;
		
	public Deducciones(Nomina nominaP)
	{
		salarioBasico = nominaP.getSalarioBasico();
		
		auxilioTransporte = nominaP.isAuxiloTransporte();
		
		totalDevengado = nominaP.getDevengado().getTotal();
	}
	
	private void liquidar()
	{
		totalDeducido = 0;
	}
	
	public int EPS()
	{
		return 0;
	}	
	
}
