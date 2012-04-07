import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class UI extends JFrame implements ActionListener
{
	JButton prev, next;
	JLabel info;
	UI()
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

		info = new JLabel("");
		info.setBounds(100,400,500,30);

		c.add(prev);
		c.add(next);
		c.add(info);

		this.setResizable(false);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==prev)
		{
			info.setText("This button will display the previous image.");
		}
		else if(e.getSource()==next)
		{
			info.setText("This button will display the next image.");
		}
		else;
	}

	public static void main(String abc[])
	{
		new UI();
	}
}
