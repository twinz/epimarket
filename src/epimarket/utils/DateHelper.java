package epimarket.utils;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

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

public class DateHelper
{
    public static DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");


    public static Date getDate(String strDate)
    {
        try	{return (Date) formatter.parse(strDate);}
        catch (Exception e) {System.out.println("DateHelper: getDate: " + e.toString()); return null;}
    }

    public static String getStringDate(Date date)
    {
        try	{return formatter.format(date);}
        catch (Exception e) {System.out.println("DateHelper: getStringDate: " + e.toString()); return "";}
    }
    
}
