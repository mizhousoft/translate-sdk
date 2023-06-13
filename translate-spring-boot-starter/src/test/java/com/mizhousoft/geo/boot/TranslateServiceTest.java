package com.mizhousoft.geo.boot;

import java.util.Set;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.mizhousoft.translate.LanguageEnum;
import com.mizhousoft.translate.TranslateException;
import com.mizhousoft.translate.TranslateService;

/**
 * TranslateService Test
 *
 * @version
 */
@ExtendWith(SpringExtension.class)
@SpringBootTest(classes = DemoApplication.class)
public class TranslateServiceTest
{
	@Autowired
	private TranslateService translateService;

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
