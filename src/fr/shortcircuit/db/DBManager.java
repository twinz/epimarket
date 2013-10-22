package fr.shortcircuit.db;

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

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;


public class DBManager
{
	//Objects spécifiques aux differents appels vers les bases (locales ou distantes).	
	// connect ... db manager
		public Connection			myConnect;	
		public Statement			myState;
		public ResultSet			myResultSet;

		//Objects de Meta-Information sur la Database connectée, et sur la requête effectuée.
		public DatabaseMetaData		myDbMetaData;
		public ResultSetMetaData	myResultSetMetaData;
		
		public PreparedStatement 	myPreparedStatement;

		public String				strDriver;
		public String 				strConnectURL;
		public String				strUser;
		public String				strPass;
		

		public DBManager(String strDriver, String strConnectURL, String strUser, String strPass)
		{
			try
			{	
				this.strDriver 			=	strDriver;
				this.strConnectURL		=	strConnectURL;
				this.strUser 			=	strUser;
				this.strPass 			=	strPass;
			
				//1ere etape: Chargement de la classe de driver
				Class.forName(this.strDriver);
					
	 			//2eme etape: Creation de l'object de connection
				myConnect 			=	DriverManager.getConnection(this.strConnectURL, this.strUser, this.strPass);
			
				//Option: Acces a un jeu de meta information sur la base avec laquelle on dialogue.
				myDbMetaData 		=	myConnect.getMetaData();

				System.out.println("DbManager: dbConnect: show DataBase MetaData:");
				System.out.println("DbManager: dbConnect: productName=" 	+ myDbMetaData.getDatabaseProductName());
				System.out.println("DbManager: dbConnect: productVersion=" 	+ myDbMetaData.getDatabaseProductVersion());
			}
			catch (Exception e)
			{
				
			}	
		}
	
		// probleme met des '' meme pour les int
		// peut etre tous mettre en string et apres transformer les string pour les nbr en int
		
		
		// INSERT
		public void Insert_sql_lite(Object obj) // METHODE
		{
			try
			{
				Method[] 	tab_method 	=	obj.getClass().getMethods();
				String		sql			=	"";
				String		key			=	"";
				String		value		=	"";
				
				for (int i = 0; i < tab_method.length; i++)
				{
					if (tab_method[i].getName().subSequence(0, 3).equals("get"))
					{
						key 	+= "'" + tab_method[i].getName().subSequence(3, tab_method[i].getName().length()).toString() + "',";
						value	+= "'" + tab_method[i].invoke(obj) + "',";		 
					}
				}
				key = key.substring(0, key.length() - 1);
				value = value.substring(0, value.length() - 1);
				sql = "INSERT INTO '" + obj.getClass().getName().toUpperCase() + "' (" + key + ") VALUES (" + value + ");";
				Execute_query("Insert", sql);
			}
			catch (Exception e)
			{
				
			}		
		}
		
		// DELETE
		public void Delete_sql_lite(Object obj)
		{
			try
			{
				Method[] 	tab_method 	=	obj.getClass().getMethods();
				String		sql			=	"DELETE FROM " + obj.getClass().getName().toUpperCase() + " WHERE ";
				
				for (int i = 0; i < tab_method.length; i++)
				{
					if (tab_method[i].getName().subSequence(0, 5).equals("getId"))
						sql += tab_method[i].getName().subSequence(3, tab_method[i].getName().length()).toString() + " = " + tab_method[i].invoke(obj);
				}
				Execute_query("Delete", sql);
			}
			catch (Exception e)
			{
					
			}
		}
		
		// UPDATE
		public void Update_sql_lite(Object obj)
		{
			try
			{
				Method[] 	tab_method 	=	obj.getClass().getMethods();
				String		sql			=	"UPDATE " + obj.getClass().getName().toUpperCase() + " SET ";
				
				for (int i = 0; i < tab_method.length; i++)
				{
					if (tab_method[i].getName().subSequence(0, 3).equals("get"))
						sql += "'" + tab_method[i].getName().subSequence(3, tab_method[i].getName().length()).toString() + "'='" + tab_method[i].invoke(obj) + "',";
				}
				sql = sql.substring(0, sql.length() - 1);
				Execute_query("Update", sql);
			}
			catch (Exception e)
			{
				
			}
		}
		
		// SELECT !!! executeQuery pas update
		public void Select_sql(Object obj)
		{
			try
			{	

			}
			catch (Exception e)
			{
						
			}
					
		}
		
		public void	Execute_query(String name_query, String query)
		{
			try
			{
				Statement myState		=	myConnect.createStatement();
				
				myState.executeUpdate(query);
				System.out.println(query + " done");
			} catch (Exception e)
			{
				
			}
		}
}