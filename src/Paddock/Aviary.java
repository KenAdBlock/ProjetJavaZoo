package Paddock;

import Species.Animal;

/**
 * Aviary est une classe représentant un enclos un peu particulier.
 * Il possède une caractéristique supplémentaire à un enclos "classique" qui est la hauteur.
 *
 * @author Charles-Henri CARLIER et Kenny COADALEN
 * @see Paddock
 */
public class Aviary extends Paddock {

    /**
     * La hauteur de la volière.
     */
    private int height;

    /**
     * Le nombre total de volières présentes dans le zoo.
     */
    private static int nbAviary;

    /**
     * Le constructeur de la classe Aviary.
     * Il permet de créer de nouvelles instances de cette classe.
     *
     * @param name
     *          Le nom de la volière.
     * @param surface
     *          La surface de la volière.
     * @param maxNbAnimals
     *          Le nombre maximum d'animaux présents dans la volière.
     * @param cleanliness
     *          La propreté de la volière.
     * @param height
     *          La vhauteur de la volière.
     */
    public Aviary(String name, int surface, int maxNbAnimals, String cleanliness, int height) {
        super(name, surface, maxNbAnimals, cleanliness);
        Paddock.setNbPaddock(Paddock.getNbPaddock() - 1);
        this.height = height;
        nbAviary += 1;
    } // Constructor

    /**
     * Retourne le nombre total de volières présentes dans le zoo.
     *
     * @return Le nombre de volières.
     */
    public static int getNbAviary() {
        return nbAviary;
    } // getNbAviary()

    /**
     * Ajoute un animal à la volière seulement si son type est "volant".
     *
     * @param type
     *          L'animal à ajouter à la volière.
     */
    public void add(Animal type){
        if(type.getTypeAnimal().equals("volant")) {
            isGoodType = true;
            super.add(type);
            isGoodType = false;
        }
        else
            System.out.println("Vous ne pouvez ajouter " + type.getName()+ " à " + this.getName() + " car ce n'est pas un animal volant");
    } // add()

    /**
     * Permet de nettoyer la volière.
     */
    public void keepUp(){
        super.keepUp();
        if(isKeepUp) {
            System.out.println("Le toit a aussi été entretenu !");
            isKeepUp = false;
        }
    } // keep()
} // class Aviary
