package epimarket.model;

public class Client
{
	private Address		address 	= null;
	private String		firstName;
	private String		lastName;
	private Integer		addressId 	= -1;
	
	public Client(){}
	
	public Client(Integer addressId, String firstName, String lastName)
	{
		this.firstName 	= firstName;
		this.lastName 	= lastName;
		this.addressId	= addressId;
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//Getters & Setters
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	public String getFirstName()							{return firstName;}
	public String getLastName()								{return lastName;}
	public Integer getAddressId() 							{return addressId;}

	public void setFirstName(String firstName)				{this.firstName 		= firstName;}
	public void setLastName(String lastName)				{this.lastName 			= lastName;}
	public void setAddressId(Integer addressId) 			{this.addressId 		= addressId;}
}
