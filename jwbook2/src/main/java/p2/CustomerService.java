package p2;

import java.util.List;

//import javax.ws.rs.GET;
//import javax.ws.rs.Path;
//import javax.ws.rs.Produces;
//import javax.ws.rs.core.MediaType;

//@Path("/customers")
public class CustomerService {
	CustomerDAO customerDao;
	OrderingService orderingService;

	public CustomerService() {
		customerDao = new CustomerDAO();
		orderingService = new OrderingService();
	}

//	@GET
//	@Produces(MediaType.APPLICATION_JSON)
	public List<Customer> get() {
		return customerDao.select();
	}

	public Customer getOrBlank(int id) {
		Customer rtn = null;

		rtn = customerDao.selectById(id);

		if (rtn == null) {
			rtn = new Customer();
			rtn.setId(-1);
			rtn.setName("");
			rtn.setAddress("");
			rtn.setPhone("");
		}

		return rtn;
	}
	
	public void addOrSet(Customer customer) {
		if(customer.getId() == -1) {
			add(customer);
		} else {
			set(customer);
		}
	}
	
	public void add(Customer customer) {
		customerDao.insert(customer);
	}
	
	public void set(Customer customer) {
		customerDao.update(customer);
	}
	
	public void remove(int id) throws HasOrderingException{
		boolean hasOrdering = orderingService.hasOrderingCustomer(id);
    	
    	if(hasOrdering) {
    		throw new HasOrderingException("Customer has ordering");
    	} else {
    		customerDao.delete(id);
    	}
	}
}
