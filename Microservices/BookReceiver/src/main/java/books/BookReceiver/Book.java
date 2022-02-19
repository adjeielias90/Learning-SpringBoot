package books.BookReceiver;


public class Book {
    private String title;
    private int price;
    private String isbn;

    public Book(String title, int price, String isbn) {
        this.title = title;
        this.price = price;
        this.isbn = isbn;
    }

    public Book(){}

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getIsbn() {
        return isbn;
    }
    
    public void setPrice(int price) {
        this.price = price;
    }
    
    public int getPrice() {
        return price;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }

}
