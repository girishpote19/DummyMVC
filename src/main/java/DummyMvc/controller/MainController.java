package DummyMvc.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

import DummyMvc.Dao.BooksDao;
import DummyMvc.Model.Book;

@Controller
public class MainController {

	@Bean
	public BooksDao booksDao() {
		return new BooksDao();
	}

	@Autowired
	private BooksDao booksDao;

	@RequestMapping("/")
	public String home(Model m) {
		List<Book> books = booksDao.getBooks();  //get All Books from Dao and stored in books variable
		m.addAttribute("books", books);			//added into Model so we will get this on view
		return "index";
	}

	// show add book form
	@RequestMapping("/add-book")
	public String addBook(Model m) {
		m.addAttribute("title", "Add Book");
		return "add_book_form";

	}

	// handle add book form
	@RequestMapping(value = "/handleBooks", method = RequestMethod.POST)
	public RedirectView handleBook(@ModelAttribute Book book, HttpServletRequest request) {
		System.out.println(book);
		booksDao.createBook(book);  //add data into the DB
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;

	}

	// delete handler
	@RequestMapping("/delete/{bookId}")
	public RedirectView deleteBook(@PathVariable("bookId") int bookId, HttpServletRequest request) {
		booksDao.deleteBook(bookId);
		RedirectView redirectView = new RedirectView();
		redirectView.setUrl(request.getContextPath() + "/");
		return redirectView;

	}
	
	//update handler
	@RequestMapping("/update/{bookId}")
	public String updateForm(@PathVariable("bookId") int bId,Model m) {
		Book book = booksDao.getBook(bId);
		m.addAttribute("book",book);
		return "update_form";
	}
}