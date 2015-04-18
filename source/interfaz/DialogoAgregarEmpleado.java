package interfaz;

import javax.swing.JDialog;



import javax.swing.JPanel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;

import java.awt.Color;

import javax.swing.border.LineBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTabbedPane;

import mundo.Experiencia;
import mundo.Hijo;
import mundo.Persona;
import mundo.ReferenciaPersonal;

import java.awt.Component;
import java.util.ArrayList;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

//import com.toedter.calendar.JCalendar;
//import com.toedter.calendar.JDateChooser;


public class DialogoAgregarEmpleado extends JDialog implements ActionListener{
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
	private JTextField nombrePareja;
	private JTextField apellidosPareja;
	private JTextField cedulaPareja;
	private JTable table;
	private JTable tableReferencias;
	private JTable tableExperiencia;
	private JTextField nombreReferencia;
	private JTextField telefonoReferencia;
	private JTextField empresaRefPersonal;
	private JTextField conceptoRefPersonal;
	private JTextField auxilioTransporte;
	private InterfazNomina interfaz;
	private JComboBox sexoEmpleado;
	private JComboBox estadoCivilEmpleado;
	private JDateChooser fechaNacimientoEmpleado;
	
	private JComboBox tipoContrato;
	private JComboBox duracionContrato;
	private JComboBox tipoContratoExperiencia;
	
	private JDateChooser fechaInicioContrato;
	private JDateChooser fechaFinContrato;
	
	
	private JDateChooser fechaNacimientoHijo;
	private JTextField telefonoPareja;
	private JTextField direccionPareja;
	private JTextField ciudadPareja;
	private JTextField ciudadEmpleado;
	private JTextField direccionHijos;
	private JTextField apellidosReferencia;
	private JTextField direccionReferencia;
	private JTextField ciudadReferencia;
	private JTextField documentoReferencia;
	private JTextField empresaExperiencia;
	private JTextField cargoExperiencia;
	private JComboBox tipoReferencia;
	private JComboBox sexoReferencia;
	
	private JButton btnAgregarReferencia;
	private JButton btnNuevaReferencia;
	private JButton btnEditarReferencia;
	private JButton btnEliminarReferencia;
	
	
	private DefaultTableModel modRP;
	private DefaultTableModel modExp;
	
	
	private ListSelectionListener listenerReferencias;
	
	private Control control;
	private JButton btnAgregarExperiencia;
	private JButton btnNuevaExperiencia;
	private JButton btnEliminarExperiencia;
	private JButton btnEditarExperiencia;
	
	private String[] tipoContratoOpciones = {"Laboral", "Prestación de Servicios", "Aprendizaje"};
	private String[] tipoReferenciaOpciones = {ReferenciaPersonal.FAMILIAR, ReferenciaPersonal.LABORAL, ReferenciaPersonal.PERSONAL};
	private JDateChooser fechaInicioExperiencia;
	private JDateChooser fechafinExperiencia;
	private JScrollPane scrollPane_2;
	private JTextField departamentoReferencia;
	private JTextField departamentoEmpleado;
	private JTextField nacionalidadEmpleado;
	
	
	public DialogoAgregarEmpleado(Control controlP) {
		
		super(null, java.awt.Dialog.ModalityType.TOOLKIT_MODAL);
		
		control = controlP;
		
		setTitle("Agregar Empleado");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 717, 668);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JButton btnAceptar = new JButton("Aceptar");
		btnAceptar.setActionCommand("Aceptar");
		btnAceptar.addActionListener(this);
		btnAceptar.setBounds(563, 595, 89, 23);
		panel.add(btnAceptar);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.setActionCommand("Cancelar");
		btnCancelar.addActionListener(this);
		btnCancelar.setBounds(450, 595, 89, 23);
		panel.add(btnCancelar);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setName("Informaci\u00F3n Personal");
		tabbedPane.setBounds(10, 11, 687, 573);
		panel.add(tabbedPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		tabbedPane.addTab("Informaci\u00F3n Personal", null, panel_1, null);
		panel_1.setLayout(null);
		
		JPanel fotoEmpleado = new JPanel();
		fotoEmpleado.setBorder(new LineBorder(new Color(0, 0, 0)));
		fotoEmpleado.setBackground(Color.WHITE);
		fotoEmpleado.setBounds(68, 52, 130, 150);
		panel_1.add(fotoEmpleado);
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion Personal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(337, 11, 335, 455);
		panel_1.add(panel_5);
		
		direccionEmpleado = new JTextField();
		direccionEmpleado.setColumns(10);
		direccionEmpleado.setBounds(177, 114, 141, 20);
		panel_5.add(direccionEmpleado);
		
		telefonoEmpleado = new JTextField();
		telefonoEmpleado.setColumns(10);
		telefonoEmpleado.setBounds(177, 240, 141, 20);
		panel_5.add(telefonoEmpleado);
		
		celularEmpleado = new JTextField();
		celularEmpleado.setColumns(10);
		celularEmpleado.setBounds(177, 283, 141, 20);
		panel_5.add(celularEmpleado);
		
		correoEmpleado = new JTextField();
		correoEmpleado.setColumns(10);
		correoEmpleado.setBounds(177, 329, 141, 20);
		panel_5.add(correoEmpleado);
		
		JLabel label_3 = new JLabel("Direcci\u00F3n");
		label_3.setBounds(30, 117, 95, 14);
		panel_5.add(label_3);
		
		JLabel label_4 = new JLabel("Tel\u00E9fono Fijo:");
		label_4.setBounds(30, 243, 115, 14);
		panel_5.add(label_4);
		
		JLabel label_5 = new JLabel("Tel\u00E9fono Celular:");
		label_5.setBounds(30, 286, 115, 14);
		panel_5.add(label_5);
		
		JLabel label_6 = new JLabel("Correo Electr\u00F3nico");
		label_6.setBounds(30, 332, 135, 14);
		panel_5.add(label_6);
		
		JLabel lblEstadoCivil = new JLabel("Estado Civil:");
		lblEstadoCivil.setBounds(30, 39, 135, 14);
		panel_5.add(lblEstadoCivil);
		
		estadoCivilEmpleado = new JComboBox();
		estadoCivilEmpleado.addItem("Soltero(a)");
		estadoCivilEmpleado.addItem("Casado(a)");
		estadoCivilEmpleado.addItem("Divorciado(a)");
		estadoCivilEmpleado.setBounds(177, 36, 141, 20);
		panel_5.add(estadoCivilEmpleado);
		
		JLabel lblFechaDeNacimiento = new JLabel("Fecha de Nacimiento:");
		lblFechaDeNacimiento.setBounds(30, 75, 135, 14);
		panel_5.add(lblFechaDeNacimiento);
		
		fechaNacimientoEmpleado = new JDateChooser();
		fechaNacimientoEmpleado.getSpinner().setToolTipText("  ");
		fechaNacimientoEmpleado.setBounds(175, 69, 144, 20);
		panel_5.add(fechaNacimientoEmpleado);
		
		JLabel lblCiudad_1 = new JLabel("Ciudad");
		lblCiudad_1.setBounds(30, 158, 95, 14);
		panel_5.add(lblCiudad_1);
		
		ciudadEmpleado = new JTextField();
		ciudadEmpleado.setColumns(10);
		ciudadEmpleado.setBounds(177, 155, 141, 20);
		panel_5.add(ciudadEmpleado);
		
		JLabel lblDepartamento_1 = new JLabel("Departamento");
		lblDepartamento_1.setBounds(30, 201, 95, 14);
		panel_5.add(lblDepartamento_1);
		
		departamentoEmpleado = new JTextField();
		departamentoEmpleado.setBounds(177, 198, 141, 20);
		panel_5.add(departamentoEmpleado);
		departamentoEmpleado.setColumns(10);
		
		JLabel lblNacionalidad = new JLabel("Nacionalidad");
		lblNacionalidad.setBounds(30, 376, 95, 14);
		panel_5.add(lblNacionalidad);
		
		nacionalidadEmpleado = new JTextField();
		nacionalidadEmpleado.setBounds(177, 373, 141, 20);
		panel_5.add(nacionalidadEmpleado);
		nacionalidadEmpleado.setColumns(10);
		
		JButton btnSubirFoto = new JButton("Agregar Foto");
		btnSubirFoto.setBounds(68, 239, 130, 23);
		panel_1.add(btnSubirFoto);
		
//		dateChooserFechaCompra = new JDateChooser();
//		dateChooserFechaCompra.setBounds(119, 128, 218, 20);
		
		JLabel label = new JLabel("Nombres:");
		label.setBounds(27, 298, 115, 14);
		panel_1.add(label);
		
		nombreEmpleado = new JTextField();
		nombreEmpleado.setBounds(141, 295, 141, 20);
		panel_1.add(nombreEmpleado);
		nombreEmpleado.setColumns(10);
		
		JLabel label_1 = new JLabel("Apellidos:");
		label_1.setBounds(27, 332, 95, 14);
		panel_1.add(label_1);
		
		apellidosEmpleado = new JTextField();
		apellidosEmpleado.setBounds(141, 332, 141, 20);
		panel_1.add(apellidosEmpleado);
		apellidosEmpleado.setColumns(10);
		
		JLabel lblTipoDocumento_1 = new JLabel("Tipo Documento");
		lblTipoDocumento_1.setBounds(27, 369, 95, 14);
		panel_1.add(lblTipoDocumento_1);
		
		JComboBox tipoDocumentoEmpleado = new JComboBox();
		tipoDocumentoEmpleado.setBounds(141, 366, 141, 20);
		panel_1.add(tipoDocumentoEmpleado);
		
		JLabel lblNoDocumento = new JLabel("No. Documento:");
		lblNoDocumento.setBounds(27, 405, 95, 14);
		panel_1.add(lblNoDocumento);
		
		cedulaEmpleado = new JTextField();
		cedulaEmpleado.setBounds(141, 402, 141, 20);
		panel_1.add(cedulaEmpleado);
		cedulaEmpleado.setColumns(10);
		
		JButton btnValidar = new JButton("Validar");
		btnValidar.setBounds(263, 500, 89, 23);
		btnValidar.setActionCommand("Validar");
		btnValidar.addActionListener(this);
		panel_1.add(btnValidar);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(27, 441, 135, 14);
		panel_1.add(lblSexo);
		
		sexoEmpleado = new JComboBox();
		sexoEmpleado.setBounds(141, 438, 141, 20);
		panel_1.add(sexoEmpleado);
		sexoEmpleado.addItem("Hombre");
		sexoEmpleado.addItem("Mujer");
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		tabbedPane.addTab("Informaci\u00F3n Familiar", null, panel_3, null);
		panel_3.setLayout(null);
		JPanel panel_6 = new JPanel();
		panel_6.setLayout(null);
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Hijos", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_6.setBackground(Color.WHITE);
		panel_6.setBounds(10, 207, 662, 327);
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
		
		JLabel lblTipoDocumento = new JLabel("Tipo Documento:");
		lblTipoDocumento.setBounds(10, 113, 104, 14);
		panel_6.add(lblTipoDocumento);
		
		cedulaHijo = new JTextField();
		cedulaHijo.setColumns(10);
		cedulaHijo.setBounds(155, 151, 141, 20);
		panel_6.add(cedulaHijo);
		
		JLabel label_10 = new JLabel("Fecha Nacimiento:");
		label_10.setBounds(10, 250, 104, 14);
		panel_6.add(label_10);
		
		JLabel lblSexo_2 = new JLabel("Sexo");
		lblSexo_2.setBounds(10, 199, 104, 14);
		panel_6.add(lblSexo_2);
		
		JButton btnAgregarHijo = new JButton("Agregar Hijos");
		btnAgregarHijo.setActionCommand("Agregar Hijo");
		btnAgregarHijo.addActionListener(this);
		btnAgregarHijo.setBounds(426, 293, 202, 23);
		panel_6.add(btnAgregarHijo);
		

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
		scrollPane.setBounds(337, 11, 315, 253);
		panel_6.add(scrollPane);
		
		fechaNacimientoHijo = new JDateChooser();
		fechaNacimientoHijo.setBounds(155, 244, 144, 20);
		panel_6.add(fechaNacimientoHijo);
		
		JComboBox sexoHijos = new JComboBox();
		sexoHijos.setBounds(155, 196, 141, 20);
		panel_6.add(sexoHijos);
		
		JLabel label_11 = new JLabel("No. Documento:");
		label_11.setBounds(10, 154, 104, 14);
		panel_6.add(label_11);
		
		JComboBox tipoDocumentoHijos = new JComboBox();
		tipoDocumentoHijos.setBounds(155, 110, 141, 20);
		panel_6.add(tipoDocumentoHijos);
		
		JLabel label_9 = new JLabel("Direcci\u00F3n");
		label_9.setBounds(10, 297, 104, 14);
		panel_6.add(label_9);
		
		direccionHijos = new JTextField();
		direccionHijos.setColumns(10);
		direccionHijos.setBounds(155, 294, 141, 20);
		panel_6.add(direccionHijos);
		
		JPanel panel_10 = new JPanel();
		panel_10.setLayout(null);
		panel_10.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Pareja", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_10.setBackground(Color.WHITE);
		panel_10.setBounds(10, 11, 662, 188);
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
		
		JLabel lblTelefono = new JLabel("Telefono");
		lblTelefono.setBounds(327, 68, 104, 14);
		panel_10.add(lblTelefono);
		
		JLabel lblSexo_1 = new JLabel("Sexo");
		lblSexo_1.setBounds(327, 112, 104, 14);
		panel_10.add(lblSexo_1);
		
		telefonoPareja = new JTextField();
		telefonoPareja.setColumns(10);
		telefonoPareja.setBounds(511, 65, 141, 20);
		panel_10.add(telefonoPareja);
		
		JComboBox sexoPareja = new JComboBox();
		sexoPareja.setBounds(511, 109, 141, 20);
		panel_10.add(sexoPareja);
		
		JLabel lblDireccin = new JLabel("Direcci\u00F3n");
		lblDireccin.setBounds(10, 112, 104, 14);
		panel_10.add(lblDireccin);
		
		direccionPareja = new JTextField();
		direccionPareja.setColumns(10);
		direccionPareja.setBounds(155, 109, 141, 20);
		panel_10.add(direccionPareja);
		
		JLabel lblCiudad = new JLabel("Ciudad");
		lblCiudad.setBounds(10, 154, 104, 14);
		panel_10.add(lblCiudad);
		
		ciudadPareja = new JTextField();
		ciudadPareja.setColumns(10);
		ciudadPareja.setBounds(155, 151, 141, 20);
		panel_10.add(ciudadPareja);
		
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
		
		tipoContrato = new JComboBox();
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
		
		duracionContrato = new JComboBox();
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
		
		fechaInicioContrato = new JDateChooser();
		fechaInicioContrato.setBounds(154, 297, 131, 20);
		panel_7.add(fechaInicioContrato);
		
		fechaFinContrato = new JDateChooser();
		fechaFinContrato.setBounds(154, 350, 131, 20);
		panel_7.add(fechaFinContrato);
		
		JLabel lblTipoLiquidacion = new JLabel("Tipo Liquidaci\u00F3n:");
		lblTipoLiquidacion.setBounds(10, 401, 137, 14);
		panel_7.add(lblTipoLiquidacion);
		
		JComboBox tipoLiquidacionEmpleado = new JComboBox();
		tipoLiquidacionEmpleado.setBounds(154, 398, 131, 20);
		panel_7.add(tipoLiquidacionEmpleado);
		
		JPanel panel_12 = new JPanel();
		panel_12.setLayout(null);
		panel_12.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Seguridad Social", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_12.setBackground(Color.WHITE);
		panel_12.setBounds(352, 11, 308, 294);
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
		saludEmpleado.setBounds(154, 28, 131, 20);
		panel_12.add(saludEmpleado);
		
		JLabel label_37 = new JLabel("Fecha Afiliaci\u00F3n a SS:");
		label_37.setBounds(10, 257, 137, 14);
		panel_12.add(label_37);
		
		JComboBox pensionesEmpleado = new JComboBox();
		pensionesEmpleado.setBounds(154, 67, 131, 20);
		panel_12.add(pensionesEmpleado);
		
		JLabel lblSolidaridad = new JLabel("Solidaridad:");
		lblSolidaridad.setBounds(10, 156, 137, 14);
		panel_12.add(lblSolidaridad);
		
		JComboBox arlEmpleado = new JComboBox();
		arlEmpleado.setBounds(154, 107, 131, 20);
		panel_12.add(arlEmpleado);
		
		JComboBox solidaridadEmpleado = new JComboBox();
		solidaridadEmpleado.setBounds(154, 153, 131, 20);
		panel_12.add(solidaridadEmpleado);
		
		JDateChooser fechaAfiliacionSS = new JDateChooser();
		fechaAfiliacionSS.setBounds(154, 251, 131, 20);
		panel_12.add(fechaAfiliacionSS);
		
		JLabel lblCajaDeCompensacin = new JLabel("Caja de Compensaci\u00F3n");
		lblCajaDeCompensacin.setBounds(10, 204, 137, 14);
		panel_12.add(lblCajaDeCompensacin);
		
		JComboBox cajaCompensacionEmpleado = new JComboBox();
		cajaCompensacionEmpleado.setBounds(154, 201, 131, 20);
		panel_12.add(cajaCompensacionEmpleado);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.WHITE);
		tabbedPane.addTab("Referencias", null, panel_11, null);
		panel_11.setLayout(null);
		
		
		JPanel panel_8 = new JPanel();
		panel_8.setLayout(null);
		panel_8.setBorder(null);
		panel_8.setBackground(Color.WHITE);
		panel_8.setBounds(10, 11, 662, 553);
		panel_11.add(panel_8);
		
		nombreReferencia = new JTextField();
		nombreReferencia.setColumns(10);
		nombreReferencia.setBounds(154, 70, 179, 20);
		panel_8.add(nombreReferencia);
		
		telefonoReferencia = new JTextField();
		telefonoReferencia.setColumns(10);
		telefonoReferencia.setBounds(154, 202, 179, 20);
		panel_8.add(telefonoReferencia);
		
		empresaRefPersonal = new JTextField();
		empresaRefPersonal.setColumns(10);
		empresaRefPersonal.setBounds(154, 442, 178, 20);
		panel_8.add(empresaRefPersonal);
		
		JLabel label_15 = new JLabel("Empresa: ");
		label_15.setBounds(10, 445, 115, 14);
		panel_8.add(label_15);
		
		JLabel label_19 = new JLabel("Concepto:");
		label_19.setBounds(10, 492, 109, 14);
		panel_8.add(label_19);
		
		conceptoRefPersonal = new JTextField();
		conceptoRefPersonal.setColumns(10);
		conceptoRefPersonal.setBounds(154, 489, 178, 20);
		panel_8.add(conceptoRefPersonal);
		
		JLabel lblNombres = new JLabel("Nombres:");
		lblNombres.setBounds(10, 73, 115, 14);
		panel_8.add(lblNombres);
		
		JLabel lblTelfono = new JLabel("Tel\u00E9fono:");
		lblTelfono.setBounds(10, 205, 115, 14);
		panel_8.add(lblTelfono);
		
		
		Object[] columnsReferencias = {" ","Nombre", "Tipo"};
		modRP = new DefaultTableModel(columnsReferencias,0)
		{

			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};

		tableReferencias = new JTable(modRP);
		tableReferencias.getColumnModel().getColumn(0).setPreferredWidth(10);
		tableReferencias.getTableHeader().setReorderingAllowed(false);
		
		listenerReferencias = new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent event) {
				//TODO
					Object source = event.getSource();
					
					if (source.equals(tableReferencias.getSelectionModel())){
						int posicion = tableReferencias.getSelectedRow();
						ReferenciaPersonal ref = (ReferenciaPersonal) control.darListaReferecnias().get(posicion);
						actualizarInformacionReferencia(ref);
					}
					else if (source.equals(tableExperiencia.getSelectionModel())){
						int posicion = tableExperiencia.getSelectedRow();
						Experiencia exp = (Experiencia) control.darListaExperiencia().get(posicion);
						actualizarInformacionExperiencia(exp);
					}
					
			}

		};

		tableReferencias.getSelectionModel().addListSelectionListener(listenerReferencias);
		
		scrollPane_2 = new JScrollPane(tableReferencias);
		scrollPane_2.setBounds(366, 11, 286, 447);
		panel_8.add(scrollPane_2);
		
		btnNuevaReferencia = new JButton("Nuevo");
		btnNuevaReferencia.setBounds(367, 469, 130, 23);
		btnNuevaReferencia.setActionCommand("Nueva Referencia");
		btnNuevaReferencia.addActionListener(this);
		btnNuevaReferencia.setEnabled(false);
		panel_8.add(btnNuevaReferencia);
		
		btnAgregarReferencia = new JButton("Agregar");
		btnAgregarReferencia.setBounds(525, 469, 130, 23);
		btnAgregarReferencia.setActionCommand("Agregar Referencia");
		btnAgregarReferencia.addActionListener(this);
		panel_8.add(btnAgregarReferencia);
		
		btnEditarReferencia = new JButton("Editar");
		btnEditarReferencia.setBounds(367, 505, 130, 23);
		btnEditarReferencia.setActionCommand("Editar Referencia");
		btnEditarReferencia.addActionListener(this);
		btnEditarReferencia.setEnabled(false);
		panel_8.add(btnEditarReferencia);
		
		btnEliminarReferencia = new JButton("Eliminar");
		btnEliminarReferencia.setBounds(525, 505, 130, 23);
		btnEliminarReferencia.setActionCommand("Eliminar Referencia");
		btnEliminarReferencia.addActionListener(this);
		btnEliminarReferencia.setEnabled(false);
		panel_8.add(btnEliminarReferencia);
		
		
		JLabel lblApellidos = new JLabel("Apellidos:");
		lblApellidos.setBounds(10, 117, 115, 14);
		panel_8.add(lblApellidos);
		
		apellidosReferencia = new JTextField();
		apellidosReferencia.setColumns(10);
		apellidosReferencia.setBounds(154, 114, 179, 20);
		panel_8.add(apellidosReferencia);
		
		JLabel lblTipo = new JLabel("Tipo:");
		lblTipo.setBounds(10, 28, 115, 14);
		panel_8.add(lblTipo);
		
		//TODO
		tipoReferencia = new JComboBox();
		for (int i = 0; i < tipoReferenciaOpciones.length; i++){
			tipoReferencia.addItem(tipoReferenciaOpciones[i]);
		}
		tipoReferencia.setBounds(154, 25, 179, 20);
		panel_8.add(tipoReferencia);
		
		JLabel lblSexo_3 = new JLabel("Sexo:");
		lblSexo_3.setBounds(10, 252, 100, 14);
		panel_8.add(lblSexo_3);
		
		sexoReferencia = new JComboBox();
		sexoReferencia.setBounds(154, 249, 179, 20);
		sexoReferencia.addItem(Persona.HOMBRE);
		sexoReferencia.addItem(Persona.MUJER);
		panel_8.add(sexoReferencia);
		
		JLabel lblDireccin_1 = new JLabel("Direcci\u00F3n:");
		lblDireccin_1.setBounds(10, 300, 100, 14);
		panel_8.add(lblDireccin_1);
		
		direccionReferencia = new JTextField();
		direccionReferencia.setColumns(10);
		direccionReferencia.setBounds(154, 297, 179, 20);
		panel_8.add(direccionReferencia);
		
		JLabel lblCiudad_2 = new JLabel("Ciudad:");
		lblCiudad_2.setBounds(10, 349, 100, 14);
		panel_8.add(lblCiudad_2);
		
		ciudadReferencia = new JTextField();
		ciudadReferencia.setColumns(10);
		ciudadReferencia.setBounds(154, 346, 179, 20);
		panel_8.add(ciudadReferencia);
		
		JLabel lblNoDocumento_1 = new JLabel("No. Documento");
		lblNoDocumento_1.setBounds(10, 164, 115, 14);
		panel_8.add(lblNoDocumento_1);
		
		documentoReferencia = new JTextField();
		documentoReferencia.setColumns(10);
		documentoReferencia.setBounds(154, 161, 179, 20);
		panel_8.add(documentoReferencia);
		
		JLabel lblDepartamento = new JLabel("Departamento");
		lblDepartamento.setBounds(10, 397, 100, 14);
		panel_8.add(lblDepartamento);
		
		departamentoReferencia = new JTextField();
		departamentoReferencia.setBounds(154, 394, 179, 20);
		panel_8.add(departamentoReferencia);
		departamentoReferencia.setColumns(10);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		tabbedPane.addTab("Experiencia Laboral", null, panel_4, null);
		panel_4.setLayout(null);
		

		Object[] columnsExperiencia = {" ","Empresa", "Cargo", "Fecha Inicio", "Fecha Fin"};
		modExp = new DefaultTableModel(columnsExperiencia,0)
		{

			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};
		
		tableExperiencia = new JTable(modExp);
		tableExperiencia.getColumnModel().getColumn(0).setPreferredWidth(10);
		tableExperiencia.getTableHeader().setReorderingAllowed(false);

		tableExperiencia.getSelectionModel().addListSelectionListener(listenerReferencias);
	
		JScrollPane scrollPane_1 = new JScrollPane(tableExperiencia);
		scrollPane_1.setBounds(38, 21, 618, 308);
		panel_4.add(scrollPane_1);
		System.out.println("FIN");
		JLabel lblEmpresa = new JLabel("Empresa:");
		lblEmpresa.setBounds(27, 411, 89, 14);
		panel_4.add(lblEmpresa);
		
		empresaExperiencia = new JTextField();
		empresaExperiencia.setColumns(10);
		empresaExperiencia.setBounds(151, 408, 149, 20);
		panel_4.add(empresaExperiencia);
		
		JLabel lblCargo = new JLabel("Cargo:");
		lblCargo.setBounds(27, 457, 89, 14);
		panel_4.add(lblCargo);
		
		cargoExperiencia = new JTextField();
		cargoExperiencia.setColumns(10);
		cargoExperiencia.setBounds(151, 454, 149, 20);
		panel_4.add(cargoExperiencia);
		
		fechaInicioExperiencia = new JDateChooser();
		fechaInicioExperiencia.getSpinner().setToolTipText("  ");
		fechaInicioExperiencia.setBounds(473, 408, 144, 20);
		panel_4.add(fechaInicioExperiencia);
		
		JLabel lblFechaInicio = new JLabel("Fecha Inicio:");
		lblFechaInicio.setBounds(338, 411, 89, 14);
		panel_4.add(lblFechaInicio);
		
		JLabel lblFechaFin = new JLabel("Fecha Fin:");
		lblFechaFin.setBounds(338, 457, 89, 14);
		panel_4.add(lblFechaFin);
		
		fechafinExperiencia = new JDateChooser();
		fechafinExperiencia.getSpinner().setToolTipText("  ");
		fechafinExperiencia.setBounds(473, 451, 144, 20);
		panel_4.add(fechafinExperiencia);
		
		JLabel lblTipoContrato_1 = new JLabel("Tipo Contrato:");
		lblTipoContrato_1.setBounds(27, 498, 89, 14);
		panel_4.add(lblTipoContrato_1);
		
		//TODO
		tipoContratoExperiencia = new JComboBox();
		
		for (int i = 0; i<tipoContratoOpciones.length; i++){
			tipoContratoExperiencia.addItem(tipoContratoOpciones[i]);
		}
		
		tipoContratoExperiencia.setBounds(151, 495, 149, 20);
		panel_4.add(tipoContratoExperiencia);
		
		btnAgregarExperiencia = new JButton("Agregar");
		btnAgregarExperiencia.addActionListener(this);
		btnAgregarExperiencia.setActionCommand("Agregar Experiencia");
		btnAgregarExperiencia.setBounds(38, 340, 122, 23);
		panel_4.add(btnAgregarExperiencia);
		
		btnEditarExperiencia = new JButton("Editar");
		btnEditarExperiencia.addActionListener(this);
		btnEditarExperiencia.setActionCommand("Editar Experiencia");
		btnEditarExperiencia.setEnabled(false);
		btnEditarExperiencia.setBounds(201, 340, 122, 23);
		panel_4.add(btnEditarExperiencia);
		
		btnEliminarExperiencia = new JButton("Eliminar");
		btnEliminarExperiencia.addActionListener(this);
		btnEliminarExperiencia.setActionCommand("Eliminar Experiencia");
		btnEliminarExperiencia.setEnabled(false);
		btnEliminarExperiencia.setBounds(367, 340, 122, 23);
		panel_4.add(btnEliminarExperiencia);
		
		btnNuevaExperiencia = new JButton("Nuevo");
		btnNuevaExperiencia.addActionListener(this);
		btnNuevaExperiencia.setActionCommand("Nueva Experiencia");
		btnNuevaExperiencia.setEnabled(false);
		btnNuevaExperiencia.setBounds(534, 340, 122, 23);
		panel_4.add(btnNuevaExperiencia);
		
		control = new Control();
		
		tabbedPane.setEnabledAt(1, false);
		tabbedPane.setEnabledAt(2, false);
		tabbedPane.setEnabledAt(3, false);
		tabbedPane.setEnabledAt(4, false);
	}

@Override
	public void actionPerformed(ActionEvent e) {
	String command = e.getActionCommand();
	System.out.println(command);
		
		if(command.equals("Cancelar"))
		{
			this.dispose();
		}
		else if (command.equals("Aceptar")){
	//		agregarEmpleado();
		}
		else if (command.equals("Agregar Hijo")){
	//		agregarHijo();
		}
		else if (command.equals("Agregar Referencia")){
			agregarReferencia();
		}
		else if (command.equals("Editar Referencia")){
			editarReferencia();
		}
		else if (command.equals("Eliminar Referencia")){
			eliminarReferencia();
			btnNuevaReferencia.setEnabled(false);
			btnEditarReferencia.setEnabled(false);
			btnEliminarReferencia.setEnabled(false);
			btnAgregarReferencia.setEnabled(true);
		}
		else if (command.equals("Nueva Referencia")){
			
			tableReferencias.getSelectionModel().removeListSelectionListener(listenerReferencias);
			tableReferencias.clearSelection();
			tableReferencias.getSelectionModel().addListSelectionListener(listenerReferencias);
			
			
			limpiarCamposReferencias();
			btnNuevaReferencia.setEnabled(false);
			btnEditarReferencia.setEnabled(false);
			btnEliminarReferencia.setEnabled(false);
			btnAgregarReferencia.setEnabled(true);
		
		}
		else if (command.equals("Agregar Experiencia")){
			agregarExperiencia();
		}
		else if (command.equals("Editar Experiencia")){
			editarExperiencia();
		}
		else if (command.equals("Eliminar Experiencia")){
			eliminarExperiencia();
			btnNuevaExperiencia.setEnabled(false);
			btnEditarExperiencia.setEnabled(false);
			btnEliminarExperiencia.setEnabled(false);
			btnAgregarExperiencia.setEnabled(true);
		}
		else if (command.equals("Nueva Experiencia")){
			
			tableExperiencia.getSelectionModel().removeListSelectionListener(listenerReferencias);
			tableExperiencia.clearSelection();
			tableExperiencia.getSelectionModel().addListSelectionListener(listenerReferencias);
			
			limpiarCamposExperiencia();
			btnNuevaExperiencia.setEnabled(false);
			btnEditarExperiencia.setEnabled(false);
			btnEliminarExperiencia.setEnabled(false);
			btnAgregarExperiencia.setEnabled(true);
		}
		else if(command.equals("Validar"))
		{
			int identificacion = Integer.parseInt(cedulaEmpleado.getText());
			String tipoDocumento ;
			String nombre; 
			String apellidos;
			String sexo;
			Date fechaNacimiento;
			String estadoCivil;
			String correo;
			int edad;
			int telefono;
			int celularP;
			String direccion;
			String ciudad;
			String departamento;
			String nacionalidad;
			
	//		control.crearNuevoEmpleado(identificacion, tipoDocumento, nombre, 
	//				apellidos, sexo, fechaNacimiento, estadoCivil, correo, 
	//				edad, telefono, celularP, direccion, ciudad, departamento, nacionalidad);
		
		}
	}
	

	public void agregarReferencia() 
	{
		
		String tipoP = tipoReferencia.getSelectedItem().toString();
		String nombresP = nombreReferencia.getText();
		String apellidosP = apellidosReferencia.getText();
		String documentoP0 = documentoReferencia.getText();
		String telefonoP0 = telefonoReferencia.getText();
		String sexoP = sexoReferencia.getSelectedItem().toString();
		String direccionP = direccionReferencia.getText();
		String ciudadP = ciudadReferencia.getText();
		String departamentoP = departamentoReferencia.getText();
		
		String empresaP = empresaRefPersonal.getText();
		String conceptoP = conceptoRefPersonal.getText();
		
		if (verificarCamposReferencias()){
			
			int telefonoP = Integer.parseInt(telefonoP0);
			int documentoP = Integer.parseInt(documentoP0);
			
			control.agregarReferenciaEmpleadoNuevo(nombresP, apellidosP, telefonoP, documentoP, sexoP, direccionP, ciudadP, departamentoP, tipoP, empresaP, conceptoP);
			actualizarTablaReferecnias();
			limpiarCamposReferencias();
		}
				
	}

	public void eliminarReferencia(){
		
		int posicion = tableReferencias.getSelectedRow();
		DefaultTableModel dm = (DefaultTableModel) tableReferencias.getModel();
		int confirm = JOptionPane.showConfirmDialog(this, "¿Desea eliminar la referencia seleccionada?","Warning",JOptionPane.YES_NO_OPTION);
		
		if (confirm == JOptionPane.YES_NO_OPTION){
			control.eliminarReferenciaEmpleadoNuevo(posicion);
			tableReferencias.getSelectionModel().removeListSelectionListener(listenerReferencias);
			modRP.removeRow(posicion);
			tableReferencias.getSelectionModel().addListSelectionListener(listenerReferencias);
		}
		
		if(control.darListaReferecnias().isEmpty()){
			limpiarCamposReferencias();
		}
		else{
			ReferenciaPersonal nuevoMostrado = (ReferenciaPersonal) control.darListaReferecnias().get(0);
			actualizarInformacionReferencia(nuevoMostrado);
		}
	}
	
	public void editarReferencia(){
		int confirm = JOptionPane.showConfirmDialog(this, "¿Desea guardar los cambios realizados?","Warning",JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_NO_OPTION){
			
			int posicion = tableReferencias.getSelectedRow();
			ReferenciaPersonal ref = (ReferenciaPersonal) control.darListaReferecnias().get(posicion);
			
			String tipoP = tipoReferencia.getSelectedItem().toString();
			String nombresP = nombreReferencia.getText();
			String apellidosP = apellidosReferencia.getText();
			String documentoP0 = documentoReferencia.getText();
			String telefonoP0 = telefonoReferencia.getText();
			String sexoP = sexoReferencia.getSelectedItem().toString();
			String direccionP = direccionReferencia.getText();
			String ciudadP = ciudadReferencia.getText();
			String empresaP = empresaRefPersonal.getText();
			String conceptoP = conceptoRefPersonal.getText();
			
			ref.setTipo(tipoP);
			ref.setNombres(nombresP);
			ref.setApellidos(apellidosP);
			ref.setIdentificacion(Integer.parseInt(documentoP0));
			ref.setTelefono(Integer.parseInt(telefonoP0));
			ref.setSexo(sexoP);
			ref.setDireccion(direccionP);
			ref.setCiudad(ciudadP);
			ref.setEmpresa(empresaP);
			ref.setConcepto(conceptoP);
			
		}		
	}
	
	public void actualizarInformacionReferencia(ReferenciaPersonal ref) {

		nombreReferencia.setText(ref.getNombres());
		apellidosReferencia.setText(ref.getApellidos());
		documentoReferencia.setText(String.valueOf(ref.getIdentificacion()));
		telefonoReferencia.setText(String.valueOf(ref.getTelefono()));
		direccionReferencia.setText(ref.getDireccion());
		ciudadReferencia.setText(ref.getCiudad());
		
		empresaRefPersonal.setText(ref.getEmpresa());
		conceptoRefPersonal.setText(ref.getConcepto());
		
		boolean listo = false;
		for (int i = 0; i<tipoReferenciaOpciones.length && !listo; i++){
			if (tipoReferenciaOpciones[i].equalsIgnoreCase(ref.getTipo())){
				listo = true;
				tipoReferencia.setSelectedIndex(i);
			}	
		}
		
		if(ref.getSexo().equals(Persona.HOMBRE)){
			sexoReferencia.setSelectedIndex(0);
		} 
		else 
		{
			sexoReferencia.setSelectedIndex(1);
		}
		
		btnNuevaReferencia.setEnabled(true);
		btnEditarReferencia.setEnabled(true);
		btnEliminarReferencia.setEnabled(true);
		btnAgregarReferencia.setEnabled(false);
		
	}
	
	
	public void limpiarCamposReferencias(){
		
		nombreReferencia.setText("");
		apellidosReferencia.setText("");
		documentoReferencia.setText(null);
		telefonoReferencia.setText(null);
		direccionReferencia.setText("");
		ciudadReferencia.setText("");
		
		empresaRefPersonal.setText("");
		conceptoRefPersonal.setText("");
		
	}
	
	public void actualizarTablaReferecnias(){
		
		tableReferencias.getSelectionModel().removeListSelectionListener(listenerReferencias);
		
		DefaultTableModel model = (DefaultTableModel) tableReferencias.getModel();
		model.setRowCount(0);
		ArrayList listaReferencias = control.darListaReferecnias();
		
		for (int i = 0;  i<listaReferencias.size(); i++){
	
			ReferenciaPersonal actual = (ReferenciaPersonal) listaReferencias.get(i);
			model.addRow(new Object[]{i+1,actual.getNombres() + "" + actual.getApellidos(), actual.getTipo()});
		}	
		
		tableReferencias.getSelectionModel().addListSelectionListener(listenerReferencias);
	}
	
	public boolean verificarCamposReferencias(){
		
		String tipoP = tipoReferencia.getSelectedItem().toString();
		String nombresP = nombreReferencia.getText();
		String apellidosP = apellidosReferencia.getText();
		String documentoP0 = documentoReferencia.getText();
		String telefonoP0 = telefonoReferencia.getText();
		String sexoP = sexoReferencia.getSelectedItem().toString();
		String direccionP = direccionReferencia.getText();
		String ciudadP = ciudadReferencia.getText();
		
		String empresaP = empresaRefPersonal.getText();
		String conceptoP = conceptoRefPersonal.getText();
		
		boolean resultado = false;
		if (!nombresP.equalsIgnoreCase("") && !apellidosP.equalsIgnoreCase("") &&
				!documentoP0.equalsIgnoreCase("") && !telefonoP0.equalsIgnoreCase("")){
			
			try{
				
				int telefonoP = Integer.parseInt(telefonoP0);
				int documentoP = Integer.parseInt(documentoP0);
				
				if (empresaP.equalsIgnoreCase("") || conceptoP.equalsIgnoreCase("") ||
						!direccionP.equalsIgnoreCase("") || !ciudadP.equalsIgnoreCase("")){
					
					int rta = JOptionPane.showConfirmDialog(this, "Hay campos sin llenar, ¿Desea continuar?", "Advertencia", JOptionPane.YES_NO_OPTION);
					
					if (rta == JOptionPane.YES_OPTION){
						
						resultado = true;
					}
				}
				else{
					
					resultado = true;
					
				}
			}
			catch (Exception e){
				JOptionPane.showMessageDialog(this, "Debe ingresar un valor numérico en los campos Telefono y No. Documento", "Error", JOptionPane.ERROR_MESSAGE);
			}
			
		}
		else{
			JOptionPane.showMessageDialog(this, "Hay campos vacíos que se deben llenar", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
		
		return resultado;
	}
	
	public void agregarExperiencia(){
		
		String empresaP = empresaExperiencia.getText();
		String cargoP = cargoExperiencia.getText();
		String tipoP = tipoContrato.getSelectedItem().toString();
		Date fechaInicioP = fechaInicioExperiencia.getDate();
		Date fechaFinP  = fechafinExperiencia.getDate();
		
		if (!empresaP.equalsIgnoreCase("") && !cargoP.equalsIgnoreCase("")){
			
			control.agregarExperienciaEmpleadoNuevo(cargoP, empresaP, tipoP, fechaInicioP, fechaFinP);
			actualizarTablaExperiencia();
			limpiarCamposExperiencia();
		}
		
		else{
			JOptionPane.showMessageDialog(this, "Hay campos vacíos que se deben llenar", "Error", JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	public void editarExperiencia(){
		int confirm = JOptionPane.showConfirmDialog(this, "¿Desea guardar los cambios realizados?","Warning",JOptionPane.YES_NO_OPTION);
		if (confirm == JOptionPane.YES_NO_OPTION){
			
			int posicion = tableExperiencia.getSelectedRow();
			Experiencia exp = (Experiencia) control.darListaExperiencia().get(posicion);
			
			String empresaP = empresaExperiencia.getText();
			String cargoP = cargoExperiencia.getText();
			String tipoP = tipoContrato.getSelectedItem().toString();
			Date fechaInicioP = fechaInicioExperiencia.getDate();
			Date fechaFinP  = fechafinExperiencia.getDate();
			
			exp.setEmpresa(empresaP);
			exp.setCargo(cargoP);
			exp.setTipoContrato(tipoP);
			exp.setFechaInicio(fechaInicioP);
			exp.setFechaFin(fechaFinP);
		}
	}

	public void eliminarExperiencia(){
		
		int posicion = tableExperiencia.getSelectedRow();
		
		DefaultTableModel dm = (DefaultTableModel) tableExperiencia.getModel();
		int confirm = JOptionPane.showConfirmDialog(this, "¿Desea eliminar la experiencia seleccionada?","Warning",JOptionPane.YES_NO_OPTION);
		
		if (confirm == JOptionPane.YES_NO_OPTION){
			control.eliminarExperienciaEmpleadoNuevo(posicion);
			tableExperiencia.getSelectionModel().removeListSelectionListener(listenerReferencias);
			modExp.removeRow(posicion);
			tableExperiencia.getSelectionModel().addListSelectionListener(listenerReferencias);
		}
		
		if(control.darListaExperiencia().isEmpty()){
			limpiarCamposExperiencia();
		}
		else{
			Experiencia nuevoMostrado = (Experiencia) control.darListaExperiencia().get(0);
			actualizarInformacionExperiencia(nuevoMostrado);
		}
	}
	
	public void limpiarCamposExperiencia(){
		
		empresaExperiencia.setText("");
		cargoExperiencia.setText("");
		tipoContrato.setSelectedIndex(0);
		fechaInicioExperiencia.setDate(new Date());
		fechafinExperiencia.setDate(new Date());
	}
	
	public void actualizarInformacionExperiencia(Experiencia exp){
		
		empresaExperiencia.setText(exp.getEmpresa());
		cargoExperiencia.setText(exp.getCargo());
		
		boolean listo = false;
		for (int i = 0; i<tipoContratoOpciones.length && !listo; i++){
			if (tipoContratoOpciones[i].equalsIgnoreCase(exp.getTipoContrato())){
				listo = true;
				tipoContrato.setSelectedIndex(i);
			}	
		}
		
		fechaInicioExperiencia.setDate(exp.getFechaInicio());
		fechafinExperiencia.setDate(exp.getFechaFin());
		
		btnNuevaExperiencia.setEnabled(true);
		btnEditarExperiencia.setEnabled(true);
		btnEliminarExperiencia.setEnabled(true);
		btnAgregarExperiencia.setEnabled(false);
		
	};
	
	public void actualizarTablaExperiencia(){
		
		tableExperiencia.getSelectionModel().removeListSelectionListener(listenerReferencias);
		
		DefaultTableModel model = (DefaultTableModel) tableExperiencia.getModel();
		model.setRowCount(0);
		ArrayList listaExperiencia = control.darListaExperiencia();
		
		for (int i = 0;  i< listaExperiencia.size(); i++){
	
			Experiencia actual = (Experiencia) listaExperiencia.get(i);
			model.addRow(new Object[]{i+1,actual.getEmpresa(), actual.getCargo(), actual.getFechaInicio(), actual.getFechaFin()});
		}	
		
		tableExperiencia.getSelectionModel().addListSelectionListener(listenerReferencias);
	}
}