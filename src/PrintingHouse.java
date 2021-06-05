package src;

import java.io.Serializable;

public class PrintingHouse implements Serializable {
    private long id;
    private boolean isAlbumPrintable;

    public PrintingHouse(boolean isAlbumPrintable, long id) {
        this.id = id;
        this.isAlbumPrintable = isAlbumPrintable;
    }

    public long getId() {
        return id;
    }

    public boolean isAlbumPrintable() {
        return isAlbumPrintable;
    }

    public void print(PrintOrder order) {
        order.getLiteraryItem().increaseQuantity(order.getCount());
        order.setDone(true);
    }
}
