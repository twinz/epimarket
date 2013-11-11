package epimarket.dao;

import	epimarket.model.*;
import	epimarket.db.*;

public class DAOOrderLine extends AbstractDAO implements IDAOOrderLine
{
	public DAOOrderLine(){
		super.dbFacade = new DBFacade();
	}
	
	public void create(OrderLine obj)
	{
		super.create(obj);
	}
	
	public void read(String str)
	{
		super.read(str);
	}
	
	public void update(OrderLine obj)
	{
		super.update(obj);
	}
	
	public void delete(OrderLine obj)
	{
		super.delete(obj);
	}
}