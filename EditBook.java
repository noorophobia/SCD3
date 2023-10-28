/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import com.mycompany.assignment3.Book;
import com.mycompany.assignment3.EditBookinFile;
import javax.swing.table.DefaultTableModel;

    import javax.swing.*;
import java.awt.*;

     import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
public class EditBook extends JFrame {
     

     private JTextField titleField, authorField, yearField, costField;
    private JTable bookTable;
    private DefaultTableModel tableModel;
    private JComboBox<String> selectRowDropdown;

    public EditBook(JTable bookTable, DefaultTableModel tableModel, Integer[] popular_count) {
        this.bookTable = bookTable;
        this.tableModel = tableModel;

        setTitle("Edit Book");
        setLayout(new GridLayout(6, 2));

        JLabel selectLabel = new JLabel("Select Row: ");
        selectRowDropdown = new JComboBox<>();
        populateDropdown(); // Fill the dropdown initially

        JLabel titleLabel = new JLabel("Title: ");
        titleField = new JTextField(20);

        JLabel authorLabel = new JLabel("Author: ");
        authorField = new JTextField(20);

        JLabel yearLabel = new JLabel("Year: ");
        yearField = new JTextField(20);

        JLabel costLabel = new JLabel("Cost: ");
        costField = new JTextField(20);

        JButton updateButton = new JButton("Update");

        add(selectLabel);
        add(selectRowDropdown);
        add(titleLabel);
        add(titleField);
        add(authorLabel);
        add(authorField);
        add(yearLabel);
        add(yearField);
        add(costLabel);
        add(costField);
       
        selectRowDropdown.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int selectedRow = selectRowDropdown.getSelectedIndex();
                if (selectedRow != -1) {
                    titleField.setText(tableModel.getValueAt(selectedRow, 1).toString());
                    authorField.setText(tableModel.getValueAt(selectedRow, 2).toString());
                    yearField.setText(tableModel.getValueAt(selectedRow, 3).toString());
                    costField.setText(tableModel.getValueAt(selectedRow, 4).toString());
                }
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = selectRowDropdown.getSelectedIndex();
                if (selectedRow != -1) {
 
                    String titleToEdit = titleField.getText();
                    String newAuthor = authorField.getText();
                    int newYear = Integer.parseInt(yearField.getText());
                    int newCost = Integer.parseInt(costField.getText());
                        String lineToEdit =  titleToEdit + "," + newAuthor + "," +newYear + "," + popular_count[selectedRow] + "," + newCost ;
                    String line="";
                    line= line+ tableModel.getValueAt(selectedRow, 1).toString()+",";
                    line= line+ tableModel.getValueAt(selectedRow, 2).toString()+",";
                    line= line+ tableModel.getValueAt(selectedRow, 3).toString()+",";
                    line=line+popular_count[selectedRow]+",";
                    line= line+ tableModel.getValueAt(selectedRow, 4).toString();
                    	        System.out.println("Existing co ited."+line);

                    editBookRow(selectedRow, titleToEdit, newAuthor, newYear, newCost, tableModel);
                    try {
                        
                        
                        
                         
                        
                        EditBookinFile.Edit(lineToEdit, line);
                    } catch (IOException ex) {
                        Logger.getLogger(EditBook.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                dispose();
            }
        });
        add(updateButton);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void populateDropdown() {
        // Filling the dropdown with row numbers (assuming titles are in column 0)
        for (int i = 0; i < tableModel.getRowCount(); i++) {
            selectRowDropdown.addItem(tableModel.getValueAt(i, 0).toString());
        }
    }

    public void editBookRow(int row, String titleToEdit, String newAuthor, int newYear, int newCost, DefaultTableModel tableModel) {
                tableModel.setValueAt("1", row, 0);

        tableModel.setValueAt(titleToEdit, row, 1);
        tableModel.setValueAt(newAuthor, row, 2);
        tableModel.setValueAt(newYear, row, 3);
        tableModel.setValueAt(newCost, row, 4);

        JOptionPane.showMessageDialog(null, "Book updated successfully.");
    }

    
}
