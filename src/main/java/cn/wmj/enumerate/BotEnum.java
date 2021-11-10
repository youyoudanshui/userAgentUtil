package cn.wmj.enumerate;

/**
 * 搜索引擎爬虫
 * @author wmj
 *
 */
public enum BotEnum {
	
	GOOGLEBOT("Google爬虫Googlebot", "Googlebot\\/\\d+\\.\\d+", "/"),
	BINGPREVIEW("必应爬虫BingPreview", "BingPreview\\/\\d+\\.\\w+", "/"),
	BAIDUSPIDER_RENDER("百度爬虫Baiduspider-render", "Baiduspider-render\\/\\d+\\.\\d+", "/"),
	
	OTHER_CMNW("其它爬虫CheckMarkNetwork", "CheckMarkNetwork\\/\\d+\\.\\d+", "/"),
	
	UNKNOWN("UNKNOWN");
	
	private String name;
	private String regex;
	private String separator;
	
	private BotEnum(String name) {
		this.name = name;
	}
	
	private BotEnum(String name, String regex, String separator) {
		this.name = name;
		this.regex = regex;
		this.separator = separator;
	}

	public String getName() {
		return name;
	}

	public String getRegex() {
		return regex;
	}

	public String getSeparator() {
		return separator;
	}

}
