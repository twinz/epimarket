package epimarket.model;

public abstract class AbstractProduct
{
	private Category				category;	
	private String 					designation; 
	private Integer					price;
	private Integer					categoryId 		= -1;
	private Integer					id 				= 0;
	
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Constructors
	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public AbstractProduct()		{}
	
	public AbstractProduct(String designation, int categoryId, int price)
	{
		createStructure(designation, categoryId, price);	
	}
	
	public void createStructure(String designation, int categoryId, int price)
	{
		this.designation		= designation;		   
		this.price				= price;	
		this.categoryId			= categoryId;
	}

	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Getter and setter
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Integer	getId()										{return id;}
	public String 	getDesignation()							{return designation;}
	public Integer 	getPrice()									{return price;}
	public Integer 	getCategoryId() 							{return categoryId;}
	
	public void 	setCategories(Category category)			{this.category 			= category;}
	public void 	setId(Integer newIdValue)					{this.id				= newIdValue;}
	public void 	setDesignation(String newDesignationValue)	{this.designation		= newDesignationValue;}
	public void 	setPrice(Integer newPriceValue)				{this.price				= newPriceValue;}
	public void 	setCategoryId(Integer categoryId) 			{this.categoryId 		= categoryId;}
}