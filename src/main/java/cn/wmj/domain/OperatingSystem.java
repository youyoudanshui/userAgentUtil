package cn.wmj.domain;

/**
 * 操作系统
 * @author wmj
 *
 */
public class OperatingSystem {
	
	String name;
	String version;
	
	public OperatingSystem() {}
	
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
		return "OperatingSystem [name=" + name + ", version=" + version + "]";
	}

}
