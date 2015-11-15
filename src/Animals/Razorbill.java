package Animals;

import Movement.IFly;
import Movement.ISwim;
import Species.Bird;

/**
 * Created by c13003593 on 13/10/2015.
 */
public class Razorbill extends Bird implements ISwim, IFly {

    public Razorbill(String name, boolean sex, int weight, int height, int age) {
        super(name, sex, weight, height, age);
    } // Constructor

    @Override
    public void makeSound() {
        System.out.println("\nJabotement du petit pingouin.");
    } // makeSound()

    @Override
    public void move() {
        System.out.println("\nLe petit pingouin se déplace...");
    } // move()

    @Override
    public void fly() {
        System.out.println("\nLe petit pingouin vole.");
    }

    @Override
    public void swim() {
        System.out.println("\nLe petit pingouin nage.");
    }
} // class Razorbill
