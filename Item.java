/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.assignment3;
 

import java.util.Scanner;

class Item implements Configuration {
	static int nextId; // Static variable to auto-increment the ID
	protected int id;
	public String title;
	public boolean isBorrowed;
	protected int popularity;
	public int cost;
	static Scanner obj;

	public Item(String t, Boolean b, int p, int c) {
	//	id = nextId++; // Assign the next available ID and increment it
		title = t;
		isBorrowed = b;
		popularity = p;
		cost = c;
		obj = new Scanner(System.in);
	}
 

	/***************** ADDED FUNCS ******************/

	static {
		nextId = 1;
	}

	// abstract void calculate();
	protected Item() {
		// nextId=1; // Static variable to auto-increment the ID
		id = nextId;
		title = " ";
		isBorrowed = false;
		popularity = 0;
		cost = 0;

		obj = new Scanner(System.in);

	}

	protected void setBorrowedStatus(boolean flag) {
		this.isBorrowed = flag;
	}

	protected boolean getBorrowedStatus() {
		return isBorrowed;
	}

	public   void setPopularityCount(int count) {
		popularity = count;
	}

	public int getPopularityCount() {
		return popularity;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	public int getCost() {

		return cost;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}
 
	public int getID() {
		return this.id;
	}

	public double calculate() {
		return cost;
		// TODO Auto-generated method stub

	}

	@Override
	public void displayInfo() {

		System.out.println("Item ID: " + id);
		System.out.println("Title " + title);
		System.out.println("Item is Borrowed: " + isBorrowed);
		System.out.println("Price: $" + cost);
		System.out.println("Popularity Count: " + popularity);

	}

}

