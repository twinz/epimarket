package epimarket.dao;

import	epimarket.model.*;
import	epimarket.db.*;

public class DAOClient extends AbstractDAO implements IDAOClient
{
	public DAOClient(){
		super.dbFacade = new DBFacade();
	}
	
	public void create(Client obj)
	{
		super.create(obj);
	}
	
	public void read(String str)
	{
		super.read(str);
	}
	
	public void update(Client obj)
	{
		super.update(obj);
	}
	
	public void delete(Client obj)
	{
		super.delete(obj);
	}
}