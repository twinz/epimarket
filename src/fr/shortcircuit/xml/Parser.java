package fr.shortcircuit.xml;

import java.io.File;
import java.util.*;

import fr.shortcircuit.db.*;
import fr.shortcircuit.model.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.apache.commons.beanutils.BeanUtils;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import fr.shortcircuit.model.*;
import fr.shortcircuit.db.*;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.DocumentType;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;

public class Parser{

	public DBConfig 			dbConfig;
	public DBLigne 				dbLigne;
	public DBColumn 			dbColumn;
	public ArrayList<DBColumn> 	listColumn;
	public ArrayList<DBLigne> 	listLigne;

	boolean firstLigne = true;
	boolean firstColumn = true;

	public Parser() {
		init();
		//aff();
	}

	public void init() {
		try {
			dbConfig = new DBConfig();
			listColumn = new ArrayList<DBColumn>();
			listLigne = new ArrayList<DBLigne>();

			DocumentBuilderFactory builderFactory = DocumentBuilderFactory
					.newInstance();
			builderFactory.setNamespaceAware(true);
			builderFactory.setValidating(true);
			builderFactory.setIgnoringElementContentWhitespace(true);

			DocumentBuilder builder = null;
			builder = builderFactory.newDocumentBuilder();
			Document xmlDoc = builder.parse(new File("doc/xml/config.xml"));
			ligne(xmlDoc.getDocumentElement(), "");
		} catch (Exception e) {
			System.out.println("reflectElement: " + e.toString());
			e.printStackTrace();
		}
	}

	public void ligne(Node node, String indent) {
		try {
			if (node instanceof Element && node.hasAttributes()) {
				//System.out.println(indent + "Element Attributes are:");

				NamedNodeMap attrs = node.getAttributes();
				for (int i = 0; i < attrs.getLength(); i++) {
					Attr attribute = (Attr) attrs.item(i);
					//System.out.println(indent + attribute.getName() + " = " + attribute.getValue());
					stock_data(attribute.getName(), attribute.getValue(),
							node.getLocalName());
				}
				if (node.getLocalName() == "Ligne") {
					firstColumn = true;
					if (listColumn.size() > 0)
						dbLigne.setColumns(listColumn);
					listLigne.add(dbLigne);
					listColumn.clear();
				} else if (node.getLocalName() == "Column") {
					firstLigne = true;
					listColumn.add(dbColumn);
				}

				System.out.println("\n");
			}

			NodeList list = node.getChildNodes();
			if (list.getLength() > 0) {
				for (int i = 0; i < list.getLength(); i++)
					ligne(list.item(i), indent + "\t");
				dbConfig.setDBList(listLigne);
			}
		} catch (Exception e) {
			System.out.println("reflectElement: " + e.toString());
			e.printStackTrace();
		}
	}

	public void stock_data(String name, String value, String ligne_name) {
		try {
			if (ligne_name == "Ligne") {
				if (firstLigne == true)
					dbLigne = new DBLigne();
				BeanUtils.setProperty(this.dbLigne, name, value);
				firstLigne = false;
			} else if (ligne_name == "Column"){
				if (firstColumn == true)
					dbColumn = new DBColumn();
				BeanUtils.setProperty(this.dbColumn, name, value);
				firstColumn = false;
			}
		} catch (Exception e) {
			System.out.println("reflectElement: " + e.toString());
			e.printStackTrace();
		}
	}
	
	public void aff()
	{
		System.out.println("AFFICHAGE DES STRUCTURES");
			for (int j = 0; j != dbConfig.getDBList().size(); j++)
			{
				System.out.println("-Ligne--> class_name = " + dbConfig.getDBList().get(j).getClass_name() + "\t, db_name = " + dbConfig.getDBList().get(j).getDb_name());
				//System.out.println("att = " + dbConfig.getDBList().get(j).getColumns());
				//for (int k = 0; k != dbConfig.getDBList().get(j).getColumns().size(); k++)
					//System.out.println("\t-Column--> class_name = " + dbConfig.getDBList().get(j).getColumns().get(k).getclass_name() + ", db_name = " + dbConfig.getDBList().get(j).getColumns().get(k).getdb_column() + ", type = " + dbConfig.getDBList().get(j).getColumns().get(k).gettype());
			}
	}

	public DBConfig getDbConfig() {
		return dbConfig;
	}

	public void setDbConfig(DBConfig dbConfig) {
		this.dbConfig = dbConfig;
	}
	
	
	
}
