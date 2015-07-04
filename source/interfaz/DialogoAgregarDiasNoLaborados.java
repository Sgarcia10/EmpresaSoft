package interfaz;

import javax.swing.JDialog;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JLabel;

public class DialogoAgregarDiasNoLaborados extends JDialog{
	private JButton btnAceptar;
	private JTextField textField;
	public DialogoAgregarDiasNoLaborados() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(283, 237, 89, 23);
		panel.add(btnAceptar);
		
		textField = new JTextField();
		textField.setBounds(221, 72, 183, 20);
		panel.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(136, 75, 46, 14);
		panel.add(lblNewLabel);
	}
}
