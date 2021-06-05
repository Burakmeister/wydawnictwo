import src.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class ShopWindow extends JFrame implements ActionListener {

        private final int x=900;    //szerokość okna
        private final int y=675;    //wysokość okna

        private MainMenu mainMenu;
        private JPanel panel;
        private JButton []but;
        private JButton next, prev;
        private JButton back;
        private int k;
        public Publisher publisher;

        public ShopWindow(ImageIcon iconImage, MainMenu mainMenu) {
            super("Sklep");
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
            for (int i = k * 20; i < k * 20 + 20 && i < publisher.shop.getLiteraryItems().size(); i++) {
                but[j].setText("" + publisher.shop.getLiteraryItems().get(j));
                but[j].setFont(new Font("Arial", (Font.BOLD), 15));
                but[j].setBounds(x / 10, y / 17 + 25 * (j), x - 200, 25);
                panel.add(but[j]);
                j++;
            }

            prev = new JButton("<");
            back = new JButton("Cofnij");
            next = new JButton(">");
            prev.setBounds(5, y / 2, x / 20, y / 12);
            back.setBounds(x - x / 9 - 20, y / 9 * 8, x / 9, y / 25);
            next.setBounds(x - x / 20 - 20, y / 2, x / 20, y / 12);
            back.addActionListener(this);
            prev.addActionListener(this);
            next.addActionListener(this);
            panel.add(prev);
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
                but[j].addActionListener(this);
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
                    Object[] options = {"Tak", "Nie"};
                    if (publisher.shop.getLiteraryItems().get(k*20+i).getQuantity() == 0) {
                        int uwaga = JOptionPane.showOptionDialog(null, "Brak wystarczającej ilości w magazynie Czy chcesz złożyć zamówienie dodruku?", "Uwaga", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                        if (uwaga == 0) {
                            publisher.printingManagement.addPrintOrder(publisher.shop.orderReprint(publisher.shop.getLiteraryItems().get(k*20+i),0));
                        }
                    }else {
                        int count = Integer.parseInt(JOptionPane.showInputDialog("Podaj ilość którą chcesz zakupić"));
                        try {
                            publisher.shop.getLiteraryItems().get(k*20+i).decreaseQuantity(count);
                        } catch (WrongNumberException wrongNumberException) {
                            JOptionPane.showMessageDialog(null, wrongNumberException.getMessage(),"Uwaga", JOptionPane.ERROR_MESSAGE);
                            System.out.println(wrongNumberException.getMessage());
                        } catch (OutOfStockExeption outOfStockExeption) {
                            int uwaga = JOptionPane.showOptionDialog(null, outOfStockExeption.getMessage() + " Czy chcesz złożyć zamówienie dodruku?", "Uwaga", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, options, options[0]);
                            if (uwaga == 0) {
                                publisher.printingManagement.addPrintOrder(publisher.shop.orderReprint(outOfStockExeption.getLiteraryItem(), 0));
                            }
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
    }