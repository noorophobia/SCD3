/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.MouseInputAdapter;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;



  public class RollOverTable extends JTable {

    private int rollOverRowIndex = -1;
    private int rollOverColumnIndex = -1;

    public RollOverTable(TableModel model) {
        super(model);
        RollOverListener lst = new RollOverListener();
        addMouseMotionListener(lst);
        addMouseListener(lst);
    }

    @Override
    public Component prepareRenderer(TableCellRenderer renderer, int row, int column) {
        JComponent c = (JComponent) super.prepareRenderer(renderer, row, column);
        
        // Reset the cell border to the default
        c.setBorder(UIManager.getBorder("Table.cellBorder"));

        if (row == rollOverRowIndex && column == rollOverColumnIndex) {
            // Set a red border color for the cell
            c.setBorder(BorderFactory.createLineBorder(Color.RED));
        }

        return c;
    }

    private class RollOverListener extends MouseInputAdapter {

        public void mouseExited(MouseEvent e) {
            rollOverRowIndex = -1;
            rollOverColumnIndex = -1;
            repaint();
        }

        public void mouseMoved(MouseEvent e) {
            int row = rowAtPoint(e.getPoint());
            int column = columnAtPoint(e.getPoint());
            if (row != rollOverRowIndex || column != rollOverColumnIndex) {
                rollOverRowIndex = row;
                rollOverColumnIndex = column;
                repaint();
            }
        }
    }
}
