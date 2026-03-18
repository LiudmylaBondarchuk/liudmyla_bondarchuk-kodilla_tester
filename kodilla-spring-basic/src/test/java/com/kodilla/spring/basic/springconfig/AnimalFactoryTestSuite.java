package com.kodilla.spring.basic.springconfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import java.util.Arrays;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("AnimalFactory Tests")
class AnimalFactoryTestSuite {
    @Test
    @DisplayName("should create dog bean by name")
    void shouldCreateDogBeanByName() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        Dog dog = (Dog) context.getBean("createDog");
        assertEquals("Bark bark", dog.getVoice());
    }
    @Test
    @DisplayName("should create random animal")
    void shouldCreateRandomAnimal() {
        ApplicationContext context = new AnnotationConfigApplicationContext("com.kodilla.spring.basic");
        Animal animal = (Animal) context.getBean("randomAnimal");
        String voice = animal.getVoice();
        List<String> possibleVoices = Arrays.asList("Bark bark", "Meow meow", "Quack quack");
        assertTrue(possibleVoices.contains(voice));
    }
}
