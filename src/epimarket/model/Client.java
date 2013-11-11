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

/**
 * A Client structure definition, with two addresses, one for billing, one for delivery (references can obviously be equals :)
 * 
 * 
 * author Dim
 */
public class Client
{
	private Address		billingAddress;
	private Address		deliveryAddress;
	
	private String		firstName;
	private String		lastName;

	
	
	public Client()
	{
		
	}
	
	public Client(Address billingAddress, Address deliveryAddress, String firstName, String	lastName)
	{
		this.billingAddress 	= billingAddress;
		this.deliveryAddress 	= deliveryAddress;
		this.firstName 			= firstName;
		this.lastName 			= lastName;
	}

	//usual toString overRiding
	public String toString()
	{
		return "Client instance: firstName=" 	+ firstName + ", lastName=" + lastName 
												+ "\r\n\t\tbillingAddress: " 	+ ((billingAddress != null)? 	billingAddress.toString() 	: "null") 
		 										+ "\r\n\t\tdeliveryAddress: " 	+ ((deliveryAddress != null)? 	deliveryAddress.toString() : "null");
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//Getters & Setters
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	public Address getBillingAddress()						{return billingAddress;}
	public Address getDeliveryAddress()						{return deliveryAddress;}
	public String getFirstName()							{return firstName;}
	public String getLastName()								{return lastName;}

	public void setBillingAddress(Address billingAddress)	{this.billingAddress 	= billingAddress;}
	public void setDeliveryAddress(Address deliveryAddress)	{this.deliveryAddress 	= deliveryAddress;}
	public void setFirstName(String firstName)				{this.firstName 		= firstName;}
	public void setLastName(String lastName)				{this.lastName 			= lastName;}

}
