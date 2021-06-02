package planning_department;

public class LongContract extends Contract
{
    public LongContract(int nr, float price, Author author, String date)
    {
        super(nr, price, author, date);
    }

    public String toString()
    {
        return (nr + ")  " + price + "  " + date);
    }
}
