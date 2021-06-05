
package src;
import planning_department.*;

import java.io.Serializable;

public class Book extends LiteraryItem implements Serializable {
    protected boolean isAlbum;

    public Book(String isbn, Author author, double price, String title, int quantity, String genre, boolean isAlbum) {
        super(isbn, author, price, genre, quantity, title);
        this.isAlbum = isAlbum;

    }

    public boolean isAlbum() {
        return isAlbum;
    }

    public String toString() {
        return title+" Cena:"+price+" ilość w magazynie:"+quantity;
    }

    public String bookProperties() {
        return title+" gatunek literacki:"+" Cena:"+price+" ilość w magazynie:"+quantity;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Book)) {
            return false;
        }
        Book book = (Book) obj;

        return isbn.equals(book.getIsbn());
    }
}
