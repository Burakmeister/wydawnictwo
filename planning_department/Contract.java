package planning_department;

import java.io.Serializable;

public abstract class Contract implements Serializable
{
    protected Author author;
    protected float price;
    protected String date;
    public Contract()
    {
    }
    public Contract(float price, Author author, String date)
    {
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
    public abstract String toString();
}
