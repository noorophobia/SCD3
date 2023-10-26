 

package com.mycompany.assignment3;

  
import gui.JButtonRenderer_Read;
 import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
 
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
 import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;


//Create a new Library class that can store multiple Book objects.
//Implement methods to add, edit, delete books in the library and also display all books in
//the library.
public class Library   implements ActionListener,MouseListener{
	static List<Item> items;
	public static Scanner obj;
 
	public Library() throws IOException {
		items = new ArrayList<>();
 		obj = new Scanner(System.in);
              readItems();    
        
       
        }
 		 
   public void readItems()  throws IOException{
         items=fileReadWrite.readItems();
                  List< List<String>>books=new ArrayList<>();
                                  
JFrame frame=new JFrame();
                 for(int i=0 ;i<items.size();i++) {
			 if (items.get(i) instanceof Book ) {
		            Book newbook= (Book) items.get(i) ;
                            String title=newbook.getTitle();
                            String author=newbook.getAuthor();
                             String ID=Integer.toString(newbook.getID());
                            String Year =Integer.toString(newbook.getYear());
                            List<String>m=new ArrayList<>(); m.add(ID);
                            m.add(title);
                            m.add(author);
                            
                            m.add(Year);
                            books.add(m);
                            
 
		        }}    
       
          DefaultTableModel model=new DefaultTableModel();
          String[] col = {"ID","Title", "Author", "Year","Read Item"};
                   for (String columnName : col) {
                        model.addColumn(columnName);
                                       }
                   for (List<String> bookInfo : books) {
                         model.addRow(bookInfo.toArray());
                         }
                   
                    
         
         //In a JTable, each column can contain data of a different type. For example, one column might contain numbers, another column might contain text, and yet another column might contain dates. To make the table work correctly and display data properly,
         //the table model needs to know the data type (class) of each column.
            DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                      JTable j = new JTable(model);
                          j.setDefaultRenderer(Object.class, centerRenderer);
           // Class<?>[] columnClass = {Integer.class,String.class,String.class, String.class};

   // j.setDefaultRenderer(Object.class, new NewClass());
    
    

        // ... Rest of your existing code ...

    JButtonRenderer_Read compCellDelete = new JButtonRenderer_Read(frame );

j.getColumnModel().getColumn(4).setCellEditor(compCellDelete);
j.getColumnModel().getColumn(4).setCellRenderer(compCellDelete);

   
     
    frame.setLayout(new FlowLayout());
     //  Dimension d=new Dimension(800,800);
     //j.setSize(d);
        
  JScrollPane scrollPane1 = new JScrollPane(j);
 frame.add(scrollPane1);
  
 
   
frame.setSize(1200,1200);
 
JTableHeader header = j.getTableHeader();
        Font boldFont = header.getFont().deriveFont(Font.BOLD);
        header.setFont(boldFont);  
        //header.setBackground(Color.yellow);
       header.setBackground(Color.CYAN);
        
         frame.setVisible(true); 
  
   }
    		  
		 
	   private void openBookDetailsWindow(String bookTitle) {
        JFrame bookDetailsFrame = new JFrame("Book Details");
        // Create and add components to display book information (e.g., JLabels, JTextFields, etc.)

        // Configure the frame properties, layout, and size
        bookDetailsFrame.setLayout(new BorderLayout());
        bookDetailsFrame.setSize(new Dimension(400, 300));
        // Add your components to bookDetailsFrame here

        bookDetailsFrame.setVisible(true);
    }
           
  @Override
                public void actionPerformed(ActionEvent e) {
                

                 }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    }

    @Override
    
    public void mousePressed(MouseEvent e) {
    
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    }

    @Override
    
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    }

    @Override
    
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    }

    @Override
    
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    
    
    }

    public class MyComparator implements Comparator<Item> {
	    

		@Override
	
                public int compare(Item o1, Item o2) {
			if(o1.getPopularityCount()<o2.getPopularityCount()) {
 			return 1;}
			if(o1.getPopularityCount()>o2.getPopularityCount()) {
				return -1;
			}
 				return 0; // if equal 
			
			
		}
	}

	
    public void hotPicks() {

        List<Item> tempitems=new  ArrayList<>(); 
	
        for(int i =0 ; i<items.size();i++) {
	
            tempitems.add(items.get(i));
	
        }
		//  MyComparator n=new MyComparator();
	        Collections.sort(tempitems,new MyComparator());
	        
	
                for(int i =0 ; i<tempitems.size();i++) {
				  tempitems.get(i).displayInfo();
		
                                  System.out.println(" ");

			  }
                
	        

	}
	
	 
	
    
 
    public void changePopularityCount(Item i,int count)throws IOException {
	 
	    if (i instanceof Book ) {
            Book newbook= (Book) i;
             
            EditBookinFile.EditPopularityCount(count, newbook);
            }}
	
    public void addItem() throws IOException {
		System.out.print("Enter 1 to add book , 2 to add Magazine , 3 to add newspaper");
	
                int n = obj.nextInt();
		
                if (n == 1) {
			Book newitem = new Book();
		
                        newitem=newitem.getBook();
			
                        fileReadWrite.addBook(newitem);
			
                        items.add(newitem);

		
                }  	  

		 

	}
	
    public static void displayall() {

        for(int i=0 ;i<items.size();i++) {
			display(items.get(i));
	
                        
		
        }
	}
	
    public static void displayItemWithID(int id) {
		Item item = null;
	
                boolean found=false;
	 		
                if (id >= 0 ) {
	 		
        for(int i=0 ;i <items.size();i++) {
	 		    	if(items.get(i).getID()==id) {
	 			         item = items.get(i);
	          
                                         found=true;
	 	
                        
                                }
	 		    }}
	 		    if(found==true) {
	 		    	 display(item);
	 		
                            }
	 		    else {
					System.out.println("Item with id "+id+" not found  ");

                                        
	 		    }
                            
	}
	
    public static void display(Item i) {

		i.displayInfo();

	
    }
	
    public static void deleteItem(int id) {  
		Item item = null;
	boolean found=false;
 	
        if (id >= 0 ) {
 		
            for(int i=0 ;i <items.size();i++) {

                if( items.get(i).getID()==id) {
 			         item = items.get(i);

                                 items.remove(i);

                                 found=true;
 		    	}
                
 		    }}
 		        if(found==true) {
		        if (item instanceof Book ) {
		            Book newbook= (Book) item;

                            fileReadWrite.deleteBook(newbook);
			
                            System.out.print("Deleted Book with ");

		        }   
                        
		    }  
 		        else {
					System.out.println("Item with id "+id+" not found  ");

                                        
 		        }}
    

    public static void editBook(Book newbook) throws IOException {
		 int x=0;

                 int index=0;

                 for(int i=0;i<items.size();i++) {
			 if(newbook.getID()==items.get(i).getID()) {
				 index=i;

                         }
		 }
				 while(x!=5) {
 					 
				 System.out.println("\n\n Library/Edit Book: ");

                                 System.out.println("1. Edit  title ");
				
                                 System.out.println("2. Edit Author ");
				
                                 System.out.println("3. Edit Published Year ");
 				//	 System.out.println("4. Edit Cost ");
					 System.out.println("4. exit ");
					 System.out.println("Enter your choice");
					 x=obj.nextInt();
					 
					 switch(x) {
					 case 1:
						 
						 
							System.out.println("Enter new Title for the book ");
                         String newtitle=obj.next();
                         
						 EditBookinFile.EditTitle(newtitle, newbook);
						 newbook.setTitle(newtitle);
						 items.set(index, newbook);
						 
						 break;
					 case 2:
						 
						 System.out.println("Enter new Author for the book ");
                         String newauthor=obj.next();
						 EditBookinFile.EditAuthor(newauthor, newbook);
						 break;
					 case 3:
							System.out.println("Enter the new year of publication of the book: ");
							int year = 0;

							boolean validInput = false;

							while (!validInput) {
								System.out.print("Enter an integer: ");
								if (obj.hasNextInt()) {
									year = obj.nextInt();
									if (year > 0) {
										validInput = true;
									}
								} else {
									System.out.println("Invalid input. Please enter an integer.");
									obj.next();
								}
								
							}
							if(validInput==true) {
								 EditBookinFile.EditYear(year, newbook);
								 newbook.setYear(year);
 								 items.set(index, newbook);
 
							}
						 
						 break;
					/* case 4:
						 System.out.println("Enter the new Cost of Magazine ");
							validInput = false;
							int cost = 0;
							while (!validInput) {
								System.out.print("Enter an integer: ");
								if (obj.hasNextInt()) {
									cost = obj.nextInt();
									if (cost > 0) {
										validInput = true;
									}
								} else {
									System.out.println("Invalid input. Please enter an integer.");
									obj.next();
								}
							}
							if(validInput==true) {
								 EditBookinFile.EditCost(cost, newbook);
								 newbook.setCost(cost);
 								 items.set(index, newbook);

							}
						 break;*/
					 case 4:
  
						 System.out.println("exiting");
 
	
                                                 break;
						 
                                         default:
					
                                             break;}}
						 
	 }
  	 
  	 
 

	
    public static void editItem(int id) throws IOException {
		 if(items.isEmpty()==false) {

                     Item item = null;

                     boolean found=false;
		 	
                     if (id >= 0 ) {
		 	
                         for(int i=0 ;i <items.size();i++) {
		 		    	if(items.get(i).getID()==id) {
		 			         item = items.get(i);

                                                 found=true;

                                        }
		 		    }}
		 		        if(found==true) {
				        if (item instanceof Book ) {
				            Book newbook= (Book) item;
				        
                                            editBook(newbook);

				        
                                        
                                        }  
				    }  
                                        
		 		        else {
							System.out.println("Item with id "+id+" not found  ");


                                        }}
		 else {
				System.out.println("Library is empty");

	
                 }}
		 
		 
		 
	 
		  
		 

}
