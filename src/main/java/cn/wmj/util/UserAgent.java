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
	
	private final String userAgentString;
	
	private final Browser browser;
	
	private final OperatingSystem operatingSystem;
	
	private final Bot bot;
	
	private final Model model;
	
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
		
		if (userAgentString.contains("MSIE") || userAgentString.contains("Trident")) {
			be = BrowserEnum.IE;
		} else if (userAgentString.contains("SogouMobileBrowser") || (userAgentString.contains("Chrome") && userAgentString.contains("MetaSr"))) {
			be = BrowserEnum.SOGOU;
		} else if (userAgentString.contains("360 Alitephone Browser")) {
			be = BrowserEnum._360;
		} else if (userAgentString.toLowerCase().contains("micromessenger")) {
			be = BrowserEnum.WX;
		} else if (userAgentString.contains("HuaweiBrowser")) {
			be = BrowserEnum.HUAWEI;
		} else if (userAgentString.contains("baiduboxapp")) {
			be = BrowserEnum.BAIDU;
		} else if (userAgentString.contains("MiuiBrowser")) {
			be = BrowserEnum.MIUI;
		} else if (userAgentString.contains("QQBrowser")) {
			be = BrowserEnum.QQ;
		} else if (userAgentString.contains("UCBrowser") || userAgentString.contains("UBrowser")) {
			be = BrowserEnum.UC;
		} else if (userAgentString.contains("LeBrowser")) {
			be = BrowserEnum.LE;
		} else if (userAgentString.contains("TheWorld")) {
			be = BrowserEnum.THEWORLD;
		} else if (userAgentString.contains("Firefox")) {
			be = BrowserEnum.FIREFOX;
		} else if (userAgentString.contains("Maxthon")) {
			be = BrowserEnum.MAXTHON;
		} else if (userAgentString.contains("LieBao")) {
			be = BrowserEnum.LIEBAO;
		} else if (userAgentString.contains("Quark")) {
			be = BrowserEnum.QUARK;
		} else if (userAgentString.contains("OPR")) {
			be = BrowserEnum.OPERA;
		} else if (userAgentString.contains("Edg")) {
			be = BrowserEnum.EDGE;
		} else if (userAgentString.contains("Chrome")) {
			be = BrowserEnum.CHROME;
		} else if (userAgentString.contains("Safari")) {
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
		OperatingSystemEnum ose;
		String version = null;
		
		if (userAgentString.contains("iPhone") || userAgentString.contains("iPod") || userAgentString.contains("iPad")) {
			ose = OperatingSystemEnum.IOS;
			version = getVersion(userAgentString, ose);
			if (version != null) {
				version = version.replace("_", ".");
			} else {
				version = "2";
			}
			operatingSystem.setName(ose.getName() + " " + version);
		} else if (userAgentString.contains("Android")) {
			ose = OperatingSystemEnum.ANDROID;
			version = getVersion(userAgentString, ose);
			if (version != null) {
				String[] vs = version.split("[.]");
				operatingSystem.setName(ose.getName() + " " + (vs.length == 1 ? vs[0] : vs[0] + "." + vs[1]));
			}
		} else if (userAgentString.contains("Mac OS X")) {
			ose = OperatingSystemEnum.MAC;
			version = getVersion(userAgentString, ose);
			if (version != null) {
				version = version.replace("_", ".");
			}
		} else if (userAgentString.contains("Windows") || userAgentString.contains("Win")) {
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
						case "5.2":
							ose = OperatingSystemEnum.WIN2003;
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
		} else if (userAgentString.contains("RIM Tablet OS")) {
			ose = OperatingSystemEnum.BBT;
			version = getVersion(userAgentString, ose);
		} else if (userAgentString.contains("BB10")) {
			ose = OperatingSystemEnum.BB10;
			version = getVersion(userAgentString, ose);
		} else if (userAgentString.contains("Linux")) {
			ose = OperatingSystemEnum.LINUX;
			if (userAgentString.contains("Ubuntu")) {
				version = "Ubuntu";
			} else if (userAgentString.contains("UOS")) {
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
		
		if (userAgentString.contains("Googlebot")) {
			be = BotEnum.GOOGLEBOT;
		} else if (userAgentString.contains("BingPreview")) {
			be = BotEnum.BINGPREVIEW;
		} else if (userAgentString.contains("bingbot")) {
			be = BotEnum.BINGBOT;
		} else if (userAgentString.contains("Baiduspider-render")) {
			be = BotEnum.BAIDUSPIDER_RENDER;
		} else if (userAgentString.contains("YandexBot")) {
			be = BotEnum.YANDEXBOT;
		} else if (userAgentString.contains("CheckMarkNetwork")) {
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
			if (userAgentString.contains(modelEnum.getModelString())) {
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
