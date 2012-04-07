import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UI extends JFrame implements ActionListener
{
	JButton prev, next;
	JLabel info;
	UI_ImagePanel ip;
	UI() throws Exception
	{
		super("Reddit Image Browser");
		setSize(800,600);

		Container c = this.getContentPane();
		c.setLayout(null);

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		int w = this.getSize().width;
		int h = this.getSize().height;
		int x = (dim.width-w)/2;
		int y = (dim.height-h)/2;
		this.setLocation(x, y);

		prev = new JButton("<<Prev");
		prev.setBounds(0,0,100,30);
		prev.addActionListener(this);

		next = new JButton("Next>>");
		next.setBounds(700,0,100,30);
		next.addActionListener(this);

		info = new JLabel("<html><h2>debian.gif</h2></html>");
		info.setHorizontalAlignment(JLabel.CENTER);
		info.setBounds(100,0,600,30);

		ip = new UI_ImagePanel();
		ip.setBounds(0,50,800,650);
		ip.setLayout(null);
		ip.setOpaque(true);

		c.add(prev);
		c.add(next);
		c.add(info);
		c.add(ip);

		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
	}

	public static void main(String abc[]) throws Exception
	{
		new UI();
	}
}
