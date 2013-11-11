package epimarket.dao;

import	epimarket.db.*;

public abstract class	AbstractDAO
{
	protected	DBFacade	dbFacade;
	
	public AbstractDAO(){}
	
	public void create(Object obj)
	{
		dbFacade.create(obj);
	}
	
	public void read(String str)
	{
		dbFacade.read(str);
	}
	
	public void update(Object obj)
	{
		dbFacade.update(obj);
	}
	
	public void delete(Object obj)
	{
		dbFacade.delete(obj);
	}
}