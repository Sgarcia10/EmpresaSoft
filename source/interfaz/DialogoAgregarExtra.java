package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;

public class DialogoAgregarExtra extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textHoras;
	private JTextField txtDa;
	private JTextField txtMes;
	private JTextField txtAo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoAgregarExtra dialog = new DialogoAgregarExtra();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoAgregarExtra() {
		setTitle("Nombre Empleado / C\u00E9dula");
		setBounds(100, 100, 408, 366);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JComboBox tipoDia = new JComboBox();
		tipoDia.setToolTipText("");
		tipoDia.setBounds(58, 38, 121, 20);
		contentPanel.add(tipoDia);
		
		JComboBox tipoHora = new JComboBox();
		tipoHora.setBounds(212, 38, 121, 20);
		contentPanel.add(tipoHora);
		
		textHoras = new JTextField();
		textHoras.setBounds(93, 79, 86, 20);
		contentPanel.add(textHoras);
		textHoras.setColumns(10);
		
		JLabel lblHoras = new JLabel("horas");
		lblHoras.setBounds(212, 76, 61, 27);
		contentPanel.add(lblHoras);
		
		txtDa = new JTextField();
		txtDa.setText("d\u00EDa");
		txtDa.setBounds(147, 110, 24, 20);
		contentPanel.add(txtDa);
		txtDa.setColumns(10);
		
		txtMes = new JTextField();
		txtMes.setText("mes");
		txtMes.setBounds(181, 110, 29, 20);
		contentPanel.add(txtMes);
		txtMes.setColumns(10);
		
		txtAo = new JTextField();
		txtAo.setText("a\u00F1o");
		txtAo.setBounds(222, 110, 43, 20);
		contentPanel.add(txtAo);
		txtAo.setColumns(10);
		
		JLabel lblFecha = new JLabel("Fecha:");
		lblFecha.setBounds(81, 110, 43, 20);
		contentPanel.add(lblFecha);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(41, 175, 314, 109);
		contentPanel.add(textArea);
		
		JLabel lblConcepto = new JLabel("Concepto:");
		lblConcepto.setBounds(41, 153, 86, 21);
		contentPanel.add(lblConcepto);
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);			
		}
	}
}
