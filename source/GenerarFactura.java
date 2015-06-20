

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

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
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
import com.itextpdf.text.Utilities;
import com.itextpdf.text.PageSize;

public class GenerarFactura {

	public static final String RUTA_FACTURAS = "./data/Facturas/Ventas/";
	public static final String RESOURCE = "./data/imagenes/";
	public static final int MAXIMO_ALTO = 792;
	public static final int MAXIMO_ANCHO = 612;
	private Venta venta;
	private DecimalFormat formatea;

	public GenerarFactura(Venta pVenta) throws MalformedURLException, DocumentException, IOException {
		venta = pVenta;
		generarPDF( );

	}

	private void generarPDF() throws MalformedURLException, DocumentException, IOException {
		// TODO Auto-generated method stub
		nuevoDocumento3();
		
	}

	private void nuevoDocumento3() throws DocumentException, MalformedURLException, IOException {
		// TODO Auto-generated method stub
		//Se obtienen los datos importantes para generar el PDF
		ArrayList<MedicamentoVendido> listaMedicamentos = venta.getMedicamentos();
		Cliente cliente = venta.getCliente();
		String id = venta.getId();
		Date fVenta = venta.getFechaVenta();
		Date fPago = venta.getFechaPago();
		String fechaVenta = fVenta.toLocaleString().split(" ")[0];
		String fechaPago = fPago.toLocaleString().split(" ")[0];
		String fechaFactura = fechaVenta.split("/")[0] + "-" +fechaVenta.split("/")[1]+ "-"  + fechaVenta.split("/")[2] +"-";
		String tipoVenta = (venta.isModificar())? "Contado" : "Crédito";
		//Generar PDF
		Document document = new Document();
		document.setPageSize(PageSize.LETTER);
		PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream(RUTA_FACTURAS+ fechaFactura+id+".pdf"));
		document.open();
		Image img = Image.getInstance(RESOURCE+"Formato_1_Pag.png");
		img.setAbsolutePosition((PageSize.LETTER.getWidth()- img.getScaledWidth()) / 2,(PageSize.LETTER.getHeight()	- img.getScaledHeight()) / 2);

		PdfContentByte canvas = writer.getDirectContentUnder();

		// Cantidad 29, 290 - No. Factura 477, 75 - Fecha Venta 477, 130
		//	FEcha Pago 477, 185 - Tipo Factura 477, 237 - Nombre 82, 175
		//	Identificacion 115, 195 - Dirección 89, 215 - Tel 89, 230 - Ciudad 345, 230
		//	Descripción 121, 305 - Precio Unitario 404, 305 - Subtotal 522, 305 - Total 507, 676
		int espacio = 12;
		int cont = 0;
		DecimalFormat formatea = new DecimalFormat("###,###.##");
		for( int i = 0; i < listaMedicamentos.size(); i++)
		{
			if( (i % 30) == 0)
			{
				cont = 0;
				document.newPage();
				canvas.addImage(img);
				canvas.setFontAndSize( BaseFont.createFont(), 12);

				//Datos Factura
				canvas.beginText(); // BT
				canvas.moveText( 477 , MAXIMO_ALTO - 80 );
				canvas.showText(id);
				canvas.endText();
				canvas.beginText(); // BT
				canvas.moveText( 477 , MAXIMO_ALTO - 135 );
				canvas.showText(fechaVenta);
				canvas.endText();
				canvas.beginText(); // BT
				canvas.moveText( 477 , MAXIMO_ALTO - 190 );
				canvas.showText(fechaPago);
				canvas.endText();
				canvas.beginText(); // BT
				canvas.moveText( 477 , MAXIMO_ALTO - 245 );
				canvas.showText(tipoVenta);
				canvas.endText();
				canvas.beginText(); // BT
				canvas.moveText( 82 , MAXIMO_ALTO - 180 );
				canvas.showText(cliente.getNombre());
				canvas.endText();
				canvas.beginText();
				canvas.moveText( 115 , MAXIMO_ALTO - 200 );
				canvas.showText(cliente.getId());
				canvas.endText();
				canvas.beginText();
				canvas.moveText( 89 , MAXIMO_ALTO - 220 );
				canvas.showText(cliente.getDireccion());
				canvas.endText();
				canvas.beginText();
				canvas.moveText( 89 , MAXIMO_ALTO - 237 );
				canvas.showText(cliente.getTelefono());
				canvas.endText();
				canvas.beginText();
				canvas.moveText( 345 , MAXIMO_ALTO - 237 );
				canvas.showText(cliente.getCiudad());
				canvas.endText();
			}
			MedicamentoVendido actual = listaMedicamentos.get(i);
			int cant = actual.getCantidad();
			String descripcion = actual.toString();
			double precioUnitario = actual.getPrecioUnitario();
			double subTotal = cant*precioUnitario;
			canvas.beginText(); // BT
			canvas.moveText(29 , MAXIMO_ALTO - 305 - (cont*espacio));
			canvas.showText(""+ cant);
			canvas.endText();
			canvas.beginText(); // BT
			canvas.moveText(121 , MAXIMO_ALTO - 305 - (cont*espacio));
			canvas.showText(descripcion);
			canvas.endText();
			canvas.beginText(); // BT
			canvas.moveText(400 , MAXIMO_ALTO - 305 - (cont*espacio));
			canvas.showText("$"+ formatea.format(precioUnitario));
			canvas.endText();
			canvas.beginText(); // BT
			canvas.moveText(518 , MAXIMO_ALTO - 305 - (cont*espacio));
			canvas.showText("$"+ formatea.format(subTotal));
			canvas.endText();
			cont++;
		}
		canvas.beginText(); // BT
		canvas.moveText(505 , MAXIMO_ALTO - 680 );
		canvas.showText("$"+ formatea.format(venta.getTotal()));
		canvas.endText();
		document.close();
	}
}
