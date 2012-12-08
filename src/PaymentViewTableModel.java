import java.util.Date;
import java.util.TreeMap;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author Mudrekh
 */
@SuppressWarnings("serial")
public class PaymentViewTableModel extends AbstractTableModel{
    private String[] columnNames = {"Date", "Paid Amount", "Type"};
    private TreeMap<Date, Payment> payments;

    public PaymentViewTableModel()
    {
        payments = new TreeMap<Date, Payment>();
    }
    
    public PaymentViewTableModel(TreeMap<Date, Payment> p)
    {
        payments = p;
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return payments.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
       Object[] entries = payments.keySet().toArray();
       Date entry = (Date)entries[row];
       Payment p = payments.get(entry);
       if(col == 0)
       {
           return entry;
       }
       else if(col == 1)
       {
           return String.format("%.2f", p.getPaidAmount());
       }
       else if(col == 2)
       {
           return p.getPaymentType();
       }  
       else
           throw new IndexOutOfBoundsException("PaymentViewTableModel provides a 3-column table, column-index "+col+" is illegal.");
           
    }

    public Class getColumnClass(int c) {
        if(payments.size() == 0)
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
