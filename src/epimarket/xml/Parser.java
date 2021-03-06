package epimarket.xml;

import java.io.File;
import java.util.*;

import epimarket.db.*;
import org.apache.commons.beanutils.BeanUtils;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Parser {

	public DBConfig 			dbConfig 	= new DBConfig();
	public XMLLigne 			dbLigne 	= new XMLLigne();
	public XMLColumn 			dbColumn 	= new XMLColumn();
	public ArrayList<XMLColumn> listColumn 	= new ArrayList<XMLColumn>();
	public ArrayList<XMLLigne> 	listLigne 	= new ArrayList<XMLLigne>();

	public Parser() {
		init();
		//aff();
	}

	public void init() {
		try {
			DocumentBuilderFactory builderFactory = DocumentBuilderFactory
					.newInstance();
			builderFactory.setNamespaceAware(true);
			builderFactory.setIgnoringElementContentWhitespace(true);

			DocumentBuilder builder = null;
			builder = builderFactory.newDocumentBuilder();
			Document xmlDoc = builder.parse(new File("doc/xml/config.xml"));
			ligne(xmlDoc.getDocumentElement());

			dbLigne.setColumns(listColumn);
			listLigne.add(dbLigne);
			dbConfig.setDBList(listLigne);

		} catch (Exception e) {
			System.out.println("reflectElement: " + e.toString());
			e.printStackTrace();
		}
	}
	
	public void ligne(Node node) {
		try {
			if (node instanceof Element && node.hasAttributes()) {

				NamedNodeMap attrs = node.getAttributes();
				for (int i = 0; i < attrs.getLength(); i++) {
					Attr attribute = (Attr) attrs.item(i);
					stock_data(attribute.getName(), attribute.getValue(),
							node.getLocalName());
				}
				if (node.getLocalName() == "Column") {
					{
						listColumn.add(dbColumn);
						dbColumn = new XMLColumn();
					}
				}
			}
			NodeList list = node.getChildNodes();
			if (list.getLength() > 0) {
				for (int i = 0; i < list.getLength(); i++)
					ligne(list.item(i));

			}
		} catch (Exception e) {
			System.out.println("reflectElement: " + e.toString());
			e.printStackTrace();
		}
	}

	// dans dbFactory
	public void stock_data(String name, String value, String ligne_name) {
		try {
			if (ligne_name == "Ligne") {
				if (listColumn.size() != 0)
					add();
				BeanUtils.setProperty(dbLigne, name, value);
			} else if (ligne_name == "Column") {
				BeanUtils.setProperty(dbColumn, name, value);
			}
		} catch (Exception e) {
			System.out.println("reflectElement: " + e.toString());
			e.printStackTrace();
		}
	}

	public void add() {
		dbLigne.setColumns(listColumn);
		listColumn = new ArrayList<XMLColumn>();
		listLigne.add(dbLigne);
		dbLigne = new XMLLigne();
	}

	public void aff() {
		if (dbConfig.getDBList() != null) {
			for (int j = 0; j != dbConfig.getDBList().size(); j++) {
				System.out.println("\n-Ligne--> class_name = "
						+ dbConfig.getDBList().get(j).getClass_name()
						+ "\t, db_name = "
						+ dbConfig.getDBList().get(j).getDb_name());
				for (int k = 0; k != dbConfig.getDBList().get(j).getColumns()
						.size(); k++)
					System.out.println("\t|\n\t=>Column= class_name = "
							+ dbConfig.getDBList().get(j).getColumns().get(k)
									.getclass_name()
							+ ", db_name = "
							+ dbConfig.getDBList().get(j).getColumns().get(k)
									.getdb_column()
							+ ", type = "
							+ dbConfig.getDBList().get(j).getColumns().get(k)
									.gettype());
			}
		}
	}

	public DBConfig getDbConfig() 				{return dbConfig;}
	public void setDbConfig(DBConfig dbConfig) 	{this.dbConfig = dbConfig;}
}
