package fr.shortcircuit.db;

import java.util.Vector;

import fr.shortcircuit.db.*;
import fr.shortcircuit.model.ProductElement;
import fr.shortcircuit.test.Main;
import fr.shortcircuit.xml.MySaxReflecter;


public class DBFacade
{	
	public 	DBManager			MyDbManager;
	
	public DBFacade()
	{
		this.MyDbManager = new DBManager("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/test", "root", "root");
	}
}