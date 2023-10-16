/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment3;

 
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

//Create a new Library class that can store multiple Book objects.
//Implement methods to add, edit, delete books in the library and also display all books in
//the library.
public class Library {
	static List<Item> items;
	public static Scanner obj;
    List<Borrower>borrowers;

	public Library() throws IOException {
		items = new ArrayList<>();
  borrowers=new ArrayList<>();
		obj = new Scanner(System.in);
 		 items=fileReadWrite.readItems();
 		//System.out.println("items size"+items.size());
 	//	displayall();
 
 		  
		 
	}
	public void displayBorrrowers() {
 		    for (Borrower borrower : borrowers) {
 		    	borrower.displayBorrowedItems();
 		    }
  

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
	
	public void returnItem(int id) {
	 System.out.println("Enter  name: ");
     String x = obj.next();
     int j=0;
      
     for (  j = 0; j < borrowers.size(); j++) {
         if (borrowers.get(j).getName().equals(x)) {
              break;
         }
     }
    if( borrowers.get(j).checkItemID(id)==true) {
    	    for (int i = 0; i < items.size(); i++) {
   	        if (id == items.get(i).getID()) {
     	         items.get(i).setBorrowedStatus(false);
   	            break;}}
    	    System.out.println("Item with id "+id+" returned b user :"+x);

   	    
    }
 
	}
     
	public void BorrowItem(int id) throws IOException {
	    boolean check = false;
	    int required=0;
	    for (int i = 0; i < items.size(); i++) {
	        if (id == items.get(i).getID()) {
	            check = true;
	            required=i;
	            break;}}
	 // /  if(check==false) {
         //   System.out.println("Unable to complete action: Item does not exist");}

	   //     if(check==true) {
	            
	            if (items.get(required).getBorrowedStatus() == true) {
	                System.out.println("Unable to complete action: Item is already borrowed");}
	            else {
 
	                System.out.println("Enter 1 to make a new user, 2 if an existing user: ");
		            int in = obj.nextInt();
	             
	                if (in == 1) {
	                    System.out.println("Enter new user name: ");
	                    String x = obj.next();
	                    Borrower newBorrower = new Borrower(x);
	                    items.get(required).setBorrowedStatus(true);
	                    newBorrower.additem(items.get(required));
	                    borrowers.add(newBorrower);
	                    System.out.println("Item borrowed successfully by " + x);
	                    int populariCount=items.get(required).getPopularityCount();
	                    populariCount=populariCount+1;

 	                    changePopularityCount(items.get(required),populariCount);
	                    items.get(required).setPopularityCount(populariCount);
	                    System.out.println("Receipt for : " + x);
	                    System.out.println("Book borrowed : " + items.get(required).getTitle());
	                    System.out.println("Book cost calculated : " + items.get(required).calculate());

   

	                   // displayBorrrowers();
 
 	                }
	                else if (in == 2) {
	                    System.out.println("Enter existing user name: ");
	                    String x = obj.next();
	                    Borrower existingBorrower = null;
	                    for (int j = 0; j < borrowers.size(); j++) {
	                        if (borrowers.get(j).getName().equals(x)) {
	                            existingBorrower = borrowers.get(j);
	                            break;
	                        }
	                    }
	                    if (existingBorrower == null) {
	                        System.out.println("Borrower not found");
	                    } else {
	                        if (existingBorrower.checkItemID(id) == true) {
	                            System.out.println("Unable to complete action: Item is already borrowed Once");
	                        } else {
	                            items.get(required).setBorrowedStatus(true);
	                            existingBorrower.additem(items.get(required));
	                            System.out.println("Item borrowed successfully by " + x);
	                            int populariCount=items.get(required).getPopularityCount();
	    	                    populariCount=populariCount+1;

 	    	                    changePopularityCount(items.get(required),populariCount);
	    	                    items.get(required).setPopularityCount(populariCount);

	                        }
	                    }
	                }
 
	            }
	        }
	//    }
	
 public void changePopularityCount(Item i,int count)throws IOException {
	 
	    if (i instanceof Book ) {
            Book newbook= (Book) i;
             EditBookinFile.EditPopularityCount(count, newbook);
 
 
        } else if (i instanceof Newspaper) {
        	 Newspaper news= (Newspaper) i;
             EditNewspaperInFile.EditPopularityCount(count, news);
        } else if (i instanceof Magazine) {
        	 Magazine mag= (Magazine) i;
             EditMagazineInFile.EditPopularityCount(count, mag);
             
             
        }

 }
	public void addItem() throws IOException {
		System.out.print("Enter 1 to add book , 2 to add Magazine , 3 to add newspaper");
		int n = obj.nextInt();
		if (n == 1) {
			Book newitem = new Book();
			newitem=newitem.getBook();
			fileReadWrite.addBook(newitem);
			items.add(newitem);

		} else if (n == 2) {
			Magazine m = new Magazine();
			m=m.getMagazine();

			if (m.getAuthors().size() > 0) {
				List<String> l = m.getAuthors();
				for (int i = 0; i < m.getAuthors().size(); i++) {
					System.out.print(l.get(i));
				}
			} else {
				System.out.print("NO");

			}
			fileReadWrite.addMagazine(m);
			items.add(m);

		} else if (n == 3) {
			Newspaper p = Newspaper.getNewspaper();
			fileReadWrite.addNewspaper(p);
			items.add(p);

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

		        } else if (item instanceof Newspaper) {
		        	 Newspaper news= (Newspaper) item;
		             fileReadWrite.deleteNewspaper(news);
		        } else if (item instanceof Magazine) {
		        	 Magazine mag= (Magazine) item;
		             fileReadWrite.deleteMagazine(mag);
						System.out.print("Deleted mag with ");

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
 public static void editMagazine(Magazine mag) throws IOException {
	 int x=0,index=0;
	 for(int i=0;i<items.size();i++) {
		 if(mag.getID()==items.get(i).getID()) {
			 index=i;
		 }
	 }
	 while(x!=6) {
			 
	 System.out.println("\n\n Library/Edit Magazine/ ID :"+mag.getID());
		 System.out.println("1. Edit  title ");
		 System.out.println("2. Edit Author ");
		 System.out.println("3. Delete Author ");
		 System.out.println("4. Add Author ");

		 System.out.println("5. Edit Publication Comapany    ");
			// System.out.println("4. Edit Cost ");
		 System.out.println("6. exit ");
		 System.out.println("Enter your choice");
		 x=obj.nextInt();
		 
		 switch(x) {
		 case 1:
				System.out.println("Enter new Title for the Magazine ");
             String newtitle=obj.next();
			 EditMagazineInFile.EditTitle(newtitle, mag);
			 mag.setTitle(newtitle);
				 items.set(index, mag);

			 
			 break;
		 case 2:
			 System.out.println("Enter number of  Author  ");
  				boolean validInput = false;
				int number = 0;
				boolean indexinvalid=false;
				while (!validInput && !indexinvalid) {
					System.out.print("Enter an integer: ");
					if (obj.hasNextInt()) {
						number = obj.nextInt();
						if (number > 0) {
							validInput = true;
						}
		                 if(number-1<= mag.getAuthors().size()) {
		                	 indexinvalid=true;
		                 }

					} else {
						System.out.println("Invalid input. Enter valid number .");
						obj.next();
					}
				}
			 System.out.println("Enter new Author for the Magazine ");
             String newauthor=obj.next();
              
             EditMagazineInFile.EditAuthor(newauthor, mag,number);
             mag.setAuthor(number-1, newauthor);
			 //System.out.println("indix is "+index);

			 items.set(index, mag);

			 break;
		 case 3:
			 System.out.println("Enter number of  Author to delete ");
				  validInput = false;
				  number = 0;
				  indexinvalid=false;
				while (!validInput && !indexinvalid) {
					System.out.print("Enter an integer: ");
					if (obj.hasNextInt()) {
						number = obj.nextInt();
						if (number > 0) {
							validInput = true;
						}
		                 if(number-1<= mag.getAuthors().size()) {
		                	 indexinvalid=true;
		                 }

					} else {
						System.out.println("Invalid input. Enter valid number .");
						obj.next();
					}
				}
			 
           
          List<String> author=EditMagazineInFile.deleteAuthor(number, mag);
         mag.setAuthors(author);
 
			 items.set(index, mag);
			 break;
			 
		 case 4 :
 				 System.out.println("Enter name  of new  Author to add ");
				 
					 String name=obj.next();
			 
          
         author=EditMagazineInFile.addAuthor(name, mag);
           index=0;
        for(int i=0 ;i<items.size();i++) {
        	if(items.get(i)==mag) {
        		index=i;
        	}
        }
        mag.setAuthors(author);

        items.set(index, mag);

		 break;
			 

		 case 5:
				System.out.println("Enter the new  publication company  of the Magazine: ");
				 
				newauthor=obj.next();
	              
	             EditMagazineInFile.EditPublisher(newauthor, mag);
	             mag.setPublisher(newauthor);
				 items.set(index, mag);

			 
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
					EditMagazineInFile.EditCost(cost, mag);
                   mag.setCost(cost);
  				 items.set(index, mag);

				}
			 break;*/
		 case 6:

			 System.out.println("exiting");

			 break;
			 default:
				 break;}}
			 
}
		 
	 
 public static void editNewspaper(Newspaper news) throws IOException {
	 int x=0,index=0;
	 for(int i=0;i<items.size();i++) {
		 if(news.getID()==items.get(i).getID()) {
			 index=i;
		 }
	 }
	 while(x!=5) {
			 //3, newspaper_title, publisher_company, 1, 20-09-2023
	 System.out.println("\n\n Library/Edit Book: ");
		 System.out.println("1. Edit  title ");
 		 System.out.println("2. Edit Publisher Company ");
		// System.out.println("3. Edit Cost ");
		 System.out.println("3. Edit Date ");
		 System.out.println("4. exit ");
		 System.out.println("Enter your choice");
		 x=obj.nextInt();
		 
		 switch(x) {
		 case 1:
				System.out.println("Enter new Title for the book ");
             String newtitle=obj.next();
			 EditNewspaperInFile.EditTitle(newtitle, news);
			 news.setTitle(newtitle);
				 items.set(index, news);

			 
			 break;
		 case 2:
			 
			 System.out.println("Enter new Publisher Company for the Newspaper ");
             String newauthor=obj.next();
             EditNewspaperInFile.EditPublisher(newauthor, news);
             news.setPublisher(newauthor);
			 items.set(index, news);

			 break;
		/* case 3:
 	 System.out.println("Enter the new Cost of Magazine ");
			boolean	validInput = false;
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
					EditNewspaperInFile.EditCost(cost, news);
					news.setCost(cost);
					 items.set(index, news);


				}
			 break;*/
		 case 3:
			 Date parsedDate=null;
			 System.out.println("Enter the new Date of Magazine ");
				SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
				boolean flag = true;
				while (flag == true) {
					System.out.print("Enter a date (dd/MM/yyyy) ");
					String input = obj.next();
					try {
						  parsedDate = sdf.parse(input);
						System.out.println("Input date: " + sdf.format(parsedDate));

						flag = false;

					} catch (ParseException e) {
						System.out.println("Invalid date format. Please enter a date in dd/MM/yyyy format.");
						flag = true;
					}
				}
				String formattedDate = sdf.format(parsedDate);
				EditNewspaperInFile.EditDate(formattedDate, news);
				news.setDate(parsedDate);
				 items.set(index, news);

				break;
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

				        } else if (item instanceof Newspaper) {
				        	 Newspaper news= (Newspaper) item;
				            editNewspaper(news);
				        } else if (item instanceof Magazine) {
				        	 Magazine mag= (Magazine) item;
				             editMagazine(mag);
				        }
				    }  
		 		        else {
							System.out.println("Item with id "+id+" not found  ");

		 		        }}
		 else {
				System.out.println("Library is empty");

		 }}
		 
		 
		 
	 
		  
		 

}
