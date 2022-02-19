package books.web;
import books.domain.Book;
import books.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class BookController {
    @Autowired
    private BookService bookService;

    @GetMapping("/books/{isbn}")
    public ResponseEntity<?> getBook(@PathVariable String isbn) {
        Book book = bookService.getBook(isbn);
        if (book == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with isbn= "
                    + isbn + " is not available"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @PostMapping("/books")
    public ResponseEntity<?> addBook(@RequestBody Book book) {
        bookService.addBook(book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @DeleteMapping("/books/{isbn}")
    public ResponseEntity<?> deleteBook(@PathVariable String isbn) {
        Book book = bookService.getBook(isbn);
        if (book == null) {
            return new ResponseEntity<CustomErrorType>(new CustomErrorType("Book with isbn= " + isbn + " is not available"),HttpStatus.NOT_FOUND);
        }
        bookService.deleteBook(isbn);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/books/{isbn}")
    public ResponseEntity<?> updateBook(@PathVariable String isbn, @RequestBody Book book) {
        bookService.updateBook(book);
        return new ResponseEntity<Book>(book, HttpStatus.OK);
    }

    @GetMapping("/books")
    public ResponseEntity<?> getAllBooks() {
        Books allbooks = new Books(bookService.getAllBooks());
        return new ResponseEntity<Books>(allbooks, HttpStatus.OK);
    }
    
}
