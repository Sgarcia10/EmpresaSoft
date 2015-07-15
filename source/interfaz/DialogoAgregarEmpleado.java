package interfaz;

import javax.imageio.ImageIO;
import javax.swing.JDialog;



import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
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
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.UIManager;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.image.BufferedImage;

import javax.swing.JTabbedPane;

import mundo.Empresa;
import mundo.empleado.Empleado;
import mundo.empleado.Experiencia;
import mundo.empleado.Hijo;
import mundo.empleado.Persona;
import mundo.empleado.Referencia;

import java.awt.Component;
import java.io.File;
import java.io.IOException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

import com.toedter.calendar.JDateChooser;

import javax.swing.JCheckBox;

//import com.toedter.calendar.JCalendar;
//import com.toedter.calendar.JDateChooser;

//TODO cambiar interfaz

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
	private JTable tableHijos;
	private JTable tableReferencias;
	private JTable tableExperiencia;
	private JTextField nombreReferencia;
	private JTextField telefonoReferencia;
	private JTextField empresaRefPersonal;
	private JTextField conceptoRefPersonal;
	
	private JDateChooser fechaNacimientoEmpleado;
	private JDateChooser fechaInicioContrato;
	private JDateChooser fechaFinContrato;
	private JDateChooser fechaNacimientoHijo;
	private JDateChooser fechaInicioExperiencia;
	private JDateChooser fechafinExperiencia;
	private JDateChooser fechaAfiliacionSS;
	
	private JComboBox sexoEmpleado;
	private JComboBox estadoCivilEmpleado;
	private JComboBox tipoDocumentoEmpleado;
	private JComboBox tipoContrato;
	private JComboBox duracionContrato;
	private JComboBox tipoContratoExperiencia;
	private JComboBox tipoReferencia;
	private JComboBox sexoReferencia;
	private JComboBox sexoHijos;
	private JComboBox tipoDocumentoHijos;
	private JComboBox sexoPareja;
	private JComboBox tipoLiquidacionEmpleado;
	private JComboBox saludEmpleado;
	private JComboBox pensionesEmpleado;
	private JComboBox arlEmpleado;
	private JComboBox cajaCompensacionEmpleado; 

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
	
	private JButton btnAgregarHijo;
	private JButton btnNuevoHijo;
	private JButton btnEliminarHijo;
	private JButton btnEditarHijo;
	
	private JButton btnAgregarReferencia;
	private JButton btnNuevaReferencia;
	private JButton btnEditarReferencia;
	private JButton btnEliminarReferencia;
	
	private JButton btnAgregarExperiencia;
	private JButton btnNuevaExperiencia;
	private JButton btnEliminarExperiencia;
	private JButton btnEditarExperiencia;
	
	private JButton btnSubirFoto;
	
	private DefaultTableModel modRP;
	private DefaultTableModel modExp;
	
	private ListSelectionListener listenerReferencias;

	private JScrollPane scrollPane_2;
	private JTextField departamentoReferencia;
	private JTextField departamentoEmpleado;
	private JTextField nacionalidadEmpleado;
	private JTextField horasSemanales;
	
	
	private String[] tipoContratoOpciones = {"Laboral", "Prestación de Servicios", "Aprendizaje"};
	private String[] tipoReferenciaOpciones = {Referencia.FAMILIAR, Referencia.LABORAL, Referencia.PERSONAL};
	private String[] tipoSexo = {Persona.HOMBRE, Persona.MUJER};
	private String[] tipoDocumento = {Persona.CEDULA,Persona.TARJETA};
	private String[] tipoSalud = {"Nueva EPS", "Saludcoop","Salud Total","Cafesalud","Sanitas","Compensar","EPS Sura",
								"Humanavivir","Comfenalco","Salud Colpatria","Coomeva","Famisanar","Cruz Blanca","Salud Vida"};
	private String[] tipoPensiones = {"Proteccion","Porvenir","Colfondos"};
	private String[] tipoARL = {"Sura","Colpatria","Colmena","Equidad","Positiva"};
	private String[] tipoSolidaridad = {"Si","No"};
	private String[] tipoCajaCompensacion = {"Cafam","Compensar","Colsubsidio","Comfenalco"};
	private String[] tipoDuracionContrato = {"Término Indefinido", "Término Fijo"};
	private String[] tipoPeriodoLiquidacion = {"15","30"};
	private String[] tipoEstadoCivil = {"Soltero(a)","Casado(a)","Viudo(a)"};
	
	private Control control;
	private InterfazNomina interfaz;
	
	private ListSelectionListener listenerTablas;
	private JCheckBox checkSolidaridad;
	private JCheckBox checkAuxilio;
	
	private JLabel lblFoto;
	
	private ImageIcon foto;
	private DecimalFormat formatoNumeros;
	private SimpleDateFormat sdf;
	
	private ValidarCampos validar;
	
	public DialogoAgregarEmpleado(Control controlP, InterfazNomina interfazP, final int posicion) {
		
		super(null, java.awt.Dialog.ModalityType.TOOLKIT_MODAL);
		
		formatoNumeros = new DecimalFormat("#############");
		validar = new ValidarCampos(this);
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		setTitle("Agregar Empleado");
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setBounds(0, 0, 717, 668);
		
		//Definir color de fondo para campos obligatorios
		
		float h = Color.RGBtoHSB(255, 255, 224, null)[0];
		float s = Color.RGBtoHSB(255, 255, 224, null)[1];
		float b = Color.RGBtoHSB(255, 255, 224, null)[2];
		//
		
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
		
		lblFoto = new JLabel("");
		lblFoto.setBounds(68, 52, 130, 150);
		panel_1.add(lblFoto);
		panel_1.add(fotoEmpleado);
		
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "Informacion Personal", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(337, 11, 335, 455);
		panel_1.add(panel_5);
		
		direccionEmpleado = new JTextField();
		direccionEmpleado.setBackground(Color.getHSBColor(h, s, b));
		direccionEmpleado.setColumns(10);
		direccionEmpleado.setBounds(177, 114, 141, 20);
		panel_5.add(direccionEmpleado);
		
		telefonoEmpleado = new JTextField();
		telefonoEmpleado.setBackground(Color.getHSBColor(h, s, b));
		telefonoEmpleado.setColumns(10);
		telefonoEmpleado.setBounds(177, 240, 141, 20);
		panel_5.add(telefonoEmpleado);
		
		celularEmpleado = new JTextField();
		celularEmpleado.setBackground(Color.getHSBColor(h, s, b));
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
		estadoCivilEmpleado.setBounds(177, 36, 141, 20);
		for (int i = 0; i < tipoEstadoCivil.length; i++){
			estadoCivilEmpleado.addItem(tipoEstadoCivil[i]);
		}
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
		ciudadEmpleado.setBackground(Color.getHSBColor(h, s, b));
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
		
		btnSubirFoto = new JButton("Agregar Foto");
		btnSubirFoto.setActionCommand("Subir Foto");
		btnSubirFoto.addActionListener(this);
		btnSubirFoto.setBounds(68, 239, 130, 23);
		panel_1.add(btnSubirFoto);
		
//		dateChooserFechaCompra = new JDateChooser();
//		dateChooserFechaCompra.setBounds(119, 128, 218, 20);
		
		JLabel label = new JLabel("Nombres:");
		label.setBounds(27, 298, 115, 14);
		panel_1.add(label);
		
		nombreEmpleado = new JTextField();
		nombreEmpleado.setBackground(Color.getHSBColor(h, s, b));
		nombreEmpleado.setBounds(141, 295, 141, 20);
		panel_1.add(nombreEmpleado);
		nombreEmpleado.setColumns(10);
		
		JLabel label_1 = new JLabel("Apellidos:");
		label_1.setBounds(27, 332, 95, 14);
		panel_1.add(label_1);
		
		apellidosEmpleado = new JTextField();
		apellidosEmpleado.setBackground(Color.getHSBColor(h, s, b));
		apellidosEmpleado.setBounds(141, 332, 141, 20);
		panel_1.add(apellidosEmpleado);
		apellidosEmpleado.setColumns(10);
		
		JLabel lblTipoDocumento_1 = new JLabel("Tipo Documento");
		lblTipoDocumento_1.setBounds(27, 369, 95, 14);
		panel_1.add(lblTipoDocumento_1);
		
		tipoDocumentoEmpleado = new JComboBox();
		tipoDocumentoEmpleado.setBounds(141, 366, 141, 20);
		for (int i = 0; i < tipoDocumento.length; i++){
			tipoDocumentoEmpleado.addItem(tipoDocumento[i]);
		}
		panel_1.add(tipoDocumentoEmpleado);
		
		JLabel lblNoDocumento = new JLabel("No. Documento:");
		lblNoDocumento.setBounds(27, 405, 95, 14);
		panel_1.add(lblNoDocumento);
		
		cedulaEmpleado = new JTextField();
		cedulaEmpleado.setBackground(Color.getHSBColor(h, s, b));
		cedulaEmpleado.setBounds(141, 402, 141, 20);
		panel_1.add(cedulaEmpleado);
		cedulaEmpleado.setColumns(10);
		
		JLabel lblSexo = new JLabel("Sexo:");
		lblSexo.setBounds(27, 441, 135, 14);
		panel_1.add(lblSexo);
		
		sexoEmpleado = new JComboBox();
		sexoEmpleado.setBounds(141, 438, 141, 20);
		for (int i = 0; i < tipoSexo.length; i++){
			sexoEmpleado.addItem(tipoSexo[i]);
		}
		panel_1.add(sexoEmpleado);
		
		JPanel panel_3 = new JPanel();
		panel_3.setEnabled(true);
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
		
		btnAgregarHijo = new JButton("Agregar");
		btnAgregarHijo.setActionCommand("Agregar Hijo");
		btnAgregarHijo.addActionListener(this);
		btnAgregarHijo.setBounds(345, 253, 145, 23);
		panel_6.add(btnAgregarHijo);
		
		btnNuevoHijo = new JButton("Nuevo");
		btnNuevoHijo.setActionCommand("Nuevo Hijo");
		btnNuevoHijo.addActionListener(this);
		btnNuevoHijo.setBounds(505, 253, 145, 23);
		btnNuevoHijo.setEnabled(false);
		panel_6.add(btnNuevoHijo);
		
		btnEditarHijo = new JButton("Editar");
		btnEditarHijo.setActionCommand("Editar Hijo");
		btnEditarHijo.addActionListener(this);
		btnEditarHijo.setBounds(345, 285, 145, 23);
		btnEditarHijo.setEnabled(false);
		panel_6.add(btnEditarHijo);
		
		btnEliminarHijo = new JButton("Eliminar");
		btnEliminarHijo.setActionCommand("Eliminar Hijo");
		btnEliminarHijo.addActionListener(this);
		btnEliminarHijo.setBounds(505, 285, 145, 23);
		btnEliminarHijo.setEnabled(false);
		panel_6.add(btnEliminarHijo);
		

		Object[] columns = {" ","Nombre","Edad"};
		DefaultTableModel mod = new DefaultTableModel(columns,0)
		{

			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};

		tableHijos = new JTable(mod);
		tableHijos.getColumnModel().getColumn(0).setPreferredWidth(30);
		tableHijos.getTableHeader().setReorderingAllowed(false);
		
		tableHijos.getSelectionModel().addListSelectionListener(listenerReferencias);
		
		JScrollPane scrollPane = new JScrollPane(tableHijos);
		scrollPane.setBounds(337, 11, 315, 230);
		panel_6.add(scrollPane);
		
		fechaNacimientoHijo = new JDateChooser();
		fechaNacimientoHijo.setBounds(155, 244, 144, 20);
		panel_6.add(fechaNacimientoHijo);
		
		sexoHijos = new JComboBox();
		sexoHijos.setBounds(155, 196, 141, 20);
		for (int i = 0; i < tipoSexo.length; i++){
			sexoHijos.addItem(tipoSexo[i]);
		}
		panel_6.add(sexoHijos);
		
		JLabel label_11 = new JLabel("No. Documento:");
		label_11.setBounds(10, 154, 104, 14);
		panel_6.add(label_11);
		
		tipoDocumentoHijos = new JComboBox();
		tipoDocumentoHijos.setBounds(155, 110, 141, 20);
		tipoDocumentoHijos.setBounds(155, 110, 141, 20);
		for (int i = 0; i < tipoDocumento.length; i++){
			tipoDocumentoHijos.addItem(tipoDocumento[i]);
		}
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
		
		sexoPareja = new JComboBox();
		sexoPareja.setBounds(511, 109, 141, 20);
		for (int i = 0; i < tipoSexo.length; i++){
			sexoPareja.addItem(tipoSexo[i]);
		}
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
		panel_7.setBounds(21, 11, 308, 492);
		panel_2.add(panel_7);
		
		JLabel label_12 = new JLabel("Salario Fijo:");
		label_12.setBounds(10, 70, 87, 14);
		panel_7.add(label_12);
		
		JLabel label_13 = new JLabel("Cargo:");
		label_13.setBounds(10, 31, 87, 14);
		panel_7.add(label_13);
		
		cargoEmpleado = new JTextField();
		cargoEmpleado.setBackground(Color.getHSBColor(h, s, b));
		cargoEmpleado.setColumns(10);
		cargoEmpleado.setBounds(154, 28, 131, 20);
		panel_7.add(cargoEmpleado);
		
		salarioFijo = new JTextField();
		salarioFijo.setColumns(10);
		salarioFijo.setBackground(Color.getHSBColor(h, s, b));
		salarioFijo.setBounds(154, 67, 131, 20);
		panel_7.add(salarioFijo);
		
		salarioVariable = new JTextField();
		salarioVariable.setColumns(10);
		salarioVariable.setBounds(155, 107, 130, 20);
		panel_7.add(salarioVariable);
		salarioVariable.setEnabled(false);
		
		JLabel label_14 = new JLabel("Salario Variable: ");
		label_14.setBounds(10, 110, 115, 14);
		panel_7.add(label_14);
		
		JLabel lblTipoContrato = new JLabel("Tipo Contrato:");
		lblTipoContrato.setBounds(10, 204, 115, 14);
		panel_7.add(lblTipoContrato);
		
		tipoContrato = new JComboBox();
		tipoContrato.setBounds(154, 201, 131, 20);
		for (int i = 0; i < tipoContratoOpciones.length; i++){
			tipoContrato.addItem(tipoContratoOpciones[i]);
		}
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
		for (int i = 0; i < tipoDuracionContrato.length; i++){
			duracionContrato.addItem(tipoDuracionContrato[i]);
		}
		panel_7.add(duracionContrato);
		
		JLabel lblAuxilioDeTransp = new JLabel("Auxilio de Transporte: ");
		lblAuxilioDeTransp.setBounds(10, 446, 137, 14);
		panel_7.add(lblAuxilioDeTransp);
		
		fechaInicioContrato = new JDateChooser();
		fechaInicioContrato.setBounds(154, 297, 131, 20);
		panel_7.add(fechaInicioContrato);
		
		fechaFinContrato = new JDateChooser();
		fechaFinContrato.setBounds(154, 350, 131, 20);
		panel_7.add(fechaFinContrato);
		
		JLabel lblTipoLiquidacion = new JLabel("Tipo Liquidaci\u00F3n:");
		lblTipoLiquidacion.setBounds(10, 401, 137, 14);
		panel_7.add(lblTipoLiquidacion);
		
		tipoLiquidacionEmpleado = new JComboBox();
		tipoLiquidacionEmpleado.setBounds(154, 398, 131, 20);
		for (int i = 0; i < tipoPeriodoLiquidacion.length; i++){
			tipoLiquidacionEmpleado.addItem(tipoPeriodoLiquidacion[i]);
		}
		panel_7.add(tipoLiquidacionEmpleado);
		
		checkAuxilio = new JCheckBox("   Si");
		checkAuxilio.setBackground(Color.WHITE);
		checkAuxilio.setBounds(154, 442, 97, 23);
		panel_7.add(checkAuxilio);
		
		JLabel lblHorasSemanales = new JLabel("Horas Semanales:");
		lblHorasSemanales.setBounds(10, 158, 137, 14);
		panel_7.add(lblHorasSemanales);
		
		horasSemanales = new JTextField();
		horasSemanales.setBackground(Color.getHSBColor(h, s, b));
		horasSemanales.setColumns(10);
		horasSemanales.setBounds(154, 155, 130, 20);
		panel_7.add(horasSemanales);
		
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
		
		saludEmpleado = new JComboBox();
		saludEmpleado.setBounds(154, 28, 131, 20);
		for (int i = 0; i < tipoSalud.length; i++){
			saludEmpleado.addItem(tipoSalud[i]);
		}
		panel_12.add(saludEmpleado);
		
		JLabel label_37 = new JLabel("Fecha Afiliaci\u00F3n a SS:");
		label_37.setBounds(10, 198, 137, 14);
		panel_12.add(label_37);
		
		pensionesEmpleado = new JComboBox();
		pensionesEmpleado.setBounds(154, 67, 131, 20);
		for (int i = 0; i < tipoPensiones.length; i++){
			pensionesEmpleado.addItem(tipoPensiones[i]);
		}
		panel_12.add(pensionesEmpleado);
		
		arlEmpleado = new JComboBox();
		arlEmpleado.setBounds(154, 107, 131, 20);
		for (int i = 0; i < tipoARL.length; i++){
			arlEmpleado.addItem(tipoARL[i]);
		}
		panel_12.add(arlEmpleado);
		
		fechaAfiliacionSS = new JDateChooser();
		fechaAfiliacionSS.setBounds(154, 198, 131, 20);
		panel_12.add(fechaAfiliacionSS);
		
		JLabel lblCajaDeCompensacin = new JLabel("Caja de Compensaci\u00F3n");
		lblCajaDeCompensacin.setBounds(10, 151, 137, 14);
		panel_12.add(lblCajaDeCompensacin);
		
		cajaCompensacionEmpleado = new JComboBox();
		cajaCompensacionEmpleado.setBounds(154, 148, 131, 20);
		for (int i = 0; i < tipoCajaCompensacion.length; i++){
			cajaCompensacionEmpleado.addItem(tipoCajaCompensacion[i]);
		}
		panel_12.add(cajaCompensacionEmpleado);
		
		JLabel lblSolidaridad = new JLabel("Solidaridad:");
		lblSolidaridad.setBounds(10, 247, 137, 14);
		panel_12.add(lblSolidaridad);
		
		checkSolidaridad = new JCheckBox("   Si");
		checkSolidaridad.setBounds(154, 243, 97, 23);
		panel_12.add(checkSolidaridad);
		checkSolidaridad.setBackground(Color.WHITE);
		checkSolidaridad.setEnabled(false);
		
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
		
		listenerTablas = new ListSelectionListener(){
			public void valueChanged(ListSelectionEvent event) {
				//TODO
					Object source = event.getSource();
					int index = 0;
					
					if (source.equals(tableReferencias.getSelectionModel())){
						index = tableReferencias.getSelectedRow();
						actualizarInformacionReferencia(index,posicion);
					}
					else if (source.equals(tableExperiencia.getSelectionModel())){
						index = tableExperiencia.getSelectedRow();
						actualizarInformacionExperiencia(index,posicion);
					}
					else if (source.equals(tableHijos.getSelectionModel())){
						index = tableHijos.getSelectedRow();
						actualizarInformacionHijo(index,posicion);
					}
					
			}

		};

		tableReferencias.getSelectionModel().addListSelectionListener(listenerTablas);
		
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
		sexoReferencia.setBounds(154, 249, 179, 20);
		for (int i = 0; i < tipoSexo.length; i++){
			sexoReferencia.addItem(tipoSexo[i]);
		}
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
		
		control = controlP;
		interfaz = interfazP;
		
		control.crearNuevoEmpleado(-1, "", "", "", "", new Date(), 
				"", "", -1, -1, -1, "", "", "", "");
	
		tabbedPane.setEnabledAt(1, true);
		tabbedPane.setEnabledAt(2, true);
		tabbedPane.setEnabledAt(3, true);
		tabbedPane.setEnabledAt(4, true);
			
		if (posicion > -1){
			Empleado e = interfaz.getListaEmpleados().get(posicion);
			
			nombreEmpleado.setText(e.getNombres()); 
			apellidosEmpleado.setText(e.getApellidos());
			cedulaEmpleado.setText(String.valueOf(formatoNumeros.format(e.getIdentificacion())));
			direccionEmpleado.setText(e.getDireccion());
			telefonoEmpleado.setText(String.valueOf(formatoNumeros.format(e.getTelefono())));
			celularEmpleado.setText(String.valueOf(formatoNumeros.format(e.getCelular())));
			correoEmpleado.setText(e.getCorreo());
			cargoEmpleado.setText(e.getContrato().getCargo());
			salarioFijo.setText(String.valueOf(formatoNumeros.format(e.getContrato().getSueldoBasico())));
			salarioVariable.setText(String.valueOf(formatoNumeros.format(e.calcularSueldoVariable())));
			
			nombrePareja.setText(e.getConyugue().getNombres());
			apellidosPareja.setText(e.getConyugue().getApellidos());
			cedulaPareja.setText(String.valueOf(formatoNumeros.format(e.getConyugue().getIdentificacion())));
			
			fechaNacimientoEmpleado.setDate(e.getFechaNacimiento());
			fechaInicioContrato.setDate(e.getContrato().getFechaInicio());
			fechaFinContrato.setDate(e.getContrato().getFechaFin());
			fechaAfiliacionSS.setDate(e.getFechaAfiliacionSS());
			
			sexoEmpleado.setSelectedItem(e.getSexo());
			estadoCivilEmpleado.setSelectedItem(e.getEstadoCivil());
			tipoDocumentoEmpleado.setSelectedItem(e.getTipoDocumento());
			tipoContrato.setSelectedItem(e.getContrato().getTipoContrato());
			duracionContrato.setSelectedItem(e.getContrato().getTipoSalario());
			
			sexoPareja.setSelectedItem(e.getConyugue().getSexo());
			tipoLiquidacionEmpleado.setSelectedItem(e.getContrato().getPeriodoLiquidacion());
			saludEmpleado.setSelectedItem(e.getSalud());
			pensionesEmpleado.setSelectedItem(e.getPensiones());
			arlEmpleado.setSelectedItem(e.getArl());
			cajaCompensacionEmpleado.setSelectedItem(e.getCajaCompensacion());

			telefonoPareja.setText(String.valueOf(e.getConyugue().getTelefono()));
			direccionPareja.setText(e.getConyugue().getDireccion());
			ciudadPareja.setText(e.getConyugue().getCiudad());
			ciudadEmpleado.setText(e.getCiudad());
			
			departamentoEmpleado.setText(e.getDepartamento());
			nacionalidadEmpleado.setText(e.getNacionalidad());
			horasSemanales.setText(String.valueOf(formatoNumeros.format(e.getContrato().getHorasSemana())));
			
			checkSolidaridad.setSelected(e.getSolidaridad());
			checkAuxilio.setSelected(e.getContrato().isAuxilioTransporte());
			
			setCamposEditables(false);
			
			actualizarTablaExperiencia(posicion);
			actualizarTablaHijos(posicion);
			actualizarTablaReferecnias(posicion);
			
		}
		
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
		agregarEmpleado();
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
		
		tableReferencias.getSelectionModel().removeListSelectionListener(listenerTablas);
		tableReferencias.clearSelection();
		tableReferencias.getSelectionModel().addListSelectionListener(listenerTablas);
		
		
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
		
		tableExperiencia.getSelectionModel().removeListSelectionListener(listenerTablas);
		tableExperiencia.clearSelection();
		tableExperiencia.getSelectionModel().addListSelectionListener(listenerTablas);
		
		limpiarCamposExperiencia();
		btnNuevaExperiencia.setEnabled(false);
		btnEditarExperiencia.setEnabled(false);
		btnEliminarExperiencia.setEnabled(false);
		btnAgregarExperiencia.setEnabled(true);
	}
	else if (command.equals("Agregar Hijo")){
		agregarHijos();
		System.out.println("command");
	}
	else if (command.equals("Editar Hijo")){
		editarHijo();
	}
	else if (command.equals("Eliminar Hijo")){
		eliminarHijo();
		btnNuevoHijo.setEnabled(false);
		btnEditarHijo.setEnabled(false);
		btnEliminarHijo.setEnabled(false);
		btnAgregarHijo.setEnabled(true);
	}
	else if (command.equals("Nuevo Hijo")){
		
		tableHijos.getSelectionModel().removeListSelectionListener(listenerTablas);
		tableHijos.clearSelection();
		tableHijos.getSelectionModel().addListSelectionListener(listenerTablas);
		
		limpiarCamposHijos();
		btnNuevoHijo.setEnabled(false);
		btnEditarHijo.setEnabled(false);
		btnEliminarHijo.setEnabled(false);
		btnAgregarHijo.setEnabled(true);
	}
	else if (command.equals("Subir Foto")){
		subirFotoEmpleado();
	}
}
	

public void agregarReferencia() {
	
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
	
	if (verificarCamposReferencias() > 0){
		
		double telefonoP = Integer.parseInt(telefonoP0);
		double documentoP = Integer.parseInt(documentoP0);
		
		control.agregarReferenciaEmpleadoNuevo(nombresP, apellidosP, 
				telefonoP, documentoP, sexoP, direccionP, ciudadP, 
				departamentoP, tipoP, empresaP, conceptoP);
		actualizarTablaReferecnias(-1);
		limpiarCamposReferencias();
	}
			
}



public void agregarExperiencia(){
	
	String empresaP = empresaExperiencia.getText();
	String cargoP = cargoExperiencia.getText();
	String tipoP = tipoContratoExperiencia.getSelectedItem().toString();

	Date fechaInicioP = fechaInicioExperiencia.getDate();
	Date fechaFinP  = fechafinExperiencia.getDate();
	
	if (verificarCamposExperiencia() >= 0){
		
		control.agregarExperienciaEmpleadoNuevo(cargoP, empresaP, tipoP, fechaInicioP, fechaFinP);
		actualizarTablaExperiencia(-1);
		limpiarCamposExperiencia();
	}
	
}

public void agregarHijos(){

	
	String nombreP = nombreHijo.getText();
	String apellidosP = apellidosHijo.getText();
	String tipoP = tipoDocumentoHijos.getSelectedItem().toString();
	String sexoP = sexoHijos.getSelectedItem().toString();
	Date fechaP = fechaNacimientoHijo.getDate();
	String direccionP = direccionHijos.getText();
	
	String documentoP0 = cedulaHijo.getText();
	double identificacionP = 0;
	
	int confirmacion = verificarCamposHijo();
	System.out.println(""+confirmacion);
	
	if (confirmacion > 0){
		
		if (confirmacion == 1){
			identificacionP = 0;
		}
		else if (confirmacion == 2){
			identificacionP = Integer.parseInt(documentoP0);
		}
		control.agregarHijoEmpleadoNuevo(nombreP, apellidosP, 0, identificacionP, sexoP, direccionP, "", "", tipoP, fechaP);
		actualizarTablaHijos(-1);
		limpiarCamposHijos();
	}
	
}

public void agregarEmpleado(){

	int res0 = agregarInfoConyugue();
	if (res0 > 0)	{
		
		int res = agregarInfoLaboral();

		if (res == 1 || res == 2){
			
			int res2 = agregarInfoEmpleado();
			
			if (res2 == 1 || res2 == 2){
				
				control.agregarEmpleado();
				interfaz.actualizarListaEmpleados();
				this.dispose();
			}
		}
	}
	
}

public void editarReferencia(){
	int confirm = JOptionPane.showConfirmDialog(this, "¿Desea guardar los cambios realizados?","Warning",JOptionPane.YES_NO_OPTION);
	if (confirm == JOptionPane.YES_NO_OPTION){
		
		int posicion = tableReferencias.getSelectedRow();
		
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
		
		if (verificarCamposReferencias() > 0){
			
			System.out.println("verificacion correcta");
			
			control.editarReferenciaEmpleadoNuevo(posicion, tipoP,
					nombresP, apellidosP,Double.parseDouble(documentoP0),
					Integer.parseInt(telefonoP0),sexoP,direccionP,
					ciudadP,empresaP,conceptoP);
			
			btnNuevaReferencia.setEnabled(false);
			btnEditarReferencia.setEnabled(false);
			btnEliminarReferencia.setEnabled(false);
			btnAgregarReferencia.setEnabled(true);
			
			limpiarCamposHijos();
			
			actualizarTablaReferecnias(-1);
		}
	}		
}

public void editarExperiencia(){
	int confirm = JOptionPane.showConfirmDialog(this, "¿Desea guardar los cambios realizados?","Warning",JOptionPane.YES_NO_OPTION);
	if (confirm == JOptionPane.YES_NO_OPTION){
		
		int posicion = tableExperiencia.getSelectedRow();
		
		String empresaP = empresaExperiencia.getText();
		String cargoP = cargoExperiencia.getText();
		String tipoP = tipoContratoExperiencia.getSelectedItem().toString();
		Date fechaInicioP = fechaInicioExperiencia.getDate();
		Date fechaFinP  = fechafinExperiencia.getDate();
		
		if (verificarCamposExperiencia() > 0){
			
			control.editarExperienciaEmpleadoNuevo(posicion, empresaP, cargoP, tipoP, fechaInicioP, fechaFinP);
			
			btnNuevaExperiencia.setEnabled(false);
			btnEditarExperiencia.setEnabled(false);
			btnEliminarExperiencia.setEnabled(false);
			btnAgregarExperiencia.setEnabled(true);
			
			limpiarCamposExperiencia();
			actualizarTablaExperiencia(-1);
		}
	}
}

public void editarHijo(){
	
	int confirm = JOptionPane.showConfirmDialog(this, "¿Desea guardar los cambios realizados?","Warning",JOptionPane.YES_NO_OPTION);
	if (confirm == JOptionPane.YES_NO_OPTION){
		
		int posicion = tableHijos.getSelectedRow();
		
		String nombreP = nombreHijo.getText();
		String apellidosP = apellidosHijo.getText();
		String tipoP = tipoDocumentoHijos.getSelectedItem().toString();
		String sexoP = sexoHijos.getSelectedItem().toString();
		Date fechaP = fechaNacimientoHijo.getDate();
		String direccionP = direccionHijos.getText();
		
		String documentoP0 = cedulaHijo.getText();
		
		int confirmacion = verificarCamposHijo();
		double identificacionP = 0;
		
		if (confirmacion > 0){
			
			if (confirmacion == 1){
				identificacionP = 0;
			}
			else if (confirmacion == 2){
				identificacionP = Double.parseDouble(documentoP0);
			}
			
			control.editarHijoEmpleadoNuevo(posicion, nombreP, apellidosP, tipoP, identificacionP, sexoP, fechaP, direccionP);
			
			btnNuevoHijo.setEnabled(false);
			btnEditarHijo.setEnabled(false);
			btnEliminarHijo.setEnabled(false);
			btnAgregarHijo.setEnabled(true);
			
			limpiarCamposHijos();
			
			actualizarTablaHijos(-1);
		}
		
	}
}

public void eliminarReferencia(){
	
	int posicion = tableReferencias.getSelectedRow();
	DefaultTableModel dm = (DefaultTableModel) tableReferencias.getModel();
	int confirm = JOptionPane.showConfirmDialog(this, "¿Desea eliminar la referencia seleccionada?","Warning",JOptionPane.YES_NO_OPTION);
	
	if (confirm == JOptionPane.YES_NO_OPTION){
		control.eliminarReferenciaEmpleadoNuevo(posicion);
		tableReferencias.getSelectionModel().removeListSelectionListener(listenerTablas);
		modRP.removeRow(posicion);
		tableReferencias.getSelectionModel().addListSelectionListener(listenerTablas);
	}
	
	if(control.darListaReferecniasEmpleadoNuevo().isEmpty()){
		limpiarCamposReferencias();
	}
	else{
		actualizarInformacionReferencia(0,-1);
	}
}

public void eliminarExperiencia(){
	
	int posicion = tableExperiencia.getSelectedRow();
	
	DefaultTableModel dm = (DefaultTableModel) tableExperiencia.getModel();
	int confirm = JOptionPane.showConfirmDialog(this, "¿Desea eliminar la experiencia seleccionada?","Warning",JOptionPane.YES_NO_OPTION);
	
	if (confirm == JOptionPane.YES_NO_OPTION){
		control.eliminarExperienciaEmpleadoNuevo(posicion);
		tableExperiencia.getSelectionModel().removeListSelectionListener(listenerTablas);
		modExp.removeRow(posicion);
		tableExperiencia.getSelectionModel().addListSelectionListener(listenerTablas);
	}
	
	if(control.darListaExperienciaEmpleadoNuevo().isEmpty()){
		limpiarCamposExperiencia();
	}
	else{
		actualizarInformacionExperiencia(0,-1);
	}
}

public void eliminarHijo(){
	
	int posicion = tableHijos.getSelectedRow();
	
	DefaultTableModel dm = (DefaultTableModel) tableHijos.getModel();
	int confirm = JOptionPane.showConfirmDialog(this, "¿Desea eliminar el hijo seleccionado?","Warning",JOptionPane.YES_NO_OPTION);
	
	if (confirm == JOptionPane.YES_NO_OPTION){
		control.eliminarHijoEmpleadoNuevo(posicion);
		tableHijos.getSelectionModel().removeListSelectionListener(listenerTablas);
		dm.removeRow(posicion);
		tableHijos.getSelectionModel().addListSelectionListener(listenerTablas);
	}
	
	if(control.darListaHijosEmpleadoNuevo().isEmpty()){
		limpiarCamposHijos();
	}
	else{
		actualizarInformacionHijo(0,-1);
	}
}

public void actualizarInformacionReferencia(int index, int posicion) {
	
	ArrayList<Referencia> lista = new ArrayList();
	if (posicion > -1){		
		 lista = control.darListaReferecniasEmpleado();
	}
	else{
		lista = control.darListaReferecniasEmpleadoNuevo();
	}
	Referencia ref = lista.get(index);

	nombreReferencia.setText(ref.getNombres());
	apellidosReferencia.setText(ref.getApellidos());
	documentoReferencia.setText(String.valueOf(formatoNumeros.format(ref.getIdentificacion())));
	telefonoReferencia.setText(String.valueOf(formatoNumeros.format(ref.getTelefono())));
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
	
	for (int i = 0; i < tipoSexo.length; i++){
		if (tipoSexo[i].equalsIgnoreCase(ref.getSexo())){
			sexoReferencia.setSelectedIndex(i);
		}	
	}
	
	btnNuevaReferencia.setEnabled(true);
	btnEditarReferencia.setEnabled(true);
	btnEliminarReferencia.setEnabled(true);
	btnAgregarReferencia.setEnabled(false);
	
}


public void actualizarInformacionExperiencia(int index, int posicion){
	
	ArrayList<Experiencia> lista = new ArrayList();
	
	if (posicion > -1){
		lista = control.darListaExperienciaEmpleado();
	}
	else{
		lista = control.darListaExperienciaEmpleadoNuevo();
	}

	Experiencia e = lista.get(index);
	
	empresaExperiencia.setText(e.getEmpresa());
	cargoExperiencia.setText(e.getCargo());
	
	
	boolean listo = false;
	
	for (int i = 0; i < tipoContratoOpciones.length; i++){
		if (tipoContratoOpciones[i].equalsIgnoreCase(e.getTipoContrato())){
			System.out.println(tipoContratoOpciones[i]);
			tipoContratoExperiencia.setSelectedIndex(i);
		}	
	}
	
	fechaInicioExperiencia.setDate(e.getFechaInicio());
	fechafinExperiencia.setDate(e.getFechaFin());
	
	btnNuevaExperiencia.setEnabled(true);
	btnEditarExperiencia.setEnabled(true);
	btnEliminarExperiencia.setEnabled(true);
	btnAgregarExperiencia.setEnabled(false);
	
}

public void actualizarInformacionHijo(int index, int posicion){
	
	ArrayList<Hijo> lista = new ArrayList();
	System.out.println("A");
	if (posicion > -1){
		System.out.println("B");
		lista = control.darListaHijosEmpleado();
		
	}
	else{
		System.out.println("C");
		lista = control.darListaHijosEmpleadoNuevo();
	}

	Hijo hij = lista.get(index);
	
	nombreHijo.setText(hij.getNombres());
	apellidosHijo.setText(hij.getApellidos());

	for (int i = 0; i < tipoDocumento.length; i++){
		if (tipoDocumento[i].equalsIgnoreCase(hij.getTipoDocumento())){
			tipoDocumentoHijos.setSelectedIndex(i);
		}	
	}
	
	cedulaHijo.setText(String.valueOf(formatoNumeros.format(hij.getIdentificacion())));
	
	for (int i = 0; i < tipoSexo.length; i++){
		if (tipoSexo[i].equalsIgnoreCase(hij.getSexo())){
			sexoHijos.setSelectedIndex(i);
		}	
	}
	
	fechaNacimientoHijo.setDate(hij.getFechaNacimiento());
	direccionHijos.setText(hij.getDireccion());
	
	btnNuevoHijo.setEnabled(true);
	btnEditarHijo.setEnabled(true);
	btnEliminarHijo.setEnabled(true);
	btnAgregarHijo.setEnabled(false);
	
}

public void actualizarTablaReferecnias(int pos){
	
	tableReferencias.getSelectionModel().removeListSelectionListener(listenerTablas);
	
	DefaultTableModel model = (DefaultTableModel) tableReferencias.getModel();
	model.setRowCount(0);
	
	ArrayList listaReferencias = new ArrayList();
	
	if (pos > -1){
		listaReferencias = control.darListaReferecniasEmpleado();
	}
	else{
		listaReferencias = control.darListaReferecniasEmpleadoNuevo();	
	}
	
	for (int i = 0;  i<listaReferencias.size(); i++){

		Referencia actual = (Referencia) listaReferencias.get(i);
		model.addRow(new Object[]{i+1,actual.getNombres() + "" + actual.getApellidos(), actual.getTipo()});
	}	
	
	tableReferencias.getSelectionModel().addListSelectionListener(listenerTablas);
}


public void actualizarTablaExperiencia(int pos){
	
	tableExperiencia.getSelectionModel().removeListSelectionListener(listenerTablas);
	
	DefaultTableModel model = (DefaultTableModel) tableExperiencia.getModel();
	model.setRowCount(0);
	
	ArrayList listaExperiencia = new ArrayList();
	
	if (pos > -1){
		listaExperiencia = control.darListaExperienciaEmpleado();
	}
	else{
		listaExperiencia = control.darListaExperienciaEmpleadoNuevo();
	}
	
	for (int i = 0;  i< listaExperiencia.size(); i++){

		Experiencia actual = (Experiencia) listaExperiencia.get(i);
		model.addRow(new Object[]{i+1,actual.getEmpresa(), actual.getCargo(), sdf.format(actual.getFechaInicio()), sdf.format(actual.getFechaFin())});
	}	
	
	tableExperiencia.getSelectionModel().addListSelectionListener(listenerTablas);
}

public void actualizarTablaHijos(int pos){
	
	tableHijos.getSelectionModel().removeListSelectionListener(listenerTablas);
	
	DefaultTableModel model = (DefaultTableModel) tableHijos.getModel();
	model.setRowCount(0);
	
	ArrayList listaHijos = new ArrayList();
	
	
	if (pos > -1){
		listaHijos = control.darListaHijosEmpleado();
	}
	else{
		listaHijos = control.darListaHijosEmpleadoNuevo();
	}
	
	for (int i = 0;  i< listaHijos.size(); i++){

		Hijo actual = (Hijo) listaHijos.get(i);
		Date fechaActual = new Date();
		int edad = fechaActual.getYear() - actual.getFechaNacimiento().getYear(); 
		
		model.addRow(new Object[]{i+1,actual.getNombres(), ""+edad});
	}	
	
	tableHijos.getSelectionModel().addListSelectionListener(listenerTablas);
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

public void limpiarCamposExperiencia(){
	
	empresaExperiencia.setText("");
	cargoExperiencia.setText("");
	tipoContrato.setSelectedIndex(0);
	fechaInicioExperiencia.setDate(new Date());
	fechafinExperiencia.setDate(new Date());
}

public void limpiarCamposHijos(){
	
	nombreHijo.setText("");
	apellidosHijo.setText("");
	tipoDocumentoHijos.setSelectedIndex(0);
	cedulaHijo.setText("");
	sexoHijos.setSelectedIndex(0);
	fechaNacimientoHijo.setDate(new Date());
	direccionHijos.setText("");
}

public int agregarInfoConyugue(){
	int res = 0;
	
	String nombreP = nombrePareja.getText();
	String apellidosP = apellidosPareja.getText();
	String documentoP0 = cedulaPareja.getText();
	String telefonoP0 = telefonoPareja.getText();
	
	res = verificarCamposConyugue();
	
	String sexoP = sexoPareja.getSelectedItem().toString();
	String direccionP = direccionPareja.getText();
	String ciudadP = ciudadPareja.getText();
	
	double documentoP = 0;
	double telefonoP = 0;
	
	if (res == 2){
		
		documentoP = Double.parseDouble(documentoP0);
		telefonoP = Double.parseDouble(telefonoP0);		
	}

	control.agregarConyugueEmpleadoNuevo(nombreP, apellidosP, documentoP, telefonoP, null, sexoP, direccionP, ciudadP);
	
	return res;
}

public int agregarInfoLaboral(){
	
	String cargoP = cargoEmpleado.getText();
	String salarioFijoP0 = salarioFijo.getText();
	String horasP0 = horasSemanales.getText();
	String periodoLiquidacionP0 = tipoLiquidacionEmpleado.getSelectedItem().toString();
	boolean auxilioP = checkAuxilio.isSelected();
	
	int res = verificarCamposLaborales();
	
	if (res > 0){
		
		double salarioFijoP = Double.parseDouble(salarioFijoP0);
		int horasP = Integer.parseInt(horasP0);
		int periodoLiquidacionP = Integer.parseInt(periodoLiquidacionP0);
		
		control.agregarInfoLaboralEmpleadoNuevo(cargoP, salarioFijoP,horasP,tipoContrato.getSelectedItem().toString(),
				duracionContrato.getSelectedItem().toString(),fechaInicioContrato.getDate(),fechaFinContrato.getDate(),
				periodoLiquidacionP,saludEmpleado.getSelectedItem().toString(),
				pensionesEmpleado.getSelectedItem().toString(),arlEmpleado.getSelectedItem().toString(),
				false ,cajaCompensacionEmpleado.getSelectedItem().toString(),
				fechaAfiliacionSS.getDate(),auxilioP);

	}
	
	return res;
	
}

public int agregarInfoEmpleado(){
	
	int res = verificarCamposEmpleado();
	
	String nombreP = nombreEmpleado.getText();
	String apellidosP = apellidosEmpleado.getText();
	String tipoP = tipoDocumentoEmpleado.getSelectedItem().toString();
	String sexoP = sexoEmpleado.getSelectedItem().toString();
	String estadoCivilP = estadoCivilEmpleado.getSelectedItem().toString();
	Date fechaP = fechaNacimientoEmpleado.getDate();
	String documentoP0 = cedulaEmpleado.getText();
	String direccionP = direccionEmpleado.getText();
	String ciudadP = ciudadEmpleado.getText();
	String departamentoP = departamentoEmpleado.getText();
	String correoP = correoEmpleado.getText();
	String nacionalidadP = nacionalidadEmpleado.getText();
	
	String telefonoP0 = telefonoEmpleado.getText();
	String celularP0 = celularEmpleado.getText();
	
	if (res > 0){
		
		Double documentoP = Double.parseDouble(documentoP0);	
		Double telefonoP = Double.parseDouble(telefonoP0);	
		Double celularP = Double.parseDouble(celularP0);
		
		control.agregarInfoPersonalEmpleadoNuevo(nombreP,apellidosP,tipoP,documentoP,
				sexoP, estadoCivilP, fechaP, direccionP, ciudadP, departamentoP, correoP, nacionalidadP, telefonoP, celularP, foto);
	}
	
	return res;
}

public int verificarCamposLaborales(){

	int res = 0;
	
	String cargoP = cargoEmpleado.getText();
	String salarioFijoP0 = salarioFijo.getText();
	String horasP0 = horasSemanales.getText();
	String periodoLiquidacionP0 = tipoLiquidacionEmpleado.getSelectedItem().toString();
	
	ArrayList<String> tipo = new ArrayList<String> (Arrays.asList("string","double","int","string"));
	ArrayList<String> valor = new ArrayList<String> (Arrays.asList(cargoP, salarioFijoP0, horasP0, periodoLiquidacionP0));
	ArrayList<Integer> prioridad = new ArrayList<Integer> (Arrays.asList(1,1,1,0));
	ArrayList<String> nombre = new ArrayList<String> (Arrays.asList("Cargo Empleado", "Salario Fijo", "Horas Semanales", "Período Liquidación","Información Laboral"));
	
	res = validar.validar(tipo, valor, prioridad, nombre);
	
//	if (!cargoP.equalsIgnoreCase("") && !salarioFijoP0.equalsIgnoreCase("") &&!horasP0.equalsIgnoreCase("")){
//		
//		try{
//			double salarioFijoP = Double.parseDouble(salarioFijoP0);	
//				try{
//					double periodoLiquidacionP = Integer.parseInt(periodoLiquidacionP0);
//					
//					try{
//						int horasP = Integer.parseInt(horasP0);
//						res = 2;
//					}
//					catch (Exception e){
//						JOptionPane.showMessageDialog(this, "Debe ingresar un valor numérico válido en el campo de horas semanales", "Error", JOptionPane.ERROR_MESSAGE);
//					}
//				}
//				catch (Exception e){
//					JOptionPane.showMessageDialog(this, "Debe ingresar un valor numérico válido en el campo de Periodo de Liquidación", "Error", JOptionPane.ERROR_MESSAGE);
//				}
//								
//		}
//		catch (Exception e){
//			JOptionPane.showMessageDialog(this, "Debe ingresar un valor numérico válido en el campo de salario fijo", "Error", JOptionPane.ERROR_MESSAGE);
//		}			
//	}
//	else{
//		JOptionPane.showMessageDialog(this, "Hay campos vacíos que se deben llenar en la Información Laboral", "Error", JOptionPane.INFORMATION_MESSAGE);
//	}
	
	return res;
}

public int verificarCamposConyugue(){
	int res = 1;
	
	String nombreP = nombrePareja.getText();
	String apellidosP = apellidosPareja.getText();
	String documentoP0 = cedulaPareja.getText();
	String telefonoP0 = telefonoPareja.getText();
	
	ArrayList<String> tipo = new ArrayList<String> (Arrays.asList("string","string","double","double"));
	ArrayList<String> valor = new ArrayList<String> (Arrays.asList(nombreP, apellidosP, documentoP0, telefonoP0));
	ArrayList<Integer> prioridad = new ArrayList<Integer> (Arrays.asList(3,3,3,3));
	ArrayList<String> nombre = new ArrayList<String> (Arrays.asList("Nombre Pareja", "Apellido Pareja", "Documento Pareja", "Telefono Pareja","Información Familiar"));
	
	res = validar.validar(tipo, valor, prioridad, nombre);
	
//	if (!nombreP.equals("") || !apellidosP.equals("") || !documentoP0.equals("") || !telefonoP0.equals("")){
//		
//		if (!nombreP.equals("") && !apellidosP.equals("") && !documentoP0.equals("") && !telefonoP0.equals("")){
//			try{
//				double telefonoP = Double.parseDouble(telefonoP0);	
//				
//				try {
//					double documentoP = Double.parseDouble(documentoP0);
//					res = 2;
//				}
//				catch (Exception e){
//					JOptionPane.showMessageDialog(this, "Debe ingresar valores numéricos válidos en el campo de número del documento de identidad del Cónyugue", "Error", JOptionPane.ERROR_MESSAGE);
//				}
//				
//			}
//			catch (Exception e){
//				JOptionPane.showMessageDialog(this, "Debe ingresar valores numéricos válidos en el campo de número telefónico del Cónyugue", "Error", JOptionPane.ERROR_MESSAGE);
//			}	
//		}
//		else
//		{
//			JOptionPane.showMessageDialog(this, "Debe llenar los campos de nombres, apellidos, telefono y número de documento del Cónyugue", "Error", JOptionPane.ERROR_MESSAGE);
//		}
//		
//	}
//	
//	
 	return res;
}

public int verificarCamposEmpleado(){
	
	int res = 0;
	
	String nombreP = nombreEmpleado.getText();
	String apellidosP = apellidosEmpleado.getText();
	String documentoP0 = cedulaEmpleado.getText();
	String direccionP = direccionEmpleado.getText();
	String ciudadP = ciudadEmpleado.getText();
	
	String telefonoP0 = telefonoEmpleado.getText();
	String celularP0 = celularEmpleado.getText();
	
	String correoP = correoEmpleado.getText();
	String departamentoP = departamentoEmpleado.getText();
	String nacionalidadP = nacionalidadEmpleado.getText();
	
	
	ArrayList<String> tipo = new ArrayList<String> (Arrays.asList("string","string","double","string","string","double","double","string","string","string"));
	ArrayList<String> valor = new ArrayList<String> (Arrays.asList(nombreP, apellidosP, documentoP0, direccionP, ciudadP, telefonoP0, celularP0,correoP,departamentoP,nacionalidadP));
	ArrayList<Integer> prioridad = new ArrayList<Integer> (Arrays.asList(1,1,1,1,1,1,1,0,0,0));
	ArrayList<String> nombre = new ArrayList<String> (Arrays.asList("Nombre Empleado", "Apellido Empleado", "Documento Empleado",
																	"Direccion Empleado","Ciudad Empleado", "Telefono Empleado", 
																	"Celular Empleado","Correo Empleado","Departamento Empleado", 
																	"Nacionalidad Empleado", "Información Empleado"));
	
	res = validar.validar(tipo, valor, prioridad, nombre);
	
//	if (!nombreP.equalsIgnoreCase("") && !apellidosP.equalsIgnoreCase("")
//			&& !documentoP0.equalsIgnoreCase("") && !direccionP.equalsIgnoreCase("") 
//			&& !ciudadP.equalsIgnoreCase("") && !telefonoP0.equalsIgnoreCase("") 
//			&& !celularP0.equalsIgnoreCase("")){
//		
//		try{
//			double documentoP = Double.parseDouble(documentoP0);	
//				
//				try{
//					double telefonoP = Double.parseDouble(telefonoP0);	
//					double celularP = Double.parseDouble(celularP0);
//					
//					if (correoP.equalsIgnoreCase("")){
//						
//						int rta = JOptionPane.showConfirmDialog(this, "Hay campos sin llenar en la Información del Empleado, ¿Desea continuar?", "Advertencia", JOptionPane.YES_NO_OPTION);
//						
//						if (rta == JOptionPane.YES_OPTION){
//							
//							res = 1;
//						}
//					}
//					
//					res = 2;
//				}
//				catch (Exception e){
//					JOptionPane.showMessageDialog(this, "Debe ingresar valores numéricos válidos en los campos de número telefónico y celular del Empleado", "Error", JOptionPane.ERROR_MESSAGE);
//				}				
//			
//		}
//		catch (Exception e){
//			JOptionPane.showMessageDialog(this, "Debe ingresar un valor numérico válido en el campo de documento de identidad del Empleado", "Error", JOptionPane.ERROR_MESSAGE);
//		}			
//	}
//	else{
//		JOptionPane.showMessageDialog(this, "Hay campos vacíos que se deben llenar en la Información del Empleado", "Error", JOptionPane.INFORMATION_MESSAGE);
//	}
	
	return res;
}


public int verificarCamposReferencias(){
	
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
	
	int res = 0;
	
	ArrayList<String> tipo = new ArrayList<String> (Arrays.asList("string","string","double","double","string","string","string","string"));
	ArrayList<String> valor = new ArrayList<String> (Arrays.asList(nombresP, apellidosP, documentoP0, telefonoP0, direccionP, ciudadP, empresaP, conceptoP));
	ArrayList<Integer> prioridad = new ArrayList<Integer> (Arrays.asList(1,1,1,1,0,0,0,0));
	ArrayList<String> nombre = new ArrayList<String> (Arrays.asList("Nombre Referencia", "Apellido Referencia", "Documento Referencia",
																	"Telefono Referencia","Dirección Referencia", "Ciudad Referencia",
																	"Empresa Referencia", "Concepto Referencia", "Información Referencia"));
	
	res = validar.validar(tipo, valor, prioridad, nombre);
	
//	if (!nombresP.equalsIgnoreCase("") && !apellidosP.equalsIgnoreCase("") &&
//			!documentoP0.equalsIgnoreCase("") && !telefonoP0.equalsIgnoreCase("")){
//		
//		try{
//			
//			double telefonoP = Double.parseDouble(telefonoP0);
//			double documentoP = Double.parseDouble(documentoP0);
//			
//			if (empresaP.equalsIgnoreCase("") || conceptoP.equalsIgnoreCase("") ||
//					!direccionP.equalsIgnoreCase("") || !ciudadP.equalsIgnoreCase("")){
//				
//				int rta = JOptionPane.showConfirmDialog(this, "Hay campos sin llenar, ¿Desea continuar?", "Advertencia", JOptionPane.YES_NO_OPTION);
//				
//				if (rta == JOptionPane.YES_OPTION){
//					
//					resultado = true;
//				}
//			}
//			else{
//				
//				resultado = true;
//				
//			}
//		}
//		catch (Exception e){
//			JOptionPane.showMessageDialog(this, "Debe ingresar un valor numérico en los campos Telefono y No. Documento", "Error", JOptionPane.ERROR_MESSAGE);
//		}
//		
//	}
//	else{
//		JOptionPane.showMessageDialog(this, "Hay campos vacíos que se deben llenar", "Error", JOptionPane.INFORMATION_MESSAGE);
//	}
	
	return res;
}


public int verificarCamposExperiencia(){
	
	String empresaP = empresaExperiencia.getText();
	String cargoP = cargoExperiencia.getText();

	int res = 0;
	
	
	ArrayList<String> tipo = new ArrayList<String> (Arrays.asList("string","string"));
	ArrayList<String> valor = new ArrayList<String> (Arrays.asList(empresaP, cargoP));
	ArrayList<Integer> prioridad = new ArrayList<Integer> (Arrays.asList(1,1));
	ArrayList<String> nombre = new ArrayList<String> (Arrays.asList("Empresa Experiencia", "Cargo Experiencia", "Información Experiencia"));
	
	res = validar.validar(tipo, valor, prioridad, nombre);
	
//	if (!empresaP.equalsIgnoreCase("") && !cargoP.equalsIgnoreCase("")){
//		
//		res = true;
//	}
//	
//	else{
//		JOptionPane.showMessageDialog(this, "Hay campos vacíos que se deben llenar", "Error", JOptionPane.INFORMATION_MESSAGE);
//	}
	return res;
}

public int verificarCamposHijo(){
	
	String nombreP = nombreHijo.getText();
	String apellidosP = apellidosHijo.getText();
	String tipoP = tipoDocumentoHijos.getSelectedItem().toString();
	String sexoP = sexoHijos.getSelectedItem().toString();
	Date fechaP = fechaNacimientoHijo.getDate();
	String direccionP = direccionHijos.getText();
	
	String documentoP0 = cedulaHijo.getText();
	
	int res = 0;
	
	if (!nombreP.equalsIgnoreCase("") && !apellidosP.equalsIgnoreCase("")){
		
		if (documentoP0.equalsIgnoreCase("") || direccionP.equalsIgnoreCase("")){
			
			int rta = JOptionPane.showConfirmDialog(this, "Hay campos sin llenar, ¿Desea continuar?", "Advertencia", JOptionPane.YES_NO_OPTION);
			
			if (rta == JOptionPane.YES_OPTION){
				if (documentoP0.equalsIgnoreCase("")){
					res = 1;
				}
				else{
					res = 2;
				}
			}
		}
		else{
			
			try{
				double documentoP = Double.parseDouble(documentoP0);
				res = 2;
				
			}
			catch (Exception e){
				JOptionPane.showMessageDialog(this, "Debe ingresar un valor numérico en el campo número de documento", "Error", JOptionPane.ERROR_MESSAGE);
			}
		
		}
	}
	else{
		JOptionPane.showMessageDialog(this, "Hay campos vacíos que se deben llenar", "Error", JOptionPane.INFORMATION_MESSAGE);
	}
	
	return res;
}

public void subirFotoEmpleado(){
	JFileChooser fc = new JFileChooser ();
	fc.setDialogTitle ("Cargar Foto Empleado");
	fc.setApproveButtonText("Abrir");
	
	FileFilter filter = new FileNameExtensionFilter("JPG File", "jpg");
	fc.setFileFilter(filter);
	
	fc.setFileSelectionMode(JFileChooser.FILES_ONLY);
	
	File rutaFotos = new File(Empresa.RUTA_ARCHIVO_FOTOS);
	fc.setCurrentDirectory(rutaFotos);

	File archivoGen = null;
	int resultado = fc.showOpenDialog(this);
	if (resultado == JFileChooser.APPROVE_OPTION)
	{
		archivoGen = fc.getSelectedFile();
		
		BufferedImage img;
		try {
			img = ImageIO.read(archivoGen);
			
			ImageIcon icono0  =new ImageIcon(img); // ADDED
			
			lblFoto.setBounds(68, 52, 130, 150);
			
			ImageIcon icon = new ImageIcon(icono0.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
			
	        lblFoto.setIcon(icon); // ADDED

	        Dimension imageSize = new Dimension(130,150); // ADDED
	        lblFoto.setPreferredSize(imageSize); // ADDED

	        lblFoto.revalidate(); // ADDED
	        lblFoto.repaint();
	        
	        foto = icono0;
	        
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
}
	public void setCamposEditables(boolean bool){
		
		nombreEmpleado.setEditable(bool);
		apellidosEmpleado.setEditable(bool);
		cedulaEmpleado.setEditable(bool);
		direccionEmpleado.setEditable(bool);
		telefonoEmpleado.setEditable(bool);
		celularEmpleado.setEditable(bool);
		correoEmpleado.setEditable(bool);
		cargoEmpleado.setEditable(bool);
		salarioFijo.setEditable(bool);
		salarioVariable.setEditable(bool);
		
		nombrePareja.setEditable(bool);
		apellidosPareja.setEditable(bool);
		cedulaPareja.setEditable(bool);
		
		fechaNacimientoEmpleado.getSpinner().setEnabled(bool); 
		fechaInicioContrato.getSpinner().setEnabled(bool);
		fechaFinContrato.getSpinner().setEnabled(bool);
		fechaAfiliacionSS.getSpinner().setEnabled(bool);
		
		sexoEmpleado.setEnabled(bool); 
		estadoCivilEmpleado.setEnabled(bool); 
		tipoDocumentoEmpleado.setEnabled(bool); 
		tipoContrato.setEnabled(bool); 
		duracionContrato.setEnabled(bool); 
		
		sexoPareja.setEnabled(bool); 
		tipoLiquidacionEmpleado.setEnabled(bool); 
		saludEmpleado.setEnabled(bool); 
		pensionesEmpleado.setEnabled(bool); 
		arlEmpleado.setEnabled(bool); 
		cajaCompensacionEmpleado.setEnabled(bool); 

		telefonoPareja.setEditable(bool);
		direccionPareja.setEditable(bool);
		ciudadPareja.setEditable(bool);
		ciudadEmpleado.setEditable(bool);
		
		departamentoEmpleado.setEditable(bool);
		nacionalidadEmpleado.setEditable(bool);
		horasSemanales.setEditable(bool);
		
		checkSolidaridad.setEnabled(false);
		checkAuxilio.setEnabled(false);
		
		//Manejar tablas
	}
	

}
