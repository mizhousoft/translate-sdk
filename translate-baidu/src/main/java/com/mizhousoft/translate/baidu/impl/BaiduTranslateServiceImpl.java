package com.mizhousoft.translate.baidu.impl;

import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.lang3.StringUtils;

import com.mizhousoft.commons.crypto.generator.RandomGenerator;
import com.mizhousoft.commons.json.JSONException;
import com.mizhousoft.commons.json.JSONUtils;
import com.mizhousoft.commons.lang.CollectionUtils;
import com.mizhousoft.translate.LanguageEnum;
import com.mizhousoft.translate.TranslateException;
import com.mizhousoft.translate.TranslateService;
import com.mizhousoft.translate.baidu.profile.BaiduProfile;
import com.mizhousoft.translate.baidu.response.BaiduTranslateResponse;
import com.mizhousoft.translate.baidu.response.BaiduTranslateResult;

import kong.unirest.core.Unirest;
import kong.unirest.core.UnirestException;

/**
 * 翻译接口
 *
 */
public class BaiduTranslateServiceImpl implements TranslateService
{
	/**
	 * BaiduProfile
	 */
	private BaiduProfile profile;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Set<String> translate(String q, LanguageEnum from, LanguageEnum to) throws TranslateException
	{
		String salt = RandomGenerator.genHexString(8, false);

		String toSignValue = profile.getAppId() + q + salt + profile.getAppSecret();
		String sign = DigestUtils.md5Hex(toSignValue);

		try
		{
			String response = Unirest.get("http://api.fanyi.baidu.com/api/trans/vip/translate").queryString("q", q)
			        .queryString("from", from.getValue()).queryString("to", to.getValue()).queryString("appid", profile.getAppId())
			        .queryString("salt", salt).queryString("sign", sign).asString().getBody();

			BaiduTranslateResponse resp = JSONUtils.parse(response, BaiduTranslateResponse.class);

			List<BaiduTranslateResult> results = resp.getResults();
			if (CollectionUtils.isEmpty(results))
			{
				return Collections.emptySet();
			}

			Set<String> dsts = new HashSet<>(results.size());
			results.forEach(item -> {
				if (!StringUtils.isBlank(item.getDst()))
				{
					dsts.add(item.getDst());
				}
			});

			return dsts;
		}
		catch (UnirestException e)
		{
			throw new TranslateException(e.getMessage(), e);
		}
		catch (JSONException e)
		{
			throw new TranslateException(e.getMessage(), e);
		}
	}

	/**
	 * 设置profile
	 * 
	 * @param profile
	 */
	public void setProfile(BaiduProfile profile)
	{
		this.profile = profile;
	}
}
