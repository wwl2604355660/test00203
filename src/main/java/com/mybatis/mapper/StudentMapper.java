package com.mybatis.mapper;

import com.mybatis.pojo.Student;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface StudentMapper {

    Student selectStudentById(@Param("sId") Integer sId);

    List<Student> selectStudentByLike(@Param("sName") String sName);

    Student selectStudentByNameAndAddress(@Param("sName") String sName,@Param("sAddress") String sAddress);
}
