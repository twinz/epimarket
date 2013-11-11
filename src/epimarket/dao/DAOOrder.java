package epimarket.dao;

import	epimarket.model.*;
import	epimarket.db.*;

public class DAOOrder extends AbstractDAO implements IDAOOrder
{
	public DAOOrder(){
		super.dbFacade = new DBFacade();
	}
	
	public void create(Order obj)
	{
		super.create(obj);
	}
	
	public void read(String str)
	{
		super.read(str);
	}
	
	public void update(Order obj)
	{
		super.update(obj);
	}
	
	public void delete(Order obj)
	{
		super.delete(obj);
	}
}