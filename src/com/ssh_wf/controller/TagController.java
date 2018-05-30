package com.ssh_wf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/*1.3、测试自定义标签*/
@Controller
@RequestMapping("/tag")
public class TagController {

    @RequestMapping("/toTag")
    public String toTag(){
        return "tag/tag";
    }
}
