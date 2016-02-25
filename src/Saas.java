import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;


public class Saas extends JFrame implements ActionListener {

	
	JButton firefox,gedit,Office,terminal;
	
	public Saas() {
		
		firefox = new JButton("Firefox");
		firefox.addActionListener(this);
		gedit= new JButton("Gedit");
		gedit.addActionListener(this);
		Office= new JButton("Redhat");
		Office.addActionListener(this);
		terminal = new JButton("terminal");
		terminal.addActionListener(this);
		this.add(firefox);
		this.add(gedit);
		this.add(Office);
		this.add(terminal);
		
		
		setLayout(new FlowLayout());
		setResizable(false);
		setVisible(true);
		setSize(700,700);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
	
		
		
	}
	

	@Override
	public void actionPerformed(ActionEvent e) {
		
	
		
		if(e.getSource().equals(firefox)){
			

	//		System.out.println("sudo sshpass -p \"mahi550\" ssh -X  root@192.168.100.195 gedit");
			ProcessBuilder builder = new ProcessBuilder("sh", "firefox.sh");
			
			try {
				Process p = builder.start();
				p.waitFor();
				System.out.println(p.exitValue());
			} catch (IOException e1) {
				
				e1.printStackTrace();
			} catch (InterruptedException e1) {
			
				e1.printStackTrace();
			}
			
			
			
		}

		if(e.getSource().equals(gedit)){
			
			ProcessBuilder builder = new ProcessBuilder("sh", "gedit.sh");
			try {
				Process p = builder.start();
				p.waitFor();
				System.out.println(p.exitValue());
			} catch (IOException e1) {
			
				e1.printStackTrace();
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
		}

		if(e.getSource().equals(Office)){
			

			ProcessBuilder builder = new ProcessBuilder("sh", "Iaas.sh");
			try {
				Process p = builder.start();
				p.waitFor();
				System.out.println(p.exitValue());
			} catch (IOException | InterruptedException e1) {
			
				e1.printStackTrace();
			}

			
		}

		if(e.getSource().equals(terminal)){
			
			System.out.println("terminal called");
			
			
		}
		
	}
	
}
