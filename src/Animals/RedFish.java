package Animals;

import Movement.ISwim;
import Species.Fish;
import Tools.Tools;

/**
 *  RedFish est la classe représentant un poisson rouge.
 *  Elle hérite de la classe abstraite Fish car sémantiquement un poisson rouge est un poisson.
 *
 *  @author Charles-Henri CARLIER et Kenny COADALEN
 *  @see Species.Fish
 */
public class RedFish extends Fish implements ISwim {
    /**
     * Le nombre de poissons rouges présents dans l'application.
     */
    static int nbRedFish;

    /**
     * Le constructeur de la classe RedFish.
     * Il permet de créer de nouvelles instances de cette classe.
     *
     * @param name
     *          Le nom du poisson rouge.
     * @param sex
     *          Le sexe du poisson rouge.
     * @param weight
     *          Le poids du poisson rouge.
     * @param height
     *          La taille du poisson rouge.
     * @param age
     *          L'âge du poisson rouge.
     */
    public RedFish(String name, boolean sex, long weight, int height, int age) {
        super(name, sex, weight, height, age);
        timeUnborn = Tools.random(6000, 6301);// 1000 ms égale 1 jour en vrai
        typeAnimal = "nageant";
        beAlive();
    } //Constructor

    /**
     * Modifie le nombre de poisson rouge.
     *
     * @param nbRedFish
     *          Le nouveau nombre de poisson rouge.
     */
    public static void setNbRedFish(int nbRedFish) {
        RedFish.nbRedFish = nbRedFish;
    } // setNbRedfish()

    /**
     * Retourne le nombre de poissons rouges présents dans l'application.
     *
     * @return Le nombre de poissons rouges.
     */
    public static int getNbRedfish() {
        return nbRedFish;
    } // getNbRedfish()

    /**
     * Retourne une string représentant "textuellement" les caractéristiques de l'objet.
     *
     * @return Une string.
     */
    @Override
    public String toString() {
        String tostring = "Poisson rouge : " +
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
     * "Simule" le bruit que fait le poisson rouge.
     */
    @Override
    public void makeSound() {
        System.out.println("\n'Bloubloutement' du poisson rouge.");
    } // makeSound()

    /**
     * "Simule" le déplacement que fait le poisson rouge.
     */
    @Override
    public void move() {
        System.out.println("\nLe poisson rouge se déplace.");
    } // move()

    /**
     * "Simule" la façon de nager du poisson rouge.
     */
    @Override
    public void swim() {
        System.out.println("\nLe poisson rouge nage.");
    } // swim()

    /**
     * Thread simulant la "vie" du poisson rouge.
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
     * Donne la possibilité à un poisson rouge de se reproduire avec un autre.
     * Cela a autant de chance de fonctionner ou non.
     * Si la reproduction a réussi, une période de gestation est nécessaire.
     *
     * @param redFish
     *          Le poisson rouge avec lequel se reproduire.
     * @see RedFish#unborn(RedFish, int)
     */
    public void reproduction(RedFish redFish){
        if ((this.isSex() != redFish.isSex())){
            int random = Tools.random(0, 2);
            int randomNbChild = Tools.random(4, 8);

            RedFish r ;
            if(this.isSex())
                r = redFish;
            else
                r = this;
            if(random < 1){
                unborn(r,randomNbChild);
            }
            else
                System.out.println("\nLa reproduction n'a donné aucun bébé");
        }
        else
            System.out.println("\nCe sont des poisson rouges du même sexe ! Petit coquin");
    } // reproduction()

    /**
     * Simule le temps de gestation d'un poisson rouge.
     * Un message est affiché lorsque 80% du processus est effectué.
     *
     * @param redFish
     *          Le poisson rouge en période de gestation.
     * @param nbChild
     *          Le nombre de futurs enfants.
     * @see RedFish#giveBirth(RedFish)
     */
    private void unborn(final RedFish redFish, final int nbChild){
        new Thread( new Thread(){
            @Override
            public void run() {
                try {
                    System.out.println(redFish.getName()
                            + "(femelle) vient de pondre  "
                            + nbChild*10
                            + " oeufs...");
                    sleep(timeUnborn - (timeUnborn / 100 * 20));
                    System.out.println("Les oeufs vont bientôt éclore");
                    sleep(timeUnborn - (timeUnborn / 100 * 80));
                    System.out.println("Seulement " + nbChild + " oeufs sont arrivés à terme");
                    for (int i = 0; i < nbChild; ++i){
                        giveBirth(redFish);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }//unborn()

    /**
     * Permet de donner naissance à un nouveau poisson rouge.
     *
     * @param redFish
     *          Le nouveau poisson rouge à créer.
     */
    private synchronized void giveBirth(RedFish redFish){
        nbRedFish += 1;
        RedFish s = new RedFish("redfish"+nbRedFish, (Tools.random(0,2) != 0), Tools.random(100,200), Tools.random(7, 14), 0);
        System.out.println("L'oeuf vient d'éclore et donne naissance à " + s.getName());
        s.setPaddock(this.getPaddock());
        this.getPaddock().add(s);
    }//giveBirth()
} // class RedFish
