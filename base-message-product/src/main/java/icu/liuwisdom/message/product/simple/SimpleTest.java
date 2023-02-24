package icu.liuwisdom.message.product.simple;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 简单消息模型
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-07 20:35
 */

public class SimpleTest {
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
        // 创建队列 队列名称 是否持久化消息 是否队列中只能有一种消息 是否自动删除队列 队列配置参数
        channel.queueDeclare("hello_queue", true, false, false, null);
        String msg = "Hello world Rabbit Mq";
        // 发送消息 交换机名称 队列名称 发布基础配置信息 发布消息内容
        channel.basicPublish("", "hello_queue", null, msg.getBytes());
        // 释放资源
        channel.close();
        connection.close();
    }
}
