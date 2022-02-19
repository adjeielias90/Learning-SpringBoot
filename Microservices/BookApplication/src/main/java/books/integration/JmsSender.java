package books.integration;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import books.domain.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

@Component
public class JmsSender {
    @Autowired
    JmsTemplate jmsTemplate;

    public void sendMessage(Book book)  {
        try {
            //convert person to JSON string and send it
            ObjectMapper objectMapper = new ObjectMapper();
            String bookString = objectMapper.writeValueAsString(book);
            System.out.println("Sending a JMS message:" + bookString);
            jmsTemplate.convertAndSend("testQueue", bookString);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }
    
}
