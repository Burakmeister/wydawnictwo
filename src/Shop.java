import java.util.List;

public class Shop {
    private List<LiteraryItem> literaryItemList;

    public Shop(List<LiteraryItem> literaryItemList) {
        this.literaryItemList = literaryItemList;
    }

    public void sell(List<LiteraryItem> items) {
        for (LiteraryItem item : items) {
            int count= 0;
            if (item.getQuantity()<count) { //dopisac wyjatek
                item.decreaseQuantity(count);
            }
        }
    }

    public void displayLiteraryItems() {
        for (LiteraryItem item:
                literaryItemList) {
            item.toString();
        }
    }
}
