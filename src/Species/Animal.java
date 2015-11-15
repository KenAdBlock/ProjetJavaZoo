package Species;

import Exception.HungerException;
import Paddock.Paddock;

/**
 * Created by c13003593 on 13/10/2015.
 */

public abstract class Animal {
    private String name;
    private boolean sex; // true = male, false = femelle
    private int weight; // en gramme
    private int height; // en cm
    private int age;
    private int hungerIndicator = 100;
    private boolean sleepIndicator; // true si il dort
    private int healthIndicator = 100;
    private Paddock paddock;

    protected Animal(String name, boolean sex, int weight, int height, int age) {
        this.name = name;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
        this.age = age;
    } // Constructor

    public void setPaddock(Paddock paddock) {
        this.paddock = paddock;
    }

    public void setHungerIndicator(int hungerIndicator) {
        this.hungerIndicator = hungerIndicator;
    }

    public String getName() {
        return name;
    }

    public boolean isSex() {
        return sex;
    }

    public int getWeight() {
        return weight;
    }

    public int getHeight() {
        return height;
    }

    public int getAge() {
        return age;
    }

    public int getHungerIndicator() {
        return hungerIndicator;
    }

    public boolean isSleepIndicator() {
        return sleepIndicator;
    }

    public int getHealthIndicator() {
        return healthIndicator;
    }

    public Paddock getPaddock() {
        return paddock;
    }

    public void eat() {
        if (!sleepIndicator) {
            int needToFull = 100 - hungerIndicator;
            int foodInside = paddock.getFoodIndicator();
            if (foodInside == 0)
                System.out.println("Pas de nourriture disponible dans l'enclos " + paddock.getName()); // faire en sorte que l'employer ajoute de la bouf !
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

    public abstract void makeSound(); // makeSound()

    public abstract void move(); // move()

    public void beHealed() {
        healthIndicator = 100;
    } // beHealed()

    public void sleep() {
        sleepIndicator = true;
    } // sleep()

    public void wake() {
        sleepIndicator = false;
    } // wake()

} // class Animal
