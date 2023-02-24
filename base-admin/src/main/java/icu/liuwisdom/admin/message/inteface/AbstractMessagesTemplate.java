package icu.liuwisdom.admin.message.inteface;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 抽象消息模板类
 *
 * @author LDB
 * @version 1.0
 * @date 2022-12-12 22:39
 */
@Data
public abstract class AbstractMessagesTemplate<M> implements IMessagesTemplate<M> {
    /**
     * 模板名称
     *
     * @author LDB
     * @date 2022-12-12 22:48
     * @version 1.0
     */
    private String name = "default message template";
    /**
     * 创建时间
     *
     * @author LDB
     * @date 2022-12-12 22:48
     * @version 1.0
     */
    private LocalDateTime createTime;
    /**
     * 设置时间
     *
     * @author LDB
     * @date 2022-12-12 22:48
     * @version 1.0
     */
    private LocalDateTime setTime;
    /**
     * 发送时间
     *
     * @author LDB
     * @date 2022-12-12 22:48
     * @version 1.0
     */
    private LocalDateTime sendTime;
    /**
     * 当前模板中的消息
     *
     * @author LDB
     * @date 2022-12-12 23:10
     * @version 1.0
     */
    private M message;

    public void setMessage(M message) {
        this.setSetTime(LocalDateTime.now());
        this.message = message;
    }

    public AbstractMessagesTemplate() {
        this.createTime = LocalDateTime.now();
    }

    public AbstractMessagesTemplate(M m) {
        this.createTime = LocalDateTime.now();
        this.createMessage(m);
    }


    @Override
    public Boolean createMessage(M m) {
        this.message = m;
        this.setSetTime(LocalDateTime.now());
        return true;
    }

    @Override
    public Boolean sendMessage(M msg) {
        this.message = msg;
        if (null == this.message) {
            throw new RuntimeException("message is null!");
        }
        this.sendTime = LocalDateTime.now();
        return true;
    }

    @Override
    public Boolean sendMessage() {
        return sendMessage(this.message);
    }
}
