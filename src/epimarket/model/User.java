package epimarket.model;

public class User
{
	private String		firstName;
	private String		lastName;
	private String		email;
	private Integer		Id;

	
	
	public User()
	{		
	}

	public User(String firstName, String lastName, String email, Integer Id)
	{
		this.firstName 	= firstName;
		this.lastName  	= lastName;
		this.email		= email;
		this.Id		=	 Id;
		
	}

	//////////////////////////////////////////////////////////////////////////////////////////////////////
	//Getters & Setters
	//////////////////////////////////////////////////////////////////////////////////////////////////////

	public 	String 	getFirstName()							{return firstName;	}
	public 	String 	getLastName()							{return lastName;	}
	public 	Integer getId()									{return Id;		}
	public 	String 	getEmail()								{return email;		}

	public 	void 	setFirstName(	String 	firstName	)	{this.firstName	= firstName;	}
	public 	void 	setLastName(	String 	lastName	)	{this.lastName 	= lastName;		}
	public 	void 	setId(			Integer Id			)	{this.Id	= Id;		}
	public 	void 	setEmail(		String 	email		)	{this.email		= email;		}
}
