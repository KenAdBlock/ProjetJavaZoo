package Animals;

import Movement.ISwim;
import Species.Fish;

/**
 * Created by c13003593 on 13/10/2015.
 */
public class Shark extends Fish implements ISwim {

    public Shark(String name, boolean sex, int weight, int height, int age) {
        super(name, sex, weight, height, age);
    } // Constructor

    @Override
    public void makeSound() {
        System.out.println("\n'Cri' du requin.");
    } // makeSound()

    @Override
    public void move() {
        swim();
    } // move()

    @Override
    public void swim() {
        System.out.println("\nLe requin nage.");
    }
} // class Shark
