package icu.liuwisdom.admin.message.test;

import com.alibaba.fastjson.JSON;
import icu.liuwisdom.admin.entity.SysMessage;
import icu.liuwisdom.admin.message.inteface.IMessagesTemplate;
import icu.liuwisdom.admin.message.template.SysMessageTemplate;
import lombok.val;

/**
 * @author LDB
 * @version 1.0
 * @date 2022-12-12 22:55
 */


class TestMessageSend {
    public static void main(String[] args) {

        val mess = new SysMessage("您有一条愿望被实现", "11233311", "1205asfdfs", "愿望实现");
        // 这里的消息模板可以被随时替换调
        IMessagesTemplate template = new SysMessageTemplate(mess);
        template.sendMessage();
        JSON.toJSONString(template);
    }
}