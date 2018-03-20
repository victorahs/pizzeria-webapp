package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import pizzeria.model.CategoriePizza;
import pizzeria.model.Pizza;

public class PizzaDaoBase implements IPizzaDao {

	ConnectionBdd connectionBdd = null;

	public PizzaDaoBase() {
		// TODO Auto-generated constructor stub
		connectionBdd = new ConnectionBdd();

	}

	@Override
	public List<Pizza> findAllPizzas() {
		// TODO Auto-generated method stub
		
		List <Pizza >pizzas = new ArrayList<>();
		try {
			Connection connection = connectionBdd.connectionJdbc();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `pizzas`");
		
			ResultSet resultat = preparedStatement.executeQuery();
			while(resultat.next()){
				
				pizzas.add(new Pizza(resultat.getString("code"), resultat.getString("libelle"), resultat.getDouble("prix"),CategoriePizza.valueOf(resultat.getString("categorie"))));
			}
			preparedStatement.close();
			return pizzas;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public void saveNewPizza(Pizza pizza) {
		// TODO Auto-generated method stub

		try {
			Connection connection = connectionBdd.connectionJdbc();
			PreparedStatement preparedStatement = connection
					.prepareStatement("INSERT INTO `pizzas`(code,libelle,prix,categorie) VALUES(?,?,?,?)");
			String code = pizza.getCode();
			String libelle = pizza.getLibelle();
			Double prix = pizza.getPrix();
			String categoriePizza = pizza.getCategorie().toString();

			preparedStatement.setString(1, code);
			preparedStatement.setString(2, libelle);
			preparedStatement.setDouble(3, prix);
			preparedStatement.setString(4, categoriePizza);
			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void updatePizza(String codePizza, Pizza pizza) {
		// TODO Auto-generated method stub
		try {
			Connection connection = connectionBdd.connectionJdbc();
			PreparedStatement preparedStatement = connection.prepareStatement(
					"UPDATE `pizzas` SET code = ?, libelle = ?, prix = ?, categorie = ? WHERE code = ?");

			preparedStatement.setString(1, pizza.getCode());
			preparedStatement.setString(2, pizza.getLibelle());
			preparedStatement.setDouble(3, pizza.getPrix());
			preparedStatement.setString(4, pizza.getCategorie().toString());
			preparedStatement.setString(5, codePizza);
			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deletePizza(String codePizza) {
		// TODO Auto-generated method stub
		try {
			Connection connection = connectionBdd.connectionJdbc();
			PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM `pizzas` WHERE code = ?");
			preparedStatement.setString(1, codePizza);
			preparedStatement.executeUpdate();
			preparedStatement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		

	}

	@Override
	public Pizza findPizzaByCode(String codePizza) {
		// TODO Auto-generated method stub

		try {
			Connection connection = connectionBdd.connectionJdbc();
			PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM `pizzas` WHERE code = ?");
			preparedStatement.setString(1, codePizza);
			ResultSet result = preparedStatement.executeQuery();

			if (result.first()) {

				Pizza pizza = new Pizza(result.getString("code"), result.getString("libelle"), result.getDouble("prix"),
						CategoriePizza.valueOf(result.getString("categorie")));
				return pizza;
			}

			preparedStatement.close();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public boolean pizzaExists(String codePizza) {
		// TODO Auto-generated method stub
		return false;
	}

}
