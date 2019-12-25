package com.hmq.test;


import com.hmq.WebApplication;
import com.hmq.service.SpringRetryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
@Slf4j
public class SpringRetryServiceTest {

    @Autowired
    private SpringRetryService springRetryService;

    @Test
    public void retryTest(){
        int count = springRetryService.retry(-1);
        System.out.println("库存为 ：" + count);
    }
}
