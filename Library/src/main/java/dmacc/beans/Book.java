package dmacc.beans;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
//@Data creates getters and setter for class
@Data
//@NoArgsConstructor creates a no-arguments constructor for the class
@NoArgsConstructor

/**
 * Book class
 * holds id, title, and author of book
 *
 */
public class Book {
	//sets id as the primary key in database
	@Id
	//creates sequence for setting id
	@GeneratedValue
	private int id;
	private String title;
	private String author;
	
	public Book(int id, String title, String author) {
		this.id = id;
		this.title = title;
		this.author=author;
	}
}
