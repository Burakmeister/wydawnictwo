import src.*;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import planning_department.*;

public class Publisher implements Serializable, ShopInterface
{
    public PlanningDepartment planningDepartment;
    public PrintingManagement printingManagement;
    public Shop shop;



    final private String filePath = "data.bin";

    public Publisher()
    {
        this.planningDepartment = new PlanningDepartment();
        this.printingManagement = new PrintingManagement();
        this.shop = new Shop();
//        this::reprint
    }

    public void saveData()
    {
        try 
        {
            ObjectOutputStream save = new ObjectOutputStream(new FileOutputStream(filePath));
            save.writeObject(this);
            save.close();
        } 
        catch (Exception ex)
        {
            ex = new Exception("Nie udalo sie otworzyc pliku do zapisu!");
            ex.printStackTrace();
            System.exit(0);
        }
    }

    public Publisher loadData()
    {
        try 
        {
            ObjectInputStream load = new ObjectInputStream(new FileInputStream(filePath));
            Publisher sec = new Publisher();
            sec = ( Publisher )load.readObject();
            load.close();
            return sec;
        } 
        catch (Exception ex) 
        {
            ex = new Exception("Nie udalo sie otworzyc pliku do odczytu!");
            ex.printStackTrace();
            return new Publisher();
        }
    }
    @Override
    public void reprint(ReprintOrder reprintOrder) {
        printingManagement.prepareReprint(reprintOrder);
    }
}
