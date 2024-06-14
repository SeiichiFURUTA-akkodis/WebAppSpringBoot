package jp.co.akkodis.webapp.bean;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

import lombok.Data;

/**
 * 商品を表すクラスです。
 */
@Data
//@Table(name="t_item")
public class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(value="itemid")
    private Integer itemId = 0;       // 商品ID
    
    @Column(value="itemname")
    private String itemname;      // 商品名
    /*
    private String categoryCode; // 分類コード
    */
    @Column(value="catname")
    private String categoryName;  // 分類名
    
    @Column(value="price")
    private Integer price;        // 値段
    /*
    private String explanation;   // 商品説明
    private String imageName;     // 画像ファイル名
    private String originalId;    // 商品固有のID
	*/
}
