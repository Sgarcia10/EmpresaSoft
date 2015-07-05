package interfaz.liquidacion;

import interfaz.Control;

import interfaz.EnterAction;
import interfaz.InterfazNomina;
import interfaz.MyTableModel;
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
import javax.swing.JOptionPane;
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
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;


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
	
	private EnterAction enterA;
	
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
		Object[] columnsHoras = {"Fecha Ingreso","Usuario","Fecha Incio","Duración", "Concepto","Incapacidad",};
		
		MyTableModel modN = new MyTableModel(columnsHoras);
		
		tableNovedaesDiasNoLaborados = new JTable(modN);
		tableNovedaesDiasNoLaborados.getTableHeader().setReorderingAllowed(false);
		
		//Enter action command para validar los campos 
		enterA = new EnterAction(this);
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
		tableNovedaesDiasNoLaborados.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter,solve);
		tableNovedaesDiasNoLaborados.getActionMap().put(solve, enterA);
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
		case 0: titulo = "Días No Laborados";  btnAnterior.setEnabled(false); break;
		default:  titulo = "Días No Laborados"; btnAnterior.setEnabled(false); break;
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
			
			int numeroFilas = model.getRowCount();
			model.setValueAt(sdf.format(new Date()), numeroFilas-1, 0);
			
			int row = numeroFilas - 1;
			int column = 1;
			
			MyTableModel myMod = (MyTableModel) tableNovedaesDiasNoLaborados.getModel();
			myMod.setRowEditable(myMod.getRowCount()-1, true);
			
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
			
			//CellEditorListener para guargdar datos cuando se edite la ultima columna
			TableCellEditor tce = tableNovedaesDiasNoLaborados.getCellEditor();
			tce.addCellEditorListener(new CellEditorListener(){

				@Override
				public void editingCanceled(ChangeEvent e) {
					// TODO Auto-generated method stub
					
				}

				@Override
				public void editingStopped(ChangeEvent e) {
					
					int row = tableNovedaesDiasNoLaborados.getSelectedRow();
					int column = tableNovedaesDiasNoLaborados.getSelectedColumn();
					
					if (column == tableNovedaesDiasNoLaborados.getColumnCount()-1){
						
						guardarNovedad();
							
					}				
					
				}
				
			}) ;
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
	
	public void guardarNovedad(){
		
		int confirm = JOptionPane.showConfirmDialog(this, "¿Desea guardar los cambios realizados?","Warning",JOptionPane.YES_NO_OPTION);		
		
		if (confirm == JOptionPane.YES_NO_OPTION){
			
			MyTableModel myMod = (MyTableModel) tableNovedaesDiasNoLaborados.getModel();
			myMod.setRowEditable(myMod.getRowCount()-1, false);
			
		}
		
	}
	
	public ValidarCampos getValidador(){
		return validador;
	} 

}
