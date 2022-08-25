package com.revature.ecomm;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.SpringApplication;

import static org.springframework.boot.SpringApplication.run;
import static org.springframework.boot.autoconfigure.SpringBootApplication.*;

@SpringBootApplication
public class EcommApplication {
    public static void main(String[] args){
        run(EcommApplication.class, args);
    }
}
