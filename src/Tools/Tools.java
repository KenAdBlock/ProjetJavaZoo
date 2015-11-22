package Tools;

import Animals.*;
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

    /**
     * Stock tous les Paddock avec pour clé leur nom.
     */
    public static Map<String, Paddock> mapPaddock = new WeakHashMap<>();

    /**
     * Stock tous les Animal avec pour clé leur nom.
     */
    public static Map<String, Animal> mapAnimal = new WeakHashMap<>();

    /**
     * Stock tous les Wolf avec pour clé leur nom.
     */
    public static Map<String, Wolf> mapWolf = new WeakHashMap<>();

    /**
     * Stock tous les Bear avec pour clé leur nom.
     */
    public static Map<String, Bear> mapBear = new WeakHashMap<>();

    /**
     * Stock tous les Tiger avec pour clé leur nom.
     */
    public static Map<String, Tiger> mapTiger = new WeakHashMap<>();

    /**
     * Stock tous les Whale avec pour clé leur nom.
     */
    public static Map<String, Whale> mapWhale = new WeakHashMap<>();

    /**
     * Stock tous les Razorbill avec pour clé leur nom.
     */
    public static Map<String, Razorbill> mapRazorbill = new WeakHashMap<>();

    /**
     * Stock tous les RedFish avec pour clé leur nom.
     */
    public static Map<String, RedFish> mapRedFish= new WeakHashMap<>();

    /**
     * Stock tous les Shark avec pour clé leur nom.
     */
    public static Map<String, Shark> mapShark = new WeakHashMap<>();

    /**
     * Stock tous les Eagle avec pour clé leur nom.
     */
    public static Map<String, Eagle> mapEagle = new WeakHashMap<>();

    /**
     * Stock tous les nom des animaux en français avec pour clé leur nom en anglais.
     */
    private static final Map<String, String> mapTypeAnimal = new HashMap<String, String>() {{
        put("Bear","Ours");
        put("Eagle","Aigle");
        put("Razorbill","Pingouin");
        put("RedFish","Poisson rouge");
        put("Shark","Requin");
        put("Tiger","Tigre");
        put("Whale","Baleine");
        put("Wolf","Loup");
    }};

    private static String colorReset = "\033[0m";

    public static synchronized int random(int min, int max) {
        Random r = new Random();
        return (min + r.nextInt(max - min));
    } // random()

    /**
     * Retourne la classe Paddock correspondante à la string passait en paramètre
     *
     * @param str
     *          Le nom du paddock.
     *
     * @return La classe Paddock correspondante à la string passait en paramètre.
     */
    public static synchronized Paddock hashPaddock(String str){
        return mapPaddock.get(str);
    } // hashPaddock()

    /**
     * Retourne la classe Animal correspondante à la string passait en paramètre
     *
     * @param str
     *          Le nom de l'animal.
     *
     * @return La classe Animal correspondante à la string passait en paramètre.
     */
    public static Animal hashAnimal(String str){
        return mapAnimal.get(str);
    }

    /**
     * Retourne la classe Wolf correspondante à la string passait en paramètre
     *
     * @param str
     *          Le nom du loup.
     *
     * @return La classe Wolf correspondante à la string passait en paramètre.
     */
    public static Wolf hashWolf(String str){
        return mapWolf.get(str);
    }

    /**
     * Retourne la classe Bear correspondante à la string passait en paramètre
     *
     * @param str
     *          Le nom de l'ours.
     *
     * @return La classe Bear correspondante à la string passait en paramètre.
     */
    public static Bear hashBear(String str){
        return mapBear.get(str);
    }

    /**
     * Retourne la classe Tiger correspondante à la string passait en paramètre
     *
     * @param str
     *          Le nom du tigre.
     *
     * @return La classe Tiger correspondante à la string passait en paramètre.
     */
    public static Tiger hashTiger(String str){
        return mapTiger.get(str);
    }

    /**
     * Retourne la classe Whale correspondante à la string passait en paramètre
     *
     * @param str
     *          Le nom de la baleine.
     *
     * @return La classe Whale correspondante à la string passait en paramètre.
     */
    public static Whale hashWhale(String str){
        return mapWhale.get(str);
    }

    /**
     * Retourne la classe Razorbill correspondante à la string passait en paramètre
     *
     * @param str
     *          Le nom du pingouin.
     *
     * @return La classe Razorbille correspondante à la string passait en paramètre.
     */
    public static Razorbill hashRazorbill(String str){
        return mapRazorbill.get(str);
    }

    /**
     * Retourne la classe RedFish correspondante à la string passait en paramètre
     *
     * @param str
     *          Le nom du poisson rouge.
     *
     * @return La classe RedFish correspondante à la string passait en paramètre.
     */
    public static RedFish hashRedFish(String str){
        return mapRedFish.get(str);
    }

    /**
     * Retourne la classe Shark correspondante à la string passait en paramètre
     *
     * @param str
     *          Le nom du requin.
     *
     * @return La classe Shark correspondante à la string passait en paramètre.
     */
    public static Shark hashShark(String str){
        return mapShark.get(str);
    }

    /**
     * Retourne la classe Eagle correspondante à la string passait en paramètre
     *
     * @param str
     *          Le nom de l'aigle.
     *
     * @return La classe Eagle correspondante à la string passait en paramètre.
     */
    public static Eagle hashEagle(String str){
        return mapEagle.get(str);
    }

    /**
     *Retourne le nom en français de l'animal correspondante au nom en anglais de l'animal passait en paramètre.
     *
     * @param str
     *          Le nom en anglais de l'animal.
     *
     * @return Le nom en français de l'animal correspondante au nom en anglais de l'animal passait en paramètre.
     */
    public static String hashTypeAnimal(String str){
        return mapTypeAnimal.get(str);
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
        System.out.println(strColorRed("\nLe nombre maximum d'enclos qui est de " + Zoo.getINSTANCE().getMaxNbPaddock() + " dans le zoo a été atteint."));
    } // notPossibilityAddPaddock()

} // class Tools