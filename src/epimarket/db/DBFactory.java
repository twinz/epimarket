package epimarket.db;

import java.util.Vector;

import epimarket.db.*;
import epimarket.model.*;
import epimarket.xml.Parser;


public class DBFactory
{	
	public  Parser				parser;
	
	public DBFactory()
	{
		System.out.println("avant parser (factory)");
		this.parser	= new Parser();
		System.out.println("apres parser (factory)");
		
	}

	public Parser getParser() {
		return parser;
	}

	public void setParser(Parser parser) {
		this.parser = parser;
	}
	
	
}