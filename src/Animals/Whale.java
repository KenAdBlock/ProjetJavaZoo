package Animals;

import Movement.ISwim;
import Species.Fish;
import Species.Mammal;
import Tools.Tools;

/**
 * Created by c13003593 on 13/10/2015.
 */
public class Whale extends Mammal implements ISwim {

    static int nbWhale;

    public Whale(String name, boolean sex, long weight, int height, int age) {
        super(name, sex, weight, height, age);
        timeUnborn = Tools.random(6000, 6301);// 1000 ms égale 1 jour en vrai
        typeAnimal = "nageant";
        beAlive();
    } //Constructor

    public static void setNbWhale(int nbWhale) {
        Whale.nbWhale = nbWhale;
    } // setNbWhale()

    public static int getNbWhale() {
        return nbWhale;
    } // getNbWhale()


    @Override
    public String toString() {
        String tostring = "Baleine : " +
                "\n\tnom = " + getName();
        if (isSex())
            tostring += "\n\tsexe = mâle ";
        else
            tostring += "\n\tsexe = femelle";
        if (getWeight()>999)
            tostring += "\n\tpoids = " + getWeight()/1000 + "kg";
        else
            tostring += "\n\tpoids = " + getWeight() + "g";
        if (getHeight()>99)
            tostring += "\n\ttaille = " + getHeight()/100 + "." + getHeight()%100 + "m";
        else
            tostring += "\n\ttaille = " + getWeight() + "cm";
        tostring += "\n\tâge = " + getAge() + "an(s)\n\tindicateur de faim = " + getHungerIndicator() + "/100";
        if(isSleepIndicator())
            tostring += "\n\tindicateur de sommeil = endormi";
        else
            tostring += "\n\tindicateur de sommeil = éveillé";
        tostring += "\n\tindicateur de santé = " + getHealthIndicator() + "/100\n\n";

        return tostring;
    } // toString()

    @Override
    public void makeSound() {
        System.out.println("\nChant de la baleine.");
    } // makeSound()

    @Override
    public void move() {
        System.out.println("\nLa baleine se déplace.");
    } // move()

    public void beAlive(){
        new Thread( new Thread() {
            @Override
            public void run() {
                while (true) {
                    try {
                        if (isSleepIndicator())
                            wakeAnimal();
                        else if (getHealthIndicator() < 22)
                            sleepAnimal();

                        if (!isSleepIndicator() && getHungerIndicator() < 25)
                            eat();
                        sleep(6000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    @Override
    public void swim() {
        System.out.println("\nLa balaine nage");
    } // swim()

    public void reproduction(Whale whale){

        if ( (this.isSex() != whale.isSex()) ){

            int random = Tools.random(0, 2);
            int randomNbChild = Tools.random(4, 8);

            Whale w ;

            if(this.isSex())
                w = whale;
            else
                w = this;

            if(random < 1){
                unborn(w,randomNbChild);
            }
            else
                System.out.println("\nLa reproduction n'a donné aucun bébé");
        }
        else
            System.out.println("\nCe sont des baleines du même sexe ! Petit coquin");
    } // reproduction()


    private void unborn(final Whale whale, final int nbChild){

        //timer()
        new Thread( new Thread(){
            @Override
            public void run() {
                try {
                    sleep(timeUnborn - (timeUnborn / 100 * 20));
                    System.out.println(whale.getName()
                            + "(femelle) va bientôt mettre bas de "
                            + nbChild
                            + " petits...");
                    sleep(timeUnborn - (timeUnborn / 100 * 80));
                    for (int i = 0; i < nbChild; ++i){
                        giveBirth(whale);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }//unborn()     // gestation

    private synchronized void giveBirth(Whale whale){
        nbWhale += 1;
        Whale w = new Whale("whale"+nbWhale, (Tools.random(0,2) != 0), Tools.random(100,200), Tools.random(7, 14), 0);
        System.out.println("L'oeuf vient d'éclore et donne naissance à " + w.getName());
        w.setPaddock(this.getPaddock());
        this.getPaddock().add(w);
    }//giveBirth()  // accouchement

} // class Whale
