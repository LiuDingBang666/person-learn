/*
package icu.liuwisdom.message.product.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

*/
/**
 * RabbitMQConfig
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-08 11:52
 * <p>
 * 交换机名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 队列名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 交换机
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 队列
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 交换机和队列的绑定关系
 * 交换机-队列-路由键
 * @author LDB
 * @date 2023-01-08 11:58
 * @version 1.0
 * <p>
 * 路由队列
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 路由交换机
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 死信交换机
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 队列名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 声明死信交换机
 * 声明正常交换机和队列
 * 声明死心交换机和队列
 * @return org.springframework.amqp.core.Exchange
 * @author LDB
 * @date 2023-01-08
 * <p>
 * 交换机名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 队列名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 交换机
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 队列
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 交换机和队列的绑定关系
 * 交换机-队列-路由键
 * @author LDB
 * @date 2023-01-08 11:58
 * @version 1.0
 * <p>
 * 路由队列
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 路由交换机
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 死信交换机
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 队列名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 声明死信交换机
 * 声明正常交换机和队列
 * 声明死心交换机和队列
 * @return org.springframework.amqp.core.Exchange
 * @author LDB
 * @date 2023-01-08
 * <p>
 * 交换机名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 队列名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 交换机
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 队列
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 交换机和队列的绑定关系
 * 交换机-队列-路由键
 * @author LDB
 * @date 2023-01-08 11:58
 * @version 1.0
 * <p>
 * 路由队列
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 路由交换机
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 死信交换机
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 队列名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 声明死信交换机
 * 声明正常交换机和队列
 * 声明死心交换机和队列
 * @return org.springframework.amqp.core.Exchange
 * @author LDB
 * @date 2023-01-08
 * <p>
 * 交换机名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 队列名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 交换机
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 队列
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 交换机和队列的绑定关系
 * 交换机-队列-路由键
 * @author LDB
 * @date 2023-01-08 11:58
 * @version 1.0
 * <p>
 * 路由队列
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 路由交换机
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 死信交换机
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 队列名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 声明死信交换机
 * 声明正常交换机和队列
 * 声明死心交换机和队列
 * @return org.springframework.amqp.core.Exchange
 * @author LDB
 * @date 2023-01-08
 * <p>
 * 交换机名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 队列名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 交换机
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 队列
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 交换机和队列的绑定关系
 * 交换机-队列-路由键
 * @author LDB
 * @date 2023-01-08 11:58
 * @version 1.0
 * <p>
 * 路由队列
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 路由交换机
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 死信交换机
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 队列名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 声明死信交换机
 * 声明正常交换机和队列
 * 声明死心交换机和队列
 * @return org.springframework.amqp.core.Exchange
 * @author LDB
 * @date 2023-01-08
 * <p>
 * 交换机名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 队列名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 交换机
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 队列
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 交换机和队列的绑定关系
 * 交换机-队列-路由键
 * @author LDB
 * @date 2023-01-08 11:58
 * @version 1.0
 * <p>
 * 路由队列
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 路由交换机
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 死信交换机
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 队列名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 声明死信交换机
 * 声明正常交换机和队列
 * 声明死心交换机和队列
 * @return org.springframework.amqp.core.Exchange
 * @author LDB
 * @date 2023-01-08
 * <p>
 * 交换机名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 队列名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 交换机
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 队列
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 交换机和队列的绑定关系
 * 交换机-队列-路由键
 * @author LDB
 * @date 2023-01-08 11:58
 * @version 1.0
 * <p>
 * 路由队列
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 路由交换机
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 死信交换机
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 队列名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 声明死信交换机
 * 声明正常交换机和队列
 * 声明死心交换机和队列
 * @return org.springframework.amqp.core.Exchange
 * @author LDB
 * @date 2023-01-08
 * <p>
 * 交换机名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 队列名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 交换机
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 队列
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 交换机和队列的绑定关系
 * 交换机-队列-路由键
 * @author LDB
 * @date 2023-01-08 11:58
 * @version 1.0
 * <p>
 * 路由队列
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 路由交换机
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 死信交换机
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 队列名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 声明死信交换机
 * 声明正常交换机和队列
 * 声明死心交换机和队列
 * @return org.springframework.amqp.core.Exchange
 * @author LDB
 * @date 2023-01-08
 * <p>
 * 交换机名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 队列名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 交换机
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 队列
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 交换机和队列的绑定关系
 * 交换机-队列-路由键
 * @author LDB
 * @date 2023-01-08 11:58
 * @version 1.0
 * <p>
 * 路由队列
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 路由交换机
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 死信交换机
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 队列名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 声明死信交换机
 * 声明正常交换机和队列
 * 声明死心交换机和队列
 * @return org.springframework.amqp.core.Exchange
 * @author LDB
 * @date 2023-01-08
 * <p>
 * 交换机名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 队列名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 交换机
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 队列
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 交换机和队列的绑定关系
 * 交换机-队列-路由键
 * @author LDB
 * @date 2023-01-08 11:58
 * @version 1.0
 * <p>
 * 路由队列
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 路由交换机
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 死信交换机
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 * <p>
 * 队列名称
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 * <p>
 * 声明死信交换机
 * 声明正常交换机和队列
 * 声明死心交换机和队列
 * @return org.springframework.amqp.core.Exchange
 * @author LDB
 * @date 2023-01-08
 **//*

@Configuration
public class RabbitMQConfig {
    */
/**
 * 交换机名称
 *
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 *//*

    public static final String EXCHANGE_NAME = "topic_exchange";
    */
/**
 * 队列名称
 *
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 *//*


    public static final String QUEUE_NAME = "topic_queue1";


    */
/**
 * 交换机
 *
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 *//*

    @Bean("messageExchange")
    public Exchange messageExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }

    */
/**
 * 队列
 *
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 *//*

    @Bean("msgQueue")
    public Queue msgQueue() {
        return QueueBuilder.durable(QUEUE_NAME).build();
    }

    */
/**
 * 交换机和队列的绑定关系
 * 交换机-队列-路由键
 *
 * @author LDB
 * @date 2023-01-08 11:58
 * @version 1.0
 *//*

    @Bean
    public Binding bindQueue(@Qualifier("msgQueue") Queue queue, @Qualifier("messageExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("topic.#").noargs();
    }

    */
/**
 * 路由队列
 *
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 *//*


    public static final String DIRECT_QUEUE_NAME = "direct_queue";

    */
/**
 * 路由交换机
 *
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 *//*


    public static final String DIRECT_EXCHANGE_NAME = "direct_exchange";

    @Bean("directQueue")
    public Queue directQueue() {
        // todo 设置队列消息有效时间
        return QueueBuilder.durable(DIRECT_QUEUE_NAME).maxLength(5).ttl(10000).build();
    }

    @Bean("directExchange")
    public Exchange directExchange() {
        return ExchangeBuilder.directExchange(DIRECT_EXCHANGE_NAME).durable(true).build();
    }

    @Bean
    public Binding directBinding(@Qualifier("directQueue") Queue queue, @Qualifier("directExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("confirm").noargs();
    }


    public static final String TOPIC_QUEUE_NAME = "topic_queue";

    public static final String TOPIC_EXCHANGE_NAME = "to_dead_topic_exchange";
    public static final String TOPIC_ROUTER_KEY = "aa.#";


    @Bean("topicQueue")
    public Queue topicQueue() {
        // todo 设置队列消息有效时间
        return QueueBuilder.durable(TOPIC_QUEUE_NAME)
                .deadLetterExchange(DEAD_QUEUE_NAME)
                .deadLetterRoutingKey(DEAD_ROUTING_KEY)
                .maxLength(100)
                .ttl(20000).build();
        // 消息超时时间
//   .withArgument("x-message-ttl", 10000)
        // 死信交换机
//  .withArgument("x-dead-letter-exchange", DEAD_EXCHANGE_NAME)
//  // 死信交换机路由key
//  .withArgument("x-dead-letter-routing-key", DEAD_ROUTING_KEY)
    }

    @Bean("topicExchange")
    public Exchange topicExchange() {
        return ExchangeBuilder.topicExchange(TOPIC_EXCHANGE_NAME).durable(true).build();
    }

    @Bean
    public Binding topicBinding2(@Qualifier("topicQueue") Queue queue, @Qualifier("topicExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(TOPIC_ROUTER_KEY).noargs();
    }


    */
/**
 * 死信交换机
 *
 * @author LDB
 * @date 2023-01-08 14:57
 * @version 1.0
 *//*

    public static final String DEAD_EXCHANGE_NAME = "dead_exchange";


    */
/**
 * 队列名称
 *
 * @author LDB
 * @date 2023-01-08 11:57
 * @version 1.0
 *//*

    public static final String DEAD_QUEUE_NAME = "dead_queue";
    public static final String DEAD_ROUTING_KEY = "dlx.#";

    */
/**
 * 声明死信交换机
 * 声明正常交换机和队列
 * 声明死心交换机和队列
 *
 * @return org.springframework.amqp.core.Exchange
 * @author LDB
 * @date 2023-01-08
 **//*

    @Bean("deadExchange")
    public Exchange deadExchange() {
        return ExchangeBuilder.topicExchange(DEAD_EXCHANGE_NAME).durable(true).build();
    }

    @Bean("deadQueue")
    public Queue deadQueue() {
        // todo 设置队列消息有效时间
        return QueueBuilder.durable(DEAD_QUEUE_NAME).build();
    }

    @Bean
    public Binding deadBinding(@Qualifier("deadQueue") Queue queue, @Qualifier("deadExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(DEAD_ROUTING_KEY).noargs();
    }

}
*/
