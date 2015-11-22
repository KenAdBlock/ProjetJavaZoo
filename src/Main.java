import Tools.Tools;
import Zoo.Zoo;

/**
 *  Main est la classe principale de l'application.
 *  C'est elle qui va se charger de lancer la méthode run() de la classe Zoo.
 *
 *  @author Charles-Henri CARLIER et Kenny COADALEN
 */
public class Main {

    /**
     * Point d'entrée de l'application.
     *
     * @param args
     *          Arguments éventuels de la méthode main().
     */
    public static void main(String[] args) {
        System.out.println(Tools.strColorBlue("Le zoo " + Zoo.getINSTANCE().getName() +  " ouvre ses portes ! Bienvenue."));
        Zoo.getINSTANCE().run();
    } // main()
} // class Main