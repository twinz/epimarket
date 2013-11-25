package epimarket.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import	epimarket.model.*;
import epimarket.dao.idao.IDAOOrderLine;
import	epimarket.db.*;

public class DAOOrderLine extends AbstractDAO implements IDAOOrderLine
{
	public DAOOrderLine(){
		super.dbFacade = new DBFacade();
	}
	/*
	public void create(OrderLine obj)
	{
		super.create(obj);
	}
	
		*/
	public List read()
	{
		//return super.read(str);
		return super.read(OrderLine.class.getSimpleName());
	}
	/*
	
	public void update(OrderLine obj)
	{
		super.update(obj);
	}
	
	public void delete(OrderLine obj)
	{
		super.delete(obj);
	}
	
	public int objectId(Object obj)
	{
		return super.objectId(obj);
	}*/
}