package com.example.wkshp1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.DefaultApplicationArguments;
import java.util.Collections;

@SpringBootApplication
public class YourApplication {

    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(YourApplication.class);

        // Set default port
        String port = "3000";

        // Check command-line arguments for --port
        ApplicationArguments cliArgs = new DefaultApplicationArguments(args);
        if (cliArgs.containsOption("port")) {
            port = cliArgs.getOptionValues("port").get(0);
        } 
        // Check for environment variable PORT
        else if (System.getenv("PORT") != null) {
            port = System.getenv("PORT");
        }

        app.setDefaultProperties(Collections.singletonMap("server.port", port));
        app.run(args);
    }
}

