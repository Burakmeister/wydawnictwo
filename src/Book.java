public class Book extends LiteraryItem{
    protected boolean isAlbum;

    public Book(String isbn, Author author, double price, String title, int quantity, String genre) {
        super(isbn, author, price, genre, quantity, title);
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
