import planning_department.Author;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class AuthorMenu extends JFrame implements ActionListener
{
    final int x=300;    //szerokość okna
    final int y=400;    //wysokość okna

    private JPanel panel;
    private Author author;
    private JButton add;
    private JButton cancel;
    private JButton delete;
    private JTextField firstname;
    private JTextField surname;
    private JTextField age;
    private JTextField authorId;
    private PlanningDepartmentWindow mainWindow;

    public boolean authorWillAdded;
    private String firstnameData, surnameData, authorIdData;
    int ageData;

    public AuthorMenu(Author a, PlanningDepartmentWindow mainWindow) 
    {
        super(a.toString());
        this.mainWindow=mainWindow;
        this.author = a;
        authorWillAdded=false;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(1, 1, x, y);
        setLocationRelativeTo(null);
        ImageIcon iconImage = new ImageIcon(this.getClass().getResource("images/Icon.png"));
        setIconImage(iconImage.getImage());
        setResizable(false);
        panel = new JPanel();
        panel.setLayout(null);
        firstname = new JTextField(a.getFirstname());
        surname = new JTextField(a.getSurname());
        age = new JTextField("" + a.getAge());
        authorId = new JTextField(a.getAuthorId());
        add = new JButton("Edytuj");
        delete = new JButton("Usun");
        cancel = new JButton("Cofnij");
        firstname.setBounds(x*1/10, y/6-y/10, x*3/4, y/14);
        surname.setBounds(x*1/10, 2*y/6-y/10, x*3/4, y/14);
        age.setBounds(x*1/10, 3*y/6-y/10, x*3/4, y/14);
        authorId.setBounds(x*1/10, 4*y/6-y/10, x*3/4, y/14);
        add.setBounds(x*1/12, y*3/4, x*1/4, x*1/7);
        delete.setBounds(x*3/8-x*1/60, y*3/4, x*1/4, x*1/7);
        cancel.setBounds(x*9/12-x*1/8, y*3/4, x*1/4, x*1/7);
        firstname.addActionListener(this);
        surname.addActionListener(this);
        age.addActionListener(this);
        authorId.addActionListener(this);
        add.addActionListener(this);
        delete.addActionListener(this);
        cancel.addActionListener(this);
        panel.add(firstname);
        panel.add(surname);
        panel.add(age);
        panel.add(authorId);
        panel.add(add);
        panel.add(delete);
        panel.add(cancel);
        add(panel);
        setVisible(true);
    }

    public AuthorMenu(PlanningDepartmentWindow mainWindow)
    {
        super("Dodaj autora");
        this.mainWindow=mainWindow;
        authorWillAdded=true;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(1, 1, x, y);
        setLocationRelativeTo(null);
        ImageIcon iconImage = new ImageIcon(this.getClass().getResource("images/Icon.png"));
        setIconImage(iconImage.getImage());
        setResizable(false);
        panel = new JPanel();
        panel.setLayout(null);
        firstname = new JTextField("Imie");
        surname = new JTextField("Nazwisko");
        age = new JTextField("Wiek");
        authorId = new JTextField("Pesel");
        add = new JButton("Dodaj");
        cancel = new JButton("Cofnij");
        firstname.addActionListener(this);
        surname.addActionListener(this);
        age.addActionListener(this);
        authorId.addActionListener(this);
        add.addActionListener(this);
        cancel.addActionListener(this);
        firstname.setBounds(x*1/10, y/6-y/10, x*3/4, y/14);
        surname.setBounds(x*1/10, 2*y/6-y/10, x*3/4, y/14);
        age.setBounds(x*1/10, 3*y/6-y/10, x*3/4, y/14);
        authorId.setBounds(x*1/10, 4*y/6-y/10, x*3/4, y/14);
        add.setBounds(x*1/10, y*3/4, x*1/4, x*1/7);
        cancel.setBounds(x*9/10-x*5/16, y*3/4, x*1/4, x*1/7);
        panel.add(firstname);
        panel.add(surname);
        panel.add(age);
        panel.add(authorId);
        panel.add(add);
        panel.add(cancel);
        add(panel);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == add)
        {
            try
            {
                ageData = Integer.parseInt(age.getText());
            }
            catch(Exception ex)
            {
                ex = new Exception("Nie wprowadzono typu int!");
                ex.getStackTrace();
                return;
            }
            surnameData = surname.getText();
            firstnameData = firstname.getText();
            authorIdData = authorId.getText();
            setVisible(false);

            if(authorWillAdded)
            {
                mainWindow.publisher.planningDepartment.addAuthor(firstnameData, surnameData, ageData, authorIdData);
                mainWindow.publisher.saveData();
                mainWindow.refreshPage();
            }
            else
            {
                int i;
                for(i=1; !mainWindow.publisher.planningDepartment.getAuthor(i).equals(author); i++)
                {
                }
                mainWindow.publisher.planningDepartment.getAuthor(i).setFirstname(firstnameData);
                mainWindow.publisher.planningDepartment.getAuthor(i).setSurname(surnameData);
                mainWindow.publisher.planningDepartment.getAuthor(i).setAge(ageData);
                mainWindow.publisher.planningDepartment.getAuthor(i).setAuthorId(authorIdData);
                for(int j=0 ; j<mainWindow.publisher.planningDepartment.howManyContracts() ; j++ )
                    if(mainWindow.publisher.planningDepartment.getContract(j).getAuthor().equals(author))
                    {
                        mainWindow.publisher.planningDepartment.getContract(j).setAuthor(mainWindow.publisher.planningDepartment.getAuthor(i));
                    }
                mainWindow.publisher.saveData();
                mainWindow.refreshPage();
            }
        }

        if(e.getSource() == delete)
        {
            int i;
                for(i=1; !mainWindow.publisher.planningDepartment.getAuthor(i).equals(author); i++)
                {
                }
                mainWindow.publisher.planningDepartment.deleteAuthor(i);
                mainWindow.refreshPage();
                mainWindow.publisher.saveData();
                setVisible(false);
        }

        if(e.getSource() == cancel)
        {
            setVisible(false);
        }
    }
}
