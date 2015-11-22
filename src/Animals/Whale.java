package Animals;

import Movement.ISwim;
import Species.Mammal;
import Tools.Tools;

/**
 *  Whale est la classe représentant une baleine.
 *  Elle hérite de la classe abstraite Mammal car sémantiquement une baleine est un mammifère.
 *
 *  @author Charles-Henri CARLIER et Kenny COADALEN
 *  @see Species.Mammal
 */
public class Whale extends Mammal implements ISwim {

    /**
     * Le nombre total de baleines présents dans le zoo.
     */

    static int nbWhale;

    /**
     * Le constructeur de la classe Whale.
     * Il permet de créer de nouvelles instances de cette classe.
     *
     * @param name
     *          Le nom de la baleine.
     * @param sex
     *          Le sexe de la baleine.
     * @param weight
     *          Le poids de la baleine.
     * @param height
     *          La taille de la baleine.
     * @param age
     *          L'âge de la baleine.
     */
    public Whale(String name, boolean sex, long weight, int height, int age) {
        super(name, sex, weight, height, age);
        timeUnborn = Tools.random(6000, 6301);// 1000 ms égale 1 jour en vrai
        typeAnimal = "nageant";
        Tools.mapWhale.put(this.getName(),this);
        beAlive();
    } //Constructor

    /**
     * Modifie le nombre de baleine.
     *
     * @param nbWhale
     *          Le nouveau nombre de baleine.
     */
    public static void setNbWhale(int nbWhale) {
        Whale.nbWhale = nbWhale;
    } // setNbWhale()

    /**
     * Retourne le nombre de baleines présents dans le zoo.
     *
     * @return Le nombre de baleines.
     */
    public static int getNbWhale() {
        return nbWhale;
    } // getNbWhale()

    /**
     * Retourne une string représentant "textuellement" les caractéristiques de la baleine.
     *
     * @return Une string, représentant les caractéristiques de la baleine.
     */
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

    /**
     * "Simule" le bruit que fait la baleine.
     */
    @Override
    public void makeSound() {
        System.out.println("\nChant de la baleine.");
    } // makeSound()

    /**
     * "Simule" le déplacement que fait la baleine.
     */
    @Override
    public void move() {
        System.out.println("\nLa baleine se déplace.");
    } // move()

    /**
     * "Simule" la façon de nager de la baleine.
     */
    @Override
    public void swim() {
        System.out.println("\nLa baleine nage");
    } // swim()

    /**
     * Thread simulant la "vie" de la baleine.
     */
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
    } // beAlive()

    /**
     * Donne la possibilité à une balein de se reproduire avec une autre.
     * Cela a autant de chance de fonctionner ou non.
     * Si la reproduction a réussi, une période de gestation est nécessaire.
     *
     * @param whale
     *          La baleine avec lequel se reproduire.
     * @see Whale#unborn(Whale, int)
     */
    public void reproduction(Whale whale){
        if ((this.isSex() != whale.isSex())){
            int random = Tools.random(0, 2);
            int randomNbChild = Tools.random(4, 8);

            Whale w ;
            Whale w1;
            if(this.isSex()) {
                w = whale;
                w1 = this;
            }
            else {
                w = this;
                w1 = whale;
            }
            if(random < 1){
                unborn(w,randomNbChild);
            }
            else if(w == w1)
                ;
            else
                System.out.println(Tools.strColorBlue("\nLa reproduction entre " + w.getName() + "(femele) et " + w1.getName() + "(mâle) n'a donné aucun bébé."));
        }
    } // reproduction()

    /**
     * Simule le temps de gestation d'une balein.
     * Un message est affiché lorsque 80% du processus est effectué.
     *
     * @param whale
     *          La baleine en période de gestation.
     * @param nbChild
     *          Le nombre de futurs enfants.
     * @see Whale#giveBirth(Whale)
     */
    private void unborn(final Whale whale, final int nbChild){
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
    }//unborn()

    /**
     * Permet de donner naissance à une nouvelle baleine.
     *
     * @param whale
     *          La nouvelle baleine à créer.
     */
    private synchronized void giveBirth(Whale whale){
        nbWhale += 1;
        Whale w = new Whale("whale"+nbWhale, (Tools.random(0,2) != 0), Tools.random(100,200), Tools.random(7, 14), 0);
        System.out.println("L'oeuf vient d'éclore et donne naissance à " + w.getName());
        w.setPaddock(this.getPaddock());
        this.getPaddock().add(w);
    }//giveBirth()
} // class Whale
