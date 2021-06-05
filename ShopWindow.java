import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ShopWindow extends JFrame implements ActionListener {

    private final int x=900;    //szerokość okna
    private final int y=675;    //wysokość okna

    private MainMenu mainMenu;
    private boolean contractsMenuIsChecked;

    private JRadioButton contractsMenu, authorsMenu;
    private JPanel panel;
    private JButton []but;
    private JButton next, prev;
    private JButton addAuthor;
    private JButton back;
    private int k;
    public Publisher publisher;

    public ShopWindow(ImageIcon iconImage, MainMenu mainMenu) {
        super("Sklep");
        contractsMenuIsChecked = false;
        this.mainMenu = mainMenu;
        this.k = 0;
        publisher = new Publisher();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(1, 1, x, y);
        setLocationRelativeTo(null);
        setIconImage(iconImage.getImage());
        setResizable(false);
        panel = new JPanel();
        panel.setLayout(null);

//        authorsMenu = new JRadioButton("Edycja", true);
//        contractsMenu = new JRadioButton("Umowy");
//        contractsMenu.addActionListener(this);
//        authorsMenu.addActionListener(this);
//        ButtonGroup group = new ButtonGroup();
//        group.add(authorsMenu);
//        group.add(contractsMenu);

//        authorsMenu.setBounds(5, y / 18 * 15, x / 9, y / 25);
//        contractsMenu.setBounds(5, y / 18 * 16, x / 9, y / 25);

        but = new JButton[20];
        for (int i = 0; i < 20; i++) {
            but[i] = new JButton();
            but[i].addActionListener(this);
        }

        publisher = publisher.loadData();
        int j = 0;
        for (int i = k * 20; i < k * 20 + 20 && i < publisher.shop.getLiteraryItems().size(); i++) {
            but[j].setText("" + publisher.shop.getLiteraryItems().get(j));
            but[j].setFont(new Font("Arial", (Font.BOLD), 15));
            but[j].setBounds(x / 10, y / 17 + 25 * (j), x - 200, 25);
            panel.add(but[j]);
            j++;
        }

        prev = new JButton("<");
//        addAuthor = new JButton("Dodaj");
        back = new JButton("Cofnij");
        next = new JButton(">");
        prev.setBounds(5, y / 2, x / 20, y / 12);
//        addAuthor.setBounds(x / 2 - 20 - x / 18, y / 9 * 8, x / 9, y / 25);
        back.setBounds(x - x / 9 - 20, y / 9 * 8, x / 9, y / 25);
        next.setBounds(x - x / 20 - 20, y / 2, x / 20, y / 12);
        back.addActionListener(this);
        prev.addActionListener(this);
//        addAuthor.addActionListener(this);
        next.addActionListener(this);
        panel.add(prev);
//        panel.add(contractsMenu);
//        panel.add(authorsMenu);
//        panel.add(addAuthor);
        panel.add(back);
        panel.add(next);

        add(panel);
        setVisible(true);
    }

    public void refreshPage()
    {
        int j=0;
        for(int i=0 ; i<20 ; i++)
            panel.remove(but[i]);
        for(int i=k*20 ; i<k*20+20 && i<publisher.shop.getLiteraryItems().size(); i++)
        {
            but[j].setText("" + publisher.shop.getLiteraryItems().get(j));
            but[j].setFont(new Font("Arial", (Font.BOLD), 15));
            but[j].setBounds(x/10, y/17+25*(j), x-200, 25);
            panel.add(but[j]);
            j++;
        }
        panel.revalidate();
        panel.repaint();
    }

    public void actionPerformed(ActionEvent e) {

//        if(e.getSource() == authorsMenu)
//        {
//            contractsMenuIsChecked = false;
//        }
//        if(e.getSource() == contractsMenu)
//        {
//            contractsMenuIsChecked = true;
//        }
//        if(e.getSource() == addAuthor)
//        {
//            new AuthorMenu(this);
//            return;
//        }

        if(e.getSource() == back)
        {
            setVisible(false);
            mainMenu.setVisible(true);
            return;
        }

        if(e.getSource() == prev)
        {
            prevPage();
            return;
        }

        if(e.getSource() == next)
        {
            nextPage();
            return;
        }

//        for(int i=0 ; i<20 ; i++)
//            if(e.getSource() == but[i])
//            {
//                if(!contractsMenuIsChecked)
//                    new AuthorMenu(publisher.planningDepartment.getAuthor(k*20+i+1), this);
//                //else
//                //    new ContractMenu(publisher.planningDepartment.getAuthor(k*20+i+1), this);
//            }
    }

    private void nextPage()
    {
        this.k++;
        refreshPage();
    }

    private void prevPage()
    {
        if(k>0)
        {
            this.k--;
            refreshPage();
        }
    }
}
