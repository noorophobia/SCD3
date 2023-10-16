/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment3;

 
import java.util.*;

public class Magazine extends Item {
	// but to achieve encapsulation , getters and setters are implemented

	private   List<String> authorsList;
	private   String publisher;
	static Scanner obj = new Scanner(System.in);

	public Magazine(String t, boolean b, int p, int c, List<String> a, String pp) {

		super(t, b, p, c);
		id = nextId++; // Assign the next available ID and increment it

		authorsList = a;
		publisher = pp;
	}

	@Override
	public void displayInfo() {

		super.displayInfo();
		if(authorsList.size()==1) {
			System.out.println("Author " + (1) + " : " + authorsList.get(0));

		}
		else {
		for (int i = 0; i < authorsList.size(); i++) {
			System.out.println("Author " + (i+1) + " : " + authorsList.get(i));

		}
		System.out.println("Publisher name " + publisher+"\n\n");

	}}

	/***************** ADDED FUNCS ******************/

	 
	public Magazine() {
		// nextId=1; // Static variable to auto-increment the ID
		super();
		authorsList = new ArrayList<String>();
		publisher = " ";

	}

	@Override

	public double calculate() {
		 
	 	double 	ncost=cost*getPopularityCount();
		return ncost;
		

	}

	public void setAuthors(List a) {
		authorsList = a;
	}

	public List<String> getAuthors() {
		return authorsList;
	}

	public int listSize() {
		return authorsList.size();
	}

	public String getAuthor(int index) {
		return authorsList.get(index);
	}
	public void setAuthor(int index,String a) {
		  authorsList.set(index,a);
	}

	public void addAuthors(String a) {
		authorsList.add(a);
	}

	public String getPublisher() {
		return this.publisher;
	}

	public void setPublisher(String p) {
		this.publisher = p;
	}

	public   Magazine getMagazine() {
		System.out.println("Enter the title of the Magazine: ");

		String title = obj.next();

		System.out.println("Enter the year of publication of the Magazine: ");
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
		int number = 0;

		validInput = false;
		while (validInput == false) {
			System.out.println("Enter the number of authors ");
			if (obj.hasNextInt()) {
				number = obj.nextInt();
				if (number > 0) {
					validInput = true;
				}
			} else {
				System.out.println("Invalid input. Please enter an integer.");
				obj.nextInt();
			}
		}

		String author = " ";
		List<String> aList = new ArrayList<String>();

		for (int i = 0; i < number; i++) {

			System.out.println("Enter the name author " + i + " of the Magazine: ");
			author = obj.next();
			aList.add(author);
		}

		System.out.println("Enter the name of Publisher Company of Magazine: ");
		publisher = obj.next();

		int cost = 0;
		validInput = false;
		while (validInput == false) {
			System.out.println("Enter the Cost of Magazine ");
			if (obj.hasNextInt()) {
				cost = obj.nextInt();
				if (cost > 0) {
					validInput = true;
				}
			} else {
				System.out.println("Invalid input. Please enter an integer.");
				obj.nextInt();
			}
		}

		Magazine m = new Magazine(title, false, 0, cost, aList, publisher);

		return m;
	}

}
