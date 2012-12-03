
import java.util.ArrayList;
import java.util.TreeMap;
import javax.swing.table.AbstractTableModel;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mudrekh
 */

class MeterViewTableModel extends AbstractTableModel {
    private String[] columnNames = {"Meter ID", "Type", "Rate"};
    private TreeMap<Integer, Meter> meters;

    public MeterViewTableModel()
    {
        meters = new TreeMap<>();
    }
    
    public MeterViewTableModel(Meter m)
    {
        meters = new TreeMap<>();
        if(m!=null)
        {
            meters.put(m.getMeterID(), m);
        }
    }
    
    public MeterViewTableModel(TreeMap<Integer, Meter> m)
    {
        meters = m;
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return meters.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
       Object[] entries = meters.keySet().toArray();
       Integer entry = (Integer)entries[row];
       if(col == 0)
           return meters.get(entry).getMeterID();
       else if(col == 1)
       {
           if(meters.get(entry).getIsDigital())
                return "Digital";
           else
               return "Analog";
       }
       else if(col == 2)
           return meters.get(entry).getMeterRate();
//       else if(col == 3)
//           return meters.get(entry).getPhysicalAddress().toString();
       else
           throw new IndexOutOfBoundsException("MeterTableModel provides a 4-column table, column-index "+col+" is illegal.");
           
    }

    public Class getColumnClass(int c) {
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