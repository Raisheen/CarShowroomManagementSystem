package interfaces;

import java.lang.*;

import entity.*;

public interface ICarRepo
{
	public void insertCarInDB(Car c);
	public void deleteCarFromDB(String CarID);
	public void updateCarInDB(Car c);
	public Car searchCar(String carID);
	public String[][] getAllCar();

}