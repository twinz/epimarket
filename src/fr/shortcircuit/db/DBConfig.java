package fr.shortcircuit.db;

import java.util.LinkedList;
import fr.shortcircuit.model.DBLigne;

public class DBConfig
{
	private LinkedList<DBLigne>		DBList;	
	
	public DBConfig()
	{
	
	}


//////////////////////////////////////////////////////////////////////////////////////////////////////
//Getters & Setters
//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public LinkedList<DBLigne> getDBList() {
		return DBList;
	}


	public void setDBList(LinkedList<DBLigne> dBList) {
		DBList = dBList;
	}
	
}
