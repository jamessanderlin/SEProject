import java.util.*;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 * Class MeterTableModel extends MapTableModel specifically for a meter table.
 *  
 * @author  Mudrekh Goderya
 */
public class MeterTableModel extends MapTableModel {
    /**
     * Creates a new instance of MapTableModel.
     */
    public MeterTableModel() {
        super();
    }

    /**
     * Creates a new instance of MapTableModel.
     */
    public MeterTableModel(Map map) {
        this(map, "Meter ID");
    }

    /**
     * Creates a new instance of MapTableModel.
     */
    public MeterTableModel(Map map, String keyName) {
        this();
        setMap(map);
        setColumnName(keyName);
    }
    
    /**
     * Override the constructor for this parameter to avoid confusion
     * @Override
     */
    public MeterTableModel(Map map, String keyName,  String entryName) {
        this(map, keyName);
    }

    /**
     * Returns the column count.
     * @Override
     */
    public int getColumnCount() {
        return 1;
    }

    /**
     * Returns the value at.
     * @Override
     */
    public Object getValueAt(int row, int column) {
        Object[] entries=map.entrySet().toArray();
        Map.Entry entry=(Map.Entry)entries[row];
        if (column==0) {
            return entry.getKey();
//        } else if (column==1) { // column==1
//            return entry.getValue();
        } else {
            throw new IndexOutOfBoundsException("MeterTableModel provides a 1-column table, column-index "+column+" is illegal.");
        }
    }

    /**
     * Overrides the column names to avoid confusion
     * @Override
     */
    public void setColumnNames(String keyName, String valueName) {
        setColumnName(keyName);
    }
    
    /**
     * Sets the column name.
     */
    public void setColumnName(String keyName) {
        String[] names={keyName};
        columnNames=names;
    }

} // end MapTableModel

