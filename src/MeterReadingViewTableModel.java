
import java.util.Date;
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
public class MeterReadingViewTableModel extends AbstractTableModel{
    private String[] columnNames = {"Date", "Reading"};
    private TreeMap<Date, Meter_Reading> meterReadings;

    public MeterReadingViewTableModel()
    {
        meterReadings = new TreeMap<Date, Meter_Reading>();
    }
    
    public MeterReadingViewTableModel(TreeMap<Date, Meter_Reading> m)
    {
        meterReadings = m;
    }
    
    public int getColumnCount() {
        return columnNames.length;
    }

    public int getRowCount() {
        return meterReadings.size();
    }

    public String getColumnName(int col) {
        return columnNames[col];
    }

    public Object getValueAt(int row, int col) {
       Object[] entries = meterReadings.keySet().toArray();
       Date entry = (Date)entries[row];
       if(col == 0)
           return meterReadings.get(entry).getReadingDate();
       else if(col == 1)
       {
           return meterReadings.get(entry).getReading();
       }
       else
           throw new IndexOutOfBoundsException("MeterReadingViewTableModel provides a 4-column table, column-index "+col+" is illegal.");
           
    }

    public Class getColumnClass(int c) {
        if(meterReadings.size() == 0)
        {
            return Object.class;
        }
        return getValueAt(0, c).getClass();
    }
}
