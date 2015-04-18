package interfaz;

import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;

import javax.swing.ButtonGroup;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.border.TitledBorder;

import java.awt.Color;

import javax.swing.JToolBar;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.border.LineBorder;

import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JYearChooser;

import mundo.Empresa;
import mundo.ReferenciaPersonal;

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
	
	public InterfazNomina() {

		setTitle("Liquidación de Nómina");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(200, 50, 766, 544);
		setResizable(false);
		setVisible(false);
		
		control = new Control();
		
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Informacion Empleado", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(241, 145, 498, 353);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel fotoEmpleado = new JPanel();
		fotoEmpleado.setBorder(new LineBorder(new Color(0, 0, 0)));
		fotoEmpleado.setBackground(Color.WHITE);
		fotoEmpleado.setBounds(10, 24, 138, 172);
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
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBorder(new TitledBorder(null, "Lista Empleados", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_3.setBounds(10, 11, 221, 498);
		panel.add(panel_3);
		panel_3.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 52, 201, 401);
		panel_3.add(scrollPane);
		
		JList listaEmpleados = new JList();
		scrollPane.setRowHeaderView(listaEmpleados);
		
		JLabel lblBuscar = new JLabel("Buscar");
		lblBuscar.setBounds(10, 30, 46, 14);
		panel_3.add(lblBuscar);
		
		busquedaEmpleados = new JTextField();
		busquedaEmpleados.setBounds(77, 27, 98, 20);
		panel_3.add(busquedaEmpleados);
		busquedaEmpleados.setColumns(10);
		
		JButton btnBuscarEmpleados = new JButton("");
		btnBuscarEmpleados.setBounds(185, 24, 26, 23);
		panel_3.add(btnBuscarEmpleados);
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
		panel_3.add(btnAgregarEmpleados);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(242, 11, 157, 123);
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
		
		JMenu mnAbout = new JMenu("About");
		menuBar.add(mnAbout);
		
		JMenuItem mntmSobreLaAplicacin = new JMenuItem("Sobre la aplicaci\u00F3n");
		mnAbout.add(mntmSobreLaAplicacin);
		setSize(new Dimension(766, 574));
		
		//Cesar
		JPanel panel_Periodo = new JPanel();
		panel_Periodo.setBorder(new TitledBorder(null, "Período", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_Periodo.setBackground(Color.WHITE);
		panel_Periodo.setBounds(409, 36, 341, 73);
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
			DialogoAgregarEmpleado agregarEmpleado = new DialogoAgregarEmpleado(control);
			agregarEmpleado.setLocationRelativeTo(this);
			agregarEmpleado.setVisible(true);
		}
//		else if (command.equals("Ver mas")){
//			DialogoVerEmpleado verEmpleado = new DialogoVerEmpleado();
//			verEmpleado.setLocationRelativeTo(this);
//			verEmpleado.setVisible(true);
//		}
		else if (command.equals("Liquidación de Nómina")){
			String periodo = darPeriodo();	
			DialogoNomina nomina = new DialogoNomina(this, control, periodo);
			nomina.setLocationRelativeTo(this);
			nomina.setVisible(true);
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
		return periodo + " " + mes + ", " + year;
	}
}
