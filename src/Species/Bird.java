package Species;

/**
 * Bird est une classe abstraite représentant un oiseau.
 * Cette classe a été créée notamment dans le but d'ajouter de la sémantique à l'application.
 *
 * @author Charles-Henri CARLIER et Kenny COADALEN
 * @see Species.Animal
 */
public abstract class Bird extends Animal{

    /**
     * Le constructeur de la classe Bird.
     * Il permet de "faire le pont" entre une classe effective (classe Wolf, Shark, Whale, etc.)
     *      et une classe abstraite (classe Animal).
     * Une instance d'un oiseau ne peut pas être possible telle quelle.
     *
     * @param name
     *          Le nom de l'oiseau.
     * @param sex
     *          Le sexe de l'oiseau.
     * @param weight
     *          Le poids de l'oiseau.
     * @param height
     *          La taille de l'oiseau.
     * @param age
     *          L'âge de l'oiseau.
     */
    protected Bird(String name, boolean sex, long weight, int height, int age) {
        super(name, sex, weight, height, age);
    } // Constructor
} // class Bird
