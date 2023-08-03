package ex;

public class Child {

	private int age;
	private int height;
	private boolean parent;
	private boolean heartDisease;
	private String[] attractions;
	private String canRideRollerCoaster;
	private String canRideBumpercar;
	private String canRideMerrygoround;

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

	public String getCanRideRollerCoaster() {
		if (this.heartDisease == false && this.height >= 120) {
			if (this.age >= 6 || this.parent != false) {
				canRideRollerCoaster = "가능";
			} else {
				canRideRollerCoaster = "불가";
			}
		} else {
			canRideRollerCoaster = "불가";
		}
		return canRideRollerCoaster;
	}

	public void setCanRideRollerCoaster(String canRideRollerCoaster) {
		this.canRideRollerCoaster = canRideRollerCoaster;
	}

	public String getCanRideBumpercar() {
		if (this.height >= 120) {
			if (this.age >= 6 || this.parent != false) {
				canRideBumpercar = "가능";
			} else {
				canRideBumpercar = "불가";
			}
		} else {
			canRideBumpercar = "불가";
		}
		return canRideBumpercar;
	}

	public String getCanRideMerrygoround() {
		canRideMerrygoround = "가능";
		return canRideMerrygoround;
	}

}
