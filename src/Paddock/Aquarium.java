package Paddock;

import Species.Animal;

/**
 * Created by Darkweizer on 12/11/2015.
 */
public class Aquarium extends Paddock {

    private int depth;
    private int salinityIndicator;
    private static int nbAquarium;

    public Aquarium(String name, int surface, int maxNbAnimals, String cleanliness, int depth, int salinityIndicator) {
        super(name, surface, maxNbAnimals, cleanliness);
        Paddock.setNbPaddock(Paddock.getNbPaddock() - 1);
        this.depth = depth;
        this.salinityIndicator = salinityIndicator;
        nbAquarium += 1;
    }

    public static int getNbAquarium() {
        return nbAquarium;
    }

    public void add(Animal type){
        if(type.getTypeAnimal().equals("nageant")) {
            isGoodType = true;
            super.add(type);
            isGoodType = false;
        }
        else
            System.out.println("Vous ne pouvez ajouter " + type.getName()+ " à " + this.getName() + " car ce n'est pas un animal qui nage");
    }

    public void keepUp(){
        super.keepUp();
        if(isKeepUp) {
            System.out.println("La salinité est bonne  et on a pas perdu de profondeur !!");
            isKeepUp = false;
        }
    }
}
