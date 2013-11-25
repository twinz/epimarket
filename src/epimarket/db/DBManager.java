package epimarket.db;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Method;
import java.util.HashMap;

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

		public DBManager(DBConfig dbConfig)
		{
			try
			{
				this.strDriver 			=	"com.mysql.jdbc.Driver";
				this.strConnectURL		=	"jdbc:mysql://localhost:3306/epimarket";
				this.strUser 			=	"root";
				this.strPass 			=	"root";
				this.dbConfig			=	dbConfig;
			}	
			catch (Exception e) 		{System.out.println("dbConnect Exception: " + e.toString()); 	e.printStackTrace();}		
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
				myConnect.close();
			}
			catch (SQLException e)				{System.out.println("Deconnexion au DBManager: Erreur interne SQL: " + e.toString());}
		}
		
		// INSERT
		public void create(Object obj)
		{
			try
			{
				if (objectId(obj) == 0)
				{
				Method[] 	tab_method 	=	obj.getClass().getMethods();
				String		sql			=	"";
				String		key			=	"";
				String		value		=	"";
				
				for (int i = 0; i < tab_method.length; i++)
				{
					if (tab_method[i].getName().subSequence(0, 3).equals("get") && !(tab_method[i].getName().equals("getClass")))
					{
						key 	+= checkStruckDbAttribute(tab_method[i].getName().subSequence(3, tab_method[i].getName().length()).toString()) + ",";
						if (tab_method[i].getName().equals("getId"))
							value	+= tab_method[i].invoke(obj) + ",";
						else
							value	+= "\"" + tab_method[i].invoke(obj) + "\",";
					}
				}
				key = key.substring(0, key.length() - 1);
				value = value.substring(0, value.length() - 1);
				sql = "INSERT INTO epimarket." + checkStruckDb(obj.getClass().getSimpleName()) + " (" + key + ") VALUES (" + value + ");";
				Execute_query("Insert", sql);
				}
			}
			catch (Exception e) 		{System.out.println("Connexion au DBManager : Operation non valide: " + e.toString()); 	e.printStackTrace();}		
		}
		
		public void delete(Object obj)
		{
			try
			{
				Method[] 	tab_method 	=	obj.getClass().getMethods();
				String		sql			=	"DELETE FROM epimarket." + checkStruckDb(obj.getClass().getSimpleName()) + " WHERE Id = " + objectId(obj) + ";";
				
				Execute_query("Delete", sql);
			}
			catch (Exception e) 		{System.out.println("Connexion au DBManager : Operation non valide: " + e.toString()); 	e.printStackTrace();}
		}
		
		public void update(Object obj)
		{
			try
			{
				delete(obj);
				create(obj);
			}
			catch (Exception e) 		{System.out.println("Connexion au DBManager : Operation non valide: " + e.toString()); 	e.printStackTrace();}
		}
		
		public ArrayList read(Object obj)
		{
			ArrayList<HashMap> list = new ArrayList<HashMap>();
			try
			{
				String sql = "SELECT * FROM " + checkStruckDb(obj.toString()) ;

				    myState				=	myConnect.createStatement();
				    myPreparedStatement	=	myConnect.prepareStatement(sql);
					myResultSet 		= 	myPreparedStatement.executeQuery();
					
				    while (myResultSet.next()) {
				    	myResultSetMetaData = myResultSet.getMetaData();
				    	HashMap mMap = new HashMap();
					for (int i = 0; i != myResultSetMetaData.getColumnCount(); i++)
					{
						
						String columnType = myResultSetMetaData.getColumnTypeName(i + 1);
						
					       if (columnType == "INT") {
							
					         String columnName = myResultSetMetaData.getColumnName(i + 1) ;
					          int value = myResultSet.getInt(i + 1) ;
					          mMap.put(columnName, value);
							
					      }  else  if (columnType == "VARCHAR") {
							
					         String columnName = myResultSetMetaData.getColumnName(i + 1) ;
					         String value = myResultSet.getString(i + 1) ;		
					         mMap.put(columnName, value);
					      } 
					}
					list.add(mMap);
				    }
				    list = fillList(list);
			}     
            catch (Exception e)                 	{System.out.println("Connexion au DBManager : Operation non valide: " + e.toString());         	e.printStackTrace();}
			return list;
		}

		public HashMap simpleRead(String sql)
		{
			HashMap mMap = new HashMap();
			try
			{
				    myState				=	myConnect.createStatement();
				    myPreparedStatement	=	myConnect.prepareStatement(sql);
					myResultSet 		= 	myPreparedStatement.executeQuery();
					
				    while (myResultSet.next()) {
				    	myResultSetMetaData = myResultSet.getMetaData();
				    	
					for (int i = 0; i != myResultSetMetaData.getColumnCount(); i++)
					{
						
						String columnType = myResultSetMetaData.getColumnTypeName(i + 1);
						
					       if (columnType == "INT") {
							
					         String columnName = myResultSetMetaData.getColumnName(i + 1) ;
					          int value = myResultSet.getInt(i + 1) ;
					          mMap.put(columnName, value);
							
					      }  else  if (columnType == "VARCHAR") {
							
					         String columnName = myResultSetMetaData.getColumnName(i + 1) ;
					         String value = myResultSet.getString(i + 1) ;		
					         mMap.put(columnName, value);
					      } 
					}
				    }
			}        
            catch (Exception e)                 	{System.out.println("Connexion au DBManager : Operation non valide: " + e.toString());         	e.printStackTrace();}
			return mMap;
		}
		
		public ArrayList<HashMap> fillList(ArrayList<HashMap> list)
		{
			try{	
				for (int i = 0; i != list.size(); i++)
				{
					HashMap map = (HashMap) list.get(i);
					map = fill(map);
				}	
		}
		catch (Exception e)                 	{System.out.println("Connexion au DBManager : Operation non valide: " + e.toString());         	e.printStackTrace();}
		return list;
		}
		
		public HashMap fill (HashMap map)
		{
			for(int j = 0; j != map.keySet().size(); j++)
			{
				
				String key = map.keySet().toArray()[j].toString();
				Object value = map.values().toArray()[j];

				if (key.substring(key.length() - 2).equals("ID"))
				{
					String sql = "SELECT * FROM " + key.substring(0, key.length() - 2) + " WHERE Id = " + value + ";";
					HashMap mMap = simpleRead(sql);
					
					map.put(key.substring(0, key.length() - 2).toLowerCase(), mMap);
					map.remove(key);
					
				}		
			}
			for (int i = 0; i != map.size(); i++)
			{
				if (map.values().toArray()[i].getClass().getSimpleName().equals("HashMap"))
				{
				HashMap newMap = (HashMap) map.values().toArray()[i];
				fill(newMap);
				}
			}
			return map;
		}
		
		public ArrayList<HashMap> fillListEavy(ArrayList<HashMap> list)
		{
			ArrayList<HashMap> sauv = list;
			try{
					for (int i = 0; i != list.size(); i++)
					{
							for (int j = 0; j != list.get(i).size(); j++)
							{
								if (list.get(i).values().toArray()[j].getClass().getSimpleName().equals("HashMap"))
								{
									HashMap line = (HashMap) list.get(i).values().toArray()[j];
									for (int k = 0; k != line.size(); k++)
									{
										String key = (String) line.keySet().toArray()[k];
										Object value = line.values().toArray()[k];
										if (key.substring(key.length() - 2).equals("ID"))
										{
											String sql = "SELECT * FROM " + key.substring(0, key.length() - 2) + " WHERE Id = " + value + ";";
											HashMap mMap = simpleRead(sql);	
											HashMap finalMap = mMap;
											for (int l = 0; l != mMap.size(); l++)
											{
												if (mMap.values().toArray()[l].equals("null"))
													finalMap = null;
											}
											line.put(key.substring(0, key.length() - 2).toLowerCase(), finalMap);
											line.remove(key);
										}
									}
								}
							}
							
						}
						System.out.println("\n");
			}
			catch (Exception e)                 	{System.out.println("Connexion au DBManager : Operation non valide: " + e.toString());         	e.printStackTrace();}
			return list;
		}
		
		public String	checkStruckDb(String name)
		{
			String res = "";
			ArrayList<String> products = dbConfig.getProducts();
			
			if (products.contains(name)){
				res = "ABSTRACTPRODUCT";
				return res;
			}
			else{
			for (int j = 0; j != dbConfig.getDBList().size(); j++)
			{
				if (dbConfig.getDBList().get(j).getClass_name().equalsIgnoreCase(name))
				{
					res =  dbConfig.getDBList().get(j).getDb_name();
					return res;
				}
			}	
			}
			return res;
		}
		
		public String	checkStruckDbAttribute(String name)
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

		public int objectId(Object obj)
		{
			int 	res 	= 	0;
			String	query	=	"";
			
			try
			{
				Method[] 	tab_method 	=	obj.getClass().getMethods();
				String		key			=	"";
				
				for (int i = 0; i < tab_method.length; i++)
				{
					
					if (tab_method[i].getName().subSequence(0, 3).equals("get") && !(tab_method[i].getName().equals("getClass")) && !(tab_method[i].getName().equals("getId")))
					{
						
						key 	+= checkStruckDbAttribute(tab_method[i].getName().subSequence(3, tab_method[i].getName().length()).toString()) + "=";
						key	+= "\"" + tab_method[i].invoke(obj) + "\" AND ";
					}
				}
				key = key.substring(0, key.length() - 4);
				query = "SELECT id FROM " + checkStruckDb(obj.getClass().getSimpleName()) + " WHERE " + key + ";";
				
				myState				=	myConnect.createStatement();
				myPreparedStatement = 	myConnect.prepareStatement(query);
				myResultSet = myPreparedStatement.executeQuery(query);
				myResultSetMetaData = myResultSet.getMetaData();
				
				while (myResultSet.next()) {
				res = myResultSet.getInt(1);}
			}
			catch (SQLException e)                 	{System.out.println("Connexion au DBManager : Erreur interne SQL: " + e.toString()); 			e.printStackTrace();}        
            catch (Exception e)                 	{System.out.println("Connexion au DBManager : Operation non valide: " + e.toString());         	e.printStackTrace();}
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