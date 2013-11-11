package epimarket.xml;

import epimarket.xml.*;

public class XMLColumn
{
	public String 			class_name 		= "";
	public String 			db_column 		= "";
	public String 			type 			= "";
	
	
	public XMLColumn()
	{
	
	}
	
	
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//Getters & Setters
//////////////////////////////////////////////////////////////////////////////////////////////////////

	

	public String getclass_name() {
		return class_name;
	}



	public String getdb_column() {
		return db_column;
	}



	public String gettype() {
		return type;
	}



	public void setclass_name(String class_name) {
		this.class_name = class_name;
	}



	public void setdb_column(String db_column) {
		this.db_column = db_column;
	}



	public void settype(String type) {
		this.type = type;
	}

}
