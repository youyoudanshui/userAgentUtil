package cn.wmj.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import cn.wmj.domain.Bot;
import cn.wmj.domain.Browser;
import cn.wmj.domain.Model;
import cn.wmj.domain.OperatingSystem;
import cn.wmj.enumerate.BotEnum;
import cn.wmj.enumerate.BrowserEnum;
import cn.wmj.enumerate.ModelEnum;
import cn.wmj.enumerate.OperatingSystemEnum;

/**
 * User Agent解析类
 * @author wmj
 *
 */
public class UserAgent {
	
	private String userAgentString;
	
	private Browser browser;
	
	private OperatingSystem operatingSystem;
	
	private Bot bot;
	
	private Model model;
	
	public UserAgent(String userAgentString) {
		this.userAgentString = userAgentString;
		this.browser = parseBrowser(userAgentString);
		this.operatingSystem = parseOperatingSystem(userAgentString);
		this.bot = parseBot(userAgentString);
		this.model = parseModel(userAgentString);
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
	
	public Bot getBot() {
		return bot;
	}
	
	public Model getModel() {
		return model;
	}
	
	private Browser parseBrowser(String userAgentString) {
		Browser browser;
		BrowserEnum be;
		
		if (userAgentString.indexOf("MSIE") > -1 || userAgentString.indexOf("Trident") > -1) {
			be = BrowserEnum.IE;
		} else if (userAgentString.indexOf("SogouMobileBrowser") > -1 || (userAgentString.indexOf("Chrome") > -1 && userAgentString.indexOf("MetaSr") > -1)) {
			be = BrowserEnum.SOGOU;
		} else if (userAgentString.indexOf("360 Alitephone Browser") > -1) {
			be = BrowserEnum._360;
		} else if (userAgentString.toLowerCase().indexOf("micromessenger") > -1) {
			be = BrowserEnum.WX;
		} else if (userAgentString.indexOf("HuaweiBrowser") > -1) {
			be = BrowserEnum.HUAWEI;
		} else if (userAgentString.indexOf("baiduboxapp") > -1) {
			be = BrowserEnum.BAIDU;
		} else if (userAgentString.indexOf("QQBrowser") > -1) {
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
		} else if (userAgentString.indexOf("Quark") > -1) {
			be = BrowserEnum.QUARK;
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
		
		if (userAgentString.indexOf("iPhone") > -1 || userAgentString.indexOf("iPod") > -1 || userAgentString.indexOf("iPad") > -1) {
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
		} else if (userAgentString.indexOf("Mac OS X") > -1) {
			ose = OperatingSystemEnum.MAC;
			version = getVersion(userAgentString, ose);
			if (version != null) {
				version = version.replace("_", ".");
			}
		} else if (userAgentString.indexOf("Windows") > -1 || userAgentString.indexOf("Win") > -1) {
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
						case "6.3":
							ose = OperatingSystemEnum.WIN8_1;
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
		} else if (userAgentString.indexOf("Linux") > -1) {
			ose = OperatingSystemEnum.LINUX;
			if (userAgentString.indexOf("Ubuntu") > -1) {
				version = "Ubuntu";
			} else if (userAgentString.indexOf("UOS") > -1) {
				version = "UOS";
			}
		} else {
			ose = OperatingSystemEnum.UNKNOWN;
		}
		
		if (operatingSystem.getName() == null) {
			operatingSystem.setName(ose.getName());
		}
		
		if (version != null) {
			operatingSystem.setVersion(version);
		}
		
		operatingSystem.setType(ose.getType());
		
		return operatingSystem;
	}
	
	private Bot parseBot(String userAgentString) {
		Bot bot;
		BotEnum be;
		
		if (userAgentString.indexOf("Googlebot") > -1) {
			be = BotEnum.GOOGLEBOT;
		} else if (userAgentString.indexOf("BingPreview") > -1) {
			be = BotEnum.BINGPREVIEW;
		} else if (userAgentString.indexOf("Baiduspider-render") > -1) {
			be = BotEnum.BAIDUSPIDER_RENDER;
		} else if (userAgentString.indexOf("CheckMarkNetwork") > -1) {
			be = BotEnum.OTHER_CMNW;
		} else {
			be = BotEnum.UNKNOWN;
		}
		
		bot = new Bot(be.getName());
		
		if (be.getRegex() != null) {
			Pattern pattern = Pattern.compile(be.getRegex());
			Matcher matcher = pattern.matcher(userAgentString);
			if (matcher.find()) {
				String version = matcher.group().split(be.getSeparator())[1];
				bot.setVersion(version);
			}
		}
		
		return bot;
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
	
	private Model parseModel(String userAgentString) {
		Model model = null;
		for (ModelEnum modelEnum: ModelEnum.values()) {
			if (userAgentString.indexOf(modelEnum.getModelString()) > -1) {
				model = new Model(modelEnum.getName(), modelEnum.getModelString());
				break;
			}
		}
		if (model == null) {
			model = new Model("UNKNOWN", null);
		}
		return model;
	}

}
