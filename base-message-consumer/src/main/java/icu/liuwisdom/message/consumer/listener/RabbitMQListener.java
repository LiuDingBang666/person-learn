package icu.liuwisdom.message.consumer.listener;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * MQ Listener
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-08 14:33
 */
@Component
public class RabbitMQListener {

    /**
     * 主题模式监听
     *
     * @param message
     * @author LDB
     * @date 2023-01-08
     **/
    @RabbitListener(queues = "topic_queue1")
    public void listenerListener(Message message) {
        System.out.println(message);
    }
}
