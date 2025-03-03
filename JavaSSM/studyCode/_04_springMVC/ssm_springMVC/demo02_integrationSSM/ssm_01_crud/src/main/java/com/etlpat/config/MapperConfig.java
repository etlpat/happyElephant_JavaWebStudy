package com.etlpat.config;

import com.etlpat.mapper.StudentMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.io.InputStream;


@Configuration
@ComponentScan("com.etlpat.mapper")
public class MapperConfig {
    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }

    @Bean
    public StudentMapper studentMapper(SqlSessionFactory sqlSessionFactory){
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        return mapper;
    }
}


