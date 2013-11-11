package epimarket.model;



/** 
 * @author Dimitri Dean DARSEYNE (D3), 
 * Published by Short-Circuit under Creative Commons (CC) Licensing: 
 * Authorship/Paternity, NO Commercial Use, NO Derivative
 * Please check for more informations:
 * http://creativecommons.org/licenses/by-nc-nd/2.0/
 *
 * Auteur Dimitri Dean DARSEYNE (D3),
 * Publié par Short-Circuit sous license Creative Commons (CC):
 * Paternité, PAS d'Utilisation Commerciale, pas de Dérivés/Modifications
 * Pour plus d'informations, se rendre sur:
 * http://creativecommons.org/licenses/by-nc-nd/2.0/fr/ 
 * 
 * @since Short-Circuit 1999
 */


public abstract class AbstractProduct implements IBonusProducer
{
	private Category				category;
		
	private String 					id, designation, type; 
	
	private int						price;
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Constructors
	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public AbstractProduct()		{}

	/** Constructor overloading:  */
	public AbstractProduct(String id, String designation, Category category, int price)
	{
		createStructure(id, designation, category, price);	
	}
	
	public void createStructure(String id, String designation, Category category, int price)
	{
		this.id					= id;
		this.designation		= designation;		   
		this.price				= price;	
		this.category			= category;
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Business logic: "behaviour" defined by the IBonusProducer business interface 
	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public int getBonusPoint()								{return 10;}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Getter and setter
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Category getCategory()							{return category;}
	public String getId()									{return id;}
	public String getDesignation()							{return designation;}
	public String getType()									{return type;}
	public int getPrice()									{return price;}
	
	public void setCategories(Category category)			{this.category 			= category;}
	public void setId(String newIdValue)					{this.id				= newIdValue;}
	public void setDesignation(String newDesignationValue)	{this.designation		= newDesignationValue;}
	public void setType(String newTypeValue)				{this.type				= newTypeValue;}
	public void setPrice(int newPriceValue)					{this.price				= newPriceValue;}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Override java.lang.Object method 
	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public String toString()								
	{
		return "Product instance: id=" + id + ", designation=" + designation + ", price=" + price + ", getBonusPoint=" + getBonusPoint() + ";"
						+ 	"\r\n\t\t\t" + category.toString();
	}
		
}