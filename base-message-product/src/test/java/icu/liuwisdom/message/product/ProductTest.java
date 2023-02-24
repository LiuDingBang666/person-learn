/*
package icu.liuwisdom.message.product;

import icu.liuwisdom.message.product.config.LazyMQConfig;
import icu.liuwisdom.message.product.config.RabbitMQConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

*/
/**
 * junit单元测试
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-08 12:02
 * <p>
 * 回退模式：当消息发送给exchange后，exchange路由到queue失败时才会执行 returncallback
 * 步骤
 * 1.开启回退模式 publish-returns true
 * 2.设置 returncallback
 * 3.设置exchange处理消息的模式
 * 1、如果消息没有路由到queue，则丢弃消息（默认）
 * 2、如果消息没有路由到queue，返回给消息发送方returncallback
 * @author LDB
 * @date 2023-01-08
 * <p>
 * 回退模式：当消息发送给exchange后，exchange路由到queue失败时才会执行 returncallback
 * 步骤
 * 1.开启回退模式 publish-returns true
 * 2.设置 returncallback
 * 3.设置exchange处理消息的模式
 * 1、如果消息没有路由到queue，则丢弃消息（默认）
 * 2、如果消息没有路由到queue，返回给消息发送方returncallback
 * @author LDB
 * @date 2023-01-08
 * <p>
 * 回退模式：当消息发送给exchange后，exchange路由到queue失败时才会执行 returncallback
 * 步骤
 * 1.开启回退模式 publish-returns true
 * 2.设置 returncallback
 * 3.设置exchange处理消息的模式
 * 1、如果消息没有路由到queue，则丢弃消息（默认）
 * 2、如果消息没有路由到queue，返回给消息发送方returncallback
 * @author LDB
 * @date 2023-01-08
 * <p>
 * 回退模式：当消息发送给exchange后，exchange路由到queue失败时才会执行 returncallback
 * 步骤
 * 1.开启回退模式 publish-returns true
 * 2.设置 returncallback
 * 3.设置exchange处理消息的模式
 * 1、如果消息没有路由到queue，则丢弃消息（默认）
 * 2、如果消息没有路由到queue，返回给消息发送方returncallback
 * @author LDB
 * @date 2023-01-08
 * <p>
 * 回退模式：当消息发送给exchange后，exchange路由到queue失败时才会执行 returncallback
 * 步骤
 * 1.开启回退模式 publish-returns true
 * 2.设置 returncallback
 * 3.设置exchange处理消息的模式
 * 1、如果消息没有路由到queue，则丢弃消息（默认）
 * 2、如果消息没有路由到queue，返回给消息发送方returncallback
 * @author LDB
 * @date 2023-01-08
 * <p>
 * 回退模式：当消息发送给exchange后，exchange路由到queue失败时才会执行 returncallback
 * 步骤
 * 1.开启回退模式 publish-returns true
 * 2.设置 returncallback
 * 3.设置exchange处理消息的模式
 * 1、如果消息没有路由到queue，则丢弃消息（默认）
 * 2、如果消息没有路由到queue，返回给消息发送方returncallback
 * @author LDB
 * @date 2023-01-08
 * <p>
 * 回退模式：当消息发送给exchange后，exchange路由到queue失败时才会执行 returncallback
 * 步骤
 * 1.开启回退模式 publish-returns true
 * 2.设置 returncallback
 * 3.设置exchange处理消息的模式
 * 1、如果消息没有路由到queue，则丢弃消息（默认）
 * 2、如果消息没有路由到queue，返回给消息发送方returncallback
 * @author LDB
 * @date 2023-01-08
 * <p>
 * 回退模式：当消息发送给exchange后，exchange路由到queue失败时才会执行 returncallback
 * 步骤
 * 1.开启回退模式 publish-returns true
 * 2.设置 returncallback
 * 3.设置exchange处理消息的模式
 * 1、如果消息没有路由到queue，则丢弃消息（默认）
 * 2、如果消息没有路由到queue，返回给消息发送方returncallback
 * @author LDB
 * @date 2023-01-08
 * <p>
 * 回退模式：当消息发送给exchange后，exchange路由到queue失败时才会执行 returncallback
 * 步骤
 * 1.开启回退模式 publish-returns true
 * 2.设置 returncallback
 * 3.设置exchange处理消息的模式
 * 1、如果消息没有路由到queue，则丢弃消息（默认）
 * 2、如果消息没有路由到queue，返回给消息发送方returncallback
 * @author LDB
 * @date 2023-01-08
 * <p>
 * 回退模式：当消息发送给exchange后，exchange路由到queue失败时才会执行 returncallback
 * 步骤
 * 1.开启回退模式 publish-returns true
 * 2.设置 returncallback
 * 3.设置exchange处理消息的模式
 * 1、如果消息没有路由到queue，则丢弃消息（默认）
 * 2、如果消息没有路由到queue，返回给消息发送方returncallback
 * @author LDB
 * @date 2023-01-08
 **//*

@SpringBootTest
@RunWith(SpringRunner.class)
public class ProductTest {
    @Resource
    private RabbitTemplate template;

    @Test
    public void testSend() {
        template.convertAndSend(RabbitMQConfig.EXCHANGE_NAME, "topic.aaa", "hello mq");
    }

    @Test
    public void testConfirmSend() {
        // 回调数据 ack为true 接收成功 cause 原因
        template.setConfirmCallback((correlationData, ack, cause) -> {
            System.out.println("message confirm..");
            if (ack) {
                System.out.println("消息接收成功!!");
            } else {
                System.out.println("消息接收失败！！");
                System.out.println(cause);
                // todo  再次发送消息
            }
        });
        template.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE_NAME, "confirm", "hello ConfirmSend mq");
    }

    */
/**
 * 回退模式：当消息发送给exchange后，exchange路由到queue失败时才会执行 returncallback
 * 步骤
 * 1.开启回退模式 publish-returns true
 * 2.设置 returncallback
 * 3.设置exchange处理消息的模式
 * 1、如果消息没有路由到queue，则丢弃消息（默认）
 * 2、如果消息没有路由到queue，返回给消息发送方returncallback
 *
 * @author LDB
 * @date 2023-01-08
 **//*

    @Test
    public void testReturnSend() {
        // 设置交换机处理失败消息的模式
        // 当消息发送到queue失败时，将消息回传给发送者
        template.setMandatory(true);
        // 消息对象 失败错误码 错误信息 交换机 路由键
        template.setReturnCallback((message, i, s, s1, s2) -> {
            System.out.println(new String(message.getBody()));
            System.out.println("setReturnCallback");
            // todo 处理消息
        });
        template.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE_NAME, "confirm", "hello ConfirmSend mq");
    }


    @Test
    public void testTTL() {
        // 消息单独过期
        for (int i = 0; i < 20; i++) {
            template.convertAndSend(RabbitMQConfig.DIRECT_EXCHANGE_NAME, "confirm", ("ttl hello mq" + (i + 1)), message -> {
                // 消息后置处理对象,
                // todo 单独设置消息过期时间,
                // todo 如果多次设置了过期时间，以时间短的为准
                // 队列过期后会将所有消息全部移除
                // 消息过期后，只有消息在顶端的才会被判断移除
                message.getMessageProperties().setExpiration("50000");
                return message;
            });
        }
    }


    @Test
    public void testDLS() {
        for (int i = 0; i < 20; i++) {
            template.convertAndSend(RabbitMQConfig.TOPIC_EXCHANGE_NAME, "aa.aaa", ("我是可能死的消息哦" + (i + 1)));
        }
    }

}
*/
