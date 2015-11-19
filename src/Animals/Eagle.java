package Animals;

import Movement.IFly;
import Species.Bird;
import Tools.Tools;

/**
 * Created by c13003593 on 13/10/2015.
 */
public class Eagle extends Bird implements IFly {
    static int nbEagle;

    public void setNbEagle(int nbEagle) {
        this.nbEagle = nbEagle;
    } // setNbEagle()

    public static int getNbEagle() {
        return nbEagle;
    } // getNbEagle()

    public Eagle(String name, boolean sex, long weight, int height, int age) {
        super(name, sex, weight, height, age);
        timeUnborn = Tools.random(6000, 6301);// 1000 ms égale 1 jour en vrai
        typeAnimal = "volant";
        nbEagle += 1;
    } //Constructor



    @Override
    public String toString() {
        String tostring = "Aigle : " +
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
        tostring += "\n\tindicateur de santé = " + getHealthIndicator() + "/100";

        return tostring;
    } // toString()

    @Override
    public void makeSound() {
        System.out.println("\nHurlement de l'aigle.");
    } // makeSound()

    @Override
    public void move() {
        System.out.println("\nL'aigle marche.");
    } // move()

    @Override
    public void fly() {
        System.out.println("\nL'aigle vole...");
    } // fly()

    public void reproduction(Eagle eagle){

        if ( (this.isSex() != eagle.isSex()) ){

            int random = Tools.random(0, 2);
            int randomNbChild = Tools.random(4, 8);

            Eagle e ;

            if(this.isSex())
                e = eagle;
            else
                e = this;

            if(random < 1){
                unborn(e,randomNbChild);
            }
            else
                System.out.println("\nLa reproduction n'a donné aucun bébé");
        }
        else
            System.out.println("\nCe sont des aigles du même sexe ! Petit coquin");
    } // reproduction()


    private void unborn(final Eagle eagle, final int nbChild){

        //timer()
        new Thread( new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println(eagle.getName()
                            + "(femelle) vient de pondre  "
                            + nbChild
                            + " oeufs...");
                    sleep(timeUnborn - (timeUnborn / 100 * 20));
                    System.out.println("Les oeufs vont bientôt éclore");
                    sleep(timeUnborn - (timeUnborn/100*80));
                    for (int i = 0; i < nbChild; ++i){
                        giveBirth(eagle);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }//unborn()     // gestation

    private synchronized void giveBirth(Eagle eagle){
        Eagle e = new Eagle("eagle"+nbEagle, (Tools.random(0,2) != 0), Tools.random(100,200), Tools.random(7, 14), 0);
        System.out.println("L'oeuf vient d'éclore et donne naissance à " + e.getName());
        e.setPaddock(this.getPaddock());
        this.getPaddock().add(e);
    }//giveBirth()  // accouchement

} // class Eagle
