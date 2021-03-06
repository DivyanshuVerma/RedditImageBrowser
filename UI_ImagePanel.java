import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;
import javax.swing.*;
 
public class UI_ImagePanel extends JPanel
{
	BufferedImage image;
	int x,y;
 
	public UI_ImagePanel(BufferedImage image, int x, int y) throws Exception
	{
		this.image = image;
	        this.x = x;
	        this.y = y;
	}

	public UI_ImagePanel(BufferedImage image) throws Exception
	{
		this(image,0,0);
	}

	public UI_ImagePanel(File f) throws Exception
	{
		this( ImageIO.read(f) ,0,0);
	}

	public UI_ImagePanel(String str) throws Exception
	{
		this( ImageIO.read(new File(str)) ,0,0);
	}

	public UI_ImagePanel() throws Exception
	{
		this( ImageIO.read(new File("debian.jpg")) ,234,0);
	}

	protected void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		//g.drawImage(image, x, y, 700,500, this);
		g.drawImage(image, x, y, this);
	}
	public int changeImage(String str) throws Exception
	{
		this.image =  ImageIO.read(new File(str));
		int w = image.getWidth();
		int pw = this.getWidth();
		x = (pw-w)/2;
		y = 0;
		paintComponent(this.getGraphics());
		return image.getHeight();
	}
}
