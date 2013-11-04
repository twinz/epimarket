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
	
	public void insert(Object obj){
		dbManager.insertSqlLite(obj);
	}
	
	public void delete(Object obj){
		dbManager.deleteSqlLite(obj);
	}
	
	public void update(Object obj){
		dbManager.updateSqlLite(obj);
	}

	public void select(String sql)
	{
		dbManager.selectSqlLite(sql);
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