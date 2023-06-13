package com.mizhousoft.translate.boot.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.translate.TranslateService;
import com.mizhousoft.translate.baidu.impl.BaiduTranslateServiceImpl;
import com.mizhousoft.translate.baidu.profile.BaiduProfile;
import com.mizhousoft.translate.boot.properties.BaiduTranslateProperties;

/**
 * BaiduTranslateConfiguration
 *
 * @version
 */
@Configuration
public class BaiduTranslateConfiguration
{
	@Autowired
	private BaiduTranslateProperties baiduProperties;

	@Autowired
	private RestClientService restClientService;

	private BaiduProfile profile;

	@Bean
	@ConditionalOnProperty("translate.baidu.app-id")
	public TranslateService getTranslateService()
	{
		BaiduProfile profile = getBaiduProfile();

		BaiduTranslateServiceImpl translateService = new BaiduTranslateServiceImpl();
		translateService.setProfile(profile);
		translateService.setRestClientService(restClientService);

		return translateService;
	}

	public synchronized BaiduProfile getBaiduProfile()
	{
		if (null == this.profile)
		{
			BaiduProfile profile = new BaiduProfile();
			profile.setAppId(baiduProperties.getAppId());
			profile.setAppSecret(baiduProperties.getAppSecret());

			this.profile = profile;
		}

		return profile;
	}
}
