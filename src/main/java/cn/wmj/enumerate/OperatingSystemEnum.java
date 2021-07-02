package cn.wmj.enumerate;

/**
 * 操作系统
 * @author wmj
 *
 */
public enum OperatingSystemEnum {
	
	WIN("Windows", "Win(?:dows )?([^do]{2})\\s?(\\d+\\.\\d+)?", " "),
	WINNT("Windows NT"),
	WIN2000("Windows 2000"),
	WINXP("Windows XP"),
	WINVISTA("Windows Vista"),
	WIN7("Windows 7"),
	WIN8("Windows 8"),
	WIN10("Windows 10"),
	WINME("Windows ME"),
	WINCE("Windows CE"),
	WINPHONE("Windows Phone", "Windows Phone OS (\\d+\\.\\d+)", " "),
	MAC("Mac OS X", "Mac OS X (\\d+_\\d+_\\d+)?(\\d+\\.\\d+\\.\\d+)?(\\d+\\.\\d+)?", " "),
	IOS("iOS", "CPU (?:iPhone )?OS (\\d+_\\d+_\\d+)", " "),
	ANDROID("Android", "Android \\d+(\\.\\d+)?(\\.\\d+)?", " "),
	LINUX("Linux"),
	UNKNOWN("UNKNOWN");
	
	private String name;
	private String regex;
	private String separator;
	
	private OperatingSystemEnum(String name) {
		this.name = name;
	}
	
	private OperatingSystemEnum(String name, String regex, String separator) {
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
