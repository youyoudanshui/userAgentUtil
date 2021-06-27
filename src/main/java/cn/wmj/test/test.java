package cn.wmj.test;

import cn.wmj.domain.Browser;
import cn.wmj.domain.OperatingSystem;
import cn.wmj.util.UserAgent;

public class test {

	public static void main(String[] args) {
		String[] agents = {
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.77 Safari/537.36",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/91.0.4472.114 Safari/537.36 Edg/91.0.864.54",
				"Mozilla/5.0 (Linux; Android 8.0.0; FRD-AL10; HMSCore 5.3.0.312; GMSCore 17.4.55) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.93 HuaweiBrowser/11.1.1.310 Mobile Safari/537.36",
				"Mozilla/5.0 (Linux; U; Android 8.0.0; zh-CN; FRD-AL10 Build/HUAWEIFRD-AL10) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/78.0.3904.108 UCBrowser/13.4.2.1122 Mobile Safari/537.36",
				"Mozilla/5.0 (Linux; U; Android 8.0.0; zh-cn; FRD-AL10 Build/HUAWEIFRD-AL10) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/77.0.3865.120 MQQBrowser/11.6 Mobile Safari/537.36 COVC/045633",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:89.0) Gecko/20100101 Firefox/89.0",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/48.0.2564.116 Safari/537.36 TheWorld 7",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.87 Safari/537.36 SE 2.X MetaSr 1.0", // PC搜狗浏览器
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/90.0.4430.85 Safari/537.36 OPR/76.0.4017.94",
				"Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/55.0.2883.87 UBrowser/6.2.4098.3 Safari/537.36",
				"Mozilla/5.0 (Linux; Android 8.0.0; FRD-AL10 Build/HUAWEIFRD-AL10; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/68.0.3440.106 Mobile Safari/537.36 AWP/2.0 SogouMSE,SogouMobileBrowser/6.4.5",
				"Mozilla/5.0 (Linux; Android 8.0.0; FRD-AL10 Build/HUAWEIFRD-AL10; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/76.0.3809.89 Mobile Safari/537.36 T7/11.25 SP-engine/0.0.0 flyflow/4.21.5.31 lite baiduboxapp/4.21.5.31 (Baidu; P1 8.0.0)",
				"Mozilla/5.0 (Linux; Android 8.0.0; FRD-AL10 Build/HUAWEIFRD-AL10) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/70.0.3538.110 Mobile Safari/537.36 360 Alitephone Browser (1.5.0.94/1.0.100.1090) mso_sdk(1.0.0)",
				"Mozilla/5.0 (Linux; U; Android 8.0.0; zh-CN; FRD-AL10 Build/HUAWEIFRD-AL10) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 OPR/12.62.0.10 Mobile Safari/537.36",
				"Mozilla/5.0 (Linux; Android 8.0.0; FRD-AL10 Build/HUAWEIFRD-AL10) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/70.0.3538.110 Mobile Safari/537.36 Maxthon/3489",
				"Mozilla/5.0 (Linux; Android 8.0.0; FRD-AL10 Build/HUAWEIFRD-AL10; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/70.0.3538.110 Mobile Safari/537.36 LieBaoFast/5.25.0",
				"Mozilla/5.0 (Windows NT 6.2; WOW64) AppleWebKit/534.57.2 (KHTML, like Gecko) Version/5.1.7 Safari/534.57.2",
				"Mozilla/4.0 (compatible; MSIE 6.0; Windows NT 6.2; WOW64; .NET4.0C; .NET4.0E; McAfee; .NET CLR 2.0.50727; .NET CLR 3.0.30729; .NET CLR 3.5.30729)",
				"Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko",
				"Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/89.0.4389.90 Safari/537.36",
				"Mozilla/5.0 (Linux; Android 7.1.1; 1707-A01 Build/NMF26X; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/81.0.4044.145 Mobile Safari/537.36",
				"Mozilla/5.0 (Linux; Android 10; HRY-AL00a; HMSCore 5.3.0.312) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/88.0.4324.93 HuaweiBrowser/11.1.2.301 Mobile Safari/537.36",
				"Mozilla/5.0 (Linux; U; Android 4.2.2; zh-cn; Lenovo A850+ Build/JDQ39) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/66.0.3359.126 MQQBrowser/10.5 Mobile Safari/537.36",
				"Mozilla/5.0 (Linux; Android 4.2.2; Lenovo A850+ Build/JDQ39; wv) AppleWebKit/537.36 (KHTML, like Gecko) Version/4.0 Chrome/43.0.2357.134 Mobile Safari/537.36 LeBrowser/8.2.5",
				"Mozilla/5.0 (Linux; Android 10; iPlay40) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/80.0.3987.132 Safari/537.36",
				"Mozilla/5.0 (Linux; Android 11; NTH-AN00; HMSCore 5.3.0.320) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 HuaweiBrowser/11.0.8.301 Mobile Safari/537.36",
				"Mozilla/5.0 (iPhone; CPU iPhone OS 14_4_1 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/14.0.3 Mobile/15E148 Safari/604.1"
		};
		
		for (String agent: agents) {
			UserAgent ua = new UserAgent(agent);
			Browser b = ua.getBrowser();
			OperatingSystem os = ua.getOperatingSystem();
			System.out.println("浏览器：" + b.getName() + " v" + b.getVersion() + "，操作系统：" + os.getName() + " v" + os.getVersion());
		}
	}

}
