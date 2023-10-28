 
package com.mycompany.assignment3;

 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
 
public class EditBookinFile {
                     		//Book book = new Book(title, false, 0, cost, author, year);
    public static void RenameFile(String newtitle,String oldtitle){
        try {
            // Copy the source file to the destination file
            Path sourcePath = Paths.get(oldtitle+".txt");
            Path destinationPath = Paths.get(newtitle+".txt");

            // StandardCopyOption.REPLACE_EXISTING is used to replace the destination file if it already exists
            Files.copy(sourcePath, destinationPath, StandardCopyOption.REPLACE_EXISTING);

            // Delete the original source file
            Files.delete(sourcePath);

            System.out.println("File copied and original file deleted successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        
    }
	public static void Edit( String line1, String lineToEdit) throws IOException {
                 System.out.println("  ."+line1 );
                 System.out.println("  ."+lineToEdit );
             String token[]=line1.split(",");
             String token2[]=lineToEdit.split(",");
             if(token[0]!=token2[0]){
                RenameFile(token[0],token2[0]); 
             }
         File file = new File("books.txt");
        StringBuilder modifiedContent = new StringBuilder();

        try {
            if (file.exists()) {
                BufferedReader reader = new BufferedReader(new FileReader(file));
                String line;

                while ((line = reader.readLine()) != null) {
                    if (line.equals(lineToEdit)) {
                        // Replace the line with the new line
                        modifiedContent.append(line1).append("\n");
                    } else {
                        modifiedContent.append(line).append("\n");
                    }
                }
                reader.close();

                BufferedWriter writer = new BufferedWriter(new FileWriter(file));
                writer.write(modifiedContent.toString());
                writer.close();

                System.out.println("File content has been edited.");
            } else {
                System.out.println("File does not exist.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
	 

    	 
	static void EditAuthor(String author, Book book) throws IOException {
	    String lineToEdit =  book.getTitle() + "," + book.getAuthor() + "," + book.getYear() + "," + book.getPopularityCount() + "," + book.getCost() ;

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
	    String lineToEdit =  book.getTitle() + "," + book.getAuthor() + "," + book.getYear() + "," + book.getPopularityCount() + "," + book.getCost() ;

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
	    String lineToEdit = book.getTitle() + "," + book.getAuthor() + "," + book.getYear() + "," + book.getPopularityCount() + "," + book.getCost() ;
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
	    String lineToEdit =  book.getTitle() + "," + book.getAuthor() + "," + book.getYear() + "," + book.getPopularityCount() + "," + book.getCost();
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
        
        public static int getPopularCount(String title,String author) throws FileNotFoundException, IOException{
             String lineToEdit =  title + "," + author ;
             File file = new File("books.txt");
	             String tokens[];

             int popularcount=0;
              if (file.isFile()) {
	        BufferedReader reader = new BufferedReader(new FileReader(file));
	        String line;
 
	        while ((line = reader.readLine()) != null) {
 
	            if (line.contains(lineToEdit)) {
  
	               tokens=line.split(",");
                 popularcount=Integer.parseInt(tokens[3]);
 	            }
         }}  return popularcount;
}
	public static void EditPopularityCount(int count, Book book) throws IOException {
	    String lineToEdit =  book.getTitle() + "," + book.getAuthor() + "," + book.getYear() + "," + book.getPopularityCount() + "," + book.getCost();
	    
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
