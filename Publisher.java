import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import planning_department.*;

public class Publisher implements Serializable
{
    public PlanningDepartment planningDepartment;
    //private PrintingManagement printingManagement;
    //private Shop shop;

    public Publisher()
    {
        this.planningDepartment = new PlanningDepartment();
        //this.printingManagement = new PrintingManagement();
        //this.shop = new Shop();
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
            ex = new Exception("Nie udalo sie otworzyc pliku!");
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
            ex = new Exception("Nie udalo sie otworzyc pliku!");
            ex.printStackTrace();
            System.exit(0);
        }
        return null;   
    }
}
