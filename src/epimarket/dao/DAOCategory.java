package epimarket.dao;

import	epimarket.model.*;
import	epimarket.db.*;

public class DAOCategory extends AbstractDAO implements IDAOCategory
{
	public DAOCategory(){
		super.dbFacade = new DBFacade();
	}
	
	public void create(Category obj)
	{
		super.create(obj);
	}
	
	public void read(String str)
	{
		super.read(str);
	}
	
	public void update(Category obj)
	{
		super.update(obj);
	}
	
	public void delete(Category obj)
	{
		super.delete(obj);
	}
}