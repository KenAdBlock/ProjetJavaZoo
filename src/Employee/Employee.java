package Employee;

import Paddock.Paddock;
import Species.Animal;
import Tools.Tools;

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

    private static Employee INSTANCE = new Employee("Gérard",true,58);

    public static Employee getINSTANCE() {
        return INSTANCE;
    }

    public String examine(Paddock paddock){
        return paddock.toString();
    }

    public void keeUp(Paddock paddock){
        paddock.keepUp();
    }

    public String getName() {
        return name;
    }

    public void restockFood(Paddock paddock, int food){

        if(food > paddock.getMaxQuantityFood()+1){
            paddock.restockFood(paddock.getMaxQuantityFood());
            System.out.println(Tools.strColorBlue("\nL'employé " + name + " à réapprovisionné de seulement " + paddock.getMaxQuantityFood() + " unités de nourriture " + paddock.getName() + "."));
        }
        else {
            paddock.restockFood(food);
            if(paddock.getFoodIndicator() > paddock.getMaxQuantityFood()+1)
                paddock.restockFood(paddock.getMaxQuantityFood());
            System.out.println(Tools.strColorBlue("\nL'employé " + name + " à réapprovisionné de " + food + " unités de nourriture " + paddock.getName() + "."));
        }
    }

    public void heal(Animal animal){
        animal.beHealed();
        System.out.println(Tools.strColorBlue("\nL'employé " + name + " a soigné " + animal.getName() + "."));
    }

    public void moveAnimal(Paddock paddockOut, Animal animal){
        paddockOut.move(animal);
    }
}
