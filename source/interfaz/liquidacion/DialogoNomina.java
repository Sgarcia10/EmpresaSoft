package interfaz.liquidacion;

import interfaz.Control;
import interfaz.InterfazNomina;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;












import java.awt.Toolkit;

import javax.swing.JButton;
import javax.swing.border.LineBorder;

import Excepciones.NoExisteEmpleadoException;
import Excepciones.NominaNoEncontradaException;

import java.awt.Component;
import java.awt.Font;



public class DialogoNomina extends JDialog implements ActionListener, MouseListener
{
	private InterfazNomina principal;
	private Control control;
	private String periodo;
	private ArrayList<Integer> indices;
	private Date fecha;
	private int cont;
	private DecimalFormat formatea;
	private String titulo;
	private JPanel panel;
	private JButton btnModificar;
	private JPanel panel_Devengado;
	private JScrollPane scrollPaneNovedades;
	private JTable tableNovedades;
	private JTable tableDevengadoOrdinaria;
	private JTable tableDevengadoDominical;
	private JPanel panelDevengadoOtros;
	private JScrollPane scrollPaneDevengadoOtros;
	private JTable tableDevengadoOtros;
	private JPanel panel_Deducciones;
	private JPanel panelDeduccionesSeguridadSocial;
	private JScrollPane scrollPane;
	private JPanel panelDeduccionesOtras;
	private JScrollPane scrollPane_2;
	private JTable tableDeduccionesSeguridadSocial;
	private JTable tableDeduccionesOtras;
	private String mensajeErrorConNomina;
	private JPanel panelDevengadoPrestaciones;
	private JScrollPane scrollPaneDevengadoPrestaciones;
	private JTable tableDevengadoPrestaciones;
	private JLabel lblTotalDevengado;
	private JTextField textFieldTotalDevengado;
	private JTextField textFieldTotalDeducciones;
	private JLabel lblTotalDeducciones;
	private JTextField textFieldValorNetoAPagar;
	private JLabel lblValorNetoAPagar;
	private double totalDevengado;
	private double totalNovedades;
	private double totalDeducciones;
	private double totalAPagar;

	public DialogoNomina( InterfazNomina ventana, Control pControl, String pPeriodo) {
		
		super(null, java.awt.Dialog.ModalityType.TOOLKIT_MODAL);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoNomina.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		getContentPane().setBackground(Color.WHITE);
		principal = ventana;
		control = pControl;
		periodo = pPeriodo;
		totalDeducciones = 0;
		totalDevengado = 0;
		totalNovedades = 0;
		totalAPagar = 0;
		mensajeErrorConNomina = "El empleado seleccionado no posee la nómina seleccionada";
		//		titulo = "Horas Extras Diurnas";
		cont = 0;
		setTitle("Nómina Para Pago De Salarios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setBounds(100, 100, 1319, 564);


		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "El Barto CC 123456789 - " + periodo, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 1283, 503);
		getContentPane().add(panel);
		getContentPane().addMouseListener(this);

		//Panel Novedades

		JPanel panel_Novedades = new JPanel();
		panel_Novedades.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Novedades", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Novedades.setBackground(Color.WHITE);
		panel_Novedades.setBounds(10, 21, 1263, 104);
		panel_Novedades.setLayout(null);


		Object[] dataNovedades = { "", "",""};
		Object[] columnsNovedades = {"Período","Sueldo Básico","Tiempo", "Sueldo Período"};
		DefaultTableModel modNovedades = new DefaultTableModel(columnsNovedades, 0)
		{

			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};

		tableNovedades = new JTable(modNovedades);
		tableNovedades.getTableHeader().setReorderingAllowed(false);

		scrollPaneNovedades = new JScrollPane(tableNovedades);
		scrollPaneNovedades.setBounds(10, 21, 1243, 72);
		panel_Novedades.add(scrollPaneNovedades);

		panel.add(panel_Novedades);

		//Panel Devengado
		panel_Devengado = new JPanel();
		panel_Devengado.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Devengado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Devengado.setBackground(Color.WHITE);
		panel_Devengado.setBounds(10, 142, 1263, 134);
		panel.add(panel_Devengado);
		panel_Devengado.setLayout(null);

		JPanel panelDevengadoOrdinaria = new JPanel();
		panelDevengadoOrdinaria.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 0), "Ordinaria", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, null));
		panelDevengadoOrdinaria.setBackground(Color.WHITE);
		panelDevengadoOrdinaria.setBounds(10, 25, 360, 68);
		panel_Devengado.add(panelDevengadoOrdinaria);

		//Ordinaria
		Object[] dataDevengadoOrdinaria = { "", "",""};
		Object[] columnsDevengadoOrdinaria = {"Recargo Nocturno","Extra Diurno","Extra Nocturno"};
		DefaultTableModel modDevengadoOrdinaria = new DefaultTableModel(columnsDevengadoOrdinaria, 0)
		{

			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};

		tableDevengadoOrdinaria = new JTable(modDevengadoOrdinaria);
		tableDevengadoOrdinaria.getTableHeader().setReorderingAllowed(false);
		panelDevengadoOrdinaria.setLayout(null);

		JScrollPane scrollPaneDevengadoOrdinaria = new JScrollPane(tableDevengadoOrdinaria);
		scrollPaneDevengadoOrdinaria.setBounds(0, 21, 360, 36);
		panelDevengadoOrdinaria.add(scrollPaneDevengadoOrdinaria);

		//Dominical y Festivos

		JPanel panelDevengadoDominical = new JPanel();
		panelDevengadoDominical.setLayout(null);
		panelDevengadoDominical.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 0), "Dominical y Festivo", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, null));
		panelDevengadoDominical.setBackground(Color.WHITE);
		panelDevengadoDominical.setBounds(380, 25, 345, 68);
		panel_Devengado.add(panelDevengadoDominical);

		Object[] dataDevengadoDominical = { "", "",""};
		Object[] columnsDevengadoDominical = {"Recargo Nocturno","Extra Diurno","Extra Nocturno", "Dominical y Festivo"};
		DefaultTableModel modDevengadoDominical = new DefaultTableModel(columnsDevengadoDominical, 0)
		{

			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};
		tableDevengadoDominical = new JTable(modDevengadoDominical);
		tableDevengadoDominical.getTableHeader().setReorderingAllowed(false);

		JScrollPane scrollPaneDevengadoDominical = new JScrollPane(tableDevengadoDominical);
		scrollPaneDevengadoDominical.setBounds(0, 21, 345, 36);
		panelDevengadoDominical.add(scrollPaneDevengadoDominical);

		//Otros
		panelDevengadoOtros = new JPanel();
		panelDevengadoOtros.setLayout(null);
		panelDevengadoOtros.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 0), "Otros", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, null));
		panelDevengadoOtros.setBackground(Color.WHITE);
		panelDevengadoOtros.setBounds(735, 25, 249, 68);
		panel_Devengado.add(panelDevengadoOtros);

		Object[] dataDevengadoOtros = { "", "",""};
		Object[] columnsDevengadoOtros = {"Auxilio de Transporte","Comisiones"};
		DefaultTableModel modDevengadoOtros = new DefaultTableModel(columnsDevengadoOtros, 0)
		{

			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};

		tableDevengadoOtros = new JTable(modDevengadoOtros);
		tableDevengadoOtros.getTableHeader().setReorderingAllowed(false);

		scrollPaneDevengadoOtros = new JScrollPane(tableDevengadoOtros);
		scrollPaneDevengadoOtros.setBounds(0, 21, 249, 36);
		panelDevengadoOtros.add(scrollPaneDevengadoOtros);

		//Deducciones

		panel_Deducciones = new JPanel();
		panel_Deducciones.setLayout(null);
		panel_Deducciones.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Deducciones", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Deducciones.setBackground(Color.WHITE);
		panel_Deducciones.setBounds(10, 287, 1263, 134);
		panel.add(panel_Deducciones);

		panelDeduccionesSeguridadSocial = new JPanel();
		panelDeduccionesSeguridadSocial.setLayout(null);
		panelDeduccionesSeguridadSocial.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 0), "Seguridad Social", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, null));
		panelDeduccionesSeguridadSocial.setBackground(Color.WHITE);
		panelDeduccionesSeguridadSocial.setBounds(10, 25, 659, 68);
		panel_Deducciones.add(panelDeduccionesSeguridadSocial);

		//Seguridad Social
		Object[] dataDeduccionesSeguridadSocial = { "", "",""};
		Object[] columnsDeduccionesSeguridadSocial = {"Salud","Pensión","Pensión Voluntaria", "Solidaridad", "AFC"};
		DefaultTableModel modDeduccionesSeguridadSocial = new DefaultTableModel(columnsDeduccionesSeguridadSocial, 0)
		{

			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};

		tableDeduccionesSeguridadSocial = new JTable(modDeduccionesSeguridadSocial);
		tableDeduccionesSeguridadSocial.getTableHeader().setReorderingAllowed(false);

		scrollPane = new JScrollPane(tableDeduccionesSeguridadSocial);
		scrollPane.setBounds(0, 21, 659, 36);
		panelDeduccionesSeguridadSocial.add(scrollPane);

		// Otras Deducciones
		panelDeduccionesOtras = new JPanel();
		panelDeduccionesOtras.setLayout(null);
		panelDeduccionesOtras.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 0), "Otras", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, null));
		panelDeduccionesOtras.setBackground(Color.WHITE);
		panelDeduccionesOtras.setBounds(687, 25, 542, 68);
		panel_Deducciones.add(panelDeduccionesOtras);

		Object[] dataDeduccionesOtras = { "", "",""};
		Object[] columnsDeduccionesOtras = {"Retención","Juzgados","Préstamos", "Fondo de empleados"};
		DefaultTableModel modDeduccionesOtras = new DefaultTableModel(columnsDeduccionesOtras, 0)
		{

			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};

		tableDeduccionesOtras = new JTable(modDeduccionesOtras);
		tableDeduccionesOtras.getTableHeader().setReorderingAllowed(false);

		scrollPane_2 = new JScrollPane(tableDeduccionesOtras);
		scrollPane_2.setBounds(0, 21, 542, 36);
		panelDeduccionesOtras.add(scrollPane_2);
		
		lblTotalDeducciones = new JLabel("Total Deducciones");
		lblTotalDeducciones.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalDeducciones.setBounds(452, 111, 133, 14);
		panel_Deducciones.add(lblTotalDeducciones);
		
		textFieldTotalDeducciones = new JTextField();
		textFieldTotalDeducciones.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldTotalDeducciones.setEditable(false);
		textFieldTotalDeducciones.setBounds(609, 108, 156, 20);
		panel_Deducciones.add(textFieldTotalDeducciones);
		textFieldTotalDeducciones.setColumns(10);


		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(231, 469, 169, 23);
		panel.add(btnModificar);
		btnModificar.addActionListener(this);
		btnModificar.setActionCommand("Modificar");
		
		JButton btnPrima = new JButton("Liquidar Prima");
		btnPrima.setActionCommand("LiquidarPrima");
		btnPrima.setBounds(438, 469, 169, 23);
		panel.add(btnPrima);
		
		JButton btnCesantias = new JButton("Liquidar Cesantias");
		btnCesantias.setActionCommand("LiquidarCesantias");
		btnCesantias.setBounds(644, 469, 169, 23);
		panel.add(btnCesantias);
		
		panelDevengadoPrestaciones = new JPanel();
		panelDevengadoPrestaciones.setBounds(994, 25, 259, 68);
		panel_Devengado.add(panelDevengadoPrestaciones);
		panelDevengadoPrestaciones.setLayout(null);
		panelDevengadoPrestaciones.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 0), "Prestaciones", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, null));
		panelDevengadoPrestaciones.setBackground(Color.WHITE);
		
		
		Object[] dataDevengadoPrestaciones = { "", "",""};
		Object[] columnsDevengadoPrestaciones = {"Prima","Cesantías","Vacaciones"};
		DefaultTableModel modDevengadoPrestaciones = new DefaultTableModel(columnsDevengadoPrestaciones, 0)
		{

			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};

		tableDeduccionesOtras = new JTable(modDeduccionesOtras);
		tableDeduccionesOtras.getTableHeader().setReorderingAllowed(false);

		tableDevengadoPrestaciones = new JTable(modDevengadoPrestaciones);
		tableDevengadoPrestaciones.getTableHeader().setReorderingAllowed(false);

		scrollPaneDevengadoPrestaciones = new JScrollPane(tableDevengadoPrestaciones);
		scrollPaneDevengadoPrestaciones.setBounds(0, 21, 259, 36);
		panelDevengadoPrestaciones.add(scrollPaneDevengadoPrestaciones);
		
		lblTotalDevengado = new JLabel("Total Devengados");
		lblTotalDevengado.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTotalDevengado.setBounds(452, 105, 145, 19);
		panel_Devengado.add(lblTotalDevengado);
		
		textFieldTotalDevengado = new JTextField();
		textFieldTotalDevengado.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldTotalDevengado.setEditable(false);
		textFieldTotalDevengado.setBounds(609, 104, 151, 20);
		panel_Devengado.add(textFieldTotalDevengado);
		textFieldTotalDevengado.setColumns(10);
		
		lblValorNetoAPagar = new JLabel("Valor Neto A Pagar");
		lblValorNetoAPagar.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblValorNetoAPagar.setBounds(464, 432, 144, 26);
		panel.add(lblValorNetoAPagar);
		
		textFieldValorNetoAPagar = new JTextField();
		textFieldValorNetoAPagar.setFont(new Font("Tahoma", Font.BOLD, 14));
		textFieldValorNetoAPagar.setEditable(false);
		textFieldValorNetoAPagar.setBounds(620, 437, 155, 20);
		panel.add(textFieldValorNetoAPagar);
		textFieldValorNetoAPagar.setColumns(10);
		
		setLocationRelativeTo(null);
		
		try{
			actualizarInformacion( );
			setVisible(true);
		}

		catch( Exception e){
			
			JOptionPane.showMessageDialog(principal, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
			cerrar();
			
		}
		//		actualizarAbonos();
		//		actualizarNotas();
	}


	private void cerrar() {
		// TODO Auto-generated method stub
		this.setVisible(false);
		this.dispose();
//		System.out.println("Si está cerrando");
	}


	public void actualizarInformacion() throws NoExisteEmpleadoException, NominaNoEncontradaException {
		// TODO Auto-generated method stub
		actualizarPanelNovedades( );
		actualizarPanelDevengado( );
		actualizarPanelDeducciones( );
		actualizarTotal( );
	}


	private void actualizarPanelNovedades() throws NoExisteEmpleadoException, NominaNoEncontradaException{
		// TODO Auto-generated method stub

		double sueldoBasico = control.getNovedadesSueldoBasico(periodo);
		int tiempoPeriodo = control.getNovedadesTiempoPeriodo(periodo );
		double sueldoPeriodo = control.getNovedadesSueldoPeriodo(periodo );
		totalNovedades = sueldoPeriodo;
		DefaultTableModel model = ( DefaultTableModel) tableNovedades.getModel();
		model.addRow(new Object[]{periodo, sueldoBasico, tiempoPeriodo, sueldoPeriodo});
	}


	private void actualizarPanelDevengado() throws NoExisteEmpleadoException, NominaNoEncontradaException {
		// TODO Auto-generated method stub
		double totalOrdinaria = actualizarPanelDevengadoOridnaria();
		double totalDominical = actualizarPanelDevengadoDominical();
		double totalOtros = actualizarPanelDevengadoOtros();
		double totalPrestaciones = actualizarPanelDevengadoPrestaciones();
		
		totalDevengado = totalOrdinaria+totalDominical+totalOtros+totalPrestaciones;
		textFieldTotalDevengado.setText(""+totalDevengado);
	}


	private double actualizarPanelDevengadoPrestaciones() {
		// TODO Auto-generated method stub
		double totalPrima = control.getDevengadoPrestacionesTotalPrima(periodo);
		double totalCesantias = control.getDevengadoPrestacionesTotalCesantias(periodo);
		double totalVacaciones = control.getDevengadoPrestacionesTotalVacaciones(periodo);
		DefaultTableModel model = ( DefaultTableModel) tableDevengadoPrestaciones.getModel();
		model.addRow(new Object[]{totalPrima, totalCesantias, totalVacaciones});
		
		return totalPrima + totalCesantias + totalVacaciones;
	}


	private double actualizarPanelDevengadoOtros() throws NoExisteEmpleadoException, NominaNoEncontradaException {
		// TODO Auto-generated method stub
		double totalAuxilioTransporte = control.getDevengadoOtrosTotalAuxilioTransporte(periodo);
		double totalComisiones = control.getDevengadoOtrosTotalComisiones(periodo);
		DefaultTableModel model = ( DefaultTableModel) tableDevengadoOtros.getModel();
		model.addRow(new Object[]{totalAuxilioTransporte, totalComisiones});
		
		return totalAuxilioTransporte + totalComisiones;
	}


	private double actualizarPanelDevengadoDominical() throws NoExisteEmpleadoException, NominaNoEncontradaException{
		// TODO Auto-generated method stub
		double totalRecargoNocturno = control.getDevengadoDominicalTotalRecargoNocturno(periodo);
		double totalExtraDiurno = control.getDevengadoDominicalTotalExtraDiurno(periodo);
		double totalExtraNocturno = control.getDevengadoDominicalTotalExtraNocturno(periodo);
		double totalDominicalDias = control.getDevengadoDominicalTotalDominicalesFestivos(periodo);

		DefaultTableModel model = ( DefaultTableModel) tableDevengadoDominical.getModel();
		model.addRow(new Object[]{totalRecargoNocturno, totalExtraDiurno, totalExtraNocturno, totalDominicalDias});
		
		return totalDominicalDias + totalExtraDiurno + totalExtraNocturno + totalDominicalDias;
	}


	private double actualizarPanelDevengadoOridnaria() throws NoExisteEmpleadoException, NominaNoEncontradaException {
		// TODO Auto-generated method stub
		double totalRecargoNocturno = control.getDevengadoOrdinarioTotalRecargoNocturno(periodo);
		double totalExtraDiurno = control.getDevengadoOrdinarioTotalExtraDiurno(periodo);
		double totalExtraNocturno = control.getDevengadoOrdinarioTotalExtraNocturno(periodo);

		DefaultTableModel model = ( DefaultTableModel) tableDevengadoOrdinaria.getModel();
		model.addRow(new Object[]{totalRecargoNocturno, totalExtraDiurno, totalExtraNocturno});
		
		return totalExtraDiurno + totalExtraNocturno + totalRecargoNocturno;
	}


	private void actualizarPanelDeducciones() throws NoExisteEmpleadoException, NominaNoEncontradaException{
		// TODO Auto-generated method stub
		double totalSeguridadSocial = actualizarPanelDeduccionesSeguridadSocial();
		double totalOtros = actualizarPanelDeduccionesOtros();
		
		totalDeducciones = totalOtros + totalSeguridadSocial;
		textFieldTotalDeducciones.setText(""+totalDeducciones);
	}


	private double actualizarPanelDeduccionesOtros() throws NoExisteEmpleadoException, NominaNoEncontradaException{
		// TODO Auto-generated method stub
		double totalRetencion = control.getDeduccionesOtrasTotalRetencion(periodo);
		double totalJuzgados = control.getDeduccionesOtrasTotalJuzgados(periodo);
		double totalPrestamos = control.getDeduccionesOtrasTotalPrestamos(periodo);
		double totalFondoEmpleados = control.getDeduccionesOtrosTotalFondosEmpleados( periodo);

		DefaultTableModel model = ( DefaultTableModel) tableDeduccionesOtras.getModel();
		model.addRow(new Object[]{totalRetencion, totalJuzgados, totalPrestamos, totalFondoEmpleados});
	
		return totalRetencion + totalJuzgados + totalPrestamos + totalFondoEmpleados;
	}


	private double actualizarPanelDeduccionesSeguridadSocial() throws NoExisteEmpleadoException, NominaNoEncontradaException{
		// TODO Auto-generated method stub
		double totalSalud = control.getDeduccionesSeguridadSocialTotalSalud(periodo);
		double totalPension = control.getDeduccionesSeguridadSocialTotalPension(periodo);
		double totalPensionVoluntaria = control.getDeduccionesSeguridadSocialTotalPensionVoluntaria(periodo);
		double totalSolidaridad = control.getDeduccionesSeguridadSocialTotalSolidaridad( periodo);
		double totalAFC = control.getDeduccionesSeguridadSocialTotalAFC(periodo);

		DefaultTableModel model = ( DefaultTableModel) tableDeduccionesSeguridadSocial.getModel();
		model.addRow(new Object[]{totalSalud, totalPension, totalPensionVoluntaria, totalSolidaridad, totalAFC});
	
		return totalAFC + totalPension + totalPensionVoluntaria + totalSalud + totalSolidaridad;
	}


	private void actualizarTotal() {
		// TODO Auto-generated method stub
		totalAPagar = totalDevengado + totalNovedades - totalDeducciones;
		textFieldValorNetoAPagar.setText("" + totalAPagar);
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		System.out.println( command );
		if(command.equals("Agregar"))
		{

		}
		else if (command.equals("Modificar"))
		{

		}
		else if (command.equals("LiquidarPrima"))
		{
			liquidarPrima();
		}
		else if (command.equals("LiquidarCesantias"))
		{
			liquidarCesantias();
		}

	}


	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if( e.getButton( ) == MouseEvent.BUTTON1 )
		{
			int numClick =  e.getClickCount( );
			if( numClick > 1){
				System.out.println("Doble Click");
				DialogoNovedadesDiasNoLaborados novedadesDias = new DialogoNovedadesDiasNoLaborados(principal, control);
				novedadesDias.setLocationRelativeTo(principal);
//				novedadesDias.setVisible(true);
			}
		}
	}


	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	
	public void liquidarPrima(){
		double prima = control.liquidarPrima();
	}
	
	public void liquidarCesantias(){
		double cesantias = control.liquidarCesantias();
	}
}
