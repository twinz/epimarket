package fr.shortcircuit.model;


import java.util.*;

import fr.shortcircuit.xml.IXMLObject;

public class ProductElement implements Comparable, IXMLObject
{
	public Collection<Column>		column = new ArrayList();
	
	//declared as public to allow java.lang.reflect.Field read/write access.
	public String 					class_name, db_name, class_column, db_column, type;
	
	
	public int 						coefBonus		= 10;
	

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Constructors
	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public ProductElement()		{}	

	public ProductElement(String class_name, String db_name, String class_column, String db_column, String type)
	{
		createStructure(class_name, db_name, class_column, db_column, type);	
	}
	
	public void createStructure(String class_name, String db_name, String class_column, String db_column, String type)
	{
		this.class_name					= class_name;				
		this.db_name					= db_name;		   
		this.class_column				= class_column;
		this.db_column					= db_column;			
		this.type						= type;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Business logic
	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public int calculateBonus()
	{
		return Integer.parseInt(db_column) * coefBonus;	
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Getters, Setters, and Add
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void addActor(Column a)							{column.add(a);}

	
	public Collection<Column> getColumn() 					{return column;}
	public int getCoefBonus() 								{return coefBonus;}
	public String getClass_name()							{return class_name;}
	public String getDb_name()								{return db_name;}
	public String getClass_column()							{return class_column;}
	public String getDb_column()							{return db_column;}
	public String getType()									{return type;}
	
	public void setColumn(Collection<Column> column)		{this.column 			= column;}
	public void setCoefBonus(int coefBonus) 				{this.coefBonus 		= coefBonus;}
	public void setClass_name(String id)					{this.class_name		= id;}
	public void setDb_name(String designation)				{this.db_name			= designation;}
	public void setClass_column(String type)				{this.class_column		= type;}
	public void setDb_column(String price)					{this.db_column			= price;}
	public void setType(String genre)						{this.type				= genre;}

	//override java.lang.Object method 
	public String toString()								{return db_name;}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//IXMLFactory methods
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public String toXmlString()
	{
		StringBuffer bufContent	= new StringBuffer();
		
		bufContent.append("<");
		bufContent.append(this.getClass().getSimpleName() + " ");
		bufContent.append("Class_name=\"" + this.getClass_name() + "\" ");
		bufContent.append("Db_name=\"" + this.getDb_name() + "\" ");
		bufContent.append("Class_column=\"" + this.getClass_column() + "\" ");
		bufContent.append("Db_column=\"" + this.getDb_column() + "\" ");
		
		
		bufContent.append("/>");
		
		if (column.size() != 0)
		{
			bufContent.append("\r\n <actors>");
			
			for (Column a : column)
				bufContent.append("\r\n  " + a.toXmlString());
				
			bufContent.append("\r\n </actors>");	
		}
		
		return bufContent.toString();	
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Comparable methods
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public int compareTo(Object o)
	{
		if (!(o instanceof ProductElement))
			throw new ClassCastException("compareTo ProductElement only");

		return db_name.compareTo((((ProductElement) o).db_name));	

		//return id.compareTo((((ProductElement) o).id));	//Gestion par Id
	}
	
}