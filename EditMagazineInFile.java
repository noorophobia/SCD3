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
public class EditMagazineInFile {
	static void EditAuthor(String newauthor, Magazine mag, int authornumber) throws IOException {
	    String author = " ";
	    List<String> authors = mag.getAuthors();
        int s = authors.size();
        String newline = "";
boolean check=false;
	    if (!authors.isEmpty()) {
	    	if(s==1) {
		        author = authors.get(0) + '.';
                System.out.println("file has .1"+author);
                if(authornumber==1) {
                	newline=newauthor+".";
                	check=true;
                }
                else{
                    System.out.println(authornumber+" does not exist");

                }

	    	}
	    	else {
 	        author = authors.get(0) + ',';

	        for (int i = 1; i < s; i++) {
	            if (i == s - 1) {
	                author = author + authors.get(i) + '.';
	            } else {
	                author = author + authors.get(i) + ',';
	            }
	        }

	        if (authornumber >= 1 && authornumber <= s) {
               //  System.out.println("file has ."+authornumber);

	            authornumber = authornumber - 1;
               // System.out.println("file has ."+authornumber);

 	            for (int i = 0; i < s; i++) {
	                if (authornumber == i) {
	                	if(i!=s-1) {
 	                    newline = newline + newauthor+',' ;
 	                }    else if(i==s-1) {
 	                    newline = newline + newauthor+'.' ;

 	                }}
	                	else {
 	                	if(i!=s-1) {
 		                    newline = newline + authors.get(i)+',';
	 	                }    else if(i==s-1) {
		                    newline = newline + authors.get(i)+'.';

	 	                }}
	                    
	                
	            }}
	    	}
	     
	    	 //newline=newline+'.';
	    		String lineToEdit = "2," + mag.getTitle() + "," + author + "," + mag.getPublisher() + "," +mag.getPopularityCount()+","+ mag.getCost() ;

	            StringBuilder modifiedContent = new StringBuilder();
	            File file = new File("books.txt");
               System.out.println("newline "+newline);

	            if (file.isFile()) {
	                BufferedReader reader = new BufferedReader(new FileReader(file));
	                String line;

	                while ((line = reader.readLine()) != null) {
 
	                    if (line.equals(lineToEdit)) {
	                        // Replace the author in the line
		                    System.out.println("line found equal   has "+line);

	    	                System.out.println("line found  has "+lineToEdit);

	                        line = line.replaceAll(author, newline);
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
	        } else {
	            System.out.println("Invalid author number. Please select a valid author to edit.");
	        }
	    }
	static  List<String>  deleteAuthor(int authorNumber, Magazine mag) throws IOException {
	    List<String> authors = mag.getAuthors();
	    int s = authors.size();

	    if(authorNumber==1) {
	    	System.out.println("Can not delete author 1 ");
	    	return null;
	    }
	    else {
	        // Create a new author string with the updated list of authors
	        String oldauthor ="";
	        for (int i = 0; i < authors.size(); i++) {
	            if (i == authors.size() - 1) {
	            	oldauthor=oldauthor+(authors.get(i))+'.';
	            } else {
	            	oldauthor=oldauthor+(authors.get(i))+',';
	            }
	        }
	        
	        
	        authors = mag.getAuthors();
		      s = authors.size();
		      if (authorNumber >= 1 && authorNumber <= s) {
			        authorNumber--; // Adjust the index to match the list index (0-based)

			        authors.remove(authorNumber); // Remove the author from the list

		      String newauthor ="";
		        for (int i = 0; i < authors.size(); i++) {
		            if (i == authors.size() - 1) {
		            	newauthor=newauthor+(authors.get(i))+'.';
		            } else {
		            	newauthor=newauthor+(authors.get(i))+',';
		            }
		        }
		        
	        // Update the author string in the file
 	        String lineToEdit = "2," + mag.getTitle() + "," + oldauthor + "," + mag.getPublisher() + "," + mag.getPopularityCount() + "," + mag.getCost();

	        StringBuilder modifiedContent = new StringBuilder();
	        File file = new File("books.txt");
	         

	        if (file.isFile()) {
	            BufferedReader reader = new BufferedReader(new FileReader(file));
	            String line;

	            while ((line = reader.readLine()) != null) {
	                if (line.equals(lineToEdit)) {
	                    // Replace the author string in the line
	    	           

	                    line = line.replaceAll(oldauthor, newauthor);
	                }
	                modifiedContent.append(line).append("\n");
	            }
	            reader.close();

	            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	            writer.write(modifiedContent.toString());
	            writer.close();

	            System.out.println("Author has been deleted from the file.");
	        } else {
	            System.out.println("File does not exist.");
	        }
	    } else {
	        System.out.println("Invalid author number. Please select a valid author to delete.");
	    }
	    return authors;
	}
	}

static  List<String>  addAuthor(String addauthor, Magazine mag) throws IOException {
	    List<String> authors = mag.getAuthors();
	    int s = authors.size();

	    
 	        String oldauthor ="";
	        for (int i = 0; i < authors.size(); i++) {
	            if (i == authors.size() - 1) {
	            	oldauthor=oldauthor+(authors.get(i))+'.';
	            } else {
	            	oldauthor=oldauthor+(authors.get(i))+',';
	            }
	        }
	        
	        
	        authors = mag.getAuthors();
		      s = authors.size();
		       
		      String newauthor ="";
		        for (int i = 0; i < authors.size(); i++) {
		            if (i == authors.size() - 1) {
		            	newauthor=newauthor+(authors.get(i))+',';
		            } else {
		            	newauthor=newauthor+(authors.get(i))+',';
		            }
		        }
		        newauthor=newauthor+addauthor+'.';
	        // Update the author string in the file
 	        String lineToEdit = "2," + mag.getTitle() + "," + oldauthor + "," + mag.getPublisher() + "," + mag.getPopularityCount() + "," + mag.getCost();

	        StringBuilder modifiedContent = new StringBuilder();
	        File file = new File("books.txt");
	         

	        if (file.isFile()) {
	            BufferedReader reader = new BufferedReader(new FileReader(file));
	            String line;

	            while ((line = reader.readLine()) != null) {
	                if (line.equals(lineToEdit)) {
	                    // Replace the author string in the line
	    	           

	                    line = line.replaceAll(oldauthor, newauthor);
	                }
	                modifiedContent.append(line).append("\n");
	            }
	            reader.close();

	            BufferedWriter writer = new BufferedWriter(new FileWriter(file));
	            writer.write(modifiedContent.toString());
	            writer.close();

	            System.out.println("Author has been Added in the file.");
	            authors.add(addauthor);
	        }
	        else {
	            System.out.println("File does not exist.");
	        }
	      
	    return authors;
	}
	

	static void EditTitle(String newtitle, Magazine  mag) throws IOException {
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
		String lineToEdit = "2," + mag.getTitle() + "," + author + "," + mag.getPublisher() + "," +mag.getPopularityCount()+","+ mag.getCost() ;

	    StringBuilder modifiedContent = new StringBuilder();
	    File file = new File("books.txt");

	    if (file.isFile()) {
	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        String line;

	        while ((line = reader.readLine()) != null) {
	            if (line.equals(lineToEdit)) {
	                // Replace the author in the line
	                line = line.replaceAll(mag.getTitle(), newtitle);
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
	
	
	static void EditPublisher(String publisher, Magazine  mag) throws IOException {
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
	}
		String lineToEdit = "2," + mag.getTitle() + "," + author + "," + mag.getPublisher() + "," +mag.getPopularityCount()+","+ mag.getCost() ;

	    StringBuilder modifiedContent = new StringBuilder();
	    File file = new File("books.txt");

	    if (file.isFile()) {
	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        String line;

	        while ((line = reader.readLine()) != null) {
	            if (line.equals(lineToEdit)) {
	                // Replace the author in the line
	                line = line.replaceAll(mag.getPublisher(), publisher);
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
	 
	static void EditCost(double cost, Magazine mag) throws IOException {
		
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
	}
		String lineToEdit = "2," + mag.getTitle() + "," + author + "," + mag.getPublisher() + "," +mag.getPopularityCount()+","+ mag.getCost() ;

	  
 	    String newcost= Integer.toString((int)cost);
	    String oldcost= Integer.toString((int)mag.getCost());

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
	 
	static void EditPopularityCount(int count, Magazine mag) throws IOException {
		
		
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
	}
		String lineToEdit = "2," + mag.getTitle() + "," + author + "," + mag.getPublisher() + "," +mag.getPopularityCount()+","+ mag.getCost() ;

 	    String newcount= Integer.toString(count);
	    String oldcount= Integer.toString(mag.getPopularityCount());

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
		 
}

 
