package com.luckypants.command;

import com.luckypants.mongo.BooksConnectionProvider;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;

public class DeleteBookCommand {

	public boolean execute(String title) {
		BooksConnectionProvider booksConn = new BooksConnectionProvider();
		DBCollection booksCollection = booksConn.getCollection();

		BasicDBObject searchQuery = new BasicDBObject();
		searchQuery.put("title", title);

		DBCursor cursor = booksCollection.find(searchQuery);

		while (cursor.hasNext()) {
			booksCollection.remove(searchQuery);
		}

		return true;
	}

	public static void main(String[] args) {
		DeleteBookCommand command = new DeleteBookCommand();
		boolean result =  command.execute("java");
		System.out.println(result);
	}

}
