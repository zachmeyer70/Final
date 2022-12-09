package dmacc.beans;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BookTest {

	@BeforeEach
	void setUp() throws Exception {
	}

	@Test
	void testGetId() {
		Book b = new Book();
		b.setId(0);
		assertEquals(b.getId(),0);
	}

	@Test
	void testGetTitle() {
		Book b = new Book();
		b.setTitle("One Piece");
		assertEquals(b.getTitle(),"One Piece");
	}

	@Test
	void testGetAuthor() {
		Book b = new Book();
		b.setAuthor("Oda");
		assertEquals(b.getAuthor(),"Oda");
	}
	@Test
	void testBookSort() {
		Book b1 = new Book();
		b1.setTitle("Harry Potter");
		Book b2 = new Book();
		b2.setTitle("Jojos");
		Book b3 = new Book();
		b3.setTitle("Berserk");
		List<Book> books = new ArrayList<>();
		books.add(b1);
		books.add(b2);
		books.add(b3);
		BookSort bs = new BookSort(books);
		books = bs.sort(books);
		assertEquals(books.get(0), b3);
		assertEquals(books.get(1), b1);
		assertEquals(books.get(2), b2);
	}
}
