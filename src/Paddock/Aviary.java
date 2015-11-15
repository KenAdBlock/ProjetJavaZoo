package Paddock;

import Species.Animal;

/**
 * Created by Darkweizer on 12/11/2015.
 */
public class Aviary extends Paddock {

    private int height;

    public Aviary(String name, int surface, int maxNbAnimals, String cleanliness, int height) {
        super(name, surface, maxNbAnimals, cleanliness);
        this.height = height;
    }

    public void add(Animal type){
        if(type.getTypeAnimal().equals("volant")) {
            isGoodType = true;
            super.add(type);
            isGoodType = false;
        }
        else
            System.out.println("Vous ne pouvez ajouter " + type.getName()+ " à " + this.getName() + " car ce n'est pas un animal volant");
    }

    public void keepUp(){
        super.keepUp();
        if(isKeepUp) {
            System.out.println("Le toit a aussi été entretenu !");
            isKeepUp = false;
        }
    }
}
