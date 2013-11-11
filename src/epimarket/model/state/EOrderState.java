package epimarket.model.state;

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

public enum EOrderState
{
	//Declaration is inversed to allow inner referencing
	TRANSACTION_ENDED(	"Transaction ended", 	null),
	TRANSACTION_STARTED("Transaction started", 	TRANSACTION_ENDED),
	TRANSACTION_NULL(	"Transaction null", 	TRANSACTION_STARTED);
	
	/** Following step */
	private EOrderState 		nextStepState;
	
	/** State */
	private String 			state;
	
	
	
	private EOrderState(String state, EOrderState nextStepState)
	{
		this.state 			= state;
		this.nextStepState	= nextStepState;
	}

	public String getState()					{return state;}

	public EOrderState getNextStepState()		{return nextStepState;}
	
}
