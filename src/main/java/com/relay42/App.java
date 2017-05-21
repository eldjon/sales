package com.relay42;

import com.relay42.config.SwaggerConfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(SwaggerConfig.class)
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
}
