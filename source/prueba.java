import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



public class prueba 
{
	public static void main(String[] args) 
	{
		
		int a;
		int b;
		int c;
		int f;
		
		
		
		double z;

		double x;
		
		Date fechaActual =new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMMMEEEE", Locale.US);
		System.out.println(""+format.format(fechaActual));
	}
}
