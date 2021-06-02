import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PlanningDepartmentWindow extends JFrame implements ActionListener
{
    private JPanel panel;
    private JButton []but;
    private JButton next, prev;
    private JButton mode;
    private JButton back;
    private int k;
    Publisher publisher;

    public PlanningDepartmentWindow(int k) 
    {
        super("Dzial programowy");
        this.k=k;
        publisher=new Publisher();
        publisher=publisher.loadData();
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(1, 1, 680, 510);
        setLocationRelativeTo(null);
        ImageIcon iconImage = new ImageIcon(this.getClass().getResource("images/Icon.png"));
        setIconImage(iconImage.getImage());
        setResizable(false);
        panel = new JPanel();
        panel.setLayout(null);

        but = new JButton[20];
        int j=0;
        for(int i=k*20 ; i<k*20+20 && i<publisher.planningDepartment.howManyAuthors(); i++)
        {
                but[j] = new JButton("" + publisher.planningDepartment.getAuthor(i+1));
                but[j].setFont(new Font("Arial", (Font.LAYOUT_LEFT_TO_RIGHT), 14));
                but[j].setBounds(80, 10+20*(j), 500, 20);
                but[j].addActionListener(this);
                panel.add(but[j]);
                j++;
        }

        prev = new JButton("<");
        mode = new JButton("Umowy");
        back = new JButton("Cofnij");
        next = new JButton(">");
        prev.setBounds(5, 200, 50, 50);
        mode.setBounds(280, 420, 100, 30);
        back.setBounds(530, 420, 100, 30);
        next.setBounds(610, 200, 50, 50);
        back.addActionListener(this);
        prev.addActionListener(this);
        next.addActionListener(this);
        panel.add(prev);
        panel.add(mode);
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
            MainMenu menu = new MainMenu();
        }
        if(e.getSource() == prev)
        {
            if(k>0){
            this.k--;
            int j=0;
            for(int i=0 ; i<20 ; i++)
                panel.remove(but[i]);
            for(int i=k*20 ; i<k*20+20 && i<publisher.planningDepartment.howManyAuthors(); i++)
            {
                    but[j] = new JButton("" + publisher.planningDepartment.getAuthor(i+1));
                    but[j].setFont(new Font("Arial", (Font.LAYOUT_LEFT_TO_RIGHT), 14));
                    but[j].setBounds(80, 10+20*(j), 500, 20);
                    but[j].addActionListener(this);
                    panel.add(but[j]);
                    j++;
            }
            panel.revalidate();
            panel.repaint();
            }
        }
        if(e.getSource() == next)
        {
            this.k++;
            int j=0;
            for(int i=0 ; i<20 ; i++)
                panel.remove(but[i]);
            for(int i=k*20 ; i<k*20+20 && i<publisher.planningDepartment.howManyAuthors(); i++)
            {
                but[j] = new JButton("" + publisher.planningDepartment.getAuthor(i+1));
                but[j].setFont(new Font("Arial", (Font.LAYOUT_LEFT_TO_RIGHT), 14));
                but[j].setBounds(80, 10+20*(j), 500, 20);
                but[j].addActionListener(this);
                panel.add(but[j]);
                j++;
            }
            panel.revalidate();
            panel.repaint();
        }
        if(e.getSource() == but[0])
            AuthorMenu a = new AuthorMenu(publisher.planningDepartment.getAuthor((k*20+1));
        if(e.getSource() == but[1])
            AuthorMenu a = new AuthorMenu(publisher.planningDepartment.getAuthor((k*20+2));
        if(e.getSource() == but[2])
            AuthorMenu a = new AuthorMenu(publisher.planningDepartment.getAuthor((k*20+3));
        if(e.getSource() == but[3])
            AuthorMenu a = new AuthorMenu(publisher.planningDepartment.getAuthor((k*20)+4);   
        if(e.getSource() == but[4])
            AuthorMenu a = new AuthorMenu(but[4]);
        if(e.getSource() == but[5])
            AuthorMenu a = new AuthorMenu(but[5]);
        if(e.getSource() == but[6])
            AuthorMenu a = new AuthorMenu(but[6]);
        if(e.getSource() == but[7])
            AuthorMenu a = new AuthorMenu(but[7]);
        if(e.getSource() == but[8])
            AuthorMenu a = new AuthorMenu(but[8]);
        if(e.getSource() == but[9])
            AuthorMenu a = new AuthorMenu(but[9]);
        if(e.getSource() == but[10])
            AuthorMenu a = new AuthorMenu(but[10]);
        if(e.getSource() == but[11])
            AuthorMenu a = new AuthorMenu(but[11]);
        if(e.getSource() == but[12])
            AuthorMenu a = new AuthorMenu(but[12]);
        if(e.getSource() == but[13])
            AuthorMenu a = new AuthorMenu(but[13]);
        if(e.getSource() == but[14])
            AuthorMenu a = new AuthorMenu(but[14]);
        if(e.getSource() == but[15])
            AuthorMenu a = new AuthorMenu(but[15]);
        if(e.getSource() == but[16])
            AuthorMenu a = new AuthorMenu(but[16]);
        if(e.getSource() == but[17])
            AuthorMenu a = new AuthorMenu(but[17]);
        if(e.getSource() == but[18])
            AuthorMenu a = new AuthorMenu(but[18]);
        if(e.getSource() == but[19])
            AuthorMenu a = new AuthorMenu(but[19]);
    }
}