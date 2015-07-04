package interfaz.temporal;

import interfaz.Control;
import interfaz.InterfazNomina;

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













import java.awt.Toolkit;

import javax.swing.JButton;

import mundo.nomina.DiasNoLaborados;
import mundo.nomina.Prestamo;

import java.awt.Dialog.ModalityType;


public class DialogoDeduccionesPrestamos extends JDialog implements ActionListener
{
	private InterfazNomina principal;
	private Control control;
	private ArrayList<Integer> indices;
	private Date fecha;
	private int cont;
	private JTable tableDeduccionesPrestamos;
	private DecimalFormat formatea;
	private String titulo;
	private JPanel panel;
	private JButton btnModificar;
	private JButton btnAgregar;
	private JButton btnAnterior;
	private JButton btnSiguiente;

	public DialogoDeduccionesPrestamos( InterfazNomina ventana, Control pControl) {
		super(null, java.awt.Dialog.ModalityType.TOOLKIT_MODAL);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DialogoDeduccionesPrestamos.class.getResource("/com/sun/java/swing/plaf/windows/icons/Computer.gif")));
		getContentPane().setBackground(Color.WHITE);
		principal = ventana;
		control = pControl;
		//		titulo = "Horas Extras Diurnas";
		cont = 0;
		setTitle("Deducciones");
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
		Object[] columnsPrestamos = {"Fecha Ingreso","Usuario","Fecha Pr�stamo","Concepto","Total","Cuota Per�odo","Saldo"};
		DefaultTableModel modN = new DefaultTableModel(columnsPrestamos, 0)
		{

			@Override
			public boolean isCellEditable(int row, int column) {
				//all cells false
				return false;
			}
		};
		tableDeduccionesPrestamos = new JTable(modN);
		tableDeduccionesPrestamos.getTableHeader().setReorderingAllowed(false);

		JScrollPane scrollPane = new JScrollPane(tableDeduccionesPrestamos);
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
		ArrayList listaPrestamos = control.getListaDeduccionesPrestamos( principal.darPeriodo());

		if( !listaPrestamos.isEmpty( ) ){
			for (int i = 0; i < listaPrestamos.size(); i++){
				Prestamo prestamoActual = (Prestamo) listaPrestamos.get(i);
				DefaultTableModel model = (DefaultTableModel) tableDeduccionesPrestamos.getModel();
				model.addRow(new Object[]{prestamoActual.getFecha(), prestamoActual.getUser().getUser(), prestamoActual.getFechaExpedicion().toLocaleString(), prestamoActual.getConcepto(), prestamoActual.getCantidad(), prestamoActual.getCuotaPeriodo(), prestamoActual.getSaldo()});
			}
		}
	}


	public void actualizarTitulo( )
	{

		switch ( cont ) {
		case 0: titulo = "Pr�stamos";  btnSiguiente.setEnabled(false); break;
		default:  titulo = "Pr�stamos"; btnSiguiente.setEnabled(false); break;
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
			
		}
		else if (command.equals("Modificar")){
			
		}
		else if( command.equals("Anterior")){
//			cont--;
//			actualizarTitulo();
			this.setVisible(false);
			this.dispose();
			DialogoDevengadoHoras novedadesHora = new DialogoDevengadoHoras(principal, control, 4);
			novedadesHora.setLocationRelativeTo(principal);
			novedadesHora.setVisible(true);
		}
		else if( command.equals("Siguiente")){
//			cont++;
		}
	}

}
