package com.example.doublesourse.mapper;

import com.example.doublesourse.model.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author weepppp 2022/7/14 15:38
 **/
@Mapper
public interface StudentMapper {

    @Select("select * from student")
    List<Student> getAllStudents();
}
