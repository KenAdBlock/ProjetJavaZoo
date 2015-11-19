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

    private Employee(String name, boolean sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    private static Employee INSTANCE = new Employee("Gerard",true,58);

    public static Employee getINSTANCE() {
        return INSTANCE;
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
