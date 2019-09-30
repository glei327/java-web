package com.hmq.test;

import com.hmq.WebApplication;
import com.hmq.common.util.IdGenerator;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Package: com.hmq.test
 * Title: IdGeneratorTest
 * Description: (用一句话描述该文件做什么)
 * Author: gaolei10
 * Date: 2019/9/30 11:33
 * version: v1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = WebApplication.class)
@Slf4j
public class IdGeneratorTest {

    @Autowired
    private IdGenerator idGenerator;

    @Test
    public void testGeneratorSequenceId(){
        log.error("------generatorSequenceId:"+idGenerator.generatorSequenceId("T_ORDER"));
    }


    @Test
    public void testGgeneratorSnowFlakeId(){
        log.error("------generatorSnowFlakeId:"+idGenerator.generatorSnowFlakeId());
    }
}
