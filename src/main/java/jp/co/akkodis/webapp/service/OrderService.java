package jp.co.akkodis.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.akkodis.webapp.bean.OrderDetail;
import jp.co.akkodis.webapp.bean.OrderLog;
import jp.co.akkodis.webapp.model.OrderDetailRepository;
import jp.co.akkodis.webapp.model.OrderLogRepository;

@Service
public class OrderService {
	
	@Autowired
	OrderLogRepository repoLog;
	
	@Autowired
	OrderDetailRepository repoDetail;
	
	public void addOrderLog(OrderLog orderLog, List<OrderDetail> orderList) {
		repoLog.save(orderLog);
		repoDetail.saveAll(orderList);
	}

}
