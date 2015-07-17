package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;

public class DialogoAgregarUsuario extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textField;
	private JPasswordField passwordField;
	private JPasswordField passwordField_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoAgregarUsuario dialog = new DialogoAgregarUsuario();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoAgregarUsuario() {
		setTitle("Agregar Usuario");
		setBounds(100, 100, 264, 212);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setBounds(30, 23, 46, 14);
		contentPanel.add(lblNombre);
		
		textField = new JTextField();
		textField.setBounds(120, 20, 107, 20);
		contentPanel.add(textField);
		textField.setColumns(10);
		
		JLabel lblClave = new JLabel("Clave");
		lblClave.setBounds(30, 52, 46, 14);
		contentPanel.add(lblClave);
		
		JLabel lblRepetirClave = new JLabel("Repetir Clave");
		lblRepetirClave.setBounds(30, 82, 86, 14);
		contentPanel.add(lblRepetirClave);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(120, 49, 107, 20);
		contentPanel.add(passwordField);
		
		passwordField_1 = new JPasswordField();
		passwordField_1.setBounds(120, 79, 107, 20);
		contentPanel.add(passwordField_1);
		
		JLabel lblPermisos = new JLabel("Permisos");
		lblPermisos.setBounds(30, 115, 46, 14);
		contentPanel.add(lblPermisos);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(120, 110, 107, 20);
		contentPanel.add(comboBox);
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("OK");
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancel");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
