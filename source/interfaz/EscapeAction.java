package interfaz;

import interfaz.liquidacion.DialogoNovedadesDiasNoLaborados;
import interfaz.liquidacion.DialogoNovedadesHoras;

import java.awt.Component;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTable;

public class EscapeAction extends AbstractAction{
	
	private ValidarCampos validador;
	private JDialog dialogo;
	private boolean activado; 
	
	public EscapeAction(JDialog dialogoP) {

		validador = new ValidarCampos(dialogoP);
		dialogo = dialogoP;
		activado = false;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (activado){
			
			JTable t = (JTable) e.getSource();
			
			String titulo = dialogo.getTitle();
			int column = t.getSelectedColumn();
			int row = t.getSelectedRow();
			
			int confirm = JOptionPane.showConfirmDialog(dialogo, "¿Desea cancelar la creación de una nueva Novedad?","Warning",JOptionPane.YES_NO_OPTION);		

			if (confirm == JOptionPane.YES_NO_OPTION){
				
				if (titulo.equalsIgnoreCase("Novedades")){
					((DialogoNovedadesDiasNoLaborados) dialogo).cancelarCreación();
				}
				else if (titulo.equalsIgnoreCase("Devengado")){
					((DialogoNovedadesHoras) dialogo).cancelarCreación();
				}
				else if (titulo.equalsIgnoreCase("Deducciones")){
					((DialogoNovedadesHoras) dialogo).cancelarCreación();
				}
			}
		}		
	}
	
	private void guardarNovedad() {
		// TODO Auto-generated method stub
		//escribir valores en la 
	}
	
	public void activar(boolean valor){
		activado = valor;
	}
}
