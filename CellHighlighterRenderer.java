 
package gui;
import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EventObject;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;

public class CellHighlighterRenderer extends DefaultTableCellRenderer {

@Override
public Component getTableCellRendererComponent(JTable table, Object obj, boolean isSelected, boolean hasFocus,
        int row, int column) {
    Component cell = super.getTableCellRendererComponent(table, obj, isSelected, hasFocus, row, column);

    if (row == table.getSelectedRow()) {
        if (column == table.getSelectedColumn()) {
            // special color
            cell.setBackground(Color.GREEN);
        } else {
            // The selected row color in "com.jtattoo.plaf.aero.AeroLookAndFeel"                
            cell.setBackground(new Color(176, 196, 222)); 
        }
    } else {
        // Other rows
        cell.setBackground(Color.WHITE);
    }

    return cell;
}


}