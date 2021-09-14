package cn.wmj.domain;

/**
 * 移动设备型号
 * @author wmj
 *
 */
public class Model {
	
	String name;
	String modelString;
	
	public Model(String name, String modelString) {
		this.name = name;
		this.modelString = modelString;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getModelString() {
		return modelString;
	}

	public void setModelString(String modelString) {
		this.modelString = modelString;
	}

	@Override
	public String toString() {
		return "Model [name=" + name + ", modelString=" + modelString + "]";
	}

}
