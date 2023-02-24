package icu.liuwisdom.message.product.workqueue;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 工作队列消息模型
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-07 20:35
 */

public class WorkQueueTest {
    public static void main(String[] args) throws IOException, TimeoutException {
        // 创建连接
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("203.57.254.215");
        factory.setPort(5672);
        factory.setVirtualHost("/message");
        factory.setUsername("ldb");
        factory.setPassword("root");
        Connection connection = factory.newConnection();
        // 创建频道
        Channel channel = connection.createChannel();
        // 创建队列
        channel.queueDeclare("work_queue", true, false, false, null);
        for (int i = 0; i < 10; i++) {
            String msg = "Hello world Rabbit Mq" + (i + 1);
            // 发送消息
            channel.basicPublish("", "work_queue", null, msg.getBytes());
        }

        // 释放资源
        channel.close();
        connection.close();
    }
}
