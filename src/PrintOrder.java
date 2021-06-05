package src;

import java.io.Serializable;

public class PrintOrder implements Serializable {

    private LiteraryItem literaryItem;

    private int count;
    private PrintingHouse printingHouse;
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

    public PrintingHouse getPrintingHouse() {
        return printingHouse;
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

    public void setPrintingHouse(PrintingHouse printingHouse) {
        this.printingHouse = printingHouse;
    }

    public void setDone(boolean done) {
        isDone = done;
    }

    @Override
    public String toString() {
        return literaryItem.getTitle()+" zamowione egzemplarze: "+count;
    }
}
