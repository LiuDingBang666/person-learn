package icu.liuwisdom.message.product;

import icu.liuwisdom.message.product.config.LazyMQConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

/**
 * junit单元测试
 *
 * @author LDB
 * @version 1.0
 * @date 2023-01-08 12:02
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class LazyTest {
    @Resource
    private RabbitTemplate template;

    @Test
    public void lazyDLS() {
        for (int i = 0; i < 20; i++) {
            template.convertAndSend(LazyMQConfig.EXCHANGE_NAME, "lazytopic.abc", ("我是延迟消息噢" + (i + 1)));
        }
    }
}
