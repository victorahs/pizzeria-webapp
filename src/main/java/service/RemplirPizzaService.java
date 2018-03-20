package service;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import dao.IPizzaDao;
import dao.PizzaDaoBase;
import dao.PizzaMemDao;
import exception.PizzaException;
import pizzeria.model.Pizza;

public class RemplirPizzaService extends MenuService {

	@Override
	public void executeUC(Scanner scanner, IPizzaDao dao) throws PizzaException {
		// TODO Auto-generated method stub

		PizzaMemDao memDao = new PizzaMemDao();
		List<Pizza> pizzas = memDao.findAllPizzas();
	

		PizzaDaoBase baseDao = new PizzaDaoBase();

		for (Pizza p : pizzas) {
			if(baseDao.findPizzaByCode(p.getCode()) == null){
				
				baseDao.saveNewPizza(p);
				System.out.println(p.getLibelle() + " a été ajouté");
				
			}
			
			
		}

	}

}
