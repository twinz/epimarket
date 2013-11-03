package fr.shortcircuit.db;

import java.util.Vector;

import fr.shortcircuit.db.*;
import fr.shortcircuit.xml.Parser;
import fr.shortcircuit.model.*;


public class DBFacade
{	
	public 	DBManager			dbManager;
	public	DBConfig			dbConfig;
	public  DBFactory			dbfactory;
	
	public DBFacade()
	{
		dbfactory = new DBFactory();
		System.out.println("----->Avant DBManager");
		this.dbManager = new DBManager("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/test", "root", "root");
		System.out.println("----->Apres DBManager");
		
		dbConfig = new DBConfig();

		
	}
	
	public void insert(Object obj){
		System.out.println("Debut de insert(facade)");
		dbManager.Insert_sql_lite(obj);
		System.out.println("fin de insert(facade)");
	}
}