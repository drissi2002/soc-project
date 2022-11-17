package com.example.demo.repositories;

import com.example.demo.models.Gender;
import com.example.demo.models.Student;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@DataJpaTest
class StudentRepositoryTest {

    @Autowired
    private StudentRepository studentRepositoryUnderTest;

    @AfterEach
    void cleanStateAfterEachTest() {
        studentRepositoryUnderTest.deleteAll();
    }

    @Test
    void itShouldCheckWhenStudentEmailExists() {
        // given
        String email = "houcem@gmail.com";
        Student student = new Student(
                "houcem",
                email,
                Gender.MALE
        );
        studentRepositoryUnderTest.save(student);

        // when
        boolean expected = studentRepositoryUnderTest.selectExistsEmail(email);

        // then
        assertThat(expected).isTrue();
    }

    @Test
    void itShouldCheckWhenStudentEmailDoesNotExists() {
        // given
        String email = "houcem@gmail.com";

        // when
        boolean expected = studentRepositoryUnderTest.selectExistsEmail(email);

        // then
        assertThat(expected).isFalse();
    }
}