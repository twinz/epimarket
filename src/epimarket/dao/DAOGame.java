package epimarket.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import	epimarket.model.*;
import epimarket.dao.idao.IDAOGame;
import	epimarket.db.*;

public class DAOGame extends AbstractDAO implements IDAOGame
{
	public DAOGame(){
		super.dbFacade = new DBFacade();
	}
	/*
	public void create(Game obj)
	{
		super.create(obj);
	}
	
	*/
	public List read()
	{
		//return super.read(str);
		return super.read(Game.class.getSimpleName());
	}
	/*
	
	public void update(Game obj)
	{
		super.update(obj);
	}
	
	public void delete(Game obj)
	{
		super.delete(obj);
	}*/
}