package com.ydh.redsheep.sharding;

import com.ydh.redsheep.sharding.mapper.OrderMapper;
import com.ydh.redsheep.sharding.pojo.TOrder;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.Random;

@SpringBootTest
public class TOrderTest {

    @Resource
    private OrderMapper orderMapper;

    @Test
    public void curd() {
        Random random = new Random();
        for (int i = 0; i <100; i++) {
            int companyId = random.nextInt(10);
            TOrder TOrder = new TOrder();
            TOrder.setCompanyId(companyId);
            TOrder.setPositionId(3242342);
            TOrder.setUserId(2222);
            TOrder.setPublishUserId(1111);
            TOrder.setResumeType(1);
            TOrder.setStatus("AUTO");
            TOrder.setCreateTime(LocalDateTime.now());
            TOrder.setOperateTime(LocalDateTime.now());
            TOrder.setWorkYear("2");
            TOrder.setName("lagou");
            TOrder.setPositionName("Java");
            TOrder.setResumeId(23233);
            orderMapper.insert(TOrder);
        }
    }

}
