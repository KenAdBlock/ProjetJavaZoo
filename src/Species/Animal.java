package Species;

import Paddock.Paddock;
import Tools.Tools;

/**
 * Created by c13003593 on 13/10/2015.
 */

public abstract class Animal {
    private String name;
    private boolean sex; // true = male, false = femelle
    private long weight; // en gramme
    private int height; // en cm
    private int age;
    private int hungerIndicator = 100;
    private boolean sleepIndicator; // true si il dort
    private int healthIndicator = 100;
    private Paddock paddock;
    protected long timeUnborn;
    protected String typeAnimal;

    protected Animal(String name, boolean sex, long weight, int height, int age) {
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
        if(hungerIndicator<0)
            this.hungerIndicator = 0;
        else
            this.hungerIndicator = hungerIndicator;
    }

    public void setHealthIndicator(int healthIndicator) {
        if(healthIndicator<0)
            this.healthIndicator= 0;
        else
            this.healthIndicator = healthIndicator;
    }





    public String getName() {
        return name;
    }

    public boolean isSex() {
        return sex;
    }

    public long getWeight() {
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

    public String getTypeAnimal() {
        return typeAnimal;
    }

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

    public abstract void makeSound(); // makeSound()

    public abstract void move(); // move()

    public void beHealed() {
        healthIndicator = 100;
        System.out.println(Tools.strColorBlue("\n" + name + " a été soigné."));
    } // beHealed()

    public void sleepAnimal() {
        sleepIndicator = true;
        healthIndicator = 100;
    } // sleep()

    public void wakeAnimal() {
        sleepIndicator = false;
    } // wake()

} // class Animal
