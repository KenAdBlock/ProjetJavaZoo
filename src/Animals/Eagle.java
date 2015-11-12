package Animals;

import Movement.IFly;
import Species.Bird;

/**
 * Created by c13003593 on 13/10/2015.
 */
public class Eagle extends Bird implements IFly {

    public Eagle(String name, boolean sex, int weight, int height, int age) {
        super(name, sex, weight, height, age);
    } // Constructor

    @Override
    public void makeSound() {
        System.out.println("\nGlatissement de l'aigle.");
    } // makeSound()

    @Override
    public void move() {
        System.out.println("\nL'aigle vole.");
    } // move()

    @Override
    public void fly() {
        System.out.println("\nL'aigle vole...");
    }
} // class Eagle
