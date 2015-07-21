package reporte;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.RoundingMode;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.itextpdf.testutils.ITextTest;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.Rectangle;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.ColumnText;
import com.itextpdf.text.pdf.PdfContentByte;
import com.itextpdf.text.pdf.PdfImportedPage;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.PageSize;


public class GenerarRecibo 
{
    // -----------------------------------------------------------------
    // Constantes y Atributos
    // -----------------------------------------------------------------
	
	public static byte[] USER = "Hello".getBytes();
	public static byte[] OWNER = "World".getBytes();
    /**
     * Ruta del pdf generado
     */
	public static final String RUTA_PDF = "./data/Reporte/";
	
    /**
     * Ruta de la plantilla 
     */
	public static final String RUTA_PLANTILLA = "./data/Reporte/Plantilla/plantilla.pdf";
	
    /**
     * Nombre del archivo
     */
	public static final String nombre = "Recibos";
	
    /**
     * Tamaño del documento
     */
	private float ancho; 	//Ancho del documento
	
	private float alto; 	//Alto del documento
	
    /**
     * Espacio
     */
	private int space = -10;
	
    /**
     * Total Devengado
     */
	private double totalDevengado;
	
    /**
     * Total Deducciones
     */
	private double totalDeducciones;
		
	private String empleado;
	
	private String deveng;
	
	private String deducc; 
    
	
	
	public GenerarRecibo (String pEmpleado, String pDevengado, String pDeducciones) throws MalformedURLException, DocumentException, IOException
	{
		empleado = pEmpleado;
		deveng = pDevengado;
		deducc = pDeducciones;
		nuevoDocumento();
	}
	
	private void nuevoDocumento () throws MalformedURLException, DocumentException, IOException
	{	
		//Create a Document (1)
		PdfReader reader = new PdfReader(RUTA_PLANTILLA);
		tamañoPlantilla(reader);
		Document document = new Document(new Rectangle(ancho,alto));
			
		//Get a PdfWriter instance (2)
		FileOutputStream out = new FileOutputStream(RUTA_PDF + nombre + ".pdf");
		PdfWriter writer = PdfWriter.getInstance(document, out);	
		
		writer.setEncryption(USER, OWNER,PdfWriter.ALLOW_PRINTING, PdfWriter.STANDARD_ENCRYPTION_128);
		
		//Open the document (3)
		document.open();
		
		//Add content (4)		
		PdfContentByte canvas = writer.getDirectContent();
		PdfImportedPage page;
			
		BaseFont bf = BaseFont.createFont(BaseFont.HELVETICA,"",BaseFont.EMBEDDED);
		BaseFont bf_bold = BaseFont.createFont(BaseFont.HELVETICA_BOLD,"",BaseFont.EMBEDDED);
		
		page = writer.getImportedPage(reader, 1);
		canvas.addTemplate(page, 1f, 0, 0, 1, 0, 0);
		
		info(canvas,bf);
		empleado(canvas,bf);
		devengado(canvas, bf, deveng);
		deducciones(canvas, bf, deducc);
		total(canvas,bf_bold);
			
		//Close document (5)
		document.close();			
	}
	
    private void tamañoPlantilla (PdfReader reader)
	{
		Rectangle tamaño1 = reader.getPageSize(1);
		ancho = tamaño1.getRight();
		alto = tamaño1.getTop();
	}

	// -----------------------------------------------------------------
    // Canvas
    // -----------------------------------------------------------------
	
    /**
     * Información del recibo
     */
	private void info(PdfContentByte canvas, BaseFont bf)
	{
		//Fecha
		canvas.beginText();
		canvas.setFontAndSize(bf, 7);;
		canvas.moveText( ancho - 130 , alto -71 );
		canvas.showText( fecha() );
		canvas.endText();
		
		//Periodo de pago 
		canvas.beginText();
		canvas.setFontAndSize(bf, 7);;
		canvas.moveText( ancho - 130 , alto -71 + space);
		canvas.showText( "QUINCENAL" );
		canvas.endText();
		
		//Forma de Pago
		canvas.beginText();
		canvas.setFontAndSize(bf, 7);;
		canvas.moveText( ancho - 130 , alto -71 + 2*space);
		canvas.showText( "EFECTIVO");
		canvas.endText();
			
	}
			
    /**
     * Datos empleado
     */
	private void empleado(PdfContentByte canvas, BaseFont bf)
	{
		int sangria = 67;
		int inicio = (int)(alto - 84);

		String[] empleado1 = empleado.split("/");
		for(int i = 0; i < empleado1.length; i++)
		{	
			canvas.beginText();
			canvas.setFontAndSize(bf, 8);;
			canvas.moveText( sangria , inicio + (i*space));
			canvas.showText(empleado1[i]);
			canvas.endText();		
		}			
	}
	
    /**
     * Devengado
     */
	private void devengado(PdfContentByte canvas, BaseFont bf, String deveng)
	{
		int sangria = 76;
		int inicio = (int) (alto - 149);
		
		DecimalFormat formateador = new DecimalFormat("$ ###,###.##");
		
		String[] devengados = deveng.split("-");
		for(int i = 0; i < devengados.length; i++)
		{
			String[] actual = (devengados[i]).split("/");
			
			String cantidad1 = String.format("%03d%n",Integer.parseInt(actual[0]));
			String cantidad = String.format("%1$-15s",cantidad1);
			
			String concepto = String.format("%1$-25s",actual[1]);
			
			String valor1 = formateador.format(Integer.parseInt(actual[2]));
			String valor = String.format("%1$40s",valor1);
			
			canvas.beginText();
			canvas.setFontAndSize(bf, 8);;
			canvas.moveText( sangria , inicio + (i*space));
			canvas.showText(cantidad + concepto + valor);
			canvas.endText();		
			
			totalDevengado+=Integer.parseInt(actual[2]);
		}
		
		String total_devengado = formateador.format(totalDevengado);
		
		canvas.beginText();
		canvas.setFontAndSize(bf, 8);;
		canvas.moveText( 270 , 122);
		canvas.showText( total_devengado);
		canvas.endText();		
		
		canvas.beginText();
		canvas.setFontAndSize(bf, 8);;
		canvas.moveText( 520 , 70);
		canvas.showText( total_devengado);
		canvas.endText();	
	}
	
    /**
     * Deducciones
     */
	private void deducciones(PdfContentByte canvas, BaseFont bf, String deducc)
	{
		int sangria = 341;
		int inicio = (int) (alto - 149);
		
		DecimalFormat formateador = new DecimalFormat("$ ###,###.##");
		
		String[] deducciones = deducc.split("-");
		for(int i = 0; i < deducciones.length; i++)
		{
			String[] actual = (deducciones[i]).split("/");
			
			String cantidad1 = String.format("%03d%n",Integer.parseInt(actual[0]));
			String cantidad = String.format("%1$-15s",cantidad1);
			
			String concepto = String.format("%1$-25s",actual[1]);
			
			String valor1 = formateador.format(Integer.parseInt(actual[2]));
			String valor = String.format("%1$45s",valor1);
			
			canvas.beginText();
			canvas.setFontAndSize(bf, 8);;
			canvas.moveText( sangria , inicio + (i*space));
			canvas.showText(cantidad + concepto + valor);
			canvas.endText();		
			
			totalDeducciones+=Integer.parseInt(actual[2]);
		}
		
		String total_deducciones= formateador.format(totalDeducciones);
		
		canvas.beginText();
		canvas.setFontAndSize(bf, 8);;
		canvas.moveText( 540 , 122);
		canvas.showText( total_deducciones);
		canvas.endText();	
		
		canvas.beginText();
		canvas.setFontAndSize(bf, 8);;
		canvas.moveText( 520 , 60);
		canvas.showText( total_deducciones);
		canvas.endText();	
		
	}
	
	
    /**
     * Total
     */
	private void total(PdfContentByte canvas, BaseFont bf_bold)
	{
		DecimalFormat formateador = new DecimalFormat("$ ###,###.##");
		int total = (int) (totalDevengado - totalDeducciones);
		String totalNomina = formateador.format(total);
			
		canvas.beginText();
		canvas.setFontAndSize(bf_bold, 8);;
		canvas.moveText( ancho - 100 , 42 );
		canvas.showText( totalNomina );
		canvas.endText();
		
		String numeroEnLetras = NumberToLetter.convertNumberToLetter(total);
		
		canvas.beginText();
		canvas.setFontAndSize(bf_bold, 8);
		canvas.moveText( 135 , 109 );
		canvas.showText("*** " + numeroEnLetras + " M/CTE***");
		canvas.endText();
	}	
	
    // -----------------------------------------------------------------
    // Métodos auxiliares
    // -----------------------------------------------------------------
	
    /**
     * Formato de fecha
     */
	private String fecha ()
	{
		Date hoy = new Date();
		SimpleDateFormat format = new SimpleDateFormat("MMMM dd, yyyy - (HH:mm:ss aa)");
		String fecha = format.format(hoy);
		return fecha;		
	}	
	
}
