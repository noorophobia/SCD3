/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package gui;
  import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import javax.swing.JPanel;

import javax.swing.JPanel;

import java.awt.Graphics;

import javax.swing.JFrame;

public class Graph extends  JPanel {
    private Integer[] values;
    private String[] names;
       public     JFrame frame ;
 
     public Graph(Integer[] values, String[] names,JFrame j) {
        this.values = values;
        this.names = names;
 frame = j;
 j.setVisible(false);
 
      JFrame newframe=new JFrame();
   newframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

         
     //   chart.setBackground(Color.decode("#77B686"));
         setBorder(BorderFactory.createLineBorder(Color.black, 4)); // Set border for the chart
         setPreferredSize(new Dimension(400, 300));

        JPanel chartPanel = new JPanel();
        chartPanel.setLayout(new BoxLayout(chartPanel, BoxLayout.Y_AXIS));
        chartPanel.add(this);

  
        JLabel label = new JLabel("Popularity Count", SwingConstants.CENTER);
         chartPanel.add(label);
         label.setSize(200, 200);
label.setAlignmentX(Component.CENTER_ALIGNMENT); // Align the label to the center

        JButton button = new JButton("Back");
        
         button.addActionListener(new java.awt.event.ActionListener() {
                 @Override
                public void actionPerformed(ActionEvent e) {
              
                    newframe.dispose();
                    frame.setVisible(true);
                  }
            });
        
        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        chartPanel.add(button);
      
         newframe.add(chartPanel);
        newframe.pack();
        newframe.setVisible(true);}

 
 
  

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        drawBarChart(g);
    }
     private void drawBarChart(Graphics g) {
        int barWidth = 40;
        int barSpace = 10;
        int initialX = 50;
        int height = getHeight()-10;
        int maxValue = 0;

        // Find the maximum value in the array
        for (int value : values) {
            if (value > maxValue) {
                maxValue = value;
            }
        }

        int x = initialX;
        int l = values.length;
                Arrays.sort(values, Comparator.reverseOrder());
              //  Arrays.sort(values, Comparator.reverseOrder());
  
              int j1 = 0;
        Integer[] valuesOfAxis = new Integer[l];
        for (int i = 0; i < values.length; i++) {
            int barHeight = (int) ((double) values[i] / maxValue * (height - 50));
           
             g.fillRect(x, height - barHeight, barWidth, barHeight - 15);
            g.setColor(Color.decode("#0B4619"));
            g.drawRect(x, height - barHeight, barWidth, barHeight - 15);
            valuesOfAxis[i] = height - barHeight;
            System.out.println(values[i]);
            System.out.print(" "+valuesOfAxis[i]);
            g.drawString(names[i], x + barWidth / 2 - 18, height - 5);
j1=height - 5;
            x += barWidth + barSpace;
        }

          
  
        int rightAlign = getWidth() - maxValue - 10; // Aligning on the right side
        int j = 0;//valuesOfAxis.length-1;
        for (int value : values) {
            g.drawString(String.valueOf(value), rightAlign+5, valuesOfAxis[j]);
                    g.drawLine(rightAlign, valuesOfAxis[j], rightAlign+5, valuesOfAxis[j]);

            j++;
        }
        g.drawLine(rightAlign, 20, rightAlign, j1-10);
        g.drawLine(initialX-10,  height-15, rightAlign, j1-10);
                          //  g.drawLine(rightAlign, height, rightAlign+5, valuesOfAxis[j]);


    }
}
