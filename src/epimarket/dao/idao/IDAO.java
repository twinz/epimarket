package epimarket.dao.idao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public interface IDAO
{
	public void 		create(Object obj);
	public List			read();
	public void 		update(Object obj);
	public void 		delete(Object obj);
	public int			objectId(Object obj);
}