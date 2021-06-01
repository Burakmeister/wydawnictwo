public class Magazine extends LiteraryItem{
    private int cycle;

    public Magazine() {}

    public Magazine(String isbn, Author author, double price, String title, int quantity, String genre, int cycle) {
        super(isbn, author, price, genre, quantity, title );
        this.cycle = cycle;
    }

    public int getCycle() {
        return cycle;
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
}
