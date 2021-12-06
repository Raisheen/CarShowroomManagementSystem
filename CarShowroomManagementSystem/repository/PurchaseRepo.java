package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class PurchaseRepo implements IPurchaseRepo
{
	DatabaseConnection dbc;
	
	public PurchaseRepo()
	{
		dbc = new DatabaseConnection();
	}
	public void insertCustomer(Purchase p)
	{
		String query = "INSERT INTO purchases VALUES ('"+p.getBillNo()+"','"+p.getCustomerName()+"','"+p.getCustomerContact()+"','"+p.getDueDate()+"','"+p.getCarID()+"');";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	public void updateCustomer(Purchase p)
	{
		String query = "UPDATE purchases SET customerName='"+p.getCustomerName()+"', customerContact = '"+p.getCustomerContact()+"', dueDate = '"+p.getDueDate()+"' WHERE bill_no='"+p.getBillNo()+"'";
		
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	}
	
	public void deleteSoldCar(String carID)
	{
		String query= " DELETE from cars where carID = '"+carID+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception e){System.out.println(e.getMessage());}
	
	}
	
	public Purchase searchPurchase(String billNo)
	{
		Purchase pr = null;
		String query = "SELECT `customerName`, `customerContact`, `dueDate`, `carID` FROM `purchases` WHERE `bill_no`='"+billNo+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String customerName = dbc.result.getString("customerName");
				String billno = dbc.result.getString("bill_no");
				String customerContact = dbc.result.getString("customerContact");
				String dueDate = dbc.result.getString("dueDate");
				String carID = dbc.result.getString("carID");
				
				pr = new Purchase();
				pr.setBillNo(billno);
				pr.setCustomerName(customerName);
				pr.setCustomerContact(customerContact);
				pr.setDueDate(dueDate);
				pr.setCarID(carID);
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return pr;
	}
	
	
}