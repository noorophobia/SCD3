package com.mycompany.assignment3;

import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import javax.swing.*;
import javax.swing.table.*;

public class Assignment3 extends JFrame {

    private JPanel topPanel;
    private JTable table;
    private JScrollPane scrollPane;
    private String[] columnNames = { "Column 1", "Column 2", "Column 3" };
    private String[][] dataValues = { { "1", "2", "Button 1" }, { "4", "5", "Button 2" }, { "7", "8", "Button 3" } };

    public Assignment3() {
        setTitle("Button in JTable Cell");
        setSize(300, 300);
        topPanel = new JPanel();
        topPanel.setLayout(new BorderLayout());
        getContentPane().add(topPanel);

        DefaultTableModel model = new DefaultTableModel(dataValues, columnNames) ;

        table = new JTable(model);

        // Use a custom cell renderer and cell editor for the Button column
        table.getColumn("Column 3").setCellRenderer(new ButtonRenderer());
        table.getColumn("Column 3").setCellEditor(new ButtonEditor(new JCheckBox()));

        scrollPane = new JScrollPane(table);
        topPanel.add(scrollPane, BorderLayout.CENTER);
    }

    class ButtonRenderer extends JButton implements TableCellRenderer {
        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
                int row, int column) {
            setText((value == null) ? "" : value.toString());
            						System.out.print("value.toString()"+value.toString());

            return this;
        }
    }

    class ButtonEditor extends DefaultCellEditor {
        private String label;
        private JButton button;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            button.setOpaque(true);

            button.addActionListener(e -> {
                // Handle button click here
                JOptionPane.showMessageDialog(null, "Button Clicked in JTable Cell");
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, int row, int column) {
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            return button;
        }

        public Object getCellEditorValue() {
            return label;
        }
    }

    public static void main(String args[]) throws IOException {
         Library l=new Library();
        
    }
}

