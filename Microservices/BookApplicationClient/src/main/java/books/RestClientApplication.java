package books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class RestClientApplication implements CommandLineRunner{
    @Autowired
    private RestOperations restTemplate;

    
	public static void main(String[] args) {
		SpringApplication.run(RestClientApplication.class, args);
	}

    @Override
    public void run(String... args) throws Exception {
        String serverUrl = "http://localhost:8080/books";

        //add 
        Book b1 = new Book("Spring in Action", 100, "978-1935182834");
        restTemplate.postForLocation(serverUrl, b1 );

        //add Book
        restTemplate.postForLocation(serverUrl, new Book("Spring Boot in Action III", 100, "978-1935182134"));
        //add Book
        restTemplate.postForLocation(serverUrl, new Book("Spring Boot in Action II", 100, "978-1935134834"));

        //get Book
        Book book= restTemplate.getForObject(serverUrl+"/{isbn}", Book.class, "978-1935182834");
        System.out.println("----------- get Book-----------------------");
        System.out.println(book.getTitle()+" "+book.getPrice());

        //get all
        Books books= restTemplate.getForObject(serverUrl, Books.class);
        System.out.println("----------- get all Books-----------------------");
        System.out.println(books);

        //delete Book
        restTemplate.delete(serverUrl+"/{isbn}", "978-1935182834");

        //update Book
        book.setPrice(200);
        restTemplate.put(serverUrl+"/{isbn}", book, book.getIsbn());

        //get all
        books= restTemplate.getForObject(serverUrl, Books.class);
        System.out.println("----------- get all Books-----------------------");
        // books.getBooks().forEach(System.out::println);
        System.out.println(books);
        
    }



    @Bean
    RestOperations restTemplate() {
        return new RestTemplate();
    }   
    
}


