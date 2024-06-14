package jp.co.akkodis.webapp.model;

import jp.co.akkodis.webapp.bean.Item;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ショッピングカート内の商品を表すクラスです。
 *
 * @author Kenji Takeuchi(Modis)
 */
@Data
@AllArgsConstructor
public class CartItem {

    // 商品
    private Item item;
    // 数量
    private int amount;

    /**
     * 数量を設定します。<br/>
     * 引数amountが負数の場合、IllegalArgumentException がスローされます。
     *
     * @param amount 数量
     * @throws IllegalArgumentException 引数amountが負数の場合
     */
    public void setAmount(int amount) {
        if (amount < 0) {
            throw new IllegalArgumentException("amount should be larger than 0");
        }
        this.amount = amount;
    }

    /**
     * 指定数量分を現在の数量に加えます。<br/>
     * 引数 da が負数の場合、IllegalArgumentException をスローします。
     *
     * @param da 加える数量
     * @return 加えた後の数量
     * @throws IllegalArgumentException 引数 da が負数の場合
     */
    public int addAmount(int da) {
        if (da < 0) {
            throw new IllegalArgumentException("da should be larger than 0");
        }
        this.amount += da;
        return this.amount;
    }

    /**
     * 合計金額（商品価格 × 数量）を計算します。
     * @return 合計金額
     */
    public int calcTotalPrice() {
        return this.amount * this.item.getPrice();
    }

    /**
     * オブジェクトの文字列表現を返します。<br/>
     * 返される文字列は、[CartItem id="商品ID" name="商品名" price="価格" amount="数量"] です。<br/>
     * 例: [CartItem id="117" name="りんご" price="100" amount="3"]
     *
     * @return オブジェクトの文字列表現
     */
    @Override
    public String toString() {
        return String.format("[CartItem id=\"%d\" name=\"%s\" price=\"%d\" amount=\"%d\"]",
                this.item.getItemId(),
                this.item.getItemName(),
                this.item.getPrice(),
                this.amount);
    }
}
