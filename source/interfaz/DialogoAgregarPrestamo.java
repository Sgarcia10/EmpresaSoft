package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;

public class DialogoAgregarPrestamo extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTextField textCuotas;
	private JTextField textInteres;
	private JTextField textCuota;
	private JTextField textValor;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoAgregarPrestamo dialog = new DialogoAgregarPrestamo();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoAgregarPrestamo() {
		setTitle("Nombre Empleado - C\u00E9dula");
		setBounds(100, 100, 340, 250);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		JLabel lblValor = new JLabel("Valor");
		lblValor.setHorizontalAlignment(SwingConstants.LEFT);
		lblValor.setBounds(56, 21, 73, 30);
		contentPanel.add(lblValor);
		
		JLabel cuotas = new JLabel("Cuotas");
		cuotas.setBounds(56, 62, 73, 30);
		contentPanel.add(cuotas);
		
		JLabel valorCuota = new JLabel("Valor Cuota");
		valorCuota.setBounds(56, 148, 85, 14);
		contentPanel.add(valorCuota);
		
		JLabel lblValorCuotaNum = new JLabel("0$");
		lblValorCuotaNum.setHorizontalAlignment(SwingConstants.RIGHT);
		lblValorCuotaNum.setBounds(218, 148, 46, 14);
		contentPanel.add(lblValorCuotaNum);
		
		JLabel lblInteres = new JLabel("Interes");
		lblInteres.setBounds(56, 103, 73, 30);
		contentPanel.add(lblInteres);
		
		textInteres = new JTextField();
		textInteres.setBounds(218, 113, 46, 20);
		contentPanel.add(textInteres);
		textInteres.setColumns(10);
		
		textCuota = new JTextField();
		textCuota.setBounds(218, 67, 46, 20);
		contentPanel.add(textCuota);
		textCuota.setColumns(10);
		
		textValor = new JTextField();
		textValor.setBounds(178, 26, 86, 20);
		contentPanel.add(textValor);
		textValor.setColumns(10);
		
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
