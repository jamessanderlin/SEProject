
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
@SuppressWarnings("serial")
class MeterViewTableModel extends AbstractTableModel {
    private String[] columnNames = {"Meter ID", "Type", "Rate"};
    private TreeMap<Integer, Meter> meters;

    public MeterViewTableModel()
    {
        meters = new TreeMap<Integer, Meter>();
    }
    
    public MeterViewTableModel(Meter m)
    {
        meters = new TreeMap<Integer, Meter>();
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
       else
           throw new IndexOutOfBoundsException("MeterTableModel provides a 4-column table, column-index "+col+" is illegal.");
           
    }

    public Class getColumnClass(int c) {
        if(meters.size() == 0)
        {
            return Object.class;
        }
        return getValueAt(0, c).getClass();
    }
}