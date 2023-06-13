package com.mizhousoft.translate;

import java.util.Set;

/**
 * 翻译接口
 *
 * @version
 */
public interface TranslateService
{
	/**
	 * 翻译
	 * 
	 * @param q
	 * @param from
	 * @param to
	 * @return
	 * @throws TranslateException
	 */
	Set<String> translate(String q, LanguageEnum from, LanguageEnum to) throws TranslateException;
}
