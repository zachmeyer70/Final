/**************************************************************
* Name        : Final Project
* Author      : Zachary Meyer
* Created     : 12/9/2022
* Course      : CIS 152 Data Structures
* Version     : 1.0
* OS          : Windows 11
* Copyright   : This is my own original work based on
*               specifications issued by our instructor
* Description : This program overall description here
*               Input:  members and books to database
*               Output: member and book information to html pages
* Academic Honesty: I attest that this is my original work.
* I have not used unauthorized source code, either modified or 
* unmodified. I have not given other fellow student(s) access to
* my program.         
***************************************************************/
package dmacc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import dmacc.beans.Book;
import dmacc.beans.Member;
import dmacc.repository.BookRepository;
import dmacc.repository.MemberRepo;



@SpringBootApplication
public class Library implements CommandLineRunner{
	public static void main(String[] args) {
		SpringApplication.run(Library.class, args);	
	}
	
	// Repositories to save members and books to database
	@Autowired
	BookRepository bRepo;
	@Autowired
	MemberRepo mRepo;
	@Override
	public void run(String... args) throws Exception {
		//creating 2 members and adding them to database
		Member m = new Member();
		m.setAddress("123 Main Street");
		m.setName("Zach");
		m.setStatus(1);
		m.setCity("Indianola");
		Member m2 = new Member();
		m2.setAddress("456 1st Street");
		m2.setName("Jim");
		m2.setStatus(0);
		m2.setCity("Des Moines");
		mRepo.save(m);	// saving members to database
		mRepo.save(m2);	// saving members to database
		//creating 2 books and saving them to database
		Book b = new Book();
		b.setAuthor("Oda");
		b.setTitle("One Piece");
		Book b2 = new Book();
		b2.setAuthor("Toriyama");
		b2.setTitle("Dragon Ball");
		
		bRepo.save(b); // saving books to database
		bRepo.save(b2);	// saving members to database
		
	}
}
