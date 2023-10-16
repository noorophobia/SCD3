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
	      	  
  

		    // Check if there are enough tokens to create a Book object
 		    if (st.countTokens() >= 4) {
 		   	      try {

 		    	 st.nextToken();
		        String title = st.nextToken();
	  	 ///         System.out.println(" " + s);

//	 	      	 System.out.print( "title  "+title);

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
  	static Magazine getMagazineFromString(String s) {
  	    StringTokenizer st = new StringTokenizer(s, ",");
           // System.out.println("Publisher: " + s);

  	    // Check if there are enough tokens to create a Magazine object
  	    if (st.countTokens() >=4) { // You expect 6 tokens
  	        try {
  	            st.nextToken(); // Skip the first token
  	            String title = st.nextToken();
 
  	            List<String> authors = new ArrayList<>();
  	            String author = st.nextToken();
  	            if(author.endsWith(".")) {
  	            	author = author.replace(Character.toString('.'), "");
  	       	      authors.add(author);
  	  	         //  System.out.println("Author: " + author);

  	            }
  	            else {

   	        while (!author.endsWith(".") && st.hasMoreTokens()) {
  	            authors.add(author);
  	       //    System.out.println("Author: " + author);
  	            author = st.nextToken();
  	            
  	        }
          	author = author.replace(Character.toString('.'), "");

     	      authors.add(author);
}
   	        
 
  	            String publisher = st.nextToken();
  	          //  System.out.println("Publisher: " + publisher);

  	            int popularityCount = Integer.parseInt(st.nextToken());
  	            int cost = Integer.parseInt(st.nextToken());
  	         ////   System.out.println("Popularity Count: " + popularityCount);
  	           // System.out.println("Cost: " + cost);

  	            // Create a new Magazine object
  	            Magazine mag = new Magazine();
  	            mag.setTitle(title);
  	            mag.setAuthors(authors);
  	            mag.setPublisher(publisher);
  	            mag.setPopularityCount(popularityCount);
  	            mag.setCost(cost);

  	            return mag;

  	        } catch (NumberFormatException e) {
  	            System.out.println("Error parsing integers in the line: " + s);
  	        }
  	    }

  	    return null; // Return null if there are not enough tokens or an error occurs
  	}

 
	static Newspaper getNewspaperFromString(String s) {
		  StringTokenizer st = new StringTokenizer(s, ",");

	  	    // Check if there are enough tokens to create a Magazine object
	  	    if (st.countTokens() >= 6) { // You expect 6 tokens
	  	        try {
	  	            st.nextToken(); // Skip the first token
	  	            String title = st.nextToken();
	  	      //      System.out.println("Title: " + title);

	  	          String publisher   = st.nextToken();
		           
		          
	  		       
	  	        int popularityCount = Integer.parseInt(st.nextToken());
	  	        int cost = Integer.parseInt(st.nextToken());

	  	        // Create a new Book object
	  	        Newspaper news = new Newspaper();
	  	        news.setTitle(title);
	  	        news.setPublisher(publisher);
	  	        news.setPopularityCount(popularityCount);
	  	        news.setCost(cost);

	  	            return news;

	  	        } catch (NumberFormatException e) {
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

	static void addMagazine(Magazine b) throws IOException {
		String author = " ";
		List<String> authors = b.getAuthors();

		if (!authors.isEmpty()) {
			int s = b.getAuthors().size();
			author = authors.get(0) + ',';

			for (int i = 1; i < s; i++) {

				if (i == s - 1) {
					author = author + authors.get(i) + '.';

				} else {
					author = author + authors.get(i) + ',';
				}
			}

			String line = "2," + b.getTitle() + "," + author + "," + b.getPublisher() + ",0," + b.getCost() + "\n";
			File file = new File("books.txt");

			// 2, magazine_title, author1_name, author2_name, author3_name.,
			// publisher_company, 10, 500 if(!file.exists()){
			file.createNewFile();

			FileWriter fWriter = new FileWriter(file, true);

			BufferedWriter w = new BufferedWriter(fWriter);

			w.write(line);

			w.close();
		}

	}

	static void addNewspaper(Newspaper b) throws IOException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		String formattedDate = sdf.format(b.getDate());
		String line = "3," + b.getTitle() + "," + b.getPublisher() + ",0," + b.getCost() + "," + formattedDate + "\n";
		File file = new File("books.txt");
		file.createNewFile();

		FileWriter fWriter = new FileWriter(file, true);

		BufferedWriter w = new BufferedWriter(fWriter);

		w.write(line);

		w.close();

	}
	public static List<Item> readItems() throws IOException {
	    List<Item> items = new ArrayList<>();

	    File file = new File("books.txt");

	    if (file.isFile()) {
	        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
	            String s;
	            int countofItem = 0;
	            while ((s = br.readLine()) != null) {
	                countofItem++;
	                if (s.charAt(0) == '1') {
	                    Book book = getBookFromString(s);

	                    if (book != null) {
	                        Book newbook = new Book(book.getTitle(), false, book.getPopularityCount(), book.getCost(), book.getAuthor(), book.getYear());
 	                        items.add(newbook);
	                    } else {
	                        System.out.println("Error parsing book data at line " + countofItem);
	                    }
	                }
	                else if (s.charAt(0) == '2') {
	                    Magazine mag = getMagazineFromString(s);
 	                  /*  if(mag==null) {
 		                    System.out.println(" mag is null" );

	                    }*/
                   //    mag.displayInfo();
	                    
	                    if (mag != null) {
	                        Magazine newmag = new Magazine(mag.getTitle(), false, mag.getPopularityCount(), mag.getCost(), mag.getAuthors(), mag.getPublisher());
	                       // newmag.displayInfo();
 	                        items.add(newmag);
 	                      //  mag.displayInfo();
	                     //   System.out.println("item " + countofItem);

 	                     //  items.get(countofItem-1).displayInfo();
	                    } else {
	                        System.out.println("Error parsing magazine data at line " + countofItem);
	                    }
	                } 
	                else if (s.charAt(0) == '3') {
	                    Newspaper news = getNewspaperFromString(s);

	                    if (news != null) {
	                        Newspaper newnews = new Newspaper(news.getTitle(), false, news.getPopularityCount(), news.getCost(), news.getPublisher(), news.getDate());
 	                        items.add(newnews);
	                    } else {
	                        System.out.println("Error parsing newspaper data at line " + countofItem);
	                    }
	                } else {
	                    System.out.println("Error reading 1 item at " + countofItem);
	                }
	            }
	        }
        /*    System.out.println("all");

	        for(int i=0 ;i<items.size();i++) {
	        	items.get(i).displayInfo();
	        }*/
	    } else {
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
	static void deleteMagazine(Magazine mag) {
		String author = " ";
		List<String> authors = mag.getAuthors();

		if (!authors.isEmpty()) {
			int s = mag.getAuthors().size();
			author = authors.get(0) + ',';

			for (int i = 1; i < s; i++) {

				if (i == s - 1) {
					author = author + authors.get(i) + '.';

				} else {
					author = author + authors.get(i) + ',';
				}
			}

			String lineToDelete = "2," + mag.getTitle() + "," + author + "," + mag.getPublisher() + "," +mag.getPopularityCount()+","+ mag.getCost() ;
 
	    System.out.println("line o dele "+lineToDelete);

	    try {
	        String filePath = "books.txt";
	        File inputFile = new File(filePath);
	        File tempFile = new File("tempFile.txt");

	        BufferedReader reader = new BufferedReader(new FileReader(inputFile));
	        BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));

	        String currentLine;

	        while ((currentLine = reader.readLine()) != null) {
	    	    System.out.println("ururru  "+currentLine);

	            if (currentLine.equals(lineToDelete)) {
	                // Skip the line you want to delete
		    	    System.out.println("ururru  "+lineToDelete);

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
	}}
		
		static void deleteNewspaper(Newspaper news) {
 			String lineToDelete = "3," + news.getTitle() + "," + news.getPublisher() + "," +news.getPopularityCount()+","+ news.getCost() + "," + news.getDate();

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
