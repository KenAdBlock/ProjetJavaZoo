package Tools;

import Paddock.Paddock;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.WeakHashMap;

/**
 * Created by Darkweizer on 18/10/2015.
 */
public class Tools {
    public static Map<String, Paddock> map1 = new WeakHashMap<>();
    private static final Map<String, String> map2 = new HashMap<String, String>(){{
        put("Bear","Ours");
        put("Eagle","Aigle");
        put("Razorbill","Pingouin");
        put("RedFish","Poisson rouge");
        put("Shark","Requin");
        put("Tiger","Tigre");
        put("Whale","Balaine");
        put("Wolf","Loup");
    }};

    public static int Random(int min, int max){

        Random r = new Random();
        return (min + r.nextInt(max - min));
    }

    public static Paddock hashPaddock(String str){
        return map1.get(str);
    }

    public static String hashTypeAnimal(String str){
        return map2.get(str);
    }
}
