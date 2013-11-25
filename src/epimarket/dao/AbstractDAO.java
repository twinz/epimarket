package epimarket.dao;

import java.util.List;

import	epimarket.db.*;

public abstract class	AbstractDAO
{
	protected	DBFacade	dbFacade;
	
	public AbstractDAO(){}
	
	public void create(Object obj)
	{
		dbFacade.create(obj);
	}
	
	public List read(Object obj)
	{
		return dbFacade.read(obj);
	}
	
	public void update(Object obj)
	{
		dbFacade.update(obj);
	}
	
	public void delete(Object obj)
	{
		dbFacade.delete(obj);
	}
	
	public int objectId(Object obj)
	{
		return dbFacade.objectId(obj);
	}
}