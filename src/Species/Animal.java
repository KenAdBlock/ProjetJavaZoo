package Species;

import Paddock.Paddock;
import Tools.Tools;

/**
 * Animal est une classe abstraite représentant un animal.
 * Cette classe a été créée notamment dans le but d'ajouter de la sémantique à l'application.
 *
 * @author Charles-Henri CARLIER et Kenny COADALEN
 */
public abstract class Animal {

    /**
     * Le nom de l'animal.
     */
    private String name;

    /**
     * Le sexe de l'animal.
     */
    private boolean sex; // true = male, false = femelle

    /**
     * Le poids de l'animal.
     */
    private long weight; // en gramme

    /**
     * La taille de l'animal.
     */
    private int height; // en cm

    /**
     * L'âge de l'animal.
     */
    private int age;

    /**
     * L'indicateur de faim de l'animal.
     */
    private int hungerIndicator = 100;

    /**
     * Booléen indiquant si l'animal dort ou non.
     */
    private boolean sleepIndicator; // true si il dort

    /**
     * L'indicateur de santé de l'animal.
     */
    private int healthIndicator = 100;

    /**
     * L'enclos dans lequel se trouve l'animal.
     */
    private Paddock paddock;

    /**
     * Le temps de gestation de l'animal.
     */
    protected long timeUnborn;

    /**
     * Le type de l'animal.
     */
    protected String typeAnimal;

    /**
     * Le constructeur de la classe Animal.
     * Cette classe a été créée notamment dans le but d'ajouter de la sémantique à l'application.
     * Une instance d'un animal ne peut pas être possible telle quelle.
     *
     * @param name
     *          Le nom de l'animal.
     * @param sex
     *          Le sexe de l'animal.
     * @param weight
     *          Le poids de l'animal.
     * @param height
     *          La taille de l'animal.
     * @param age
     *          L'âge de l'animal.
     */
    protected Animal(String name, boolean sex, long weight, int height, int age) {
        this.name = name;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
        this.age = age;
        Tools.mapAnimal.put(this.name, this);
    }// Constructor

    /**
     * Modifie l'enclos de l'animal afin que ce dernier se retrouve dans le nouvel enclos mis en paramètre.
     *
     * @param paddock
     *          Le nouvel enclos de l'animal.
     */
    public void setPaddock(Paddock paddock) {
        this.paddock = paddock;
    } // setPaddock()

    /**
     * Modifie l'indicateur de faim de l'animal
     *
     * @param hungerIndicator
     *          Le nouvel indicateur de faim.
     */
    public void setHungerIndicator(int hungerIndicator) {
        if(hungerIndicator<0)
            this.hungerIndicator = 0;
        else
            this.hungerIndicator = hungerIndicator;
    } // setHungerIndicator()

    /**
     * Modifie l'indicateur de santé de l'animal.
     *
     * @param healthIndicator
     *          Le nouvel indicateur de santé.
     */
    public void setHealthIndicator(int healthIndicator) {
        if(healthIndicator<0)
            this.healthIndicator= 0;
        else
            this.healthIndicator = healthIndicator;
    } // setHealthIndicator()

    /**
     * Récupère le nom de l'animal.
     *
     * @return Le nom de l'animal.
     */
    public String getName() {
        return name;
    } // getName()

    /**
     * Récupère le poids de l'animal.
     *
     * @return Le poids de l'animal.
     */
    public long getWeight() {
        return weight;
    } // getWeight()

    /**
     * Récupère la taille de l'animal.
     *
     * @return La taille de l'animal.
     */
    public int getHeight() {
        return height;
    } // getHeight()

    /**
     * Récupère l'âge de l'animal.
     *
     * @return L'âge de l'animal.
     */
    public int getAge() {
        return age;
    } // getAge()

    /**
     * Récupère l'indicateur de faim de l'animal.
     *
     * @return L'indicateur de faim de l'animal.
     */
    public int getHungerIndicator() {
        return hungerIndicator;
    } // getHungerIndicator()

    /**
     * Récupère l'indicateur de santé de l'animal.
     *
     * @return L'indicateur de santé.
     */
    public int getHealthIndicator() {
        return healthIndicator;
    } // getHealthIndicator()

    /**
     * Récupère l'enclos dans lequel se trouve l'animal
     *
     * @return Une instance de Paddock, représentant l'enclos de l'animal.
     */
    public Paddock getPaddock() {
        return paddock;
    } // getPaddock()

    /**
     * Récupère le type de l'animal.
     *
     * @return Le type de l'animal.
     */
    public String getTypeAnimal() {
        return typeAnimal;
    } // getTypeAnimal()

    /**
     * Récupère un booléen indiquant si l'animal est un mâle ou une femelle (true = mâle et false = femelle).
     *
     * @return Le sexe de l'animal.
     */
    public boolean isSex() {
        return sex;
    } // isSex()

    /**
     * Récupère un booléen indiquant si l'animal dort ou non (true -> il dort et false -> il ne dort pas).
     *
     * @return L'indicateur de sommeil de l'animal.
     */
    public boolean isSleepIndicator() {
        return sleepIndicator;
    } // isSleepIndicator()

    /**
     * Permet à l'animal de manger.
     * Cette méthode va vérifier si il y a de la nourriture de disponible dans l'enclos.
     * Et si c'est le cas, elle va ajouter à l'indicateur de faim de l'animal le maximum possible (limité à 100).
     */
    public void eat() {
        if (!sleepIndicator) {
            int needToFull = 100 - hungerIndicator;
            int foodInside = paddock.getFoodIndicator();
            if (foodInside == 0)
                System.out.println(Tools.strColorRed("Pas de nourriture disponible dans l'enclos " + paddock.getName()));
            else if((foodInside - needToFull) >= 0){
                paddock.setFoodIndicator(foodInside -= needToFull);
                hungerIndicator += needToFull;
            }
            else{
                hungerIndicator += foodInside;
                paddock.setFoodIndicator(0);
            }
        }
        else
            System.out.println("il fait dodo !");
    } // eat()

    /**
     * "Simule" le bruit que fait l'animal.
     * Méthode abstraite du fait qu'un animal est abstrait. Surcharge de la méthode dans chaque classe effective d'animal.
     */
    public abstract void makeSound(); // makeSound()

    /**
     * "Simule" le déplacement que fait l'animal.
     */
    public abstract void move(); // move()

    /**
     * Permet à l'animal d'être soigné.
     */
    public void beHealed() {
        healthIndicator = 100;
    } // beHealed()

    /**
     * Permet à l'animal de s'endormir.
     * Cela va lui permettre de regagner toute sa santé.
     */
    public void sleepAnimal() {
        sleepIndicator = true;
        healthIndicator = 100;
    } // sleepAnimal()

    /**
     * Permet à l'animal de se réveiller.
     */
    public void wakeAnimal() {
        sleepIndicator = false;
    } // wake()
} // class Animal
