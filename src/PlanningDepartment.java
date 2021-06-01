import java.util.ArrayList;
public class PlanningDepartment 
{
    private ArrayList<Author> listOfAuthors;
    private ArrayList<Contract> listOfContracts;

    public PlanningDepartment()
    {
        this.listOfAuthors = new ArrayList<Author>();
        this.listOfContracts = new ArrayList<Contract>();
    }

    public Contract getContract(int nr)
    {
        return listOfContracts.get(nr-1);
    }
    public Author getAuthor(int nr)
    {
        return listOfAuthors.get(nr-1);
    }
    public void addLongContract(float price, Author author, String date)
    {
        listOfContracts.add(new LongContract(listOfContracts.size()+1, price, author, date));
    }
    public void addOrderContract(float price, Author author, String date, LiteraryItem item)
    {
        listOfContracts.add(new OrderContract(listOfContracts.size()+1, price, author, date, item, false));
    }
    public void addAuthor(String firstname, String surname, int age, String authorId)
    {
        listOfAuthors.add(new Author(listOfAuthors.size()+1, firstname, surname, age, authorId));
    }
    public void deleteContract(int idx)
    {
        listOfContracts.remove(idx-1);
        for(int i=idx-1 ; i<listOfContracts.size(); i++)
        {
            listOfContracts.get(i).setNr(i+1);
        }
    }
    public void deleteAuthor(int idx)
    {
        listOfAuthors.remove(idx-1);
        for(int i=idx-1 ; i<listOfAuthors.size(); i++)
        {
            listOfAuthors.get(i).setNr(i+1);
        }
    }
    public int howManyAuthors()
    {
        return listOfAuthors.size();
    }
    public int howManyContracts()
    {
        return listOfAuthors.size();
    }
}
