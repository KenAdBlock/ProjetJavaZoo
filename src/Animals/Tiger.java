package Animals;

import Movement.IWander;
import Species.Fish;

/**
 * Created by c13003593 on 13/10/2015.
 */
public class Tiger extends Fish implements IWander {

    public Tiger(String name, boolean sex, long weight, int height, int age) {
        super(name, sex, weight, height, age);
    } // Constructor

    @Override
    public void makeSound() {
        System.out.println("\nFeulement du tigre.");
    } // makeSound()

    @Override
    public void move() {
        System.out.println("\nLe tigre vagabonde.");
    } // move()

    @Override
    public void wander() {

    }
} // class Tiger
