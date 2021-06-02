import javax.swing.*;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

private JPanel panel;
public class AuthorMenu extends JFrame
{
    public AuthorMenu(Author a)
    {
        super("Autor");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(1, 1, 680, 510);
        setLocationRelativeTo(null);
        ImageIcon iconImage = new ImageIcon(this.getClass().getResource("images/Icon.png"));
        setIconImage(iconImage.getImage());
        setResizable(false);
        panel = new JPanel();

        add(panel);
    }
}
