package gui;
import com.mycompany.assignment3.Book;
import com.mycompany.assignment3.EditBookinFile;
import com.mycompany.assignment3.fileReadWrite;
import gui.TextArea;
import java.awt.Component;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.io.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.EventObject;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
 
public class JButtonRenderer_Read extends AbstractCellEditor implements TableCellEditor, TableCellRenderer {
JFrame frame;
         public JButtonRenderer_Read(JFrame f) {
            frame=f;
        }

        @Override
        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            JButton b = new JButton("Read");
            return b;
        }
 JFrame newframe=frame; 
                                 Book newbook=new Book();
        @Override
        public Component getTableCellEditorComponent(JTable table, Object value, boolean isSelected, final int row, int column) {
            JButton b = new JButton("Read");
            

            b.addActionListener(new java.awt.event.ActionListener() {
                 @Override
                public void actionPerformed(ActionEvent e) {
                     String title = table.getValueAt(row, 1).toString();
                     String au = table.getValueAt(row, 2).toString();
                     String ear = table.getValueAt(row, 3).toString();
                                          String cos = table.getValueAt(row, 4).toString();

                    try {
                        //System.out.println(" title "+title);
                        TextArea a=    new TextArea(frame);
                        //frame.setVisible(false);
                        a.getBack(title);
                    int o=EditBookinFile. getPopularCount(title,au);
                    System.out.println("poppouler"+o);
                     newbook.setAuthor(au);
                    newbook.setCost(Integer.parseInt(cos));
                    newbook.setPopularityCount(o);
                    newbook.setYear(Integer.parseInt(ear));
                    newbook.setTitle(title);
                    o=o+1;
                      EditBookinFile.EditPopularityCount(o, newbook  );
 
                     }
                     catch (IOException ex) {
                        Logger.getLogger(JButtonRenderer_Read.class.getName()).log(Level.SEVERE, null, ex);
                    }
                      table.clearSelection();
     
                }
            });
           table.revalidate();
table.repaint();
if (frame != null) {
        frame.requestFocus();  
    }

            return b;
        }

         

        @Override
        public boolean isCellEditable(EventObject anEvent) {
            return true;
        }

        @Override
        public boolean shouldSelectCell(EventObject anEvent) {
            return true;
        }

    @Override
    public Object getCellEditorValue() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    }