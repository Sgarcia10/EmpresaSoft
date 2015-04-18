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

public class DialogoLiquidacion extends JDialog{
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTable table;
	private JTextField textField_7;
	private JTextField textField_8;
	private JTextField textField_9;
	private JTextField textField_10;
	private JTextField textField_11;
	private JTextField textField_12;
	public DialogoLiquidacion() {
		setTitle("N\u00F3mina");
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblCodigo = new JLabel("Codigo");
		lblCodigo.setBounds(36, 24, 46, 14);
		panel.add(lblCodigo);
		
		textField = new JTextField();
		textField.setBounds(129, 21, 123, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(129, 49, 123, 20);
		panel.add(textField_1);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(36, 52, 46, 14);
		panel.add(lblNombre);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(new TitledBorder(null, "Salario", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 80, 293, 431);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblTipoDeSalario = new JLabel("Tipo de Salario");
		lblTipoDeSalario.setBounds(24, 28, 80, 14);
		panel_1.add(lblTipoDeSalario);
		
		JRadioButton rdbtnFijo = new JRadioButton("Fijo");
		rdbtnFijo.setBackground(Color.WHITE);
		rdbtnFijo.setBounds(128, 24, 57, 23);
		panel_1.add(rdbtnFijo);
		
		JRadioButton rdbtnVariable = new JRadioButton("Variable");
		rdbtnVariable.setBackground(Color.WHITE);
		rdbtnVariable.setBounds(187, 24, 87, 23);
		panel_1.add(rdbtnVariable);
		
		JLabel lblSalarioBase = new JLabel("Salario Base");
		lblSalarioBase.setBounds(24, 52, 95, 14);
		panel_1.add(lblSalarioBase);
		
		textField_2 = new JTextField();
		textField_2.setBounds(128, 49, 141, 20);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel lblUltimoPago = new JLabel("Ultimo Pago");
		lblUltimoPago.setBounds(24, 83, 95, 14);
		panel_1.add(lblUltimoPago);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(128, 80, 141, 20);
		panel_1.add(textField_3);
		
		JLabel lblFechaPago = new JLabel("Fecha Pago");
		lblFechaPago.setBounds(24, 116, 95, 14);
		panel_1.add(lblFechaPago);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(128, 113, 141, 20);
		panel_1.add(textField_4);
		
		JLabel lblHorasExtraDiurnas = new JLabel("Horas extra diurnas");
		lblHorasExtraDiurnas.setBounds(24, 209, 95, 14);
		panel_1.add(lblHorasExtraDiurnas);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(168, 206, 101, 20);
		panel_1.add(textField_5);
		
		JLabel lblHorasExtraNocturnas = new JLabel("Horas extra nocturnas");
		lblHorasExtraNocturnas.setBounds(24, 237, 115, 14);
		panel_1.add(lblHorasExtraNocturnas);
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(168, 234, 101, 20);
		panel_1.add(textField_6);
		
		JLabel lblAdelantos = new JLabel("Adelantos");
		lblAdelantos.setBounds(24, 262, 57, 14);
		panel_1.add(lblAdelantos);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(116, 272, 153, 135);
		panel_1.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(154, 144, 115, 20);
		panel_1.add(textField_7);
		
		JLabel lblLaborados = new JLabel("D\u00EDas Laborados");
		lblLaborados.setBounds(24, 147, 95, 14);
		panel_1.add(lblLaborados);
		
		textField_8 = new JTextField();
		textField_8.setColumns(10);
		textField_8.setBounds(154, 175, 115, 20);
		panel_1.add(textField_8);
		
		JLabel lblDominicalesYFestivos = new JLabel("Dominicales y Festivos");
		lblDominicalesYFestivos.setBounds(24, 178, 95, 14);
		panel_1.add(lblDominicalesYFestivos);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBorder(new TitledBorder(null, "ISS", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBounds(312, 85, 327, 279);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblSalud = new JLabel("Salud");
		lblSalud.setBounds(28, 52, 46, 14);
		panel_2.add(lblSalud);
		
		textField_9 = new JTextField();
		textField_9.setEditable(false);
		textField_9.setBounds(84, 49, 86, 20);
		panel_2.add(textField_9);
		textField_9.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(192, 49, 97, 20);
		panel_2.add(comboBox);
		
		JLabel lblPension = new JLabel("Pension");
		lblPension.setBounds(28, 94, 46, 14);
		panel_2.add(lblPension);
		
		textField_10 = new JTextField();
		textField_10.setEditable(false);
		textField_10.setColumns(10);
		textField_10.setBounds(84, 91, 86, 20);
		panel_2.add(textField_10);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(192, 91, 97, 20);
		panel_2.add(comboBox_1);
		
		JLabel lblFondo = new JLabel("Fondo");
		lblFondo.setBounds(28, 136, 46, 14);
		panel_2.add(lblFondo);
		
		textField_11 = new JTextField();
		textField_11.setEditable(false);
		textField_11.setColumns(10);
		textField_11.setBounds(84, 133, 86, 20);
		panel_2.add(textField_11);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(192, 133, 97, 20);
		panel_2.add(comboBox_2);
		
		JLabel lblAuxilios = new JLabel("Auxilios");
		lblAuxilios.setBounds(28, 177, 80, 14);
		panel_2.add(lblAuxilios);
		
		JRadioButton rdbtnSi = new JRadioButton("Si");
		rdbtnSi.setBackground(Color.WHITE);
		rdbtnSi.setBounds(143, 173, 57, 23);
		panel_2.add(rdbtnSi);
		
		JRadioButton rdbtnNo = new JRadioButton("No");
		rdbtnNo.setBackground(Color.WHITE);
		rdbtnNo.setBounds(202, 173, 87, 23);
		panel_2.add(rdbtnNo);
		
		JLabel lblNeto = new JLabel("Neto ($)");
		lblNeto.setBounds(28, 223, 46, 14);
		panel_2.add(lblNeto);
		
		textField_12 = new JTextField();
		textField_12.setBounds(84, 220, 86, 20);
		panel_2.add(textField_12);
		textField_12.setColumns(10);
		
		JButton btnCalcular = new JButton("Calcular");
		btnCalcular.setBounds(200, 219, 89, 23);
		panel_2.add(btnCalcular);
	}
}
