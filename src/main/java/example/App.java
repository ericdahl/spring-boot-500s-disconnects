package example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@SpringBootApplication
public class App {

    private static final Random RANDOM = new Random();

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }

    @RequestMapping(value = "/", produces = MediaType.TEXT_PLAIN_VALUE)
    public String index() {
        final StringBuilder builder = new StringBuilder();

        for (int i = 0; i < 100000; ++i) {
            builder.append(RANDOM.nextInt()).append('\n');
        }

        return builder.toString();
    }

}
