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
		System.out.println("Avant Factory(Facade)");
		dbfactory = new DBFactory();
		System.out.println("Apres Factory(Facade)");
		System.out.println("Avant DBManager(Facade)");
		
		System.out.println("Test (facade)");
		System.out.println("AFFICHAGE DES STRUCTURES");
		dbConfig = dbfactory.parser.getDbConfig();
		
		
		this.dbManager = new DBManager("com.mysql.jdbc.Driver", "jdbc:mysql://localhost:3306/test", "root", "root", dbConfig);
		System.out.println("Apres DBManager(Facade)");
		
		
		/*for (int j = 0; j != dbConfig.getDBList().size(); j++)
		{
			System.out.println("-Ligne--> class_name = " + dbConfig.getDBList().get(j).getClass_name() + "\t, db_name = " + dbConfig.getDBList().get(j).getDb_name());
		}*/
	
		
		//dbConfig = new DBConfig();

		
	}
	
	public void insert(Object obj){
		System.out.println("Debut de insert(facade)");
		dbManager.Insert_sql_lite(obj);
		System.out.println("fin de insert(facade)");
	}

	public DBConfig getDbConfig() {
		return dbConfig;
	}

	public void setDbConfig(DBConfig dbConfig) {
		this.dbConfig = dbConfig;
	}

	public DBManager getDbManager() {
		return dbManager;
	}

	public DBFactory getDbfactory() {
		return dbfactory;
	}

	public void setDbManager(DBManager dbManager) {
		this.dbManager = dbManager;
	}

	public void setDbfactory(DBFactory dbfactory) {
		this.dbfactory = dbfactory;
	}
	
	
}