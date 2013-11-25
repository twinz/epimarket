package epimarket.model;

public class Dvd extends AbstractProduct
{
	public Dvd() {}	

	public Dvd(String designation, int categoryId, int price)
	{
		createStructure(designation, categoryId, price);	
	}
}