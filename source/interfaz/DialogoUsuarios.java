package interfaz;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.TextField;

import javax.swing.DefaultCellEditor;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableColumnModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class DialogoUsuarios extends JDialog {

	private final JPanel contentPanel = new JPanel();
	private JTable table;

	private DefaultTableModel modeloTablaUsuarios;
	private JTable tablaUsuarios;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			DialogoUsuarios dialog = new DialogoUsuarios();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public DialogoUsuarios() {
		setBounds(100, 100, 450, 300);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 434, 228);
		contentPanel.add(panel);
		panel.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 11, 414, 206);
		panel.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		TextField textField = new TextField();
		scrollPane.setColumnHeaderView(textField);
		
		TableColumn columnaNombre, columnaPassword;
		DefaultTableColumnModel headers; 

		//create and define columns 
		columnaNombre = new TableColumn(0); 
		columnaNombre.setHeaderValue("Nombre"); // set column name 
//		columnaNombre.setPreferredWidth(150); //set column width 

		columnaPassword = new TableColumn(1); 
		columnaPassword.setHeaderValue("Tipo"); 
//		columnaPassword.setPreferredWidth(50); 

		// A DefaultTableColumnModel object is created and the three 
		// TableColumn objects are added to it. 
		
		modeloTablaUsuarios = new DefaultTableModel()
		{

			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};

		modeloTablaUsuarios.addColumn("Nombre");
		modeloTablaUsuarios.addColumn("Tipo");
		
		
		headers = new DefaultTableColumnModel(); 
		headers.addColumn(columnaNombre); 
		headers.addColumn(columnaPassword); 
		
		tablaUsuarios = new JTable(modeloTablaUsuarios, headers);
		tablaUsuarios.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tablaUsuarios.getTableHeader().setReorderingAllowed(false);
		
		
		scrollPane.setViewportView(tablaUsuarios);
		
		
		{
			JPanel buttonPane = new JPanel();
			buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
			getContentPane().add(buttonPane, BorderLayout.SOUTH);
			{
				JButton okButton = new JButton("Agregar");
				okButton.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						
					}
				});
				okButton.setActionCommand("OK");
				buttonPane.add(okButton);
				getRootPane().setDefaultButton(okButton);
			}
			
			JButton btnEditar = new JButton("Editar");
			btnEditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
				}
			});
			buttonPane.add(btnEditar);
			{
				JButton cancelButton = new JButton("Cancelar");
				cancelButton.setActionCommand("Cancel");
				buttonPane.add(cancelButton);
			}
		}
	}
}
