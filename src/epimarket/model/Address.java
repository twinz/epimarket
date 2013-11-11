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

public class Address
{
	private String 		streetNumber;
	private String 		streetName;
	private String 		city;
	private String 		zipCode;
	private String 		country;
	
	
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

	public String toString()
	{
		return "Address instance, streetNumber= " + streetNumber + ", streetName= " + streetName + ", city= " + city + ", zipCode= " + zipCode + ", country= " + country;
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//Getters & Setters
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	public String getStreetNumber()						{return streetNumber;}
	public String getStreetName()						{return streetName;}
	public String getCity()								{return city;}
	public String getZipCode()							{return zipCode;}
	public String getCountry()							{return country;}

	public void setStreetNumber(String streetNumber)	{this.streetNumber 	= streetNumber;}
	public void setStreetName(String streetName)		{this.streetName 	= streetName;}
	public void setCity(String city)					{this.city 			= city;}
	public void setZipCode(String zipCode)				{this.zipCode 		= zipCode;}
	public void setCountry(String country)				{this.country		= country;}
		
}
