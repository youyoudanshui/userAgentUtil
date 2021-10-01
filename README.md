# User Agent解析插件

#### 介绍
根据User Agent获取浏览器和操作系统，特别是满足识别国产和移动端浏览器的需要。由于设备不足，对一些浏览器和操作系统的识别还不完善，希望大家可以提供一些User Agent供测试，尤其是鸿蒙系统的。

V1.1.0 优化了操作系统和浏览器识别，增加了客户端类型判断和搜索引擎爬虫识别。

V1.2.0 进一步优化对操作系统和浏览器等的识别，并增加对移动端设备的识别。

 **V1.2.1 优化对搜狗浏览器的识别，增加对三星 Galaxy A90机型的识别。** 

- 具体支持识别的浏览器、操作系统和移动端设备型号等，请查看文档 http://www.wmj.zone/userAgentUtil



#### 安装教程

插件已上传中央仓库，在pom.xml加入以下依赖即可使用：

```
<dependency>
    <groupId>zone.wmj</groupId>
    <artifactId>user-agent-util</artifactId>
    <version>1.2.1</version>
</dependency>
```



#### 使用示例

```
String userAgentString = "Mozilla/5.0 (Windows NT 10.0; WOW64; Trident/7.0; rv:11.0) like Gecko";
UserAgent ua = new UserAgent(userAgentString);
Browser b = ua.getBrowser();
OperatingSystem so = ua.getOperatingSystem();
Bot bot = ua.getBot();
Model model = ua.getModel();
System.out.println("浏览器名称：" + b.getName() + ",浏览器版本：" + b.getVersion());
System.out.println("操作系统名称：" + so.getName() + ",操作系统版本：" + so.getVersion() + ",操作系统类型：" + so.getType());
System.out.println("设备型号：" + model.getName());
System.out.println("搜索引擎爬虫名称：" + bot.getName() + ",搜索引擎爬虫版本：" + bot.getVersion());
```



