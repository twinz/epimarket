package epimarket.dao;

import	epimarket.model.*;
import	epimarket.db.*;

public class DAOAbstractProduct extends AbstractDAO implements IDAOAbstractProduct 
{
	public DAOAbstractProduct (){
		super.dbFacade = new DBFacade();
	}
	
	public void create(AbstractProduct  obj)
	{
		super.create(obj);
	}
	
	public void read(String str)
	{
		super.read(str);
	}
	
	public void update(AbstractProduct  obj)
	{
		super.update(obj);
	}
	
	public void delete(AbstractProduct  obj)
	{
		super.delete(obj);
	}
}