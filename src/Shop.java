package src;
import java.io.Serializable;
import java.util.ArrayList;

public class Shop implements Serializable {
    private ArrayList<LiteraryItem> literaryItemList;

//    private ShopInterface shopInterface;

    public Shop(/*ShopInterface mshopInterface*/) {
        this.literaryItemList = new ArrayList<LiteraryItem>();
//        this.shopInterface = mshopInterface;
    }

    public void sell(ArrayList<LiteraryItem> items, int count) throws WrongNumberException, OutOfStockExeption {
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

    public PrintOrder orderReprint(LiteraryItem literaryItem, int count) {
        PrintOrder reprintOrder = new PrintOrder(literaryItem, count);
        //shopInterface.reprint(reprintOrder);
        return reprintOrder;
    }


}
