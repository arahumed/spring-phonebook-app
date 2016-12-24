package com.arthur;

import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class PhonebookApplication {
    
    private static final Logger log = LoggerFactory.getLogger(PhonebookApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(PhonebookApplication.class, args);
    }
    
    
    public static Person newPerson(String name, String phone, String email){
        Person p = new Person(name);
        p.setMobile(phone);
        p.setEmail(email);
        return p;
    }
    
    
    /* -- Enable for testing purpose --*/
    @Bean
    public CommandLineRunner demo(PersonRepository repo){
        return (args) -> {
            repo.save(newPerson("Peter", "123", "Peter@gmail.com"));
            repo.save(newPerson("Paul", "456", "Paul@outlook.com"));
            repo.save(newPerson("Mary", "789", "Mary@facebook.com"));
            
            log.info("==== List All =====");
            for (Person p :repo.findAll()){
                log.info(p.toString());
            }
            
            log.info("==== Find Rabbit =====");
            for (Person p :repo.findByName("Peter")){
                log.info(p.toString());
            }
        };
    }
    
}
