package src;

public class PrintOrder {
<<<<<<< HEAD
    private LiteraryItem literaryItem;
=======
    private Book book;
>>>>>>> 13ac8906c945652e5c79aea95aaa02a02c31c635
    private int count;
    private long printingHouseId;
    private boolean isDone;

<<<<<<< HEAD
    public LiteraryItem getLiteraryItem() {
        return literaryItem;
=======
    public Book getBook() {
        return book;
>>>>>>> 13ac8906c945652e5c79aea95aaa02a02c31c635
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
}
