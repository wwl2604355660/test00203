package com.mybatis;

import com.mybatis.mapper.StudentMapper;
import com.mybatis.utils.SqlSessionUtils;
import org.apache.ibatis.session.SqlSession;

/**
 * @author wwl
 * @create 2023-06-11 22:19
 */
public class Main {

    public static void main(String[] args) {
        SqlSession sqlSession = SqlSessionUtils.getSqlSession();
        StudentMapper studentMapper = sqlSession.getMapper(StudentMapper.class);

    }

}
