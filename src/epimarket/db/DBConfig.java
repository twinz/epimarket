package epimarket.db;

import java.util.*;

import epimarket.xml.*;

public class DBConfig
{
	private ArrayList<XMLLigne>  DBList;
	private ArrayList<String> 	 products	=	new ArrayList<String>();
	
	public DBConfig(){
		products.add("Dvd");
		products.add("Game");
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//Getters & Setters
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	public ArrayList<XMLLigne> getDBList() 				{return DBList;}

	public void setDBList(ArrayList<XMLLigne> dBList) 	{DBList = dBList;}

	public ArrayList<String> getProducts() {
		return products;
	}

	public void setProducts(ArrayList<String> products) {
		this.products = products;
	}
	
	
}
