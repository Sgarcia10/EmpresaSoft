package interfaz;

import java.awt.BorderLayout;

import java.awt.FlowLayout;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.border.TitledBorder;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DialogoLogin extends JDialog implements ActionListener{

	private final JPanel contentPanel = new JPanel();
	
	private JTextField textFieldUsuario;
	
	private InterfazNomina interfaz;
	private JPasswordField passwordField;
	private Control control;

	/**
	 * Create the dialog.
	 */
	public DialogoLogin(InterfazNomina interfazN, Control controlP) {
		
		super(null, java.awt.Dialog.ModalityType.TOOLKIT_MODAL);
		
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		interfaz = interfazN;
		control = controlP;
		
		
		setBounds(100, 100, 386, 305);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBackground(Color.WHITE);
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JLabel lblUsuario = new JLabel("Usuario");
		lblUsuario.setBounds(53, 166, 46, 14);
		contentPanel.add(lblUsuario);
		
	
		JLabel lblContrasea = new JLabel("Contrase\u00F1a");
		lblContrasea.setBounds(53, 191, 66, 14);
		contentPanel.add(lblContrasea);
		
		
		textFieldUsuario = new JTextField();
		textFieldUsuario.setBounds(183, 163, 158, 20);
		contentPanel.add(textFieldUsuario);
		textFieldUsuario.setColumns(10);
		
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(new TitledBorder(null, "Conexsur", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(47, 11, 294, 143);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JLabel lblNitXX = new JLabel("NIT: x x x x ");
		lblNitXX.setBounds(26, 39, 70, 14);
		panel.add(lblNitXX);
			
	
		JLabel lblDireccinXX = new JLabel("Direcci\u00F3n: x x x x ");
		lblDireccinXX.setBounds(26, 68, 95, 14);
		panel.add(lblDireccinXX);
			
			
		JLabel lblTelfonoXX = new JLabel("Tel\u00E9fono: x x x x ");
		lblTelfonoXX.setBounds(26, 99, 95, 14);
		panel.add(lblTelfonoXX);
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBorder(null);
		panel_1.setBounds(151, 21, 133, 111);
		panel.add(panel_1);
				
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setSize(110, 110);
		ImageIcon fot = new ImageIcon("./data/logo_empresa.jpg");
		ImageIcon icono = new ImageIcon(fot.getImage().getScaledInstance(lblNewLabel.getWidth(), lblNewLabel.getHeight(), Image.SCALE_DEFAULT));
		lblNewLabel.setIcon(icono);
		panel_1.add(lblNewLabel);
				

		passwordField = new JPasswordField();
		passwordField.setBounds(183, 188, 158, 17);
		contentPanel.add(passwordField);

		{
			JPanel buttonPane = new JPanel();
			buttonPane.setBackground(Color.WHITE);
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Aceptar");
				okButton.addActionListener(this);
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.addActionListener(this);
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		
		String command = e.getActionCommand();
		
		if(command.equals("OK"))
		{
			String nombre = textFieldUsuario.getText();
			String contrasena = passwordField.getText();
			System.out.println(nombre);
			
			if( nombre != "" && contrasena != "" )
			{
				System.out.println(nombre);
				boolean reg = control.validacionUsuario(nombre, contrasena);
				if(reg)
				{
					System.out.println("Registró");
					//String user = principal.darUserActual().darNombre();
					//System.out.println("Usuario actual: " + user);
					this.setVisible(false);
					JOptionPane.showMessageDialog(this, "Bienvenido " + nombre, "Bodega", JOptionPane.INFORMATION_MESSAGE);
					this.dispose();
					
					interfaz.setVisible(true);
					
				}
				else
				{
					JOptionPane.showMessageDialog(this, "El usuario o contraseña no son incorrectos", "Error", JOptionPane.ERROR_MESSAGE );
				}
				System.out.println("Inicio sesion");
				}
			else
			{
				JOptionPane.showMessageDialog(this, "El usuario o contraseña no se ingresaron correctamente", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}
		else if( command.equals("Cancel"))
		{
			this.dispose();
			interfaz.cerrar();
		}
		
	}
}
