package Paddock;

/**
 * Created by Darkweizer on 12/11/2015.
 */
public class Aquarium extends Paddock {

    private int depth;

    public Aquarium(String name, int surface, int maxNbAnimals, String cleanliness, int depth) {
        super(name, surface, maxNbAnimals, cleanliness);
        this.depth = depth;
    }
}
