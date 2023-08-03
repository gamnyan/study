/*CREATE TABLE coupons(
    couponId IDENTITY,
    title VARCHAR(64) NOT NULL,
    discount BIGINT NOT NULL,
    doubleDiscount BOOLEAN,
    discountType VARCHAR(64) NOT NULL
);*/

package restaurant;

public class Coupon {
	private int id;
	private String name;
	private int discount;
	private boolean doubleDiscount;
	private String discountType;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public boolean isDoubleDiscount() {
		return doubleDiscount;
	}
	public void setDoubleDiscount(boolean doubleDiscount) {
		this.doubleDiscount = doubleDiscount;
	}
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
}
