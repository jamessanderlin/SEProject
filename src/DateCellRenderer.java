
import java.text.DateFormat;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mudrekh
 */
@SuppressWarnings("serial")
public class DateCellRenderer extends LeftCellRenderer{

    DateFormat formatter;
    public DateCellRenderer() { super(); }

    public void setValue(Object value) {
        if (formatter==null) {
            formatter = DateFormat.getDateInstance();
        }
        setText((value == null) ? "" : formatter.format(value));
    }
}
