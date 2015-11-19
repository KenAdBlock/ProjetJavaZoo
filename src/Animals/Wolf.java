package Animals;

import Movement.IWander;
import Species.Mammal;
import Tools.Tools;

/**
 * Created by c13003593 on 13/10/2015.
 */
public class Wolf extends Mammal implements IWander {

    static int nbWolf;

    public static void setNbWolf(int nbWolf) {
        Wolf.nbWolf = nbWolf;
    } // setNbWolf()

    public static int getNbWolf() {
        return nbWolf;
    } // getNbWolf()

    public Wolf(String name, boolean sex, long weight, int height, int age) {
        super(name, sex, weight, height, age);
        timeUnborn = Tools.random(6000, 6301);// 1000 ms égale 1 jour en vrai
        typeAnimal = "autre";
    } //Constructor


    @Override
    public String toString() {
        String tostring = "Loup : " +
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
        System.out.println("\nHurlement du loup.");
    } // makeSound()

    @Override
    public void move() {
        System.out.println("\nLe loup vagabonde.");
    } // move()

    @Override
    public void wander() {
        System.out.println("Je fais des bonds, encore des bonds, tout plein de bonds !");
    } // wander()


    public void reproduction(Wolf wolf){

        if ( (this.isSex() != wolf.isSex()) ){

            int random = Tools.random(0, 2);
            int randomNbChild = Tools.random(4, 8);

            Wolf w ;

            if(this.isSex())
                w = wolf;
            else
                w = this;

            if(random < 1){
                unborn(w,randomNbChild);
            }
            else
                System.out.println("\nLa reproduction n'a donné aucun bébé");
        }
        else
            System.out.println("\nCe sont des loups du même sexe ! Petit coquin");
    } // reproduction()


    private void unborn(final Wolf wolf, final int nbChild){

        //timer()
        new Thread( new Thread(){
            @Override
            public void run() {
                try {
                    sleep(timeUnborn - (timeUnborn/100*20));
                    System.out.println(wolf.getName()
                            + "(femelle) va bientôt mettre bas de "
                            + nbChild
                            + " petits...");
                    sleep(timeUnborn - (timeUnborn/100*80));
                    for (int i = 0; i < nbChild; ++i){
                        giveBirth(wolf);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }//unborn()     // gestation


    private synchronized void giveBirth(Wolf wolf){
        nbWolf += 1;
        Wolf w = new Wolf("wolf"+nbWolf, (Tools.random(0,2) != 0), Tools.random(100,200), Tools.random(7, 14), 0);
        System.out.println(wolf.getName() + "(femelle) vient de donner naissance à " + w.getName());
        w.setPaddock(this.getPaddock());
        this.getPaddock().add(w);
    }//giveBirth()  // accouchement

} // class Wolf
