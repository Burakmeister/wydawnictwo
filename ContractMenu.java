import javax.swing.*;
import planning_department.Author;
//import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContractMenu extends JFrame implements ActionListener
{
    final int x=300;    //szerokość okna
    final int y=400;    //wysokość okna

    private int k;
    private JPanel panel;
    private JButton 
    private Author author;

    private PlanningDepartmentWindow mainWindow;

    private String firstnameData, surnameData, authorIdData;
    int ageData;

    public ContractMenu(Author a, PlanningDepartmentWindow mainWindow) 
    {
        super("Umowy: " + a);
        this.mainWindow=mainWindow;
        this.k=0;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(1, 1, x, y);
        setLocationRelativeTo(null);
        setIconImage(iconImage.getImage());
        setResizable(false);
        panel = new JPanel();
        panel.setLayout(null);

        authorsMenu = new JRadioButton("Edycja", true);
        contractsMenu = new JRadioButton("Umowy");
        contractsMenu.addActionListener(this);
        authorsMenu.addActionListener(this);
        ButtonGroup group = new ButtonGroup();
        group.add(authorsMenu);
        group.add(contractsMenu);

        authorsMenu.setBounds(5, y/18*15, x/9, y/25);
        contractsMenu.setBounds(5, y/18*16, x/9, y/25);

        but = new JButton[20];
        for(int i=0 ; i<20 ; i++)
        {
            but[i] = new JButton();
            but[i].addActionListener(this);
        }

        publisher = publisher.loadData();
        int j=0;
        for(int i=k*20 ; i<k*20+20 && i<publisher.planningDepartment.howManyAuthors(); i++)
        {
                but[j].setText("" + publisher.planningDepartment.getAuthor(i+1));
                but[j].setFont(new Font("Arial", (Font.BOLD), 15));
                but[j].setBounds(x/10, y/17+25*(j), x-200, 25);
                panel.add(but[j]);
                j++;
        }

        prev = new JButton("<");
        addAuthor = new JButton("Dodaj");
        back = new JButton("Cofnij");
        next = new JButton(">");
        prev.setBounds(5, y/2, x/20, y/12);
        addAuthor.setBounds(x/2-20-x/18, y/9*8, x/9, y/25);
        back.setBounds(x-x/9-20, y/9*8, x/9, y/25);
        next.setBounds(x-x/20-20, y/2, x/20, y/12);
        back.addActionListener(this);
        prev.addActionListener(this);
        addAuthor.addActionListener(this);
        next.addActionListener(this);
        panel.add(prev);
        panel.add(contractsMenu);
        panel.add(authorsMenu);
        panel.add(addAuthor);
        panel.add(back);
        panel.add(next);

        add(panel);
        setVisible(true);
    }

    
    public void actionPerformed(ActionEvent e) 
    {
    }
}
