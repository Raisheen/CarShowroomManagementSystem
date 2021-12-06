package interfaces;

import java.lang.*;
import entity.*;

public interface IPurchaseRepo
{
	
	void insertCustomer(Purchase p);
	void updateCustomer(Purchase p);
	void deleteSoldCar(String carID);
    Purchase searchPurchase(String billNo);
}