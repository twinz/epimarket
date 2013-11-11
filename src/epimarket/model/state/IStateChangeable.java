package epimarket.model.state;

import epimarket.model.validation.IValidable;


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

/**
 * A very simple interface to define the abstraction of a state changing process
 * 
 * Please Note: this interface extends the IValidable instance
 * 
 * @author Dim
 */
public interface IStateChangeable extends IValidable
{
	public EOrderState getState();

	public void setState(EOrderState orderState);
	
}
