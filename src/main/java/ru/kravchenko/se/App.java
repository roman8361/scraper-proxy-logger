package ru.kravchenko.se;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;

/**
 * Hello world!
 *
 */

@RestController
@EnableAutoConfiguration
public class App {

    @RequestMapping("/")
    private String home() {
        return "HELLO TRALALALLALAL";
    }

    public static void main( String[] args ){
        SpringApplication app = new SpringApplication(App.class);
        app.setDefaultProperties(Collections
                .singletonMap("server.port", "8000"));
        app.run(args);
    }

    static boolean isCheck(final User user) {
        return user.getName() != null && !user.getName().isEmpty();
    }

}
