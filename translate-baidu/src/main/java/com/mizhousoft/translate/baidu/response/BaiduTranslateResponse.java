package com.mizhousoft.translate.baidu.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * 响应
 *
 */
public class BaiduTranslateResponse
{
	/**
	 * 
	 */
	private String from;

	/**
	 * 
	 */
	private String to;

	/**
	 * 
	 */
	@JsonProperty("trans_result")
	private List<BaiduTranslateResult> results;

	/**
	 * 获取from
	 * 
	 * @return
	 */
	public String getFrom()
	{
		return from;
	}

	/**
	 * 设置from
	 * 
	 * @param from
	 */
	public void setFrom(String from)
	{
		this.from = from;
	}

	/**
	 * 获取to
	 * 
	 * @return
	 */
	public String getTo()
	{
		return to;
	}

	/**
	 * 设置to
	 * 
	 * @param to
	 */
	public void setTo(String to)
	{
		this.to = to;
	}

	/**
	 * 获取results
	 * 
	 * @return
	 */
	public List<BaiduTranslateResult> getResults()
	{
		return results;
	}

	/**
	 * 设置results
	 * 
	 * @param results
	 */
	public void setResults(List<BaiduTranslateResult> results)
	{
		this.results = results;
	}
}
