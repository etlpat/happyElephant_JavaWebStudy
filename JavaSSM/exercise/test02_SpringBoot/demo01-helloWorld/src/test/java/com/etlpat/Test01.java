package com.etlpat;

import com.etlpat.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class Test01 {
    @Autowired
    User user;

    @Test
    public void test01() {
        System.out.println(user);
    }
}
