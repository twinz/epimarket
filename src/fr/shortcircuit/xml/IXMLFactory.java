package fr.shortcircuit.xml;

import java.util.Collection;
import java.util.Map;

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

/** XML Factory design */
public interface IXMLFactory 
{
	/** provides a 1 dimension collection (Vector, List, Set) of the produced object population.
	 * Check Sorting/Indexing option in concrete implementation. */
	public Collection<IXMLObject> 		getCollectionElt();
}
