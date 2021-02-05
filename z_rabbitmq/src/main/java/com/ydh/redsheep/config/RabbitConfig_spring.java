//package com.ydh.redsheep.config;
//
//import org.springframework.amqp.core.*;
//import org.springframework.amqp.rabbit.annotation.EnableRabbit;
//import org.springframework.amqp.rabbit.config.SimpleRabbitListenerContainerFactory;
//import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
//import org.springframework.amqp.rabbit.connection.ConnectionFactory;
//import org.springframework.amqp.rabbit.core.RabbitAdmin;
//import org.springframework.amqp.rabbit.core.RabbitTemplate;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.ComponentScan;
//import org.springframework.context.annotation.Configuration;
//
//import java.net.URI;
//
//@ComponentScan("com.ydh.redsheep.comsumer")
//@Configuration
//@EnableRabbit  // xml中也可以使用<rabbit:annotation-driven />  启用@RabbitListener注解
//public class RabbitConfig_spring {
//
//    // 连接工厂
//    @Bean
//    public ConnectionFactory connectionFactory() {
//        ConnectionFactory factory = new CachingConnectionFactory(URI.create("amqp://root:123456@172.16.131.16:5672/%2f"));
//        return factory;
//    }
//
//    // RabbitTemplate
//    @Bean
//    @Autowired
//    public RabbitTemplate rabbitTemplate(ConnectionFactory factory) {
//        RabbitTemplate rabbitTemplate = new RabbitTemplate(factory);
//        return rabbitTemplate;
//    }
//
//    // RabbitAdmin
//    @Bean
//    @Autowired
//    public RabbitAdmin rabbitAdmin(ConnectionFactory factory) {
//        RabbitAdmin rabbitAdmin = new RabbitAdmin(factory);
//        return rabbitAdmin;
//    }
//
//    // Queue
//    @Bean
//    public Queue queue() {
//        final Queue queue = QueueBuilder.nonDurable("queue.anno").build();
//        return queue;
//    }
//
//    // Exchange
//    @Bean
//    public Exchange exchange() {
//        final FanoutExchange fanoutExchange = new FanoutExchange("ex.anno.fanout", false, false, null);
//        return fanoutExchange;
//    }
//
//    // Binding
//    @Bean
//    @Autowired
//    public Binding binding(Queue queue, Exchange exchange) {
//        // 创建一个绑定，不指定绑定的参数
//        final Binding binding = BindingBuilder.bind(queue).to(exchange).with("key.anno").noargs();
//        return binding;
//    }
//
//    @Bean("rabbitListenerContainerFactory")
//    @Autowired
//    public SimpleRabbitListenerContainerFactory simpleRabbitListenerContainerFactory(ConnectionFactory connectionFactory) {
//        SimpleRabbitListenerContainerFactory factory = new SimpleRabbitListenerContainerFactory();
//        factory.setConnectionFactory(connectionFactory);
//        factory.setAcknowledgeMode(AcknowledgeMode.AUTO);
////        factory.setAcknowledgeMode(AcknowledgeMode.MANUAL);
////        factory.setAcknowledgeMode(AcknowledgeMode.NONE);
////        factory.setConcurrentConsumers(10);
////        factory.setMaxConcurrentConsumers(15);
//        // 按照批次消费消息
////        factory.setBatchSize(10);
//
//        return factory;
//    }
//}
