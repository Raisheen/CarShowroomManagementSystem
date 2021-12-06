package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;


public class ManagePurchaseFrame extends JFrame implements ActionListener
{
	private JPanel panel;
	private JLabel billLabel, nameLabel, contactLabel, dateLabel, carIDLabel;
	private JTextField billTF, nameTF, contactTF, dateTF, caridTF;
	private JButton ConfirmBtn,SearchBtn,UpdateBtn,BackBtn,LogoutBtn,DeleteBtn;
	
	User user;
	PurchaseRepo pr;
	public ManagePurchaseFrame(User user)
	{
		super("MANAGE PURCHASE FRAME");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
        Font myFont = new Font("Cambria", Font.ITALIC | Font.BOLD , 18);
	
		panel = new JPanel();
		panel.setLayout(null);
		
		
		nameLabel = new JLabel("NAME: ");
		nameLabel.setBounds(60,60,200,40);
		panel.add(nameLabel);
		
		
		nameTF = new JTextField();
		nameTF.setBounds(215,60,200,40);
		panel.add(nameTF);
			
	    
		
		contactLabel = new JLabel("CONTACT: ");
	    contactLabel.setBounds(60,110,200,40);
		panel.add(contactLabel);
		
		
	    contactTF = new JTextField();
		contactTF.setBounds(215,110,200,40);
		panel.add(contactTF);
			
			
			
        dateLabel = new JLabel("DATE: ");
		dateLabel.setBounds(60,160,200,40);
		panel.add(dateLabel);
		
		
		dateTF = new JTextField();
	    dateTF.setBounds(215,160,200,40);
		panel.add(dateTF);
				
		
		billLabel=new JLabel("BILL: ");
		billLabel.setBounds(500,110,200,40);
		panel.add(billLabel);
		
        billTF = new JTextField();
		billTF.setBounds(650,110,200,40);
		panel.add(billTF);
		
		carIDLabel = new JLabel("CAR ID: ");
		carIDLabel.setBounds(500,60,200,40);
		panel.add(carIDLabel);
		
		caridTF= new JTextField();
		caridTF.setBounds(650,60,200,40);
		panel.add(caridTF);
		
		
		
		
		ConfirmBtn = new JButton("CONFIRM");
		ConfirmBtn.setBounds(150,300,200,40);
		ConfirmBtn.addActionListener(this);
		panel.add(ConfirmBtn);
		
		SearchBtn = new JButton ("SEARCH");
		SearchBtn.setBounds(200,300,100,40);
		SearchBtn.addActionListener(this);
		panel.add(SearchBtn);
		
		UpdateBtn = new JButton("UPDATE");
		UpdateBtn.setBounds(300,300,100,40);
		UpdateBtn.addActionListener(this);
		panel.add(UpdateBtn);
		
		
		BackBtn = new JButton("BACK");
		BackBtn.setBounds(350,300,200,40);
		BackBtn.addActionListener(this);
		panel.add(BackBtn);
		
		
	    LogoutBtn = new JButton("LOGOUT");
	    LogoutBtn.setBounds(550,300,200,40);
		LogoutBtn.addActionListener(this);
		panel.add(LogoutBtn);
		
		
		DeleteBtn = new JButton("DELETE");
	    DeleteBtn.setBounds(750,300,200,40);
		DeleteBtn.addActionListener(this);
		panel.add(DeleteBtn);
	 
	 this.add(panel);
	
    }
	 

	
	
	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		if(command.equals(ConfirmBtn.getText()))
		{
			Purchase p= new Purchase();
			p.setBillNo(billTF.getText());
			p.setCustomerName(nameTF.getText());
			p.setCustomerContact(contactTF.getText());
			p.setDueDate(dateTF.getText());
			p.setCarID(caridTF.getText());
			
			String carID=caridTF.getText();
			
			pr.insertCustomer(p);
			
			
			JOptionPane.showMessageDialog(this, "Inserted");
			
			billTF.setText("");
			nameTF.setText("");
			contactTF.setText("");
			dateTF.setText("");
			caridTF.setText("");
			
			ConfirmBtn.setEnabled(false);
			SearchBtn.setEnabled(true);
			UpdateBtn.setEnabled(true);
			DeleteBtn.setEnabled(true);
			BackBtn.setEnabled(true);
			LogoutBtn.setEnabled(true);
			
			
			
		}
		else if (command.equals(SearchBtn.getText()))
		{
			if(!billTF.getText().equals("") || !billTF.getText().equals(null))
			{
				Purchase p = pr.searchPurchase(billTF.getText());
				if(p!= null)
				{
					String carID=caridTF.getText();
					
					nameTF.setText(p.getCustomerName());
					contactTF.setText(p.getCustomerContact());
					dateTF.setText(p.getDueDate());
					caridTF.setText(p.getCarID());
					
					dateTF.setEnabled(false);
					caridTF.setEnabled(false);
					billTF.setEnabled(false);
					nameTF.setEnabled(true);
					contactTF.setEnabled(true);
					
					
					ConfirmBtn.setEnabled(false);
					SearchBtn.setEnabled(false);
					UpdateBtn.setEnabled(true);
					DeleteBtn.setEnabled(true);
					BackBtn.setEnabled(true);
					LogoutBtn.setEnabled(true);
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild ID");
				}
			}
		}
		else if (command.equals(UpdateBtn.getText()))
		{
			Purchase p= new Purchase();
			p.setBillNo(billTF.getText());
			p.setCustomerName(nameTF.getText());
			p.setCustomerContact(contactTF.getText());
			p.setDueDate(dateTF.getText());
			p.setCarID(caridTF.getText());
			
			pr.updateCustomer(p);
			
			JOptionPane.showMessageDialog(this, "Updated");
			billTF.setText("");
			nameTF.setText("");
			contactTF.setText("");
			dateTF.setText("");
			caridTF.setText("");
			
			ConfirmBtn.setEnabled(true);
			SearchBtn.setEnabled(true);
			UpdateBtn.setEnabled(true);
			DeleteBtn.setEnabled(true);
			BackBtn.setEnabled(true);
			LogoutBtn.setEnabled(true);
			
			
		}
		else if (command.equals(BackBtn.getText()))
		{
			User u = new User();
			EmployeeHome eh = new EmployeeHome(u);
			eh.setVisible(true);
			this.setVisible(false);
		}
		else if (command.equals(LogoutBtn.getText()))
		{
			LoginFrame lf = new LoginFrame();
			lf.setVisible(true);
			this.setVisible(false);
		}
		else{}
		
	}
	
	 
}	 