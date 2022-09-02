package com.revature.ecomm;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import static org.springframework.boot.SpringApplication.run;
import static org.springframework.boot.autoconfigure.SpringBootApplication.*;


@SpringBootApplication

    public class EcommApplicationTest {
        public static void main(String[] args) {
            run(EcommApplication.class, args);
        }
}
