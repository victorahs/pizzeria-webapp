package dao;

import java.util.List;

import pizzeria.model.Pizza;

public interface IPizzaDao {

	List<Pizza> findAllPizzas();

	/**
	 * Sauvegarde une nouvelle pizza
	 * 
	 * @param pizza
	 *            pizza qu'on veut ajouter
	 */
	void saveNewPizza(Pizza pizza);

	/**
	 * Mets à jours une pizza
	 * 
	 * @param codePizza
	 *            code de la pizza à mettre à mettre à jours
	 * @param pizza
	 *            modfication de la pizza
	 */
	void updatePizza(String codePizza, Pizza pizza);

	/**
	 * Supprime une pizza
	 * 
	 * @param codePizza
	 *            code de la pizza à supprimer
	 */
	void deletePizza(String codePizza);

	/**
	 * Trouve la pizza en fonction de son code
	 * 
	 * @param codePizza
	 *            code de la pizza qu'on cherche
	 * @return
	 */
	Pizza findPizzaByCode(String codePizza);

	/**
	 * @param codePizza
	 *            code de la pizza qu'on recherche
	 * @return true si la pizza existe false si elle n'exite pas
	 */
	boolean pizzaExists(String codePizza);
}
