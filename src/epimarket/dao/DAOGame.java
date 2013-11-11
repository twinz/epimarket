package epimarket.dao;

import	epimarket.model.*;
import	epimarket.db.*;

public class DAOGame extends AbstractDAO implements IDAOGame
{
	public DAOGame(){
		super.dbFacade = new DBFacade();
	}
	
	public void create(Game obj)
	{
		super.create(obj);
	}
	
	public void read(String str)
	{
		super.read(str);
	}
	
	public void update(Game obj)
	{
		super.update(obj);
	}
	
	public void delete(Game obj)
	{
		super.delete(obj);
	}
}