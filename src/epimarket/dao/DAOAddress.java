package epimarket.dao;

import java.util.List;

import	epimarket.model.*;
import epimarket.dao.idao.IDAOAddress;
import	epimarket.db.*;

public class DAOAddress extends AbstractDAO implements IDAOAddress
{
	public DAOAddress(){
		super.dbFacade = new DBFacade();
	}
	/*
	public void create(Integer obj)
	{
		super.create(obj);
	}
	
	*/
	public List read()
	{
		//return super.read(str);
		return super.read(Address.class.getSimpleName());
	}
	/*
	
	public void update(Integer obj)
	{
		super.update(obj);
	}
	
	public void delete(Integer obj)
	{
		super.delete(obj);
	}*/
}