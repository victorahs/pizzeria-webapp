package service;

import java.util.Scanner;

import dao.IPizzaDao;
import exception.PizzaException;

/**Cr�ation de la class abstraite Menu
 * @author ETY0005
 *
 */
public abstract class MenuService {
	
	public abstract void executeUC(Scanner scanner, IPizzaDao dao) throws PizzaException;
		
		
		
	
	

} 
