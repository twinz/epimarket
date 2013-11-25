package epimarket.db;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DBFacade
{	
	public  DBFactory			dbfactory;
	public	DBConfig			dbConfig;
	public 	DBManager			dbManager;
	
	public DBFacade()
	{
		dbfactory = new DBFactory();
		dbConfig = dbfactory.parser.getDbConfig();
		this.dbManager = new DBManager(dbConfig);
		// dans constructeur dbManager
	}
	
	public	void	create(Object obj)
	{
		dbManager.connect();
		dbManager.create(obj);
		dbManager.disconnect();
	}
	
	public	List	read(Object obj)
	{
		dbManager.connect();
		return dbManager.read(obj);
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
	
	public	int	objectId(Object obj)
	{
		dbManager.connect();
		return dbManager.objectId(obj);
	}
}