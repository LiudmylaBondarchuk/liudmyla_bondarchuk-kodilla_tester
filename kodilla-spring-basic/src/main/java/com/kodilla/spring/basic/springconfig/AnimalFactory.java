package com.kodilla.spring.basic.springconfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import java.util.Random;
@Configuration
public class AnimalFactory {
    @Bean
    public Dog createDog() { return new Dog(); }
    @Bean
    public Animal randomAnimal() {
        Random generator = new Random();
        int chosen = generator.nextInt(3);
        if (chosen == 0) { return new Dog(); }
        else if (chosen == 1) { return new Cat(); }
        else { return new Duck(); }
    }
}
