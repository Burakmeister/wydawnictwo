import src.OutOfStockExeption;
import src.PrintOrder;
import src.PrintingHouse;
import src.WrongNumberException;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PrintingManagementWindow extends JFrame implements ActionListener {

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

    public PrintingManagementWindow(ImageIcon iconImage, MainMenu mainMenu) {
        super("Drukowanie");
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

        but = new JButton[20];
        for (int i = 0; i < 20; i++) {
            but[i] = new JButton();
            but[i].addActionListener(this);
        }

        publisher = publisher.loadData();
        int j = 0;
        for (int i = k * 20; i < k * 20 + 20 && i < publisher.printingManagement.getListOfPrintOrders().size(); i++) {
            but[j].setText("" + publisher.printingManagement.getListOfPrintOrders().get(j));
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
        for (int i = k * 20; i < k * 20 + 20 && i < publisher.printingManagement.getListOfPrintOrders().size(); i++) {
            but[j].setText("" + publisher.printingManagement.getListOfPrintOrders().get(j));
            but[j].setFont(new Font("Arial", (Font.BOLD), 15));
            but[j].setBounds(x / 10, y / 17 + 25 * (j), x - 200, 25);
            panel.add(but[j]);
            j++;
        }
        panel.revalidate();
        panel.repaint();
    }

    public void actionPerformed(ActionEvent e) {

        for (int i=0; i<20; i++) {
            if (e.getSource() == but[i])
            {
                PrintOrder order = publisher.printingManagement.getListOfPrintOrders().get(i);

                Object[] possibilities = {"0", "1", "2"};
                int selection = Integer.parseInt(String.valueOf(JOptionPane.showInputDialog(
                        null,
                        "Wybierz drukarnię\n"
                                + "albumy może drukować jedynie drukarnia nr. 2"+"\nDrukarnia:",
                        "Wybór drukarni",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        possibilities,
                        "1")));
                System.out.println(selection);
                PrintingHouse printingHouse = publisher.printingManagement.getListOfPrintingHouses().get(selection);
                order.setPrintingHouse(printingHouse);
                publisher.printingManagement.getListOfPrintOrders().remove(order);

                if (selection!= 3) {
                    int count = Integer.parseInt(JOptionPane.showInputDialog("Podaj ilość zamówionych egzemplarzy"));
                    order.setCount(count);
                    int result = JOptionPane.showConfirmDialog(null, "Wysłać do drukowania?", "Drukowanie",JOptionPane.OK_CANCEL_OPTION);
                    switch (result) {
                        case 0:
                            printingHouse.print(order);
                    }

                }
                refreshPage();
                publisher.saveData();
            }
        }

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

//    private JPanel createPrintingOptionPanel() {
//        JPanel panel = new JPanel();
//        final JButton button1 = new JButton("Drukarnia nr. 1");
//        final JButton button2 = new JButton("Drukarnia nr. 2");
//        final JButton button3 = new JButton("Drukarnia nr. 3");
//
//        button1.addActionListener(this);
//        button2.addActionListener(this);
//        button3.addActionListener(this);
//        panel.add(button1);
//        panel.add(button2);
//        panel.add(button3);
//
//        return panel;
//    }
}
