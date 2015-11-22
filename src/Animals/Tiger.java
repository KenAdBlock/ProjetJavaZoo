package Animals;

import Movement.IWander;
import Species.Mammal;
import Tools.Tools;

/**
 *  Tiger est la classe représentant un tigre.
 *  Elle hérite de la classe abstraite Mammal car sémantiquement un tigre est un mammifère.
 *
 *  @author Charles-Henri CARLIER et Kenny COADALEN
 *  @see Species.Mammal
 */
public class Tiger extends Mammal implements IWander {

    /**
     * Le nombre total de tigres présents dans le zoo.
     */
    static int nbTiger;

    /**
     * Le constructeur de la classe Tiger.
     * Il permet de créer de nouvelles instances de cette classe.
     *
     * @param name
     *          Le nom du tigre.
     * @param sex
     *          Le sexe du tigre.
     * @param weight
     *          Le poids du tigre.
     * @param height
     *          La taille du tigre.
     * @param age
     *          L'âge du tigre.
     */
    public Tiger(String name, boolean sex, long weight, int height, int age) {
        super(name, sex, weight, height, age);
        timeUnborn = Tools.random(6000, 6301);// 1000 ms égale 1 jour en vrai
        typeAnimal = "autre";
        Tools.mapTiger.put(this.getName(),this);
        beAlive();
    } //Constructor

    /**
     * Modifie le nombre de tigre.
     *
     * @param nbTiger
     *          Le nouveau nombre de tigre.
     */
    public static void setNbTiger(int nbTiger) {
        Tiger.nbTiger = nbTiger;
    } // setNbTiger()

    /**
     * Retourne le nombre de tigres présents dans le zoo.
     *
     * @return Le nombre de tigres.
     */
    public static int getNbTiger() {
        return nbTiger;
    } // getNbTiger()

    /**
     * Retourne une string représentant "textuellement" les caractéristiques du tigre.
     *
     * @return Une string, représentant les caractéristiques du tigre.
     */
    @Override
    public String toString() {
        String tostring = "Tigre : " +
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
     * "Simule" le bruit que fait le tigre.
     */
    @Override
    public void makeSound() {
        System.out.println("\nHurlement du tigre.");
    } // makeSound()

    /**
     * "Simule" le déplacement que fait le tigre.
     */
    @Override
    public void move() {
        System.out.println("\nLe tigre vagabonde.");
    } // move()

    /**
     * "Simule" la façon de vagabonder du tigre.
     */
    @Override
    public void wander() {
        System.out.println("Je fais des bonds, encore des bonds, tout plein de bonds !");
    } // wander()

    /**
     * Thread simulant la "vie" du tigre.
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
     * Donne la possibilité à un tigre de se reproduire avec un autre.
     * Cela a autant de chance de fonctionner ou non.
     * Si la reproduction a réussi, une période de gestation est nécessaire.
     *
     * @param tiger
     *          Le tigre avec lequel se reproduire.
     * @see Tiger#unborn(Tiger, int)
     */
    public void reproduction(Tiger tiger){
        if ((this.isSex() != tiger.isSex())){
            int random = Tools.random(0, 2);
            int randomNbChild = Tools.random(4, 8);

            Tiger t ;
            Tiger t1;
            if(this.isSex()) {
                t = tiger;
                t1 = this;
            }
            else {
                t = this;
                t1 = tiger;
            }
            if(random < 1){
                unborn(t,randomNbChild);
            }
            else if(t == t1)
                ;
            else
                System.out.println(Tools.strColorBlue("\nLa reproduction entre " + t.getName() + "(femele) et " + t1.getName() + "(mâle) n'a donné aucun bébé."));
        }
    } // reproduction()

    /**
     * Simule le temps de gestation d'un tigre.
     * Un message est affiché lorsque 80% du processus est effectué.
     *
     * @param tiger
     *          Le tigre en période de gestation.
     * @param nbChild
     *          Le nombre de futurs enfants.
     * @see Tiger#giveBirth(Tiger)
     */
    private void unborn(final Tiger tiger, final int nbChild){
        new Thread( new Thread(){
            @Override
            public void run() {
                try {
                    sleep(timeUnborn - (timeUnborn/100*20));
                    System.out.println(tiger.getName()
                            + "(femelle) va bientôt mettre bas de "
                            + nbChild
                            + " petits...");
                    sleep(timeUnborn - (timeUnborn/100*80));
                    for (int i = 0; i < nbChild; ++i){
                        giveBirth(tiger);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }//unborn()

    /**
     * Permet de donner naissance à un nouveau tigre.
     *
     * @param tiger
     *          Le nouveau tigre à créer.
     */
    private synchronized void giveBirth(Tiger tiger){
        nbTiger += 1;
        Tiger t = new Tiger("tiger"+nbTiger, (Tools.random(0,2) != 0), Tools.random(100,200), Tools.random(7, 14), 0);
        System.out.println(tiger.getName() + "(femelle) vient de donner naissance à " + t.getName());
        t.setPaddock(this.getPaddock());
        this.getPaddock().add(t);
    }//giveBirth()
} // class Tiger
