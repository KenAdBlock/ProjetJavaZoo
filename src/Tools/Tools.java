package Tools;

import Paddock.Paddock;
import java.util.*;

/**
 * Created by Darkweizer on 18/10/2015.
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
        put("Whale","Balaine");
        put("Wolf","Loup");
    }};
    private static String white = "\033[0m";
    private static String red = "\033[31m";
    private static String blue = "\033[34m";
//    private static String magenta = "\033[35m";
//    private static String cyan = "\033[36m";

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

    public static void exitZoo() {
        System.out.println(strColorBlue("Le zoo ferme ses portes. À demain ! :)"));
        System.exit(0);
    } // exitZoo()

    public static void notProposedOption() {
        System.out.println(strColorRed("Cette option n'est pas proposée..."));
    } // notProposedOption()

    public static String strColorRed(String str) {
        return red + str + white;
    } // strColorRed()

    public static String strColorBlue(String str) {
        return blue + str + white;
    } // strColorBlue()

} // class Tools