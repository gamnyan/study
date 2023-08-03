package beanutils;

public class Child {

	private int age;
	private int height;
	private boolean parent;
	private boolean heartDisease;
	private String[] attractions;

	public String toString() {
		String rtn = null;

		StringBuilder sb = new StringBuilder();
		for (String attraction : attractions) {
			sb.append(attraction);
			sb.append(",");

		}
		rtn = String.format("%s\t%s\t%s\t%s\t", age, height, parent, heartDisease);
		rtn += sb.toString();
		return rtn;

	}

	public Child() {
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public boolean isParent() {
		return parent;
	}

	public void setParent(boolean parent) {
		this.parent = parent;
	}

	public boolean isHeartDisease() {
		return heartDisease;
	}

	public void setHeartDisease(boolean heartDisease) {
		this.heartDisease = heartDisease;
	}

	public String[] getAttractions() {
//		useBean
		if (this.attractions == null) {
			this.attractions = new String[0];
		}
		return attractions;
	}

	public void setAttractions(String[] attractions) {
		this.attractions = attractions;
	}

}
