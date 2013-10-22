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
import fr.shortcircuit.model.Column;
import fr.shortcircuit.model.ProductElement;


public class MySaxReflecter<T extends Collection<ProductElement>> extends DefaultHandler implements IXMLViewConstants, IXMLFactory
{
	private Map<String, Collection<ProductElement>>		mapType, mapGenre;
	
	private T											collectionElt;

	private String 										fileName;

	private Object										currentObject;
	
	private Collection									currentCollection;

	private String 										STR_PACKAGE_PREFIX	= "fr.shortcircuit.model"; 
	

	
	public MySaxReflecter(T collectionElt, String fileName)
	{
		createStructures(collectionElt, fileName);

		createSaxParser();
		
		//mapContent();
		
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
		System.out.println("---> dans startElement/ namespace = " + namespaceURI + "|sName = " + sName + "|qName = " + qName + "| att = " + attrs.getValue(0));
		//Verification du type dans la classe Constants
		//{"ProductElement", "GameElement", "DvdElement", "K7Element", "actor"};
		if (LIST_AUTOMATION_SUPPORTED_CLASS.contains(qName))  
	  	{
			if (!qName.equalsIgnoreCase("column"))
			{
				System.out.println("--> dans autre");
				currentCollection = collectionElt;
			}
			else if (!(currentObject instanceof Column)) 
			{
				System.out.println("--> dans actor");
				currentCollection = ((ProductElement) currentObject).getColumn();
				System.out.println("--> apres actor");
			}
	  		//reflectElement(qName, attrs, currentCollection);
			reflectElement(attrs.getValue(0), attrs, currentCollection);
	  		System.out.println("--> apres");
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
			System.out.println("className = " + className);
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

		reflectMap("ProductElement", "price", collectionElt, mapType);
		reflectMap("ProductElement", "genre", collectionElt, mapGenre);
	}
	
	
	public Map reflectMap(String className, String publicKeyField, Collection collection2map, Map mapElt)
	{
		try
		{
			//Referencement du "Member" utilise: optimisation du cout de l'algo
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
			for (Column a : product.getColumn())
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
