package jp.co.akkodis.webapp.bean;

import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.domain.Persistable;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_order_log")
public class OrderLog implements Persistable<String> {
	@Id
	@Column(value ="order_id")
	private String orderId;
	
	@Column(value ="customer_name")
	private String customerName;
	
	@Column(value ="order_date")
	private Date orderDate;

	public OrderLog(String orderId, String customerName) {
		this.orderId = orderId;
		this.customerName = customerName;
	}
	
	@Override
    public boolean isNew() {
        return true;
    }

	@Override
	public String getId() {
		// TODO 自動生成されたメソッド・スタブ
		return this.orderId;
	}

}
