package epimarket.test;

import java.util.GregorianCalendar;

import epimarket.model.*;
import epimarket.dao.*;

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
		Address add12 		= new Address("124", "Magenta", "Paris", "75010", "France");
		Client	cli1		= new Client(add11, add12, "Alexandre", "Martens");
		Client	cli2		= new Client(add11, add12, "Raphael", "Martens");
		
		DaoAddress.create(add11);
		DaoAddress.create(add12);
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
		AbstractProduct p1 	= new Dvd("51", 	"Any Given Sunday", 	cat1, 10);
		AbstractProduct p2 	= new Dvd("52", 	"Braveheart", 			cat3, 15);
		AbstractProduct p3 	= new Dvd("53", 	"Tigres et dragons", 	cat2, 15);
		AbstractProduct p4 	= new Dvd("54", 	"Les grands ducs", 		cat3, 20);
		AbstractProduct p5	= new Game("55", 	"Heroes of Might",	 	cat3, 50);
		AbstractProduct p6	= new Game("56", 	"Civilisation 5", 		cat1, 50);
		
		DaoAbstrackProduct.create(p1);
		DaoAbstrackProduct.create(p2);
		DaoAbstrackProduct.create(p3);
		DaoAbstrackProduct.create(p4);
		DaoAbstrackProduct.create(p5);
		DaoAbstrackProduct.create(p6);
		
		//OrderLine
		IDAO DaoOrderLine	= new DAOOrderLine();
		OrderLine ol1		= new OrderLine(p6, 2);
		OrderLine ol2		= new OrderLine(p1, 1);
		OrderLine ol3		= new OrderLine(p2, 1);
		
		DaoOrderLine.create(ol1);
		DaoOrderLine.create(ol2);
		DaoOrderLine.create(ol3);
		
		//Order
		IDAO DaoOrder		= new DAOOrder();
		Order	ord1		= new Order();
		Order	ord2		= new Order();
		
		ord1.addLine(ol1);
		ord1.addLine(ol2);
		ord1.setDateOrderStarted(new GregorianCalendar().getTime());
		ord2.addLine(ol3);
		ord2.setDateOrderStarted(new GregorianCalendar().getTime());	
		// Faire un create
	}
}
