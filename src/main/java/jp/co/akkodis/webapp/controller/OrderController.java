package jp.co.akkodis.webapp.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.co.akkodis.webapp.bean.OrderDetail;
import jp.co.akkodis.webapp.bean.OrderLog;
import jp.co.akkodis.webapp.model.Cart;
import jp.co.akkodis.webapp.model.CartItem;
import jp.co.akkodis.webapp.service.OrderService;

@Controller
@SessionAttributes("cart")
public class OrderController {
	
	@Autowired
	OrderService service;
	
	@PostMapping(value = "/complete")
	public String complete(@RequestParam String customerName, Cart cart) {
		UUID orderId = UUID.randomUUID();
		OrderLog orderLog = new OrderLog(orderId.toString(), customerName);
		List<CartItem> cartItemList = cart.getCartItemList();
		List<OrderDetail> orderList = new ArrayList<OrderDetail>();
		for (CartItem ci: cartItemList) {
			orderList.add(new OrderDetail(orderId.toString(), ci.getItem().getItemId(), ci.getAmount()));
		}
		service.addOrderLog(orderLog, orderList);
		cart.clear();
		return "purchase";
	}
}
