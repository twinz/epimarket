package epimarket.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import	epimarket.model.*;
import epimarket.dao.idao.IDAOAbstractProduct;
import	epimarket.db.*;

public class DAOAbstractProduct extends AbstractDAO implements IDAOAbstractProduct 
{
	public DAOAbstractProduct (){
		super.dbFacade = new DBFacade();
	}
	/*
	public void create(AbstractProduct  obj)
	{
		super.create(obj);
	}
	
	*/
	public List read()
	{
		//return super.read(str);
		return super.read(AbstractProduct.class.getSimpleName());
	}
	/*
	
	public void update(AbstractProduct  obj)
	{
		super.update(obj);
	}
	
	public void delete(AbstractProduct  obj)
	{
		super.delete(obj);
	}
	
	public int objectId(Object obj)
	{
		return super.objectId(obj);
	}*/
}