package com.ssh_wf.service;

import javax.mail.MessagingException;
import java.io.UnsupportedEncodingException;

/**
 * Description : 邮件相关服务接口. <br />
 * Create Time : 2013年11月29日 下午5:54:20 <br />
 * Copyright : Copyright (c) 2010 - 2013 All rights reserved. <br />
 *
 * @author yanshaodong
 * @version 1.0
 */
public interface EmailService {

    /**
     * 发送邮件
     * @param mailto		收件邮箱
     * @param title			标题
     * @param content		内容
     */
    /*1.1、测试发邮件*/
    void sendHtmlMail(String to, String subject, String html) throws MessagingException,UnsupportedEncodingException;


}

