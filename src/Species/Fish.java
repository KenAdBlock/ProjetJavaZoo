package Species;

/**
 * Fish est une classe abstraite représentant un poisson.
 * Cette classe a été créée notamment dans le but d'ajouter de la sémantique à l'application.
 *
 * @author Charles-Henri CARLIER et Kenny COADALEN
 * @see Species.Animal
 */
public abstract class Fish extends Animal{

    /**
     * Le constructeur de la classe Fish.
     * Il permet de "faire le pont" entre une classe effective (classe Wolf, Shark, Whale, etc.)
     *      et une classe abstraite (classe Animal).
     * Une instance d'un poisson ne peut pas être possible telle quelle.
     *
     * @param name
     *          Le nom du poisson.
     * @param sex
     *          Le sexe du poisson.
     * @param weight
     *          Le poids du poisson.
     * @param height
     *          La taille du poisson.
     * @param age
     *          L'âge du poisson.
     */
    protected Fish(String name, boolean sex, long weight, int height, int age) {
        super(name, sex, weight, height, age);
    } // Constructor
} // class Fish
