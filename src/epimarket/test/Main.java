package epimarket.test;

import java.util.HashMap;
import java.util.List;
import epimarket.model.*;
import epimarket.dao.*;
import epimarket.dao.idao.IDAO;

public class Main
{	
	public static void main(String argv[])
	{
		buildEntities();
	}
	
	public static void buildEntities()
	{
		
		//Clients
		IDAO 	DaoAddress 	= new DAOAddress();
		IDAO 	DaoClient 	= new DAOClient();
		
		Address add11 		= new Address("124", "Magenta", "Paris", "75010", "France");
		Address add12 		= new Address("42", "Magenta", "Paris", "75010", "France");
		DaoAddress.create(add11);
		DaoAddress.create(add12);
		
		Client	cli1		= new Client(DaoAddress.objectId(add11), "Alexandre", "Martens");
		Client	cli2		= new Client(DaoAddress.objectId(add12), "Raphael", "Martens");
		DaoClient.create(cli1);
		DaoClient.create(cli2);
		
		
		//Categories
		IDAO DaoCategory 	= new DAOCategory();
		Category cat1		= new Category("US");
		Category cat2		= new Category("Asia");
		Category cat3		= new Category("Europe");
		
		DaoCategory.create(cat1);
		DaoCategory.create(cat2);
		DaoCategory.create(cat3);
		
		//AbstractProduct
		IDAO DaoAbstrackProduct = new DAOAbstractProduct();
		
		//AbstractProduct p00 	= new Dvd("null", 1, 0);
		//AbstractProduct p01 	= new Game("null", 1, 0);
		
		
		AbstractProduct p1 	= new Dvd("Any Given Sunday", 	DaoAbstrackProduct.objectId(cat1), 10);
		AbstractProduct p2 	= new Dvd("Braveheart", 		DaoAbstrackProduct.objectId(cat3), 15);
		AbstractProduct p3 	= new Dvd("Tigres et dragons", 	DaoAbstrackProduct.objectId(cat2), 15);
		AbstractProduct p4 	= new Dvd("Les grands ducs", 	DaoAbstrackProduct.objectId(cat3), 20);
		AbstractProduct p5	= new Game("Heroes of Might",	DaoAbstrackProduct.objectId(cat3), 50);
		AbstractProduct p6	= new Game("Civilisation 5", 	DaoAbstrackProduct.objectId(cat1), 50);
		
		//DaoAbstrackProduct.create(p00);
		//DaoAbstrackProduct.create(p01);
		DaoAbstrackProduct.create(p1);
		DaoAbstrackProduct.create(p2);
		DaoAbstrackProduct.create(p3);
		DaoAbstrackProduct.create(p4);
		DaoAbstrackProduct.create(p5);
		DaoAbstrackProduct.create(p6);
		
		//OrderLine
		IDAO DaoOrderLine	= new DAOOrderLine();
		OrderLine ol1		= new OrderLine(DaoOrderLine.objectId(p6), 1);
		OrderLine ol2		= new OrderLine(DaoOrderLine.objectId(p1), 2);
		OrderLine ol3		= new OrderLine(DaoOrderLine.objectId(p2), 3);
		
		DaoOrderLine.create(ol1);
		DaoOrderLine.create(ol2);
		DaoOrderLine.create(ol3);
		
		//Order
		IDAO DaoOrder		= new DAOOrder();
		
		Orders	ord1		= new Orders(DaoOrder.objectId(cli1), DaoOrder.objectId(ol1));
		Orders	ord2		= new Orders(DaoOrder.objectId(cli2), DaoOrder.objectId(ol2));
		
		DaoOrder.create(ord1);
		DaoOrder.create(ord2);
		
		//Test
		List list = DaoOrder.read();
		aff(list);
		
		// Supprime Raph
		//DaoOrder.delete(ord1);
		
		//list = DaoOrder.read("SELECT * FROM ORDERS;");
		//aff(list);
		
		// Supprime achat Alex
		//DaoOrderLine.delete(ol2);
		
		//list = DaoOrder.read("SELECT * FROM ORDERS;");
		//aff(list);
		
		
	}
	
	public static void aff(List list)
	{
		System.out.println("----------------------------------------------------");
		for (int i = 0; i != list.size(); i++)
		{ 
			HashMap mMap = (HashMap) list.get(i);
			System.out.println("Order" + i);
				for (int j = 0; j != mMap.size(); j++)
				{
					System.out.println("|---> " + mMap.keySet().toArray()[j]);
					System.out.println("    |---> " + mMap.values().toArray()[j]);
				}
				System.out.println("\n");
		}
		System.out.println("\n");
	}
}
