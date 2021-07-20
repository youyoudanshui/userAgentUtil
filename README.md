# User Agent解析插件

#### 介绍
根据User Agent获取浏览器和操作系统，特别是满足识别国产和移动端浏览器的需要。由于设备不足，对一些浏览器和操作系统的识别还不完善，希望大家可以提供一些User Agent供测试，尤其是鸿蒙系统的。

- 支持识别的浏览器：
1. Internet Explorer
2. Edge
3. Chrome
4. Firefox
5. Safari
6. Opera
7. 搜狗浏览器（移动端）
8. 微信浏览器
9. 百度浏览器
10. QQ浏览器
11. 360极速浏览器（移动端）
12. UC浏览器
13. 遨游浏览器（移动端）
14. 猎豹浏览器
15. 世界之窗浏览器

- 支持识别的手机内置浏览器：
1. 华为浏览器
2. 联想浏览器（绿茶浏览器）

- 支持识别的操作系统：
1. Windows
2. Mac
3. iOS
4. Android
5. Linux


#### 安装教程

插件没有上传中央仓库，需要执行Maven install安装到本地仓库，在使用该插件的项目中加入以下依赖：

```
<dependency>
    <groupId>cn.wmj</groupId>
    <artifactId>user-agent-util</artifactId>
    <version>1.0.0</version>
</dependency>
```



#### 使用示例

```
String userAgentString = "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko";
UserAgent ua = new UserAgent(userAgentString);
Browser b = ua.getBrowser();
String so = ua.getOperatingSystem();
System.out.println("浏览器名称：" + b.getName() + ",浏览器版本：" + b.getVersion());
System.out.println("操作系统名称：" + b.getName() + ",操作系统版本：" + b.getVersion());
```



