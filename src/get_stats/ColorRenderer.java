package get_stats;

import java.awt.Color;
import java.awt.Component;


import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;
/**
 * @author ashraf_sarhan
 *
 */
public class ColorRenderer implements TableCellRenderer {

    public static final DefaultTableCellRenderer DEFAULT_RENDERER = new DefaultTableCellRenderer();
    
    public static final Color ODD_ROW_COLOR = Color.LIGHT_GRAY;

    public static final Color EVEN_ROW_COLOR = Color.WHITE;

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value,
            boolean isSelected, boolean hasFocus, int row, int column) {
        Component c = DEFAULT_RENDERER.getTableCellRendererComponent(table,
                value, isSelected, hasFocus, row, column);
 
        // Apply zebra style on table rows
        if (row % 2 == 0) {
            c.setBackground(EVEN_ROW_COLOR);
        } else {
            c.setBackground(ODD_ROW_COLOR);
        }
        return c;
    }
}

