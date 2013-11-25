package epimarket.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import	epimarket.model.*;
import epimarket.dao.idao.IDAOClient;
import	epimarket.db.*;

public class DAOClient extends AbstractDAO implements IDAOClient
{
	public DAOClient(){
		super.dbFacade = new DBFacade();
	}
	/*
	public void create(Client obj)
	{
		super.create(obj);
	}
	
	*/
	public List read()
	{
		//return super.read(str);
		return super.read(Client.class.getSimpleName());
	}
	/*
	
	public void update(Client obj)
	{
		super.update(obj);
	}
	
	public void delete(Client obj)
	{
		super.delete(obj);
	}*/
}