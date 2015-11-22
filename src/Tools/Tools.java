package Tools;

import Paddock.Paddock;
import java.util.*;

import Species.Animal;
import Zoo.Zoo;

/**
 *  Tools est la classe outil de l'ensemble de l'application.
 *  Elle contient des méthodes utiles au développement, l'optimisation et l'affichage de la classe Zoo.
 *
 *  @author Charles-Henri CARLIER et Kenny COADALEN
 */
public class Tools {

    public static Map<String, Paddock> map1 = new WeakHashMap<>();

    private static final Map<String, String> map2 = new HashMap<String, String>() {{
        put("Bear","Ours");
        put("Eagle","Aigle");
        put("Razorbill","Pingouin");
        put("RedFish","Poisson rouge");
        put("Shark","Requin");
        put("Tiger","Tigre");
        put("Whale","Baleine");
        put("Wolf","Loup");
    }};

    public static Map<String, Animal> map3 = new WeakHashMap<>();

    private static String colorReset = "\033[0m";

    /**
     *
     *
     * @param min
     *
     * @param max
     *
     *
     * @return
     */
    public static synchronized int random(int min, int max) {
        Random r = new Random();
        return (min + r.nextInt(max - min));
    } // random()

    /**
     *
     *
     * @param str
     *
     *
     * @return
     */
    public static synchronized Paddock hashPaddock(String str){
        return map1.get(str);
    } // hashPaddock()

    /**
     *
     *
     * @param str
     *
     *
     * @return
     */
    public static Animal hashAnimal(String str){
        return map3.get(str);
    }

    /**
     *
     *
     * @param str
     *
     *
     * @return
     */
    public static String hashTypeAnimal(String str){
        return map2.get(str);
    } // hashTypeAnimal()

    /**
     *
     *
     * @param choice
     *
     *
     * @return
     */
    public static boolean askPaddockFill(boolean choice) {

        Scanner scannerChoicePaddockFill = new Scanner(System.in);
        System.out.println("Voulez-vous ajouter un animal ? o/n");
        String choicePaddockFill = scannerChoicePaddockFill.next();
        choicePaddockFill = choicePaddockFill.toLowerCase();
        switch (choicePaddockFill) {
            case "o":case "y":case "oui":case "yes":
                choice = true;
                break;
            case "n":case "non":case "no":
                choice = false;
                break;
            default:
                notProposedOption();
                System.out.println();
                choice = Tools.askPaddockFill(choice);
                break;
        }
        scannerChoicePaddockFill.nextLine();
        return choice;
    }

    /**
     *
     */
    public static void askAgain() {
        System.out.println(strColorRed("\nÊtes-vous certain de vouloir quitter le zoo ? (o/n)"));

        Scanner scannerChoiceAgain = new Scanner(System.in);
        String choiceAgain = scannerChoiceAgain.next();
        choiceAgain = choiceAgain.toLowerCase();
        switch (choiceAgain) {
            case "o": case "y": case "oui": case "yes":
                exitZoo();
                break;
            case "n": case "non": case "no":
                break;
            default:
                notProposedOption();
                break;
        } // switch
    } // askAgain()

    /**
     *
     */
    public static void exitZoo() {
        System.out.println(strColorBlue("\nLe zoo " + Zoo.getINSTANCE().getName() + " ferme ses portes. À demain ! :)"));
        System.exit(0);
    } // exitZoo()

    /**
     *
     */
    public static void notProposedOption() {
        System.out.println(strColorRed("\nCette option n'est pas proposée..."));
    } // notProposedOption()

    /**
     *
     *
     * @param str
     *
     *
     * @return
     */
    public static String strColorBlue(String str) {
        String blue = "\033[34m";
        return blue + str + colorReset;
    } // strColorBlue()

    /**
     *
     *
     * @param str
     *
     *
     * @return
     */
    public static String strColorRed(String str) {
        String red = "\033[31m";
        return red + str + colorReset;
    } // strColorBlue()

    /**
     *
     */
    public static void notPossibilityAddPaddock() {
        System.out.println(strColorRed("Le nombre maximum de paddock qui est de " + Zoo.getINSTANCE().getMaxNbPaddock() + " a été atteint."));
    } // notPossibilityAddPaddock()

} // class Tools