package cn.wmj.enumerate;

public enum Browser {
	
	IE("Internet Explorer", "(MSIE \\d+\\.0)|(rv:\\d+\\.0)", " |:"),
	EDGE("Edge", "Edg\\/\\d+\\.\\d+\\.\\d+\\.\\d+", "/"),
	CHROME("Chrome", "Chrome\\/\\d+\\.\\d+\\.\\d+\\.\\d+", ""), // 也可能是360，PC搜狗，PC遨游浏览器
	FIREFOX("Firefox", "Firefox\\/\\d+\\.\\d+", "/"),
	SAFARI("Safari", "Safari\\/\\d+\\.\\d+\\.\\d+", "/"),
	OPERA("Opera", "OPR\\/\\d+\\.\\d+\\.\\d+\\.\\d+", "/"),
	SOGOU("搜狗浏览器", "SogouMobileBrowser\\/\\d+\\.\\d+\\.\\d+", "/"), // 手机搜狗浏览器
	WX("微信浏览器", null, null),
	BAIDU("百度浏览器", "baiduboxapp\\/\\d+\\.\\d+\\.\\d+\\.\\d+", "/"),
	QQ("QQ浏览器", "MQQBrowser\\/\\d+\\.\\d+", "/"),
	_360("360极速浏览器", "360 Alitephone Browser \\(\\d+\\.\\d+\\.\\d+\\.\\d+\\/\\d+\\.\\d+\\.\\d+\\.\\d+", "/"), // 手机360极速浏览器
	UC("UC浏览器", "UC?Browser\\/\\d+\\.\\d+\\.\\d+\\.\\d+", "/"),
	MAXTHON("遨游浏览器", "Maxthon\\/\\d+", "/"), // 手机遨游浏览器
	LIEBAO("猎豹浏览器", "LieBaoFast\\/\\d+\\.\\d+\\.\\d+", "/"),
	THEWORLD("世界之窗浏览器", "TheWorld \\d+", " "),
	HUAWEI("华为浏览器", "HuaweiBrowser\\/\\d+\\.\\d+\\.\\d+\\.\\d+", "/"),
	UNKNOWN("UNKNOWN", null, null);
	
	private String name;
	private String version;
	private String regex;
	private String separator;
	
	private Browser(String name, String regex, String separator) {
		this.name = name;
		this.regex = regex;
		this.separator = separator;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getRegex() {
		return regex;
	}

	public void setRegex(String regex) {
		this.regex = regex;
	}

	public String getSeparator() {
		return separator;
	}

	public void setSeparator(String separator) {
		this.separator = separator;
	}

}
