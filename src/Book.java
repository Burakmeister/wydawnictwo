<<<<<<< HEAD
import java.util.Objects;

=======
package src;
import planning_department.*;
>>>>>>> 13ac8906c945652e5c79aea95aaa02a02c31c635
public class Book extends LiteraryItem{
    protected boolean isAlbum;

    public Book(String isbn, long authorId, double price, String title, int quantity, String genre) {
        super(isbn, authorId, price, genre, quantity, title);
    }

    public boolean isAlbum() {
        return isAlbum;
    }

    public String toString() {
        return "Book{" +
                "isAlbum=" + isAlbum +
                "isbn='" + isbn + '\'' +
                ", price=" + price +
                ", genre='" + genre + '\'' +
                ", quantity=" + quantity +
                ", title='" + title + '\'' +
                '}';
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
