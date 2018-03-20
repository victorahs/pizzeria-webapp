package pizzeria.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author ETY0005
 * Cr�ation de la class Pizza
 *
 */
@Entity
@Table(name = "pizza")

public class Pizza {
	/** id : int
	 * 
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	/** code : String
	 * 
	 */
	@Column(name = "CODE")
	String code;
	/** libelle : String
	 * 
	 */
	@Column(name = "LIBELLE")
	String libelle;
	/** prix : double
	 * 
	 */
	@Column(name = "PRIX")
	double prix;
	/** categorie : CategoriePizza
	 * 
	 */
	@Column(name = "CATEGORIE")
	@Enumerated(EnumType.STRING)
	CategoriePizza categorie;
	
	/** compteur : int
	 * 
	 */
	private static int compteur = 0;
	
	/**Constructer
	 * 
	 * @param code code le la pizza
	 * @param libelle libelle de la pizza
	 * @param prix prix de la pizza
	 * @param categorie categorie de la pizza
	 */
	public Pizza(){
		
	}

	public Pizza(String code, String libelle, double prix, CategoriePizza categorie  ){
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
		
	}
	
	/**Constructer
	 * @param id id de la pizza
	 * @param code code de la pizza
	 * @param libelle de la pizza
	 * @param prix prix de la pizza
	 * @param categorie categorie de la pizza
	 */
	public Pizza(int id, String code, String libelle, double prix, CategoriePizza categorie  ){

		this.id = id;
		this.code = code;
		this.libelle = libelle;
		this.prix = prix;
		this.categorie = categorie;
		
	}
	
	
	
	public String toString(){
		
		return this.getCode() + "->" + this.getLibelle() + "(" + this.getPrix() + "\u20ac" + ") cat�gorie de la pizza est : " + this.categorie.getValue();
	}

	/** Getter
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**Setter
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}

	/** Getter
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**Setter
	 * @param code the code to set
	 */
	public void setCode(String code) {
		this.code = code;
	}

	/** Getter
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	/**Setter
	 * @param libelle the libelle to set
	 */
	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	/** Getter
	 * @return the prix
	 */
	public double getPrix() {
		return prix;
	}

	/**Setter
	 * @param prix the prix to set
	 */
	public void setPrix(double prix) {
		this.prix = prix;
	}

	/** Getter
	 * @return the categorie
	 */
	public CategoriePizza getCategorie() {
		return categorie;
	}

	/**Setter
	 * @param categorie the categorie to set
	 */
	public void setCategorie(CategoriePizza categorie) {
		this.categorie = categorie;
	}

	
	

}
