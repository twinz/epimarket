package epimarket.model;
 
public class OrderLine
{
	private AbstractProduct 	product;
	private Integer				quantity;
	private Integer				abstractProductId;
	
	
	public OrderLine()	{}

	public OrderLine(int productId, int quantity)
	{
		this.abstractProductId = productId;
		this.quantity  = quantity;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//Getters & Setters
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	public Integer getQuantity()						{return quantity;}
	
	public void setProduct(AbstractProduct product)		{this.product 	= product;}
	public void setQuantity(Integer quantity)			{this.quantity 	= quantity;}

	public Integer getAbstractProductId() {
		return abstractProductId;
	}

	public void setAbstractProductId(Integer abstractProductId) {
		this.abstractProductId = abstractProductId;
	}


	
	
}
