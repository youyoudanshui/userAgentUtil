package cn.wmj.enumerate;

/**
 * 浏览器
 * @author wmj
 *
 */
public enum BrowserEnum {
	
	IE("Internet Explorer", "(MSIE \\d+\\.\\d+)|(rv:\\d+\\.\\d+)", " |:"),
	EDGE("Edge", "Edg\\/\\d+\\.\\d+\\.\\d+\\.\\d+", "/"),
	CHROME("Chrome", "Chrome\\/\\d+\\.\\d+\\.\\d+\\.\\d+", "/"), // 也可能是360，PC搜狗，PC遨游浏览器
	FIREFOX("Firefox", "Firefox\\/\\d+\\.\\d+", "/"),
	SAFARI("Safari", "Safari\\/\\d+\\.\\d+(\\.\\d+)?", "/"),
	OPERA("Opera", "OPR\\/\\d+\\.\\d+\\.\\d+\\.\\d+", "/"),
	SOGOU("搜狗浏览器", "SogouMobileBrowser\\/\\d+\\.\\d+\\.\\d+", "/"), // 手机搜狗浏览器
	WX("微信浏览器"),
	BAIDU("百度浏览器", "baiduboxapp\\/\\d+\\.\\d+\\.\\d+\\.\\d+", "/"),
	QQ("QQ浏览器", "QQBrowser\\/\\d+\\.\\d+(\\.\\d+\\.\\d+)?", "/"),
	_360("360极速浏览器", "360 Alitephone Browser \\(\\d+\\.\\d+\\.\\d+\\.\\d+\\/\\d+\\.\\d+\\.\\d+\\.\\d+", "/"), // 手机360极速浏览器
	UC("UC浏览器", "UC?Browser\\/\\d+\\.\\d+\\.\\d+\\.\\d+", "/"),
	MAXTHON("遨游浏览器", "Maxthon\\/\\d+", "/"), // 手机遨游浏览器
	LIEBAO("猎豹浏览器", "LieBaoFast\\/\\d+\\.\\d+\\.\\d+", "/"),
	THEWORLD("世界之窗浏览器", "TheWorld \\d+", " "),
	QUARK("夸克", "Quark\\/\\d+\\.\\d+\\.\\d+\\.\\d+", "/"),
	
	HUAWEI("华为浏览器", "HuaweiBrowser\\/\\d+\\.\\d+\\.\\d+\\.\\d+", "/"),
	LE("绿茶浏览器", "LeBrowser\\/\\d+\\.\\d+\\.\\d+", "/"), // 联想手机浏览器
	MIUI("Miui浏览器", "MiuiBrowser\\/\\d+\\.\\d+\\.\\d+", "/"), // 小米手机浏览器

	UNKNOWN("UNKNOWN");
	
	private final String name;
	private String regex;
	private String separator;
	
	BrowserEnum(String name) {
		this.name = name;
	}
	
	BrowserEnum(String name, String regex, String separator) {
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
