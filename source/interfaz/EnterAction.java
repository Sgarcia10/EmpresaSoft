package interfaz;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.beans.PropertyChangeListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class EnterAction extends AbstractAction {

	private ValidarCampos validador;
	private JDialog dialogo;
	
	public EnterAction(JDialog dialogoP) {

		validador = new ValidarCampos(dialogoP);
		dialogo = dialogoP;
		String titulo = dialogo.getTitle();
		System.out.println(titulo);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JTable t = (JTable) e.getSource();
		
		int column = t.getSelectedColumn();
		int row = t.getSelectedRow();
		
		if (column >= 0 && row >= 0){
			validarCampo(t, row, column);
		}
		
	}
	
	public boolean validarCampo(JTable t, int row, int column){
		
		String valor = String.valueOf(t.getValueAt(row, column));			
		
		boolean res = true;
		
		String tipo = compararTipoCampo(column);
		
		
		if (valor != null && !valor.isEmpty()){

			res = validador.validarIndividual(valor, tipo);
			
			if (res == false){
				
				t.setValueAt("", row, column);
				
				t.setColumnSelectionInterval(column, column);
				t.setRowSelectionInterval(row, row);
				
				if (t.editCellAt(row, column))
				{			
				    Component editor = t.getEditorComponent();
				    editor.requestFocusInWindow();
				}
			}
			
			else if (column < t.getColumnCount()-1){
				
				t.setColumnSelectionInterval(column+1, column+1);
				t.setRowSelectionInterval(row, row);
				
				if (t.editCellAt(row, column+1))
				{			
				    Component editor = t.getEditorComponent();
				    editor.requestFocusInWindow();
				}
			}
			
			else {
				
				t.clearSelection();
				t.setCellSelectionEnabled(false);
				
				
			}

		}
		
		else{
			JOptionPane.showMessageDialog(dialogo, "Debe ingresar un valor en el campo", "", JOptionPane.INFORMATION_MESSAGE); 
		}
				
		return res;
	}

	private String compararTipoCampo(int column) {
		String tipo = "String";
		
		if (dialogo.getTitle().equalsIgnoreCase("Novedades")){
			if (column == 2){
				tipo = "Date";
			}
			else if (column == 3){
				tipo = "int";
			}
		}
		
		else if ((dialogo.getTitle().equalsIgnoreCase("Devengado"))){
			if (column == 2){
				tipo = "Date";
			}
			else if (column == 3 || column == 5){
				tipo = "int";
			}
		}
		
		else if ((dialogo.getTitle().equalsIgnoreCase("Deducciones"))){
			if (column == 2){
				tipo = "Date";
			}
			else if (column == 4 || column == 5){
				tipo = "int";
			}
		}
		
		
		return tipo;
	}

	private void guardarNovedad() {
		// TODO Auto-generated method stub
		//escribir valores en la 
	}

}
