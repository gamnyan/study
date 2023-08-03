package ordering;

import java.util.*;

public class OrderService {
	Map<Integer, Order> orders = new HashMap<>();

	public OrderService() {
		Order o = null;
		o = new Order(1, 1, 1, 6000, "20-07-01");
		orders.put(1, o);
		o = new Order(2, 1, 3, 21000, "20-07-03");
		orders.put(2, o);
		o = new Order(3, 2, 5, 8000, "20-07-03");
		orders.put(3, o);
		o = new Order(4, 3, 6, 6000, "20-07-04");
		orders.put(4, o);
		o = new Order(5, 4, 7, 20000, "20-07-05");
		orders.put(5, o);
		o = new Order(6, 1, 2, 12000, "20-07-07");
		orders.put(6, o);
		o = new Order(7, 4, 8, 13000, "20-07-07");
		orders.put(7, o);
		o = new Order(8, 3, 10, 12000, "20-07-08");
		orders.put(8, o);
		o = new Order(9, 2, 10, 7000, "20-07-09");
		orders.put(9, o);
		o = new Order(10, 3, 8, 13000, "20-07-09");
		orders.put(10, o);
	}

	public List<Order> findAll() {
		return new ArrayList<>(orders.values());
	}

	public Order find(int id) {
		return orders.get(id);
	}
	
	public List<Order> find() {
        return new ArrayList<>(orders.values());
    }

	public synchronized void add(Order order) {
		int max = Collections.max(orders.keySet());
		order.setId(max + 1);
		order.setOrderDate(new Date());
		orders.put(order.getId(), order);
	}
}
