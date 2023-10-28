/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment3;

 

import java.util.*;
   
public class Book extends Item {
	// we can make data members public b using public keword before data tpes
	// but to achieve encapsulation , getters and setters are implemented

	private String author;
	private int year;
	static Scanner obj = new Scanner(System.in);

	public Book(String t, boolean b, int p, int c, String a, int y) {
		super(t, b, p, c);
		id = nextId++; // Assign the next available ID and increment it

		author = a;
		year = y;
		
	}
	@Override

	public double calculate() {
		 
 	double 	ncost= (cost+(0.2 * cost)+200);
 		return ncost;
		

	}

	@Override
	public void displayInfo() {

		super.displayInfo();

		System.out.println("Author : " + author);
		System.out.println("Year : " + year+"\n\n");
	}

	/***************** ADDED FUNCS ******************/

	public Book() {

		super();

		author = "";
		year = 0;

	}

	 

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getAuthor() {
		return this.author;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getYear() {
		return this.year;
	}

	public static Book getBook() {
		System.out.println("Enter the title of the book: ");

		String title = obj.next();

		System.out.println("Enter the author of the book: ");
		String author = obj.next();

		System.out.println("Enter the year of publication of the book: ");
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
		System.out.println("Enter the Cost of Magazine ");
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
		// ;
 	//	System.out.println("Invalid input. Please enter an integer."+popularity);

 		Book book = new Book(title, false, 0, cost, author, year);

		return book;
	}
}

