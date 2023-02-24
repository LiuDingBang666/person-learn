package icu.liuwisdom.message.product.topic;

import com.rabbitmq.client.BuiltinExchangeType;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * 主题消息模型
 * exchange --> routerkey --> queue-exchange-routerkey --> queue
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-07 20:35
 */

public class TopicTest {
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
        // 创建交换机
        //     DIRECT("direct") 定向, FANOUT("fanout") 广播, TOPIC("topic") 通配符, HEADERS("headers") 使用较少;
        // 交换机名称 类型 是否持久化 是否自动删除 内部使用，一般false 参数列表
        String exchangeName = "test_topic";
        channel.exchangeDeclare(exchangeName, BuiltinExchangeType.TOPIC, true, true, false, null);
        String queue1 = "test_topic_queue1";
        String queue2 = "test_topic_queue2";
        // 创建队列 持久化 独占 自动删除 队列参数
        channel.queueDeclare(queue1, true, false, false, null);
        channel.queueDeclare(queue2, true, false, false, null);
        // 绑定队列到交换机上 交换机-->队列
        // 队列名称 交换机名称 路由键 配置参数
        // router名称 系统名称.系统级别
        //  error 存数据库 order 存数据库
        channel.queueBind(queue1, exchangeName, "#.error");
        channel.queueBind(queue1, exchangeName, "order.*");
        channel.queueBind(queue2, exchangeName, "*.*");
        // 发送消息
        String key = "a.a";
        channel.basicPublish(exchangeName, key, null, (key + "==> Hello Router Model").getBytes());
        // 释放资源
        channel.close();
        connection.close();
    }
}
