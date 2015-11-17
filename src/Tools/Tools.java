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

    public static int random(int min, int max) {
        Random r = new Random();
        return (min + r.nextInt(max - min));
    } // random()

    public static Paddock hashPaddock(String str){
        return map1.get(str);
    }

    public static String hashTypeAnimal(String str){
        return map2.get(str);
    }

    public static void askAgain() {
        System.out.print("\nVoulez-vous faire une autre action avant de quitter le zoo ? (o/n)\n");

        Scanner scannerChoiceAgain = new Scanner(System.in);
        String choiceAgain = scannerChoiceAgain.next();
        choiceAgain = choiceAgain.toLowerCase();
        switch (choiceAgain) {
            case "o": case "y": case "oui": case "yes":
                break;
            case "n": case "non": case "no":
                System.out.println("Le zoo ferme ses portes. À demain ! :)");
                System.exit(0);
                break;
            default:
                System.out.println("Cette option n'est pas proposée...");
                break;
        } // switch
    } // askAgain()

} // class Tools