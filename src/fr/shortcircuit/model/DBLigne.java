package fr.shortcircuit.model;

import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import fr.shortcircuit.model.DBColumn;;

public class DBLigne
{
	private String 					ClassName;
	private String					DBName;
	private LinkedList<DBColumn>	Columnslist;
	
	
	public DBLigne()
	{
	
	}


//////////////////////////////////////////////////////////////////////////////////////////////////////
//Getters & Setters
//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public String getClassName() {
		return ClassName;
	}


	public String getDBName() {
		return DBName;
	}


	public LinkedList<DBColumn> getColumnslist() {
		return Columnslist;
	}


	public void setClassName(String className) {
		ClassName = className;
	}


	public void setDBName(String dBName) {
		DBName = dBName;
	}


	public void setColumnslist(LinkedList<DBColumn> columnslist) {
		Columnslist = columnslist;
	}
	
}
