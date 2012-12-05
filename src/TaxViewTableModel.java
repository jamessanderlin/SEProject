
import java.util.TreeMap;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mudrekh
 */
public class TaxViewTableModel extends AbstractTableModel{
    private String[] columnNames = {"Name", "Rate"};
    private TreeMap<String, Taxes> taxes;

    public TaxViewTableModel()
    {
        taxes = new TreeMap<String, Taxes>();
    }
    
    public TaxViewTableModel(TreeMap<String, Taxes> m)
    {
        taxes = m;
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return taxes.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
       Object[] entries = taxes.keySet().toArray();
       String entry = (String)entries[row];
       if(col == 0)
           return entry;
       else if(col == 1)
       {
           return taxes.get(entry).getRate();
       }
       else
           throw new IndexOutOfBoundsException("TaxViewTableModel provides a 2-column table, column-index "+col+" is illegal.");
           
    }

    public Class getColumnClass(int c) {
        if(taxes.size() == 0)
        {
            return Object.class;
        }
        return getValueAt(0, c).getClass();
    }

//    /*
//     * Don't need to implement this method unless your table's
//     * editable.
//     */
//    public boolean isCellEditable(int row, int col) {
//        //Note that the data/cell address is constant,
//        //no matter where the cell appears onscreen.
//        if (col < 2) {
//            return false;
//        } else {
//            return true;
//        }
//    }
//
//    /*
//     * Don't need to implement this method unless your table's
//     * data can change.
//     */
//    public void setValueAt(Object value, int row, int col) {
//        data[row][col] = value;
//        fireTableCellUpdated(row, col);
//    }
//    ...
}
