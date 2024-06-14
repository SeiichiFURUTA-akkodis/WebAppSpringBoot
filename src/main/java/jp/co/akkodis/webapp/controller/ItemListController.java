package jp.co.akkodis.webapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jp.co.akkodis.webapp.bean.Item;
import jp.co.akkodis.webapp.service.ItemService;

@Controller
public class ItemListController {
	
	@Autowired
	ItemService service;
	
	@GetMapping(value = {"/", "/itemlist"})
	public String list(Model model) {
		List<Item> list = service.getAllItemList();
		while (list.size() % 3 != 0) {
			list.add(new Item());
		}
		model.addAttribute("itemList", list);
		return "list";
	}

}
