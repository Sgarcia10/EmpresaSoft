package interfaz;

import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class ValidarCampos {
	
	private JDialog dialogo;
	
	public ValidarCampos(JDialog dialogoP){
		dialogo = dialogoP;
	}
	
	
	/*
	 * Prioridad 0: Valores opcionales que generan una alerta en caso de no ser llenados para que el usuario
	 * 				reconsidere si los deja vacios.
	 * Prioridad 1: Valores obligatorios que se deben llenar y validar.
	 * Prioridad 2: Valores opcionales, no se deben llenar pero si se llenan se deben validar
	 * Prioridad 3: Valores opcionales, no se deben llenar pero si se le asigna algún valor a cualquiera de
	 * 				los parametros con prioridad 3 entonces se deben llenar todos los campos con prioridad 3
	 * 				para que la información quede completa
	 * 
	 * Return:  0 si falló la validación de los campos
	 *			1 si la validación está bien pero hay campos sin llenar
	 *			2 si todos los campos se llenaron adecuadamente 		
	 */
	
	
	public int validar (ArrayList tipo, ArrayList <String> valor, ArrayList<Integer> prioridad, ArrayList<String> nombres){

		int res = 0;
		boolean listo = false;
		
		ArrayList<String> valoresConPrioridad0 = darValoresConPrioridad(valor,prioridad,0);
		ArrayList<String> valoresPrioritarios = darValoresConPrioridad(valor,prioridad,1);
		ArrayList<String> valoresNoPrioritarios = darValoresConPrioridad(valor,prioridad,2);
		ArrayList<String> valoresComplementarios = darValoresConPrioridad(valor,prioridad,3);

		
		ArrayList<String> valoresDeInteres = valoresPrioritarios;
		valoresDeInteres.addAll(valoresNoPrioritarios);
		
		if (valoresPrioritarios.contains("")){
			JOptionPane.showMessageDialog(dialogo, "Hay campos vacíos que se deben llenar en "+ nombres.get(nombres.size()-1), "Error", JOptionPane.INFORMATION_MESSAGE); 
		}
		
		else{
			res = validarCampos(valoresDeInteres, valor, tipo, nombres);

		}
		
		if (!valoresComplementarios.isEmpty()){

			if (encontrarCampoLLeno(valoresComplementarios)){
				if(valoresComplementarios.contains("")){
					ArrayList<String> nombresC = darNombresCorrespondientes(valoresComplementarios, valor, nombres);
					JOptionPane.showMessageDialog(dialogo, "Debe llenar los siguentes campos en " + nombres.get(nombres.size()-1) +
													" o \n dejarlos todos vacíos para tener la información completa \n\n" + formarListaNombres(nombres), "Error", JOptionPane.ERROR_MESSAGE);
					res = 0;
				}
				else{
					
					res = validarCampos(valoresComplementarios, valor, tipo, nombres);
				}
			}
			
			else{
				res = 1;
			}
		}
		

		if (res > 0 && valoresConPrioridad0.contains("")){
			
			int rta = JOptionPane.showConfirmDialog(dialogo, "Hay campos sin llenar en " + nombres.get(nombres.size()-1) +", ¿Desea continuar?", "Advertencia", JOptionPane.YES_NO_OPTION);
			if (rta == JOptionPane.YES_OPTION){
				res = 1;
			}
			else{
				res = 0;
			}
		}
		System.out.println("resultado validar referencia"+res);
		return res;
	}
	 
		
	private ArrayList darValoresConPrioridad(ArrayList valor, ArrayList<Integer> prioridad, int numero){
		
		ArrayList res = new ArrayList<>();
		
		for (int i = 0; i<prioridad.size(); i++){
			if (prioridad.get(i) == numero){
				res.add(valor.get(i));
			}
		}
		
		return res;
	}
	
	
	private int validarCampos(ArrayList<String> valorP, ArrayList totalP, ArrayList tipoP, ArrayList nombreP){
		
		int res = 0;
		boolean listo = false;
	
		for (int i = 0; i < valorP.size() && !listo;i++){
		
			int posicion = totalP.indexOf(valorP.get(i));  //mejorar la forma de encontrar la posicion
			System.out.println(valorP.get(i));
			
			if (tipoP.get(posicion).equals("int")){
			
				try{
					Integer.parseInt(valorP.get(i));
					res = 2;
				}
				catch (Exception e){
					JOptionPane.showMessageDialog(dialogo, "Debe ingresar un valor numérico válido en el campo "+ nombreP.get(i), "Error", JOptionPane.ERROR_MESSAGE);
					listo = true;
					res = 0;
				}	
			}
			else if(tipoP.get(posicion).equals("double")){
			
				try{
					Double.parseDouble(valorP.get(i));
					res = 2;
				}
				catch (Exception e){
					JOptionPane.showMessageDialog(dialogo, "Debe ingresar un valor numérico válido en el campo "+ nombreP.get(i), "Error", JOptionPane.WARNING_MESSAGE);
					listo = true;
					res = 0;
				}	
			}
		}
		
		return res;
	}

	
	
	private boolean encontrarCampoLLeno(ArrayList<String> arrayP){
		boolean res = false;
		
		for (int i = 0; i<arrayP.size() && !res; i++){
			if (!arrayP.get(i).equals("")){
				res = true;
			}
		}
		
		return res;
	}
	
	private ArrayList darNombresCorrespondientes(ArrayList arrayP, ArrayList valorP, ArrayList nombreP){
		
		ArrayList res = new ArrayList<>();

		
		for (int i = 0; i<arrayP.size(); i++){
			int posicion = valorP.indexOf(arrayP.get(i));
			res.add(nombreP.get(posicion));
		}
		
		return res;
	}
	
	private String formarListaNombres(ArrayList<String> arrayP){
		String res = "";
		
		for (int i = 0; i<arrayP.size() -1; i++){
			res = res + " - " + arrayP.get(i) + "\n";
		}
		
		res = res + "\n";		
		return res;
	}
	
}
