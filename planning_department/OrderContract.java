package planning_department;

import src.*;
public class OrderContract extends Contract
{
    private LiteraryItem item;
    private boolean status;
    public OrderContract(float price, Author author, String date, LiteraryItem item, boolean status)
    {
        super(price, author, date);
        this.item = item;
        this.status = status;
    }
    public LiteraryItem getLiteraryItem()
    {
        return this.item;
    }
    public boolean contractStatus()
    {
        return this.status;
    }
    public void contractStatus(boolean newStatus)
    {
        this.status = newStatus;
    }
    public String toString()
    {
        return (price + "  " + date + "  " + status);
    }
}
