package epimarket.test;

import epimarket.db.*;
import epimarket.model.*;

public class Main 
{
	public DBFacade			dbFacade;
	static Main				test;


	
	public static void main(String args[])
	{		
		test			= new Main();	
		
		User user = new User("Alexandre", "MARTENS", "alexmartens@hotmail.fr", 5);
		test.dbFacade.insert(user);
	}
	
	public Main()
	{		
		System.out.println("Avant facade(main)");
		this.dbFacade = new DBFacade();
		System.out.println("Apres facade(main)");
	}	
	

}
