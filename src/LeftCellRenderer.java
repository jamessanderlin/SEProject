import javax.swing.table.DefaultTableCellRenderer;

/**
 * Quick snippet class to quickly and easily left justify the cells of a JTable.
 * 
 * @author Mudrekh Goderya
 */
@SuppressWarnings("serial")
public class LeftCellRenderer extends DefaultTableCellRenderer{

	public LeftCellRenderer()
	{
            super();
            this.setHorizontalAlignment(LEFT);
	}
}
