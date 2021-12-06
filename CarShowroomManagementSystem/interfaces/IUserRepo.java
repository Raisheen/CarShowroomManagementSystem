package interfaces;

import java.lang.*;

import entity.*;

public interface IUserRepo
{
	User getUser(String userId, String password);
	void insertUser(User u);
	//void updateUserPassword(User u);
	
	void updateUserPassword(String userId,String pass);
	void deleteUser(String userId);
}