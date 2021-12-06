package repository;

import java.lang.*;
import java.util.ArrayList;
import entity.*;
import interfaces.*;

public class CarRepo implements ICarRepo
{
	DatabaseConnection dbc;
	public CarRepo()
	{
		dbc = new DatabaseConnection();
	}
	public void insertCarInDB(Car c)
	{
		String query = "INSERT INTO cars VALUES ('"+c.getCarID()+"','"+c.getCarModel()+"','"+c.getManufacturer()+"','"+c.getCarColor()+"','"+c.getManufacturingDate()+"',"+c.getCarCC()+","+c.getCarPrice()+");";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}

	}
	public void deleteCarFromDB(String carID)
	{
		String query = " DELTE FROM cars WHERE carID= '"+carID+"';";
		try
		{
			dbc.openConnection();
			dbc.st.execute(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}		
	}
	public void updateCarInDB(Car c)
	{
		String query = " UPDATE cars SET carID= '"+c.getCarID()+"', carModel= '"+c.getCarModel()+"', manufacturer= '"+c.getManufacturer()+"', carColor= '"+c.getCarColor()+"',manufacturingDate= '"+c.getManufacturingDate()+"',carCC= "+c.getCarCC()+",carPrice= "+c.getCarPrice()+");";
		try
		{
			dbc.openConnection();
			dbc.st.executeUpdate(query);
			dbc.closeConnection();
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
	
	}	
	public Car searchCar(String carID)
	{
		Car cr1 = null;
		String query = "SELECT `model;`, `manufacturer`, `color`,`manufacturingDate`,`CC`,`price` FROM `cars` WHERE `carID`='"+carID+"';";     
		try
		{
		
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
		
			while(dbc.result.next())
			{
				
				String carModel = dbc.result.getString("model");
				String manufacturer = dbc.result.getString("manufacturer");
				String carColor= dbc.result.getString("color");
				String manufacturingDate= dbc.result.getString("manufacturingDate");
				int carCC=dbc.result.getInt("CC");
				double carPrice = dbc.result.getDouble("price");
				
				
				cr1 = new Car();
				cr1.setCarID(carID);
				cr1.setCarModel(carModel);
				cr1.setManufacturer( manufacturer);
				cr1.setCarColor(carColor);
				cr1.setManufacturingDate( manufacturingDate);
				cr1.setCarCC( carCC);
				cr1.setCarPrice( carPrice);
				
			}
			
		}
		catch(Exception ex){System.out.println(ex.getMessage());}
		dbc.closeConnection();
		return cr1;
	}
	
	public String[][] getAllCar()
	{
		ArrayList<Car> ar = new ArrayList<Car>();
		String query = "SELECT * FROM cars;";  
		
		try
		{
			dbc.openConnection();
			dbc.result = dbc.st.executeQuery(query);
			
		
			while(dbc.result.next())
			{
				String carID=dbc.result.getString("carID");
				String carModel = dbc.result.getString("model");
				String manufacturer = dbc.result.getString("manufacturer");
				String carColor= dbc.result.getString("color");
				String manufacturingDate= dbc.result.getString("manufacturingDate");
				int carCC=dbc.result.getInt("CC");
				double carPrice = dbc.result.getDouble("price");
				
				
				Car c = new Car( carID, carModel, manufacturer, carColor, manufacturingDate, carPrice,carCC);
				ar.add(c);
			}
		}
		catch(Exception e){System.out.println(e.getMessage());}
		dbc.closeConnection();
		
		
		Object obj[] = ar.toArray();
		String data[][] = new String [ar.size()][7];
		
		for(int i=0; i<obj.length; i++)
		{
			data[i][0] = ((Car)obj[i]).getCarID();
			data[i][1] = ((Car)obj[i]).getCarModel();
			data[i][2] = ((Car)obj[i]).getManufacturer();
			data[i][3] = ((Car)obj[i]).getCarColor();
			data[i][4] = ((Car)obj[i]).getManufacturingDate();
			data[i][5] = ((Car)obj[i]).getCarPrice()+"";
			data[i][6] = (((Car)obj[i]).getCarCC())+"";
		}
		return data;
	}
}