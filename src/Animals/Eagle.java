package Animals;

import Movement.IFly;
import Species.Bird;
import Tools.Tools;

/**
 *  Eagle est la classe représentant un aigle.
 *  Elle hérite de la classe abstraite Bird car sémantiquement un aigle est un oiseau.
 *
 *  @author Charles-Henri CARLIER et Kenny COADALEN
 *  @see Species.Bird
 */
public class Eagle extends Bird implements IFly {

    /**
     * Le nombre total d'aigles présents dans le zoo.
     */
    static int nbEagle;

    /**
     * Le constructeur de la classe Eagle.
     * Il permet de créer de nouvelles instances de cette classe.
     *
     * @param name
     *          Le nom de l'aigle.
     * @param sex
     *          Le sexe de l'aigle.
     * @param weight
     *          Le poids de l'aigle.
     * @param height
     *          La taille de l'aigle.
     * @param age
     *          L'âge de l'aigle.
     */
    public Eagle(String name, boolean sex, long weight, int height, int age) {
        super(name, sex, weight, height, age);
        timeUnborn = Tools.random(6000, 6301);// 1000 ms égale 1 jour en vrai
        typeAnimal = "volant";
        beAlive();
    } //Constructor

    /**
     * Modifie le nombre d'aigle.
     *
     * @param nbEagle
     *          Le nouveau nombre d'aigle.
     */
    public static void setNbEagle(int nbEagle) {
        Eagle.nbEagle = nbEagle;
    }

    /**
     * Retourne le nombre d'aigles présents dans le zoo.
     *
     * @return Le nombre d'aigles.
     */
    public static int getNbEagle() {
        return nbEagle;
    }

    /**
     * Retourne une string représentant "textuellement" les caractéristiques de l'aigle.
     *
     * @return Une string.
     */
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
        tostring += "\n\tindicateur de santé = " + getHealthIndicator() + "/100\n\n";

        return tostring;
    } // toString()

    /**
     * "Simule" le bruit que fait l'aigle.
     */
    @Override
    public void makeSound() {
        System.out.println("\nHurlement de l'aigle.");
    } // makeSound()

    /**
     * "Simule" le déplacement que fait l'aigle.
     */
    @Override
    public void move() {
        System.out.println("\nL'aigle marche.");
    } // move()

    /**
     * "Simule" la façon de voler de l'aigle.
     */
    @Override
    public void fly() {
        System.out.println("\nL'aigle vole...");
    } // fly()

    /**
     * Thread simulant la "vie" de l'aigle.
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
     * Donne la possibilité à un aigle de se reproduire avec un autre.
     * Cela a autant de chance de fonctionner ou non.
     * Si la reproduction a réussi, une période de gestation est nécessaire.
     *
     * @param eagle
     *          L'aigle avec lequel se reproduire.
     * @see Eagle#unborn(Eagle, int)
     */
    public void reproduction(Eagle eagle){
        if ((this.isSex() != eagle.isSex())){
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

    /**
     * Simule le temps de gestation d'un aigle.
     * Un message est affiché lorsque 80% du processus est effectué.
     *
     * @param eagle
     *          L'aigle en période de gestation.
     * @param nbChild
     *          Le nombre de futurs enfants.
     * @see Eagle#giveBirth(Eagle)
     */
    private void unborn(final Eagle eagle, final int nbChild){
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
    }//unborn()

    /**
     * Permet de donner naissance à un nouvel aigle.
     *
     * @param eagle
     *          Le nouvel aigle à créer.
     */
    private synchronized void giveBirth(Eagle eagle){
        Eagle e = new Eagle("eagle"+nbEagle, (Tools.random(0,2) != 0), Tools.random(100,200), Tools.random(7, 14), 0);
        System.out.println("L'oeuf vient d'éclore et donne naissance à " + e.getName());
        e.setPaddock(this.getPaddock());
        this.getPaddock().add(e);
    }//giveBirth()
} // class Eagle
