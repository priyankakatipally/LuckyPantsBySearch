package com.luckypants.command;

import org.codehaus.jackson.map.ObjectMapper;

import com.luckypants.model.Book;
import com.luckypants.mongo.BooksConnectionProvider;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

public class CreateBookCommand {

	public boolean execute(Book book) {
		BooksConnectionProvider booksConn = new BooksConnectionProvider();
		DBCollection booksCollection = booksConn.getCollection();

		ObjectMapper mapper = new ObjectMapper();
		try {
			DBObject dbObject = (DBObject) JSON.parse(mapper
					.writeValueAsString(book));
			booksCollection.insert(dbObject);
		} catch (Exception e) {
			System.out.println("ERROR during mapping book to Mongo Object");
			return false;
		}

		return true;
	}

	public static void main(String[] args) {
		CreateBookCommand create = new CreateBookCommand();
		Book book = new Book();
		book.setAuthor("Gula");
		book.setTitle("Python");
		book.setISBN("A123er5");
		book.setCost("45");
		book.setGenre("Scripting language");
		Book book1 = new Book();

		book1.setAuthor("David");
		book1.setTitle("Computer Networks");
		book1.setISBN("567Tw");
		book1.setCost("40");
		book1.setGenre("Networking");
		
		
		if (create.execute(book)) {
			System.out.println("SUCCESS:Book Created");
		} else {
			System.out.println("ERROR:Failed to create book");
		}
		if (create.execute(book1)) {
			System.out.println("SUCCESS:Book Created");
		} else {
			System.out.println("ERROR:Failed to create book");
		}

	}
}
