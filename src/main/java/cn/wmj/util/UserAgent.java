package cn.wmj.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.wmj.enumerate.Browser;

public class UserAgent {
	
	private String userAgentString;
	
	private Browser browser;
	
	private String operatingSystem;
	
	public UserAgent(String userAgentString) {
		this.userAgentString = userAgentString;
		this.browser = parseBrowser(userAgentString);
		this.operatingSystem = parseOperatingSystem(userAgentString);
	}

	public String getUserAgentString() {
		return userAgentString;
	}

	public Browser getBrowser() {
		return browser;
	}

	public String getOperatingSystem() {
		return operatingSystem;
	}
	
	private Browser parseBrowser(String userAgentString) {
		Browser browser;
		
		if (userAgentString.indexOf("MSIE") > -1 || userAgentString.indexOf("Trident") > -1) {
			browser = Browser.IE;
		} else if (userAgentString.indexOf("Safari") > -1 && userAgentString.indexOf("Sogou") > -1) {
			browser = Browser.SOGOU;
		} else if (userAgentString.toLowerCase().indexOf("micromessenger") > -1) {
			browser = Browser.WX;
		} else if (userAgentString.indexOf("HuaweiBrowser") > -1) {
			browser = Browser.HUAWEI;
		} else if (userAgentString.indexOf("baiduboxapp") > -1) {
			browser = Browser.BAIDU;
		} else if (userAgentString.indexOf("MQQBrowser") > -1) {
			browser = Browser.QQ;
		} else if (userAgentString.indexOf("360 Alitephone Browser") > -1) {
			browser = Browser._360;
		} else if (userAgentString.indexOf("UCBrowser") > -1 || userAgentString.indexOf("UBrowser") > -1) {
			browser = Browser.UC;
		} else if (userAgentString.indexOf("TheWorld") > -1) {
			browser = Browser.THEWORLD;
		} else if (userAgentString.indexOf("Firefox") > -1) {
			browser = Browser.FIREFOX;
		} else if (userAgentString.indexOf("Maxthon") > -1) {
			browser = Browser.MAXTHON;
		} else if (userAgentString.indexOf("LieBao") > -1) {
			browser = Browser.LIEBAO;
		} else if (userAgentString.indexOf("OPR") > -1) {
			browser = Browser.OPERA;
		} else if (userAgentString.indexOf("Edg") > -1) {
			browser = Browser.EDGE;
		} else if (userAgentString.indexOf("Chrome") > -1) {
			browser = Browser.CHROME;
		} else if (userAgentString.indexOf("Safari") > -1) {
			browser = Browser.SAFARI;
		} else {
			browser = Browser.UNKNOWN;
		}
		
		if (browser.getRegex() != null) {
			Pattern pattern = Pattern.compile(browser.getRegex());
			Matcher matcher = pattern.matcher(userAgentString);
			if (matcher.find()) {
				String version = matcher.group().split(browser.getSeparator())[1];
				if (Browser.IE.getName().equals(browser.getName())) {
					browser.setName(Browser.IE.getName() + " " + version.split("[.]")[0]);
				}
				browser.setVersion(version);
			}
		}
		
		return browser;
	}
	
	private String parseOperatingSystem(String userAgentString) {
		String system_win = null,
				system_mac = null,
				system_iphone = null,
				system_ipod = null,
				system_ipad = null,
				system_ios = null,
				system_android = null,
				system_winMobile = null,
				system_wii = null,
				system_ps = null,
				system_linux = null;
		
		String operatingSystem;
		
		if (userAgentString.indexOf("Windows") > -1) {
			system_win = "-1";
		}
		if (userAgentString.indexOf("Mac OS X") > -1) {
			system_mac = "-1";
		}
		if (userAgentString.indexOf("iPhone") > -1) {
			system_iphone = "-1";
		}
		if (userAgentString.indexOf("iPod") > -1) {
			system_ipod = "-1";
		}
		if (userAgentString.indexOf("iPad") > -1) {
			system_ipad = "-1";
		}
		if (userAgentString.indexOf("Wii") > -1) {
			system_wii = "-1";
		}
		if (userAgentString.indexOf("PlayStation") > -1) {
			system_ps = "-1";
		}
		if (userAgentString.indexOf("Linux") > -1) {
			system_linux = "-1";
		}
		
		if (system_win != null) {
			Pattern pattern = Pattern.compile("Win(?:dows )?([^do]{2})\\s?(\\d+\\.\\d+)?");
			Matcher matcher = pattern.matcher(userAgentString);
			if (matcher.find()) {
				String[] groups = matcher.group().split(" ");
				if ("NT".equals(groups[1])) {
					switch (groups[2]) {
					case "5.0":
						system_win = "2000";
						break;
					case "5.1":
						system_win = "XP";
						break;
					case "6.0":
						system_win = "Vista";
						break;
					case "6.1":
						system_win = "7";
						break;
					case "6.2":
						system_win = "8";
						break;
					case "6.4": case "10.0":
						system_win = "10";
						break;
					default:
						system_win = "NT";
						break;
					}
				} else if ("9x".equals(groups[1])) {
					system_win = "ME";
				} else {
					system_win = groups[1];
				}
			}
		}

		if ("CE".equals(system_win)) {
			system_winMobile = system_win;
		} else if ("Ph".equals(system_win)) {
			Pattern pattern = Pattern.compile("Windows Phone OS (\\d+\\.\\d)");
			Matcher matcher = pattern.matcher(userAgentString);
			if (matcher.find()) {
				system_win = "Phone";
				system_winMobile = matcher.group().split(" ")[3];
			}
		}
		
		if (system_iphone != null || system_ipod != null || system_ipad != null) {
			Pattern pattern = Pattern.compile("CPU (?:iPhone )?OS (\\d+_\\d+)");
			Matcher matcher = pattern.matcher(userAgentString);
			if (matcher.find()) {
				system_ios = matcher.group().split(" ")[2].replace("_", ".");
			} else {
				system_ios = "2";
			}
		}
		
		Pattern pattern = Pattern.compile("Android (\\d+\\.\\d+)");
		Matcher matcher = pattern.matcher(userAgentString);
		if (matcher.find()) {
			system_android = matcher.group().split(" ")[1];
		}
		
		if (system_win != null && system_winMobile == null) {
			operatingSystem = "Windows" + ("-1".equals(system_win) ? "" : " " + system_win);
		} else if (system_winMobile != null) {
			operatingSystem = "Windows " + system_win + (system_winMobile.equals(system_win) ? "" : " " + system_winMobile);
		} else if (system_mac != null) {
			operatingSystem = "Mac OS X";
		} else if (system_ios != null) {
			operatingSystem = "iOS " + system_ios;
		} else if (system_android != null) {
			operatingSystem = "Android " + system_android;
		} else if (system_wii != null) {
			operatingSystem = "Wii";
		} else if (system_ps != null) {
			operatingSystem = "PlayStation";
		} else if (system_linux != null) {
			operatingSystem = "Linux";
		} else {
			operatingSystem = "UNKNOWN";
		}
		
		return operatingSystem;
	}

}
