package fr.shortcircuit.model;

public class User extends ProductElement
{
	private String		firstName;
	private String		lastName;
	private String		email;
	private Integer		userId;

	
	
	public User()
	{		
	}

	public User(String firstName, String lastName, String email, Integer userId)
	{
		this.firstName 	= firstName;
		this.lastName  	= lastName;
		this.email		= email;
		this.userId		= userId;
		
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//Getters & Setters
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	public 	String 	getFirstName()							{return firstName;	}
	public 	String 	getLastName()							{return lastName;	}
	public 	Integer getId()									{return userId;		}
	public 	String 	getEmail()								{return email;		}

	public 	void 	setFirstName(	String 	firstName	)	{this.firstName	= firstName;	}
	public 	void 	setLastName(	String 	lastName	)	{this.lastName 	= lastName;		}
	public 	void 	setId(			Integer userId		)	{this.userId	= userId;		}
	public 	void 	setEmail(		String 	email		)	{this.email		= email;		}
}
