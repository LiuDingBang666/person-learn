package icu.liuwisdom.email.service.impl;

import icu.liuwisdom.email.dto.EmailDto;
import org.apache.commons.lang3.StringUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;
import java.util.UUID;

/**
 * 邮箱服务
 *
 * @author LDB
 * @version 1.0
 * @date 2022-12-21 14:37
 */
@Service
public class EmailServiceImpl {
    @Resource
    JavaMailSender javaMailSender;

    public void sendSimpleEmail(EmailDto dto) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(dto.getFrom());
        message.setTo(dto.getTo());
        if (StringUtils.isNotEmpty(dto.getCc())) {
            message.setCc(dto.getCc());
        }
        message.setSubject(dto.getSubject());
        message.setText(dto.getContent());
        if (null != dto.getSentDate()) {
            message.setSentDate(dto.getSentDate());
        }
        javaMailSender.send(message);
    }

    /**
     * 发送普通邮件
     * 方法5个参数分别表示：邮件发送者、收件人、邮件主题、邮件内容、以及附件
     *
     * @author LDB
     * @date 2022-12-21
     **/
    public void sendMimeEmail(EmailDto dto) {
        try {
            MimeMessage message = javaMailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(message, true);
            helper.setFrom(dto.getFrom());
            helper.setTo(dto.getTo());
            helper.setSubject(dto.getSubject());
            helper.setText(dto.getContent());
            // 最后通过 addAttachment 方法添加附件
            dto.getFile().stream().peek(file -> {
                try {
                    helper.addAttachment(file.getName(), file);
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            }).count();
            dto.getFilePath().stream().peek(path -> {
                // 通过FileSystemResource构造静态资源，让后调用addInline方法将资源加入到邮件对象中
                File file = new File(path);
                FileSystemResource res = new FileSystemResource(file);
                try {
                    helper.addInline(UUID.randomUUID().toString(), res);
                } catch (MessagingException e) {
                    throw new RuntimeException(e);
                }
            }).count();
            javaMailSender.send(message);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}