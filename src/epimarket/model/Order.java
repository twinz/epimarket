package epimarket.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import epimarket.model.state.EOrderState;
import epimarket.model.state.IStateChangeable;
import epimarket.model.validation.ValidationException;
import epimarket.utils.DateHelper;

public class Order implements IStateChangeable
{
	private Client 					client;
	private List<OrderLine> 		lines 		= new ArrayList<OrderLine>();
	private EOrderState 			state;
	private Date					dateOrderStarted;
	private Date					dateOrderEnded;
	
	public Order()
	{
		
		state = EOrderState.TRANSACTION_STARTED;
	}

	public float getTotal()
	{
		float total = 0;
		
		for (Iterator<OrderLine> i = lines.iterator(); i.hasNext(); )
		{
			OrderLine ol = i.next(); 
			
			total += ol.getQuantity() * ol.getProduct().getPrice();
		}
	
		return total;
	}

	public String toString()
	{
		StringBuilder sb = new StringBuilder();

		sb.append("Order: \r\n\tState=" 	+ state.toString() 
				+ ((dateOrderStarted != null)? 	", dateOrderStarted=" + DateHelper.getStringDate(dateOrderStarted)	: ", dateOrderStarted = null") 
				+ ((dateOrderEnded != null)? 	", dateOrderEnded=" + DateHelper.getStringDate(dateOrderEnded)	: ", dateOrderEnded = null"));

		sb.append("\r\n");

		//Ternary operator use
		sb.append("\r\n\tClient: " + ((client != null)? client.toString() : "null"));

		sb.append("\r\n");

		//Please Note: the simplified grammatical definition of a "for"
		for (OrderLine i : lines)
			sb.append("\r\n\t" + i.toString());

		return sb.toString();
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//IValidable interface implementation
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
		
	public void validate() throws ValidationException
	{
		if  (client == null)
			throw new ValidationException("Order instance: client IS NULL !!!");
		
		for (Iterator<OrderLine> i = lines.iterator(); i.hasNext(); )
		{
			OrderLine ol = i.next(); 
			
			if  ((ol.getProduct() == null) || (ol.getQuantity() == null))
				throw new ValidationException("Order line instance: instance not consistent, inner product reference, and/or quantity IS NULL !!!");
		}
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//List common handling
	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void addLine(OrderLine l)						{lines.add(l);}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//Getters & Setters
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public Client getClient()								{return client;}
	public List<OrderLine> getLines()						{return lines;}
	public EOrderState getState()							{return state;}
	public Date getDateOrderStarted()						{return dateOrderStarted;}
	public Date getDateOrderEnded()							{return dateOrderEnded;}

	public void setClient(Client client)					{this.client 			= client;}
	public void setLines(List<OrderLine> lines)				{this.lines 			= lines;}
	public void setState(EOrderState state)					{this.state 			= state;}
	public void setDateOrderStarted(Date dateOrderStarted)	{this.dateOrderStarted 	= dateOrderStarted;}
	public void setDateOrderEnded(Date dateOrderEnded)		{this.dateOrderEnded 	= dateOrderEnded;}
}
