package com.mizhousoft.translate.baidu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.mizhousoft.commons.restclient.service.RestClientService;
import com.mizhousoft.translate.TranslateService;
import com.mizhousoft.translate.baidu.impl.BaiduTranslateServiceImpl;
import com.mizhousoft.translate.baidu.profile.BaiduProfile;

@ComponentScan("com.mizhousoft")
@SpringBootApplication
public class DemoApplication
{
	@Autowired
	private RestClientService restClientService;

	@Value("${translate.baidu.app-id}")
	private String appId;

	@Value("${translate.baidu.app-secret}")
	private String appSecret;

	public static void main(String[] args)
	{
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public BaiduProfile getBaiduProfile()
	{
		BaiduProfile profile = new BaiduProfile();
		profile.setAppId(appId);
		profile.setAppSecret(appSecret);

		return profile;
	}

	@Bean
	public TranslateService getTranslateService(BaiduProfile profile)
	{
		BaiduTranslateServiceImpl translateService = new BaiduTranslateServiceImpl();
		translateService.setProfile(profile);
		translateService.setRestClientService(restClientService);

		return translateService;
	}
}
