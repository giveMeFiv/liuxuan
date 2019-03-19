package com.example.demo.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
	 // 测试一对一
    @Bean
    public Queue helloQueue() {
        return new Queue("hello");
    }

    @Bean
    public Queue fooQueue() {
        return new Queue("foo");
}
    @Bean
    public Queue multimapQueue1() {
        return new Queue("OneToMany");
    }
 // 测试多对多
    @Bean
    public Queue multimapQueue3() {
        return new Queue("manyToMany");
    }
    @Bean
    public Queue entityQueue() {
        return new Queue("entity");
    }
}
