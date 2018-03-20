package pizzeria.model;

/**
 * Represente une catégorie de pizzas
 * 
 * @author ETY0005
 *
 *
 */
public enum CategoriePizza {
	/** Catégorie de pizza avec viande */
	VIANDE("Viande"),
	/** Catégorie de pizza avec poisson */
	POISSON("Poisson"),
	/** Catégorie de pizza sans viande */
	SANS_VIANDE("Sans Viande");

	/**
	 * value : String
	 * 
	 */
	private String value;

	/**
	 * Constructeur
	 * 
	 * @param value
	 */
	private CategoriePizza(String value) {

		this.value = value;
	}

	public String getValue() {

		return value;
	}

	/**
	 * Return une categorie de pizza en fonction de sont libelle
	 * 
	 * @param libelle
	 * @return {@link CategoriePizza}
	 */
	public static CategoriePizza findByLibelle(String libelle) {
		for (CategoriePizza categorie : values()) {
			if (categorie.getValue().equals(libelle)) {
				return categorie;
			}
		}
		return null;
	}

}
