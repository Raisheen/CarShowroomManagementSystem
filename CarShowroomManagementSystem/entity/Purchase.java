package entity;

import java.lang.*;

public class Purchase
{
	private String billNo;
	private String customerName;
	private String customerContact;
	private String dueDate;
	private String carID;
	
	public Purchase(){}
	public Purchase(String billNo, String customerName, String customerContact, String dueDate, String carID)
	{
		this.billNo=billNo;
		this.customerName=customerName;
		this.customerContact=customerContact;
		this.dueDate=dueDate;
		this.carID=carID;
		
	}
	public void setBillNo(String billNo){this.billNo=billNo;}
	public void setCustomerName(String customerName){this.customerName=customerName;}
	public void setCustomerContact(String customerContact){this.customerContact=customerContact;}
	public void setDueDate(String dueDate){this.dueDate=dueDate;}
	public void setCarID(String carID){this.carID=carID;}
	
	public String getBillNo(){return billNo;}
	public String getCustomerName(){return customerName;}
	public String getCustomerContact(){return customerContact;}
	public String getDueDate(){return dueDate;}
	public String getCarID(){return carID;}
	
}