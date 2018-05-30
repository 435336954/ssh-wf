package com.ssh_wf.tld;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;
import java.io.IOException;

/*1.3、测试自定义标签*/
public class MyTagTest extends TagSupport {

    @Override
    public int doStartTag() throws JspException {

        try {
            pageContext.getResponse().getWriter().write("<h1>这是我写的一大段信息：ABCDEFGHIJKLMNOPQRSTUVWXYZ</h1>");
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        return super.doStartTag();
    }
}