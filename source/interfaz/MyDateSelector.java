package interfaz;

import java.awt.Component;
import java.util.Calendar;
import java.util.Date;

import javax.swing.AbstractCellEditor;
import javax.swing.JSpinner;
import javax.swing.JTable;
import javax.swing.SpinnerDateModel;
import javax.swing.SpinnerModel;
import javax.swing.table.TableCellEditor;

public class MyDateSelector extends AbstractCellEditor implements TableCellEditor {

	Date currentDate;
	JSpinner spinner;

	protected static final String EDIT = "edit";

	public MyDateSelector() {
		Calendar calendar = Calendar.getInstance();
		Date initDate = calendar.getTime();
		calendar.add(Calendar.YEAR, -100);
    	Date earliestDate = calendar.getTime();
    	calendar.add(Calendar.YEAR, 200);
    	Date latestDate = calendar.getTime();
    	SpinnerModel dateModel = new SpinnerDateModel(initDate,
            earliestDate,
            latestDate,
            Calendar.YEAR);//ignored for user input
    	spinner = new JSpinner(dateModel);
    	spinner.setEditor(new JSpinner.DateEditor(spinner, "dd/MM/yyyy"));
	}

	// Implement the one CellEditor method that AbstractCellEditor doesn't.
	public Object getCellEditorValue() {
		currentDate = ((SpinnerDateModel)spinner.getModel()).getDate();
		Object obj = ((SpinnerDateModel)spinner.getModel()).getDate();
		Date d = (Date) obj;
		return d.getDate()+"/"+(d.getMonth()+1)+"/"+(d.getYear()-100);
	}


	@Override
	public Component getTableCellEditorComponent(JTable table, Object value,
		boolean isSelected, int row, int column) {
	
//		currentDate = (Date)value;
		spinner.setValue(new Date());
		return spinner;
		}
}
