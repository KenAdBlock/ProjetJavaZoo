package Animals;

import Movement.ISwim;
import Species.Fish;
import Tools.Tools;

/**
 * Created by c13003593 on 13/10/2015.
 */
public class Shark extends Fish implements ISwim {

    static int nbShark;

    public void setNbShark(int nbShark) {
        this.nbShark = nbShark;
    }

    public int getNbShark() {
        return nbShark;
    }

    public Shark(String name, boolean sex, long weight, int height, int age) {
        super(name, sex, weight, height, age);
        timeUnborn = Tools.random(6000, 6301);// 1000 ms égale 1 jour en vrai
        typeAnimal = "nageant";
    } //Constructor



    @Override
    public String toString() {
        String tostring = "Requin : " +
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
    }

    @Override
    public void makeSound() {
        System.out.println("\nHurlement de requin.");
    } // makeSound()

    @Override
    public void move() {
        System.out.println("\nLa requin se déplace.");
    } // move()

    @Override
    public void swim() {
        System.out.println("\nLe requin nage.");
    }

    public void reproduction(Shark shark){

        if ( (this.isSex() != shark.isSex()) ){

            int random = Tools.random(0, 2);
            int randomNbChild = Tools.random(4, 8);

            Shark s ;

            if(this.isSex())
                s = shark;
            else
                s = this;

            if(random < 1){
                unborn(s,randomNbChild);
            }
            else
                System.out.println("\nLa reproduction n'a donné aucun bébé");
        }
        else
            System.out.println("\nCe sont des requins du même sexe ! Petit coquin");
    }


    private void unborn(final Shark shark, final int nbChild){

        //timer()
        new Thread( new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println(shark.getName()
                            + "(femelle) vient de pondre  "
                            + nbChild*10
                            + " oeufs...");
                    sleep(timeUnborn - (timeUnborn / 100 * 20));
                    System.out.println("Les oeufs vont bientôt éclore");
                    sleep(timeUnborn - (timeUnborn / 100 * 80));
                    System.out.println("Seulement " + nbChild + " oeufs sont arrivés à terme");
                    for (int i = 0; i < nbChild; ++i){
                        giveBirth(shark);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }//unborn()     // gestation

    private synchronized void giveBirth(Shark shark){
        nbShark += 1;
        Shark s = new Shark("shark"+nbShark, (Tools.random(0,2) != 0), Tools.random(100,200), Tools.random(7, 14), 0);
        System.out.println("L'oeuf vient d'éclore et donne naissance à " + s.getName());
        s.setPaddock(this.getPaddock());
        this.getPaddock().add(s);
    }//giveBirth()  // accouchement

} // class Shark
