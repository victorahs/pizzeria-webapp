package service;

import java.util.Scanner;

import dao.IPizzaDao;
import exception.DeletePizzaException;

/**Creation de la classe qui permet la suppression d'une pizza
 * @author ETY0005
 *
 */
public class SupprimerPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao dao) throws DeletePizzaException {
		// TODO Auto-generated method stub
		System.out.println("Veuillez saisir le code de la pizza à supprimer:");

		String codeSupr = scanner.next();

		if (dao.findPizzaByCode(codeSupr) == null) {

			throw new DeletePizzaException("La pizza avec le code " + codeSupr + " n'existe pas");

		} else {

			dao.deletePizza(codeSupr);

		}
	}

}
