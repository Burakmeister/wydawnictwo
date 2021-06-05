import planning_department.Author;
import planning_department.LongContract;
import planning_department.OrderContract;
import src.LiteraryItem;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ContractMenu implements ActionListener
{
    private final int x=900;    //szerokość okna
    private final int y=675;    //wysokość okna

    private int k;
    private JPanel panel;
    private JButton addLongContract;
    private JButton addOrderContract;
    public LongContract longContract;
    private ArrayList<OrderContract> listOfOrders;
    private Author author;
    public PlanningDepartmentWindow mainWindow;

    private JDialog LongContractAddWindow;
    JButton cancelContract;
    JButton addLong;
    JTextField price;
    JTextField date;

    private JDialog OrderContractAddWindow;
    JButton addLiteraryItem;
    JButton cancelOrder;
    JButton addOrder;
    private LiteraryItem literaryItem;

    private float priceData;
    private String dateData;

    public ContractMenu(Author a, PlanningDepartmentWindow mainWindow) 
    {
        this.mainWindow=mainWindow;
        this.author=a;
        this.k=0;
        mainWindow.setTitle("Umowy: " + a);
        mainWindow.remove(mainWindow.panel);
        panel = new JPanel();
        panel.setLayout(null);
        
        mainWindow.prev.removeActionListener(mainWindow);
        mainWindow.next.removeActionListener(mainWindow);
        mainWindow.back.removeActionListener(mainWindow);

        listOfOrders = new ArrayList<OrderContract>();
        for(int i=0 ; i<mainWindow.publisher.planningDepartment.howManyContracts(); i++)
        {
            if(mainWindow.publisher.planningDepartment.getContract(i).getAuthor().equals(author) && mainWindow.publisher.planningDepartment.getContract(i) instanceof OrderContract)
            {
                listOfOrders.add( (OrderContract) mainWindow.publisher.planningDepartment.getContract(i));
            }
            else if(mainWindow.publisher.planningDepartment.getContract(i).getAuthor().equals(author) && mainWindow.publisher.planningDepartment.getContract(i) instanceof LongContract)
            {
                longContract = (LongContract) mainWindow.publisher.planningDepartment.getContract(i);
            }
        }

        for(int i=0 ; i<20 ; i++)
        {
            mainWindow.but[i].removeActionListener(mainWindow);
            mainWindow.but[i].addActionListener(this);
        }

        if(longContract != null)
        {
            addOrderContract = new JButton("Zlecenie");
        }
        else
        {
            addLongContract = new JButton("Umowa o prace");
            addOrderContract = new JButton("Umowa / Zlecenie");
            addLongContract.setBounds(5, y/9*8, x/9, y/25);
            addLongContract.addActionListener(this);
            panel.add(addLongContract);
        }
        addOrderContract.setBounds(x/2-20-x/18, y/9*8, x/9, y/25);
        addOrderContract.addActionListener(this);
        panel.add(addOrderContract);

        mainWindow.back.addActionListener(this);
        mainWindow.prev.addActionListener(this);
        mainWindow.next.addActionListener(this);
        panel.add(mainWindow.prev);
        panel.add(mainWindow.back);
        panel.add(mainWindow.next);
        mainWindow.add(panel);

        refreshPage();
    }

    
    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == mainWindow.prev)
        {
            if(this.k>0)
            {
                this.k--;
                refreshPage();
            }
        }

        if(e.getSource() == mainWindow.next)
        {
            if(listOfOrders.size() > k*19+19)
            {
                this.k++;
                refreshPage();
            } 
        }

        if(e.getSource() == cancelContract)
        {
            if(LongContractAddWindow == null)
            OrderContractAddWindow.setVisible(false);
            else if(LongContractAddWindow.isVisible())
                LongContractAddWindow.setVisible(false);
            if(OrderContractAddWindow == null)
                LongContractAddWindow.setVisible(false);
            else if(OrderContractAddWindow.isVisible())
            OrderContractAddWindow.setVisible(false);
        }


        if(e.getSource() == addLongContract)
        {
            longContractWindow();
        }
        if(e.getSource() == addOrderContract)
        {
            orderContractWindow();
        }
        if(e.getSource() == addLong)
        {
            try
            {
                priceData = Float.parseFloat(price.getText());
            }
            catch(Exception ex)
            {
                ex = new Exception("Nie wprowadzono typu float!");
                ex.getStackTrace();
                return;
            }
            dateData = date.getText();
            System.out.println(dateData);
            LongContractAddWindow.setVisible(false);
            mainWindow.publisher.planningDepartment.addLongContract(priceData, author, dateData);
            longContract = new LongContract(priceData, author, dateData);
            mainWindow.publisher.saveData();
            addLongContract.setVisible(false);
            refreshPage();
        }

        if(e.getSource() == addOrder)
        {
            if(literaryItem != null)
            {
                try
                {
                    priceData = Float.parseFloat(price.getText());
                }
                catch(Exception ex)
                {
                    ex = new Exception("Nie wprowadzono typu float!");
                    ex.getStackTrace();
                    return;
                }
                dateData = date.getText();
                OrderContractAddWindow.setVisible(false);
                mainWindow.publisher.planningDepartment.addOrderContract(priceData, author, dateData, literaryItem, false);
                listOfOrders.add(new OrderContract(priceData, author, dateData, literaryItem, false));
                mainWindow.publisher.saveData();
                refreshPage();
            }
            else
            return;
        }

        if(e.getSource() == mainWindow.back)
        {
            mainWindow.remove(panel);
            mainWindow.comeback();
        }

        for(int i=0 ; i<20 ; i++)
            if(e.getSource() == mainWindow.but[i])
            {

            }
        if(e.getSource() == addLiteraryItem)
        {
            new LiteraryItemAdderWindow(this, author, mainWindow.iconImage);
        }
    }

    public void refreshPage()
    {
        int j=0;
        for(int i=0 ; i<20 ; i++)
            panel.remove(mainWindow.but[i]);
        if(longContract != null)
            {
                mainWindow.but[j].setText("Umowa o prace: " + longContract);
                mainWindow.but[j].setFont(new Font("Arial", (Font.BOLD), 15));
                mainWindow.but[j].setBounds(x/10, y/17, x-200, 25);
                panel.add(mainWindow.but[j]);
                j++;
                for(int i=k*19 ; i<k*19+19 && i<listOfOrders.size() ; i++)
                {
                    mainWindow.but[j].setText("Zlecenie: "+ listOfOrders.get(i) + "  " + listOfOrders.get(i).getLiteraryItem().getIsbn() + " " + listOfOrders.get(i).getLiteraryItem().getTitle());
                    mainWindow.but[j].setFont(new Font("Arial", (Font.BOLD), 15));
                    mainWindow.but[j].setBounds(x/10, y/17+25*(j+1), x-200, 25);
                    panel.add(mainWindow.but[j]);
                    j++;
                }
            }
        else
            {
                for(int i=k*20 ; i<k*20+20 && i<listOfOrders.size() ; i++)
                {
                    mainWindow.but[j].setText("Umowa/Zlecenie: "+ listOfOrders.get(i) + "  " + listOfOrders.get(i).getLiteraryItem().getIsbn() + " " + listOfOrders.get(i).getLiteraryItem().getTitle());
                    mainWindow.but[j].setFont(new Font("Arial", (Font.BOLD), 15));
                    mainWindow.but[j].setBounds(x/10, y/17+25*(j), x-200, 25);
                    panel.add(mainWindow.but[j]);
                    j++;
                }
            }
        panel.revalidate();
        panel.repaint();
    }

    public void setLiteraryItem(LiteraryItem literaryItem)
    {
        this.literaryItem = literaryItem;
    }

    private void orderContractWindow()
    {
        OrderContractAddWindow = new JDialog(mainWindow,"Zlecenie");
        OrderContractAddWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int x, y;
        OrderContractAddWindow.setBounds(1, 1, x=300, y=400);
        OrderContractAddWindow.setLocationRelativeTo(null);
        OrderContractAddWindow.setIconImage(mainWindow.iconImage.getImage());
        OrderContractAddWindow.setLayout(null);
        date = new JTextField("Data wygasniecia");
        price = new JTextField("Pensja");
        addOrder = new JButton("Dodaj");
        addLiteraryItem = new JButton("Ksiazka");
        cancelContract = new JButton("Cofnij");
        date.addActionListener(this);
        price.addActionListener(this);
        addOrder.addActionListener(this);
        cancelContract.addActionListener(this);
        addLiteraryItem.addActionListener(this);
        date.setBounds(x*1/10, y/6-y/10, x*3/4, y/14);
        price.setBounds(x*1/10, 2*y/6-y/10, x*3/4, y/14);
        addLiteraryItem.setBounds(x*1/10, 2*y/6-y/10, x*3/4, y/14);
        addLiteraryItem.setBounds(x*1/10, 3*y/6-y/10, x*3/4, y/14);
        cancelContract.setBounds(x*9/10-x*5/16, y*3/4, x*1/4, x*1/7);
        addOrder.setBounds(x*1/10, y*3/4, x*1/4, x*1/7);
        OrderContractAddWindow.add(cancelContract);
        OrderContractAddWindow.add(addOrder);
        OrderContractAddWindow.add(price);
        OrderContractAddWindow.add(addLiteraryItem);
        OrderContractAddWindow.add(date);
        OrderContractAddWindow.setVisible(true);
    }
    private void longContractWindow()
    {
        LongContractAddWindow = new JDialog(mainWindow,"Umowa o prace");
        LongContractAddWindow.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        int x, y;
        LongContractAddWindow.setBounds(1, 1, x=300, y=400);
        LongContractAddWindow.setLocationRelativeTo(null);
        LongContractAddWindow.setIconImage(mainWindow.iconImage.getImage());
        LongContractAddWindow.setLayout(null);
        date = new JTextField("Data wygasniecia");
        price = new JTextField("Pensja");
        addLong = new JButton("Dodaj");
        cancelContract = new JButton("Cofnij");
        date.addActionListener(this);
        price.addActionListener(this);
        addLong.addActionListener(this);
        cancelContract.addActionListener(this);
        date.setBounds(x*1/10, y/6-y/10, x*3/4, y/14);
        price.setBounds(x*1/10, 2*y/6-y/10, x*3/4, y/14);
        cancelContract.setBounds(x*9/10-x*5/16, y*3/4, x*1/4, x*1/7);
        addLong.setBounds(x*1/10, y*3/4, x*1/4, x*1/7);
        LongContractAddWindow.add(cancelContract);
        LongContractAddWindow.add(addLong);
        LongContractAddWindow.add(date);
        LongContractAddWindow.add(price);
        LongContractAddWindow.setVisible(true);
        panel.remove(LongContractAddWindow);
        addOrderContract.setText("Zlecenie");
    } 

}
