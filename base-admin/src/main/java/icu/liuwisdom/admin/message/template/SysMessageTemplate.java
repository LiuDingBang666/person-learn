package icu.liuwisdom.admin.message.template;

import icu.liuwisdom.admin.entity.SysMessage;
import icu.liuwisdom.admin.message.inteface.AbstractMessagesTemplate;
import icu.liuwisdom.admin.service.SysMessageService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * 系统消息模板
 *
 * @author LDB
 * @version 1.0
 * @date 2022-12-12 22:57
 */
@Component
@NoArgsConstructor
@AllArgsConstructor
public class SysMessageTemplate extends AbstractMessagesTemplate<SysMessage> {
    @Resource
    SysMessageService service;


    @Override
    public Boolean sendMessage() {
        super.setName("系统消息模板");
        super.sendMessage();
        return service.save(this.getMessage());
    }


    public SysMessageTemplate(SysMessage mess) {
        super.setMessage(mess);
        super.setName("系统消息模板");
    }
}
