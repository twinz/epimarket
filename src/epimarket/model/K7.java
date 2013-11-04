package epimarket.model;

public class K7 
{
	private	String		titre;
	private String		description;
	private	Integer		prix;
	private Integer		reduction;
	private Integer		Id;
	private Integer 	coefBonus		= 15;
	
	
	public K7(){}	
	
	/*public int calculateBonus()
	{
		return Integer.parseInt(getPrice()) * coefBonus; 	
	}*/
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//Getters & Setters
//////////////////////////////////////////////////////////////////////////////////////////////////////


public 	String 		getTitre() 								{return titre;						}
public 	String 		getDescription() 						{return description;				}
public 	Integer 	getPrix() 								{return prix;						}
public 	Integer 	getReduction() 							{return reduction;					}
public 	Integer 	getId() 								{return Id;							}

public 	void 		setTitre(		String 	titre		) 	{this.titre 		= titre;		}
public 	void 		setDescription(	String 	description	) 	{this.description 	= description;	}
public	void 		setPrix(		Integer prix		) 	{this.prix 			= prix;			}
public 	void 		setReduction(	Integer reduction	) 	{this.reduction		= reduction;	}
public 	void 		setId(			Integer Id			) 	{this.Id 			= Id;			}
}