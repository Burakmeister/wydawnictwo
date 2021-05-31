public class Book extends LiteraryItem{
    protected boolean isAlbum;

    public Book(String isbn, long authorId, double price, String title, int quantity, String genre) {
        super(isbn, authorId, price, genre, quantity, title);
    }

    @Override
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
}
