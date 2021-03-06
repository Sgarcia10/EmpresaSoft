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
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;

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
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import interfaz.liquidacion.DialogoNomina;
import interfaz.liquidacion.DialogoNovedadesDiasNoLaborados;
import mundo.Contrato;
import mundo.Empresa;
import mundo.empleado.Empleado;
import seguridad.EncriptadorPassword;

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
	private JMenu mnNomina;
	private JMenuItem mntmAgregarNovedades;
	private JMenuItem mntmDiasNoLaborados;
	private JMenu mnAgregarDevengados;
	private JMenuItem mntmOrdinariosHorasExtrasDiurnas;
	private JMenuItem mntmOrdinariosHorasExtrasNocturnas;
	private JMenuItem mntmOrdinariosRecargoNocturno;
	private JMenuItem mntmDominicalesHorasExtrasDiurnas;
	private JMenuItem mntmDominicalesHorasExtrasNocturnas;
	private JMenuItem mntmDominicalesRecargoNocturno;
	private JMenuItem mntmDominicalesDiasDominicalesY;
	private JMenu mnDevengadosOrdinarios;
	private JMenu mnDominicalesYFestivos;

	public InterfazNomina() {

		//Definir formato n�meros largos
		formatoNumeros = new DecimalFormat("#############");
		formatoDinero = new DecimalFormat("###,###,###,###.00");

		//

		setTitle("Liquidaci�n de N�mina");
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
		nombresEmpleado.setEditable(false);
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
		apellidosEmpleado.setEditable(false);
		panel_1.add(apellidosEmpleado);

		JLabel lblFechaDeNacimiento = new JLabel("C\u00E9dula:");
		lblFechaDeNacimiento.setBounds(168, 89, 105, 14);
		panel_1.add(lblFechaDeNacimiento);

		cedulaEmpleado = new JTextField();
		cedulaEmpleado.setColumns(10);
		cedulaEmpleado.setBounds(323, 86, 157, 20);
		cedulaEmpleado.setEditable(false);
		panel_1.add(cedulaEmpleado);

		JLabel lblFechaDeIngreso = new JLabel("Direcci\u00F3n:");
		lblFechaDeIngreso.setBounds(168, 120, 105, 14);
		panel_1.add(lblFechaDeIngreso);

		direccionEmpleado = new JTextField();
		direccionEmpleado.setColumns(10);
		direccionEmpleado.setBounds(323, 117, 157, 20);
		direccionEmpleado.setEditable(false);
		panel_1.add(direccionEmpleado);

		JLabel lblFechaDeAfiliacin = new JLabel("Telefono Fijo:");
		lblFechaDeAfiliacin.setBounds(168, 151, 135, 14);
		panel_1.add(lblFechaDeAfiliacin);

		telefenoFijoEmpleado = new JTextField();
		telefenoFijoEmpleado.setColumns(10);
		telefenoFijoEmpleado.setBounds(323, 148, 157, 20);
		telefenoFijoEmpleado.setEditable(false);
		panel_1.add(telefenoFijoEmpleado);

		JLabel lblSalarioBsico = new JLabel("Cargo:");
		lblSalarioBsico.setBounds(168, 218, 105, 14);
		panel_1.add(lblSalarioBsico);

		cargoEmpleado = new JTextField();
		cargoEmpleado.setColumns(10);
		cargoEmpleado.setBounds(323, 215, 157, 20);
		cargoEmpleado.setEditable(false);
		panel_1.add(cargoEmpleado);

		JButton btnLiquidacindeNomina = new JButton("Liquidaci�n de Nomina");
		btnLiquidacindeNomina.addActionListener(this);
		btnLiquidacindeNomina.setActionCommand("Liquidaci�n de N�mina");
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
		salarioTotalEmpleado.setEditable(false);
		panel_1.add(salarioTotalEmpleado);

		telefonoCelularEmpleado = new JTextField();
		telefonoCelularEmpleado.setColumns(10);
		telefonoCelularEmpleado.setBounds(323, 179, 157, 20);
		telefonoCelularEmpleado.setEditable(false);
		panel_1.add(telefonoCelularEmpleado);

		JLabel lblTelefonoCelular = new JLabel("Tel�fono Celular:");
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

		modeloTablaEmpleados = new DefaultTableModel()
		{

			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};

		modeloTablaEmpleados.addColumn("Nombre");
		modeloTablaEmpleados.addColumn("Indentificaci�n");

		TableColumn columnaNombre, columnaId;
		DefaultTableColumnModel headers; 

		//create and define columns 
		columnaNombre = new TableColumn(0); 
		columnaNombre.setHeaderValue("Nombre"); // set column name 
		columnaNombre.setPreferredWidth(150); //set column width 

		columnaId = new TableColumn(1); 
		columnaId.setHeaderValue("Indentificaci�n"); 
		columnaId.setPreferredWidth(50); 

		// A DefaultTableColumnModel object is created and the three 
		// TableColumn objects are added to it. 

		headers = new DefaultTableColumnModel(); 
		headers.addColumn(columnaNombre); 
		headers.addColumn(columnaId);  
		

		tablaEmpleados = new JTable(modeloTablaEmpleados, headers);
		tablaEmpleados.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaEmpleados.getTableHeader().setReorderingAllowed(false);

//		tablaEmpleados.getSelectionModel().addListSelectionListener(new ListSelectionListener()
//		{
//			public void valueChanged(ListSelectionEvent event) {
//				// do some actions here, for example
//				// print first column value from selected row
//				String id = tablaEmpleados.getValueAt(tablaEmpleados.getSelectedRow(), 1).toString();
//				System.out.println(id);
//				actualizarResumenDatosEmpleadoSeleccionado(id);
//			}
//		});
		
		tablaEmpleados.addMouseListener(new MouseAdapter() {
		    @Override
		    public void mouseClicked(MouseEvent evt) {
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

		mnNomina = new JMenu("N�mina");
		menuBar.add(mnNomina);

		mntmAgregarNovedades = new JMenuItem("Agregar");
		mnNomina.add(mntmAgregarNovedades);
		mntmAgregarNovedades.setActionCommand("Agregar Novedades");
		mntmAgregarNovedades.addActionListener(this);
		mnNomina.add(mntmAgregarNovedades);
		
//		mntmDiasNoLaborados = new JMenuItem("D�as No Laborados");
//		mntmDiasNoLaborados.setActionCommand("DiasNoLaborados");
//		mntmDiasNoLaborados.addActionListener(this);
//		mnAgregarNovedades.add(mntmDiasNoLaborados);
//
//		mnAgregarDevengados = new JMenu("Devengados");
//		mnNomina.add(mnAgregarDevengados);
//
//		mnDevengadosOrdinarios = new JMenu("Ordinarios");
//		mnAgregarDevengados.add(mnDevengadosOrdinarios);
//
//		mntmOrdinariosHorasExtrasDiurnas = new JMenuItem("Horas Extras Diurnas");
//		mntmOrdinariosHorasExtrasDiurnas.setActionCommand("OrdinariosHorasExtrasDiurnas");
//		mntmOrdinariosHorasExtrasDiurnas.addActionListener(this);
//		mnDevengadosOrdinarios.add(mntmOrdinariosHorasExtrasDiurnas);
//
//		mntmOrdinariosHorasExtrasNocturnas = new JMenuItem("Horas Extras Nocturnas");
//		mntmOrdinariosHorasExtrasNocturnas.setActionCommand("OrdinariosHorasExtrasNocturnas");
//		mntmOrdinariosHorasExtrasNocturnas.addActionListener(this);
//		mnDevengadosOrdinarios.add(mntmOrdinariosHorasExtrasNocturnas);
//
//		mntmOrdinariosRecargoNocturno = new JMenuItem("Recargo Nocturno");
//		mntmOrdinariosRecargoNocturno.setActionCommand("OrdinariosRecargoNocturno");
//		mntmOrdinariosRecargoNocturno.addActionListener(this);
//		mnDevengadosOrdinarios.add(mntmOrdinariosRecargoNocturno);
//
//		mnDominicalesYFestivos = new JMenu("Dominicales Y Festivos");
//		mnAgregarDevengados.add(mnDominicalesYFestivos);
//
//		mntmDominicalesHorasExtrasDiurnas = new JMenuItem("Horas Extras Diurnas");
//		mntmDominicalesHorasExtrasDiurnas.setActionCommand("DominicalesHorasExtrasDiurnas");
//		mntmDominicalesHorasExtrasDiurnas.addActionListener(this);
//		mnDominicalesYFestivos.add(mntmDominicalesHorasExtrasDiurnas);
//
//		mntmDominicalesHorasExtrasNocturnas = new JMenuItem("Horas Extras Nocturnas");
//		mntmDominicalesHorasExtrasDiurnas.setActionCommand("DominicalesHorasExtrasDirunas");
//		mntmDominicalesHorasExtrasDiurnas.addActionListener(this);
//		mnDominicalesYFestivos.add(mntmDominicalesHorasExtrasNocturnas);
//
//		mntmDominicalesRecargoNocturno = new JMenuItem("Recargo Nocturno");
//		mntmDominicalesRecargoNocturno.setActionCommand("DominicalesRecargoNocturno");
//		mntmDominicalesRecargoNocturno.addActionListener(this);
//		mnDominicalesYFestivos.add(mntmDominicalesRecargoNocturno);
//
//		mntmDominicalesDiasDominicalesY = new JMenuItem("D�as Dominicales y Festivos");
//		mntmDominicalesDiasDominicalesY.setActionCommand("DominicalesDiasDominicalesY");
//		mntmDominicalesDiasDominicalesY.addActionListener(this);
//		mnDominicalesYFestivos.add(mntmDominicalesDiasDominicalesY);

		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);

		JMenuItem mntmSobreLaAplicacin = new JMenuItem("Sobre la aplicaci\u00F3n");
		mnAbout.add(mntmSobreLaAplicacin);
		setSize(new Dimension(766, 574));

		//Cesar
		JPanel panel_Periodo = new JPanel();
		panel_Periodo.setBorder(new TitledBorder(null, "Per�odo", TitledBorder.LEADING, TitledBorder.TOP, null, null));
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

		radioButtonPeriodo1 = new JRadioButton("1-15", false);
		radioButtonPeriodo1.setActionCommand("1-15");
		radioButtonPeriodo1.setBackground(Color.WHITE);
		radioButtonPeriodo1.setBounds(6, 39, 65, 23);
		panel_Periodo.add(radioButtonPeriodo1);

		radioButtonPeriodo2 = new JRadioButton("16-30", false);
		radioButtonPeriodo2.setActionCommand("16-30");
		radioButtonPeriodo2.setBackground(Color.WHITE);
		radioButtonPeriodo2.setBounds(81, 39, 65, 23);
		panel_Periodo.add(radioButtonPeriodo2);

		Date dia =  new Date( );
//		System.err.println(dia.getDay() + "-" + dia.getDate()+ "-" + dia.toString()+ "-" + dia.toLocaleString());
		String[] d = dia.toLocaleString().split("/");
		int d1 = Integer.parseInt(d[0]);
		if( d1 > 15){
			radioButtonPeriodo2.setSelected(true);
		}
		else{
			radioButtonPeriodo1.setSelected(true);
		}

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
//				try {
//					 
//					String content = "This is the content to write into file";
//		 
//					File file = new File("./data/Persistencia/usuarios.properties");
//		 
//					// if file doesnt exists, then create it
//					if (!file.exists()) {
//						file.createNewFile();
//					}
//		 
//					FileWriter fw = new FileWriter(file.getAbsoluteFile(), true);
//					BufferedWriter bw = new BufferedWriter(fw);
//					PrintWriter out = new PrintWriter(bw);
//					out.println("hola2");
//					bw.close();
//		 
//					System.out.println("Done");
//		 
//				} catch (IOException e) {
//					e.printStackTrace();
//				}
				
				Properties prop = new Properties();
				InputStream inStream = null;
			 
				try {
			 
					inStream = new FileInputStream("./data/Persistencia/admin.properties");
					prop.load(inStream);
					System.out.println(prop.getProperty("admin.password"));
					// set the properties value
					
			 
				} catch (IOException io) {
					io.printStackTrace();
				} finally {
					if (inStream != null) {
						try {
							inStream.close();
						} catch (IOException e) {
							e.printStackTrace();
						}
					}
			 
				}
				
				try {
					EncriptadorPassword encripter = new EncriptadorPassword("2952450");
					String enc = encripter.encrypt("Conexsur2015");
					String dec = encripter.decrypt(enc);
					
					System.out.println("Conexsur2015"+" - "+enc+" - "+dec);
					
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
			control.getEmpresa().guardarEstadoEmpleados(Empresa.RUTA_ARCHIVO_PERSISTENCIA);
			super.dispose();
			System.out.println("se cerro correctamente el proyecto");
		}
		catch( Exception e)
		{
			setVisible( true );

			int respuesta = JOptionPane.showConfirmDialog(this, "Problemas guardando la informaci�n:\n"+e.getMessage() + "\n�Quiere cerrar el programa sin guardar?", "Error", JOptionPane.YES_NO_OPTION);
			if( respuesta == JOptionPane.YES_OPTION)
			{
				super.dispose();
			}

		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		System.out.println(command);
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
		else if (command.equals("Liquidaci�n de N�mina")){
			String periodo = darPeriodo();	

			if (tablaEmpleados.getSelectedRow() >= 0){
				DialogoNomina nomina = new DialogoNomina(this, control, periodo);
				nomina.setLocationRelativeTo(this);
//				nomina.setVisible(true);
			}
			else{
				JOptionPane.showMessageDialog(this, "Debe seleccionar un empleado", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if (command.equals("Agregar Novedades")){
			DialogoNovedadesDiasNoLaborados novedadesDias = new DialogoNovedadesDiasNoLaborados(this, control, null);
			novedadesDias.setLocationRelativeTo(this);
//			novedadesDias.setVisible(true);
		}

		else if (command.equals("OrdinariosHorasExtrasDiurnas")){

		}

		else if (command.equals("OrdinariosHorasExtrasNocturnas")){

		}

		else if (command.equals("OrdinariosRecargoNocturno")){

		}
		else if (command.equals("DominicalesHorasExtrasDiurnas")){

		}

		else if (command.equals("DominicalesRecargoNocturno")){

		}

		else if (command.equals("DominicalesDiasDominicalesY")){

		}


	}

	public String darPeriodo( ){
		int m = mesPeriodo.getMonth();
		String mes;
		switch ( m ) {
		case 0: mes = "enero"; break;
		case 1: mes = "febrero"; break;
		case 2: mes = "marzo"; break;
		case 3: mes = "abril"; break;
		case 4: mes = "mayo"; break;
		case 5: mes = "junio"; break;
		case 6: mes = "julio"; break;
		case 7: mes = "agosto"; break;
		case 8: mes = "septiembre"; break;
		case 9: mes = "octubre"; break;
		case 10: mes = "noviembre"; break;
		case 11: mes = "diciembre"; break;
		default:  mes = "enero"; break;
		}
		String periodo = botonesPeriodo.getSelection().getActionCommand();
		String year = "" + anoPeriodo.getValue();
		//		System.out.println(periodo + "/" + mes + "/" + year);
		return periodo + "/" + mes + "/" + year;
	}

	public void actualizarListaEmpleados(){

		ArrayList<Empleado> listaE = control.getEmpleados();
		modeloTablaEmpleados.setRowCount(0);

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
