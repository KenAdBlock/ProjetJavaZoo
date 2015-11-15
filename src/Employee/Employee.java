package Employee;

import Paddock.Paddock;
import Species.Animal;

/**
 * Created by Darkweizer on 15/11/2015.
 */
public class Employee {

    private String name;
    private boolean sex;
    private int age;

    public Employee(String name, boolean sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public String examine(Paddock paddock){
        return paddock.toString();
    }

    public void keeUp(Paddock paddock){
        paddock.keepUp();
    }

    public void restockFood(Paddock paddock, int food){
        paddock.restockFood(food);
    }

    public void moveAnimal(Paddock paddockOut, Animal animal){
        paddockOut.move(animal);
    }
}
