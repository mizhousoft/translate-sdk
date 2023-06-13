package com.mizhousoft.translate;

/**
 * 语种
 *
 */
public enum LanguageEnum
{
    // 中文
	ZH("zh"),
    // 英文
	EN("en");

	/**
	 * 构造函数
	 * 
	 * @param value
	 */
	LanguageEnum(String value)
	{
		this.value = value;
	}

	// 值
	private final String value;

	/**
	 * 获取value
	 * 
	 * @return
	 */
	public String getValue()
	{
		return value;
	}

	/**
	 * 判断是否自己
	 * 
	 * @param val
	 * @return
	 */
	public boolean isSelf(String val)
	{
		return this.getValue().equalsIgnoreCase(val);
	}

	/**
	 * 获取LogLevel
	 * 
	 * @param value
	 * @return
	 */
	public static LanguageEnum getLogLevel(String value)
	{
		LanguageEnum[] enumValues = LanguageEnum.values();
		for (LanguageEnum enumValue : enumValues)
		{
			if (enumValue.isSelf(value))
			{
				return enumValue;
			}
		}

		throw new IllegalArgumentException(value + " is illegal.");
	}
}
