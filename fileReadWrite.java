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
 
public class fileReadWrite {

  	static Book getBookFromString(String s) {
		    StringTokenizer st = new StringTokenizer(s,",");
	      	  
  

  		    if (st.countTokens() >= 4) {
 		   	      try {

 		        String title = st.nextToken();
 
		        String author = st.nextToken();
		        int year = Integer.parseInt(st.nextToken());
		        int popularityCount = Integer.parseInt(st.nextToken());
		        int cost = Integer.parseInt(st.nextToken());

		        // Create a new Book object
		        Book newBook = new Book();
 		        newBook.setTitle(title);
		        newBook.setAuthor(author);
		        newBook.setYear(year);
		        newBook.setPopularityCount(popularityCount);
		        newBook.setCost(cost);

		        return newBook;
		    }
 		    catch (NumberFormatException e) {
	  	          System.out.println("Error parsing integers in the line: " + s);
	  	      }
 		    }
 		    
 		   
			return null;
		}
  	 
	public static void addBook(Book newitem) throws IOException {

		String line = "1," + newitem.getTitle() + "," + newitem.getAuthor() + "," + newitem.getYear() + ",0," + newitem.getCost() + "\n";
		File file = new File("books.txt");
		// 1, book_title, author_name, 1950, 3, 200
		if (!file.exists()) {
			file.createNewFile();
		}
		FileWriter fWriter = new FileWriter(file, true);

		BufferedWriter w = new BufferedWriter(fWriter);

		w.write(line);

		// System.out.println(text);

		w.close();

	}
 
	public static List<Item> readItems() throws IOException {
	    List<Item> items = new ArrayList<>();
  System.out.println("lis");
	    File file = new File("books.txt");
  System.out.println("file");
	    if (file.isFile()) {
	        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	            String s;
	            int countofItem = 0;
	            while ((s = br.readLine()) != null) {
                          System.out.println("reading");
	                countofItem++;
 	                    Book book = getBookFromString(s);

	                    if (book != null) {
	                        Book newbook = new Book(book.getTitle(), false, book.getPopularityCount(), book.getCost(), book.getAuthor(), book.getYear());
 	                        items.add(newbook);
	                    } else {
	                        System.out.println("Error parsing book data at line " + countofItem);
	                    }
	                }
	            	        System.out.println(countofItem);

                        
                       
	            }
	        }
         else {
	        System.out.println("File does not exist");
	    }

	    System.out.println("Loaded items from file books.txt");

	    return items;
	}
	static void deleteBook(Book book) {
	    String lineToDelete = "1," + book.getTitle() + "," + book.getAuthor() + "," + book.getYear() + "," + book.getPopularityCount() + "," + book.getCost() ;

	    System.out.println(lineToDelete);

	    try {
	        String filePath = "books.txt";
	        File inputFile = new File(filePath);
	        File tempFile = new File("tempFile.txt");

	        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

	        String currentLine;

	        while ((currentLine = reader.readLine()) != null) {
	            if (currentLine.equals(lineToDelete)) {
	                // Skip the line you want to delete
	                continue;
	            }

	            writer.write(currentLine);
	            writer.newLine(); // Add a newline after each line
	        }

	        writer.close();
	        reader.close();

	        // Delete the original file
	        if (inputFile.delete()) {
	            // Rename the temporary file to the original file name
	            if (tempFile.renameTo(inputFile)) {
	                System.out.println("Line deleted successfully.");
	            } else {
	                System.out.println("Error renaming the temporary file.");
	            }
	        } else {
	            System.out.println("Error deleting the original file.");
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	}
	 
}