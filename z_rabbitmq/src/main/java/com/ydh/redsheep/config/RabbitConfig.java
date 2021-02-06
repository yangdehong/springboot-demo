package com.ydh.redsheep.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

@ComponentScan("com.ydh.redsheep.comsumer")
@EnableRabbit
@Configuration
public class RabbitConfig {

    /************************** dlx ***************************/
    @Bean
    public Queue queueDlx() {
        Queue queue = new Queue("queue.dlx", true, false, false, null);
        return queue;
    }
    /**
     * 死信交换器 * @return
     */
    @Bean
    public Exchange exchangeDlx() {
        DirectExchange exchange = new DirectExchange("ex.dlx", true, false, null);
        return exchange;
    }
    /**
     * 死信交换器绑定死信队列 * @return
     */
    @Bean
    public Binding bindingDlx() {
        return BindingBuilder.bind(queueDlx()).to(exchangeDlx()).with("key.dlx").noargs();
    }

    @Bean
    public Queue queueBiz() {
        Map<String, Object> props = new HashMap<>();
        // 消息的生存时间 10s
        props.put("x-message-ttl", 10000);
        // 设置该队列所关联的死信交换器(当队列消息TTL到期后依然没有消费，则加入死信队列)
        props.put("x-dead-letter-exchange", "ex.dlx");
        // 设置该队列所关联的死信交换器的routingKey，如果没有特殊指定，使用原队列的routingKey
        props.put("x-dead-letter-routing-key", "key.dlx");
        Queue queue = new Queue("queue.biz", true, false, false, props);
        return queue;
    }
    @Bean
    public Exchange exchangeBiz() {
        DirectExchange exchange = new DirectExchange("ex.biz", true, false, null);
        return exchange;
    }
    @Bean
    public Binding bindingBiz() {
        return BindingBuilder.bind(queueBiz()).to(exchangeBiz()).with("key.biz").noargs();
    }



    /************************** ttl ***************************/
    @Bean
    public Queue queueTTL() {
        Map<String, Object> props = new HashMap<>();
        // 对于该队列中的消息，设置都等待10s
        props.put("x-message-ttl", 10000);
        // 队列设置30s
//        props.put("x-expires", 30 * 1000);
        Queue queue = new Queue("queue.ttl", false, false, false, props);
        return queue;
    }
    @Bean
    public Exchange exchangeTTL() {
        DirectExchange exchange = new DirectExchange("ex.ttl", false, false);
        return exchange;
    }
    @Bean
    public Binding bindingTTL() {
        return BindingBuilder.bind(queueTTL()).to(exchangeTTL()).with("key.ttl").noargs();
    }

    @Bean
    public Queue queueWaiting() {
        Queue queue = new Queue("queue.ttl-waiting", false, false, false, null);
        return queue;
    }
    /**
     * 该交换器使用的时候，需要给每个消息设置有效期 * @return
     */
    @Bean
    public Exchange exchangeWaiting() {
        DirectExchange exchange = new DirectExchange("ex.ttl-waiting", false, false);
        return exchange;
    }
    @Bean
    public Binding bindingWaiting() {
        return BindingBuilder.bind(queueWaiting()).to(exchangeWaiting()).with("key.ttl-waiting").noargs();
    }

    /************************** message ***************************/


    @Bean
    public Queue queue() {
        return new Queue("queue.boot", false, false, false, null);
    }

    @Bean
    public Exchange exchange() {
        return new TopicExchange("ex.boot", false, false, null);
    }


    @Bean
    public Binding binding() {
        return new Binding("queue.boot", Binding.DestinationType.QUEUE, "ex.boot", "key.boot",
                null);
    }

}
