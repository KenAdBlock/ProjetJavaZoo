package Animals;

import Species.Mammal;
import Tools.Tools;

/**
 * Created by c13003593 on 13/10/2015.
 */
public class Bear extends Mammal {

    static int nbBear;

    public static void setNbBear(int nbBear) {
        Bear.nbBear = nbBear;
    } // setNbBear()

    public static int getNbBear() {
        return nbBear;
    } // getNbBear()

    public Bear(String name, boolean sex, long weight, int height, int age) {
        super(name, sex, weight, height, age);
        timeUnborn = Tools.random(6000, 6301); // 1000 ms égale 1 jour en vrai
        typeAnimal = "autre";
    } // Constructor

    @Override
    public String toString() {
        String tostring = "Ours : " +
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
        System.out.println("\nGrognement de l'ours.");
    } // makeSound()

    @Override
    public void move() {
        System.out.println("\nL'ours se déplace...");
    } // move()

    public void reproduction(Bear bear){

        if ( (this.isSex() != bear.isSex()) ){

            int random = Tools.random(0, 2);
            int randomNbChild = Tools.random(4, 8);

            Bear b ;

            if(this.isSex())
                b = bear;
            else
                b = this;

            if(random < 1){
                System.out.println("ça a marché");
                unborn(b,randomNbChild);
            }
            else
                System.out.println("\nLa reproduction n'a donné aucun bébé");
        }
        else
            System.out.println("\nCe sont des loups du même sexe ! Petit coquin");
    } // reproduction()


    private void unborn(final Bear bear, final int nbChild){

        //timer()
        new Thread( new Thread(){
            @Override
            public void run() {
                try {
                    sleep(timeUnborn - (timeUnborn/100*20));
                    System.out.println(bear.getName() + "(femelle) va bientôt mettre bas...");
                    sleep(timeUnborn - (timeUnborn/100*80));
                    for (int i = 0; i < nbChild; ++i){
                        giveBirth(bear);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }//unborn()     // gestation

    private synchronized void giveBirth(Bear bear){
        nbBear += 1;
        Bear b = new Bear("bear"+nbBear, (Tools.random(0,2) != 0), Tools.random(100,200), Tools.random(7, 14), 0);
        System.out.println(bear.getName() + "(femelle) vient de donner naissance à " + "bear" + nbBear);
        b.setPaddock(this.getPaddock());
        this.getPaddock().add(b);

    }//giveBirth()  // accouchement

} // class Bear
