package com.example.doublesourse;

import com.example.doublesourse.model.Student;
import com.example.doublesourse.service.StudentService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class DoublesourseApplicationTests {

    @Autowired
    StudentService studentService;

    @Test
    void contextLoads() {
    }

    @Test
    void Test1(){
        List<Student> allStudents = studentService.getAllStudents();
        System.out.println(allStudents);
    }

}
