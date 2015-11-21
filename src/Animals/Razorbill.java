package Animals;

import Movement.IFly;
import Movement.ISwim;
import Species.Bird;
import Tools.Tools;

/**
 *  Razorbill est la classe représentant un pingouin.
 *  Elle hérite de la classe abstraite Bird car sémantiquement un pingouin est un oiseau.
 *
 *  @author Charles-Henri CARLIER et Kenny COADALEN
 *  @see Species.Bird
 */
public class Razorbill extends Bird implements ISwim, IFly {

    /**
     * Le nombre de pingouins présents dans l'application.
     */
    static int nbRazorbill;

    /**
     * Le constructeur de la classe Razorbill.
     * Il permet de créer de nouvelles instances de cette classe.
     *
     * @param name
     *          Le nom du pingouin.
     * @param sex
     *          Le sexe du pingouin.
     * @param weight
     *          Le poids du pingouin.
     * @param height
     *          La taille du pingouin.
     * @param age
     *          L'âge du pingouin.
     */
    public Razorbill(String name, boolean sex, long weight, int height, int age) {
        super(name, sex, weight, height, age);
        timeUnborn = Tools.random(6000, 6301);// 1000 ms égale 1 jour en vrai
        typeAnimal = "nageant";
        beAlive();
    } //Constructor

    /**
     * Modifie le nombre de pingouin.
     *
     * @param nbRazorbill
     *          Le nouveau nombre de pingouin.
     */
    public static void setNbRazorbill(int nbRazorbill) {
        Razorbill.nbRazorbill = nbRazorbill;
    } // setNbRazorbill()

    /**
     * Retourne le nombre de pingouins présents dans l'application.
     *
     * @return Le nombre de pingouins.
     */
    public static int getNbRazorbill() {
        return nbRazorbill;
    } // getNbRazorbill()

    /**
     * Retourne une string représentant "textuellement" les caractéristiques de l'objet.
     *
     * @return Une string.
     */
    @Override
    public String toString() {
        String tostring = "Petit pingouin : " +
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
     * "Simule" le bruit que fait le pingouin.
     */
    @Override
    public void makeSound() {
        System.out.println("\nJabotement du petit pingouin.");
    } // makeSound()

    /**
     * "Simule" le déplacement que fait le pingouin.
     */
    @Override
    public void move() {
        System.out.println("\nLe petit pingouin se déplace.");
    } // move()

    /**
     * "Simule" la façon de voler du pingouin.
     */
    @Override
    public void fly() {
        System.out.println("\nLe petit pingouin vole.");
    } // fly()

    /**
     * "Simule" la façon de nager du pingouin.
     */
    @Override
    public void swim() {
        System.out.println("\nLe petit pingouin nage.");
    } // swim()

    /**
     * Thread simulant la "vie" du pingouin.
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
     * Donne la possibilité à un pingouin de se reproduire avec un autre.
     * Cela a autant de chance de fonctionner ou non.
     * Si la reproduction a réussi, une période de gestation est nécessaire.
     *
     * @param razorbill
     *          Le pingouin avec lequel se reproduire.
     * @see Razorbill#unborn(Razorbill, int)
     */
    public void reproduction(Razorbill razorbill){
        if ((this.isSex() != razorbill.isSex())){
            int random = Tools.random(0, 2);
            int randomNbChild = Tools.random(4, 8);

            Razorbill r ;
            if(this.isSex())
                r = razorbill;
            else
                r = this;
            if(random < 1){
                unborn(r,randomNbChild);
            }
            else
                System.out.println("\nLa reproduction n'a donné aucun bébé");
        }
        else
            System.out.println("\nCe sont des petit pingouins du même sexe ! Petit coquin");
    } // reproduction()

    /**
     * Simule le temps de gestation d'un pingouin.
     * Un message est affiché lorsque 80% du processus est effectué.
     *
     * @param razorbill
     *          Le pingouin en période de gestation.
     * @param nbChild
     *          Le nombre de futurs enfants.
     * @see Razorbill#giveBirth(Razorbill)
     */
    private void unborn(final Razorbill razorbill, final int nbChild){
        new Thread( new Thread(){
            @Override
            public void run() {
                try {
                    sleep(timeUnborn - (timeUnborn / 100 * 20));
                    System.out.println(razorbill.getName()
                            + "(femelle) va bientôt mettre bas de "
                            + nbChild
                            + " petits...");
                    sleep(timeUnborn - (timeUnborn / 100 * 80));
                    for (int i = 0; i < nbChild; ++i){
                        giveBirth(razorbill);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }//unborn()

    /**
     * Permet de donner naissance à un nouveau pingouin.
     *
     * @param razorbill
     *          Le nouveau pingouin à créer.
     */
    private synchronized void giveBirth(Razorbill razorbill){
        nbRazorbill += 1;
        Razorbill r = new Razorbill("razorbill"+nbRazorbill, (Tools.random(0,2) != 0), Tools.random(100,200), Tools.random(7, 14), 0);
        System.out.println("L'oeuf vient d'éclore et donne naissance à " + r.getName());
        r.setPaddock(this.getPaddock());
        this.getPaddock().add(r);
    }//giveBirth()
} // class Razorbill
