package interfaz.temporal;

import interfaz.Control;
import interfaz.EnterAction;
import interfaz.InterfazNomina;
import interfaz.ValidarCampos;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Cursor;
import java.awt.FocusTraversalPolicy;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.DefaultCellEditor;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.ListSelectionModel;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import java.awt.Toolkit;

import javax.swing.JButton;

import mundo.nomina.DiasNoLaborados;

import com.toedter.calendar.JDateChooser;

import java.awt.Dialog.ModalityType;


public class DialogoNovedadesDiasNoLaborados extends JDialog implements ActionListener
{
	private InterfazNomina principal;
	private Control control;
	private ArrayList<Integer> indices;
	private Date fecha;
	private int cont;
	private JTable tableNovedaesDiasNoLaborados;
	private DecimalFormat formatea;
	private String titulo;
	private JPanel panel;
	private JButton btnModificar;
	private JButton btnAgregar;
	private JButton btnAnterior;
	private JButton btnSiguiente;
	
	private ValidarCampos validador;
	private SimpleDateFormat sdf;
	private DefaultTableModel model; 
	private TableCellEditor tce;
	
	private static final String solve = "Solve";
	
	
	public DialogoNovedadesDiasNoLaborados( InterfazNomina ventana, Control pControl) {
		super(null, java.awt.Dialog.ModalityType.TOOLKIT_MODAL);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoNovedadesDiasNoLaborados.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		getContentPane().setBackground(Color.WHITE);
		principal = ventana;
		control = pControl;
		//		titulo = "Horas Extras Diurnas";
		cont = 0;
		setTitle("Novedades");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		getContentPane().setLayout(null);
		setBounds(100, 100, 688, 384);
		
		sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		panel = new JPanel();
		panel.setLayout(null);
		//		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 652, 288);
		getContentPane().add(panel);
		Object[] dataHoras = { "", "",""};
		Object[] columnsHoras = {"Fecha Ingreso","Usuario","Fecha Incio","Duraci�n", "Concepto","Incapacidad",};
		DefaultTableModel modN = new DefaultTableModel(columnsHoras, 0)
		{

			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
			
		};
		tableNovedaesDiasNoLaborados = new JTable(modN){ 
			public boolean isCellEditable (int iRows, int iCols){ 
				return true; /// editable la tabla 
				} 
				};
		tableNovedaesDiasNoLaborados.getTableHeader().setReorderingAllowed(false);
		
		//Enter action command
		
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
		tableNovedaesDiasNoLaborados.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter,solve);
		tableNovedaesDiasNoLaborados.getActionMap().put(solve, new EnterAction(this));
		//
	

		JScrollPane scrollPane = new JScrollPane(tableNovedaesDiasNoLaborados);
		scrollPane.setBounds(10, 22, 632, 221);
		panel.add(scrollPane);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(164, 254, 169, 23);
		btnModificar.addActionListener(this);
		btnModificar.setActionCommand("Modificar");
		panel.add(btnModificar);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(343, 254, 169, 23);
		btnAgregar.addActionListener(this);
		btnAgregar.setActionCommand("Agregar");
		panel.add(btnAgregar);

		btnAnterior = new JButton("Anterior");
		btnAnterior.setBounds(165, 310, 186, 23);
		btnAnterior.addActionListener(this);
		btnAnterior.setActionCommand("Anterior");
		getContentPane().add(btnAnterior);

		btnSiguiente = new JButton("Siguiente");
		btnSiguiente.setBounds(361, 310, 164, 23);
		btnSiguiente.addActionListener(this);
		btnSiguiente.setActionCommand("Siguiente");
		getContentPane().add(btnSiguiente);

		actualizarTitulo();
		actualizarInformacion();
		
	}


	private void actualizarInformacion() {
		// TODO Auto-generated method stub
		ArrayList listaDiasNoLaborados = control.getListaDiasNoLaborados(principal.darPeriodo());

		if( !listaDiasNoLaborados.isEmpty( ) ){
			for (int i = 0; i < listaDiasNoLaborados.size(); i++){
				DiasNoLaborados day = (DiasNoLaborados) listaDiasNoLaborados.get(i);
				DefaultTableModel model = (DefaultTableModel) tableNovedaesDiasNoLaborados.getModel();
				model.addRow(new Object[]{day.getFecha(), day.getUser().getUser(), day.getFechaInicio().toLocaleString(), day.getDuracion(), day.getConcepto(), "Falta Atributo de incapacidad"});
			}
		}
	}


	public void actualizarTitulo( )
	{

		switch ( cont ) {
		case 0: titulo = "D�as No Laborados";  btnAnterior.setEnabled(false); break;
		default:  titulo = "D�as No Laborados"; btnAnterior.setEnabled(false); break;
		}
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String command = e.getActionCommand();
		System.out.println( command );
		if(command.equals("Agregar"))
			
		{
			model = (DefaultTableModel) tableNovedaesDiasNoLaborados.getModel();
			model.addRow(new Object[]{"","","","","",""});
//			model.isCellEditable(0, 0);
			
			int numeroFilas = model.getRowCount();
			model.setValueAt(sdf.format(new Date()), numeroFilas-1, 0);
			
			int row = numeroFilas - 1;
			int column = 1;
			
			tableNovedaesDiasNoLaborados.setCellSelectionEnabled(true);
			
			tableNovedaesDiasNoLaborados.setColumnSelectionInterval(column, column);
			tableNovedaesDiasNoLaborados.setRowSelectionInterval(row, row);

			tableNovedaesDiasNoLaborados.requestFocus();
			tableNovedaesDiasNoLaborados.editCellAt(row, column);
			
			if (tableNovedaesDiasNoLaborados.editCellAt(row, column))
			{
			    Component editor = tableNovedaesDiasNoLaborados.getEditorComponent();
			    editor.requestFocusInWindow();
			}
			
//			boolean res = editarCelda(numeroFilas-1, 1);
			
			
		}
		else if (command.equals("Modificar")){

		}
		else if( command.equals("Anterior")){
			//			cont--;
			//			actualizarTitulo();
		}
		else if( command.equals("Siguiente")){
			//			cont++;
			this.setVisible(false);
			this.dispose();
			DialogoDevengadoHoras novedadesHora = new DialogoDevengadoHoras(principal, control, 0);
			novedadesHora.setLocationRelativeTo(principal);
			novedadesHora.setVisible(true);
		}
	}
	
	public boolean editarCelda(int row, int column){

//		tableNovedaesDiasNoLaborados.setCellSelectionEnabled(true);
//		
//		tableNovedaesDiasNoLaborados.setColumnSelectionInterval(column, column);
//		tableNovedaesDiasNoLaborados.setRowSelectionInterval(row, row);
//
//		tableNovedaesDiasNoLaborados.requestFocus();
//		tableNovedaesDiasNoLaborados.editCellAt(row, column);
		
		tce = tableNovedaesDiasNoLaborados.getCellEditor();
		tce.addCellEditorListener(new CellEditorListener() {
			
			@Override
			public void editingStopped(ChangeEvent arg0) {
				//tce.stopCellEditing();
				
				int row = tableNovedaesDiasNoLaborados.getSelectedRow();
				int column = tableNovedaesDiasNoLaborados.getSelectedColumn();
				
				
				String valor = String.valueOf(tableNovedaesDiasNoLaborados.getValueAt(row, column));			
				String tipo = "String";
				boolean res = true;
				
				if (column == 2){
					tipo = "Date";
				}
				
				if (valor != null && !valor.isEmpty()){
					try {
						res = validador.validarIndividual(valor, tipo);
						
					} 
					catch (Exception e) {
						System.out.println("catch exeption");
						tableNovedaesDiasNoLaborados.getInputMap().put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), "none");
						tableNovedaesDiasNoLaborados.getInputMap().remove(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0));
						res = false;
//						tableNovedaesDiasNoLaborados.getInputMap();
					}
				}

				
				if (res == false){

					tableNovedaesDiasNoLaborados.setValueAt("", row, column);					
					editarCelda(row, column+1);

				}
				
				else if (column == model.getColumnCount()-1){
					guardarNovedad();
				}
				
			}
			

			@Override
			public void editingCanceled(ChangeEvent arg0) {
				// TODO Auto-generated method stub
			}
		});
		return false;
		
	}
	
	public void guardarNovedad(){
		
	}
	
	public ValidarCampos getValidador(){
		return validador;
	} 

}