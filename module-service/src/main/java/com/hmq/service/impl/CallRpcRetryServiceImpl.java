package com.hmq.service.impl;

import com.hmq.service.CallRpcRetryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.remoting.RemoteAccessException;
import org.springframework.retry.annotation.Backoff;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

import java.time.LocalTime;

@Slf4j
@Service
public class CallRpcRetryServiceImpl implements CallRpcRetryService {

    private final int totalNum = 100000;

    /**
     * 1、@EnableRetry 主类开启重试
     * 2、@Retryable @Recover 两个方法返回值必须一致
     */

    @Override
    @Retryable(value = Exception.class, maxAttempts = 3, backoff = @Backoff(delay = 2000L, multiplier = 1.5))
    public int retry(int num) {
        log.info("减库存开始" + LocalTime.now());
        try {
            int i = 1 / 0;
        } catch (Exception e) {
            log.error("illegal");
        }
        if (num <= 0) {
            throw new IllegalArgumentException("数量不对");
        }
        log.info("减库存执行结束" + LocalTime.now());
        return totalNum - num;
    }

    @Recover
    public int recover(Exception e) {
        log.warn("减库存失败！！！" + LocalTime.now());
        return 1000;
    }
}
