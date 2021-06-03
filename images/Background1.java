package images;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
 
import javax.imageio.ImageIO;
import javax.swing.JPanel;
 
public class Background1 extends JPanel {
 
 	private BufferedImage image;
 
 	public Background1() 
     {
 		File imageFile = new File("images/MainMenu.jpg");
 		try 
        {
 			image = ImageIO.read(imageFile);
 		} 
        catch (IOException e) 
        {
 			e.printStackTrace();
 		}
 
 		Dimension dimension = new Dimension(image.getWidth(), image.getHeight());
 		setPreferredSize(dimension);
 	}
 
 	public void paintComponent(Graphics g) 
    {
 		Graphics2D g2d = (Graphics2D) g;
 		g2d.drawImage(image, 0, 0, this);
 	}
 }