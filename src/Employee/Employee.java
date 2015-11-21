package Employee;

import Paddock.Paddock;
import Species.Animal;
import Tools.Tools;

/**
 * Employee est la classe représentant l'employé (unique) de l'application.
 * Son unicité fait d'elle un singleton.
 *
 * @author Charles-Henri CARLIER et Kenny COADALEN
 */
public class Employee {

    /**
     * Le nom de l'employé.
     */
    private String name;

    /**
     * Le sexe de l'employé.
     */
    private boolean sex;

    /**
     * L'âge de l'employé.
     */
    private int age;

    /**
     * Le constructeur de la classe Employé.
     * Il permet de créer une et une seule instance de cette classe.
     *
     * @param name
     *          Le nom de l'employé.
     * @param sex
     *          Le sexe de l'employé.
     * @param age
     *          L'âge de l'employé.
     */
    private Employee(String name, boolean sex, int age) {
        this.name = name;
        this.sex = sex;
        this.age = age;
    } // Constructor

    /**
     *
     */
    private static Employee INSTANCE = new Employee("Gerard",true,58);

    /**
     *
     *
     * @return
     */
    public static Employee getINSTANCE() {
        return INSTANCE;
    } // getINSTANCE()

    /**
     *
     *
     * @param paddock
     * @return
     */
    public String examine(Paddock paddock){
        return paddock.toString();
    } // examine()

    /**
     *
     *
     * @param paddock
     */
    public void keeUp(Paddock paddock){
        paddock.keepUp();
    } // keeUp()

    /**
     *
     *
     * @param paddock
     * @param food
     */
    public void restockFood(Paddock paddock, int food){
        if(food > paddock.getMaxQuantityFood()+1){
            paddock.restockFood(paddock.getMaxQuantityFood());
            System.out.println(Tools.strColorBlue("\nL'employé " + name + " a réapprovisionné de seulement " + paddock.getMaxQuantityFood() + " unités de nourriture " + paddock.getName() + "."));
        }
        else {
            paddock.restockFood(food);
            if(paddock.getFoodIndicator() > paddock.getMaxQuantityFood()+1)
                paddock.restockFood(paddock.getMaxQuantityFood());
            System.out.println(Tools.strColorBlue("\nL'employé " + name + " à réapprovisionné de " + food + " unités de nourriture " + paddock.getName() + "."));
        }
    } // restockFood()

    /**
     *
     *
     * @param animal
     */
    public void heal(Animal animal){
        animal.beHealed();
        System.out.println(Tools.strColorBlue("\nL'employé " + name + " a soigné " + animal.getName() + "."));
    } // heal()

    /**
     *
     * 
     * @param paddockOut
     * @param animal
     */
    public void moveAnimal(Paddock paddockOut, Animal animal){
        paddockOut.move(animal);
    } // moveAnimal()
} // class Employe
