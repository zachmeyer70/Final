package dmacc.beans;

import java.util.List;

/**
 * 
 * Book sort class
 *sorts list of books based of title in alphabetical order  
 */
public class BookSort {
	private List<Book> books;
	
	//Constructor with list passed in
	public BookSort(List<Book> books) {
		this.books = books;
	}

	//sorting function with list parameter
	public List<Book> sort(List<Book> books) {
		Book temp;
		// loops to get book title and title of next book in list
		for(int i = 0; i < books.size(); i++) {
			for(int j = i + 1; j < books.size(); j++) {
				//if next books title is before other in alphabet then swaps 
				if(books.get(i).getTitle().compareTo(books.get(j).getTitle()) > 0) {
					// sets first to temp
					temp = books.get(i);
					// swap position of books
					books.set(i, books.get(j));
					books.set(j, temp);
				}
			}
		}
		return books;
	}
}
