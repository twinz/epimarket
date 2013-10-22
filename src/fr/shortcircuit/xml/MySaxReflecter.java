package fr.shortcircuit.xml;

import java.io.File;
import java.lang.reflect.Field;
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

import fr.shortcircuit.gui.IXMLViewConstants;
import fr.shortcircuit.model.DBColumn;
import fr.shortcircuit.model.ProductElement;
import fr.shortcircuit.db.*;


public class MySaxReflecter<T extends Collection<ProductElement>> extends DefaultHandler implements IXMLViewConstants, IXMLFactory
{
	private Map<String, Collection<ProductElement>>		mapType, mapGenre;
	private T											collectionElt;
	private String 										fileName;
	private Object										currentObject;
	private Collection									currentCollection;
	private String 										STR_PACKAGE_PREFIX	= "fr.shortcircuit.model"; 
	
	public	DBConfig									dbConfig;
	
	public MySaxReflecter(T collectionElt, String fileName)
	{
		createStructures(collectionElt, fileName);
		createSaxParser();
		mapContent();
		setParents();
	}
	
	public void createStructures(T collectionElt, String fileName)
	{
		this.fileName					= fileName;  			
		this.collectionElt				= collectionElt;
		
		System.out.println("MySaxReflecter: starts parsing " + fileName);	
	}

	//currentCollection				= collectionElt;

	/** Instanciation du parser Sax affecte. */ 	
	public void createSaxParser()
	{		
	  	SAXParserFactory factory 		= SAXParserFactory.newInstance();
	
	   	try 
	   	{
	    	SAXParser saxParser 		= factory.newSAXParser();
	
	    	saxParser.parse(new File(fileName), this); 
	    	
		}
		catch (Throwable t) 	{System.out.println("createSaxParser: " + t.toString()); t.printStackTrace();}
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//SAX parsing methods
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public void startElement(String namespaceURI, String sName, String qName, Attributes attrs) throws SAXException
	{
		this.dbConfig = new DBConfig();
		
		if (LIST_AUTOMATION_SUPPORTED_CLASS.contains(qName))  
	  	{
			if (qName.equals("object"))// creer une LigneList
			{
				this.dbConfig.dbList = new DBList();
			}
			
			else if (qName.equals("column"))//creer une columnList
			{
				
			}
			reflectElement(qName, attrs, currentCollection);
	  	}
	}

	public void endElement(String namespaceURI, String sName, String qName) throws SAXException   	{}	
	public void characters(char buf[], int offset, int len) throws SAXException						{}
	public void startDocument() throws SAXException													{}	
	public void endDocument() throws SAXException													{System.out.println("endDocument: " + collectionElt.size() + " elt(s)");}

	///////////////////////////////////////////////////////
	//Sub-parsing methods : create, chain, and feed objects 
	///////////////////////////////////////////////////////
	
	public void reflectElement(String className, Attributes attrs, Collection collectionStorer)
	{
		try
		{
			Class associatedClass								= Class.forName(STR_PACKAGE_PREFIX + "." + className);
			Object newInstance									= associatedClass.newInstance();
			currentObject										= newInstance;
			
			for (int i = 0; i != attrs.getLength(); i++)
			{
				BeanUtils.setProperty(newInstance, attrs.getQName(i), attrs.getValue(i));
				System.out.println("Name = " + attrs.getQName(i) + ", Value = " + attrs.getValue(i));
			}
			collectionStorer.add(newInstance);
			System.out.println("<--> collection = " + collectionStorer);
			System.out.println("\n");
		}
		catch (Exception e) {System.out.println("reflectElement: " + e.toString()); e.printStackTrace();}
	}


	public void mapContent()
	{
		mapType													= new HashMap();
		mapGenre												= new TreeMap();

		//reflectMap("ProductElement", "price", collectionElt, mapType);
		mapGenre = reflectMap("ProductElement", "class_name", collectionElt, mapGenre);
	}
	
	
	public Map reflectMap(String className, String publicKeyField, Collection collection2map, Map mapElt)
	{
		try
		{
			Field eltField									= Class.forName(STR_PACKAGE_PREFIX + "." + className).getField(publicKeyField);
			Iterator iteratorElt							= collection2map.iterator();
		
			while (iteratorElt.hasNext())
			{
				try
				{
					Object elt								= iteratorElt.next();		
					Object memberValue						= eltField.get(elt);
					
					if (memberValue != null)
					{
						Collection collectionEntry				= (Collection) mapElt.get(memberValue.toString());	
						
						if (collectionEntry == null)
						{
							//collectionEntry					= new Vector(); //pas de tri sur les entrees
							collectionEntry						= new TreeSet(); //trie et ordonne, ProductElement isAssignableFrom(Comparable) !
							collectionEntry.add(elt);	
							mapElt.put(eltField.get(elt).toString(), collectionEntry);
						}
						else
							collectionEntry.add(elt);
					}
				}
				catch (Exception e) {System.out.println(e.toString());/*e.printStackTrace();*/}		
			}	
		}
		catch (Exception e) {System.out.println(e.toString());e.printStackTrace();}

		return mapElt;			
	}
	 
	public void setParents()
	{
		for (ProductElement product : collectionElt)
			for (DBColumn a : product.getColumn())
				a.setParent(product);
	}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//IXMLFactory methods
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Map getMapEntry() 									{return null;}
	public Collection getCollectionElt() 						{return collectionElt;}
	public StringBuffer getFileContent() 						{return null;}

	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Getters
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public Map getMapType() 									{return mapType;}
	public Map getMapGenre() 									{return mapGenre;} 

	
}
