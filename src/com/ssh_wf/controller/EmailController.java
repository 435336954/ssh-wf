package com.ssh_wf.controller;

import com.ssh_wf.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.mail.MessagingException;
import javax.mail.internet.AddressException;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;

@Controller
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService emailService;

    /*1.1、测试发邮件*/
    @RequestMapping("/send")
    public String send(HttpServletRequest request, Model model){
        HashMap<String, String> map = new HashMap<>();
        String mailto = request.getParameter("mailto");
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        try {
            emailService.sendHtmlMail(mailto,title,content);
            map.put("status","success");
        } catch(AddressException e) {
            map.put("status","error");
            e.printStackTrace();
        } catch(MessagingException e) {
            map.put("status","error");
            e.printStackTrace();
        } catch(UnsupportedEncodingException e){
            map.put("status","error");
            e.printStackTrace();
        }
        model.addAttribute("map",map);
        return "result";
    }
    @RequestMapping("/toSend")
    public String toSend(HttpServletRequest request){
        return "send_email";
    }
}
