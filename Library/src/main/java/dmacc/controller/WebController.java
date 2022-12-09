package dmacc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import dmacc.beans.Book;
import dmacc.beans.BookSort;
import dmacc.beans.Member;
import dmacc.beans.MemberStatus;
import dmacc.repository.BookRepository;
import dmacc.repository.MemberRepo;

@Controller
public class WebController {
	//repositories to get and save entities to databse
	@Autowired
	BookRepository bRepo;
	@Autowired
	MemberRepo mRepo;
	
	//goes to the addBook page from  hyper link on index page
	@GetMapping("/addBook") public String addNewBook(Model model) {
		// creates book and adds to model
		Book b = new Book();
		model.addAttribute("newBook",b);
		// name of page hyperlink goes to
		return "addBook";
	}
	// calls method when submit is pressed on addBook page
	//gets book from model object
	@PostMapping("/addBook") public String addNewBook(@ModelAttribute Book b, Model model) {
		// save book to database
		bRepo.save(b);
		// goes to viewAllBooks page
		return viewAllBooks(model);
	}
	
	//goes to addMember page from hyper link
	@GetMapping("/addMember") public String addNewMember(Model model) {
		// creates member object and adds to model
		Member m = new Member();
		model.addAttribute("newMember",m);
		// goes to addMember page
		return "addMember";
	}
	// calls method when click submit button on addMember page
	// gets member object from model
	@PostMapping("/addMember") public String addNewMember(@ModelAttribute Member m, Model model) {
		// save member to database
		mRepo.save(m);
		//goes to view all members page
		return viewAllMembers(model);
	}
	//takes to viewAllBooks page
	@GetMapping("/viewAllBooks") public String viewAllBooks(Model model) {
		//bRepo.findAll() is a list of all book is database
		// that list is passed into book sort method
		BookSort bs = new BookSort(bRepo.findAll());
		//sorted list is passed back
		List<Book> b = bRepo.findAll();
		b = bs.sort(b);
		System.out.println(b);
		// adds to sorted list to model to list out on html page
		model.addAttribute("b", b);
		return "viewBooks";
	}
	//takes to view all Members page
	@GetMapping("/viewAllMembers") public String viewAllMembers(Model model) {
		//mRepo.findAll() is list of all members in database
		// that is is passed into member status page
		MemberStatus ms = new MemberStatus(mRepo.findAll());
		//list is passed into priority queue in findStatus method.
		//the priority queue is used to compare status of member to list in order
		//contents of priority queue is added to list in correct order
		// list passed back
		List<Member> m = ms.findStatus(mRepo.findAll());
		// added ordered list of model
		model.addAttribute("currentMembers", m);
		return "viewMembers";
	}
	//takes users back to index page
	@GetMapping("/index") public String home() {
		return"index";
	}

}
