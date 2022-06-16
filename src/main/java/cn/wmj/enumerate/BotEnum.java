package cn.wmj.enumerate;

/**
 * 搜索引擎爬虫
 * @author wmj
 *
 */
public enum BotEnum {
	
	GOOGLEBOT("Google爬虫Googlebot", "Googlebot\\/\\d+\\.\\d+", "/"),
	BINGPREVIEW("必应爬虫BingPreview", "BingPreview\\/\\d+\\.\\w+", "/"),
	BINGBOT("必应爬虫Bingbot", "bingbot\\/\\d+\\.\\d+", "/"),
	BAIDUSPIDER_RENDER("百度爬虫Baiduspider-render", "Baiduspider-render\\/\\d+\\.\\d+", "/"),
	YANDEXBOT("Yandex爬虫YandexBot", "YandexBot\\/\\d+\\.\\d+", "/"),
	YISOUSPIDER("神马爬虫YisouSpider", "YisouSpider\\/\\d+\\.\\d+", "/"),
	
	OTHER_CMNW("其它爬虫CheckMarkNetwork", "CheckMarkNetwork\\/\\d+\\.\\d+", "/"),
	
	UNKNOWN("UNKNOWN");
	
	private final String name;
	private String regex;
	private String separator;
	
	BotEnum(String name) {
		this.name = name;
	}
	
	BotEnum(String name, String regex, String separator) {
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
