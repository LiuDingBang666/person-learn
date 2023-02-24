package icu.liuwisdom.message.product.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 延迟队列
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-08 11:52
 */
@Configuration
public class LazyMQConfig {

    /**
     * 死信交换机
     *
     * @author LDB
     * @date 2023-01-08 14:57
     * @version 1.0
     */
    public static final String DEAD_EXCHANGE_NAME = "lazy_dead_exchange";
    /**
     * 队列名称
     *
     * @author LDB
     * @date 2023-01-08 11:57
     * @version 1.0
     */
    public static final String DEAD_QUEUE_NAME = "lazy_dead_queue";
    public static final String DEAD_ROUTING_KEY = "lazy.#";

    /**
     * 声明死信交换机
     * 声明正常交换机和队列
     * 声明死心交换机和队列
     *
     * @return org.springframework.amqp.core.Exchange
     * @author LDB
     * @date 2023-01-08
     **/
    @Bean("lazyDeadExchange")
    public Exchange lazyDeadExchange() {
        return ExchangeBuilder.topicExchange(DEAD_EXCHANGE_NAME).durable(true).build();
    }

    @Bean("lazyDeadQueue")
    public Queue lazyDeadQueue() {
        // todo 设置队列消息有效时间
        return QueueBuilder.durable(DEAD_QUEUE_NAME).build();
    }

    @Bean
    public Binding lazyDeadBinding(@Qualifier("lazyDeadQueue") Queue queue, @Qualifier("lazyDeadExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(DEAD_ROUTING_KEY).noargs();
    }

    /**
     * 交换机名称
     *
     * @author LDB
     * @date 2023-01-08 11:57
     * @version 1.0
     */
    public static final String EXCHANGE_NAME = "lazy_topic_exchange";
    /**
     * 队列名称
     *
     * @author LDB
     * @date 2023-01-08 11:57
     * @version 1.0
     */

    public static final String QUEUE_NAME = "lazy_topic_queue";


    /**
     * 交换机
     *
     * @author LDB
     * @date 2023-01-08 11:57
     * @version 1.0
     */
    @Bean("lazyMessageExchange")
    public Exchange lazyMessageExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_NAME).durable(true).build();
    }

    /**
     * 队列
     *
     * @author LDB
     * @date 2023-01-08 11:57
     * @version 1.0
     */
    @Bean("lazyMsgQueue")
    public Queue lazyMsgQueue() {
        return QueueBuilder.durable(QUEUE_NAME)
                .deadLetterExchange(DEAD_EXCHANGE_NAME)
                .deadLetterRoutingKey("lazy.cacel")
                .ttl(10000).build();
    }

    /**
     * 交换机和队列的绑定关系
     * 交换机-队列-路由键
     *
     * @author LDB
     * @date 2023-01-08 11:58
     * @version 1.0
     */
    @Bean
    public Binding lazyBindQueue(@Qualifier("lazyMsgQueue") Queue queue, @Qualifier("lazyMessageExchange") Exchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with("lazytopic.#").noargs();
    }


}
