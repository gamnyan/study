package restaurant;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/restaurant")
public class RestaurantService {
	RestaurantDAO dao;

	public RestaurantService() {
		dao = new RestaurantDAO();
	}
	
	public List<Coupon> getCoupon() {
		return dao.selectCoupon();
	}
	
	public Coupon getCouponById(int id) {
		return dao.selectCouponById(id);
	}
	public List<Card> getCard() {
		return dao.selectCard();
	}
	
	public Card getCardById(int id) {
		return dao.selectCardById(id);
	}
	
	public List<Menu> getMenu() {
		return dao.selectMenu();
	}
	
	public Menu getMenuById(int id) {
		return dao.selectMenuById(id);
	}
	
	public List<Object[]> getBill(){
		return dao.selectBill();
	}
	
	public List<Object[]> getLineItem(){
		return dao.selectLineItem();
	}
	
	public void addbill(Bill bill) {
		dao.insertBill(bill);
	}
}
