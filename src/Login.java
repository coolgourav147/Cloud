import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener {
		JLabel l1,l2;
		JTextField t1;
		JPasswordField p1;
		JButton b1,b2,b3,b4;
		Connection conn1;
		Statement stm1;
		
     public Login()
     {
    	 this.setVisible(true);
    	 this.setSize(500, 500);
    	 this.setLayout(null);
    	 this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
    	 l1=new JLabel("Username:");
    	 l1.setBounds(60, 30, 65, 20);
    	 l2=new JLabel("Password:");
    	 l2.setBounds(60, 60, 65, 20);
    	 t1=new JTextField();
    	 t1.setBounds(130, 29, 100, 25);
    	 p1=new JPasswordField();
    	 p1.setBounds(130, 59, 100, 25);
    	 b1=new JButton("Sign In");
    	 b1.setBounds(110, 100, 90, 25);
    	 b1.addActionListener(this);
    	 b2=new JButton("IAAS");
    	 b2.setBounds(10, 125, 90, 25);
    	 b2.setVisible(false);
    	 b3=new JButton("SAAS");
    	 b3.addActionListener(this);
    	 b3.setBounds(110, 125, 90, 25);
    	 b3.setVisible(false);
    	 b4=new JButton("STAAS");
    	 b4.setBounds(210, 125, 90, 25);
    	 b4.setVisible(false);

    	 
    	 this.add(l1);
    	 this.add(l2);
    	 this.add(t1);
    	 this.add(p1);
    	 this.add(b1);
    	 this.add(b2);
    	 this.add(b3);
    	 this.add(b4);
     }
	
	
	
	/*public static void main(String[] args) {
		Login l=new Login();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}*/



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		

		if(e.getSource().equals(b3)){
			
			//System.out.println("this is c2");
			
			new Saas();
			
			
			
		}
		
		
		if(e.getSource().equals(b1))
		{
		 String usr,pass,s1=null,s2=null,s3=null;
		 int flag = 0,uid = 0;
		 usr=t1.getText();
		 pass=p1.getText();
		 try {
			conn1=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/owncloud","root","mahi550");
	        
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 try {
			stm1=conn1.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
			
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 try {
			ResultSet rs=stm1.executeQuery("select * from signup");
			while(rs.next())
			{
				if(rs.getString(2).equals(usr)&&rs.getString(3).equals(pass))
				{
					uid=rs.getInt(1);
					flag=1;
					break;
				
				}
				else
				flag=0;
			}
			if(flag==1)
			{
			ResultSet r1=stm1.executeQuery("select * from service");
			while(r1.next())
			{
			  if(r1.getInt(1)==uid)
			  {
				s1=r1.getString(2);
				s2=r1.getString(3);
				s3=r1.getString(4);
				break; 
			  }
			
			/*if(s1.equals("true"))
			{
				
			}*/
				
			}
			if(s1.equals("true"))
			{
				l1.setVisible(false);
				l2.setVisible(false);
				t1.setVisible(false);
				p1.setVisible(false);
				b1.setVisible(false);
				b2.setVisible(true);
			}
			if(s2.equals("true"))
			{
				l1.setVisible(false);
				l2.setVisible(false);
				t1.setVisible(false);
				p1.setVisible(false);
				b1.setVisible(false);
				b3.setVisible(true);
			}
			if(s3.equals("true"))
			{
				l1.setVisible(false);
				l2.setVisible(false);
				t1.setVisible(false);
				p1.setVisible(false);
				b1.setVisible(false);
				b4.setVisible(true);
			}
			  System.out.println(s1+s2+s3);
			
			}
			else
				JOptionPane.showMessageDialog(this, "Invalid username and passsword");
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			
			
			
			
		}
		
	}

}
