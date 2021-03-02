package io.am.githubactionsdemo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.Timed;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class HelloWorldControllerTest {

    @Autowired
    HelloWorldController controller;

    @Test
    @Timed(millis = 500)
    void sayHelloWorld() {
        ResponseEntity<String> entity = controller.sayHelloWorld();
        assertEquals(HttpStatus.OK, entity.getStatusCode());
        assertEquals("Hello World", entity.getBody());
    }
}