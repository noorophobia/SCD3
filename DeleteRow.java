 
package gui;

import com.mycompany.assignment3.Book;
import com.mycompany.assignment3.EditBookinFile;
import com.mycompany.assignment3.fileReadWrite;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
 
public class DeleteRow extends JFrame {
     

     private JTextField titleField, authorField, yearField, costField;
    private JTable bookTable;
    private DefaultTableModel tableModel;
    private JComboBox<String> selectRowDropdown;

    public DeleteRow(JTable bookTable, DefaultTableModel tableModel) {
        this.bookTable = bookTable;
        this.tableModel = tableModel;

        setTitle("Edit Book");
        setLayout(new GridLayout(6, 2));

        JLabel selectLabel = new JLabel("Select Row: ");
        selectRowDropdown = new JComboBox<>();
        populateDropdown();  
 
        JButton updateButton = new JButton("Update");

        add(selectLabel);
        add(selectRowDropdown);
        
       
       

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int selectedRow = selectRowDropdown.getSelectedIndex();
             if (selectedRow != -1) {
                tableModel.removeRow(selectedRow);
            
             Book book=new Book();
 
              String title = tableModel.getValueAt(selectedRow, 1).toString();
                     String au = tableModel.getValueAt(selectedRow, 2).toString();
                     String ear = tableModel.getValueAt(selectedRow, 3).toString();
                                          String cos = tableModel.getValueAt(selectedRow, 4).toString();
                                 int o = 0;
                    try {
                        o = EditBookinFile. getPopularCount(title,au);
                    } catch (IOException ex) {
                        Logger.getLogger(DeleteRow.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    int e2=Integer.parseInt(ear);
                    int e3=Integer.parseInt(cos);
                    
                  book.setPopularityCount(o);
                  book.setAuthor(au);
                  book.setCost(e3 );
                  book.setTitle(title);
                  book.setYear(e2 );
            fileReadWrite.deleteBook(book) ;
                dispose();
            }}
        });
        add(updateButton);

        pack();
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setVisible(true);
    }

    private void populateDropdown() {
         for (int i = 0; i < tableModel.getRowCount(); i++) {
            selectRowDropdown.addItem(tableModel.getValueAt(i, 0).toString());
        }
    }

   
    
}
