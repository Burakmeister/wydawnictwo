public class Author
{
    private int nr;
    private String firstname;
    private String surname;
    private int age;
    private String authorId;
   
    public Author(int nr, String firstname, String surname, int age, String authorId)
    {
        this.nr=nr;
        this.firstname=firstname;
        this.surname=surname;
        this.age=age;
        this.authorId=authorId;
    }
    public String getFirstname()
    {
        return this.firstname;
    }
    public String getSurname()
    {
        return this.surname;
    }
    public int getAge()
    {
        return this.age;
    }
    public String getAuthorId()
    {
        return this.authorId;
    }
    public int getNr()
    {
        return this.nr;
    }
    public void setNr(int nr)
    {
        this.nr=nr;
    }
    public String toString()
    {
        return (nr + ")  " + firstname + "  " + surname + "  " + age);
    }
}
