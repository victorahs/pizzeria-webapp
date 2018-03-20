package dao;

import java.util.ArrayList;
import java.util.List;

import pizzeria.model.CategoriePizza;
import pizzeria.model.Pizza;

/**Implementation de IPizzaDao qui CRUD une liste de pizzas
 * @author ETY0005
 *
 */
public class PizzaMemDao implements IPizzaDao {

	List<Pizza> pizzas;


	/**Insertion de pizza dans la liste pizzas
	 * 
	 */
	public PizzaMemDao() {
		
		pizzas = new ArrayList<>();

		pizzas.add(new Pizza(0, "PEP", "Pépéroni", 12.50, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(1, "MAR", "Margherita", 14.00, CategoriePizza.POISSON));
		pizzas.add(new Pizza(2, "REIN", "La Reine", 11.50, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza(3, "FRO", "La 4 fromages", 12.00, CategoriePizza.POISSON));
		pizzas.add(new Pizza(4, "CAN", "La Cannibale", 12.50, CategoriePizza.SANS_VIANDE));
		pizzas.add(new Pizza(5, "SAV", "La savoyarde", 13.00, CategoriePizza.VIANDE));
		pizzas.add(new Pizza(6, "ORI", "L'orientale", 13.50,  CategoriePizza.POISSON));
		pizzas.add(new Pizza(7, "IND", "L'indienne", 14.00,  CategoriePizza.POISSON));

	}

	@Override

	public List<Pizza> findAllPizzas() {

		return pizzas;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {

		pizzas.add(pizza);

	}


	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		int index = findIndexPizzaByCode(codePizza);
		if (index!=-1){
			pizzas.set(index, pizza);
		}

	}

	@Override
	public void deletePizza(String codePizza) {

		pizzas.remove(findPizzaByCode(codePizza));

	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {

		for (Pizza p : pizzas) {

			if (p.getCode().equals(codePizza)) {

				return p;
			}

		}
		return null;
	}
	
	/**
	 * @param codePizza code de la pizza pour laquel on cherche l'index
	 * @return index de la pizza correspondante
	 */
	public int findIndexPizzaByCode(String codePizza) {

		for (int i=0; i<pizzas.size(); i++) {
			Pizza p = pizzas.get(i);
			if (p.getCode().equals(codePizza)) {

				return i;
			}

		}
		return -1;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		
		for (Pizza p : pizzas) {

			if (p.getCode().equals(codePizza)) {

				return true;
			}
		}
		return false;

}
}
