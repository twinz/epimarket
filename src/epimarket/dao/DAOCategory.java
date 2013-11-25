package epimarket.dao;

import java.util.List;

import	epimarket.model.*;
import epimarket.dao.idao.IDAOCategory;
import	epimarket.db.*;

public class DAOCategory extends AbstractDAO implements IDAOCategory
{
	public DAOCategory(){
		super.dbFacade = new DBFacade();
	}
	/*
	public void create(Category obj)
	{
		super.create(obj);
	}
	
	*/
	public List read()
	{
		//return super.read(str);
		return super.read(Category.class.getSimpleName());
	}
	/*
	
	public void update(Category obj)
	{
		super.update(obj);
	}
	
	public void delete(Category obj)
	{
		super.delete(obj);
	}*/
}