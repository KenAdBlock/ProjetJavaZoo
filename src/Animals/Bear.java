package Animals;

import Species.Mammal;
import Tools.Tools;

/**
 *  Bear est la classe représentant un ours.
 *  Elle hérite de la classe abstraite Mammal car sémantiquement un ours est un mammifère.
 *
 *  @author Charles-Henri CARLIER et Kenny COADALEN
 *  @see Species.Mammal
 */
public class Bear extends Mammal {
    /**
     * Le nombre d'ours présents dans l'application.
     */
    static int nbBear;

    /**
     * Le constructeur de la classe Bear.
     * Il permet de créer de nouvelles instances de cette classe.
     *
     * @param name
     *          Le nom de l'ours.
     * @param sex
     *          Le sexe de l'ours.
     * @param weight
     *          Le poids de l'ours.
     * @param height
     *          La taille de l'ours.
     * @param age
     *          L'âge de l'ours.
     */
    public Bear(String name, boolean sex, long weight, int height, int age) {
        super(name, sex, weight, height, age);
        timeUnborn = Tools.random(6000, 6301); // 1000 ms égale 1 jour en vrai
        typeAnimal = "autre";
        beAlive();
    } // Constructor

    /**
     * Modifie le nombre d'ours.
     *
     * @param nbBear
     *          Le nouveau nombre d'ours.
     */
    public static void setNbBear(int nbBear) {
        Bear.nbBear = nbBear;
    } // setNbBear()

    /**
     * Retourne le nombre d'ours présents dans l'application.
     *
     * @return Le nombre d'ours.
     */
    public static int getNbBear() {
        return nbBear;
    } // getNbBear()

    /**
     * Retourne une string représentant "textuellement" les caractéristiques de l'objet.
     *
     * @return Une string.
     */
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

    /**
     * "Simule" le bruit que fait l'ours.
     */
    @Override
    public void makeSound() {
        System.out.println("\nGrognement de l'ours.");
    } // makeSound()

    /**
     * "Simule" le déplacement que fait l'ours.
     */
    @Override
    public void move() {
        System.out.println("\nL'ours se déplace...");
    } // move()

    /**
     * Thread simulant la "vie" de l'ours.
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
     * Donne la possibilité à un ours de se reproduire avec un autre.
     * Cela a autant de chance de fonctionner ou non.
     * Si la reproduction a réussi, une période de gestation est nécessaire.
     *
     * @param bear
     *          L'ours avec lequel se reproduire.
     * @see Bear#unborn(Bear, int)
     */
    public void reproduction(Bear bear){
        if ((this.isSex() != bear.isSex())){
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

    /**
     * Simule le temps de gestation d'un ours.
     * Un message est affiché lorsque 80% du processus est effectué.
     *
     * @param bear
     *          L'ours en période de gestation.
     * @param nbChild
     *          Le nombre de futurs enfants.
     * @see Bear#giveBirth(Bear)
     */
    private void unborn(final Bear bear, final int nbChild){
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
    }//unborn()

    /**
     * Permet de donner naissance à un nouvel ours.
     *
     * @param bear
     *          Le nouvel ours à créer.
     */
    private synchronized void giveBirth(Bear bear){
        nbBear += 1;
        Bear b = new Bear("bear"+nbBear, (Tools.random(0,2) != 0), Tools.random(100,200), Tools.random(7, 14), 0);
        System.out.println(bear.getName() + "(femelle) vient de donner naissance à " + "bear" + nbBear);
        b.setPaddock(this.getPaddock());
        this.getPaddock().add(b);
    }//giveBirth()
} // class Bear
