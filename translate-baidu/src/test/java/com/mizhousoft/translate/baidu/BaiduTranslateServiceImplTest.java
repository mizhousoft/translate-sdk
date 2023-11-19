package com.mizhousoft.translate.baidu;

import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.mizhousoft.commons.httpclient.unirest.UnirestLogInterceptor;
import com.mizhousoft.translate.LanguageEnum;
import com.mizhousoft.translate.TranslateException;
import com.mizhousoft.translate.TranslateService;

import kong.unirest.core.Unirest;

/**
 * BaiduTranslateServiceImplTest
 *
 * @version
 */
@SpringBootTest(classes = DemoApplication.class)
public class BaiduTranslateServiceImplTest
{
	@Autowired
	private TranslateService translateService;

	@BeforeAll
	public static void init()
	{
		Unirest.config().interceptor(new UnirestLogInterceptor());
	}

	@Test
	public void search()
	{
		try
		{
			Set<String> results = translateService.translate("深圳米舟科技有限公司", LanguageEnum.ZH, LanguageEnum.EN);

			Assertions.assertEquals("Shenzhen Mizhou Technology Co., Ltd", results.iterator().next());
		}
		catch (TranslateException e)
		{
			Assertions.fail(e);
		}
	}
}
