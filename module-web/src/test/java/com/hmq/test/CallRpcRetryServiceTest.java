package com.hmq.test;


import com.hmq.WebApplication;
import com.hmq.service.CallRpcRetryService;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
@Slf4j
public class CallRpcRetryServiceTest {

    @Autowired
    private CallRpcRetryService callRpcRetryService;

    @Test
    public void retryTest(){
        int count = callRpcRetryService.retry(-1);
        System.out.println("库存为 ：" + count);
    }
}
