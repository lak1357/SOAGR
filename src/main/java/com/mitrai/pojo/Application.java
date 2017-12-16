package com.mitrai.pojo;

public class Application {

	private String name;
	private String version;

	public Application() {
	}

	public Application(String name) {
		this.name = name;
	}

	public Application(String name, String version) {
		this.name = name;
		this.version = version;
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
		return "Application [name=" + name + ", version=" + version + "]";
	}

}
