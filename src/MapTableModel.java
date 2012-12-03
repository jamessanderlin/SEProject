/*
 * NOTE: THIS CLASS WAS PULLED FROM THE INTERNET AS A TABLE MODEL WRAPPER FOR
 * A JTABLE
 * 
 * Project: Gulden Utilies
 * Class:   de.gulden.util.swing.MapTableModel
 * Version: snapshot-beautyj-1.1
 *
 * Date:    2004-09-29
 *
 * This is a snapshot version of the Gulden Utilities,
 * it is not released as a seperate version.
 *  
 * Note:    Contains auto-generated Javadoc comments created by BeautyJ.
 *  
 * This is licensed under the GNU Lesser General Public License (LGPL)
 * and comes with NO WARRANTY.
 *
 * Author:  Jens Gulden
 * Email:   amoda@jensgulden.de
 */


import java.util.*;
import java.util.Map;
import javax.swing.table.AbstractTableModel;

/**
 * Class MapTableModel.
 *  
 * @author  Jens Gulden
 * @version  snapshot-beautyj-1.1
 */
public class MapTableModel extends AbstractTableModel {

    // ------------------------------------------------------------------------
    // --- fields                                                           ---
    // ------------------------------------------------------------------------

    /**
     * The map.
     */
    protected Map map;

    /**
     * The column names array.
     */
    protected String[] columnNames;


    // ------------------------------------------------------------------------
    // --- constructors                                                     ---
    // ------------------------------------------------------------------------

    /**
     * Creates a new instance of MapTableModel.
     */
    public MapTableModel() {
        super();
    }

    /**
     * Creates a new instance of MapTableModel.
     */
    public MapTableModel(Map map) {
        this(map,"Entry","Value");
    }

    /**
     * Creates a new instance of MapTableModel.
     */
    public MapTableModel(Map map, String keyName, String valueName) {
        this();
        setMap(map);
        setColumnNames(keyName,valueName);
    }


    // ------------------------------------------------------------------------
    // --- methods                                                          ---
    // ------------------------------------------------------------------------

    /**
     * Returns the row count.
     */
    public int getRowCount() {
        return map.size();
    }

    /**
     * Returns the column count.
     */
    public int getColumnCount() {
        return 2;
    }

    /**
     * Returns the value at.
     */
    public Object getValueAt(int row, int column) {
        Object[] entries=map.entrySet().toArray();
        Map.Entry entry=(Map.Entry)entries[row];
        if (column==0) {
            return entry.getKey();
        } else if (column==1) { // column==1
            return entry.getValue();
        } else {
            throw new IndexOutOfBoundsException("MapTableModel provides a 2-column table, column-index "+column+" is illegal.");
        }
    }

    /**
     * Returns the column name.
     */
    public String getColumnName(int column) {
        return columnNames[column];
    }

    /**
     * Sets the column names.
     */
    public void setColumnNames(String keyName, String valueName) {
        String[] names={keyName,valueName};
        columnNames=names;
    }

    /**
     * Returns the map.
     */
    public Map getMap() {
        return map;
    }

    /**
     * Sets the map.
     */
    public void setMap(Map _map) {
        map = _map;
    }
    
    public Class getColumnClass(int c) {
        if(map.size() == 0)
        {
            return Object.class;
        }
        return getValueAt(0, c).getClass();
    }

} // end MapTableModel

