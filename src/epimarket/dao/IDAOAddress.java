package epimarket.dao;

import epimarket.model.*;

public interface IDAOAddress extends IDAO
{
	public void 		create(Object obj);
	public void			read(String str);
	public void 		update(Object obj);
	public void 		delete(Object obj);
}