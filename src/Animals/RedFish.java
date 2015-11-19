package Animals;

import Movement.ISwim;
import Species.Fish;

/**
 * Created by c13003593 on 13/10/2015.
 */
public class RedFish extends Fish implements ISwim {

    public RedFish(String name, boolean sex, long weight, int height, int age) {
        super(name, sex, weight, height, age);
    } // Constructor

    @Override
    public void makeSound() {
        System.out.println("\n'Bloubloutement' du poisson rouge.");
    } // makeSound()

    @Override
    public void move() {
        swim();
    } // move()

    @Override
    public void swim() {
        System.out.println("\nLe poisson rouge nage.");
    }
} // class RedFish
