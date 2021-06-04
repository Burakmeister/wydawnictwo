import planning_department.Author;
import planning_department.LongContract;
import planning_department.OrderContract;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class ContractMenu extends JFrame implements ActionListener
{
    private final int x=900;    //szerokość okna
    private final int y=675;    //wysokość okna

    private int k;
    private JPanel panel;
    private JButton []but;
    private JButton next, prev;
    private JButton addContract;
    private JButton back;

    private LongContract longContract;
    private ArrayList<OrderContract> listOfOrders;
    private Author author;

    private PlanningDepartmentWindow mainWindow;

    private String firstnameData, surnameData, authorIdData;
    int ageData;

    public ContractMenu(Author a, PlanningDepartmentWindow mainWindow) 
    {
        super("Umowy: " + a);
        this.mainWindow=mainWindow;
        this.author=a;
        this.k=0;
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setBounds(1, 1, x, y);
        setLocationRelativeTo(null);
        ImageIcon iconImage = new ImageIcon(this.getClass().getResource("images/Icon.png"));
        setIconImage(iconImage.getImage());
        setResizable(false);
        panel = new JPanel();
        panel.setLayout(null);

        listOfOrders = new ArrayList<OrderContract>();
        for(int i=0 ; i<mainWindow.publisher.planningDepartment.howManyContracts(); i++)
        {
            if(mainWindow.publisher.planningDepartment.getContract(i).getAuthor().equals(author) && mainWindow.publisher.planningDepartment.getContract(i) instanceof OrderContract)
            {
                listOfOrders.add( (OrderContract) mainWindow.publisher.planningDepartment.getContract(i));
            }
            else if(mainWindow.publisher.planningDepartment.getContract(i).getAuthor().equals(author) && mainWindow.publisher.planningDepartment.getContract(i) instanceof LongContract)
            {
                longContract = (LongContract)mainWindow.publisher.planningDepartment.getContract(i);
            }
        }

        but = new JButton[20];
        for(int i=0 ; i<20 ; i++)
        {
            but[i] = new JButton();
            but[i].addActionListener(this);
        }

        if(longContract != null)
        {
            but[0] = new JButton("Umowa o prace: "+ longContract);
            but[0].addActionListener(this);
            int j=1;
            for(int i=k*19 ; i<k*19+19 && i<listOfOrders.size() ; i++)
            {
                but[j].setText("Zlecenie: "+ listOfOrders.get(i));
                but[j].setFont(new Font("Arial", (Font.BOLD), 15));
                but[j].setBounds(x/10, y/17+25*(j), x-200, 25);
                panel.add(but[j]);
                j++;
            }
        }
        else
        {
            int j=0;
            for(int i=k*20 ; i<k*20+20 && i<listOfOrders.size() ; i++)
            {
                but[j].setText("Umowa/Zlecenie: "+ listOfOrders.get(i));
                but[j].setFont(new Font("Arial", (Font.BOLD), 15));
                but[j].setBounds(x/10, y/17+25*(j), x-200, 25);
                panel.add(but[j]);
                j++;
            }
        }
        prev = new JButton("<");
        addContract = new JButton("Dodaj");
        back = new JButton("Cofnij");
        next = new JButton(">");
        prev.setBounds(5, y/2, x/20, y/12);
        addContract.setBounds(x/2-20-x/18, y/9*8, x/9, y/25);
        back.setBounds(x-x/9-20, y/9*8, x/9, y/25);
        next.setBounds(x-x/20-20, y/2, x/20, y/12);
        back.addActionListener(this);
        prev.addActionListener(this);
        addContract.addActionListener(this);
        next.addActionListener(this);
        panel.add(prev);
        panel.add(addContract);
        panel.add(back);
        panel.add(next);

        add(panel);
        setVisible(true);
    }

    
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == back)
        {
            setVisible(false);
        }
    }
}
