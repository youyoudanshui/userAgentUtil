package cn.wmj.domain;

/**
 * 浏览器
 * @author wmj
 *
 */
public class Browser {
	
	String name;
	String version;
	
	public Browser(String name) {
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
		return "Browser [name=" + name + ", version=" + version + "]";
	}

}
