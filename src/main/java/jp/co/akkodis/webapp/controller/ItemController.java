package jp.co.akkodis.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jp.co.akkodis.webapp.bean.Item;
import jp.co.akkodis.webapp.model.Cart;
import jp.co.akkodis.webapp.service.ItemService;

@Controller
@SessionAttributes("cart")
public class ItemController {

	@Autowired
	ItemService service;

	@GetMapping(value = { "/", "/itemlist" })
	public String list(Model model) {
		List<Item> list = service.getAllItemList();
		while (list.size() % 3 != 0) {
			list.add(new Item());
		}
		model.addAttribute("itemList", list);
		return "list";
	}

	@GetMapping(value = "/detail")
	public String detail(@RequestParam Integer itemId, Model model) {
		Item item = service.getItemById(itemId);
		model.addAttribute("item", item);
		return "detail";
	}

	@GetMapping(value = "/cart")
	public String cart(
			@RequestParam Integer itemId, @RequestParam Integer amount, 
			@RequestParam String action, Cart cart) {
		switch (action) {
		case "view":
			break;
		case "add": {
			cart.add(service.getItemById(itemId), amount);
			break;
		}
		case "clear": {
			cart.clear();
			break;
		}
		case "removeItem": {
			cart.removeItem(itemId);
			break;
		}
		case "setAmount": {
			cart.setAmount(itemId, amount);
			break;
		}
		default:
			;
		}
		return "cart";
	}

	@GetMapping(value = "/register")
	public String register() {
		return "register";
	}
}
