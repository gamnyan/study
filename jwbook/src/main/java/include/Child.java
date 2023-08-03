package include;

public class Child {

	private int age;
	private int height;
	private boolean parent;
	private boolean heartDisease;
	private String[] attractions;

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
