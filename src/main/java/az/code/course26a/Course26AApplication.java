package az.code.course26a;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@EnableTransactionManagement
public class Course26AApplication {

    public static void main(String[] args) {
        SpringApplication.run(Course26AApplication.class, args);
    }

}
