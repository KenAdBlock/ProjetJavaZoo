package Species;

import Exception.HungerException;

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

    protected Animal(String name, boolean sex, int weight, int height, int age) {
        this.name = name;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
        this.age = age;
    } // Constructor

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


    public void eat() throws HungerException {
        if (!sleepIndicator) {
            hungerIndicator = 100;
        }
        else {
            throw new HungerException();
        }
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
