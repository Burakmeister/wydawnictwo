package planning_department;

public class LongContract extends Contract
{
    public LongContract(float price, Author author, String date)
    {
        super(price, author, date);
    }

    public String toString()
    {
        return (price + "  " + date);
    }
}
