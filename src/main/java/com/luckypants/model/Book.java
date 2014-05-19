package com.luckypants.model;


public class Book {
	
	private String title;
	private String author;
	private String ISBN;
	private String cost;
	private String genre;
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getISBN() {
		return ISBN;
	}
	public void setISBN(String ISBN) {
		this.ISBN = ISBN;
	}
	public String getCost(){
		return cost;
	}
	public void setCost(String cost){
		this.cost=cost;
	}
	public String getGenre(){
		return genre;
	}
	public void setGenre(String genre){
		this.genre=genre;
	}
	
}
