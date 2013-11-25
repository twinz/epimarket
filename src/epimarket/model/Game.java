package epimarket.model;

public class Game extends AbstractProduct
{	
	public Game() {}	
	
	public Game(String designation, int categoryId, int price)
	{
		createStructure(designation, categoryId, price);	
	}	
}