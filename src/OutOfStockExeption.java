package src;

public class OutOfStockExeption extends Exception {
    private LiteraryItem literaryItem;

    public OutOfStockExeption(LiteraryItem literaryItem) {
        this.literaryItem = literaryItem;
    }

    public LiteraryItem getLiteraryItem() {
        return literaryItem;
    }

    @Override
    public String getMessage() {
        return "Brak wystarczającej ilości w magazynie";
    }
}
