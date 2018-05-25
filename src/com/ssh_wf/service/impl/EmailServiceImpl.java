package com.ssh_wf.service.impl;

import com.silkeroad.support.util.Configuration;
import com.ssh_wf.service.EmailService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;;

/**
 * Description : 邮件相关服务接口实现. <br />
 * Create Time : 2013年11月29日 下午5:55:31 <br />
 * Copyright : Copyright (c) 2010 - 2013 All rights reserved. <br />
 *
 * @author yanshaodong
 * @version 1.0
 */
@Service("emailService")
public class EmailServiceImpl implements EmailService{

    private static final Log log = LogFactory.getLog(EmailServiceImpl.class);

    /*1.1、测试发邮件*/
    // 报警邮箱配置参数
    public static final String EMAIL_HOST = "smtp.163.com";
    public static final String EMAIL_USERNAME = "wangfei_0410@163.com";
    public static final String EMAIL_PASSWORD = "wang435336954";
    private static final Integer PORT = 25;
    private static JavaMailSenderImpl mailSender = createMailSender();

    /**
     * 邮件发送器
     *
     * @return 配置好的工具
     */
    /*1.1、测试发邮件*/
    private static JavaMailSenderImpl createMailSender() {
        JavaMailSenderImpl sender = new JavaMailSenderImpl();
        sender.setHost(EMAIL_HOST);
        sender.setPort(PORT);
        sender.setUsername(EMAIL_USERNAME);
        sender.setPassword(EMAIL_PASSWORD);
        sender.setDefaultEncoding("Utf-8");
        Properties p = new Properties();
        p.setProperty("mail.smtp.timeout", "100");
        p.setProperty("mail.smtp.auth", "true");
        sender.setJavaMailProperties(p);
        return sender;
    }

    /**
     * 发送邮件
     *
     * @param to 接受人
     * @param subject 主题
     * @param html 发送内容
     * @throws MessagingException 异常
     * @throws UnsupportedEncodingException 异常
     */
    /*1.1、测试发邮件*/
    public  void sendHtmlMail(String to, String subject, String html) throws MessagingException,UnsupportedEncodingException {
        MimeMessage mimeMessage = mailSender.createMimeMessage();
        // 设置utf-8或GBK编码，否则邮件会有乱码
        MimeMessageHelper messageHelper = new MimeMessageHelper(mimeMessage, true, "UTF-8");
        messageHelper.setFrom(EMAIL_USERNAME, "系统名称");
        messageHelper.setTo(to);
        messageHelper.setSubject(subject);
        messageHelper.setText(html, true);
        mailSender.send(mimeMessage);
    }
}
