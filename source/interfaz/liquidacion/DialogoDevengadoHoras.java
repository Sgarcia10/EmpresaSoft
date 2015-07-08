package interfaz.liquidacion;

import interfaz.Control;
import interfaz.EnterAction;
import interfaz.EscapeAction;
import interfaz.InterfazNomina;
import interfaz.MyTableModel;

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
import javax.swing.table.TableModel;

import java.awt.Toolkit;

import javax.swing.JButton;

import Excepciones.NoExisteEmpleadoException;
import Excepciones.NominaNoEncontradaException;
import mundo.nomina.HoraExtra;



public class DialogoDevengadoHoras extends JDialog implements ActionListener
{
	private InterfazNomina principal;
	private Control control;
	private ArrayList<Integer> indices;
	private Date fecha;
	private int cont;
	private JTable tableNovedaesHoras;
	private DecimalFormat formatea;
	private String titulo;
	private JPanel panel;
	private JButton btnModificar;
	private JButton btnAgregar;
	private JButton btnAnterior;
	private JButton btnSiguiente;

	private MyTableModel ordinaria_extra_diurno;
	private MyTableModel ordinaria_extra_nocturno;
	private MyTableModel dominical_extra_diurno;
	private MyTableModel dominical_extra_nocturno;
	private MyTableModel dominical_dia;

	private SimpleDateFormat sdf;
	private JButton btnEliminar;
	
	private EnterAction enterA;
	private EscapeAction escapeA;

	private static final String solve = "Solve";
	private static final String cancel = "Cancel";

	public DialogoDevengadoHoras( InterfazNomina ventana,  Control pControl, int pCont) {
		super(null, java.awt.Dialog.ModalityType.TOOLKIT_MODAL);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoDevengadoHoras.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		getContentPane().setBackground(Color.WHITE);
		principal = ventana;
		control = pControl;
		//		titulo = "Horas Extras Diurnas";
		cont = pCont;
		setTitle("Devengado");
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
		Object[] columnsHoras = {"Fecha Ingreso","Usuario","Fecha Realización", "Cantidad","Concepto","Valor Unitario","SubTotal"};

		MyTableModel modN = new MyTableModel(columnsHoras);

		tableNovedaesHoras = new JTable(modN);
		tableNovedaesHoras.getTableHeader().setReorderingAllowed(false);

		//Enter action command
		enterA = new EnterAction(this);
		KeyStroke enter = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);
		tableNovedaesHoras.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(enter,solve);
		tableNovedaesHoras.getActionMap().put(solve, enterA);
		//
		
		//Escape action command para cancelar el proceso de agregar
		escapeA = new EscapeAction(this);
		KeyStroke escape = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0);
		tableNovedaesHoras.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT).put(escape,cancel);
		tableNovedaesHoras.getActionMap().put(cancel, escapeA);
		//

		tableNovedaesHoras.getTableHeader().setReorderingAllowed(false);


		ordinaria_extra_diurno = new MyTableModel(columnsHoras);
		ordinaria_extra_nocturno = new MyTableModel(columnsHoras);
		dominical_extra_diurno = new MyTableModel(columnsHoras);
		dominical_extra_nocturno = new MyTableModel(columnsHoras);
		dominical_dia = new MyTableModel(columnsHoras);

		JScrollPane scrollPane = new JScrollPane(tableNovedaesHoras);
		scrollPane.setBounds(10, 22, 632, 221);
		panel.add(scrollPane);

		btnModificar = new JButton("Modificar");
		btnModificar.setBounds(71, 254, 169, 23);
		btnModificar.addActionListener(this);
		btnModificar.setEnabled(false);
		btnModificar.setActionCommand("Modificar");
		panel.add(btnModificar);

		btnAgregar = new JButton("Agregar");
		btnAgregar.setBounds(250, 254, 169, 23);
		btnAgregar.addActionListener(this);
		btnAgregar.setActionCommand("Agregar");
		panel.add(btnAgregar);
		
		btnEliminar = new JButton("Eliminar");
		btnEliminar.addActionListener(this);
		btnEliminar.setActionCommand("Eliminar");
		btnEliminar.setEnabled(false);
		btnEliminar.setBounds(429, 254, 169, 23);
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
		}
		catch( Exception e){
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
		
		if(tableNovedaesHoras.getRowCount() == 0){
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


	public void actualizarTitulo( ) throws NoExisteEmpleadoException, NominaNoEncontradaException
	{

		switch ( cont ) {
		case -1: 
			this.setVisible(false);
			this.dispose();
			DialogoNovedadesDiasNoLaborados novedadesDias = new DialogoNovedadesDiasNoLaborados(principal, control);
			novedadesDias.setLocationRelativeTo(principal);
			novedadesDias.setVisible(true); break;


		case 0: titulo = "Ordinaria - Extra Diurno"; /*actualizarOrdinariaExtraDiurno();*/ tableNovedaesHoras.setModel(ordinaria_extra_diurno);break;
		case 1: titulo = "Ordinaria - Extra Nocturno";  /*actualizarOrdinariaExtraNocturno();*/ btnAnterior.setEnabled(true); tableNovedaesHoras.setModel(ordinaria_extra_nocturno); break;
		case 2: titulo = "Dominical y Festivo - Extra Diurno";  /* actualizarDominicalExtraDiurno();*/tableNovedaesHoras.setModel(dominical_extra_diurno); break;
		case 3: titulo = "Dominical y Festivo - Extra Nocturno";   /*actualizarDominicalExtraNocturno( );*/tableNovedaesHoras.setModel(dominical_extra_nocturno);break;
		case 4: titulo = "Dominical y Festivo - Dominical y Festivo";  /*actualizarDominicalDiasDomYFestivos( );*/ tableNovedaesHoras.setModel(dominical_dia);break;
		case 5: 

			this.setVisible(false);
			this.dispose();
			DialogoDeduccionesPrestamos deducciones = new DialogoDeduccionesPrestamos(principal, control);
			deducciones.setLocationRelativeTo(principal);
			deducciones.setVisible(true); break;
		default:  titulo = "Ordinaria - Extra Diurno"; break;
		}
		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null));
	}

	private void actualizarDominicalDiasDomYFestivos() throws NoExisteEmpleadoException, NominaNoEncontradaException{
		// TODO Auto-generated method stub
		ArrayList listaDominicalDominicales = control.getListaDominicalDiasDominicalesYFestivos(principal.darPeriodo() );

		if( !listaDominicalDominicales.isEmpty( ) ){
			for (int i = 0; i < listaDominicalDominicales.size(); i++){
				HoraExtra hora = (HoraExtra) listaDominicalDominicales.get(i);
				DefaultTableModel model = (DefaultTableModel) tableNovedaesHoras.getModel();
				model.addRow(new Object[]{hora.getFecha(), hora.getUser().getUser(), hora.getFechaLaborada().toLocaleString(), hora.getNumeroHoras(), hora.getConcepto(), hora.getValorUnitario(), hora.getSubTotal()});
			}
		}
	}


	private void actualizarDominicalExtraNocturno() throws NoExisteEmpleadoException, NominaNoEncontradaException{
		// TODO Auto-generated method stub
		ArrayList listaDominicalExtraNocturno = control.getListaDominicalExtraNocturno( principal.darPeriodo());
		tableNovedaesHoras.setModel(dominical_extra_nocturno);

		//		if( !listaDominicalExtraNocturno.isEmpty( ) ){
		//			for (int i = 0; i < listaDominicalExtraNocturno.size(); i++){
		//				HoraExtra hora = (HoraExtra) listaDominicalExtraNocturno.get(i);
		//				DefaultTableModel model = (DefaultTableModel) tableNovedaesHoras.getModel();
		//				model.addRow(new Object[]{hora.getFecha(), hora.getUser().getUser(), hora.getFechaLaborada().toLocaleString(), hora.getNumeroHoras(), hora.getConcepto(), hora.getValorUnitario(), hora.getSubTotal()});
		//			}
		//		}
	}


	private void actualizarDominicalExtraDiurno() throws NoExisteEmpleadoException, NominaNoEncontradaException{
		// TODO Auto-generated method stub
		ArrayList listaDominicalExtraDiurno = control.getListaDominicalExtraDiurno(principal.darPeriodo() );
		tableNovedaesHoras.setModel(dominical_extra_diurno);

		//		if( !listaDominicalExtraDiurno.isEmpty( ) ){
		//			for (int i = 0; i < listaDominicalExtraDiurno.size(); i++){
		//				HoraExtra hora = (HoraExtra) listaDominicalExtraDiurno.get(i);
		//				DefaultTableModel model = (DefaultTableModel) tableNovedaesHoras.getModel();
		//				model.addRow(new Object[]{hora.getFecha(), hora.getUser().getUser(), hora.getFechaLaborada().toLocaleString(), hora.getNumeroHoras(), hora.getConcepto(), hora.getValorUnitario(), hora.getSubTotal()});
		//			}
		//		}
	}


	private void actualizarOrdinariaExtraNocturno() throws NoExisteEmpleadoException, NominaNoEncontradaException{
		// TODO Auto-generated method stub
		ArrayList listaOrdinariaExtraNocturno = control.getListaOrdinariaExtraNocturno( principal.darPeriodo());

		if( !listaOrdinariaExtraNocturno.isEmpty( ) ){
			for (int i = 0; i < listaOrdinariaExtraNocturno.size(); i++){
				HoraExtra hora = (HoraExtra) listaOrdinariaExtraNocturno.get(i);
				DefaultTableModel model = (DefaultTableModel) tableNovedaesHoras.getModel();
				model.addRow(new Object[]{hora.getFecha(), hora.getUser().getUser(), hora.getFechaLaborada().toLocaleString(), hora.getNumeroHoras(), hora.getConcepto(), hora.getValorUnitario(), hora.getSubTotal()});
			}
		}
	}


	private void actualizarOrdinariaExtraDiurno() throws NoExisteEmpleadoException, NominaNoEncontradaException{
		// TODO Auto-generated method stub

		ArrayList listaOrdinariaExtraDiurno = control.getListaOrdinariaExtraDiurno(principal.darPeriodo() );

		if( !listaOrdinariaExtraDiurno.isEmpty( ) ){
			for (int i = 0; i < listaOrdinariaExtraDiurno.size(); i++){
				HoraExtra hora = (HoraExtra) listaOrdinariaExtraDiurno.get(i);
				DefaultTableModel model = (DefaultTableModel) tableNovedaesHoras.getModel();
				model.addRow(new Object[]{hora.getFecha(), hora.getUser().getUser(), hora.getFechaLaborada().toLocaleString(), hora.getNumeroHoras(), hora.getConcepto(), hora.getValorUnitario(), hora.getSubTotal()});
			}
		}
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

			switch ( cont ) {

			case 0: agregarFila(ordinaria_extra_diurno); break;
			case 1: agregarFila(ordinaria_extra_nocturno); break;
			case 2: agregarFila(dominical_extra_diurno); break;
			case 3: agregarFila(dominical_extra_nocturno); break;
			case 4: agregarFila(dominical_dia); break;

			default: ; break;
			}

		}
		else if (command.equals("Modificar")){
			
			int row = tableNovedaesHoras.getSelectedRow();
			int column = tableNovedaesHoras.getSelectedColumn();
			modificar(row, column);
		}
		
		else if (command.equals("Eliminar")){
			
			int confirm = JOptionPane.showConfirmDialog(this, "¿Desea eliminar la novedad seleccionada?","Warning",JOptionPane.YES_NO_OPTION);		

			if (confirm == JOptionPane.YES_NO_OPTION){
				
				int index = tableNovedaesHoras.getSelectedRow();
				DefaultTableModel dm = (DefaultTableModel) tableNovedaesHoras.getModel();
				dm.removeRow(index);
				eliminar(index);
			}
		}
		else if( command.equals("Anterior")){
			cont--;
			try{
				actualizarTitulo();
			}
			catch( Exception e1){
				JOptionPane.showMessageDialog(this, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

			}
			
		}
		else if( command.equals("Siguiente")){
			cont++;
			try{
				actualizarTitulo();
			}
			catch( Exception e1){
				JOptionPane.showMessageDialog(this, e1.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);

			}
		}
	}

	private void agregarFila(MyTableModel mod){

		btnAgregar.setEnabled(false);
		btnEliminar.setEnabled(false);
		escapeA.activar(true);
		
		MyTableModel model = mod;
		model.addRow(new Object[]{"","","","","","",""});
		model.agregarFila();

		int numeroFilas = model.getRowCount();
		int numeroColumnas = model.getColumnCount();

		model.setValueAt(sdf.format(new Date()), numeroFilas-1, 0);
		
		String user = control.darUsuario();
		model.setValueAt(user, numeroFilas-1, 1);

		int row = numeroFilas - 1;
		int column = 2;
		
		if (numeroFilas > 0){
			for (int i = 0; i < numeroFilas-1; i++){
				mod.setRowEditable(i, false);
			}
		}
		
//		mod.setRowEditable(mod.getRowCount()-1, true);

		MyTableModel myMod = (MyTableModel) tableNovedaesHoras.getModel();
		myMod.setRowEditable(myMod.getRowCount()-1, true);

		tableNovedaesHoras.setCellSelectionEnabled(true);

		tableNovedaesHoras.setColumnSelectionInterval(column, column);
		tableNovedaesHoras.setRowSelectionInterval(row, row);

//		tableNovedaesHoras.requestFocus();
		tableNovedaesHoras.editCellAt(row, column);

		if (tableNovedaesHoras.editCellAt(row, column))
		{
			Component editor = tableNovedaesHoras.getEditorComponent();
			editor.requestFocusInWindow();
		}
		
	}

	public void guardarNovedad(){

		int confirm = JOptionPane.showConfirmDialog(this, "¿Desea guardar los cambios realizados?","Warning",JOptionPane.YES_NO_OPTION);		

		if (confirm == JOptionPane.YES_NO_OPTION){
			
			btnAgregar.setEnabled(true);
			btnModificar.setEnabled(true);
			btnEliminar.setEnabled(true);
			
			escapeA.activar(false);
			
			MyTableModel myMod = (MyTableModel) tableNovedaesHoras.getModel();
			myMod.setRowEditable(myMod.getRowCount()-1, false);

			int row = tableNovedaesHoras.getRowCount();
			
			tableNovedaesHoras.setColumnSelectionInterval(2, 2);
			tableNovedaesHoras.setRowSelectionInterval(row-1, row-1);
			
			String fechaRealizado = (String) tableNovedaesHoras.getValueAt(row-1, 2);
			String cantidad = (String) tableNovedaesHoras.getValueAt(row-1, 3);
			String concepto = (String) tableNovedaesHoras.getValueAt(row-1, 4);
			String valorUnitario = (String) tableNovedaesHoras.getValueAt(row-1, 5);
			String subTotal = (String) tableNovedaesHoras.getValueAt(row-1, 6);
			
			if (btnModificar.isEnabled()){
				
				switch ( cont ) {

				case 0: control.editarOrdinarioExtraDiurno(tableNovedaesHoras.getSelectedRow(),fechaRealizado, cantidad, concepto, valorUnitario, subTotal); break;
				case 1: control.editarOrdinarioExtraNocturno(tableNovedaesHoras.getSelectedRow(),fechaRealizado, cantidad, concepto, valorUnitario, subTotal); break;
				case 2: control.editarDominicalExtraDiurno(tableNovedaesHoras.getSelectedRow(),fechaRealizado, cantidad, concepto, valorUnitario, subTotal); break;
				case 3: control.editarDominicalExtraNocturno(tableNovedaesHoras.getSelectedRow(),fechaRealizado, cantidad, concepto, valorUnitario, subTotal); break;
				case 4: control.editarDominicalDiasDominicalesYFestivos(tableNovedaesHoras.getSelectedRow(),fechaRealizado, cantidad, concepto, valorUnitario, subTotal);break;

				default: ; break;
				}
			}
			else{
				
				switch ( cont ) {

				case 0: control.agregarOrdinarioExtraDiurno(fechaRealizado, cantidad, concepto, valorUnitario, subTotal); break;
				case 1: control.agregarOrdinarioExtraNocturno(fechaRealizado, cantidad, concepto, valorUnitario, subTotal); break;
				case 2: control.agregarDominicalExtraDiurno(fechaRealizado, cantidad, concepto, valorUnitario, subTotal); break;
				case 3: control.agregarDominicalExtraNocturno(fechaRealizado, cantidad, concepto, valorUnitario, subTotal); break;
				case 4: control.agregarDominicalDiasDominicalesYFestivos(fechaRealizado, cantidad, concepto, valorUnitario, subTotal);break;

				default: ; break;
				}
				
			}
			
		}

	}
	
	public void cancelarCreación() {
		
		btnAgregar.setEnabled(true);
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(true);
		escapeA.activar(false);
		
		int row = tableNovedaesHoras.getRowCount();
		DefaultTableModel model = (DefaultTableModel) tableNovedaesHoras.getModel();
		model.removeRow(row-1);
	} 
	
	public void modificar(int row, int column){
		
		btnAgregar.setEnabled(false);
		btnModificar.setEnabled(true);
		btnEliminar.setEnabled(true);
		
		MyTableModel myMod = (MyTableModel) tableNovedaesHoras.getModel();
		myMod.setRowEditable(row, true);
		
		tableNovedaesHoras.editCellAt(row, column);

		if (tableNovedaesHoras.editCellAt(row, column))
		{
			Component editor = tableNovedaesHoras.getEditorComponent();
			editor.requestFocusInWindow();
		}
		
	}
	
	public void eliminar(int index){
		
		if(tableNovedaesHoras.getRowCount() == 0){
			btnAgregar.setEnabled(true);
			btnModificar.setEnabled(true);
			btnEliminar.setEnabled(false);
		}
		else{
			btnAgregar.setEnabled(true);
			btnModificar.setEnabled(true);
			btnEliminar.setEnabled(true);
		}
		
		switch ( cont ) {

		case 0: control.eliminarOrdinarioExtraDiurno(index);
		case 1: control.eliminarOrdinarioExtraNocturno(index);
		case 2: control.eliminarDominicalExtraDiurno(index);
		case 3: control.eliminarDominicalExtraNocturno(index);
		case 4: control.eliminarDominicalDiasDominicalesYFestivos(index);

		default: ; break;
		
		}
	}

}
