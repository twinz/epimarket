package epimarket.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import	epimarket.model.*;
import epimarket.dao.idao.IDAODvd;
import	epimarket.db.*;

public class DAODvd extends AbstractDAO implements IDAODvd
{
	public DAODvd(){
		super.dbFacade = new DBFacade();
	}
	/*
	public void create(Dvd obj)
	{
		super.create(obj);
	}
	*/
	public List read()
	{
		//return super.read(str);
		return super.read(Dvd.class.getSimpleName());
	}
	/*
	
	public void update(Dvd obj)
	{
		super.update(obj);
	}
	
	public void delete(Dvd obj)
	{
		super.delete(obj);
	}*/
}