public class PrintingHouse {
    private long id;
    private boolean isAlbumPrintable;

    public PrintingHouse(boolean isAlbumPrintable) {
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
