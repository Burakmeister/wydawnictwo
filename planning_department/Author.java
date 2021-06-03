package planning_department;

import java.io.Serializable;

public class Author implements Serializable
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
        return (nr + ")  " + authorId + "  "+ firstname + "  " + surname + "  " + age);
    }
    public boolean equals(Author a)
    {
        if(this.firstname.equals(a.firstname) && this.surname.equals(a.surname) && this.age == a.age && this.authorId.equals(a.authorId))
            return true;
        else
            return false;
    }
}
