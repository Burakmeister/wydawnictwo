package src;
import planning_department.*;

import java.io.Serializable;

public abstract class LiteraryItem implements Serializable {
    public LiteraryItem() {}

    public LiteraryItem(String isbn, Author author, double price, String genre, int quantity, String title) {
        this.isbn = isbn;
        this.author = author;
        this.price = price;
        this.genre = genre;
        this.quantity = quantity;
        this.title = title;
    }

    protected String isbn;
    protected Author author;
    protected double price;
    protected String genre;
    protected int quantity;
    protected String title;

    public String getIsbn() {
        return isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public double getPrice() {
        return price;
    }

    public String getGenre() { return genre; }

    public int getQuantity() { return quantity; }

    public String getTitle() { return title; }

    public void decreaseQuantity(int count) throws WrongNumberException, OutOfStockExeption{
        if (count<0 || count==0) {
            throw new WrongNumberException(count);
        }
        if (count>quantity) {
            throw new OutOfStockExeption(this);
        }
        this.quantity -= count;
    }

    public void increaseQuantity(int count) {
        this.quantity += count;
    }

    public abstract String toString();
}
