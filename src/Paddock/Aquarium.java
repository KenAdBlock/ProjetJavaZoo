package Paddock;

import Species.Animal;

/**
 * Aquarium est une classe représentant un enclos un peu particulier.
 * Il possède des caractéristiques supplémentaires à un enclos "classique" :
 *      La profondeur et l'indicateur de salinité.
 *
 * @author Charles-Henri CARLIER et Kenny COADALEN
 * @see Paddock
 */
public class Aquarium extends Paddock {

    /**
     * La profondeur de l'aquarium.
     */
    private int depth;

    /**
     * L'indicateur de salinité de l'eau.
     */
    private int salinityIndicator;

    /**
     * Le nombre total d'aquarium présents dans le zoo.
     */
    private static int nbAquarium;

    /**
     * Le constructeur de la classe Aquarium.
     * Il permet de créer de nouvelles instances de cette classe.
     *
     * @param name
     *          Le nom de l'aquarium.
     * @param surface
     *          La surface de l'aquarium.
     * @param maxNbAnimals
     *          Le nombre maximum d'animaux présents dans l'aquarium.
     * @param cleanliness
     *          La propreté de l'aquarium.
     * @param depth
     *          La profondeur de l'aquarium.
     * @param salinityIndicator
     *          La salinité de l'eau de l'aquarium.
     */
    public Aquarium(String name, int surface, int maxNbAnimals, String cleanliness, int depth, int salinityIndicator) {
        super(name, surface, maxNbAnimals, cleanliness);
        Paddock.setNbPaddock(Paddock.getNbPaddock() - 1);
        this.depth = depth;
        this.salinityIndicator = salinityIndicator;
        nbAquarium += 1;
    } // Constructor

    /**
     * Retourne le nombre total d'aquariums présents dans le zoo.
     *
     * @return Le nombre d'aquariums.
     */
    public static int getNbAquarium() {
        return nbAquarium;
    } // getNbAquarium()

    /**
     * Ajoute un animal à l'aquarium seulement si son type est "nageant".
     *
     * @param type
     *          L'animal à ajouter à l'aquarium.
     */
    public void add(Animal type){
        if(type.getTypeAnimal().equals("nageant")) {
            isGoodType = true;
            super.add(type);
            isGoodType = false;
        }
        else
            System.out.println("Vous ne pouvez ajouter " + type.getName()+ " à " + this.getName() + " car ce n'est pas un animal qui nage");
    } // add()

    /**
     * Permet de nettoyer l'aquarium.
     */
    public void keepUp(){
        super.keepUp();
        if(isKeepUp) {
            System.out.println("La salinité est bonne  et on a pas perdu de profondeur !!");
            isKeepUp = false;
        }
    } // keepUp()
} // class Aquarium
