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
public class EditBookinFile {
	static void EditAuthor(String author, Book book) throws IOException {
	    String lineToEdit = "1," + book.getTitle() + "," + book.getAuthor() + "," + book.getYear() + "," + book.getPopularityCount() + "," + book.getCost() ;

	    StringBuilder modifiedContent = new StringBuilder();
	    File file = new File("books.txt");

	    if (file.isFile()) {
	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        String line;

	        while ((line = reader.readLine()) != null) {
	            if (line.equals(lineToEdit)) {
	                // Replace the author in the line
	                line = line.replaceAll(book.getAuthor(), author);
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

	static void EditTitle(String newtitle, Book book) throws IOException {
	    String lineToEdit = "1," + book.getTitle() + "," + book.getAuthor() + "," + book.getYear() + "," + book.getPopularityCount() + "," + book.getCost() ;

	    StringBuilder modifiedContent = new StringBuilder();
	    File file = new File("books.txt");

	    if (file.isFile()) {
	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        String line;

	        while ((line = reader.readLine()) != null) {
	            if (line.equals(lineToEdit)) {
	                // Replace the author in the line
	                line = line.replaceAll(book.getTitle(), newtitle);
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
	static void EditYear(int year, Book book) throws IOException {
	    String lineToEdit = "1," + book.getTitle() + "," + book.getAuthor() + "," + book.getYear() + "," + book.getPopularityCount() + "," + book.getCost() ;
	    String newyear= Integer.toString(year);
	    String oldyear= Integer.toString(book.getYear());

	    StringBuilder modifiedContent = new StringBuilder();
	    File file = new File("books.txt");
   
	    if (file.isFile()) {
	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        String line;

	        while ((line = reader.readLine()) != null) {
	            if (line.equals(lineToEdit)) {
	                // Replace the author in the line
	                line = line.replaceAll(oldyear, newyear);
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
	static void EditCost(double cost, Book book) throws IOException {
	    String lineToEdit = "1," + book.getTitle() + "," + book.getAuthor() + "," + book.getYear() + "," + book.getPopularityCount() + "," + book.getCost();
	    String newcost= Integer.toString((int) cost);
	    String oldcost= Integer.toString((int)book.getCost());

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
	static void EditPopularityCount(int count, Book book) throws IOException {
	    String lineToEdit = "1," + book.getTitle() + "," + book.getAuthor() + "," + book.getYear() + "," + book.getPopularityCount() + "," + book.getCost();
	    
	    String newcount= Integer.toString(count);
	    String oldcount= Integer.toString(book.getPopularityCount());

	    StringBuilder modifiedContent = new StringBuilder();
	    File file = new File("books.txt");
   
	    if (file.isFile()) {
	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        String line;
    		System.out.println("line edi : "+lineToEdit);

	        while ((line = reader.readLine()) != null) {
 
	            if (line.equals(lineToEdit)) {
	                // Replace the author in the line
	        		System.out.println("line : "+line);

	        		System.out.println("line einside di : "+lineToEdit);
	        		System.out.println("coun old  : "+oldcount );
	        		System.out.println("new old  : "+newcount );

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
		 
}
