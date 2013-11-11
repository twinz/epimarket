package epimarket.dao;

import	epimarket.model.*;
import	epimarket.db.*;

public class DAODvd extends AbstractDAO implements IDAODvd
{
	public DAODvd(){
		super.dbFacade = new DBFacade();
	}
	
	public void create(Dvd obj)
	{
		super.create(obj);
	}
	
	public void read(String str)
	{
		super.read(str);
	}
	
	public void update(Dvd obj)
	{
		super.update(obj);
	}
	
	public void delete(Dvd obj)
	{
		super.delete(obj);
	}
}