package Species;

/**
 * Mammal est une classe abstraite représentant un mammifère.
 * Cette classe a été créée notamment dans le but d'ajouter de la sémantique à l'application.
 *
 * @author Charles-Henri CARLIER et Kenny COADALEN
 * @see Species.Animal
 */
public abstract class Mammal extends Animal {

    /**
     * Le constructeur de la classe Mammal.
     * Il permet de "faire le pont" entre une classe effective (classe Wolf, Shark, Whale, etc.)
     *      et une classe abstraite (classe Animal).
     * Une instance d'un mammifère ne peut pas être possible telle quelle.
     *
     * @param name
     *          Le nom du mammifère.
     * @param sex
     *          Le sexe du mammifère.
     * @param weight
     *          Le poids du mammifère.
     * @param height
     *          La taille du mammifère.
     * @param age
     *          L'âge du mammifère.
     */
    protected Mammal(String name, boolean sex, long weight, int height, int age) {
        super(name, sex, weight, height, age);
    } // Constructor
} // class Mammal
