package service;

import java.util.Scanner;

import dao.IPizzaDao;
import exception.DeletePizzaException;
import exception.UpdatePizzaException;
import pizzeria.model.CategoriePizza;
import pizzeria.model.Pizza;

/**Cr�ation de la classe  qui permet de modifier la pizza
 * @author ETY0005
 *
 */
public class ModifierPizzaService extends MenuService {



	@Override
	public void executeUC(Scanner scanner, IPizzaDao dao) throws UpdatePizzaException  {
		// TODO Auto-generated method stub
		System.out.println("Veuillez saisir le code de la pizza �  modifier:");
		
		String codeModif = scanner.next();
		
		if (dao.findPizzaByCode(codeModif) == null) {

			throw new UpdatePizzaException("La pizza avec le code "  + codeModif + " n'existe pas");

		} else{
		
			

				System.out.println("Veuillez saisir le nouveau code:");
				String codeM = scanner.next();
				

				System.out.println("Veuillez saisir le nouveau nom (sans espace):");
				String libM = scanner.next();
				

				System.out.println("Veuillez saisir le prix:");
				double prixM = scanner.nextDouble();
				
				System.out.println("Veuillez saisir la cat�gorie de pizza : Viande, Sans viande, Poisson");
				String catM = scanner.next();
				if(CategoriePizza.findByLibelle(catM) == null){
					
					throw new UpdatePizzaException("La categorie s�lectionn� n'existe pas");
					
				}
				CategoriePizza categorie = CategoriePizza.findByLibelle(catM);
				
				dao.updatePizza(codeModif, new Pizza(codeM, libM, prixM, categorie));
		}
	}

}
