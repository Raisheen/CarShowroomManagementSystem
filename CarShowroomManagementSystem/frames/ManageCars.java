package frames;

import java.lang.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

import repository.*;
import entity.*;

public class ManageCars extends JFrame implements ActionListener
{
	private JPanel panel;
	private JLabel carIDLabel, carModelLabel, manufacturerLabel, colorLabel, manufacturingDateLabel, carPriceLabel, ccLabel;
	private JTextField carIDtf, carModeltf, manufacturertf, colortf, manufacturingDatetf, carPricetf, cctf;
	private JButton LoadBtn,InsertBtn,UpdateBtn,DeleteBtn,ShowAllBtn, BackBtn,LogoutBtn, RefreshBtn;
	private JTable CarTable;
	private JScrollPane CarSP;
	
	private CarRepo cr;
	User user;
	
	public ManageCars(User user)
	{
		super("Manage Cars");
		this.setSize(1000,600);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		cr= new CarRepo();
			
		panel = new JPanel();
		panel.setLayout(null);
		
		String data[][] = {{"", "", "", "","","",""}};
		
		String head[] = {"carID","Model","Manufacturer","Color","ManufacturingDate","Price","CC"};
		
		CarTable = new JTable(data,head);
		CarSP = new JScrollPane(CarTable);
		CarSP.setBounds(350,00,300,60);
		CarTable.setEnabled(false);
		panel.add(CarSP);
		
		
		carIDLabel= new JLabel("Car ID: ");
		carIDLabel.setBounds(60,60,200,40);
		panel.add(carIDLabel);
		
		carIDtf= new JTextField();
		carIDtf.setBounds(215,60,200,40);
		panel.add(carIDtf);
		
		carModelLabel= new JLabel("Car Model: ");
		carModelLabel.setBounds(60,110,200,40);
		panel.add(carModelLabel);
		
		carModeltf= new JTextField();
		carModeltf.setBounds(215,110,200,40);
		panel.add(carModeltf);
		
		manufacturerLabel=new JLabel("Manufacturer: ");
		manufacturerLabel.setBounds(60,160,200,40);
		panel.add(manufacturerLabel);
		
		manufacturertf=new JTextField();
		manufacturertf.setBounds(215,160,200,40);
		panel.add(manufacturertf);
		
		colorLabel= new JLabel("Color: ");
		colorLabel.setBounds(60,210,200,40);
		panel.add(colorLabel);
		
		colortf=new JTextField();
		colortf.setBounds(215,210,200,40);
		panel.add(colortf);
		
		manufacturingDateLabel=new  JLabel("Manufacturing Date: ");
		manufacturingDateLabel.setBounds(60,260,200,40);
		panel.add(manufacturingDateLabel);
		
		manufacturingDatetf=new JTextField();
		manufacturingDatetf.setBounds(215,260,200,40);
		panel.add(manufacturingDatetf);
		
		carPriceLabel=new JLabel("Price: ");
		carPriceLabel.setBounds(60,310,200,40);
		panel.add(carPriceLabel);
		
		carPricetf=new JTextField();
		carPricetf.setBounds(215,310,200,40);
		panel.add(carPricetf);
		
		ccLabel=new JLabel("CC: ");
		ccLabel.setBounds(60,360,200,40);
		panel.add(ccLabel);
		
		cctf=new JTextField();
		cctf.setBounds(215,360,200,40);
		panel.add(cctf);
		
        LoadBtn = new JButton("LOAD");
		LoadBtn.setBounds(40,450,100,40);
        LoadBtn.addActionListener(this);
		panel.add(LoadBtn);
                
        InsertBtn = new JButton("INSERT");
		InsertBtn.setBounds(140,450,100,40);
        InsertBtn.addActionListener(this);
		panel.add(InsertBtn);
                
        UpdateBtn = new JButton("UPDATE");
	    UpdateBtn.setBounds(240,450,100,40);
            UpdateBtn.addActionListener(this);
        panel.add(UpdateBtn);
                
        DeleteBtn = new JButton("DELETE");
	    DeleteBtn.setBounds(340,450,100,40);
        DeleteBtn.addActionListener(this);
		panel.add(DeleteBtn);
                     
		BackBtn = new JButton("BACK");
	    BackBtn.setBounds(440,450,100,40);
        BackBtn.addActionListener(this);
		panel.add(BackBtn);
                
        LogoutBtn = new JButton("LOGOUT");
	    LogoutBtn.setBounds(540,450,100,40);
        LogoutBtn.addActionListener(this);
		panel.add(LogoutBtn);
                
        RefreshBtn = new JButton("REFRESH");
	    RefreshBtn.setBounds(640,450,100,40);
        RefreshBtn.addActionListener(this);
		panel.add(RefreshBtn);
                
        ShowAllBtn = new JButton("SHOW ALL");
	    ShowAllBtn .setBounds(740,450,100,40);
        ShowAllBtn.addActionListener(this);
		panel.add(ShowAllBtn);
                
                
		this.add(panel);
		
		
	}

	public void actionPerformed(ActionEvent ae)
	{
		String command = ae.getActionCommand();
		
		if(command.equals(LoadBtn.getText()))
		{
			if(!carIDtf.getText().equals("") || !carIDtf.getText().equals(null))
			{
				Car c = cr.searchCar(carIDtf.getText());
				if (c!=null)
				{
					carModeltf.setText(c.getCarModel());
					manufacturertf.setText(c.getManufacturer());
					colortf.setText(c.getCarColor());
					manufacturingDatetf.setText(c.getManufacturingDate());
					carPricetf.setText(c.getCarPrice()+"");
					
					cctf.setText(c.getCarCC()+"");
					
					carIDtf.setEnabled(false);
					
					UpdateBtn.setEnabled(true);
					DeleteBtn.setEnabled(true);
					ShowAllBtn.setEnabled(true);
					RefreshBtn.setEnabled(true);
					InsertBtn.setEnabled(false);
					LoadBtn.setEnabled(false);
				
				}
				else
				{
					JOptionPane.showMessageDialog(this,"Invaild Car ID");
				}
				
			}
		}
		else if(command.equals(InsertBtn.getText()))
		{
			Car c=new Car();
			c.setCarID(carIDtf.getText());
			c.setCarModel(carModeltf.getText());
			c.setManufacturer(manufacturertf.getText());
			c.setCarColor(colortf.getText());
			c.setManufacturingDate(manufacturingDatetf.getText());
			c.setCarPrice(Double.parseDouble(carPricetf.getText()) );
			c.setCarCC(Integer.parseInt(cctf.getText()) );
			
			cr.insertCarInDB(c);
			JOptionPane.showMessageDialog(this, "Inserted");
			
			carIDtf.setText("");
			carModeltf.setText("");
			manufacturertf.setText("");
			colortf.setText("");
			manufacturingDatetf.setText("");
			carPricetf.setText("");
			cctf.setText("");
			
			LoadBtn.setEnabled(true);
			InsertBtn.setEnabled(true);
			UpdateBtn.setEnabled(false);
			DeleteBtn.setEnabled(false);
			RefreshBtn.setEnabled(false);
			
		}
		else if(command.equals(UpdateBtn.getText()))
		{
			Car c = new Car();
			c.setCarID(carIDtf.getText());
			c.setCarModel(carModeltf.getText());
			c.setManufacturer(manufacturertf.getText());
			c.setCarColor(colortf.getText());
			c.setManufacturingDate(manufacturingDatetf.getText());
			c.setCarPrice(Double.parseDouble(carPricetf.getText()));
			c.setCarCC(Integer.parseInt(cctf.getText()));
			
			cr.updateCarInDB(c);
			JOptionPane.showMessageDialog(this, "Updated");
			
			LoadBtn.setEnabled(true);
			InsertBtn.setEnabled(true);
			UpdateBtn.setEnabled(true);
			DeleteBtn.setEnabled(true);
			RefreshBtn.setEnabled(true);
			ShowAllBtn.setEnabled(true);
		}
		else if(command.equals(DeleteBtn.getText()))
		{
			cr.deleteCarFromDB(carIDtf.getText());
			
			JOptionPane.showMessageDialog(this,"Deleted");
			
			carIDtf.setText("");
			carModeltf.setText("");
			manufacturertf.setText("");
			colortf.setText("");
			manufacturingDatetf.setText("");
			carPricetf.setText("");
			cctf.setText("");

			LoadBtn.setEnabled(true);
			InsertBtn.setEnabled(true);
			UpdateBtn.setEnabled(true);
			DeleteBtn.setEnabled(true);
			RefreshBtn.setEnabled(true);
			ShowAllBtn.setEnabled(true);

			carIDtf.setEnabled(true);
			carModeltf.setEnabled(true);
			manufacturertf.setEnabled(true);
			colortf.setEnabled(true);
			manufacturingDatetf.setEnabled(true);
			carPricetf.setEnabled(true);
			cctf.setEnabled(true);
		}
		else if(command.equals(RefreshBtn.getText()))
		{
			carIDtf.setText("");
			carModeltf.setText("");
			manufacturertf.setText("");
			colortf.setText("");
			manufacturingDatetf.setText("");
			carPricetf.setText("");
			cctf.setText("");

			LoadBtn.setEnabled(true);
			InsertBtn.setEnabled(true);
			UpdateBtn.setEnabled(true);
			DeleteBtn.setEnabled(true);
			RefreshBtn.setEnabled(true);
			ShowAllBtn.setEnabled(true);
		}
		else if(command.equals(ShowAllBtn.getText()))
		{
			String data[][]= cr.getAllCar();
			String head[]= {"carID","Model","Manufacturer","Color","ManufacturingDate","Price","CC"};
			
			panel.remove(CarSP);
			
			CarTable= new JTable (data, head);
			CarTable.setEnabled(false);
			CarSP=new JScrollPane(CarTable);
			CarSP.setBounds(350,00,300,60);
			panel.add(CarSP);
			
			panel.revalidate();
			panel.repaint();
			
		}
		else if (command.equals(BackBtn.getText()))
		{
			EmployeeHome eh = new EmployeeHome(user);
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