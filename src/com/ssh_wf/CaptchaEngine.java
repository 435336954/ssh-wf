package com.ssh_wf;

import com.octo.captcha.component.image.backgroundgenerator.BackgroundGenerator;
import com.octo.captcha.component.image.backgroundgenerator.FunkyBackgroundGenerator;
import com.octo.captcha.component.image.color.RandomListColorGenerator;
import com.octo.captcha.component.image.fontgenerator.FontGenerator;
import com.octo.captcha.component.image.fontgenerator.RandomFontGenerator;
import com.octo.captcha.component.image.textpaster.DecoratedRandomTextPaster;
import com.octo.captcha.component.image.textpaster.TextPaster;
import com.octo.captcha.component.image.textpaster.textdecorator.TextDecorator;
import com.octo.captcha.component.image.wordtoimage.ComposedWordToImage;
import com.octo.captcha.component.word.wordgenerator.RandomWordGenerator;
import com.octo.captcha.engine.image.ListImageCaptchaEngine;
import com.octo.captcha.image.gimpy.GimpyFactory;

import java.awt.*;

/**
 * 验证码图片生成
 * 
 * 
 * 
 */
/*1.2、测试验证码*/
public class CaptchaEngine extends ListImageCaptchaEngine {

	/** 图片宽度 */
	private static final int IMAGE_WIDTH = 120;

	/** 图片高度 */
	private static final int IMAGE_HEIGHT = 40;

	/** 最小字体大小 */
	private static final int MIN_FONT_SIZE = 16;

	/** 最大字体大小 */
	private static final int MAX_FONT_SIZE = 26;

	/** 最小字符个数 */
	private static final int MIN_WORD_LENGTH = 4;

	/** 最大字符个数 */
	private static final int MAX_WORD_LENGTH = 4;

	/** 随机字符 */
	private static final String CHAR_STRING = "ABCDEFGHJKLMNPQRSTUVWXYZ23456789";

	/**
	 * 随机字体
	 */
	private static final Font[] FONTS = new Font[] { new Font("Microsoft YaHei", Font.BOLD, 38) };

	/**
	 * 字体颜色
	 */
	private static final Color[] COLORS = new Color[] { new Color(26, 26, 26)};
	
	/**
	 * 背景颜色
	 */
	private static final Color[] BJCOLORS = new Color[]{ new Color(220, 220, 220) };
	
	/**
	 * 验证码图片生成
	 */
	@Override
	protected void buildInitialFactories() {
		FontGenerator fontGenerator = new RandomFontGenerator(MIN_FONT_SIZE, MAX_FONT_SIZE, FONTS);
		RandomListColorGenerator randomListColorGenerator = new RandomListColorGenerator(BJCOLORS);
		BackgroundGenerator backgroundGenerator =  new FunkyBackgroundGenerator(IMAGE_WIDTH, IMAGE_HEIGHT, randomListColorGenerator);//new FunkyBackgroundGenerator(IMAGE_WIDTH, IMAGE_HEIGHT);
		TextPaster textPaster = new DecoratedRandomTextPaster(MIN_WORD_LENGTH, MAX_WORD_LENGTH, new RandomListColorGenerator(COLORS), new TextDecorator[] {});
		addFactory(new GimpyFactory(new RandomWordGenerator(CHAR_STRING), new ComposedWordToImage(fontGenerator, backgroundGenerator, textPaster)));
	}

}