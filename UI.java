import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

class UI extends JFrame implements ActionListener
{
	JButton prev, next;
	JLabel info;
	UI_ImagePanel ip;
	JScrollPane sp;
	String linkarr[];
	JLabel url_info;
	int top;
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

		url_info = new JLabel("<html><h2>debian.gif</h2></html>");
		url_info.setHorizontalAlignment(JLabel.CENTER);

		ip = new UI_ImagePanel();
		ip.setLayout(null);
		ip.setOpaque(true);
		ip.setPreferredSize(new Dimension(795, 500));

		ip.add(url_info);

		sp = new JScrollPane(ip);
		sp.setBounds(0,50,795,550);

		c.add(prev);
		c.add(next);
		c.add(info);
		c.add(sp);

		linkarr = ParseLinks.readPage("http://www.reddit.com/r/fffffffuuuuuuuuuuuu/");
		top = 1;

		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		try{
		if(e.getSource()==prev)
		{
		}
		else if(e.getSource()==next)
		{
			if(top<Integer.parseInt(linkarr[0]))
			{
				String url = linkarr[++top];
				System.out.println(url);
				ImageDwnl.readIm(url, new File("temp-im.png"));
				int ht = ip.changeImage("temp-im.png");
				System.out.println(ht);
				url_info.setText("<html><h2>"+url+"</h2></html>");
				url_info.setBounds(100,0,600, 2*ht + 50);
				ip.setPreferredSize(new Dimension(800, ht + 100));
				sp.getVerticalScrollBar().setValue(0);
				repaint();
			}
		}
		else;
		}catch(Exception ex){System.out.println();}
	}

	public static void main(String abc[]) throws Exception
	{
		new UI();
	}
}
