/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment3;

 
import java.util.ArrayList;
import java.util.List;

public class Borrower {
       private String name;
   	static List<Item> itemsborrowed;

       Borrower(){
    	    name="";
    	    itemsborrowed=new ArrayList<>();

    	    
       }
       Borrower(String n){
    	   this.name=n;
   	    itemsborrowed=new ArrayList<>();

       }
       
       public void displayBorrowedItems() {
		   System.out.println("Borrower name :"+ getName());
 
    	   for(int i=0 ;i<itemsborrowed.size();i++) {
    		   System.out.println(itemsborrowed.get(i).getTitle());
    	   }
       }
       public boolean checkItemID(int id) {
    	   boolean check=false;
    	   for(int i=0;i<itemsborrowed.size();i++) {
    		   if(itemsborrowed.get(i).getID()==id) {
    			   check=true;
    			   break;
    		   }
    	   }
    	   return check;
       }
       public void additem(Item i) {
    	   itemsborrowed.add(i);
       }
       public void setName(String n) {
    	   name=n;
       }
       public String getName() {
    	   return name;
       }
}
