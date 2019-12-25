package com.hmq.service;

/**
 * @author gaolei10
 * @date 2019/12/25 09:16
 * @Describe GuavaRetryService
 */
public interface GuavaRetryService {

    boolean retry(int num) throws Exception;
}
