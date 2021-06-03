import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Publisher implements Serializable, ShopInterface
{
    private PlanningDepartment planningDepartment;
    public PrintingManagement printingManagement;
    private Shop shop;

    public Publisher()
    {
        //this.planningDepartment = new PlanningDepartment();
        this.printingManagement = new PrintingManagement();
        this.shop = new Shop(this::reprint);
    }

    public void saveData()
    {
        try 
        {
            ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream("data.bin"));
            save.writeObject(this);
            save.close();
        } 
        catch (Exception ex)
        {
            ex.printStackTrace();
            System.exit(0);
        }
    }

    public Publisher loadData()
    {
        try 
        {
            ObjectInputStream load = new ObjectInputStream(new FileInputStream("data.bin"));
            Publisher sec = new Publisher();
            sec = ( Publisher )load.readObject();
            load.close();
            return sec;
        } 
        catch (Exception ex) 
        {
            ex.printStackTrace();
            System.exit(0);
        }
        return null;   
    }

    @Override
    public void reprint(ReprintOrder reprintOrder) {
        printingManagement.prepareReprint(reprintOrder);
    }
}
