package jp.co.akkodis.webapp.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import jp.co.akkodis.webapp.bean.Item;

/**
 * ショッピングカートを表すクラスです。
 *
 * @author Kenji Takeuchi(Modis)
 */
public class Cart {

    /**
     * カート内のすべての商品データ。
     * キー（Key）が商品IDで、値（Value）が CartItem オブジェクト。
     */
    private Map<Integer, CartItem> cartData;

    /**
     * 新しいショッピングカートを作成します。
     */
    public Cart() {
        this.cartData = new HashMap<>();
    }

    /**
     * カートに商品を追加します。<br/>
     * 既にカートに追加済みの商品であれば数量を加算します。<br/>
     * 引数 item が null または amount が負数の場合、IllegalArgumentException がスローされます。
     *
     * @param item 商品
     * @param amount 数量
     *
     * @throws IllegalArgumentException 引数 item が null または amount が負数の場合
     */
    public void add(Item item, int amount) {
        if (item == null) {
            throw new IllegalArgumentException("item param is null.");
        }

        if (hasItem(item.getItemId())) {
            this.addAmount(item.getItemId(), amount);
        } else {
            this.cartData.put(item.getItemId(), new CartItem(item, amount));
        }
    }

    /**
     * カート内の商品の数量を加算します。
     * amount が負数の場合、IllegalArgumentException がスローされます。
     * 指定された商品が存在しない場合は何もしません。
     *
     * @param itemId 商品ID
     * @param amount 追加数量
     */
    public void addAmount(Integer itemId, int amount) {
        if (hasItem(itemId)) {
        	// amountの引数チェックはaddAmountメソッドに委譲
            this.cartData.get(itemId).addAmount(amount);
        }
    }

    /**
     * カート内の商品の数量を取得します。
     * カート内に指定された商品IDが見つからない場合、-1 を返します。
     *
     * @param itemId 商品ID
     *
     * @return カート内の商品の数量
     */
    public int getAmount(Integer itemId) {
        if (hasItem(itemId)) {
            return this.cartData.get(itemId).getAmount();
        } else {
            return -1;
        }
    }

    /**
     * カート内の商品の数量を設定します。<br/>
     * 設定数量が 0 の場合、カートから商品を削除します。<br/>
     * amount が負数の場合、IllegalArgumentException がスローされます。<br/>
     * 指定された商品が存在しない場合は何もしません。
     *
     * @param itemId 商品ID
     * @param amount 設定数量
     *
     * @throws IllegalArgumentException amount が負数の場合
     */
    public void setAmount(Integer itemId, int amount) {
        if (hasItem(itemId)) {
            if (amount == 0) {
                this.cartData.remove(itemId);
            } else {
                this.cartData.get(itemId).setAmount(amount);
            }
        }
    }

    /**
     * 指定された商品IDの商品がカート内に存在するかどうかを調べます。
     *
     * @param itemId 商品ID
     *
     * @return 商品IDが存在する場合はtrue 存在しない場合はfalse
     */
    public boolean hasItem(Integer itemId) {
        return this.cartData.containsKey(itemId);
    }

    /**
     * カート内のすべての商品IDを数え上げる反復子を取得します。
     *
     * @return カート内のすべての商品IDを数え上げる反復子
     */
    public Iterator<Integer> itemIdIterator() {
        return this.cartData.keySet().iterator();
    }

    /**
     * カート内の商品のリストを取得します。
     * @return カート内の商品のリスト
     */
    public List<CartItem> getCartItemList() {
        return new ArrayList<>(this.cartData.values());
    }

    /**
     * 指定された商品IDのカート内の商品情報を取得します。<br/>
     * 指定された商品が存在しない場合は null を返します。
     *
     * @param itemId 商品ID
     *
     * @return 商品IDのカート内の商品情報
     */
    public CartItem getCartItem(Integer itemId) {
        return this.cartData.get(itemId);
    }

    /**
     * カート内商品の総合計金額を計算します。
     * @return カート内商品の総合計金額
     */
    public int calcTotalSum() {
        int total = 0;
        for (CartItem ci : getCartItemList()) {
            total += ci.calcTotalPrice();
        }

        return total;
    }

    /**
     * カートの内容をクリアします。
     */
    public void clear() {
        this.cartData.clear();
    }

    /**
     * カート内に追加した商品の数を取得します。<br/>
     * 各商品の数量のことでありません。
     *
     * @return カート内に追加した商品の数
     */
    public int size() {
        return this.cartData.size();
    }

    /**
     * 指定された商品をカートから削除します。<br/>
     * 存在しない商品の場合は何もしません。
     *
     * @param itemId 商品ID
     */
    public void removeItem(Integer itemId) {
        // Mapのremoveメソッドは対象のキーがなければ何もしない仕様なので存在判定はここでは行わない
        this.cartData.remove(itemId);
    }
}
