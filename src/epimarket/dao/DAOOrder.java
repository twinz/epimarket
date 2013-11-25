package epimarket.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import	epimarket.model.*;
import epimarket.dao.idao.IDAOOrder;
import	epimarket.db.*;

public class DAOOrder extends AbstractDAO implements IDAOOrder
{
	public DAOOrder(){
		super.dbFacade = new DBFacade();
	}
	/*
	public void create(Orders obj)
	{
		super.create(obj);
	}
	*/
	public List read()
	{
		//return super.read(str);
		return super.read(Orders.class.getSimpleName());
	}
	/*
	public void update(Orders obj)
	{
		super.update(obj);
	}
	
	public void delete(Orders obj)
	{
		super.delete(obj);
	}
	
	public int objectId(Object obj)
	{
		return super.objectId(obj);
	}*/
}