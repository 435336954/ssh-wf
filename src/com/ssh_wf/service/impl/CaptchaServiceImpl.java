package com.ssh_wf.service.impl;

import com.ssh_wf.service.CaptchaService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.awt.image.BufferedImage;
import java.util.Locale;

/**
 * Service - 验证码
 *
 *
 *
 */
/*1.2、测试验证码*/
@Service("captchaServiceImpl")
public class CaptchaServiceImpl implements CaptchaService {

    @Resource(name = "imageCaptchaService")
    private com.octo.captcha.service.CaptchaService imageCaptchaService;

    /** 系统统一验证码 */
    @Value("${system.unified.code}")
    private String systemUnifiedCode;

    public BufferedImage buildImage(String captchaId) {
        return (BufferedImage) imageCaptchaService.getChallengeForID(captchaId);
    }

    public boolean isValid(String captchaId, String captcha) {
        System.out.println("captchaId="+captchaId +",captcha="+ captcha);
        // 系统统一验证码
        if(systemUnifiedCode.equals(captcha)){
            System.out.println("systemUnifiedCode captcha="+ captcha);
            return true;
        }
        if (StringUtils.isNotEmpty(captchaId) && StringUtils.isNotEmpty(captcha)) {
            try {
                String aCase = captcha.toUpperCase(Locale.getDefault());
                return imageCaptchaService.validateResponseForID(captchaId, aCase);
            } catch (Exception e) {
                e.printStackTrace();
                return false;
            }
        } else {
            System.out.println("captchaId is null or captchaType not exist.");
            return false;
        }

    }
}