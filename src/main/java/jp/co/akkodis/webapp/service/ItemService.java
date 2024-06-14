package jp.co.akkodis.webapp.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.akkodis.webapp.bean.Item;
import jp.co.akkodis.webapp.model.ItemRepository;

@Service
public class ItemService {
	@Autowired
	ItemRepository repository;
	
	public List<Item> getAllItemList() {
		return (ArrayList<Item>) repository.findAll();
	}

}
