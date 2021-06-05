import images.*;
import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Objects;

public class MainMenu extends JFrame implements ActionListener
{
    private JPanel panelBack;
    private JButton but1, but2, but3, but4;
    private ImageIcon iconImage;

    public MainMenu() 
    {
        super("Wydawnictwo");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(1, 1, 680, 510);
        setLocationRelativeTo(null);
        iconImage = new ImageIcon(Objects.requireNonNull(this.getClass().getResource("images\\Icon.png")));
        setIconImage(iconImage.getImage());
        setResizable(false);
        panelBack = new Background1();
        panelBack.setLayout(null);

        but1 = new JButton("Dzial Programowy");
        but2 = new JButton("Dzial Druku");
        but3 = new JButton("Sklep");
        but4 = new JButton("Wyjscie");
        but1.setFont(new Font("Arial", (Font.BOLD), 16));
        but2.setFont(new Font("Arial", (Font.BOLD), 16));
        but3.setFont(new Font("Arial", (Font.BOLD), 16));
        but4.setFont(new Font("Arial", (Font.BOLD), 16));
        but1.setBounds(100, 52, 200, 80);
        but2.setBounds(100, 154, 200, 80);
        but3.setBounds(100, 256, 200, 80);
        but4.setBounds(100, 358, 200, 80);
        but1.addActionListener(this);
        but2.addActionListener(this);
        but3.addActionListener(this);
        but4.addActionListener(this);
        panelBack.add(but1);
        panelBack.add(but2);
        panelBack.add(but3);
        panelBack.add(but4);

        add(panelBack);  
        pack();
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) 
    {
        if(e.getSource() == but1){
            setVisible(false);
            new PlanningDepartmentWindow(iconImage, this);
        }

        if(e.getSource() == but2){
            setVisible(false);
            PrintingManagementWindow printingManagement = new PrintingManagementWindow(iconImage, this);
//            JOptionPane.showMessageDialog(null,"alert","alert",JOptionPane.ERROR_MESSAGE);
        }

        if(e.getSource() == but3){
            setVisible(false);
            ShopWindow shop = new ShopWindow(iconImage, this);
        }
        
        if(e.getSource() == but4)
            System.exit(0);
    }

    public static void main(String[] args)
    {
        new MainMenu();
    }    
}