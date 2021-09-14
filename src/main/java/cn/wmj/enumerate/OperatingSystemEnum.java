package cn.wmj.enumerate;

/**
 * 操作系统
 * @author wmj
 *
 */
public enum OperatingSystemEnum {
	
	WIN("Windows", "Win(?:dows )?([^do]{2})\\s?(\\d+\\.\\d+)?", " ", OperatingSystemTypeEnum.PC.toString()),
	WINNT("Windows NT", OperatingSystemTypeEnum.PC.toString()),
	WIN2000("Windows 2000", OperatingSystemTypeEnum.PC.toString()),
	WINXP("Windows XP", OperatingSystemTypeEnum.PC.toString()),
	WINVISTA("Windows Vista", OperatingSystemTypeEnum.PC.toString()),
	WIN7("Windows 7", OperatingSystemTypeEnum.PC.toString()),
	WIN8("Windows 8", OperatingSystemTypeEnum.PC.toString()),
	WIN10("Windows 10", OperatingSystemTypeEnum.PC.toString()),
	WINME("Windows ME", OperatingSystemTypeEnum.PC.toString()),
	WINCE("Windows CE", OperatingSystemTypeEnum.MOBILE.toString()),
	WINPHONE("Windows Phone", "Windows Phone OS (\\d+\\.\\d+)", " ", OperatingSystemTypeEnum.MOBILE.toString()),
	MAC("Mac OS X", "Mac OS X (\\d+_\\d+_\\d+)?(\\d+\\.\\d+\\.\\d+)?(\\d+\\.\\d+)?", " ", OperatingSystemTypeEnum.PC.toString()),
	IOS("iOS", "CPU (?:iPhone )?OS (\\d+_\\d+(_\\d+)?)", " ", OperatingSystemTypeEnum.MOBILE.toString()),
	ANDROID("Android", "Android \\d+(\\.\\d+)?(\\.\\d+)?", " ", OperatingSystemTypeEnum.MOBILE.toString()),
	LINUX("Linux", OperatingSystemTypeEnum.PC.toString()),
	UNKNOWN("UNKNOWN");
	
	private String name;
	private String regex;
	private String separator;
	private String type;
	
	private OperatingSystemEnum(String name) {
		this.name = name;
	}
	
	private OperatingSystemEnum(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	private OperatingSystemEnum(String name, String regex, String separator, String type) {
		this.name = name;
		this.regex = regex;
		this.separator = separator;
		this.type = type;
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
	
	public String getType() {
		return type;
	}

}
