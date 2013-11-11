package epimarket.model;

/** 
 * @author Dimitri Dean DARSEYNE (D3), 
 * Published by Short-Circuit under Creative Commons (CC) Licensing: 
 * Authorship/Paternity, NO Commercial Use, NO Derivative
 * Please check for more informations:
 * http://creativecommons.org/licenses/by-nc-nd/2.0/
 *
 * Auteur Dimitri Dean DARSEYNE (D3),
 * Publié par Short-Circuit sous license Creative Commons (CC):
 * Paternité, PAS d'Utilisation Commerciale, pas de Dérivés/Modifications
 * Pour plus d'informations, se rendre sur:
 * http://creativecommons.org/licenses/by-nc-nd/2.0/fr/ 
 * 
 * @since Short-Circuit 1999 
 */


public class Game extends AbstractProduct
{	
	//furthermore members (fields, methods) to be added...
	
	
	public Game() {}	
	
	/** Constructor overloading:  */
	public Game(String id, String designation, Category category, int price)
	{
		createStructure(id, designation, category, price);	
	}

	////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//Business logic: "behaviour" defined by the IBonusProducer business interface 
	////////////////////////////////////////////////////////////////////////////////////////////////////////////

	public int getBonusPoint()
	{
		return 20;	
	}

	
}