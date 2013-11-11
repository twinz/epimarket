package epimarket.model;

/** 
 * @author Dimitri Dean DARSEYNE (D3), 
 * Published by Short-Circuit under Creative Commons (CC) Licensing: 
 * Authorship/Paternity, NO Commercial Use, NO Derivative
 * Please check for more informations:
 * http://creativecommons.org/licenses/by-nc-nd/2.0/
 *
 * Auteur Dimitri Dean DARSEYNE (D3),
 * Publié par Short-Circuit sous l	icense Creative Commons (CC):
 * Paternité, PAS d'Utilisation Commerciale, pas de Dérivés/Modifications
 * Pour plus d'informations, se rendre sur:
 * http://creativecommons.org/licenses/by-nc-nd/2.0/fr/ 
 * 
 * @since Short-Circuit 1999
 */

/**
 * A Simple order entity providing:<BR> 
 * 
 * - Litteral properties, for usual OrderLines fields
 * - A reference to a Product, associated to the quantity ordered.
 */  
public class OrderLine
{
	/** The target Product */
	private AbstractProduct 	product;
	
	/** The desired quantity for the selected product */
	private Integer		quantity;
	
	
	public OrderLine()	{}

	public OrderLine(AbstractProduct product, int quantity)
	{
		setProduct(product);
		setQuantity(quantity);
	}

	public String toString()
	{
		return "OrderLine instance: quantity=" + quantity + "\r\n\t\tassociated Product=" + ((product != null)? product.toString() : "null");
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//Getters & Setters
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	public AbstractProduct getProduct()					{return product;}
	public Integer getQuantity()						{return quantity;}
	
	public void setProduct(AbstractProduct product)		{this.product 	= product;}
	public void setQuantity(Integer quantity)			{this.quantity 	= quantity;}

}
