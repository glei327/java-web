package com.hmq.common.util;

import java.util.Map;

/**
 * Package: util
 * Title: SequenceUtil
 * Description: (用一句话描述该文件做什么)
 * Author: gaolei10
 * Date: 2019/9/27 15:23
 * version: v1.0
 */
public class SequenceUtil {
    private Map<String, Sequence> sequenceMap;
    private Sequence defaultSequence;

    public void setDefaultSequence(Sequence defaultSequence) {
        this.defaultSequence = defaultSequence;
    }

    public void setSequenceMap(Map<String, Sequence> sequenceMap) {
        this.sequenceMap = sequenceMap;
    }

    /**
     * 如果没有在map中指定，则使用默认的。 <br/>
     * 如果没有默认的，则出错。<br/>
     * 没有写入操作，并发无问题。<br/>
     * @param name sequence名字
     * @return
     */
    public long get(String name) {
        Sequence sequence = null;
        if (sequenceMap != null) {
            sequence = sequenceMap.get(name);
        }
        if (sequence == null) {
            if (defaultSequence != null) {
                return defaultSequence.get(name);
            } else {
                throw new RuntimeException("sequence " + name + " undefined!");
            }
        }
        return sequence.get(name);
    }
}
