package com.hmq.common.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Map;

/**
 * Package: com.hmq.common.util
 * Title: IdGenerator
 * Description: (用一句话描述该文件做什么)
 * Author: gaolei10
 * Date: 2019/9/30 10:31
 * version: v1.0
 */
@Slf4j
@Component
public class IdGenerator {


//    private Map<String, Sequence> sequenceMap;
    @Resource
    private Sequence sequence;
    @Resource
    private SnowFlake snowFlake;

//    public void setDefaultSequence(Sequence defaultSequence) {
//        this.defaultSequence = defaultSequence;
//    }

//    public void setSequenceMap(Map<String, Sequence> sequenceMap) {
//        this.sequenceMap = sequenceMap;
//    }
    /**
     * 如果没有在map中指定，则使用默认的。 <br/>
     * 如果没有默认的，则出错。<br/>
     * 没有写入操作，并发无问题。<br/>
     * @param name sequence名字
     * @return
     */
    public long generatorSequenceId(String name) {
//        Sequence sequence = null;
//        if (sequenceMap != null) {
//            sequence = sequenceMap.get(name);
//        }
        if (sequence == null) {
            if (sequence != null) {
                return sequence.get(name);
            } else {
                throw new RuntimeException("sequence " + name + " undefined!");
            }
        }
        return sequence.get(name);
    }

    public long generatorSnowFlakeId(){
        return snowFlake.nextId();
    }
}
