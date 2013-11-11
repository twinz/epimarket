package epimarket.db;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.io.File;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.beanutils.BeanUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import epimarket.xml.*;

import epimarket.model.*;


public class DBManager
{
		public Connection			myConnect;	
		public Statement			myState;
		public ResultSet			myResultSet;

		public DatabaseMetaData		myDbMetaData;
		public ResultSetMetaData	myResultSetMetaData;
		
		public PreparedStatement 	myPreparedStatement;

		public String				strDriver;
		public String 				strConnectURL;
		public String				strUser;
		public String				strPass;
		
		public DBFacade				dbFacade;
		public DBFactory			dbFactory;
		public DBConfig				dbConfig;
		

		public DBManager(String strDriver, String strConnectURL, String strUser, String strPass, DBConfig dbConfig)
		{
			try
			{	
				this.strDriver 			=	strDriver;
				this.strConnectURL		=	strConnectURL;
				this.strUser 			=	strUser;
				this.strPass 			=	strPass;
				this.dbConfig			=	dbConfig;
			}	
			catch (Exception e) 				{System.out.println("dbConnect Exception: " + e.toString()); 	e.printStackTrace();}		
		}
		
		public void connect()
		{
			try
			{
				Class.forName(this.strDriver);
				myConnect =	DriverManager.getConnection(this.strConnectURL, this.strUser, this.strPass);
			}
			catch (ClassNotFoundException e) 	{System.out.println("Connexion au DBManager : Classe non existente: " + e.toString());}	
			catch (SQLException e) 				{System.out.println("Connexion au DBManager : Erreur interne SQL: " + e.toString());}				
		}
		
		public void	disconnect()
		{
			try
			{
				myState.close();
				myConnect.close();
			}
			catch (SQLException e)				{System.out.println("Deconnexion au DBManager: Erreur interne SQL: " + e.toString());}
		}
		
		// INSERT
		public void create(Object obj) // METHODE
		{
			try
			{
				Method[] 	tab_method 	=	obj.getClass().getMethods();
				String		sql			=	"";
				String		key			=	"";
				String		value		=	"";
				
				for (int i = 0; i < tab_method.length; i++)
				{
					if (tab_method[i].getName().subSequence(0, 3).equals("get") && !(tab_method[i].getName().equals("getClass")))
					{
						key 	+= check_struck_db_attribue(tab_method[i].getName().subSequence(3, tab_method[i].getName().length()).toString()) + ",";
						if (tab_method[i].getName().equals("getId"))
							value	+= tab_method[i].invoke(obj) + ",";
						else
							value	+= "\"" + tab_method[i].invoke(obj) + "\",";		 
					}
				}
				key = key.substring(0, key.length() - 4);
				value = value.substring(0, value.length() - 1);
				key += ",Id";
				
				sql = "INSERT INTO epimarket." + check_struck_db(obj.getClass().getSimpleName()) + " (" + key + ") VALUES (" + value + ");";
				Execute_query("Insert", sql);
			}
			catch (Exception e) // INSERT INTO epimarket.USER (firstName, lastName, email, userId) VALUES ("test1", "test2", "test3", 1);
			{
				
			}		
		}			
		
		
		
		// DELETE
		// changer le nom des ids et mettre getid partout et dans xml
		
		
		public void delete(Object obj)
		{
			try
			{
				Method[] 	tab_method 	=	obj.getClass().getMethods();
				String		sql			=	"DELETE FROM epimarket." + check_struck_db(obj.getClass().getSimpleName()) + " WHERE ";
				
				for (int i = 0; i < tab_method.length; i++)
				{
					if (tab_method[i].getName().equals("getId"))
						sql += check_struck_db_attribue(tab_method[i].getName().subSequence(3, tab_method[i].getName().length()).toString()) + " = " + tab_method[i].invoke(obj);
				}
				Execute_query("Delete", sql);
			}
			catch (Exception e) // DELETE FROM epimarket.USER WHERE userId = 1;
			{
					
			}
		}
		
		// UPDATE
		public void update(Object obj)
		{
			try
			{/*
				Method[] 	tab_method 	=	obj.getClass().getMethods();
				String		sql			=	"UPDATE " + check_struck_db(obj.getClass().getSimpleName()) + " SET ";
				
				for (int i = 0; i < tab_method.length; i++)
				{
					if (tab_method[i].getName().subSequence(0, 3).equals("get") && !(tab_method[i].getName().equals("getClass")))
						sql += "'" + check_struck_db_attribue(tab_method[i].getName().subSequence(3, tab_method[i].getName().length()).toString()) + "'='" + tab_method[i].invoke(obj) + "',";
				}
				sql = sql.substring(0, sql.length() - 1);
				sql += ";";
				Execute_query("Update", sql);*/
				delete(obj);
				create(obj);
			}
			catch (Exception e)
			{
				
			}
		}
		
		public void read(String sql)
		{
			try
			{/*
				ArrayList<User> collUser = new ArrayList<User>();
				 
				    myState				=	myConnect.createStatement();
				    myPreparedStatement	=	myConnect.prepareStatement(sql);
					myResultSet 		= 	myPreparedStatement.executeQuery();
					
					
					
				    User user = null;
				     
				    while (myResultSet.next()) {

				    	user = new User();
				
				    	myResultSetMetaData = myResultSet.getMetaData();
					
					for (int i = 0; i != myResultSetMetaData.getColumnCount(); i++)
					{
						System.out.println("type = " + myResultSetMetaData.getColumnTypeName(i + 1));
						System.out.println("column_name = " + myResultSetMetaData.getColumnName(i + 1));
						
						if (myResultSetMetaData.getColumnTypeName(i + 1) == "VARCHAR")
							BeanUtils.setProperty(user, "set" + myResultSetMetaData.getColumnName(i + 1), myResultSet.getString(i + 1)); // probleme de case (maj) // si tous change att au id pour insert ...
						else
							BeanUtils.setProperty(user, "set" + myResultSetMetaData.getColumnName(i + 1), myResultSet.getInt(i + 1));
					}
					//System.out.println("\n");
					
				     // user.setFirstName(myResultSet.getString(1));
				      //user.setLastName( myResultSet.getString(2) );
				      //user.setEmail(myResultSet.getString(3));
				      //user.setId(myResultSet.getInt(4));
				 
				      collUser.add( user );
				    }
				    
				    for (int i= 0; i != collUser.size(); i++)
				    {
				    	System.out.println("Ligne " + i + " = \nfirstName = " + collUser.get(i).getFirstName()+ "\tlastName = " + collUser.get(i).getLastName()+ "\temail = " + collUser.get(i).getEmail()+ "\tid = " + collUser.get(i).getId());
				    }*/
				    
			}
			//catch (SQLException e)                 	{System.out.println("Connexion au DBManager : Erreur interne SQL: " + e.toString()); 			e.printStackTrace();}        
            catch (Exception e)                 	{System.out.println("Connexion au DBManager : Operation non valide: " + e.toString());         	e.printStackTrace();}
			
		}
		/*
		 * PARCOURIR LES COLUMNS UNE PAR UNE
		 * ResultSetMetaData rsmd = rs.getMetaData(); // Récupération des métadonnées
 
			for (int i = 1; i <= rsmd.getColumnCount(); i++){
      			record.add(rs.getString(i));
			}
		 * 
		 */
				
				
				/*
				System.out.println("sql = " + sql);
				List<Object> 	list 	= new ArrayList<Object>();
				
				myState				=	myConnect.createStatement();
				myResultSet 		= 	myPreparedStatement.executeQuery(sql);
	            System.out.println("Select done");
	            Object obj;
	            
	            while (myResultSet.next())
	            {
	            	try{
	            		System.out.println("resultset = " + myResultSet);
	            	}
	            	catch (Exception e){}
	            }
			}
			catch (SQLException e)                 	{System.out.println("Connexion au DBManager : Erreur interne SQL: " + e.toString()); 			e.printStackTrace();}        
            catch (Exception e)                 	{System.out.println("Connexion au DBManager : Operation non valide: " + e.toString());         	e.printStackTrace();}     */   
					
		
		public String	check_struck_db(String name)
		{
			String res = "";
			
			for (int j = 0; j != dbConfig.getDBList().size(); j++)
			{
				if (dbConfig.getDBList().get(j).getClass_name().equalsIgnoreCase(name))
				{
					res =  dbConfig.getDBList().get(j).getDb_name();
					return res;
				}
				
			}	
			return res;
		}
		
		public String	check_struck_db_attribue(String name)
		{
			String res = "";
			
			for (int j = 0; j != dbConfig.getDBList().size(); j++)
			{
				for (int i = 0; i != dbConfig.getDBList().get(j).getColumns().size(); i++)
				{
					if (dbConfig.getDBList().get(j).getColumns().get(i).getclass_name().equalsIgnoreCase(name))
					{
						res =  dbConfig.getDBList().get(j).getColumns().get(i).getdb_column();
						return res;
					}
				}
				
			}	
			return res;
		}

		
		public void	Execute_query(String name_query, String query)
		{
			try
			{
				System.out.println("Query = " + query);
				
				myState				=	myConnect.createStatement();
				myPreparedStatement = 	myConnect.prepareStatement(query);
				
				myPreparedStatement.executeUpdate(query);
				System.out.println(name_query + " done\n");
			} 
			catch (SQLException e)                 	{System.out.println("Connexion au DBManager : Erreur interne SQL: " + e.toString()); 			e.printStackTrace();}        
            catch (Exception e)                 	{System.out.println("Connexion au DBManager : Operation non valide: " + e.toString());         	e.printStackTrace();}        
    }
}