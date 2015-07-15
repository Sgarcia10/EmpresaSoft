package interfaz.liquidacion;

import interfaz.Control;
import interfaz.EnterAction;
import interfaz.EscapeAction;
import interfaz.InterfazNomina;
import interfaz.MyDateSelector;
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
import javax.swing.JComboBox;
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
import Excepciones.NoExisteEmpleadoException;
import Excepciones.NominaNoEncontradaException;

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
	private JButton btnEliminar;
	private JButton btnAnterior;
	private JButton btnSiguiente;

	private ValidarCampos validador;
	private SimpleDateFormat sdf;
	private DefaultTableModel model; 
	private TableCellEditor tce;

	private EnterAction enterA;
	private EscapeAction escapeA;

	private static final String solve = "Solve";
	private static final String cancel = "Cancel";



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
		
		//Escape action command para cancelar el proceso de agregar
		escapeA = new EscapeAction(this);
		KeyStroke escape = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
		tableNovedaesDiasNoLaborados.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape,cancel);
		tableNovedaesDiasNoLaborados.getActionMap().put(cancel, escapeA);
		//
		
		//Agregar ComboBox
		String[] opciones = { "Si", "No" };
        JComboBox comboBox1 = new JComboBox( opciones );
        DefaultCellEditor dce1 = new DefaultCellEditor( comboBox1 );
        tableNovedaesDiasNoLaborados.getColumnModel().getColumn(5).setCellEditor(dce1);
		//
		
		JScrollPane scrollPane = new JScrollPane(tableNovedaesDiasNoLaborados);
		scrollPane.setBounds(10, 22, 632, 221);
		panel.add(scrollPane);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(76, 254, 169, 23);
		btnModificar.addActionListener(this);
		btnModificar.setActionCommand("Modificar");
		btnModificar.setEnabled(false);
		panel.add(btnModificar);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(255, 254, 169, 23);
		btnAgregar.addActionListener(this);
		btnAgregar.setActionCommand("Agregar");
		panel.add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setEnabled(false);
		btnEliminar.setActionCommand("Eliminar");
		btnEliminar.setBounds(434, 254, 169, 23);
		panel.add(btnEliminar);

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

		try{
			actualizarTitulo();
			actualizarInformacion();
			
		}

		catch( Exception e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		if(tableNovedaesDiasNoLaborados.getRowCount() == 0){
			btnAgregar.setEnabled(true);
			btnModificar.setEnabled(false);
			btnEliminar.setEnabled(false);
		}
		else{
			btnAgregar.setEnabled(true);
			btnModificar.setEnabled(true);
			btnEliminar.setEnabled(true);
		}
	}


	private void actualizarInformacion() throws NoExisteEmpleadoException, NominaNoEncontradaException {
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
			btnAgregar.setEnabled(false);
			btnEliminar.setEnabled(false);
			escapeA.activar(true);
			btnEliminar.setEnabled(false);
			
			model = (DefaultTableModel) tableNovedaesDiasNoLaborados.getModel();
			model.addRow(new Object[]{"","","","","",""});
			
			TableColumn fechaI = tableNovedaesDiasNoLaborados.getColumnModel().getColumn(2);
			fechaI.setCellEditor(new MyDateSelector());

			MyTableModel myMod = (MyTableModel) tableNovedaesDiasNoLaborados.getModel();
			myMod.agregarFila();
			
			int numeroFilas = model.getRowCount();
			model.setValueAt(sdf.format(new Date()), numeroFilas-1, 0);
			
			String user = control.darUsuario();
			model.setValueAt(user, numeroFilas-1, 1);

			int row = numeroFilas - 1;
			int column = 2;
			
			if (numeroFilas > 0){
				for (int i = 0; i < numeroFilas-1; i++){
					myMod.setRowEditable(i, false);
				}
			}
			
			myMod.setRowEditable(myMod.getRowCount()-1, true);
			
			tableNovedaesDiasNoLaborados.setCellSelectionEnabled(true);

			tableNovedaesDiasNoLaborados.setColumnSelectionInterval(column, column);
			tableNovedaesDiasNoLaborados.setRowSelectionInterval(row, row);

//			tableNovedaesDiasNoLaborados.requestFocus();
			tableNovedaesDiasNoLaborados.editCellAt(row, column);

			if (tableNovedaesDiasNoLaborados.editCellAt(row, column))
			{
				Component editor = tableNovedaesDiasNoLaborados.getEditorComponent();
				editor.requestFocusInWindow();
			}

		}
		else if (command.equals("Modificar")){
			
			int row = tableNovedaesDiasNoLaborados.getSelectedRow();
			int column = tableNovedaesDiasNoLaborados.getSelectedColumn();
			modificar(row, column);
		}
		
		else if (command.equals("Eliminar")){
			
			int confirm = JOptionPane.showConfirmDialog(this, "¿Desea eliminar la novedad seleccionada?","Warning",JOptionPane.YES_NO_OPTION);		

			if (confirm == JOptionPane.YES_NO_OPTION){
				
				int index = tableNovedaesDiasNoLaborados.getSelectedRow();
				DefaultTableModel dm = (DefaultTableModel) tableNovedaesDiasNoLaborados.getModel();
				dm.removeRow(index);
				eliminar(index);
			}
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
			
			btnAgregar.setEnabled(true);
			btnModificar.setEnabled(true);
			btnEliminar.setEnabled(true);
			
			escapeA.activar(false);
			
			MyTableModel myMod = (MyTableModel) tableNovedaesDiasNoLaborados.getModel();
			myMod.setRowEditable(myMod.getRowCount()-1, false);
			
			int row = tableNovedaesDiasNoLaborados.getRowCount();
			
			tableNovedaesDiasNoLaborados.setColumnSelectionInterval(2, 2);
			tableNovedaesDiasNoLaborados.setRowSelectionInterval(row-1, row-1);
			
			String fechaInicio = (String) tableNovedaesDiasNoLaborados.getValueAt(row-1, 2);
			String duracion = (String) tableNovedaesDiasNoLaborados.getValueAt(row-1, 3);
			String concepto = (String) tableNovedaesDiasNoLaborados.getValueAt(row-1, 4);
			String incapacidad = (String) tableNovedaesDiasNoLaborados.getValueAt(row-1, 5);
			
			if (btnModificar.isEnabled()){
				control.editarDiaNoLaborado(tableNovedaesDiasNoLaborados.getSelectedRow(), fechaInicio,duracion,concepto,incapacidad);
			}
			else{
				control.agregarDiaNoLaborado(fechaInicio,duracion,concepto,incapacidad);
			}
			
		}

	}

	public ValidarCampos getValidador(){
		return validador;
	}


	public void cancelarCreación() {
		
		btnAgregar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(true);
		escapeA.activar(false);
		
		int row = tableNovedaesDiasNoLaborados.getRowCount();
		DefaultTableModel model = (DefaultTableModel) tableNovedaesDiasNoLaborados.getModel();
		model.removeRow(row-1);
	} 
	
	public void modificar(int row, int column){
		
		btnAgregar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(true);
		
		MyTableModel myMod = (MyTableModel) tableNovedaesDiasNoLaborados.getModel();
		myMod.setRowEditable(row, true);
		
		tableNovedaesDiasNoLaborados.editCellAt(row, column);

		if (tableNovedaesDiasNoLaborados.editCellAt(row, column))
		{
			Component editor = tableNovedaesDiasNoLaborados.getEditorComponent();
			editor.requestFocusInWindow();
		}
		
	}
	
	public void eliminar(int index){
		if(tableNovedaesDiasNoLaborados.getRowCount() == 0){
			btnAgregar.setEnabled(true);
			btnModificar.setEnabled(false);
			btnEliminar.setEnabled(false);
		}
		else{
			btnAgregar.setEnabled(true);
			btnModificar.setEnabled(true);
			btnEliminar.setEnabled(true);
		}
		control.eliminarDiaNoLaborado(index);
	}
}
