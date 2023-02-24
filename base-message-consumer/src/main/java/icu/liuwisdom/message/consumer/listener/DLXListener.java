package icu.liuwisdom.message.consumer.listener;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * DLXListener 死信测试
 * 手动签收
 * 1、设置手动签收
 * 2、实现新接口
 * 3、如果消息成功处理则调用 channel.basicack,否则 channel.basicnack
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-08 14:33
 */
@Component
public class DLXListener {
    /**
     * 监听
     *
     * @param message
     * @author LDB
     * @date 2023-01-08
     **/

    @RabbitListener(queues = "topic_queue")
    public void dlxListener(Message message, Channel channel) throws Exception {
        long tag = message.getMessageProperties().getDeliveryTag();
        // 接收消息
        try {
            String msg = new String(message.getBody());
            System.out.println(msg);
            channel.basicAck(tag, true);
        } catch (Exception e) {
            // 标签 是否签收 是否将消息重新放入队列
            channel.basicNack(tag, true, false);
        }
    }

}
