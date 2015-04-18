package interfaz;

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

import java.awt.Component;



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

	public DialogoNomina( InterfazNomina ventana, Control pControl, String pPeriodo) {
		super(null, java.awt.Dialog.ModalityType.TOOLKIT_MODAL);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoNomina.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		getContentPane().setBackground(Color.WHITE);
		principal = ventana;
		control = pControl;
		periodo = pPeriodo;
		//		titulo = "Horas Extras Diurnas";
		cont = 0;
		setTitle("Nómina Para Pago De Salarios");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setBounds(100, 100, 1050, 548);


		panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "El Barto CC 123456789 - " + periodo, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 1014, 487);
		getContentPane().add(panel);
		getContentPane().addMouseListener(this);

		//Panel Novedades

		JPanel panel_Novedades = new JPanel();
		panel_Novedades.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Novedades", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Novedades.setBackground(Color.WHITE);
		panel_Novedades.setBounds(10, 21, 994, 104);
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
		scrollPaneNovedades.setBounds(10, 21, 974, 72);
		panel_Novedades.add(scrollPaneNovedades);

		panel.add(panel_Novedades);

		//Panel Devengado
		panel_Devengado = new JPanel();
		panel_Devengado.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 1, true), "Devengado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Devengado.setBackground(Color.WHITE);
		panel_Devengado.setBounds(10, 142, 994, 104);
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
		panel_Deducciones.setBounds(10, 272, 994, 104);
		panel.add(panel_Deducciones);

		panelDeduccionesSeguridadSocial = new JPanel();
		panelDeduccionesSeguridadSocial.setLayout(null);
		panelDeduccionesSeguridadSocial.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 0), "Seguridad Social", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, null));
		panelDeduccionesSeguridadSocial.setBackground(Color.WHITE);
		panelDeduccionesSeguridadSocial.setBounds(10, 25, 567, 68);
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
		scrollPane.setBounds(0, 21, 567, 36);
		panelDeduccionesSeguridadSocial.add(scrollPane);

		// Otras Deducciones
		panelDeduccionesOtras = new JPanel();
		panelDeduccionesOtras.setLayout(null);
		panelDeduccionesOtras.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0), 0), "Otras", TitledBorder.CENTER, TitledBorder.BELOW_TOP, null, null));
		panelDeduccionesOtras.setBackground(Color.WHITE);
		panelDeduccionesOtras.setBounds(587, 25, 397, 68);
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
		scrollPane_2.setBounds(0, 21, 397, 36);
		panelDeduccionesOtras.add(scrollPane_2);


		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(235, 453, 169, 23);
		panel.add(btnModificar);
		btnModificar.addActionListener(this);
		btnModificar.setActionCommand("Modificar");

		actualizarInformacion( );

		//		actualizarAbonos();
		//		actualizarNotas();
	}


	public void actualizarInformacion() {
		// TODO Auto-generated method stub
		actualizarPanelNovedades( );
		actualizarPanelDevengado( );
		actualizarPanelDeducciones( );
		actualizarTotal( );
	}


	private void actualizarPanelNovedades() {
		// TODO Auto-generated method stub

		double sueldoBasico = control.getNovedadesSueldoBasico(periodo);
		int tiempoPeriodo = control.getNovedadesTiempoPeriodo(periodo );
		double sueldoPeriodo = control.getNovedadesSueldoPeriodo(periodo );

		DefaultTableModel model = ( DefaultTableModel) tableNovedades.getModel();
		model.addRow(new Object[]{periodo, sueldoBasico, tiempoPeriodo, sueldoPeriodo});
	}


	private void actualizarPanelDevengado() {
		// TODO Auto-generated method stub
		actualizarPanelDevengadoOridnaria();
		actualizarPanelDevengadoDominical();
		actualizarPanelDevengadoOtros();
	}


	private void actualizarPanelDevengadoOtros() {
		// TODO Auto-generated method stub
		double totalAuxilioTransporte = control.getDevengadoOtrosTotalAuxilioTransporte(periodo);
		double totalComisiones = control.getDevengadoOtrosTotalComisiones(periodo);

		DefaultTableModel model = ( DefaultTableModel) tableDevengadoOtros.getModel();
		model.addRow(new Object[]{totalAuxilioTransporte, totalComisiones});
	}


	private void actualizarPanelDevengadoDominical() {
		// TODO Auto-generated method stub
		double totalRecargoNocturno = control.getDevengadoDominicalTotalRecargoNocturno(periodo);
		double totalExtraDiurno = control.getDevengadoDominicalTotalExtraDiurno(periodo);
		double totalExtraNocturno = control.getDevengadoDominicalTotalExtraNocturno(periodo);
		double totalDominicalDias = control.getDevengadoDominicalTotalDominicalesFestivos(periodo);

		DefaultTableModel model = ( DefaultTableModel) tableDevengadoDominical.getModel();
		model.addRow(new Object[]{totalRecargoNocturno, totalExtraDiurno, totalExtraNocturno, totalDominicalDias});
	}


	private void actualizarPanelDevengadoOridnaria() {
		// TODO Auto-generated method stub
		double totalRecargoNocturno = control.getDevengadoOrdinarioTotalRecargoNocturno(periodo);
		double totalExtraDiurno = control.getDevengadoOrdinarioTotalExtraDiurno(periodo);
		double totalExtraNocturno = control.getDevengadoOrdinarioTotalExtraNocturno(periodo);

		DefaultTableModel model = ( DefaultTableModel) tableDevengadoOrdinaria.getModel();
		model.addRow(new Object[]{totalRecargoNocturno, totalExtraDiurno, totalExtraNocturno});
	}


	private void actualizarPanelDeducciones() {
		// TODO Auto-generated method stub
		actualizarPanelDeduccionesSeguridadSocial();
		actualizarPanelDeduccionesOtros();
	}


	private void actualizarPanelDeduccionesOtros() {
		// TODO Auto-generated method stub
		double totalRetencion = control.getDeduccionesOtrasTotalRetencion(periodo);
		double totalJuzgados = control.getDeduccionesOtrasTotalJuzgados(periodo);
		double totalPrestamos = control.getDeduccionesOtrasTotalPrestamos(periodo);
		double totalFondoEmpleados = control.getDeduccionesOtrosTotalFondosEmpleados( periodo);
				
		DefaultTableModel model = ( DefaultTableModel) tableDeduccionesOtras.getModel();
		model.addRow(new Object[]{totalRetencion, totalJuzgados, totalPrestamos, totalFondoEmpleados});
	}


	private void actualizarPanelDeduccionesSeguridadSocial() {
		// TODO Auto-generated method stub
		double totalSalud = control.getDeduccionesSeguridadSocialTotalSalud(periodo);
		double totalPension = control.getDeduccionesSeguridadSocialTotalPension(periodo);
		double totalPensionVoluntaria = control.getDeduccionesSeguridadSocialTotalPensionVoluntaria(periodo);
		double totalSolidaridad = control.getDeduccionesSeguridadSocialTotalSolidaridad( periodo);
		double totalAFC = control.getDeduccionesSeguridadSocialTotalAFC(periodo);
		
		DefaultTableModel model = ( DefaultTableModel) tableDeduccionesSeguridadSocial.getModel();
		model.addRow(new Object[]{totalSalud, totalPension, totalPensionVoluntaria, totalSolidaridad, totalAFC});
	}


	private void actualizarTotal() {
		// TODO Auto-generated method stub

	}


	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		System.out.println( command );
		if(command.equals("Agregar"))
		{

		}
		else if (command.equals("Modificar")){

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
				novedadesDias.setLocationRelativeTo(this);
				novedadesDias.setVisible(true);
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
}
