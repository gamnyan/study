package restaurant;

public class LineItem {
	private int id;
	private int billId;
	private int menuId;
	private int menuQuantity;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBillId() {
		return billId;
	}

	public void setBillId(int billId) {
		this.billId = billId;
	}

	public int getMenuId() {
		return menuId;
	}

	public void setMenuId(int menuId) {
		this.menuId = menuId;
	}

	public int getMenuQuantity() {
		return menuQuantity;
	}

	public void setMenuQuantity(int menuQuantity) {
		this.menuQuantity = menuQuantity;
	}
}
