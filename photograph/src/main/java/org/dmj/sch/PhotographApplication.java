package org.dmj.sch;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = "org.dmj.sch")
@SpringBootApplication
public class PhotographApplication {

    public static void main(String[] args) {
        SpringApplication.run(PhotographApplication.class, args);
    }
}
