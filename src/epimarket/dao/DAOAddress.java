package epimarket.dao;

import	epimarket.model.*;
import	epimarket.db.*;

public class DAOAddress extends AbstractDAO implements IDAOAddress
{
	public DAOAddress(){
		super.dbFacade = new DBFacade();
	}
	
	public void create(Address obj)
	{
		super.create(obj);
	}
	
	public void read(String str)
	{
		super.read(str);
	}
	
	public void update(Address obj)
	{
		super.update(obj);
	}
	
	public void delete(Address obj)
	{
		super.delete(obj);
	}
}