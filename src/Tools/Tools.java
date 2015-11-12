package Tools;

import java.util.Random;

/**
 * Created by Darkweizer on 18/10/2015.
 */
public class Tools {

    public static int Random(int min, int max){

        Random r = new Random();
        return (min + r.nextInt(max - min));
    }
}
