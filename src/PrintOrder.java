package src;

import java.io.Serializable;

public class PrintOrder implements Serializable {

    private LiteraryItem literaryItem;

    private int count;
    private long printingHouseId;
    private boolean isDone;

    public PrintOrder(LiteraryItem literaryItem, int count) {
        this.literaryItem = literaryItem;
        this.count = count;
        this.isDone = false;
    }

    public LiteraryItem getLiteraryItem() {
        return literaryItem;
    }

    public int getCount() {
        return count;
    }

    public long getPrintingHouseId() {
        return printingHouseId;
    }

    public boolean isDone() {
        return isDone;
    }

    public void setLiteraryItem(LiteraryItem literaryItem) {
        this.literaryItem = literaryItem;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setPrintingHouseId(long printingHouseId) {
        this.printingHouseId = printingHouseId;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return literaryItem.getTitle();
    }
}
