 
package gui;
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
import javax.swing.table.TableCellEditor;
import javax.swing.table.TableCellRenderer;
 
public class TextArea implements WindowListener {
    JFrame frame1;
 public TextArea(JFrame j){
 frame1=j;
 frame1.setVisible(false);
 }
      int reply=JOptionPane.NO_OPTION;
      JFrame frame;
 void getBack(String title) throws IOException{
      title = title + ".txt";
        File f = new File(title);
        if (!f.exists()) {
            f.createNewFile();
        }

        Path p = Path.of(title);
        String allLines = Files.readString(p);
        if (allLines == null) {
            allLines = "File is empty";
        }

          frame = new JFrame("JScrollPane Scrolling Example");
        frame.setSize(400, 300);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // Handle window closing manually

        JTextArea textArea = new JTextArea(10, 40);
        textArea.setLineWrap(true);
        textArea.setText(allLines);
textArea.setSelectionStart(0);
textArea.setSelectionEnd(0);
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);

        frame.add(scrollPane);
        frame.setVisible(true);
frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                // Show a confirmation dialog when the window is closing
                int result = JOptionPane.showConfirmDialog(frame, "Are you sure you want to exit?", "Confirmation", JOptionPane.YES_NO_OPTION);
                if (result == JOptionPane.YES_OPTION) {
                    reply=result;
                    System.out.println("inside getBack " + result);
                    frame.setVisible(false);
                    frame.dispose(); // Close the window if the user confirms
                    frame1.setVisible(true);
                 }
            }
        });

        // Return the result of the confirmation dialog
        
 }
    JFrame getframe(){
        return frame;}
   
    @Override
    public void windowOpened(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowClosing(WindowEvent e) {
   reply = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit", "b", JOptionPane.YES_NO_OPTION);
     
     }

    @Override
    public void windowClosed(WindowEvent e) {
 
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowIconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowActivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

  






    
 