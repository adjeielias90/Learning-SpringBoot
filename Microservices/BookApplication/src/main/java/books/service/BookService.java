package books.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import books.data.BookRepository;
import books.domain.Book;
import books.integration.JmsSender;

@Service
public class BookService {


    @Autowired
    BookRepository booksRepository;

    @Autowired
    JmsSender jmsSender;


    public void addBook(Book book) {
        booksRepository.save(book);
        jmsSender.sendMessage(book);
    }

    public void updateBook(Book book) {
        booksRepository.save(book);
        jmsSender.sendMessage(book);
    }

    public void deleteBook(String isbn) {
        jmsSender.sendMessage(getBook(isbn));
        booksRepository.delete(isbn);
    }

    public Book getBook(String isbn) {
        return booksRepository.findByIsbn(isbn);
    }

    public Collection<Book> getAllBooks() {
        return booksRepository.findAll();
    }

    
    
}
