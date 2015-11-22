package Animals;

import Movement.IWander;
import Species.Mammal;
import Tools.Tools;

/**
 *  Wolf est la classe représentant un loup.
 *  Elle hérite de la classe abstraite Mammal car sémantiquement un loup est un mammifère.
 *
 *  @author Charles-Henri CARLIER et Kenny COADALEN
 *  @see Species.Mammal
 */
public class Wolf extends Mammal implements IWander {

    /**
     * Le nombre de loups présents dans l'application.
     */
    static int nbWolf;

    /**
     * Le constructeur de la classe Wolf.
     * Il permet de créer de nouvelles instances de cette classe.
     *
     * @param name
     *          Le nom du loup.
     * @param sex
     *          Le sexe du loup.
     * @param weight
     *          Le poids du loup.
     * @param height
     *          La taille du loup.
     * @param age
     *          L'âge du loup.
     */
    public Wolf(String name, boolean sex, long weight, int height, int age) {
        super(name, sex, weight, height, age);
        timeUnborn = Tools.random(6000, 6301);// 1000 ms égale 1 jour en vrai
        typeAnimal = "autre";
        beAlive();
    } //Constructor

    /**
     * Modifie le nombre de loup.
     *
     * @param nbWolf
     *          Le nouveau nombre de loup.
     */
    public static void setNbWolf(int nbWolf) {
        Wolf.nbWolf = nbWolf;
    } // setNbWolf()

    /**
     * Retourne le nombre de loups présents dans l'application.
     *
     * @return Le nombre de loups.
     */
    public static int getNbWolf() {
        return nbWolf;
    } // getNbWolf()

    /**
     * Retourne une string représentant "textuellement" les caractéristiques de l'objet.
     *
     * @return Une string.
     */
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
        tostring += "\n\tindicateur de santé = " + getHealthIndicator() + "/100\n\n";

        return tostring;
    } // toString()

    /**
     * "Simule" le bruit que fait le loup.
     */
    @Override
    public void makeSound() {
        System.out.println("\nHurlement du loup.");
    } // makeSound()

    /**
     * "Simule" le déplacement que fait le loup.
     */
    @Override
    public void move() {
        System.out.println("\nLe loup vagabonde.");
    } // move()

    /**
     * "Simule" la façon de vagabonder du loup.
     */
    @Override
    public void wander() {
        System.out.println("Je fais des bonds, encore des bonds, tout plein de bonds !");
    } // wander()

    /**
     * Thread simulant la "vie" du loup.
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
     * Donne la possibilité à un loup de se reproduire avec un autre.
     * Cela a autant de chance de fonctionner ou non.
     * Si la reproduction a réussi, une période de gestation est nécessaire.
     *
     * @param wolf
     *          Le loup avec lequel se reproduire.
     * @see Wolf#unborn(Wolf, int)
     */
    public void reproduction(Wolf wolf){
        if ((this.isSex() != wolf.isSex())){
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

    /**
     * Simule le temps de gestation d'un loup.
     * Un message est affiché lorsque 80% du processus est effectué.
     *
     * @param wolf
     *          Le loup en période de gestation.
     * @param nbChild
     *          Le nombre de futurs enfants.
     * @see Wolf#giveBirth(Wolf)
     */
    private void unborn(final Wolf wolf, final int nbChild){
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
    }//unborn()

    /**
     * Permet de donner naissance à un nouveau loup.
     *
     * @param wolf
     *          Le nouveau loup à créer.
     */
    private synchronized void giveBirth(Wolf wolf){
        nbWolf += 1;
        Wolf w = new Wolf("wolf"+nbWolf, (Tools.random(0,2) != 0), Tools.random(100,200), Tools.random(7, 14), 0);
        System.out.println(wolf.getName() + "(femelle) vient de donner naissance à " + w.getName());
        w.setPaddock(this.getPaddock());
        this.getPaddock().add(w);
    }//giveBirth()
} // class Wolf
