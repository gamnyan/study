package restaurant;

import java.util.Date;

public class Bill {
	private int id;
	private int discountPrice;
	private int price;
	private Date billDate;
	private int cardId;
	private int couponId;
	private LineItem[] lineItem;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getDiscountPrice() {
		return discountPrice;
	}
	public void setDiscountPrice(int discountPrice) {
		this.discountPrice = discountPrice;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Date getBillDate() {
		return billDate;
	}
	public void setBillDate(Date billDate) {
		this.billDate = billDate;
	}
	public int getCardId() {
		return cardId;
	}
	public void setCardId(int cardId) {
		this.cardId = cardId;
	}
	public int getCouponId() {
		return couponId;
	}
	public void setCouponId(int couponId) {
		this.couponId = couponId;
	}
	public LineItem[] getLineItem() {
		return lineItem;
	}
	public void setLineItem(LineItem[] lineItem) {
		this.lineItem = lineItem;
	}
	
}
