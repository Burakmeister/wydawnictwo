<<<<<<< HEAD
import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.ListIterator;
=======
package src;

import java.util.List;
>>>>>>> 13ac8906c945652e5c79aea95aaa02a02c31c635

public class Shop {
    private ArrayList<LiteraryItem> literaryItemList;

    private ShopInterface shopInterface;

    public Shop(ShopInterface mshopInterface) {
        this.literaryItemList = new ArrayList<LiteraryItem>();
        this.shopInterface = mshopInterface;
    }

    public void sell(ArrayList<LiteraryItem> items, int count) {
        for (LiteraryItem item : items) {
            if (item.getQuantity()>=count) { //dopisac wyjatek
                item.decreaseQuantity(count);
            }
        }
    }

    public ArrayList<LiteraryItem> getLiteraryItems() {
        return this.literaryItemList;
    }

    public void addLiteraryItem(LiteraryItem literaryItem) {
        this.literaryItemList.add(literaryItem);
    }

    public void orderReprint(LiteraryItem literaryItem, int count) {
        ReprintOrder reprintOrder = new ReprintOrder(literaryItem, count);
        shopInterface.reprint(reprintOrder);
        //return reprintOrder;
    }


}
