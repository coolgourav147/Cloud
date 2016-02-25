import java.awt.Checkbox;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Cloud extends JFrame implements ActionListener{
      Connection conn;
      Statement stmt;
      PreparedStatement pstm,pstm1;
      JTextField txtf1;
      JPasswordField txtf2,txtf3;
      JTextArea Txta;
      JButton b1;
      JCheckBox c1,c2,c3;
      JLabel l1,l2,l3,l4;
      int flag;
      String user,pass;
      int uid,uid1;
	public Cloud()
	{
		
			
		
				
				this.setVisible(true);
				this.setSize(500, 500);
				this.setLayout(null);
				this.setResizable(false);
				this.setDefaultCloseOperation(EXIT_ON_CLOSE);
				l1=new JLabel("Username:");
				l1.setBounds(100, 30, 65, 15);
				l2=new JLabel("Password:");
				l2.setBounds(100, 80, 65, 15);
				l3=new JLabel("Re-enter pass:");
				l3.setBounds(100, 130, 120, 15);
				l4=new JLabel("Service:");
				l4.setBounds(100, 190, 50, 15);
				txtf1=new JTextField();
				txtf1.setBounds(190, 28, 120, 25);
				txtf2=new JPasswordField();
				txtf2.setBounds(190, 78, 120, 25);
				txtf3=new JPasswordField();
				txtf3.setBounds(190, 128, 120, 25);
				c1=new JCheckBox("IAAS");
				c1.setBounds(190, 188, 60, 20);
				c2=new JCheckBox("SAAS");
				//c2.addActionListener(this);
				c2.setBounds(190, 210, 60, 20);
				c2.setSelected(true);
				c2.setEnabled(false);
				c3=new JCheckBox("STAAS");
				c3.setBounds(190, 230, 70, 20);
				b1=new JButton("Sign-Up");
				b1.setBounds(190, 300, 100, 30);
				this.add(l1);
				this.add(l2);
				this.add(l3);
				this.add(l4);
				this.add(txtf1);
				this.add(txtf2);
				this.add(txtf3);
				this.add(c1);
				this.add(c2);
				this.add(c3);
				this.add(b1);
				b1.addActionListener(this);
			
		
	}		
	
	
	
	
	/*public static void main(String[] args) {
		Cloud r=new Cloud();
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
*/



	@Override
	public void actionPerformed(ActionEvent r) {
		// TODO Auto-generated method stub
		
		System.out.println(r.getSource());
		System.out.println(b1);
		
		
		if(r.getSource().equals(b1))
		{
			
			System.out.println("this is submit button");
			
			
			try {
				conn=DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/owncloud","root","mahi550");
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				//e2.printStackTrace();
				System.out.println("this is gourav");
			}
			try {
				stmt=conn.createStatement();
				conn.setAutoCommit(false);
			} catch (SQLException e2) {
				// TODO Auto-generated catch block
				System.out.println("this is after auto cmnt");
				//e2.printStackTrace();
			}
			String us,pa,ch2 = "false",ch3 ="false";
			
			us=txtf2.getText();
			pa=txtf3.getText();
			int ln=us.length();
			int chk=us.compareTo(pa);
			System.out.println(chk+" "+ln);
			System.out.println("in action");
			System.out.println(txtf1.getText());
			try {
				
				ResultSet rs=stmt.executeQuery("select * from signup");
				while(rs.next())
				{
					
					System.out.println("in result");
					
					if(rs.getString(2).equals(txtf1.getText()))
					{
					flag=1;	
					break;
					}
					else
					{
						flag=0;
					}
									
				}
				
				System.out.println(flag);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("this is after flag");
			}
			if(flag==1)
			{
			JOptionPane.showMessageDialog(this, "username already present try another");
			}
			
			else
			{
		  if(chk!=0||ln==0)
		  {
			JOptionPane.showMessageDialog(this, "Empty passwords or they don't match"); 
		  }
		  /*
		   if()
			{
				JOptionPane.showMessageDialog(this, "Please select atleast one service");
			}
			
				  */
		  else
		  {
			try {
				System.out.println("in insert");
				user=txtf1.getText();  
				pass=txtf2.getText();
				//uid1;
				pstm=conn.prepareStatement("insert into signup values(?,?,?)");
				pstm.setInt(1,0);
				pstm.setString(2, user);
				pstm.setString(3, pass);
				pstm.execute();
				if(c1.isSelected())
				{
					ch2="true";
				}
					else
				   ch2="false";	
				if(c3.isSelected())
				{
					ch3="true";
				}
				else
				{
					ch3="false";
				}
				ResultSet rl=stmt.executeQuery("select * from signup");
				while(rl.next())
				{
					System.out.println("in scroll");
					if(rl.last())
					{
						uid=rl.getInt(1);
					}
					
					
				}
				System.out.println("in service");
				System.out.println(ch2+ch3);
				pstm1=conn.prepareStatement("insert into service values(?,?,?,?)");
				pstm1.setInt(1,uid);
				pstm1.setString(2, ch2);
				pstm1.setString(3, "true");
				pstm1.setString(4, ch3);
				pstm1.execute();
				conn.commit();
				conn.close();
				//conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		//		System.out.println("fater close");
			}
			  
		  }
		  
		}
		
		
}
		
	}
			
}		
		
		
	


