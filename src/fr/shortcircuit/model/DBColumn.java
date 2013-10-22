package fr.shortcircuit.model;

import fr.shortcircuit.xml.IXMLObject;

public class DBColumn implements IXMLObject
{
	public ProductElement 	parent;
	public String 			class_column 	= "";
	public String 			db_column 		= "";
	public String 			type 			= "";
	
	
	public DBColumn()
	{
	
	}
	
//////////////////////////////////////////////////////////////////////////////////////////////////////
//Getters & Setters
//////////////////////////////////////////////////////////////////////////////////////////////////////

	public ProductElement		getParent() 		{return parent;			}
	public String 				getClass_column() 	{return class_column;	}
	public String 				getDb_column() 		{return db_column;		}
	public String 				getType() 			{return type;			}

	public void setParent(		ProductElement parent	) {this.parent 			= parent;		}
	public void setClass_column(String class_column		) {this.class_column 	= class_column;	}
	public void setDb_column(	String db_column		) {this.db_column 		= db_column;	}
	public void setType(		String type				) {this.type 			= type;			}


	//  to return full XML node
	public String toXmlString()
	{
		StringBuffer bufContent	= new StringBuffer();
		
		bufContent.append("Column ");
		bufContent.append("Class_column=\"" + this.getClass_column() + "\" ");

		if (db_column != null && db_column.length() != 0)
			bufContent.append("DB_column=\"" + this.getDb_column() + "\" ");	
		
		return bufContent.toString();	
	}
	
	public String toString()
	{
		if (db_column != null && db_column.length() != 0)
			return "db_column =  " + db_column + ", db_Class_column" + class_column;		
		else
			return class_column;	
	}
}
