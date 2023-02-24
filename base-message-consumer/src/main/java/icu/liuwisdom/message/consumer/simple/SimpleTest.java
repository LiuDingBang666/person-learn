package icu.liuwisdom.message.consumer.simple;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 简单模型测试
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-08 9:23
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
        // 创建队列 队列名称 是否持久化 是否独占消息 是否自动删除 配置参数
        channel.queueDeclare("hello_queue", true, false, false, null);
        // 接收消息 - 默认消费者
        DefaultConsumer consumer = new DefaultConsumer(channel) {
            /**
             * 收到消息后自动执行该方法
             * @author LDB
             * @date 2023-01-08
             * @param consumerTag 消费者标签
             * @param envelope 获取一些信息 交换机 路由key
             * @param properties 配置信息
             * @param body 数据
             **/
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                System.out.println(consumerTag);
                System.out.println(envelope.getExchange());
                System.out.println(envelope.getRoutingKey());
                System.out.println(properties);
                System.out.println(new String(body));
                super.handleDelivery(consumerTag, envelope, properties, body);
            }
        };
        channel.basicConsume("hello_queue", true, consumer);
    }
}
