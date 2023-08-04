package restaurant;

import org.json.simple.JSONObject;

public class Coupon {

    private long id;
    private String name;
    private Integer discount;
    private String discountType;
    private Boolean doubleDiscount;

    @SuppressWarnings("unchecked")
	public String toJsonString() {
        String rtn = null;

        JSONObject jo = new JSONObject();
        jo.put("id", id);
        jo.put("name", name);
        jo.put("discount", discount);
        jo.put("discountType", discountType);
        jo.put("doubleDiscount", doubleDiscount);

        rtn = jo.toString();

        return rtn;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDiscount() {
        return discount;
    }

    public void setDiscount(Integer discount) {
        this.discount = discount;
    }

    public String getDiscountType() {
        return discountType;
    }

    public void setDiscountType(String discountType) {
        this.discountType = discountType;
    }

    public Boolean isDoubleDiscount() {
        return doubleDiscount;
    }

    public void setDoubleDiscount(Boolean doubleDiscount) {
        this.doubleDiscount = doubleDiscount;
    }
}
