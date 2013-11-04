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
		this.parser	= new Parser();
	}

	public Parser getParser() {
		return parser;
	}

	public void setParser(Parser parser) {
		this.parser = parser;
	}
	
	
}