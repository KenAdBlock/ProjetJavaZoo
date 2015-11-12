package Animals;

import Species.Mammal;

/**
 * Created by c13003593 on 13/10/2015.
 */
public class Bear extends Mammal {

    public Bear(String name, boolean sex, int weight, int height, int age) {
        super(name, sex, weight, height, age);
    } // Constructor

    @Override
    public void makeSound() {
        System.out.println("\nGrognement de l'ours.");
    } // makeSound()

    @Override
    public void move() {
        System.out.println("\nL'ours se déplace...");
    } // move()

} // class Bear
