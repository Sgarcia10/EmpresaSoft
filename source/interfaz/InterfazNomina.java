package interfaz;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;
import java.text.DateFormatSymbols;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import interfaz.liquidacion.DialogoNomina;
import mundo.Contrato;
import mundo.Empresa;
import mundo.empleado.Empleado;

public class InterfazNomina extends JFrame implements ActionListener{
	private JTextField busquedaEmpleados;
	private JTextField nombresEmpleado;
	private JTextField apellidosEmpleado;
	private JTextField cedulaEmpleado;
	private JTextField direccionEmpleado;
	private JTextField telefenoFijoEmpleado;
	private JTextField cargoEmpleado;
	private JTextField salarioTotalEmpleado;
	private JTextField telefonoCelularEmpleado;
	
	private Control control;
	private int periodo;
	private JYearChooser anoPeriodo;
	private JMonthChooser mesPeriodo;
	private JRadioButton radioButtonPeriodo1;
	private JRadioButton radioButtonPeriodo2;
	private ButtonGroup botonesPeriodo;
	
	private JList listaEmpleados;
	private DefaultTableModel modeloTablaEmpleados;
	private JTable tablaEmpleados;
	
	private JLabel lblFoto;
	
	private DecimalFormat formatoNumeros;
	private DecimalFormat formatoDinero;
	private JMenu mnAgregar;
	private JMenu mnAgregarNovedades;
	private JMenuItem mntmDiasNoLaborados;
	private JMenu mnAgregarDevengados;
	private JMenuItem mntmOrdinariosHorasExtrasDiurnas;
	private JMenuItem mntmOrdinariosHorasExtrasNocturnas;
	private JMenuItem mntmOrdinariosRecargoNocturno;
	private JMenuItem mntmDominicalesHorasExtrasDirunas;
	private JMenuItem mntmDominicalesHorasExtrasNocturnas;
	private JMenuItem mntmDominicalesRecargoNocturno;
	private JMenuItem mntmDominicalesDiasDominicalesY;
	private JMenu mnDevengadosOrdinarios;
	private JMenu mnDominicalesYFestivos;
	
	public InterfazNomina() {
		
	//Definir formato números largos
		formatoNumeros = new DecimalFormat("#############");
		formatoDinero = new DecimalFormat("###,###,###,###.00");
		
	//

		setTitle("Liquidación de Nómina");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 798, 653);
		setPreferredSize(new Dimension(970, 580));;
		setResizable(true);
		setVisible(false);
		
		try {
			control = new Control();
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Informacion Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(441, 140, 500, 367);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel fotoEmpleado = new JPanel();
		fotoEmpleado.setBorder(new LineBorder(new Color(0, 0, 0)));
		fotoEmpleado.setBackground(Color.WHITE);
		fotoEmpleado.setBounds(10, 24, 138, 160);
		
		lblFoto = new JLabel("");
		panel_1.add(lblFoto);
		panel_1.add(fotoEmpleado);
		
		nombresEmpleado = new JTextField();
		nombresEmpleado.setBounds(323, 24, 157, 20);
		panel_1.add(nombresEmpleado);
		nombresEmpleado.setColumns(10);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(168, 24, 77, 14);
		panel_1.add(lblNombres);
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(168, 58, 89, 14);
		panel_1.add(lblApellidos);
		
		apellidosEmpleado = new JTextField();
		apellidosEmpleado.setColumns(10);
		apellidosEmpleado.setBounds(323, 55, 157, 20);
		panel_1.add(apellidosEmpleado);
		
		JLabel lblFechaDeNacimiento = new JLabel("C\u00E9dula:");
		lblFechaDeNacimiento.setBounds(168, 89, 105, 14);
		panel_1.add(lblFechaDeNacimiento);
		
		cedulaEmpleado = new JTextField();
		cedulaEmpleado.setColumns(10);
		cedulaEmpleado.setBounds(323, 86, 157, 20);
		panel_1.add(cedulaEmpleado);
		
		JLabel lblFechaDeIngreso = new JLabel("Direcci\u00F3n:");
		lblFechaDeIngreso.setBounds(168, 120, 105, 14);
		panel_1.add(lblFechaDeIngreso);
		
		direccionEmpleado = new JTextField();
		direccionEmpleado.setColumns(10);
		direccionEmpleado.setBounds(323, 117, 157, 20);
		panel_1.add(direccionEmpleado);
		
		JLabel lblFechaDeAfiliacin = new JLabel("Telefono Fijo:");
		lblFechaDeAfiliacin.setBounds(168, 151, 135, 14);
		panel_1.add(lblFechaDeAfiliacin);
		
		telefenoFijoEmpleado = new JTextField();
		telefenoFijoEmpleado.setColumns(10);
		telefenoFijoEmpleado.setBounds(323, 148, 157, 20);
		panel_1.add(telefenoFijoEmpleado);
		
		JLabel lblSalarioBsico = new JLabel("Cargo:");
		lblSalarioBsico.setBounds(168, 218, 105, 14);
		panel_1.add(lblSalarioBsico);
		
		cargoEmpleado = new JTextField();
		cargoEmpleado.setColumns(10);
		cargoEmpleado.setBounds(323, 215, 157, 20);
		panel_1.add(cargoEmpleado);
		
		JButton btnLiquidacindeNomina = new JButton("Liquidación de Nomina");
		btnLiquidacindeNomina.addActionListener(this);
		btnLiquidacindeNomina.setActionCommand("Liquidación de Nómina");
		btnLiquidacindeNomina.setBounds(157, 301, 163, 23);
		panel_1.add(btnLiquidacindeNomina);
		
		JButton btnVerMas = new JButton("Ver mas");
		btnVerMas.addActionListener(this);
		btnVerMas.setBounds(352, 301, 128, 23);
		btnVerMas.setActionCommand("Ver mas");
		panel_1.add(btnVerMas);
		
		JLabel lblSalarioTotal = new JLabel("Salario Total:");
		lblSalarioTotal.setBounds(168, 254, 105, 14);
		panel_1.add(lblSalarioTotal);
		
		salarioTotalEmpleado = new JTextField();
		salarioTotalEmpleado.setColumns(10);
		salarioTotalEmpleado.setBounds(323, 251, 157, 20);
		panel_1.add(salarioTotalEmpleado);
		
		telefonoCelularEmpleado = new JTextField();
		telefonoCelularEmpleado.setColumns(10);
		telefonoCelularEmpleado.setBounds(323, 179, 157, 20);
		panel_1.add(telefonoCelularEmpleado);
		
		JLabel lblTelefonoCelular = new JLabel("Telefono Celular:");
		lblTelefonoCelular.setBounds(168, 182, 135, 14);
		panel_1.add(lblTelefonoCelular);
		
		JPanel panelListaEmpleado = new JPanel();
		panelListaEmpleado.setBackground(Color.WHITE);
		panelListaEmpleado.setBorder(new TitledBorder(null, "Lista Empleados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panelListaEmpleado.setBounds(10, 11, 421, 498);
		panel.add(panelListaEmpleado);
		panelListaEmpleado.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setBounds(10, 52, 400, 401);
		panelListaEmpleado.add(scrollPane);
		
		modeloTablaEmpleados = new DefaultTableModel();
		
		modeloTablaEmpleados.addColumn("Nombre");
		modeloTablaEmpleados.addColumn("Indentificación");

		TableColumn columnaNombre, columnaId;
		DefaultTableColumnModel headers; 
		DefaultTableModel rows;	

		//create and define columns 
		columnaNombre = new TableColumn(0); 
		columnaNombre.setHeaderValue("Nombre"); // set column name 
		columnaNombre.setPreferredWidth(150); //set column width 

		columnaId = new TableColumn(1); 
		columnaId.setHeaderValue("Indentificación"); 
		columnaId.setPreferredWidth(50); 

		// A DefaultTableColumnModel object is created and the three 
		// TableColumn objects are added to it. 

		headers = new DefaultTableColumnModel(); 
		headers.addColumn(columnaNombre); 
		headers.addColumn(columnaId);  
		

		tablaEmpleados = new JTable(modeloTablaEmpleados, headers);

		tablaEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
	
		
		tablaEmpleados.getSelectionModel().addListSelectionListener(new ListSelectionListener(){
	        public void valueChanged(ListSelectionEvent event) {
	            // do some actions here, for example
	            // print first column value from selected row
	        	String id = tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 1).toString();
	            System.out.println(id);
	            actualizarResumenDatosEmpleadoSeleccionado(id);
	        }
	    });
		
//		listaEmpleados = new JList();
//		listaEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
//		listaEmpleados.setBackground(Color.WHITE);
//		listaEmpleados.addListSelectionListener(new ListSelectionListener() {
//
//			@Override
//			public void valueChanged(ListSelectionEvent e) {
//				if( listaEmpleados.getSelectedValue() != null){
//					int pos = listaEmpleados.getSelectedIndex();
//					actualizarResumenDatosEmpleadoSeleccionado(pos);
//				}
//				
//			}
//		});	
		scrollPane.setViewportView(tablaEmpleados);
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(10, 30, 46, 14);
		panelListaEmpleado.add(lblBuscar);
		
		busquedaEmpleados = new JTextField();
		busquedaEmpleados.setBounds(77, 27, 98, 20);
		panelListaEmpleado.add(busquedaEmpleados);
		busquedaEmpleados.setColumns(10);
		
		JButton btnBuscarEmpleados = new JButton("");
		btnBuscarEmpleados.setBounds(185, 24, 26, 23);
		panelListaEmpleado.add(btnBuscarEmpleados);
		btnBuscarEmpleados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btnBuscarEmpleados.setToolTipText("Buscar\r\n");
		btnBuscarEmpleados.setIcon(new ImageIcon("./data/icono_lupa.gif"));
		
		JButton btnAgregarEmpleados = new JButton("Agregar");
		btnAgregarEmpleados.setActionCommand("Agregar");
		btnAgregarEmpleados.addActionListener(this);
		btnAgregarEmpleados.setBounds(122, 464, 89, 23);
		panelListaEmpleado.add(btnAgregarEmpleados);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(442, 11, 157, 123);
		panel.add(panel_5);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setSize(140, 140);
		ImageIcon fot = new ImageIcon("./data/logo_empresa.jpg");
		ImageIcon icono = new ImageIcon(fot.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(icono);
		panel_5.add(lblNewLabel);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnArchivo = new JMenu("Archivo");
		menuBar.add(mnArchivo);
		
		JMenuItem mntmAbrir = new JMenuItem("Abrir");
		mntmAbrir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_A, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmAbrir);
		
		JMenuItem mntmGuardar = new JMenuItem("Guardar");
		mntmGuardar.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_G, InputEvent.CTRL_MASK));
		mnArchivo.add(mntmGuardar);
		
		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_F4, InputEvent.ALT_MASK));
		mnArchivo.add(mntmSalir);
		
		mnAgregar = new JMenu("Agregar");
		menuBar.add(mnAgregar);
		
		mnAgregarNovedades = new JMenu("Novedades");
		mnAgregar.add(mnAgregarNovedades);
		
		mntmDiasNoLaborados = new JMenuItem("Días No Laborados");
		mntmDiasNoLaborados.setActionCommand("DiasNoLaborados");
		mntmDiasNoLaborados.addActionListener(this);
		mnAgregarNovedades.add(mntmDiasNoLaborados);
		
		mnAgregarDevengados = new JMenu("Devengados");
		mnAgregar.add(mnAgregarDevengados);
		
		mnDevengadosOrdinarios = new JMenu("Ordinarios");
		mnAgregarDevengados.add(mnDevengadosOrdinarios);
		
		mntmOrdinariosHorasExtrasDiurnas = new JMenuItem("Horas Extras Diurnas");
		mntmOrdinariosHorasExtrasDiurnas.setActionCommand("OrdinariosHorasExtrasDiurnas");
		mntmOrdinariosHorasExtrasDiurnas.addActionListener(this);
		mnDevengadosOrdinarios.add(mntmOrdinariosHorasExtrasDiurnas);
		
		mntmOrdinariosHorasExtrasNocturnas = new JMenuItem("Horas Extras Nocturnas");
		mntmOrdinariosHorasExtrasNocturnas.setActionCommand("OrdinariosHorasExtrasNocturnas");
		mntmOrdinariosHorasExtrasNocturnas.addActionListener(this);
		mnDevengadosOrdinarios.add(mntmOrdinariosHorasExtrasNocturnas);
		
		mntmOrdinariosRecargoNocturno = new JMenuItem("Recargo Nocturno");
		mntmOrdinariosRecargoNocturno.setActionCommand("OrdinariosRecargoNocturno");
		mntmOrdinariosRecargoNocturno.addActionListener(this);
		mnDevengadosOrdinarios.add(mntmOrdinariosRecargoNocturno);
		
		mnDominicalesYFestivos = new JMenu("Dominicales Y Festivos");
		mnAgregarDevengados.add(mnDominicalesYFestivos);
		
		mntmDominicalesHorasExtrasDirunas = new JMenuItem("Horas Extras Dirunas");
		mntmDominicalesHorasExtrasDirunas.setActionCommand("DominicalesHorasExtrasDirunas");
		mntmDominicalesHorasExtrasDirunas.addActionListener(this);
		mnDominicalesYFestivos.add(mntmDominicalesHorasExtrasDirunas);
		
		mntmDominicalesHorasExtrasNocturnas = new JMenuItem("Horas Extras Nocturnas");
		mntmDominicalesHorasExtrasDirunas.setActionCommand("DominicalesHorasExtrasDirunas");
		mntmDominicalesHorasExtrasDirunas.addActionListener(this);
		mnDominicalesYFestivos.add(mntmDominicalesHorasExtrasNocturnas);
		
		mntmDominicalesRecargoNocturno = new JMenuItem("Recargo Nocturno");
		mntmDominicalesRecargoNocturno.setActionCommand("DominicalesRecargoNocturno");
		mntmDominicalesRecargoNocturno.addActionListener(this);
		mnDominicalesYFestivos.add(mntmDominicalesRecargoNocturno);
		
		mntmDominicalesDiasDominicalesY = new JMenuItem("Días Dominicales y Festivos");
		mntmDominicalesDiasDominicalesY.setActionCommand("DominicalesDiasDominicalesY");
		mntmDominicalesDiasDominicalesY.addActionListener(this);
		mnDominicalesYFestivos.add(mntmDominicalesDiasDominicalesY);
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmSobreLaAplicacin = new JMenuItem("Sobre la aplicaci\u00F3n");
		mnAbout.add(mntmSobreLaAplicacin);
		setSize(new Dimension(766, 574));
		
		//Cesar
		JPanel panel_Periodo = new JPanel();
		panel_Periodo.setBorder(new TitledBorder(null, "Período", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Periodo.setBackground(Color.WHITE);
		panel_Periodo.setBounds(604, 36, 341, 73);
		panel.add(panel_Periodo);
		panel_Periodo.setLayout(null);
		
		anoPeriodo = new JYearChooser();
		anoPeriodo.setBounds(278, 39, 53, 20);
		panel_Periodo.add(anoPeriodo);
		
		mesPeriodo = new JMonthChooser();
		mesPeriodo.setBackground(Color.WHITE);
		mesPeriodo.getComboBox().setBackground(Color.WHITE);
		mesPeriodo.setBounds(152, 39, 116, 20);
		panel_Periodo.add(mesPeriodo);
		
		radioButtonPeriodo1 = new JRadioButton("1-15", true);
		radioButtonPeriodo1.setActionCommand("1-15");
		radioButtonPeriodo1.setBackground(Color.WHITE);
		radioButtonPeriodo1.setBounds(6, 39, 65, 23);
		panel_Periodo.add(radioButtonPeriodo1);
		
		radioButtonPeriodo2 = new JRadioButton("16-30");
		radioButtonPeriodo2.setActionCommand("16-30");
		radioButtonPeriodo2.setBackground(Color.WHITE);
		radioButtonPeriodo2.setBounds(81, 39, 65, 23);
		panel_Periodo.add(radioButtonPeriodo2);
		
		botonesPeriodo = new ButtonGroup();
		botonesPeriodo.add(radioButtonPeriodo1);
		botonesPeriodo.add(radioButtonPeriodo2);
		
		DialogoLogin loggin = new DialogoLogin(this, control);
		loggin.setLocationRelativeTo(this);
		loggin.setVisible(true);
		
		actualizarListaEmpleados();
		
		pack();
	}
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					InterfazNomina frame = new InterfazNomina( );
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void cerrar()
	{
		try
		{
			//mundo.salvarProyecto("./data/cupiColegios.data");
			this.dispose();
			System.out.println("se cerro correctamente el proyecto");
		}
		catch (Exception e)
		{
			// : handle exception
		}
	}
	
	public void dispose( )
	{
		try
		{
			control.getEmpresa().guardarEstado(Empresa.RUTA_ARCHIVO_PERSISTENCIA);
			super.dispose();
			System.out.println("se cerro correctamente el proyecto");
		}
		catch( Exception e)
		{
			setVisible( true );

			int respuesta = JOptionPane.showConfirmDialog(this, "Problemas guardando la información:\n"+e.getMessage() + "\n¿Quiere cerrar el programa sin guardar?", "Error", JOptionPane.YES_NO_OPTION);
			if( respuesta == JOptionPane.YES_OPTION)
			{
				super.dispose();
			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		if(command.equals("Agregar"))
		{
			DialogoAgregarEmpleado agregarEmpleado = new DialogoAgregarEmpleado(control,this,-1);
			agregarEmpleado.setLocationRelativeTo(this);
			agregarEmpleado.setVisible(true);
		}
		else if (command.equals("Ver mas")){
			int pos = tablaEmpleados.getSelectedRow();
			
			if (pos > -1){
				DialogoAgregarEmpleado verEmpleado = new DialogoAgregarEmpleado(control,this,pos);
				verEmpleado.setLocationRelativeTo(this);
				verEmpleado.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(this, "Debe seleccionar un empleado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if (command.equals("Liquidación de Nómina")){
			String periodo = darPeriodo();	
			
			if (tablaEmpleados.getSelectedRow() >= 0){
				DialogoNomina nomina = new DialogoNomina(this, control, periodo);
				nomina.setLocationRelativeTo(this);
				nomina.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(this, "Debe seleccionar un empleado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		
	}
	
	public String darPeriodo( ){
		int m = mesPeriodo.getMonth();
		String mes;
		switch ( m ) {
				case 0: mes = "Enero"; break;
				case 1: mes = "Febrero"; break;
				case 2: mes = "Marzo"; break;
				case 3: mes = "Abril"; break;
				case 4: mes = "Mayo"; break;
				case 5: mes = "Junio"; break;
				case 6: mes = "Julio"; break;
				case 7: mes = "Agosto"; break;
				case 8: mes = "Septiembre"; break;
				case 9: mes = "Octubre"; break;
				case 10: mes = "Noviembre"; break;
				case 11: mes = "Diciembre"; break;
				default:  mes = "Enero"; break;
				}
		String periodo = botonesPeriodo.getSelection().getActionCommand();
		String year = "" + anoPeriodo.getValue();
		return periodo + "/" + mes + "/" + year;
	}
	
	public void actualizarListaEmpleados(){
		
		ArrayList<Empleado> listaE = control.getEmpleados();
		
		if( !listaE.isEmpty( ) ){
//			listaEmpleados.setListData( listaE.toArray( ) );
//			System.out.println(listaE.size());
//			listaEmpleados.setSelectedIndex( listaE.size() - 1);
//			actualizarResumenDatosEmpleadoSeleccionado(listaE.size() - 1);
			for(int i=0; i<listaE.size(); i++)
			{
				Empleado e = listaE.get(i);		
				double d = e.getIdentificacion();
				DecimalFormat format = new DecimalFormat("#");
				Object [] row = {e.toString().toUpperCase(), format.format(d)};
				modeloTablaEmpleados.addRow(row);
			}
			
		}
		
		
	}
	
	public void actualizarResumenDatosEmpleadoSeleccionado(String id)
	{
		Empleado e = control.seleccionarEmpleadoIdentificacion(id);
		Contrato c = e.getContrato();
		
		
		nombresEmpleado.setText(e.getNombres());
		apellidosEmpleado.setText(e.getApellidos());
		cedulaEmpleado.setText(String.valueOf(formatoNumeros.format(e.getIdentificacion())));
		direccionEmpleado.setText(e.getDireccion());
		telefenoFijoEmpleado.setText(String.valueOf(formatoNumeros.format(e.getTelefono())));
		cargoEmpleado.setText(c.getCargo());

		salarioTotalEmpleado.setText(String.valueOf(formatoDinero.format(c.getSueldoTotal())));
		telefonoCelularEmpleado.setText(String.valueOf(formatoNumeros.format(e.getCelular())));
		
		if (!(e.getFoto() == null) ){
			
			lblFoto.setBounds(10, 24, 138, 160);
			ImageIcon icono0 = e.getFoto();
			ImageIcon icon = new ImageIcon(icono0.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
			
	        lblFoto.setIcon(icon); // ADDED

	        Dimension imageSize = new Dimension(130,150); // ADDED
	        lblFoto.setPreferredSize(imageSize); // ADDED

	        lblFoto.revalidate(); // ADDED
	        lblFoto.repaint();
		}
		else {
			lblFoto.setIcon(null); // ADDED

	        lblFoto.revalidate(); // ADDED
	        lblFoto.repaint();
		}
	}
	
	public ArrayList<Empleado> getListaEmpleados(){
		return control.getEmpleados();
	}
}
