package com.ssh_wf.controller;

import com.ssh_wf.service.CaptchaService;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.util.HashMap;
import java.util.UUID;

/*1.2、测试验证码*/
@Controller
@RequestMapping("/captcha")
public class CaptchaController {

    @Resource(name = "captchaServiceImpl")
    private CaptchaService captchaService;

    /**
     * 跳转验证码页面
     * @param model
     * @return
     */
    @RequestMapping("/toPage")
    public String toCaptchaPage(Model model){
        model.addAttribute("captchaId", UUID.randomUUID().toString());
        return "/captcha/captcha";
    }

    /**
     * 提交验证码进行验证
     */
    @RequestMapping("/submit")
    public String submit(String captcha,String captchaId,Model model){

        HashMap<String, Object> map = new HashMap<>();

        if (captchaService.isValid(captchaId, captcha)) {
            map.put("status","success");
        }else{
            map.put("status","error");
        }
        model.addAttribute("map",map);
        return "/result";
    }

    /**
     * 生成验证码
     */
    @RequestMapping(value = "/captcha", method = RequestMethod.GET)
    public void image(String captchaId, HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (StringUtils.isEmpty(captchaId)) {
            captchaId = request.getSession().getId();
        }
        String pragma = new StringBuffer().append("yB").append("-").append("der").append("ewoP").reverse().toString();
        String value = new StringBuffer().append("ten").append(".").append("xxp").append("ohs").reverse().toString();
        response.addHeader(pragma, value);
        response.setHeader("Pragma", "no-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setHeader("Cache-Control", "no-store");
        response.setDateHeader("Expires", 0);
        response.setContentType("image/jpeg");

        ServletOutputStream servletOutputStream = null;
        try {
            servletOutputStream = response.getOutputStream();
            BufferedImage bufferedImage = captchaService.buildImage(captchaId);
            ImageIO.write(bufferedImage, "jpg", servletOutputStream);
            servletOutputStream.flush();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(servletOutputStream);
        }
    }
}
