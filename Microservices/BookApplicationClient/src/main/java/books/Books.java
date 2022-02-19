package books;

import java.util.Collection;
// import java.util.List;

public class Books {
    private Collection<Book> books;

    public Books(){}

    public Books(Collection<Book> books) {
        this.books = books;
    }
    public Collection<Book> getBooks() {
        return books;
    }
    public void setBooks(Collection<Book> contacts) {
        this.books = books;
    }

}
