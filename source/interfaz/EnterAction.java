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
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		JTable t = (JTable) e.getSource();
		
		int column = t.getSelectedColumn();
		int row = t.getSelectedRow();
		
		validarCampo(t, row, column);
	}
	
	public boolean validarCampo(JTable t, int row, int column){
		
		String valor = String.valueOf(t.getValueAt(row, column));			
		String tipo = "String";
		System.out.println(valor);
		
		boolean res = true;
		
		if (column == 2){
			tipo = "Date";
		}
		else if (column == 3){
			tipo = "int";
		}
		
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
			
//			else {
//				guardarNovedad();
//			}

		}
		
		else{
			JOptionPane.showMessageDialog(dialogo, "Debe ingresar un valor en el campo", "", JOptionPane.INFORMATION_MESSAGE); 
		}
				
		return res;
	}

}
