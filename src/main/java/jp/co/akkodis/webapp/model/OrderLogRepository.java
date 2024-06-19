package jp.co.akkodis.webapp.model;

import org.springframework.data.repository.CrudRepository;

import jp.co.akkodis.webapp.bean.OrderLog;

public interface OrderLogRepository extends CrudRepository<OrderLog,String> {

}
