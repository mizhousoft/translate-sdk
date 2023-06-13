package com.mizhousoft.translate.baidu.response;

/**
 * 结果
 *
 */
public class BaiduTranslateResult
{
	/**
	 * 源数据
	 */
	private String src;

	/**
	 * 结果数据
	 */
	private String dst;

	/**
	 * 获取src
	 * 
	 * @return
	 */
	public String getSrc()
	{
		return src;
	}

	/**
	 * 设置src
	 * 
	 * @param src
	 */
	public void setSrc(String src)
	{
		this.src = src;
	}

	/**
	 * 获取dst
	 * 
	 * @return
	 */
	public String getDst()
	{
		return dst;
	}

	/**
	 * 设置dst
	 * 
	 * @param dst
	 */
	public void setDst(String dst)
	{
		this.dst = dst;
	}
}
