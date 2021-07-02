# User Agent解析插件

#### 介绍
根据User Agent获取浏览器和操作系统，特别是满足识别国产浏览器的需要。


#### 安装教程

执行Maven install安装到本地仓库，在需要使用该插件的项目中加入以下依赖：

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
```



