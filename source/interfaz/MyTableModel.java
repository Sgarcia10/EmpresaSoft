package interfaz;

import javax.swing.table.DefaultTableModel;

public class MyTableModel extends DefaultTableModel {
	
	private boolean editable_row[]; // 1d array to represent rows

    public MyTableModel(Object[] columnsHoras) { // constructor
    	
        super(columnsHoras, 0);
        this.editable_row = new boolean[0];
    }

    @Override
    public boolean isCellEditable(int row, int column) { // custom isCellEditable function
        return this.editable_row [row];
    }

    public void setRowEditable(int row, boolean value) {

        this.editable_row [row] = value; // set cell true/false
//        this.fireTableCellUpdated(row, col);
    }
    
    public void agregarFila (){
    	
    	boolean[] nuevo = new boolean [1];
    	nuevo [0] = true;
    	editable_row = concatenar(editable_row, nuevo);
    }
    
    public boolean[] concatenar(boolean[] a, boolean[] b){
    	
    	int al = a.length;
    	int bl = b.length;
    	
    	boolean[] c = new boolean[al + bl];
    	System.arraycopy(a, 0, c, 0, al);
    	System.arraycopy(b, 0, c, al, bl);
    	return c;
    }
    
}
