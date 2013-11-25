package epimarket.model;

public class Address
{
	private String 		streetNumber;
	private String 		streetName;
	private String 		city;
	private String 		zipCode;
	private String 		country;
	private Integer		id = 0;
	
	public Address()
	{
		
	}
	
	public Address(String streetNumber, String streetName, String city, String zipCode, String country)
	{
		this.streetNumber 	= streetNumber;
		this.streetName 	= streetName;
		this.city 			= city;
		this.zipCode 		= zipCode;
		this.country 		= country;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//Getters & Setters
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	public String getStreetNumber()						{return streetNumber;}
	public String getStreetName()						{return streetName;}
	public String getCity()								{return city;}
	public String getZipCode()							{return zipCode;}
	public String getCountry()							{return country;}
	public Integer getId() 								{return id;}

	public void setStreetNumber(String streetNumber)	{this.streetNumber 	= streetNumber;}
	public void setStreetName(String streetName)		{this.streetName 	= streetName;}
	public void setCity(String city)					{this.city 			= city;}
	public void setZipCode(String zipCode)				{this.zipCode 		= zipCode;}
	public void setCountry(String country)				{this.country		= country;}
	public void setId(Integer id) 						{this.id 			= id;}
}