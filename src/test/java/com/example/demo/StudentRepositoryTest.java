package com.example.demo;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.Assertions.*;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepository;

    @BeforeEach
    void setup() {
        studentRepository.save(Student.builder()
                .firstname("Hippo")
                .lastname("Hippo")
                .build());

        studentRepository.save(Student.builder()
                .firstname("Hippo")
                .lastname("Hippy")
                .build());
    }

    @Test
    void shouldFindSomeStudent() {
        assertThat(studentRepository.findAll()).isNotEmpty();
    }
}