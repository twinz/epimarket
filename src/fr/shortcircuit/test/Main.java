package fr.shortcircuit.test;

import java.util.Vector;
import fr.shortcircuit.model.*;
import fr.shortcircuit.xml.MySaxReflecter;

public class Main 
{
	public MySaxReflecter			saxReflectedParser;


	
	public static void main(String args[])
	{		
		Main newAppli			= new Main();		
	}
	
	public Main()
	{		
		createStructures();
	}	
	
	public void createStructures()
	{	
		this.saxReflectedParser	= new MySaxReflecter<Vector<ProductElement>>(new Vector<ProductElement>(), "doc/xml/config.xml");
	}

}
