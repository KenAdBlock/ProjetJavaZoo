package Tools;

import Paddock.Paddock;
import java.util.*;

/**
 * Created by Darkweizer on 18/10/2015.
 */
public class Tools {
    public static Map<String, Paddock> map1 = new WeakHashMap<>();

    private static String colorReset = "\033[0m";
    private static final Map<String, String> map2 = new HashMap<String, String>() {{
        put("Bear","Ours");
        put("Eagle","Aigle");
        put("Razorbill","Pingouin");
        put("RedFish","Poisson rouge");
        put("Shark","Requin");
        put("Tiger","Tigre");
        put("Whale","Balaine");
        put("Wolf","Loup");
    }};

    public static int random(int min, int max) {
        Random r = new Random();
        return (min + r.nextInt(max - min));
    } // random()

    public static Paddock hashPaddock(String str){
        return map1.get(str);
    } // hashPaddock()

    public static String hashTypeAnimal(String str){
        return map2.get(str);
    } // hashTypeAnimal()

    public static void askAgain() {
        System.out.println("\nVoulez-vous faire une autre action avant de quitter le zoo ? (o/n)");

        Scanner scannerChoiceAgain = new Scanner(System.in);
        String choiceAgain = scannerChoiceAgain.next();
        choiceAgain = choiceAgain.toLowerCase();
        switch (choiceAgain) {
            case "o": case "y": case "oui": case "yes":
                break;
            case "n": case "non": case "no":
                exitZoo();
                break;
            default:
                notProposedOption();
                break;
        } // switch
    } // askAgain()

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
        System.out.println();
        return choice;
    }

    public static void exitZoo() {
        System.out.println(strColorBlue("\nLe zoo ferme ses portes. À demain ! :)"));
        System.exit(0);
    } // exitZoo()

    public static void notProposedOption() {
        System.err.println("\nCette option n'est pas proposée...");
    } // notProposedOption()

    public static String strColorBlue(String str) {
        String blue = "\033[34m";
        return blue + str + colorReset;
    } // strColorBlue()

} // class Tools