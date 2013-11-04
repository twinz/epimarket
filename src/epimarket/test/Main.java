package epimarket.test;

import epimarket.db.*;
import epimarket.model.*;

public class Main 
{
	public DBFacade			dbFacade;
	static Main				test;

	// mettre relation 1 et 1n
	// xml

	// main => DAO => DBFacade => DBManager
	
	public static void main(String args[])
	{		
		test			= new Main();	
		
		User user = new User("Alexandre", "MARTENS", "alexmartens@hotmail.fr", 1);
		User user2 = new User("Raphael", "MARTENS", "raphmartens@hotmail.fr", 2);
		
		test.dbFacade.delete(user);
		test.dbFacade.delete(user2);
		
		test.dbFacade.insert(user);
		test.dbFacade.insert(user2);
		
		user = new User("Alexandre", "MARTENS", "alexmartens@gmail.com", 1);
		user2 = new User("Raphael", "MARTENS", "raphmartens@hgmail.com", 2);
		
		test.dbFacade.update(user);
		test.dbFacade.update(user2);

		test.dbFacade.select("SELECT * FROM epimarket.USER");
	}
	
	
	public Main()
	{	
		this.dbFacade = new DBFacade();
	}	
	

}
