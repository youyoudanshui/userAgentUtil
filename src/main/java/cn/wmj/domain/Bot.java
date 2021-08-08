package cn.wmj.domain;

/**
 * 搜索引擎爬虫
 * @author wmj
 *
 */
public class Bot {
	
	String name;
	String version;
	
	public Bot(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getVersion() {
		return version;
	}
	
	public void setVersion(String version) {
		this.version = version;
	}

	@Override
	public String toString() {
		return "Bot [name=" + name + ", version=" + version + "]";
	}

}
