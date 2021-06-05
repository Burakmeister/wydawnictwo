package src;

import planning_department.*;

import java.io.Serializable;

public class Magazine extends LiteraryItem implements Serializable {
    private int cycle;

    public Magazine() {}

    public Magazine(String isbn, long authorId, double price, String title, int quantity, String genre, int cycle) {
        super(isbn, authorId, price, genre, quantity, title );
        this.cycle = cycle;
    }

    public int getCycle() {
        return cycle;
    }

    public void setCycle(int cycle) {
        this.cycle = cycle;
    }

    @Override
    public String toString() {
        return "Magazine{" +
                "isbn='" + isbn + '\'' +
                ", price=" + price +
                ", genre='" + genre + '\'' +
                ", quantity=" + quantity +
                ", title='" + title + '\'' +
                ", cycle=" + cycle +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Magazine)) {
            return false;
        }
        Magazine magazine = (Magazine) obj;

        return isbn.equals(magazine.getIsbn());
    }
}
