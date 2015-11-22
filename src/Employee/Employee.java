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
     * Instance unique d'un employé.
     */
    private static Employee INSTANCE = null;

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
     * Retourne l'instance unique de l'employé.
     *
     * @return L'instance de l'employé (unique).
     */
    public static synchronized Employee getINSTANCE() {
        if (INSTANCE == null)
            INSTANCE = new Employee("Gerard", true, 58);
        return INSTANCE;
    } // getINSTANCE()

    /**
     * Permet a l'employé d'éxaminer un enclos.
     *
     * @param paddock
     *          L'enclos à éxaminer.
     *
     * @return Une chaîne de caractère, contenant les caractéristiques d'un enclos.
     */
    public String examine(Paddock paddock){
        return paddock.toString();
    } // examine()

    /**
     * Permet à l'employé de nettoyer un enclos.
     *
     * @param paddock
     *          L'enclos dans lequel nettoyer.
     */
    public void keeUp(Paddock paddock){
        paddock.keepUp();
    } // keeUp()

    /**
     * Permet de récupérer le nom de l'employé.
     */
    public String getName() {
        return name;
    } // getName()


    /**
     * Permet à l'employé de réapprovisionner un enclos en nourriture.
     *
     * @param paddock
     *          L'enclos à réapprovisionner.
     * @param food
     *          La quantité de nourriture à réapprovisionner.
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
     * Permet à l'employé de soigner un animal.
     *
     * @param animal
     *          L'animal à soigner.
     */
    public void heal(Animal animal){
        animal.beHealed();
        System.out.println(Tools.strColorBlue("\nL'employé " + name + " a soigné " + animal.getName() + "."));
    } // heal()

    /**
     * Permet à l'employé de déplacer un animal d'un enclos à un autre.
     *
     * @param paddockOut
     *          L'enclos de destination du déplacement.
     * @param animal
     *          L'animal à déplacer.
     */
    public void moveAnimal(Paddock paddockOut, Animal animal){
        paddockOut.move(animal);
    } // moveAnimal()
} // class Employee
