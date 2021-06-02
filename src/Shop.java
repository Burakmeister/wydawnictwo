import java.util.Collection;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.ListIterator;

public class Shop {
    private ArrayList<LiteraryItem> literaryItemList;

    public Shop() {
        this.literaryItemList = new ArrayList<LiteraryItem>();
    }

    public void sell(ArrayList<LiteraryItem> items) {
        for (LiteraryItem item : items) {
            int count= 0;
            if (item.getQuantity()<count) { //dopisac wyjatek
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

    public ReprintOrder orderReprint(String isbn, int count) {
        for (LiteraryItem item : literaryItemList) {
            if (item.getIsbn().equals(isbn)) {
                ReprintOrder reprintOrder = new ReprintOrder(item, count);
                return reprintOrder;
            }
        }
        throw // wyjatek
    }

}
