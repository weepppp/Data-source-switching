package com.example.doublesourse.service;

import com.example.doublesourse.annotation.Ds;
import com.example.doublesourse.mapper.StudentMapper;
import com.example.doublesourse.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

/**
 * @author weepppp 2022/7/14 15:33
 **/
@Service
public class StudentService {

    @Autowired
    StudentMapper studentMapper;


    @Ds("slave")
    public List<Student> getAllStudents(){
        return studentMapper.getAllStudents();
    }
}
