package Animals;

import Movement.ISwim;
import Species.Fish;
import Tools.Tools;

/**
 *  Shark est la classe représentant un requin.
 *  Elle hérite de la classe abstraite Fish car sémantiquement un requin est un poisson.
 *
 *  @author Charles-Henri CARLIER et Kenny COADALEN
 *  @see Species.Fish
 */
public class Shark extends Fish implements ISwim {

    /**
     * Le nombre total de requins présents dans le zoo.
     */
    static int nbShark;

    /**
     * Le constructeur de la classe Shark.
     * Il permet de créer de nouvelles instances de cette classe.
     *
     * @param name
     *          Le nom du requin.
     * @param sex
     *          Le sexe du requin.
     * @param weight
     *          Le poids du requin.
     * @param height
     *          La taille du requin.
     * @param age
     *          L'âge du requin.
     */
    public Shark(String name, boolean sex, long weight, int height, int age) {
        super(name, sex, weight, height, age);
        timeUnborn = Tools.random(6000, 6301);// 1000 ms égale 1 jour en vrai
        typeAnimal = "nageant";
        beAlive();
    } //Constructor

    /**
     * Modifie le nombre de requin.
     *
     * @param nbShark
     *          Le nouveau nombre de requin.
     */
    public static void setNbShark(int nbShark) {
        Shark.nbShark = nbShark;
    } // setNbShark()

    /**
     * Retourne le nombre de requins présents dans le zoo.
     *
     * @return Le nombre de requins.
     */
    public static int getNbShark() {
        return nbShark;
    } // getNbShark()

    /**
     * Retourne une string représentant "textuellement" les caractéristiques du requin.
     *
     * @return Une string.
     */
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
        tostring += "\n\tindicateur de santé = " + getHealthIndicator() + "/100\n\n";

        return tostring;
    } // toString()

    /**
     * "Simule" le bruit que fait le requin.
     */
    @Override
    public void makeSound() {
        System.out.println("\nHurlement de requin.");
    } // makeSound()

    /**
     * "Simule" le déplacement que fait le requin.
     */
    @Override
    public void move() {
        System.out.println("\nLa requin se déplace.");
    } // move()

    /**
     * "Simule" la façon de nager du requin.
     */
    @Override
    public void swim() {
        System.out.println("\nLe requin nage.");
    } // swim()

    /**
     * Thread simulant la "vie" du requin.
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
     * Donne la possibilité à un requin de se reproduire avec un autre.
     * Cela a autant de chance de fonctionner ou non.
     * Si la reproduction a réussi, une période de gestation est nécessaire.
     *
     * @param shark
     *          Le requin avec lequel se reproduire.
     * @see Shark#unborn(Shark, int)
     */
    public void reproduction(Shark shark){
        if ((this.isSex() != shark.isSex())){
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
    } // reproduction()

    /**
     * Simule le temps de gestation d'un requin.
     * Un message est affiché lorsque 80% du processus est effectué.
     *
     * @param shark
     *          Le requin en période de gestation.
     * @param nbChild
     *          Le nombre de futurs enfants.
     * @see Shark#giveBirth(Shark)
     */
    private void unborn(final Shark shark, final int nbChild){
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
    }//unborn()

    /**
     * Permet de donner naissance à un nouveau requin.
     *
     * @param shark
     *          Le nouveau requin à créer.
     */
    private synchronized void giveBirth(Shark shark){
        nbShark += 1;
        Shark s = new Shark("shark"+nbShark, (Tools.random(0,2) != 0), Tools.random(100,200), Tools.random(7, 14), 0);
        System.out.println("L'oeuf vient d'éclore et donne naissance à " + s.getName());
        s.setPaddock(this.getPaddock());
        this.getPaddock().add(s);
    }//giveBirth()
} // class Shark
