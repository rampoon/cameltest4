package se.rampoon.example4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/**
 * Test of Camel by using Spring boot. Consuming from ActiveMQ, producing a file.
 *
 */
@SpringBootApplication
public class SpringBootCamelActiveMQ {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootCamelActiveMQ.class, args);
    }
}
