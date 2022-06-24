package com.plateer.ec1.db;

import com.plateer.ec1.promotion.mapper.TestMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DBTest {
    @Autowired
    private TestMapper testMapper;

    @Test
    @DisplayName("1. DB 연동 테스트")
    public void test() {
        testMapper.testMapper();
    }

}
