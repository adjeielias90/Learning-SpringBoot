package books.data;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;
import books.domain.Book;



@Repository
public class BookRepository {
    private Map <String, Book> books = new HashMap<String, Book>();

    public void save (Book book) {
        books.put(book.getIsbn(), book);
    }

    public Book findByIsbn(String isbn){
        return books.get(isbn);
    }

    public void delete(String isbn){
        books.remove(isbn);
    }

    public Collection<Book> findAll(){
        return books.values();
    }

}