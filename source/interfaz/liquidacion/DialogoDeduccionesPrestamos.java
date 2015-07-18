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
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.KeyStroke;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.event.CellEditorListener;
import javax.swing.event.ChangeEvent;
import javax.swing.table.DefaultTableModel;

















import javax.swing.table.TableCellEditor;
import javax.swing.table.TableColumn;

import java.awt.Toolkit;

import javax.swing.JButton;

import Excepciones.NoExisteEmpleadoException;
import Excepciones.NominaNoEncontradaException;
import mundo.nomina.DiasNoLaborados;
import mundo.nomina.Prestamo;

import java.awt.Dialog.ModalityType;


public class DialogoDeduccionesPrestamos extends JDialog implements ActionListener
{
	private InterfazNomina principal;
	private Control control;
	private DialogoNomina dialogoNomina;
	private ArrayList<Integer> indices;
	private Date fecha;
	private int cont;
	private JTable tableDeduccionesPrestamos;
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

	public DialogoDeduccionesPrestamos( InterfazNomina ventana, Control pControl, DialogoNomina pNomina) {
		super(null, java.awt.Dialog.ModalityType.TOOLKIT_MODAL);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoDeduccionesPrestamos.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		getContentPane().setBackground(Color.WHITE);
		principal = ventana;
		control = pControl;
		dialogoNomina = pNomina;
		//		titulo = "Horas Extras Diurnas";
		cont = 0;
		setTitle("Deducciones");
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
		Object[] columnsPrestamos = {"Fecha Ingreso","Usuario","Fecha Préstamo","Concepto","Total","Cuota Período","Saldo"};
		
		MyTableModel modN = new MyTableModel(columnsPrestamos);
		
		tableDeduccionesPrestamos = new JTable(modN);
		tableDeduccionesPrestamos.getTableHeader().setReorderingAllowed(false);

		//Enter action command
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
		tableDeduccionesPrestamos.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter,solve);
		tableDeduccionesPrestamos.getActionMap().put(solve, new EnterAction(this));
		//
		
		//Escape action command para cancelar el proceso de agregar
		escapeA = new EscapeAction(this);
		KeyStroke escape = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
		tableDeduccionesPrestamos.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape,cancel);
		tableDeduccionesPrestamos.getActionMap().put(cancel, escapeA);
		//		
		
		JScrollPane scrollPane = new JScrollPane(tableDeduccionesPrestamos);
		scrollPane.setBounds(10, 22, 632, 221);
		panel.add(scrollPane);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(77, 254, 169, 23);
		btnModificar.addActionListener(this);
		btnModificar.setActionCommand("Modificar");
		btnModificar.setEnabled(false);
		panel.add(btnModificar);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(256, 254, 169, 23);
		btnAgregar.addActionListener(this);
		btnAgregar.setActionCommand("Agregar");
		panel.add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setActionCommand("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(435, 254, 169, 23);
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
		
		if(tableDeduccionesPrestamos.getRowCount() == 0){
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


	private void actualizarInformacion() {
		// TODO Auto-generated method stub
		ArrayList listaPrestamos = control.getListaDeduccionesPrestamos( principal.darPeriodo());

		if( !listaPrestamos.isEmpty( ) ){
			for (int i = 0; i < listaPrestamos.size(); i++){
				Prestamo prestamoActual = (Prestamo) listaPrestamos.get(i);
				DefaultTableModel model = (DefaultTableModel) tableDeduccionesPrestamos.getModel();
				model.addRow(new Object[]{prestamoActual.getFecha(), prestamoActual.getUser().getUser(), prestamoActual.getFechaExpedicion().toLocaleString(), prestamoActual.getConcepto(), prestamoActual.getCantidad(), prestamoActual.getValorCuota(), prestamoActual.getSaldo()});
			}
		}
	}


	public void actualizarTitulo( )
	{

		switch ( cont ) {
		case 0: titulo = "Préstamos";  btnSiguiente.setEnabled(false); break;
		default:  titulo = "Préstamos"; btnSiguiente.setEnabled(false); break;
		}
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}
	private void actualizarAbonos() {
		//		ArrayList nuevaLista = actual.getAbonos();
		//
		//		if( !nuevaLista.isEmpty( ) ){
		//			for (int i = 0; i < nuevaLista.size(); i++){
		//				Abono a = (Abono) nuevaLista.get(i);
		//				DefaultTableModel model = (DefaultTableModel) tableAbonos.getModel();
		//				model.addRow(new Object[]{a.getFecha().toLocaleString(),
		//						formatea.format(a.getAbono())});
		//			}
		//		}
		//

	}

	private void actualizarNotas() {
		//		ArrayList nuevaListaNotas = actual.getNotasCredito();
		//
		//		if( !nuevaListaNotas.isEmpty( ) ){
		//			for (int i = 0; i < nuevaListaNotas.size(); i++){
		//				NotaCredito nc = (NotaCredito) nuevaListaNotas.get(i);
		//				DefaultTableModel model = (DefaultTableModel) tableNovedaesHoras.getModel();
		//				int pos = i + 1;
		//				model.addRow(new Object[]{"NOTA - "+pos,
		//						nc.getFecha(),
		//						formatea.format(nc.getTotal())});
		//			}
		//		}

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
			
			DefaultTableModel model = (DefaultTableModel) tableDeduccionesPrestamos.getModel();
			model.addRow(new Object[]{"","","","","",""});
			
			TableColumn fechaI = tableDeduccionesPrestamos.getColumnModel().getColumn(2);
			fechaI.setCellEditor(new MyDateSelector());
			
			MyTableModel myMod = (MyTableModel) tableDeduccionesPrestamos.getModel();
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
			
			tableDeduccionesPrestamos.setCellSelectionEnabled(true);
			
			tableDeduccionesPrestamos.setColumnSelectionInterval(column, column);
			tableDeduccionesPrestamos.setRowSelectionInterval(row, row);

//			tableDeduccionesPrestamos.requestFocus();
			tableDeduccionesPrestamos.editCellAt(row, column);
			
			if (tableDeduccionesPrestamos.editCellAt(row, column))
			{
			    Component editor = tableDeduccionesPrestamos.getEditorComponent();
			    editor.requestFocusInWindow();
			}
		}
		else if (command.equals("Modificar")){
			
			int row = tableDeduccionesPrestamos.getSelectedRow();
			int column = tableDeduccionesPrestamos.getSelectedColumn();
			modificar(row, column);
		}
		
		else if (command.equals("Eliminar")){
			
			int confirm = JOptionPane.showConfirmDialog(this, "¿Desea eliminar la novedad seleccionada?","Warning",JOptionPane.YES_NO_OPTION);		

			if (confirm == JOptionPane.YES_NO_OPTION){
				
				int index = tableDeduccionesPrestamos.getSelectedRow();
				DefaultTableModel dm = (DefaultTableModel) tableDeduccionesPrestamos.getModel();
				dm.removeRow(index);
				eliminar(index);
			}
		}
		else if( command.equals("Anterior")){
//			cont--;
//			actualizarTitulo();
			this.setVisible(false);
			this.dispose();
			DialogoDevengadoHoras novedadesHora = new DialogoDevengadoHoras(principal, control, dialogoNomina, 4);
			novedadesHora.setLocationRelativeTo(principal);
			novedadesHora.setVisible(true);
		}
		else if( command.equals("Siguiente")){
//			cont++;
		}
	}
	
	public void guardarNovedad(){
		
		int confirm = JOptionPane.showConfirmDialog(this, "¿Desea guardar los cambios realizados?","Warning",JOptionPane.YES_NO_OPTION);		

		if (confirm == JOptionPane.YES_NO_OPTION){
			
			btnAgregar.setEnabled(true);
			btnModificar.setEnabled(true);
			btnEliminar.setEnabled(true);
			
			escapeA.activar(false);
			
			MyTableModel myMod = (MyTableModel) tableDeduccionesPrestamos.getModel();
			myMod.setRowEditable(myMod.getRowCount()-1, false);

			int row = tableDeduccionesPrestamos.getRowCount();
			
			tableDeduccionesPrestamos.setColumnSelectionInterval(2, 2);
			tableDeduccionesPrestamos.setRowSelectionInterval(row-1, row-1);
			
			String fechaPrestamo = (String) tableDeduccionesPrestamos.getValueAt(row-1, 2);
			String concepto = (String) tableDeduccionesPrestamos.getValueAt(row-1, 3);
			String total = (String) tableDeduccionesPrestamos.getValueAt(row-1, 4);
			String cuotaPeriodo = (String) tableDeduccionesPrestamos.getValueAt(row-1, 5);
			String saldo = (String) tableDeduccionesPrestamos.getValueAt(row-1, 6);
			
			if (btnModificar.isEnabled()){
				control.editarDeduccionesOtrosTotalPrestamos(tableDeduccionesPrestamos.getSelectedRow(), fechaPrestamo, concepto, total, cuotaPeriodo, saldo);
			}
			else{
				control.agregarDeduccionesOtrosTotalPrestamos(fechaPrestamo, concepto, total, cuotaPeriodo, saldo);
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
		
		int row = tableDeduccionesPrestamos.getRowCount();
		DefaultTableModel model = (DefaultTableModel) tableDeduccionesPrestamos.getModel();
		model.removeRow(row-1);
	} 
	
	public void modificar(int row, int column){
		
		btnAgregar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(true);
		
		MyTableModel myMod = (MyTableModel) tableDeduccionesPrestamos.getModel();
		myMod.setRowEditable(row, true);
		
		tableDeduccionesPrestamos.editCellAt(row, column);

		if (tableDeduccionesPrestamos.editCellAt(row, column))
		{
			Component editor = tableDeduccionesPrestamos.getEditorComponent();
			editor.requestFocusInWindow();
		}
		
	}
	
	public void eliminar(int index){
		
		if(tableDeduccionesPrestamos.getRowCount() == 0){
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
	
	public void dispose(){
		
		if (dialogoNomina != null){
			try {
				dialogoNomina.actualizarInformacion();
			} catch (NoExisteEmpleadoException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NominaNoEncontradaException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		super.dispose();
	}
}
