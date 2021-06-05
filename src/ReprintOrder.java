package src;
public class ReprintOrder {
    private LiteraryItem literaryItem;
    private int count;

    public ReprintOrder(LiteraryItem literaryItem, int count) {
        this.literaryItem = literaryItem;
        this.count = count;
    }

    public LiteraryItem getLiteraryItem() {
        return literaryItem;
    }

    public int getCount() {
        return count;
    }
}
