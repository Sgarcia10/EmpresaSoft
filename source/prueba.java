import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;



public class prueba 
{
	public static void main(String[] args) {
		Date fechaActual =new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyyMMMMEEEE", Locale.US);
		System.out.println(""+format.format(fechaActual));
	}
}
