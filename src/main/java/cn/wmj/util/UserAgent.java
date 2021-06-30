package cn.wmj.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.wmj.domain.Browser;
import cn.wmj.domain.OperatingSystem;
import cn.wmj.enumerate.BrowserEnum;
import cn.wmj.enumerate.OperatingSystemEnum;

public class UserAgent {
	
	private String userAgentString;
	
	private Browser browser;
	
	private OperatingSystem operatingSystem;
	
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

	public OperatingSystem getOperatingSystem() {
		return operatingSystem;
	}
	
	private Browser parseBrowser(String userAgentString) {
		Browser browser;
		BrowserEnum be;
		
		if (userAgentString.indexOf("MSIE") > -1 || userAgentString.indexOf("Trident") > -1) {
			be = BrowserEnum.IE;
		} else if (userAgentString.indexOf("Safari") > -1 && userAgentString.indexOf("Sogou") > -1) {
			be = BrowserEnum.SOGOU;
		} else if (userAgentString.indexOf("360 Alitephone Browser") > -1) {
			be = BrowserEnum._360;
		} else if (userAgentString.toLowerCase().indexOf("micromessenger") > -1) {
			be = BrowserEnum.WX;
		} else if (userAgentString.indexOf("HuaweiBrowser") > -1) {
			be = BrowserEnum.HUAWEI;
		} else if (userAgentString.indexOf("baiduboxapp") > -1) {
			be = BrowserEnum.BAIDU;
		} else if (userAgentString.indexOf("MQQBrowser") > -1) {
			be = BrowserEnum.QQ;
		} else if (userAgentString.indexOf("UCBrowser") > -1 || userAgentString.indexOf("UBrowser") > -1) {
			be = BrowserEnum.UC;
		} else if (userAgentString.indexOf("LeBrowser") > -1) {
			be = BrowserEnum.LE;
		} else if (userAgentString.indexOf("TheWorld") > -1) {
			be = BrowserEnum.THEWORLD;
		} else if (userAgentString.indexOf("Firefox") > -1) {
			be = BrowserEnum.FIREFOX;
		} else if (userAgentString.indexOf("Maxthon") > -1) {
			be = BrowserEnum.MAXTHON;
		} else if (userAgentString.indexOf("LieBao") > -1) {
			be = BrowserEnum.LIEBAO;
		} else if (userAgentString.indexOf("OPR") > -1) {
			be = BrowserEnum.OPERA;
		} else if (userAgentString.indexOf("Edg") > -1) {
			be = BrowserEnum.EDGE;
		} else if (userAgentString.indexOf("Chrome") > -1) {
			be = BrowserEnum.CHROME;
		} else if (userAgentString.indexOf("Safari") > -1) {
			be = BrowserEnum.SAFARI;
		} else {
			be = BrowserEnum.UNKNOWN;
		}
		
		browser = new Browser(be.getName());
		
		if (be.getRegex() != null) {
			Pattern pattern = Pattern.compile(be.getRegex());
			Matcher matcher = pattern.matcher(userAgentString);
			if (matcher.find()) {
				String version = matcher.group().split(be.getSeparator())[1];
				if (BrowserEnum.IE.getName().equals(be.getName())) {
					browser.setName(BrowserEnum.IE.getName() + " " + version.split("[.]")[0]);
				}
				browser.setVersion(version);
			}
		}
		
		return browser;
	}
	
	private OperatingSystem parseOperatingSystem(String userAgentString) {
		OperatingSystem operatingSystem = new OperatingSystem();
		OperatingSystemEnum ose = null;
		String version = null;
		
		if (userAgentString.indexOf("Windows") > -1 || userAgentString.indexOf("Win") > -1) {
			ose = OperatingSystemEnum.WIN;
			Pattern pattern = Pattern.compile(ose.getRegex());
			Matcher matcher = pattern.matcher(userAgentString);
			if (matcher.find()) {
				String[] groups = matcher.group().split(ose.getSeparator());
				if (groups.length == 1) {
					version = groups[0].substring(3);
					operatingSystem.setName(ose.getName() + " " + version);
				} else {
					if ("NT".equals(groups[1])) {
						version = groups[2];
						switch (version) {
						case "5.0":
							ose = OperatingSystemEnum.WIN2000;
							break;
						case "5.1":
							ose = OperatingSystemEnum.WINXP;
							break;
						case "6.0":
							ose = OperatingSystemEnum.WINVISTA;
							break;
						case "6.1":
							ose = OperatingSystemEnum.WIN7;
							break;
						case "6.2":
							ose = OperatingSystemEnum.WIN8;
							break;
						case "10.0":
							ose = OperatingSystemEnum.WIN10;
							break;
						default:
							ose = OperatingSystemEnum.WINNT;
							break;
						}
					} else if ("9x".equals(groups[1])) {
						ose = OperatingSystemEnum.WINME;
						version = "9x";
					} else if ("CE".equals(groups[1])) {
						ose = OperatingSystemEnum.WINCE;
					} else if ("Ph".equals(groups[1])) {
						ose = OperatingSystemEnum.WINPHONE;
						version = getVersion(userAgentString, ose);
						if (version != null) {
							operatingSystem.setName(ose.getName() + " " + version);
						}
					} else {
						operatingSystem.setName(ose.getName() + " " + groups[1]);
					}
				}
			}
		} else if (userAgentString.indexOf("iPhone") > -1 || userAgentString.indexOf("iPod") > -1 || userAgentString.indexOf("iPad") > -1) {
			ose = OperatingSystemEnum.IOS;
			version = getVersion(userAgentString, ose);
			if (version != null) {
				version = version.replace("_", ".");
			} else {
				version = "2";
			}
			operatingSystem.setName(ose.getName() + " " + version);
		} else if (userAgentString.indexOf("Android") > -1) {
			ose = OperatingSystemEnum.ANDROID;
			version = getVersion(userAgentString, ose);
			if (version != null) {
				String[] vs = version.split("[.]");
				operatingSystem.setName(ose.getName() + " " + (vs.length == 1 ? vs[0] : vs[0] + "." + vs[1]));
			}
		} else if (userAgentString.indexOf("PlayStation") > -1) {
			ose = OperatingSystemEnum.PS;
		} else if (userAgentString.indexOf("Mac OS X") > -1) {
			ose = OperatingSystemEnum.MAC;
			version = getVersion(userAgentString, ose);
			if (version != null) {
				version = version.replace("_", ".");
			}
		} else if (userAgentString.indexOf("Linux") > -1) {
			ose = OperatingSystemEnum.LINUX;
		} else if (userAgentString.indexOf("Wii") > -1) {
			ose = OperatingSystemEnum.WII;
		} else {
			ose = OperatingSystemEnum.UNKNOWN;
		}
		
		if (operatingSystem.getName() == null) {
			operatingSystem.setName(ose.getName());
		}
		
		if (version != null) {
			operatingSystem.setVersion(version);
		}
		
		return operatingSystem;
	}
	
	private String getVersion(String userAgentString, OperatingSystemEnum ose) {
		String version = null;
		Pattern pattern = Pattern.compile(ose.getRegex());
		Matcher matcher = pattern.matcher(userAgentString);
		if (matcher.find()) {
			String[] gs = matcher.group().split(ose.getSeparator());
			version = gs[gs.length - 1];
		}
		return version;
	}

}
