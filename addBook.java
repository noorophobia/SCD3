/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;

import com.mycompany.assignment3.Book;
import com.mycompany.assignment3.fileReadWrite;
 import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
 
public class addBook extends JFrame {
  
   private JTextField titleField, authorField, yearField, costField;
  
    public addBook(  DefaultTableModel model) {
        setTitle("Add New Book Entry");
        setLayout(new GridLayout(5, 2));

        JLabel titleLabel = new JLabel("Title: ");
        titleField = new JTextField(20);

        JLabel authorLabel = new JLabel("Author: ");
        authorField = new JTextField(20);

        JLabel yearLabel = new JLabel("Year: ");
        yearField = new JTextField(20);

        JLabel costLabel = new JLabel("Cost: ");
        costField = new JTextField(20);

        JButton addButton = new JButton("Add Book");

        add(titleLabel);
        add(titleField);
        add(authorLabel);
        add(authorField);
        add(yearLabel);
        add(yearField);
        add(costLabel);
        add(costField);
        add(addButton);

        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String title = titleField.getText();
                    String author = authorField.getText();
                    int year = Integer.parseInt(yearField.getText());
                    int cost = Integer.parseInt(costField.getText());

                    Book newBook = new Book(title, false, 0, cost, author, year);
                            Object[] row = {newBook.getID(),title, author, year };
          model.addRow(row);
                   fileReadWrite.addBook(newBook);
                    JOptionPane.showMessageDialog(null, "Book added successfully to books.txt!");
                    dispose(); // Close the JFrame after adding the book
                } catch (NumberFormatException | IOException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid input or error occurred. Please try again.");
                }
            }
        });

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

   
   

}
