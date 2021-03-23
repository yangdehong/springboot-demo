package com.ydh.redsheep.zrocketmq.listener;

import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.annotation.RocketMQTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionListener;
import org.apache.rocketmq.spring.core.RocketMQLocalTransactionState;
import org.apache.rocketmq.spring.support.RocketMQHeaders;
import org.springframework.messaging.Message;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RocketMQTransactionListener(txProducerGroup = "txGroup")
public class TxRocketListener implements RocketMQLocalTransactionListener {

    private static Map<String, RocketMQLocalTransactionState> STAMP_MAP = new HashMap<>();

    /**
     * 执行业务逻辑
     * @param message
     * @param o
     * @return
     */
    @Override
    public RocketMQLocalTransactionState executeLocalTransaction(Message message, Object o) {
        String txId = (String) message.getHeaders().get(RocketMQHeaders.TRANSACTION_ID);
        try {
            log.info("执行业务");
            Thread.sleep(1000);
            STAMP_MAP.put(txId, RocketMQLocalTransactionState.COMMIT);
            return RocketMQLocalTransactionState.COMMIT;
        } catch (Exception e) {
            e.printStackTrace();
        }
        STAMP_MAP.put(txId, RocketMQLocalTransactionState.ROLLBACK);
        return RocketMQLocalTransactionState.ROLLBACK;
    }

    /**
     * 执行回查
     * @param message
     * @return
     */
    @Override
    public RocketMQLocalTransactionState checkLocalTransaction(Message message) {
        String txId = (String) message.getHeaders().get(RocketMQHeaders.TRANSACTION_ID);
        log.info("回查消息->txId={}，state={}", txId, STAMP_MAP.get(txId));
        return STAMP_MAP.get(txId);
    }
}
