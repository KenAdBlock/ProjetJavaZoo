package Species;

/**
 * Created by c12010902 on 16/10/2015.
 */
public abstract class Mammal extends Animal {

    protected long timeUnborn;
    protected Mammal(String name, boolean sex, int weight, int height, int age) {
        super(name, sex, weight, height, age);
    }


}
