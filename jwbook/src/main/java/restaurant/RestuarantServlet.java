package restaurant;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;

@WebServlet(urlPatterns = "/restaurantControl")
public class RestuarantServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	RestaurantService rs;

	public RestuarantServlet() {
		super();
		rs = new RestaurantService();
	}

	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String action = StringUtils.defaultIfEmpty(request.getParameter("action"), "bill");
		String view = "";
		switch (action) {
		case "bill":
			view = bill(request, response);
			break;
		case "bills":
			view = bills(request, response);
			break;
		}

		if (StringUtils.isNotEmpty(view)) {
			getServletContext().getRequestDispatcher(view).forward(request, response);
		}
	}

	public String bill(HttpServletRequest request, HttpServletResponse response) {
		boolean hasBill = Boolean.parseBoolean(StringUtils.defaultIfEmpty(request.getParameter("hasBill"), "false"));
		List<Coupon> couponList = rs.getCoupon();
		List<Card> cardList = rs.getCard();
		List<Menu> menuList = rs.getMenu();

		request.setAttribute("hasBill", hasBill);
		request.setAttribute("couponList", couponList);
		request.setAttribute("cardList", cardList);
		request.setAttribute("menuList", menuList);

		return "/restaurant/bill.jsp";
	}
	
	public String bills(HttpServletRequest request, HttpServletResponse response) {
		boolean hasBill = Boolean.parseBoolean(StringUtils.defaultIfEmpty(request.getParameter("hasBill"), "false"));
		List<Coupon> couponList = rs.getCoupon();
		List<Card> cardList = rs.getCard();
		List<Menu> menuList = rs.getMenu();
		List<Object[]> billList = rs.getBill();
		List<Object[]> lineItemList = rs.getLineItem();
		
		request.setAttribute("hasBill", hasBill);
		request.setAttribute("couponList", couponList);
		request.setAttribute("cardList", cardList);
		request.setAttribute("menuList", menuList);
		request.setAttribute("billList", billList);
		request.setAttribute("lineItemList", lineItemList);
		
		return "/restaurant/bills.jsp";
	}
//	
//	String bills(HttpServletRequest request, HttpServletResponse response) {
//		int id = Integer.parseInt(StringUtils.defaultIfEmpty(request.getParameter("id"), "-1"));
//		Customer customer = ms.getCustomerOrBlank(id);
//		request.setAttribute("customer", customer);
//
//		return "/customer.jsp";
//	}

//	public String listCardTypes(HttpServletRequest request) {
//		List<CardTypes> cardTypeList;
//		try {
//			cardTypeList = dao.getCardTypes();
//			request.setAttribute("cardTypeList", cardTypeList);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ctx.log("카드타입 목록 생성 과정에서 문제 발생!!");
//			request.setAttribute("error", "카드타입 목록이 정상적으로 처리되지 않았습니다!!");
//		}
//		return "restaurant/restaurant.jsp";
//	}
//
//	public String listCoupons(HttpServletRequest request) {
//		List<Coupons> couponList;
//		try {
//			couponList = dao.getCoupons();
//			request.setAttribute("couponList", couponList);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ctx.log("쿠폰 목록 생성 과정에서 문제 발생!!");
//			request.setAttribute("error", "쿠폰 목록이 정상적으로 처리되지 않았습니다!!");
//		}
//		return "restaurant/restaurant.jsp";
//	}
//
//	public String listCreditCards(HttpServletRequest request) {
//		List<CreditCards> creditCardList;
//		try {
//			creditCardList = dao.getCreditCards();
//			request.setAttribute("creditCardList", creditCardList);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ctx.log("크레딧카드 목록 생성 과정에서 문제 발생!!");
//			request.setAttribute("error", "크레딧카드 목록이 정상적으로 처리되지 않았습니다!!");
//		}
//		return "restaurant/restaurant.jsp";
//	}
//
//	public String listDrinks(HttpServletRequest request) {
//		List<Drinks> drinkList;
//		try {
//			drinkList = dao.getDrinks();
//			request.setAttribute("drinkList", drinkList);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ctx.log("음료 목록 생성 과정에서 문제 발생!!");
//			request.setAttribute("error", "음료 목록이 정상적으로 처리되지 않았습니다!!");
//		}
//		return "restaurant/restaurant.jsp";
//	}
//
//	public String listMenus(HttpServletRequest request) {
//		List<Menus> menuList;
//		try {
//			menuList = dao.getMenus();
//			request.setAttribute("menuList", menuList);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ctx.log("메뉴 목록 생성 과정에서 문제 발생!!");
//			request.setAttribute("error", "메뉴 목록이 정상적으로 처리되지 않았습니다!!");
//		}
//		return "restaurant/restaurant.jsp";
//	}

//	public String getCardTypes(HttpServletRequest request) {
//		int cardTypeId = Integer.parseInt(request.getParameter("cardTypeId"));
//		try {
//			CardTypes ct = dao.getCardTypes(cardTypeId);
//			request.setAttribute("cardTypes", ct);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			ctx.log("카드타입을 가져오는 과정에서 문제 발생!!");
//			request.setAttribute("error", "카드타입을 정상적으로 가져오지 못했습니다!!");
//		}
//		return "restaurant/restraurant.jsp";
//	}
//	public String getCoupons(HttpServletRequest request) {
//		int couponId = Integer.parseInt(request.getParameter("couponId"));
//		try {
//			Coupons c = dao.getCoupons(couponId);
//			request.setAttribute("coupons", c);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			ctx.log("쿠폰을 가져오는 과정에서 문제 발생!!");
//			request.setAttribute("error", "쿠폰을 정상적으로 가져오지 못했습니다!!");
//		}
//		return "ch10/newsView.jsp";
//	}
//	public String getRestaurant(HttpServletRequest request) {
//		int aid = Integer.parseInt(request.getParameter("aid"));
//		try {
//			News n = dao.getNews(aid);
//			request.setAttribute("news", n);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			ctx.log("뉴스를 가져오는 과정에서 문제 발생!!");
//			request.setAttribute("error", "뉴스를 정상적으로 가져오지 못했습니다!!");
//		}
//		return "ch10/newsView.jsp";
//	}
//	public String getRestaurant(HttpServletRequest request) {
//		int aid = Integer.parseInt(request.getParameter("aid"));
//		try {
//			News n = dao.getNews(aid);
//			request.setAttribute("news", n);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			ctx.log("뉴스를 가져오는 과정에서 문제 발생!!");
//			request.setAttribute("error", "뉴스를 정상적으로 가져오지 못했습니다!!");
//		}
//		return "ch10/newsView.jsp";
//	}
//	public String getRestaurant(HttpServletRequest request) {
//		int aid = Integer.parseInt(request.getParameter("aid"));
//		try {
//			News n = dao.getNews(aid);
//			request.setAttribute("news", n);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			ctx.log("뉴스를 가져오는 과정에서 문제 발생!!");
//			request.setAttribute("error", "뉴스를 정상적으로 가져오지 못했습니다!!");
//		}
//		return "ch10/newsView.jsp";
//	}

//	public String addNews(HttpServletRequest request) {
//		News n = new News();
//		try {
//			// 이미지 파일 저장
//			Part part = request.getPart("file");
//			String fileName = getFilename(part);
//			if (fileName != null && !fileName.isEmpty()) {
//				part.write(fileName);
//			}
//			// 입력값을 News 객체로 매핑
//			BeanUtils.populate(n, request.getParameterMap());
//			
//			// 이미지 파일 이름을 News 객체에도 저장
//			n.setImg("/img/" + fileName);
//			dao.addNews(n);
//		} catch (Exception e) {
//			e.printStackTrace();
//			ctx.log("뉴스 추가 과정에서 문제 발생!!");
//			request.setAttribute("error", "뉴스가 정상적으로 등록되지 않았습니다!!");
//			return listNews(request);
//		}
//		return "redirect:/news.nhn?action=listNews";
//	}
//
//	public String deleteNews(HttpServletRequest request) {
//		int aid = Integer.parseInt(request.getParameter("aid"));
//		try {
//			dao.delNews(aid);
//		} catch (SQLException e) {
//			e.printStackTrace();
//			ctx.log("뉴스 삭제 과정에서 문제 발생!!");
//			request.setAttribute("error", "뉴스가 정상적으로 삭제되지 않았습니다!!");
//			return listNews(request);
//		}
//		return "redirect:/news.nhn?action=listNews";
//	}
//
//	private String getFilename(Part part) {
//		String fileName = null;
//		// 파일 이름이 들어 있는 헤더 영역을 가져옴
//		String header = part.getHeader("content-disposition");
//		System.out.println("Header => " + header);
//
//		// 파일 이름이 들어 있는 속성 부분의 시작 위치를 가져와 " " 사이의 값만 가지고 옴
//		int start = header.indexOf("filename=");
//		fileName = header.substring(start + 10, header.length() - 1);
//		ctx.log("파일명:" + fileName);
//		return fileName;
//	}
}
