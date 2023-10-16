/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment3;

 
 import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
//3, newspaper_title, publisher_company, 1, 20-09-2023
public class EditNewspaperInFile {
	 
  
	 

	static void EditTitle(String newtitle, Newspaper news) throws IOException {
		
 			String lineToEdit = "3," + news.getTitle() + "," + news.getPublisher() + "," +news.getPopularityCount()+","+ news.getCost() + "," + news.getDate() ;

	    StringBuilder modifiedContent = new StringBuilder();
	    File file = new File("books.txt");

	    if (file.isFile()) {
	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        String line;

	        while ((line = reader.readLine()) != null) {
	            if (line.equals(lineToEdit)) {
	                // Replace the author in the line
	                line = line.replaceAll(news.getTitle(), newtitle);
	            }
	            modifiedContent.append(line).append("\n");
	        }
	        reader.close();

	        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	        writer.write(modifiedContent.toString());
	        writer.close();

	        System.out.println("Existing content in the file has been edited.");
	    } else {
	        System.out.println("File does not exist.");
	    }
	}
 
	static void EditCost(double cost, Newspaper news) throws IOException {
			String lineToEdit = "3," + news.getTitle() + "," + news.getPublisher() + "," +news.getPopularityCount()+","+ news.getCost() + "," + news.getDate() ;
	    String newcost= Integer.toString((int)cost);
	    String oldcost= Integer.toString((int)news.getCost());

	    StringBuilder modifiedContent = new StringBuilder();
	    File file = new File("books.txt");
   
	    if (file.isFile()) {
	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        String line;

	        while ((line = reader.readLine()) != null) {
	            if (line.equals(lineToEdit)) {
	                // Replace the author in the line
	                line = line.replaceAll(oldcost, newcost);
	            }
	            modifiedContent.append(line).append("\n");
	        }
	        reader.close();

	        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	        writer.write(modifiedContent.toString());
	        writer.close();

	        System.out.println("Existing content in the file has been edited.");
	    } else {
	        System.out.println("File does not exist.");
	    }
	}
	static void EditPopularityCount(int count, Newspaper news) throws IOException {
			String lineToEdit = "3," + news.getTitle() + "," + news.getPublisher() + "," +news.getPopularityCount()+","+ news.getCost() + "," + news.getDate() ;
	    String newcount= Integer.toString(count);
	    String oldcount= Integer.toString(news.getPopularityCount());

	    StringBuilder modifiedContent = new StringBuilder();
	    File file = new File("books.txt");
   
	    if (file.isFile()) {
	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        String line;

	        while ((line = reader.readLine()) != null) {
	            if (line.equals(lineToEdit)) {
	                // Replace the author in the line
	                line = line.replaceAll(oldcount, newcount);
	            }
	            modifiedContent.append(line).append("\n");
	        }
	        reader.close();

	        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	        writer.write(modifiedContent.toString());
	        writer.close();

	        System.out.println("Existing content in the file has been edited.");
	    } else {
	        System.out.println("File does not exist.");
	    }
	}
	static void EditDate(String newDate, Newspaper news) throws IOException {
		String lineToEdit = "3," + news.getTitle() + "," + news.getPublisher() + "," +news.getPopularityCount()+","+ news.getCost() + "," + news.getDate() ;
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		String formattedDate = sdf.format(news.getDate());

    StringBuilder modifiedContent = new StringBuilder();
    File file = new File("books.txt");

    if (file.isFile()) {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        String line;

        while ((line = reader.readLine()) != null) {
            if (line.equals(lineToEdit)) {
                // Replace the author in the line
                line = line.replaceAll( formattedDate, newDate);
            }
            modifiedContent.append(line).append("\n");
        }
        reader.close();

        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
        writer.write(modifiedContent.toString());
        writer.close();

        System.out.println("Existing content in the file has been edited.");
    } else {
        System.out.println("File does not exist.");
    }
}
	
	static void EditPublisher(String publisher, Newspaper  news) throws IOException {
		String lineToEdit = "3," + news.getTitle() + "," + news.getPublisher() + "," +news.getPopularityCount()+","+ news.getCost() + "," + news.getDate();

 
	    StringBuilder modifiedContent = new StringBuilder();
	    File file = new File("books.txt");

	    if (file.isFile()) {
	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        String line;

	        while ((line = reader.readLine()) != null) {
	            if (line.equals(lineToEdit)) {
	                // Replace the author in the line
	                line = line.replaceAll(news.getPublisher(), publisher);
	            }
	            modifiedContent.append(line).append("\n");
	        }
	        reader.close();

	        BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	        writer.write(modifiedContent.toString());
	        writer.close();

	        System.out.println("Existing content in the file has been edited.");
	    } else {
	        System.out.println("File does not exist.");
	    }
	}
	 
		 
}
