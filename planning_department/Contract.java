package planning_department;

public abstract class Contract 
{
    protected int nr;
    protected Author author;
    protected float price;
    protected String date;
    public Contract()
    {
    }
    public Contract(int nr, float price, Author author, String date)
    {
        this.nr=nr;
        this.author=author;
        this.price=price;
    }
    public String getDate()
    {
        return this.date;
    }
    public Author getAuthor()
    {
        return this.author;
    }
    public float getPrice()
    {
        return this.price;
    }
    public void setNr(int nr)
    {
        this.nr=nr;
    }
    public abstract String toString();
}
