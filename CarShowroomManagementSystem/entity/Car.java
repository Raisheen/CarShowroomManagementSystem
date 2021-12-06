package entity;

import java.lang.*;

public class Car
{
	private String carID;
	private String carModel;
	private String manufacturer;
	private String carColor;
	private String manufacturingDate;
	private double carPrice;
	private int carCC;
	
	public Car(){
		this.carID=carID;
		this.carModel= carModel;
		this.manufacturer=manufacturer;
		this.carColor=carColor;
		this.manufacturingDate=manufacturingDate;
		this.carPrice=20000;
		this.carCC=100;
	}
	public Car(String carID, String carModel, String manufacturer, String carColor, String manufacturingDate, double carPrice, int carCC)
	{
		this.carID=carID;
		this.carModel= carModel;
		this.manufacturer=manufacturer;
		this.carColor=carColor;
		this.manufacturingDate=manufacturingDate;
		this.carPrice=carPrice;
		this.carCC=carCC;
		
	}
	public void setCarID(String carID){this.carID=carID;}
	public void setCarModel(String carModel){this.carModel=carModel;}
	public void setManufacturer(String manufacturer){this.manufacturer=manufacturer;}
	public void setCarColor(String carColor){this.carColor=carColor;}
	public void setManufacturingDate(String manufacturingDate){this.manufacturingDate=manufacturingDate;}
	public void setCarPrice(double carPrice){this.carPrice=carPrice;}
	public void setCarCC(int carCC){this.carCC=carCC;}
	
	public String getCarID(){return carID;}
	public String getCarModel(){return carModel;}
	public String getManufacturer(){return manufacturer;}
	public String getCarColor(){return carColor;}
	public String getManufacturingDate(){return manufacturingDate;}
	public double getCarPrice(){return carPrice;}
	public int getCarCC(){return carCC;}
	
	
}