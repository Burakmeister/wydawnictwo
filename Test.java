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
            for(int i=0; i<pub.planningDepartment.howManyAuthors(); i++)
                System.out.println(pub.planningDepartment.getAuthor(i+1));
            System.out.println("1.Dodaj");
            menu = scan.next().charAt(0);
            switch(menu)
            {
                case '1':
                {
                    pub.planningDepartment.addAuthor("firstname", "surname", 20, "authorId");
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
