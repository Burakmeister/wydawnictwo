import src.*;
import java.util.Scanner;
public class Test 
{
    public static void main(String[] args)
    {
        Publisher pub = new Publisher();
        pub = pub.loadData();
        Scanner scan = new Scanner(System.in);
        while(true)
        {
            char menu;
            for(int i=0; i<pub.shop.getLiteraryItems().size(); i++)
                System.out.println(pub.shop.getLiteraryItems().get(i));
            System.out.println("1.Dodaj");
            menu = scan.next().charAt(0);
            switch(menu)
            {
                case '1':
                {
                    pub.shop.getLiteraryItems().add(new Book("34",3423423,34.3,"ksiazka", 34, "fantasy"));
                    break;
                }
                case '2':
                {
                    scan.close();
                    pub.saveData();
                    System.exit(0);
                }
                default:
                break;
            }
        }
    }
}
