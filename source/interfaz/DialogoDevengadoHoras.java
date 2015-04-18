package interfaz;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;







import mundo.HoraExtra;

import java.awt.Toolkit;

import javax.swing.JButton;



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


		panel = new JPanel();
		panel.setLayout(null);
		//		panel.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), titulo, TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 11, 652, 288);
		getContentPane().add(panel);
		Object[] dataHoras = { "", "",""};
		Object[] columnsHoras = {"Fecha Ingreso","Usuario","Fecha Realización", "Cantidad","Concepto","Valor Unitario","SubTotal"};
		DefaultTableModel modN = new DefaultTableModel(columnsHoras, 0)
		{

			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};
		tableNovedaesHoras = new JTable(modN);
		tableNovedaesHoras.getTableHeader().setReorderingAllowed(false);

		JScrollPane scrollPane = new JScrollPane(tableNovedaesHoras);
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

	}


	public void actualizarTitulo( )
	{

		switch ( cont ) {
		case -1: 
			this.setVisible(false);
			this.dispose();
			DialogoNovedadesDiasNoLaborados novedadesDias = new DialogoNovedadesDiasNoLaborados(principal, control);
			novedadesDias.setLocationRelativeTo(principal);
			novedadesDias.setVisible(true); break;
		case 0: titulo = "Ordinaria - Extra Diurno"; actualizarOrdinariaExtraDiurno(); break;
		case 1: titulo = "Ordinaria - Extra Nocturno"; actualizarOrdinariaExtraNocturno(); btnAnterior.setEnabled(true); break;
		case 2: titulo = "Dominical y Festivo - Extra Diurno";  actualizarDominicalExtraDiurno(); break;
		case 3: titulo = "Dominical y Festivo - Extra Nocturno";  break;
		case 4: titulo = "Dominical y Festivo - Dominical y Festivo"; break;
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

	private void actualizarDominicalExtraDiurno() {
		// TODO Auto-generated method stub
		ArrayList listaDominicalExtraDiurno = control.getListaDominicalExtraDiurno( );

		if( !listaDominicalExtraDiurno.isEmpty( ) ){
			for (int i = 0; i < listaDominicalExtraDiurno.size(); i++){
				HoraExtra hora = (HoraExtra) listaDominicalExtraDiurno.get(i);
				DefaultTableModel model = (DefaultTableModel) tableNovedaesHoras.getModel();
				model.addRow(new Object[]{hora.getFecha(), hora.getUser().getUser(), hora.getFechaLaborada().toLocaleString(), hora.getNumeroHoras(), hora.getConcepto(), hora.getValorUnitario(), hora.getSubTotal()});
			}
		}
	}


	private void actualizarOrdinariaExtraNocturno() {
		// TODO Auto-generated method stub
		ArrayList listaOrdinariaExtraNocturno = control.getListaOrdinariaExtraNocturno( );

		if( !listaOrdinariaExtraNocturno.isEmpty( ) ){
			for (int i = 0; i < listaOrdinariaExtraNocturno.size(); i++){
				HoraExtra hora = (HoraExtra) listaOrdinariaExtraNocturno.get(i);
				DefaultTableModel model = (DefaultTableModel) tableNovedaesHoras.getModel();
				model.addRow(new Object[]{hora.getFecha(), hora.getUser().getUser(), hora.getFechaLaborada().toLocaleString(), hora.getNumeroHoras(), hora.getConcepto(), hora.getValorUnitario(), hora.getSubTotal()});
			}
		}
	}


	private void actualizarOrdinariaExtraDiurno() {
		// TODO Auto-generated method stub

		ArrayList listaOrdinariaExtraDiurno = control.getListaOrdinariaExtraDiurno( );

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

		}
		else if (command.equals("Modificar")){

		}
		else if( command.equals("Anterior")){
			cont--;
			actualizarTitulo();
		}
		else if( command.equals("Siguiente")){
			cont++;
			actualizarTitulo();
		}
	}

}
