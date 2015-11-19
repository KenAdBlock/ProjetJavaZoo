package Animals;

import Movement.ISwim;
import Species.Fish;

/**
 * Created by c13003593 on 13/10/2015.
 */
public class Whale extends Fish implements ISwim {

    public Whale(String name, boolean sex, long weight, int height, int age) {
        super(name, sex, weight, height, age);
    } // Constructor

    @Override
    public void makeSound() {
        System.out.println("\nChant de la baleine.");
    } // makeSound()

    @Override
    public void move() {
        swim();
    } // move()

    @Override
    public void swim() {
        System.out.println("\nLa balaine nage");
        if (this.isSex())
            System.out.println(" avec son gros zizi ;)");
        else
            System.out.println(" avec ses gros sboob !");
    }
} // class Whale
