package icu.liuwisdom.admin.message.inteface;

/**
 * 消息模板接口
 *
 * @author LDB
 * @version 1.0
 * @date 2022-12-12 22:39
 */

public interface IMessagesTemplate<Message> extends IMessage<Message> {
    /**
     * 创建消息
     *
     * @param message
     * @return java.lang.Boolean
     * @author LDB
     * @date 2022-12-12
     **/
    Boolean createMessage(Message message);

}
