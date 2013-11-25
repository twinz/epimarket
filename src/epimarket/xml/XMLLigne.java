package epimarket.xml;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import epimarket.xml.*;

public class XMLLigne
{
	private String 					class_name;
	private String					db_name;
	private ArrayList<XMLColumn>	columns;
	
	public XMLLigne()
	{
	
	}

	public String getClass_name() {
		return class_name;
	}

	public String getDb_name() {
		return db_name;
	}

	public ArrayList<XMLColumn> getColumns() {
		return columns;
	}

	public void setClass_name(String class_name) {
		this.class_name = class_name;
	}

	public void setDb_name(String db_name) {
		this.db_name = db_name;
	}

	public void setColumns(ArrayList<XMLColumn> columns) {
		this.columns = columns;
	}

	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//Getters & Setters
//////////////////////////////////////////////////////////////////////////////////////////////////////



	
}
