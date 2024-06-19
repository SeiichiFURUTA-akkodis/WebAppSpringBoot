package jp.co.akkodis.webapp.model;

import org.springframework.data.repository.CrudRepository;

import jp.co.akkodis.webapp.bean.OrderDetail;

public interface OrderDetailRepository extends CrudRepository<OrderDetail,Integer> {

}
