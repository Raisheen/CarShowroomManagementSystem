package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

import repository.*;
import entity.*;



public class ChangePasswordFrame extends JFrame implements ActionListener
{
	private final JPanel panel;
	private JLabel EnterIdLabel,EnterCurrentPasswordLabel,SetNewPasswordLabel;
	private JTextField EnterIdTF;
	private JPasswordField EnterCurrentPasswordPF;
	private JPasswordField SetNewPasswordPF;
	private final JButton NextBtn,BackBtn;
	    
	User user;
	UserRepo ur;
	public ChangePasswordFrame(User user)
	{
		super("CHANGE PASSWORD");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		
		panel = new JPanel();
		panel.setLayout(null);
		
                
                
                
        JLabel EnterIdLabel = new JLabel("Enter Id: ");
		EnterIdLabel.setBounds(160,60,250,40);
		
		panel.add(EnterIdLabel);

        JTextField EnterIdTF;
        EnterIdTF = new JTextField();
		EnterIdTF.setBounds(400,60,250,40);
		panel.add(EnterIdTF);

            
        JLabel EnterCurrentPasswordLabel = new JLabel("Enter Current Password: ");
		EnterCurrentPasswordLabel.setBounds(160,110,250,40);
		panel.add(EnterCurrentPasswordLabel);
                
                
        JPasswordField EnterCurrentPasswordPF;
        EnterCurrentPasswordPF = new JPasswordField();
		EnterCurrentPasswordPF.setBounds(400,110,250,40);
		panel.add(EnterCurrentPasswordPF);
                
                
        JLabel SetNewPasswordLabel = new JLabel("Set New Password: ");
		SetNewPasswordLabel.setBounds(160,160,250,40);
		panel.add(SetNewPasswordLabel);
                
                
        JPasswordField SetNewPasswordPF;
        SetNewPasswordPF = new JPasswordField();
		SetNewPasswordPF.setBounds(400,160,250,40);
		panel.add(SetNewPasswordPF);
                
        NextBtn = new JButton("NEXT");
		NextBtn.setBounds(250,250,150,40);
		NextBtn.addActionListener(this);
		panel.add(NextBtn);
		
        BackBtn = new JButton("BACK");
		BackBtn.setBounds(400,250,150,40);
		BackBtn.addActionListener(this);
		panel.add(BackBtn);
                 
               


            

	 this.add(panel);

    }
	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(NextBtn.getText()))
		{
			UserRepo ur = new UserRepo();
			User user = ur.getUser(EnterIdTF.getText(), EnterCurrentPasswordPF.getText());
			
			if(user != null)
			{
				user.setUserId(EnterIdTF.getText());
				user.setPassword(SetNewPasswordPF.getText());
				ur.updateUserPassword(EnterIdTF+"",SetNewPasswordPF+"");
				
				JOptionPane.showMessageDialog(this, "Updated");
				
				NextBtn.setEnabled(false);
				
			}
			else
			{
				JOptionPane.showMessageDialog(this, "User Not Found");
			}
			
		}
		else if(command.equals(BackBtn.getText()))
		{
			EmployeeHome eh = new EmployeeHome(user);
			eh.setVisible(true);
			this.setVisible(false);
			
		}
}
}