package mk.ukim.finki.emtlab2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;


@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
@ServletComponentScan
public class  EmtLab2Application {

    public static void main(String[] args) {
        SpringApplication.run(EmtLab2Application.class, args);
    }

}
