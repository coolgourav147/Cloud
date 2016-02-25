import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Index extends JFrame implements ActionListener{
	JButton b1,b2;
	
	public Index() {
		// TODO Auto-generated constructor stub
		this.setVisible(true);
		this.setSize(400, 400);
		b1=new JButton("Login");
		b2=new JButton("Sign-up");
		this.add(b1);
		b1.addActionListener(this);
		
		this.add(b2);
		b2.addActionListener(this);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setLayout(new FlowLayout());
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Index w=new Index();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(b1))
		{
			Login w=new Login();
			System.out.println("b1");
		}
		if(e.getSource().equals(b2))
		{
			Cloud c=new Cloud();
			System.out.println("b2");
		}
	}

}
