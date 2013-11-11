package epimarket.model.state;

import epimarket.model.validation.ValidationException;

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

public class OrderStateMachine
{
	/**
	 * The current method forwards the potential ValidationException declared by the IValidable.validate() method
	 * 
	 * @param statedReference
	 * @throws ValidationException
	 */
	public static void changeStep(IStateChangeable statedReference) throws ValidationException
	{
		//can call the IValidable interface validate() method, because IValidable extends IStateChangeable
		//any IStateChangeable reference is also a IValidable instance.
		statedReference.validate();
		
		statedReference.setState(statedReference.getState().getNextStepState());
	}

}
