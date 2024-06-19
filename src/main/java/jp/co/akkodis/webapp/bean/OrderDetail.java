package jp.co.akkodis.webapp.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 注文履歴の１レコードの詳細情報クラスです。
 */
@Data
@NoArgsConstructor
@Table(name = "t_order_detail")
public class OrderDetail {

	@Id
	private int id;
	
	@Column(value ="order_id")
	private String orderId;
	
	@Column(value ="order_item_id")
	private int orderItemId;
	
	@Column(value ="order_amount")
	private int orderAmount;

	public OrderDetail(String orderId, int orderItemId, int orderAmount) {
		super();
		this.orderId = orderId;
		this.orderItemId = orderItemId;
		this.orderAmount = orderAmount;
	}
}
