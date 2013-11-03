package fr.shortcircuit.db;

import java.util.Vector;

import fr.shortcircuit.db.*;
import fr.shortcircuit.xml.Parser;
import fr.shortcircuit.model.*;


public class DBFactory
{	
	public  Parser				parser;
	
	public DBFactory()
	{
		this.parser	= new Parser();
		
	}
}