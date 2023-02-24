package icu.liuwisdom.message.consumer.listener;

import org.springframework.stereotype.Component;

/**
 * QosListener 消费限流
 * 1、确保ack为手动确认
 * 2、配置属性
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-08 14:33
 */
@Component
public class QosListener {

    /*@RabbitListener(queues = "direct_queue")
    public void listenerMsg(Channel channel, Message message) throws IOException {
        long tag = message.getMessageProperties().getDeliveryTag();
        // 输出消息
        String msg = new String(message.getBody());
        // 处理逻辑
        System.out.println(msg);
        // 确认消息
        channel.basicAck(tag, true);
    }*/
}
