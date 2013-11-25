package epimarket.model;

public class Orders
{
	private Client 					client;
	private int						clientId;
	private int						orderLineId;
	
	public Orders(int clientId, int linesId)
	{
		this.clientId 		= 		clientId;
		this.orderLineId 	= 		linesId;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//Getters & Setters
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	
	public void setClient(Client client)					{this.client 			= client;}
	public void setOrderLineId(int orderLineId) 			{this.orderLineId 		= orderLineId;}
	
	public int getClientId() 								{return clientId;}
	public int getOrderLineId() 							{return orderLineId;}
	
}
