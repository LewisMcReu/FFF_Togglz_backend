package be.faros.flags;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.togglz.spring.boot.actuate.autoconfigure.TogglzAutoConfiguration;

@SpringBootApplication
public class TogglzFlagsBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(TogglzFlagsBackendApplication.class, args);
    }

}
