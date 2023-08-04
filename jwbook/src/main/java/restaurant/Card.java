/*CREATE TABLE creditCards(
    cardId IDENTITY,
    cardType VARCHAR(64) NOT NULL,
    cardName VARCHAR(64) NOT NULL,
    discount BIGINT NOT NULL,
    discountType VARCHAR(64) NOT NULL
);*/

package restaurant;

import org.json.simple.JSONObject;

public class Card {
	private int id;
	private String cardType;
	private String name;
	private int discount;
	private String discountType;
	
	@SuppressWarnings("unchecked")
	public String cardJsonArrayString() {
    	String rtn = null;
    	
    	JSONObject jo = new JSONObject();
    	jo.put("id", id);
    	jo.put("cardType", cardType);
    	jo.put("name", name);
    	jo.put("discount", discount);
    	jo.put("discountType", discountType);
    	
    	rtn = jo.toString();
    	
    	return rtn;
    }
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCardType() {
		return cardType;
	}
	public void setCardType(String cardType) {
		this.cardType = cardType;
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
	public String getDiscountType() {
		return discountType;
	}
	public void setDiscountType(String discountType) {
		this.discountType = discountType;
	}
}
