package epimarket.db;

import java.util.Vector;

import epimarket.db.*;
import epimarket.model.*;
import epimarket.xml.Parser;


public class DBFacade
{	
	public  DBFactory			dbfactory;
	public	DBConfig			dbConfig;
	public 	DBManager			dbManager;
	
	
	
	public DBFacade()
	{
		dbfactory = new DBFactory();
		dbConfig = dbfactory.parser.getDbConfig();
		this.dbManager = new DBManager("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/test", "root", "root", dbConfig);
	}
	
	public	void	create(Object obj)
	{
		dbManager.connect();
		dbManager.create(obj);
		dbManager.disconnect();
	}
	
	public	void	read(String str)
	{
		dbManager.connect();
		dbManager.read(str);
		dbManager.disconnect();
	}
	
	public	void	update(Object obj)
	{
		dbManager.connect();
		dbManager.update(obj);
		dbManager.disconnect();
	}
	
	public	void	delete(Object obj)
	{
		dbManager.connect();
		dbManager.delete(obj);
		dbManager.disconnect();
	}
}