package icu.liuwisdom.admin.message.inteface;

/**
 * 消息顶级接口
 *
 * @author LDB
 * @version 1.0
 * @date 2022-12-13 20:15
 */

public interface IMessage<Message> {
    /**
     * 发送消息
     *
     * @return java.lang.Boolean
     * @author LDB
     * @date 2022-12-12
     **/
    Boolean sendMessage();

    /**
     * 发送消息
     *
     * @param msg
     * @return java.lang.Boolean
     * @author LDB
     * @date 2022-12-13
     **/
    Boolean sendMessage(Message msg);
}
