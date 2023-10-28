 

package com.mycompany.assignment3;

  
import gui.DeleteRow;
import gui.EditBook;
import gui.Graph;
import gui.RollOverTable;
import gui.JButtonRenderer_Read;
import gui.addBook;
 import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
 
import java.awt.Font;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
 import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
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
                    JPanel pane=new JPanel();              
JFrame frame=new JFrame();
 String[] names = new String[items.size()];
  Integer[] popular_count=new Integer[items.size()];
                 for(int i=0 ;i<items.size();i++) {
			 if (items.get(i) instanceof Book ) {
		            Book newbook= (Book) items.get(i) ;
                            String title=newbook.getTitle();
                            names[i]=title;
                            if(title.length()>7){
                                String firstSixChars = title.substring(6, title.length());

                                 names[i]=firstSixChars;
                            }
                            popular_count[i]=newbook.getPopularityCount();
                            String author=newbook.getAuthor();
                             String ID=Integer.toString(newbook.getID());
                            String Year =Integer.toString(newbook.getYear());
                                                        String cost =Integer.toString(newbook.getCost());

                            List<String>m=new ArrayList<>(); m.add(ID);
                            m.add(title);
                            m.add(author);
                            
                            m.add(Year);
                            m.add(cost);
                            books.add(m);
                            
 
		        }}    
       
          DefaultTableModel model=new DefaultTableModel();
          String[] col = {"ID","Title", "Author", "Year","Cost","Read Item"};
                   for (String columnName : col) {
                        model.addColumn(columnName);
                                       }
                   for (List<String> bookInfo : books) {
                         model.addRow(bookInfo.toArray());
                         }
                    
                      RollOverTable j = new RollOverTable(model );

         
             DefaultTableCellRenderer centerRenderer = new DefaultTableCellRenderer();
            centerRenderer.setHorizontalAlignment(JLabel.CENTER);
                     //      j.setDefaultRenderer(Object.class, centerRenderer);
 
     
     
    JButtonRenderer_Read compCellDelete = new JButtonRenderer_Read(frame );

j.getColumnModel().getColumn(5).setCellEditor(compCellDelete);
j.getColumnModel().getColumn(5).setCellRenderer(compCellDelete);
 
  DefaultTableCellRenderer cellRenderer = new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
                Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
                if (isSelected) {
                    c.setBackground(table.getSelectionBackground());
                } else {
                    c.setBackground(Color.WHITE);
                }
                return c;
            }
        };
        j.setDefaultRenderer(Object.class, cellRenderer);

     /*   j.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                Point point = e.getPoint();
                int column = j.columnAtPoint(point);
                int row = j.rowAtPoint(point);
                if (column >= 0 && row >= 0) {
                    j.setSelectionBackground(Color.lightGray);
                    j.setDefaultRenderer(Object.class, cellRenderer); 
                    j.prepareRenderer(cellRenderer, row, column);
                    j.repaint();
                }
            }
        });*/
        JButton button = new JButton("View Popularity count");

 
         
         button.addActionListener(new java.awt.event.ActionListener() {
                 @Override
                public void actionPerformed(ActionEvent e) {
                    frame.setVisible(false);
                     try {
                         items=fileReadWrite.readItems();
                     } catch (IOException ex) {
                         Logger.getLogger(Library.class.getName()).log(Level.SEVERE, null, ex);
                     }
                  List< List<String>>book=new ArrayList<>();
                 
 String[] name = new String[items.size()];
  Integer[] popular_counts=new Integer[items.size()];
                 for(int i=0 ;i<items.size();i++) {
			 if (items.get(i) instanceof Book ) {
		            Book newbook= (Book) items.get(i) ;
                            String title=newbook.getTitle();
                            name[i]=title;
                            if(title.length()>7){
                                String firstSixChars = title.substring(6, title.length());

                                 name[i]=firstSixChars;
                            }
                            popular_counts[i]=newbook.getPopularityCount();}}
                 
                      Graph g=new Graph(popular_counts,name,frame);
                      
                     
                           
                }
            });
         JButton button2 = new JButton("Add book");

 
         
         button2.addActionListener(new java.awt.event.ActionListener() {
                 @Override
                public void actionPerformed(ActionEvent e) {
                   // frame.setVisible(false);
                     addBook g=new addBook(model );
                      
                     
                           
                }
            });
         
           JButton button4 = new JButton("Delete book");

 
         
         button4.addActionListener(new java.awt.event.ActionListener() {
                 @Override
                public void actionPerformed(ActionEvent e) {
                   // frame.setVisible(false);
                DeleteRow n=new DeleteRow(j,model);                      
                     
                           
                }
            });
    

           JButton button3 = new JButton("Edit book");

 
         
         button3.addActionListener(new java.awt.event.ActionListener() {
                 @Override
                public void actionPerformed(ActionEvent e) {
                   // frame.setVisible(false);
        EditBook b=new EditBook(j,  model,popular_count);
                      
                     
                           
                }
            });

         
         
         
         
         
          //   chart.setBackground(Color.decode("#77B686"));
         pane.setBorder(BorderFactory.createLineBorder(Color.black, 4)); // Set border for the chart
         pane.setPreferredSize(new Dimension(400, 300));

  
 pane.setLayout(new BoxLayout(pane, BoxLayout.Y_AXIS));

 JPanel buttonPanel = new JPanel();
//buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.X_AXIS));
 buttonPanel.setLayout(new   FlowLayout());
 

 buttonPanel.add(button);
buttonPanel.add(button2);
buttonPanel.add(button3);
buttonPanel.add(button4);

 
        
        
  JScrollPane scrollPane1 = new JScrollPane(j);
 pane.add(scrollPane1);
   
   frame.add(pane);
     pane.add(buttonPanel);

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
