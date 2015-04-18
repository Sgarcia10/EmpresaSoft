package interfaz;

import javax.swing.JDialog;


import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTabbedPane;
import java.awt.Component;
import com.toedter.calendar.JDateChooser;

//import com.toedter.calendar.JCalendar;
//import com.toedter.calendar.JDateChooser;


public class DialogoVerEmpleado extends JDialog implements ActionListener{
	private JTextField nombreEmpleado;
	private JTextField apellidosEmpleado;
	private JTextField cedulaEmpleado;
	private JTextField direccionEmpleado;
	private JTextField telefonoEmpleado;
	private JTextField celularEmpleado;
	private JTextField correoEmpleado;
	private JTextField cargoEmpleado;
	private JTextField salarioFijo;
	private JTextField salarioVariable;
	private JTextField nombreHijo;
	private JTextField apellidosHijo;
	private JTextField cedulaHijo;
	private JTextField edadHijo;
	private JTextField nombrePareja;
	private JTextField apellidosPareja;
	private JTextField cedulaPareja;
	private JTextField edadPareja;
	private JTable table;
	private JTable tablaRefLaboral;
	private JTable tableRefPersonal;
	private JTextField nombreRefLaboral;
	private JTextField telefonoRefLaboral;
	private JTextField empresaRefLaboral;
	private JTextField conceptoRefLaboral;
	private JTextField nombreRefPersonal;
	private JTextField telefonoRefPersonal;
	private JTextField empresaRefPersonal;
	private JTextField conceptoRefPersonal;
	private JTextField auxilioTransporte;
	
//	private JDateChooser dateChooserFechaCompra;
	
	
	public DialogoVerEmpleado() {
		
		super(null, java.awt.Dialog.ModalityType.TOOLKIT_MODAL);
		
		setTitle("Agregar Empleado");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 717, 640);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setActionCommand("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(561, 556, 89, 23);
		panel.add(btnAceptar);
		
		JButton btnModificar = new JButton("Cancelar");
		btnModificar.setActionCommand("Modificar");
		btnModificar.addActionListener(this);
		btnModificar.setBounds(451, 556, 89, 23);
		panel.add(btnModificar);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setName("Informaci\u00F3n Personal");
		tabbedPane.setBounds(10, 11, 687, 534);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setForeground(Color.WHITE);
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Informaci\u00F3n Personal", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel fotoEmpleado = new JPanel();
		fotoEmpleado.setBorder(new LineBorder(new Color(0, 0, 0)));
		fotoEmpleado.setBackground(Color.WHITE);
		fotoEmpleado.setBounds(68, 30, 130, 150);
		panel_1.add(fotoEmpleado);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion Personal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(326, 11, 346, 484);
		panel_1.add(panel_5);
		
		nombreEmpleado = new JTextField();
		nombreEmpleado.setColumns(10);
		nombreEmpleado.setBounds(177, 49, 141, 20);
		panel_5.add(nombreEmpleado);
		
		apellidosEmpleado = new JTextField();
		apellidosEmpleado.setColumns(10);
		apellidosEmpleado.setBounds(177, 86, 141, 20);
		panel_5.add(apellidosEmpleado);
		
		cedulaEmpleado = new JTextField();
		cedulaEmpleado.setColumns(10);
		cedulaEmpleado.setBounds(177, 124, 141, 20);
		panel_5.add(cedulaEmpleado);
		
		direccionEmpleado = new JTextField();
		direccionEmpleado.setColumns(10);
		direccionEmpleado.setBounds(177, 279, 141, 20);
		panel_5.add(direccionEmpleado);
		
		telefonoEmpleado = new JTextField();
		telefonoEmpleado.setColumns(10);
		telefonoEmpleado.setBounds(177, 335, 141, 20);
		panel_5.add(telefonoEmpleado);
		
		celularEmpleado = new JTextField();
		celularEmpleado.setColumns(10);
		celularEmpleado.setBounds(177, 379, 141, 20);
		panel_5.add(celularEmpleado);
		
		correoEmpleado = new JTextField();
		correoEmpleado.setColumns(10);
		correoEmpleado.setBounds(177, 422, 141, 20);
		panel_5.add(correoEmpleado);
		
//		dateChooserFechaCompra = new JDateChooser();
//		dateChooserFechaCompra.setBounds(119, 128, 218, 20);
		
		JLabel label = new JLabel("Nombres:");
		label.setBounds(30, 52, 115, 14);
		panel_5.add(label);
		
		JLabel label_1 = new JLabel("Apellidos:");
		label_1.setBounds(30, 89, 95, 14);
		panel_5.add(label_1);
		
		JLabel label_2 = new JLabel("Cedula:");
		label_2.setBounds(30, 127, 95, 14);
		panel_5.add(label_2);
		
		JLabel label_3 = new JLabel("Direcci\u00F3n");
		label_3.setBounds(30, 282, 95, 14);
		panel_5.add(label_3);
		
		JLabel label_4 = new JLabel("Tel\u00E9fono Fijo:");
		label_4.setBounds(30, 338, 115, 14);
		panel_5.add(label_4);
		
		JLabel label_5 = new JLabel("Tel\u00E9fono Celular:");
		label_5.setBounds(30, 382, 115, 14);
		panel_5.add(label_5);
		
		JLabel label_6 = new JLabel("Correo Electr\u00F3nico");
		label_6.setBounds(30, 425, 135, 14);
		panel_5.add(label_6);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(30, 163, 135, 14);
		panel_5.add(lblSexo);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil:");
		lblEstadoCivil.setBounds(30, 200, 135, 14);
		panel_5.add(lblEstadoCivil);
		
		JComboBox sexoEmpleado = new JComboBox();
		sexoEmpleado.setEnabled(false);
		sexoEmpleado.addItem("Hombre");
		sexoEmpleado.addItem("Mujer");
		sexoEmpleado.setBounds(177, 160, 141, 20);
		panel_5.add(sexoEmpleado);
		
		JComboBox estadoCivilEmpleado = new JComboBox();
		estadoCivilEmpleado.setEnabled(false);
		estadoCivilEmpleado.addItem("Soltero(a)");
		estadoCivilEmpleado.addItem("Casado(a)");
		estadoCivilEmpleado.addItem("Divorciado(a)");
		estadoCivilEmpleado.setBounds(177, 197, 141, 20);
		panel_5.add(estadoCivilEmpleado);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setBounds(30, 242, 135, 14);
		panel_5.add(lblFechaDeNacimiento);
		
		JDateChooser fechaNacimientoEmpleado = new JDateChooser();
		fechaNacimientoEmpleado.getSpinner().setForeground(Color.BLACK);
		fechaNacimientoEmpleado.getSpinner().setEnabled(false);
		fechaNacimientoEmpleado.setEnabled(false);
		fechaNacimientoEmpleado.setToolTipText(" ");
		fechaNacimientoEmpleado.getSpinner().setToolTipText("");
		fechaNacimientoEmpleado.setBounds(177, 236, 144, 20);
		panel_5.add(fechaNacimientoEmpleado);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		tabbedPane.addTab("Informaci\u00F3n Familiar", null, panel_3, null);
		panel_3.setLayout(null);
		
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Hijos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(10, 182, 662, 313);
		panel_3.add(panel_6);
		
		JLabel label_7 = new JLabel("Nombres:");
		label_7.setBounds(10, 31, 104, 14);
		panel_6.add(label_7);
		
		JLabel label_8 = new JLabel("Apellidos:");
		label_8.setBounds(10, 73, 95, 14);
		panel_6.add(label_8);
		
		nombreHijo = new JTextField();
		nombreHijo.setColumns(10);
		nombreHijo.setBounds(155, 28, 141, 20);
		panel_6.add(nombreHijo);
		
		apellidosHijo = new JTextField();
		apellidosHijo.setColumns(10);
		apellidosHijo.setBounds(155, 70, 141, 20);
		panel_6.add(apellidosHijo);
		
		JLabel label_9 = new JLabel("No. Documento:");
		label_9.setBounds(10, 113, 104, 14);
		panel_6.add(label_9);
		
		cedulaHijo = new JTextField();
		cedulaHijo.setColumns(10);
		cedulaHijo.setBounds(155, 110, 141, 20);
		panel_6.add(cedulaHijo);
		
		JLabel label_10 = new JLabel("Fecha Nacimiento:");
		label_10.setBounds(10, 160, 104, 14);
		panel_6.add(label_10);
		
		JLabel label_11 = new JLabel("Edad:");
		label_11.setBounds(10, 199, 104, 14);
		panel_6.add(label_11);
		
		edadHijo = new JTextField();
		edadHijo.setColumns(10);
		edadHijo.setBounds(155, 196, 141, 20);
		panel_6.add(edadHijo);
		
		JButton btnAgregarHijo = new JButton("Agregar");
		btnAgregarHijo.setBounds(207, 238, 89, 23);
		panel_6.add(btnAgregarHijo);
		
		
		Object[] data = { "", "", ""};
		Object[] columns = {" ","Nombre","Edad"};
		DefaultTableModel mod = new DefaultTableModel(columns,0)
		{

			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};

		table = new JTable(mod);
		table.getColumnModel().getColumn(0).setPreferredWidth(30);
		table.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(337, 11, 315, 291);
		panel_6.add(scrollPane);
		
		JDateChooser fechaNacimientoHijo = new JDateChooser();
		fechaNacimientoHijo.getSpinner().setEnabled(false);
		fechaNacimientoHijo.setEnabled(false);
		fechaNacimientoHijo.setBounds(155, 154, 144, 20);
		panel_6.add(fechaNacimientoHijo);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pareja", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(10, 11, 662, 160);
		panel_3.add(panel_10);
		
		JLabel label_29 = new JLabel("Nombres:");
		label_29.setBounds(10, 31, 104, 14);
		panel_10.add(label_29);
		
		JLabel label_30 = new JLabel("Apellidos:");
		label_30.setBounds(327, 31, 95, 14);
		panel_10.add(label_30);
		
		nombrePareja = new JTextField();
		nombrePareja.setColumns(10);
		nombrePareja.setBounds(155, 28, 141, 20);
		panel_10.add(nombrePareja);
		
		apellidosPareja = new JTextField();
		apellidosPareja.setColumns(10);
		apellidosPareja.setBounds(511, 28, 141, 20);
		panel_10.add(apellidosPareja);
		
		JLabel label_31 = new JLabel("No. Documento:");
		label_31.setBounds(10, 68, 104, 14);
		panel_10.add(label_31);
		
		cedulaPareja = new JTextField();
		cedulaPareja.setColumns(10);
		cedulaPareja.setBounds(155, 65, 141, 20);
		panel_10.add(cedulaPareja);
		
		JLabel label_32 = new JLabel("Fecha Nacimiento:");
		label_32.setBounds(327, 68, 104, 14);
		panel_10.add(label_32);
		
		JLabel label_33 = new JLabel("Edad:");
		label_33.setBounds(10, 112, 104, 14);
		panel_10.add(label_33);
		
		edadPareja = new JTextField();
		edadPareja.setColumns(10);
		edadPareja.setBounds(155, 109, 141, 20);
		panel_10.add(edadPareja);
		
		JDateChooser fechaNacimientoPareja = new JDateChooser();
		fechaNacimientoPareja.getSpinner().setEnabled(false);
		fechaNacimientoPareja.setEnabled(false);
		fechaNacimientoPareja.setBounds(508, 68, 144, 20);
		panel_10.add(fechaNacimientoPareja);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		tabbedPane.addTab("Informaci\u00F3n Laboral", null, panel_2, null);
		panel_2.setLayout(null);
		
		JPanel panel_7 = new JPanel();
		panel_7.setLayout(null);
		panel_7.setBorder(new TitledBorder(null, "Informaci\u00F3n Laboral", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_7.setBackground(Color.WHITE);
		panel_7.setBounds(21, 11, 308, 473);
		panel_2.add(panel_7);
		
		JLabel label_12 = new JLabel("Salario Fijo:");
		label_12.setBounds(10, 70, 87, 14);
		panel_7.add(label_12);
		
		JLabel label_13 = new JLabel("Cargo:");
		label_13.setBounds(10, 31, 87, 14);
		panel_7.add(label_13);
		
		cargoEmpleado = new JTextField();
		cargoEmpleado.setColumns(10);
		cargoEmpleado.setBounds(154, 28, 131, 20);
		panel_7.add(cargoEmpleado);
		
		salarioFijo = new JTextField();
		salarioFijo.setColumns(10);
		salarioFijo.setBounds(154, 67, 131, 20);
		panel_7.add(salarioFijo);
		
		salarioVariable = new JTextField();
		salarioVariable.setColumns(10);
		salarioVariable.setBounds(155, 107, 130, 20);
		panel_7.add(salarioVariable);
		
		JLabel label_14 = new JLabel("Salario Variable: ");
		label_14.setBounds(10, 110, 115, 14);
		panel_7.add(label_14);
		
		JLabel lblTipoContrato = new JLabel("Tipo Contrato:");
		lblTipoContrato.setBounds(10, 204, 115, 14);
		panel_7.add(lblTipoContrato);
		
		JComboBox tipoContrato = new JComboBox();
		tipoContrato.setEnabled(false);
		tipoContrato.setBounds(154, 201, 131, 20);
		tipoContrato.addItem("Contrato Laboral");
		tipoContrato.addItem("Prestación de Servicios");
		tipoContrato.addItem("Contrato de Aprendizaje");
		panel_7.add(tipoContrato);
		
		JLabel label_17 = new JLabel("Fecha Inicio Contrato:");
		label_17.setBounds(10, 303, 137, 14);
		panel_7.add(label_17);
		
		JLabel label_18 = new JLabel("Fecha Fin Contrato:");
		label_18.setBounds(10, 356, 137, 14);
		panel_7.add(label_18);
		
		JLabel lblDuracinContrato = new JLabel("Duraci\u00F3n Contrato:");
		lblDuracinContrato.setBounds(10, 254, 137, 14);
		panel_7.add(lblDuracinContrato);
		
		JComboBox duracionContrato = new JComboBox();
		duracionContrato.setEnabled(false);
		duracionContrato.setBounds(154, 251, 131, 20);
		tipoContrato.addItem("Término Indefinido");
		duracionContrato.addItem("Término Fijo");
		panel_7.add(duracionContrato);
		
		JLabel lblAuxilioDeTransp = new JLabel("Auxilio de Transporte: ");
		lblAuxilioDeTransp.setBounds(10, 156, 137, 14);
		panel_7.add(lblAuxilioDeTransp);
		
		auxilioTransporte = new JTextField();
		auxilioTransporte.setColumns(10);
		auxilioTransporte.setBounds(155, 153, 130, 20);
		panel_7.add(auxilioTransporte);
		
		JDateChooser fechaInicioContrato = new JDateChooser();
		fechaInicioContrato.getSpinner().setEnabled(false);
		fechaInicioContrato.setEnabled(false);
		fechaInicioContrato.setBounds(154, 297, 131, 20);
		panel_7.add(fechaInicioContrato);
		
		JDateChooser fechaFinContrato = new JDateChooser();
		fechaFinContrato.getSpinner().setEnabled(false);
		fechaFinContrato.setEnabled(false);
		fechaFinContrato.setBounds(154, 350, 131, 20);
		panel_7.add(fechaFinContrato);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seguridad Social", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_12.setBackground(Color.WHITE);
		panel_12.setBounds(352, 11, 308, 247);
		panel_2.add(panel_12);
		
		JLabel lblArl = new JLabel("Pensiones:");
		lblArl.setBounds(10, 70, 87, 14);
		panel_12.add(lblArl);
		
		JLabel lblSalud = new JLabel("Salud:");
		lblSalud.setBounds(10, 31, 87, 14);
		panel_12.add(lblSalud);
		
		JLabel lblArl_1 = new JLabel("ARL:");
		lblArl_1.setBounds(10, 110, 115, 14);
		panel_12.add(lblArl_1);
		
		JComboBox saludEmpleado = new JComboBox();
		saludEmpleado.setEnabled(false);
		saludEmpleado.setBounds(154, 28, 131, 20);
		panel_12.add(saludEmpleado);
		
		JLabel label_37 = new JLabel("Fecha Afiliaci\u00F3n a SS:");
		label_37.setBounds(10, 210, 137, 14);
		panel_12.add(label_37);
		
		JComboBox pensionesEmpleado = new JComboBox();
		pensionesEmpleado.setEnabled(false);
		pensionesEmpleado.setBounds(154, 67, 131, 20);
		panel_12.add(pensionesEmpleado);
		
		JLabel lblSolidaridad = new JLabel("Solidaridad:");
		lblSolidaridad.setBounds(10, 156, 137, 14);
		panel_12.add(lblSolidaridad);
		
		JComboBox arlEmpleado = new JComboBox();
		arlEmpleado.setEnabled(false);
		arlEmpleado.setBounds(154, 107, 131, 20);
		panel_12.add(arlEmpleado);
		
		JComboBox solidaridadEmpleado = new JComboBox();
		solidaridadEmpleado.setEnabled(false);
		solidaridadEmpleado.setBounds(154, 153, 131, 20);
		panel_12.add(solidaridadEmpleado);
		
		JDateChooser fechaAfiliacionSS = new JDateChooser();
		fechaAfiliacionSS.getSpinner().setEnabled(false);
		fechaAfiliacionSS.setEnabled(false);
		fechaAfiliacionSS.setBounds(154, 204, 131, 20);
		panel_12.add(fechaAfiliacionSS);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		tabbedPane.addTab("Referencias", null, panel_11, null);
		panel_11.setLayout(null);
		
		JPanel panel_9 = new JPanel();
		panel_9.setLayout(null);
		panel_9.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Referencias Laborales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_9.setBackground(Color.WHITE);
		panel_9.setBounds(10, 207, 662, 288);
		panel_11.add(panel_9);
		
		nombreRefLaboral = new JTextField();
		nombreRefLaboral.setColumns(10);
		nombreRefLaboral.setBounds(154, 28, 179, 20);
		panel_9.add(nombreRefLaboral);
		
		telefonoRefLaboral = new JTextField();
		telefonoRefLaboral.setColumns(10);
		telefonoRefLaboral.setBounds(154, 67, 179, 20);
		panel_9.add(telefonoRefLaboral);
		
		empresaRefLaboral = new JTextField();
		empresaRefLaboral.setColumns(10);
		empresaRefLaboral.setBounds(155, 107, 178, 20);
		panel_9.add(empresaRefLaboral);
		
		JLabel label_23 = new JLabel("Empresa: ");
		label_23.setBounds(10, 110, 115, 14);
		panel_9.add(label_23);
		
		JLabel label_24 = new JLabel("Concepto:");
		label_24.setBounds(10, 148, 109, 14);
		panel_9.add(label_24);
		
		conceptoRefLaboral = new JTextField();
		conceptoRefLaboral.setColumns(10);
		conceptoRefLaboral.setBounds(155, 145, 178, 20);
		panel_9.add(conceptoRefLaboral);
		
		JLabel label_25 = new JLabel("Nombre:");
		label_25.setBounds(10, 31, 115, 14);
		panel_9.add(label_25);
		
		JLabel label_26 = new JLabel("Tel\u00E9fono :");
		label_26.setBounds(10, 70, 115, 14);
		panel_9.add(label_26);
		
		JLabel lblFecha = new JLabel("Fecha inicio contrato:");
		lblFecha.setBounds(10, 191, 141, 14);
		panel_9.add(lblFecha);
		
		JLabel lblFechaFinContrato = new JLabel("Fecha fin contrato:");
		lblFechaFinContrato.setBounds(10, 235, 141, 14);
		panel_9.add(lblFechaFinContrato);
		
		
		Object[] dataRefLab = { "", ""};
		Object[] columnsRefLab = {" ","Nombre"};
		DefaultTableModel modRL = new DefaultTableModel(columnsRefLab,0)
		{

			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};

		tablaRefLaboral = new JTable(modRL);
		tablaRefLaboral.getColumnModel().getColumn(0).setPreferredWidth(30);
		tablaRefLaboral.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane_1 = new JScrollPane(tablaRefLaboral);
		scrollPane_1.setBounds(371, 11, 281, 266);
		panel_9.add(scrollPane_1);
		
		JDateChooser fechaInicioContratoRefLaboral = new JDateChooser();
		fechaInicioContratoRefLaboral.getSpinner().setEnabled(false);
		fechaInicioContratoRefLaboral.setEnabled(false);
		fechaInicioContratoRefLaboral.setBounds(154, 185, 179, 20);
		panel_9.add(fechaInicioContratoRefLaboral);
		
		JDateChooser fechaFinContratoRefLaboral = new JDateChooser();
		fechaFinContratoRefLaboral.getSpinner().setEnabled(false);
		fechaFinContratoRefLaboral.setEnabled(false);
		fechaFinContratoRefLaboral.setBounds(154, 229, 179, 20);
		panel_9.add(fechaFinContratoRefLaboral);
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Referencias Personales", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(10, 11, 662, 185);
		panel_11.add(panel_8);
		
		nombreRefPersonal = new JTextField();
		nombreRefPersonal.setColumns(10);
		nombreRefPersonal.setBounds(154, 28, 179, 20);
		panel_8.add(nombreRefPersonal);
		
		telefonoRefPersonal = new JTextField();
		telefonoRefPersonal.setColumns(10);
		telefonoRefPersonal.setBounds(154, 67, 179, 20);
		panel_8.add(telefonoRefPersonal);
		
		empresaRefPersonal = new JTextField();
		empresaRefPersonal.setColumns(10);
		empresaRefPersonal.setBounds(155, 107, 178, 20);
		panel_8.add(empresaRefPersonal);
		
		JLabel label_15 = new JLabel("Empresa: ");
		label_15.setBounds(10, 110, 115, 14);
		panel_8.add(label_15);
		
		JLabel label_19 = new JLabel("Concepto:");
		label_19.setBounds(10, 148, 109, 14);
		panel_8.add(label_19);
		
		conceptoRefPersonal = new JTextField();
		conceptoRefPersonal.setColumns(10);
		conceptoRefPersonal.setBounds(155, 145, 178, 20);
		panel_8.add(conceptoRefPersonal);
		
		JLabel label_21 = new JLabel("Nombre:");
		label_21.setBounds(10, 31, 115, 14);
		panel_8.add(label_21);
		
		JLabel label_22 = new JLabel("Tel\u00E9fono :");
		label_22.setBounds(10, 70, 115, 14);
		panel_8.add(label_22);
		
		
		Object[] dataRefPer = { "", ""};
		Object[] columnsRefPer = {" ","Nombre"};
		DefaultTableModel modRP = new DefaultTableModel(columnsRefPer,0)
		{

			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};

		tableRefPersonal = new JTable(modRP);
		tableRefPersonal.getColumnModel().getColumn(0).setPreferredWidth(10);
		tableRefPersonal.getTableHeader().setReorderingAllowed(false);
		JScrollPane scrollPane_2 = new JScrollPane(tableRefPersonal);
		scrollPane_2.setBounds(366, 11, 286, 163);
		panel_8.add(scrollPane_2);
	}

@Override
public void actionPerformed(ActionEvent e) {
String command = e.getActionCommand();
	
	if(command.equals("Cancelar"))
	{
		this.dispose();
	}
	else if (command.equals("Aceptar")){
		agregarEmpleado();
	}
	
	
}

private void agregarEmpleado() {
	// TODO Auto-generated method stub
	
}
}
