package interfaz;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {
	
	private boolean editable_row; // 2d array to represent rows and columns

    public MyTableModel(Object[] columnsHoras) { // constructor
    	
        super(columnsHoras, 0);
        this.editable_row = true;
    }

    @Override
    public boolean isCellEditable(int row, int column) { // custom isCellEditable function
        return this.editable_row;
    }

    public void setRowEditable(int row, boolean value) {
        this.editable_row = value; // set cell true/false
//        this.fireTableCellUpdated(row, col);
    }
}
